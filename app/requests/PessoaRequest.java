package requests;

import java.math.BigDecimal;

public class PessoaRequest { 
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private Long nascimento;
	
	private BigDecimal peso;
	
	private String uf;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getNascimento() {
		return nascimento;
	}

	public void setNascimento(Long nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}