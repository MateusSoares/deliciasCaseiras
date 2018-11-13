package deliciascaseiras.dao;

import java.util.List;

import javax.persistence.EntityManager;

import deliciascaseiras.modelo.Cliente;
import deliciascaseiras.util.Conexao;

public class ClienteDAO {

private EntityManager em ;
	
	public ClienteDAO() {
		em = Conexao.getConnection();
	}
	
public void salvar(Cliente obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Cliente> buscarTodos(){
		
		return em
		        .createQuery("from Cliente")
		        .getResultList();
		
	}	
	
	
	public void excluir(Cliente obj) {
		
		Cliente aux = 
				em.find(Cliente.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Cliente buscarPorId(Integer codigo){
		
		return em.find(Cliente.class,codigo);		
	}
}
