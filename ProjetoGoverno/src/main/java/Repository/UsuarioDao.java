package Repository;

import java.util.List;

import org.hibernate.Session;

import Model.Usuario;

public interface UsuarioDao {
	
	public void salvar(Usuario usuario);
	
	 public void atualizar(Usuario usuario);

	 public void excluir(Usuario usuario);

	 public Usuario carregar(Integer codigo);

	 public Usuario buscarPorLogin(String login);

	 public List<Usuario> listar();

	void setSession(Session usuario);
	
	public Usuario buscaPorPasswordToken(String token);

	
	

}
