package deliciascaseiras.security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@ManagedBean
@RequestScoped
public class Seguranca {

	public String getNomeUsuario() {
		String nome = null;
		
		PessoaSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}
		
		return nome;
	}

	private PessoaSistema getUsuarioLogado() {
		PessoaSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			usuario = (PessoaSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
	
	public boolean isPermitidoSalvarArea(){
		 ExternalContext externalContext =
		  FacesContext.getCurrentInstance().getExternalContext();
		 
		  return  externalContext.isUserInRole("ADMINISTRADOR");
	}
	
	public String getLogout(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		String aux = request.getContextPath()+"/j_spring_security_logout";
		return aux;
	}
	
}
