package WebBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.BarChartModel;

import Graficos.EstadoFornecedor;
import Model.Fornecedor;
import Model.Usuario;
import ModelRN.FornecedorRN;


@ManagedBean
@RequestScoped
public class FornecedorBean {
	
	private Fornecedor selecionada = new Fornecedor();
	private List<Fornecedor> lista = null;
	private String destinoSalvar;
	private List<EstadoFornecedor> estados;
	
	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;

	
	public String salvar() {
		this.destinoSalvar="fornecedorsalvo";
		FornecedorRN frn=new FornecedorRN();
		frn.salvar(selecionada);
		this.selecionada=new Fornecedor();
		this.lista=null;
		return null;
	}
	public String excluir() {
		FornecedorRN frn=new FornecedorRN();
		frn.excluir(this.selecionada);
		this.selecionada=new Fornecedor();
		this.lista=null;
		return null;
		
	}
	public int fornecedoresPorUf(String uf) {
	  return new FornecedorRN().listarFornecedorPorUF(uf).size();
	}
		
		
	public Fornecedor getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Fornecedor selecionada) {
		this.selecionada = selecionada;
	}

	public List<Fornecedor> getLista() {
		if (this.lista == null) {
			FornecedorRN conta = new FornecedorRN();
			this.lista = conta.listar();
		}
		return this.lista;

	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}
	
	
	

}
