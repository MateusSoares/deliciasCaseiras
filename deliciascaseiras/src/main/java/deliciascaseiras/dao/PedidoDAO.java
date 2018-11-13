package deliciascaseiras.dao;

import java.util.List;

import javax.persistence.EntityManager;

import deliciascaseiras.modelo.Pedido;
import deliciascaseiras.util.Conexao;

public class PedidoDAO {

private EntityManager em ;
	
	public PedidoDAO() {
		em = Conexao.getConnection();
	}
	
public void salvar(Pedido obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Pedido> buscarTodos(){
		
		return em
		        .createQuery("from Pedido")
		        .getResultList();
		
	}	
	
	
	public void excluir(Pedido obj) {
		
		Pedido aux = 
				em.find(Pedido.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Pedido buscarPorId(Integer codigo){
		
		return em.find(Pedido.class,codigo);		
	}
}
