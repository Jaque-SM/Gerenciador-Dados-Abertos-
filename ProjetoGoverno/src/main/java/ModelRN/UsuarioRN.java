package ModelRN;

import java.util.List;

import Controller.DAOException;
import Controller.DAOFactory;
import Model.Usuario;
import Repository.UsuarioDao;


public class UsuarioRN {
	private UsuarioDao usuarioDAO;

		 public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
		}
		
		 public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
		}
		
		 public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
		}
		
		 public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
		usuario.getPermissao().add("ROLE_USUARIO");
		this.usuarioDAO.salvar(usuario);
		} else {
		this.usuarioDAO.atualizar(usuario);
		}
		}
		
		 public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
		}
		
		 public List<Usuario> listar() {
		return this.usuarioDAO.listar();
		}

			public void updatePasswordToken(String token, String email) throws DAOException {
				
				Usuario usuario = this.usuarioDAO.buscarPorLogin(email);
				
				if(usuario != null) {
					usuario.setToken(token);
					this.usuarioDAO.salvar(usuario);
				}else {
					throw new DAOException("Não foi encontrado nenhum usuário com este email " + email);
				}
				
			}
			
			public Usuario get(String token) {
				return this.usuarioDAO.buscaPorPasswordToken(token);
			}

	
		}