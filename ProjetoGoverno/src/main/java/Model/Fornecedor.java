package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Fornecedor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String cnpj;
	@Column
	private String nome;
	@Column
	private String ativo;
	@Column
	private String id_municipio;
	@Column
	private String uf;
	@Column
	private String id_natureza_juridica;
	@Column
	private String id_porte_empresa;
	@Column
	private String id_cnae;
	@Column
	private String habilitado_licitar;
	
	 public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}


	public String getId_municipio() {
		return id_municipio;
	}
	public void setId_municipio(String id_municipio) {
		this.id_municipio = id_municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getId_natureza_juridica() {
		return id_natureza_juridica;
	}
	public void setId_natureza_juridica(String id_natureza_juridica) {
		this.id_natureza_juridica = id_natureza_juridica;
	}
	public String getId_porte_empresa() {
		return id_porte_empresa;
	}
	public void setId_porte_empresa(String id_porte_empresa) {
		this.id_porte_empresa = id_porte_empresa;
	}
	public String getId_cnae() {
		return id_cnae;
	}
	public void setId_cnae(String id_cnae) {
		this.id_cnae = id_cnae;
	}
	public String getHabilitado_licitar() {
		return habilitado_licitar;
	}
	public void setHabilitado_licitar(String habilitado_licitar) {
		this.habilitado_licitar = habilitado_licitar;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ativo, cnpj, habilitado_licitar, id, id_cnae, id_municipio, id_natureza_juridica,
				id_porte_empresa, nome, uf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(habilitado_licitar, other.habilitado_licitar) && Objects.equals(id, other.id)
				&& Objects.equals(id_cnae, other.id_cnae) && Objects.equals(id_municipio, other.id_municipio)
				&& Objects.equals(id_natureza_juridica, other.id_natureza_juridica)
				&& Objects.equals(id_porte_empresa, other.id_porte_empresa) && Objects.equals(nome, other.nome)
				&& Objects.equals(uf, other.uf);
	}
	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", usuario=" + ", cnpj=" + cnpj + ", nome=" + nome + ", ativo="
				+ ativo + ", id_municipio=" + id_municipio + ", uf=" + uf + ", id_natureza_juridica="
				+ id_natureza_juridica + ", id_porte_empresa=" + id_porte_empresa + ", id_cnae=" + id_cnae
				+ ", habilitado_licitar=" + habilitado_licitar + "]";
	}
	
	
	
	

}
