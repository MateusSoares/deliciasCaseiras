package deliciascaseiras.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo ;
	@OneToMany
	private List<Produto> produtos = new ArrayList<Produto>();
	@Temporal(TemporalType.DATE)
	private Date dtPedido ;
	@Temporal(TemporalType.DATE)
	private Date dtEntrega ;
	@Enumerated(EnumType.STRING)
	private StatusPedidoENUM status ;
	@ManyToOne
	private Cliente cliente ;
	
	
	

	public Pedido() {
		
	}




	public Pedido(List<Produto> produtos, Date dtPedido, Date dtEntrega, StatusPedidoENUM status, Cliente cliente) {
		this.produtos = produtos;
		this.dtPedido = dtPedido;
		this.dtEntrega = dtEntrega;
		this.status = status;
		this.cliente = cliente;
	}




	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public List<Produto> getProdutos() {
		return produtos;
	}




	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}




	public Date getDtPedido() {
		return dtPedido;
	}




	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}




	public Date getDtEntrega() {
		return dtEntrega;
	}




	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}




	public StatusPedidoENUM getStatus() {
		return status;
	}




	public void setStatus(StatusPedidoENUM status) {
		this.status = status;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Pedido other = (Pedido) obj;
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
		return "Pedido"+this.codigo;
	}
	
	
	
	
	
}
