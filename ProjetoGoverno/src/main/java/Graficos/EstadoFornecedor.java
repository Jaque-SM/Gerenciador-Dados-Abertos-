package Graficos;

public class EstadoFornecedor {
	
	private String uflocal;
	private int fornecedores;
		
	public EstadoFornecedor() {
		super();
	}

	public EstadoFornecedor(int id, String uf, int deputados) {
		super();
		this. uflocal= uf;
		this.fornecedores = deputados;
	}

	public String getUflocal() {
		return uflocal;
	}

	public void setUflocal(String uflocal) {
		this.uflocal = uflocal;
	}

	public int getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(int fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public String toString() {
		return "EstadoFornecedor [uflocal=" + uflocal + ", fornecedores=" + fornecedores + ", getUflocal()="
				+ getUflocal() + ", getFornecedores()=" + getFornecedores() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
