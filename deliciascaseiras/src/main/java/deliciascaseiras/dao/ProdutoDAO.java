package deliciascaseiras.dao;

import java.util.List;

import javax.persistence.EntityManager;

import deliciascaseiras.modelo.Produto;
import deliciascaseiras.util.Conexao;

public class ProdutoDAO {

private EntityManager em ;
	
	public ProdutoDAO() {
		em = Conexao.getConnection();
	}
	
public void salvar(Produto obj){
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}
	
	
	public List<Produto> buscarTodos(){
		
		return em
		        .createQuery("from Produto")
		        .getResultList();
		
	}	
	
	
	public void excluir(Produto obj) {
		
		Produto aux = 
				em.find(Produto.class,obj.getCodigo());
		em.getTransaction().begin();
		em.remove(aux);
		em.flush();//executa a instrução no momento
		em.getTransaction().commit();
	}
	
	public Produto buscarPorId(Integer codigo){
		
		return em.find(Produto.class,codigo);		
	}
}
