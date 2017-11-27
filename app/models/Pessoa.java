package models;

import java.util.List;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.avaje.ebean.Ebean;

//import play.db.ebean.Model;
import com.avaje.ebean.Model;

@Entity
@Table(name="pessoa")
public class Pessoa extends Model { 
	
	private static final long serialVersionUID = -1746546171805131391L;
	//public static final Finder<Long, Pessoa> find = new Finder<>(Pessoa.class);
	public static Finder<Long,Pessoa> find = new Finder<Long,Pessoa>(Long.class, Pessoa.class);
	
	public static boolean salvar(Pessoa pessoa) {
		
		try {
			pessoa.save();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public static boolean remover(Pessoa pessoa) {
		
		try {
			pessoa.delete();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Pessoa> findAll() {
		
		return find.where().findList();
	}
	
	public static Pessoa findById(Long id) {
		
		return find.byId(id);
	}
	
	public static Pessoa findByCpf(String cpf) {
		
		return find.where().eq("cpf", cpf).findUnique();
	}
	

	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="id", columnDefinition="BIGINT(11)", nullable=false)
	private Long id;
	
	@Column(name="nome", columnDefinition="VARCHAR(45)", nullable=false)
	private String nome;
	
	@Column(name="cpf", columnDefinition="VARCHAR(45)", nullable=false)
	private String cpf;
	
	@Column(name="nascimento", columnDefinition="VARCHAR(45)", nullable=true)
	private Long nascimento;
	
	@Column(name="peso", columnDefinition="DECIMAL", nullable=true)
	private BigDecimal peso;
	
	@Column(name="uf", columnDefinition="VARCHAR(45)", nullable=true)
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