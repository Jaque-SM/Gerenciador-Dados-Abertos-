package XML;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Fornecedor;

public class FornecedorBD {

	public Fornecedor saveFornecedor(Fornecedor dao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(dao);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dao;
	}

	public Fornecedor deleteServico(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Fornecedor dae = (Fornecedor) session.get(Fornecedor.class, id);
			return dae;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
