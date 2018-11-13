package deliciascaseiras.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import deliciascaseiras.dao.ClienteDAO;
import deliciascaseiras.modelo.Cliente;

public class ClienteService {

	private ClienteDAO dao = new ClienteDAO();

	public void salvar(Cliente obj) {

		if ((obj == null) || (obj.getNome().isEmpty()))
			throw new ServiceException("Nome do Cliente não informado!");

		dao.salvar(obj);
	}

	public List<Cliente> buscarTodos() {

		return dao.buscarTodos();

	}

	public void excluir(Cliente obj) {

		dao.excluir(obj);
	}

	public Cliente buscarPorId(Integer codigo) {

		return dao.buscarPorId(codigo);
	}
}
