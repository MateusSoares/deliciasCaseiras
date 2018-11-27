package deliciascaseiras.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import deliciascaseiras.modelo.Produto;
import deliciascaseiras.modelo.TipoDeVendaENUM;
import deliciascaseiras.service.ProdutoService;
import deliciascaseiras.util.FacesMensagens;


@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Produto> produtos;
	private List<TipoDeVendaENUM> tipoDeVenda;
	private Produto prodEdicao = 
			             new Produto();
	private ProdutoService prodService =
            new ProdutoService();
	
	public ProdutoBean() {
		
		setProdutos(prodService.buscarTodos());
		setTipoDeVenda(Arrays.asList(TipoDeVendaENUM.values()));
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<TipoDeVendaENUM> getTipoDeVenda() {
		return tipoDeVenda;
	}

	public void setTipoDeVenda(List<TipoDeVendaENUM> tipoDeVenda) {
		this.tipoDeVenda = tipoDeVenda;
	}

	
	public Produto getProdEdicao() {
		return prodEdicao;
	}

	public void setProdEdicao(Produto prodEdicao) {
		this.prodEdicao = prodEdicao;
	}

	public String novoProduto(){
		prodEdicao = new Produto();
		return  "CadastroProduto?faces-redirect=true";
	}
	
	public String editarProduto(){
		return  "CadastroProduto?faces-redirect=true";
	}	
	
	public void salvarProduto(){
				
		try{
		prodService.salvar(prodEdicao);
		setProdutos(prodService.buscarTodos()); 
		
		FacesMensagens.info("Registro salvo com sucesso.");
		limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public void excluirProduto(){
		
		try{
		prodService.excluir(prodEdicao);
		setProdutos(prodService.buscarTodos()); 
		
		FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}	
	
	
	private void limpa() {
		prodEdicao = new Produto();
		
	}
	
	
}
