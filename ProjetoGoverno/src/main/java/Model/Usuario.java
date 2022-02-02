package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@JoinColumn(name = "codigo")
	private Integer codigo;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	@org.hibernate.annotations.NaturalId
	@Column
	private String login;
	@Column
	private String senha;
	@Column
	private Date nascimento;
	@Column
	private String idioma;
	@Column
	private boolean ativo;

	private String token;

	
	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "usuario_permissao", uniqueConstraints = { //////
			@UniqueConstraint(columnNames = { "usuario", "permissao" }) }, joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "permissao", length = 50)
	private Set<String> permissao = new HashSet<String>();
	
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, codigo, email, idioma, login, nascimento, nome, permissao, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return ativo == other.ativo && Objects.equals(codigo, other.codigo) && Objects.equals(email, other.email)
			    && Objects.equals(idioma, other.idioma)
				&& Objects.equals(login, other.login) && Objects.equals(nascimento, other.nascimento)
				&& Objects.equals(nome, other.nome) && Objects.equals(permissao, other.permissao)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", fone=" + ", email=" + email + ", login="
				+ login + ", senha=" + senha + ", nascimento=" + nascimento + ", idioma=" + idioma + ", ativo=" + ativo
				+ ", permissao=" + permissao + "]";
	}
	
	
	
	
	
	
}
