package br.com.cast.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Aluno {
	
	@Id
	@Column(name= "cpf", unique = true)
	private Long cpf;
	
	@Column(name = "nome" , nullable = false)
	private String nome;
	
	public Aluno() {
	}

	public Aluno(Long cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "AGAluno [cpf=" + cpf + ", nome=" + nome + "]";
	}
}