package deliciascaseiras.modelo;

public enum StatusPedidoENUM {

	AGUARDANDO(1), CONFIRMADO(2), CANCELADO(3) ;
	
	private Integer valor ;

	private StatusPedidoENUM(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return this.valor ;
	}
	
}
