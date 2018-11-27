package deliciascaseiras.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo ;
	@OneToOne
	private Pessoa pessoa ;
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<Pedido>() ;
	
	public Cliente() {
		
	}


	public Cliente(Integer codigo) {
		this.codigo = codigo ;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return pessoa.getNome();
	}

	public void setNome(String nome) {
		pessoa.setNome(nome);;
	}

	public String getLogin() {
		return pessoa.getLogin();
	}

	public void setLogin(String login) {
		pessoa.setLogin(login);
	}

	public String getSenha() {
		return pessoa.getSenha();
	}

	public void setSenha(String senha) {
		pessoa.setSenha(senha);
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cliente other = (Cliente) obj;
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
		return this.pessoa.getNome();
	}
	
	
}
