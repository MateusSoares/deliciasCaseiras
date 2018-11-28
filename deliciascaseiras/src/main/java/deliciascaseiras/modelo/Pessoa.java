package deliciascaseiras.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity //(name="pessoas")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Tipo_pessoa",
                     discriminatorType=
                         DiscriminatorType.STRING)
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     Integer codigo;
     String nome;
     
     @Temporal(TemporalType.DATE)
     @Column(name="dtNasc",
    		 nullable=true)
     Date dtNascimento;
     String cpf;
     @Enumerated(EnumType.STRING)
     Sexo sexo;	 
     @Column(unique=true,
    		 length=30)
     String login;
     String senha;
     //@Transient
     //String confirmaSenha;
     
     @Temporal(TemporalType.TIMESTAMP)
	 @Column(insertable=true,
	 updatable=false)
     Date dtCriacao;
     
     private String email;
     private String idioma;
 	 private boolean ativo;

 	@ElementCollection
	@JoinTable(name="pessoa_permissao", uniqueConstraints = {
			@UniqueConstraint(columnNames={"codPessoa","permissao"})
	}, joinColumns = @JoinColumn(name="codPessoa"))
	@Column(name="permissao", length=50)
	private Set<String> permissao = new HashSet<String>();
 	
 	@OneToMany(mappedBy="pessoa")
	private List<Pedido> pedidos = new ArrayList<Pedido>() ;
 	 

 	
	public Pessoa(Integer codigo, String nome, Date dtNascimento, String cpf, Sexo sexo, Date dtCriacao) {
		this.codigo = codigo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dtCriacao = dtCriacao;
	}
     
	 public Pessoa() {
		ativo = true;
		dtCriacao = new Date();
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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

	/*
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
    */
	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", dtNascimento=" + dtNascimento + ", cpf=" + cpf
				+ ", sexo=" + sexo + ", dtCriacao=" + dtCriacao + "]";
	}
	 
	 
}
