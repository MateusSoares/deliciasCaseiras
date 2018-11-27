package deliciascaseiras.modelo;

public enum TipoDeVendaENUM {

	UNIDADE("Unidade"), KG("KG");
	 
	private String valor ;

	private TipoDeVendaENUM(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor ;
	}
	
	
}
