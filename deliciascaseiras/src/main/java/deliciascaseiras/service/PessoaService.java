package deliciascaseiras.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import deliciascaseiras.dao.PessoaDAO;
import deliciascaseiras.modelo.Pessoa;

public class PessoaService {

	private PessoaDAO dao 
	            = new PessoaDAO();
	
	
	public void salvar(Pessoa obj){
		
		if ( (obj == null) || 
		     (obj.getNome().isEmpty())
		   )
		  throw new ServiceException("Nome não informado.");
		
		
		if ((obj.getCodigo() == null) || (obj.getCodigo() == 0) )
			obj.getPermissao().add("USUARIO");

		
		
		dao.salvar(obj);
	}
	
	
	public List<Pessoa> buscarTodos(){
		
		return dao.buscarTodos();
		
	}	
	
	
	public void excluir(Pessoa obj) {
		
		dao.excluir(obj);
	}
	
	public Pessoa buscarPorId(Integer codigo){
		
		return dao.buscarPorId(codigo);		
	}	
		
	public Pessoa buscarPorLogin(String login){
		
		return dao.buscarPorLogin(login);
	}
	
}
