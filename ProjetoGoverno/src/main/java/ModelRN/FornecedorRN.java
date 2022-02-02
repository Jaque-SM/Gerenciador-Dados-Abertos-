package ModelRN;

import java.util.List;

import Controller.DAOFactory;
import Graficos.EstadoFornecedor;
import Model.Fornecedor;
import Model.Usuario;
import Repository.FornecedorDAO;

public class FornecedorRN {

	private FornecedorDAO forne;

	public FornecedorRN() {
		this.forne = DAOFactory.criarFornecedorDAO();
	}

	public Fornecedor carregar(Integer codigo) {
		return this.forne.carregar(codigo);
	}

	public void salvar(Fornecedor fn) {
		this.forne.salvar(fn);
	}

	public void excluir(Fornecedor fn) {
		this.forne.excluir(fn);
	}

	public List<Fornecedor> listar() {
		return this.forne.listar();
	}

	public List<Fornecedor> listarFornecedorPorUF(String uf) {
		return this.forne.listarFornecedorPorUF(uf);
	}

	public List<String> listarUf() {
		return this.forne.listarUf();
	}

	public Fornecedor buscarFavorita(Usuario usuario) {
		return this.forne.buscarFavorita(usuario);
	}

	// id_porte_empresa
	public List<String> listaEmpresa() {
		return this.forne.listarPorteEmpresa();
	}

	// id_natureza_juridica
	public List<String> listarIdJuridica() {
		return this.forne.listarIdJuridica();
	}

	public List<EstadoFornecedor> listarPopulosos() {
		return this.forne.listarPopulosos();
	}

}
