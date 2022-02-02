package Repository;

import java.util.List;

import org.hibernate.Session;

import Graficos.EstadoFornecedor;
import Model.Fornecedor;
import Model.Usuario;


public interface FornecedorDAO {

	public void salvar(Fornecedor forne);
	
	 public void atualizar(Fornecedor forne);

	 public void excluir(Fornecedor forne);
	 
	 public Fornecedor carregar(Integer conta);

	 public List<Fornecedor> listar();
	 
	 public Fornecedor buscarFavorita(Usuario usu);
	 
	void setSession(Session sesion);

	 //listar por UF
	public List <Fornecedor> listarFornecedorPorUF(String uf);
	
	//listar estados
	 public List<String> listarUf();
	 
	 //listar IdJuridica
	 public List<String> listarIdJuridica();


	 //id_porte_empresa
	 public List<String> listarPorteEmpresa();
	 
	 //id_cnae
	 public List<String> listarid_cnae();
	 
	 //habilitado_licitar
	 public List<String> habilitado_licitar();

	public List<EstadoFornecedor> listarPopulosos();



	 
	 

}
