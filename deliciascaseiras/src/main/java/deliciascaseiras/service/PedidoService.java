package deliciascaseiras.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import deliciascaseiras.dao.PedidoDAO;
import deliciascaseiras.modelo.Pedido;
import deliciascaseiras.modelo.Pessoa;

public class PedidoService {

	private PedidoDAO dao = new PedidoDAO();

	public void salvar(Pedido obj) {

		if ((obj == null) || (obj.getPessoa().getNome().isEmpty()))
			throw new ServiceException("Nome do Cliente não informado!");

		dao.salvar(obj);
	}

	public List<Pedido> buscarTodos() {

		return dao.buscarTodos();

	}
	
	public List<Pedido> buscarPorPessoa(Pessoa pessoa) {

		return dao.buscarPorPessoa(pessoa);

	}

	public void excluir(Pedido obj) {

		dao.excluir(obj);
	}

	public Pedido buscarPorId(Integer codigo) {

		return dao.buscarPorId(codigo);
	}
}
