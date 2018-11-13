package deliciascaseiras.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="administrador")
public class Administrador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo ;
	private String nome ;
	private String login ;
	private String senha ;
	
	public Administrador() {
		
	}

	public Administrador(Integer codigo, String nome, String login, String senha) {
		this.codigo = codigo;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		Administrador other = (Administrador) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	
	
	
	
}
