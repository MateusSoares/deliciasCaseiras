package deliciascaseiras.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo ;
	private String nome ;
	private String descricao ;
	@Enumerated(EnumType.STRING)
	private TipoDeVendaENUM tipoVenda ;
	
	public Produto() {
		
	}

	public Produto(String nome, String descricao, TipoDeVendaENUM tipoVenda) {
		this.nome = nome;
		this.descricao = descricao;
		this.tipoVenda = tipoVenda;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoDeVendaENUM getTipoVenda() {
		return tipoVenda;
	}

	public void setTipoVenda(TipoDeVendaENUM tipoVenda) {
		this.tipoVenda = tipoVenda;
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
		Produto other = (Produto) obj;
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
		return nome;
	}
	
	
	 
	
}
