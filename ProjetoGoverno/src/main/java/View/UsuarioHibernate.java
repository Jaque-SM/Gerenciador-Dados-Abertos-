package View;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Model.Usuario;
import Repository.UsuarioDao;


public class UsuarioHibernate implements UsuarioDao {

	private Session ses;
	
	@Override
	public void setSession(Session sesion) {
		this.ses = sesion;

	}
	@Override
	public void salvar(Usuario usuario) {
		this.ses.save(usuario);

	}

	@Override
	public void atualizar(Usuario usuario) {
		 if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
			 Usuario usuarioPermissao = this.carregar(usuario.getCodigo());
			 usuario.setPermissao(usuarioPermissao.getPermissao());
			 this.ses.evict(usuarioPermissao);
			 }
			 this.ses.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.ses.delete(usuario);

	}

	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) this.ses.get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.ses.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		return this.ses.createCriteria(Usuario.class).list(); 
	}
	@Override
	public Usuario buscaPorPasswordToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
