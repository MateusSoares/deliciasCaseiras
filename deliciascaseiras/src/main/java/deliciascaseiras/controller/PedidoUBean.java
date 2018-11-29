package deliciascaseiras.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import deliciascaseiras.modelo.Pedido;
import deliciascaseiras.modelo.Produto;
import deliciascaseiras.security.Seguranca;
import deliciascaseiras.service.PedidoService;
import deliciascaseiras.service.PessoaService;
import deliciascaseiras.service.ProdutoService;
import deliciascaseiras.util.FacesMensagens;


@ManagedBean
@SessionScoped
public class PedidoUBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private List<Pedido> pessoas;
	private List<Produto> produtos;
	private Seguranca seg = new Seguranca() ;
	
	private Pedido pedEdicao = new Pedido();
	
	private PedidoService pedService = new PedidoService();
	private ProdutoService prodService = new ProdutoService();
	private PessoaService pesService = new PessoaService();
	
	public PedidoUBean() {
        
		setPedidos(pedService.buscarPorPessoa(pesService.buscarPorId(seg.getCodUsuario())));
        setProdutos(getProdService().buscarTodos());

	}
	
	public List<Pedido> getPedidos() {
		return pessoas;
	}



	public void setPedidos(List<Pedido> pessoas) {
		this.pessoas = pessoas;
	}



	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ProdutoService getProdService() {
		return prodService;
	}

	public void setProdService(ProdutoService prodService) {
		this.prodService = prodService;
	}

	public PedidoService getPedService() {
		return pedService;
	}



	public void setPedService(PedidoService pedService) {
		this.pedService = pedService;
	}



	public Pedido getPedEdicao() {
		return pedEdicao;
	}

	public void setPedEdicao(Pedido pedEdicao) {
		this.pedEdicao = pedEdicao;
	}

	public String novoPedido(){
		setPedEdicao(new Pedido());
		return  "CadastroPedidoU?faces-redirect=true";
	}
	
	public String editarPedido(){
		return  "CadastroPedido?faces-redirect=true";
	}	
	
	public void salvarPedido(){
				
		try{
		
			pedEdicao.setPessoa(pesService.buscarPorId(seg.getCodUsuario()));
			
		pedService.salvar(getPedEdicao());
		System.out.println("deu merda" + seg.getNomeUsuario());
		setPedidos(pedService.buscarTodos()); 
		
		FacesMensagens.info("Registro salvo com sucesso.");
		limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public void excluirPedido(){
		
		try{
		pedService.excluir(getPedEdicao());
		setPedidos(pedService.buscarTodos()); 
		
		FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}	
	
	
	private void limpa() {
		setPedEdicao(new Pedido());
		
	}

	public String confirmar() {

		if (getPedEdicao().isConfirmado())
			getPedEdicao().setConfirmado(false);
		else
			getPedEdicao().setConfirmado(true);

		try {
			pedService.salvar(getPedEdicao());
		} catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
		return null;
	}
	
	
	
}
