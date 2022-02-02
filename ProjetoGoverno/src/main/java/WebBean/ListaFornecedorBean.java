package WebBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Model.Fornecedor;
import ModelRN.FornecedorRN;

@ManagedBean(name = "listaFornecedorBean")
@RequestScoped // (padrão),
//@ViewScoped 
//@SessionScoped 
//@ApplicationScoped
//@NoneScoped 
public class ListaFornecedorBean {

	private List<Fornecedor> listaResultadoBusca;
	private List<Fornecedor> resultado;

	private String uf;
	private List<String> ufs;

	private String id_natureza_juridica;
	private List<String> id_natureza_juridicas;

	private String id_porte_empresa;
	private List<String> id_porte_empresas;

	private List<Fornecedor> gastosCidade = null;

	public String getId_porte_empresa() {
		return id_porte_empresa;
	}

	public void setId_porte_empresa(String id_porte_empresa) {
		this.id_porte_empresa = id_porte_empresa;
	}

	public List<String> getId_porte_empresas() {
		FornecedorRN g = new FornecedorRN();
		id_porte_empresas = g.listaEmpresa();
		return id_porte_empresas;
	}

	public void setId_porte_empresas(List<String> id_porte_empresas) {
		this.id_porte_empresas = id_porte_empresas;
	}

	public List<Fornecedor> getGastosCidade() {
		return gastosCidade;
	}

	public void setGastosCidade(List<Fornecedor> gastosCidade) {
		this.gastosCidade = gastosCidade;
	}

	public String getId_natureza_juridica() {
		return id_natureza_juridica;
	}

	public void setId_natureza_juridica(String id_natureza_juridica) {
		this.id_natureza_juridica = id_natureza_juridica;
	}

	public List<String> getId_natureza_juridicas() {
		FornecedorRN g = new FornecedorRN();
		id_natureza_juridicas = g.listarIdJuridica();
		return id_natureza_juridicas;
	}

	public void setId_natureza_juridicas(List<String> id_natureza_juridicas) {
		this.id_natureza_juridicas = id_natureza_juridicas;
	}

	public List<String> getUfs() {
		FornecedorRN g = new FornecedorRN();
		ufs = g.listarUf();
		return ufs;
	}

	public void setUfs(List<String> ufs) {
		this.ufs = ufs;
	}

	public List<Fornecedor> getListaResultadoBusca() {
		return listaResultadoBusca;
	}

	public void setListaResultadoBusca(List<Fornecedor> listaResultadoBusca) {
		this.listaResultadoBusca = listaResultadoBusca;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setResultado(List<Fornecedor> resultado) {
		this.resultado = resultado;
	}

	public List<Fornecedor> getResultado() {
		return resultado;
	}

	public List<Fornecedor> busca() {
		// FornecedorRN an=new FornecedorRN();
		// listaResultadoBusca=an.listarFornecedorPorUF(this.uf);

		// this.uf = this.uf.toLowerCase();
		System.out.print("UF: " + this.uf);
		System.out.print("Natureza: " + this.id_natureza_juridica);
		System.out.print("Porte: " + this.id_porte_empresa);

		this.listaResultadoBusca = this.listar();
		List<Fornecedor> aux = new ArrayList<Fornecedor>();

		// Se todos os filtros forem passados
		if (!this.uf.isEmpty() && !this.id_natureza_juridica.isEmpty() && !this.id_porte_empresa.isEmpty()) {
			for (Fornecedor g : listaResultadoBusca)
				if (g.getUf().equals(this.uf)
						&& g.getId_natureza_juridica().equals(this.id_natureza_juridica)
						&& g.getId_porte_empresa().equals(this.id_porte_empresa))
					aux.add(g);
			listaResultadoBusca = aux;
		}
		// Se o uf nao for passado
		if (this.uf.isEmpty() && !this.id_natureza_juridica.isEmpty() && !this.id_porte_empresa.isEmpty()) {
			for (Fornecedor g : listaResultadoBusca)
				if (g.getId_natureza_juridica().equals(this.id_natureza_juridica)
						&& g.getId_porte_empresa().equals(this.id_porte_empresa))
					aux.add(g);
			listaResultadoBusca = aux;
		}
		// Se o id_juridico nao for passado
		if (!uf.isEmpty() && this.id_porte_empresa.isEmpty() && !this.id_porte_empresa.isEmpty()) {
			for (Fornecedor g : listaResultadoBusca)
				if (g.getUf().equals(uf) && g.getId_porte_empresa().equals(this.id_porte_empresa))
					aux.add(g);
			listaResultadoBusca = aux;
		}
		// Se o id_empresarial nao for passado
		if (!uf.isEmpty() && !id_natureza_juridica.isEmpty() && this.id_porte_empresa.isEmpty()) {
			for (Fornecedor g : listaResultadoBusca)
				if (g.getUf().equals(this.uf) && g.getId_natureza_juridica().equals(this.id_natureza_juridica))
					aux.add(g);
			listaResultadoBusca = aux;
		}
		// Se o uf nao for passado e Se o id_juridico nao for passado
		if (uf.isEmpty() && id_natureza_juridica.isEmpty() && !this.id_porte_empresa.isEmpty()) {
			for (Fornecedor g : listaResultadoBusca)
				if (g.getId_porte_empresa().equals(this.id_porte_empresa))
					aux.add(g);
			listaResultadoBusca = aux;
		}
		// Se o uf nao for passado e Se o id_empresarial nao for passado
		if (uf.isEmpty() && !id_natureza_juridica.isEmpty() && this.id_porte_empresa.isEmpty()) {
			for (Fornecedor g : listaResultadoBusca)
				if (g.getId_natureza_juridica().equals(this.id_natureza_juridica))
					aux.add(g);
			listaResultadoBusca = aux;
		}
		// Se o id_juridico nao for passado e Se o id_empresarial nao for passado
		if (!uf.isEmpty() && id_natureza_juridica.isEmpty() && this.id_porte_empresa.isEmpty()) {
			for (Fornecedor g : listaResultadoBusca)
				if (g.getUf().equals(this.uf))
					aux.add(g);
			listaResultadoBusca = aux;
		}

		return listaResultadoBusca;
	}

	private List<Fornecedor> listar() {
		FornecedorRN am = new FornecedorRN();
		this.listaResultadoBusca = am.listar();

		return am.listar();
	}

}
