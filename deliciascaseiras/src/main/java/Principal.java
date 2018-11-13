import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import deliciascaseiras.modelo.Administrador;
import deliciascaseiras.modelo.Cliente;
import deliciascaseiras.modelo.Pedido;
import deliciascaseiras.modelo.Produto;
import deliciascaseiras.modelo.StatusPedidoENUM;
import deliciascaseiras.modelo.TipoDeVendaENUM;
import deliciascaseiras.service.AdministradorService;
import deliciascaseiras.service.ClienteService;
import deliciascaseiras.service.PedidoService;
import deliciascaseiras.service.ProdutoService;

public class Principal {
	
	public static void main(String[] args) {
		
		Administrador adm = new Administrador(05, "Italo", "cudagua", "54321") ;
		AdministradorService admService = new AdministradorService() ;
		
		Cliente cli = new Cliente("Mateus", "loginMateus", "321") ;
		ClienteService cliService = new ClienteService() ;
		 cliService.salvar(cli);
		
		
		Produto prod1 = new Produto("Bolo", "Fuba", TipoDeVendaENUM.UNIDADE) ;
		Produto prod2 = new Produto("Biscoito", "Sequilho", TipoDeVendaENUM.KG) ;
		ProdutoService prodService = new ProdutoService();
		
		prodService.salvar(prod1);
		prodService.salvar(prod2);
		
		List<Produto> listProd = new ArrayList<Produto>();
		
		listProd.add(prodService.buscarPorId(01));
		listProd.add(prodService.buscarPorId(02));
		
		Pedido ped = new Pedido(listProd, new Date(), new Date(), StatusPedidoENUM.AGUARDANDO, cliService.buscarPorId(01) );
		PedidoService pedService = new PedidoService() ;
		
		List<Pedido> listPed = new ArrayList<Pedido>();
		
		listPed.add(ped);
		
		cli.setPedidos(listPed);
		
		//cliService.salvar(cli);
		
		
		
		pedService.salvar(ped);
		
		
	}
}
