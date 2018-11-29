package deliciascaseiras.modelo;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo ;
	@ManyToOne
	private Produto produto ;
	@Temporal(TemporalType.DATE)
	private Date dtPedido = new Date() ;
	@Temporal(TemporalType.DATE)
	private Date dtEntrega ;
	@ManyToOne
	private Pessoa pessoa ;
	private Boolean confirmado ; 
	
	
	

	public Pedido() {
		this.confirmado = false ;
	}




	public Pedido(Produto poduto, Date dtPedido, Date dtEntrega, Pessoa pessoa) {
		this.produto = poduto;
		this.dtPedido = dtPedido;
		this.dtEntrega = dtEntrega;
		this.pessoa = pessoa;
	}




	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public Produto getProduto() {
		return produto;
	}




	public void setProduto(Produto produto) {
		this.produto = produto;
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



	public Pessoa getPessoa() {
		return pessoa;
	}




	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
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
