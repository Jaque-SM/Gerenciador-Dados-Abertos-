package View;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Graficos.EstadoFornecedor;
import Model.Fornecedor;
import Model.Usuario;
import Repository.FornecedorDAO;

public class FornecedorHibernate implements FornecedorDAO{

private Session ses;
	
	@Override
	public void setSession(Session sesion) {
		this.ses = sesion;
	}
	
	@Override
	public void salvar(Fornecedor forne) {
		this.ses.saveOrUpdate(forne);
	}

	@Override
	public void excluir(Fornecedor forne) {
		this.ses.delete(forne);
	}
	@Override
	public Fornecedor carregar(Integer frn) {
		return (Fornecedor)this.ses.get(Fornecedor.class, frn) ;
	}
	
	@Override
	public List<Fornecedor> listar() {
		Criteria criteria = this.ses.createCriteria(Fornecedor.class);
		return criteria.list();

	}

	@Override
	public void atualizar(Fornecedor forne) {
		
	}

	@Override
	public Fornecedor buscarFavorita(Usuario usu) {
		return null;
	}

	@Override
	public List<String> listarid_cnae() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> habilitado_licitar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> listarFornecedorPorUF(String uf) {
		String hql = "select f from Fornecedor f where f.uf = :uf";//"select sum(g.valor) from gastos g where g.estado = :estado";
		Query consulta = this.ses.createQuery(hql);
		consulta.setString("uf", uf);
		return consulta.list();
	}
	
	public List<String> listarUf() {
		String hql = "select distinct uf from Fornecedor";//"select sum(g.valor) from gastos g where g.estado = :estado";
		Query consulta = this.ses.createQuery(hql);
		return consulta.list();
		}
	
	public List<String> listarIdJuridica() {
		String hql = "select distinct id_natureza_juridica from Fornecedor";//"select sum(g.valor) from gastos g where g.estado = :estado";
		Query consulta = this.ses.createQuery(hql);
		return consulta.list();
		}

	@Override
	public List<String> listarPorteEmpresa() {
		String hql = "select distinct id_porte_empresa from Fornecedor";//"select sum(g.valor) from gastos g where g.estado = :estado";
	       Query consulta = this.ses.createQuery(hql);
	       return consulta.list();
	}

	@Override
	public List<EstadoFornecedor> listarPopulosos() {
		String hql = "select uf , count(cnpj) as quant from Fornecedor group by uf order by quant";
	       Query consulta = this.ses.createQuery(hql);
	       return consulta.list();
		
	}


	
}
