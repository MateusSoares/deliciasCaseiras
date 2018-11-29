package deliciascaseiras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import deliciascaseiras.modelo.Produto;
import deliciascaseiras.service.ProdutoService;

@FacesConverter(forClass=Produto.class)
public class ProdutoConverter implements Converter{

	private ProdutoService service = new ProdutoService();
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Produto area = null;
		
		if ( (value != null) && (!value.isEmpty()) )
			area = 
               service.buscarPorId(Integer.parseInt(value));		
		
		return area;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		
		if (value != null){
		   return  String.valueOf(((Produto)value).getCodigo());
		}
		else 
		   return null;
	}

	
	
	
}
