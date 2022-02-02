package Controller;

import Repository.FornecedorDAO;
import Repository.UsuarioDao;
import View.FornecedorHibernate;

import View.UsuarioHibernate;


public class DAOFactory {

	
	public static UsuarioDao criarUsuarioDAO() {
		UsuarioHibernate usuarioDAO = new UsuarioHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
		}
	public static FornecedorDAO criarFornecedorDAO() {
		FornecedorHibernate fornece = new FornecedorHibernate();
		fornece.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return fornece;
		}
	
	
	
}
