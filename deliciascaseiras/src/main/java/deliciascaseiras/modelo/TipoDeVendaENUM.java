package deliciascaseiras.modelo;

public enum TipoDeVendaENUM {

	UNIDADE(1), KG(2);
	 
	private Integer valor ;

	private TipoDeVendaENUM(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return this.valor ;
	}
	
	
}
