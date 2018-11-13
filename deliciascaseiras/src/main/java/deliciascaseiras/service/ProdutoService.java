package deliciascaseiras.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import deliciascaseiras.dao.ProdutoDAO;
import deliciascaseiras.modelo.Produto;

public class ProdutoService {

	private ProdutoDAO dao = new ProdutoDAO();

	public void salvar(Produto obj) {

		if ((obj == null) || (obj.getNome().isEmpty()))
			throw new ServiceException("Nome do Produto não informado!");

		dao.salvar(obj);
	}

	public List<Produto> buscarTodos() {

		return dao.buscarTodos();

	}

	public void excluir(Produto obj) {

		dao.excluir(obj);
	}

	public Produto buscarPorId(Integer codigo) {

		return dao.buscarPorId(codigo);
	}
}
