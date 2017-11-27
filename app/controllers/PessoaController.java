package controllers;

import requests.PessoaRequest;
import models.Pessoa;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


public class PessoaController extends Controller {

	public Result findAllPessoa() {
		
		return ok(Json.toJson(Pessoa.findAll()));
		
	}
	
	public Result cadastrarPessoa(){
		
		Form<PessoaRequest> form = Form.form(PessoaRequest.class);
		form = form.bindFromRequest();
		PessoaRequest request = form.get();
		
		Pessoa pessoaBD = Pessoa.findByCpf(request.getCpf());
		
		if(pessoaBD != null){
			return forbidden("CPF Já cadastrado!");
		}
		
		Pessoa pessoaNova = new Pessoa();
		
		pessoaNova.setNome(request.getNome());
		pessoaNova.setNascimento(request.getNascimento());
		pessoaNova.setPeso(request.getPeso());
		pessoaNova.setCpf(request.getCpf());
		pessoaNova.setUf(request.getUf());
		
		if(Pessoa.salvar(pessoaNova)){
			return ok("Cadastro efetuado com sucesso!");
		}
		
		return internalServerError("Erro ao salvar informações!");
		
	}
	
	public Result removerPessoa(Long id) {
		
		Pessoa pessoaBD = Pessoa.findById(id);
		
		if(pessoaBD != null){
			if(Pessoa.remover(pessoaBD)){
				return ok(Json.toJson("Excluido com Sucesso!"));
			}else{
				return internalServerError("Erro ao excluir informações!");
			}
		}
		
		return notFound();
		
	}

}
