package deliciascaseiras.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import deliciascaseiras.dao.AdministradorDAO;
import deliciascaseiras.modelo.Administrador;

public class AdministradorService {

	private AdministradorDAO dao = new AdministradorDAO();

	public void salvar(Administrador obj) {

		if ((obj == null) || (obj.getNome().isEmpty()))
			throw new ServiceException("Nome do Administrador não informado!");

		dao.salvar(obj);
	}

	public List<Administrador> buscarTodos() {

		return dao.buscarTodos();

	}

	public void excluir(Administrador obj) {

		dao.excluir(obj);
	}

	public Administrador buscarPorId(Integer codigo) {

		return dao.buscarPorId(codigo);
	}
	
}
