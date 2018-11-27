package deliciascaseiras.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import deliciascaseiras.modelo.Pessoa;
import deliciascaseiras.service.PessoaService;
import deliciascaseiras.util.FacesMensagens;


@ManagedBean
@SessionScoped
public class PessoaBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private List<Pessoa> pessoas;
	private Pessoa pesEdicao = 
			             new Pessoa();
	private PessoaService pesService =
            new PessoaService();
	
	public PessoaBean() {
        setPessoas(pesService.buscarTodos());		

	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}



	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}



	public PessoaService getPesService() {
		return pesService;
	}



	public void setPesService(PessoaService pesService) {
		this.pesService = pesService;
	}



	public Pessoa getPesEdicao() {
		return pesEdicao;
	}

	public void setPesEdicao(Pessoa pesEdicao) {
		this.pesEdicao = pesEdicao;
	}

	public String novaPessoa(){
		setPesEdicao(new Pessoa());
		return  "CadastroPessoa?faces-redirect=true";
	}
	
	public String editarPessoa(){
		return  "CadastroPessoa?faces-redirect=true";
	}	
	
	public void salvarPessoa(){
				
		try{
		pesService.salvar(getPesEdicao());
		setPessoas(pesService.buscarTodos()); 
		
		FacesMensagens.info("Registro salvo com sucesso.");
		limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}

	public void excluirPessoa(){
		
		try{
		pesService.excluir(getPesEdicao());
		setPessoas(pesService.buscarTodos()); 
		
		FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}	
	
	
	private void limpa() {
		setPesEdicao(new Pessoa());
		
	}

	public String ativar() {

		if (getPesEdicao().isAtivo())
			getPesEdicao().setAtivo(false);
		else
			getPesEdicao().setAtivo(true);

		try {
			pesService.salvar(getPesEdicao());
		} catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
		return null;
	}

	public String atribuirPermissao(String permissao) {

		Set<String> roles = getPesEdicao().getPermissao();
		if (roles.contains(permissao))
			roles.remove(permissao);
		else
			roles.add(permissao);

		
		try {
			pesService.salvar(getPesEdicao());
		} catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
		return null;
	}
	
	
	
}
