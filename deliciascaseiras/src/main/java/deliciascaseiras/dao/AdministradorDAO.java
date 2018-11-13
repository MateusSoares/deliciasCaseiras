package deliciascaseiras.dao;

import java.util.List;

import javax.persistence.EntityManager;

import deliciascaseiras.modelo.Administrador;
import deliciascaseiras.util.Conexao;



public class AdministradorDAO {

	
	private EntityManager em ;
	
	public AdministradorDAO() {
		em = Conexao.getConnection();
	}
	
public void salvar(Administrador obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Administrador> buscarTodos(){
		
		return em
		        .createQuery("from Administrador")
		        .getResultList();
		
	}	
	
	
	public void excluir(Administrador obj) {
		
		Administrador aux = 
				em.find(Administrador.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Administrador buscarPorId(Integer codigo){
		
		return em.find(Administrador.class,codigo);		
	}
}
