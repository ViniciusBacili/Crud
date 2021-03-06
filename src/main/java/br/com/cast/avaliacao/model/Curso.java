package br.com.cast.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table
@Entity
public class Curso {

	//POJO - Plain Old Java Object
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity = Categoria.class)
	private Categoria categoria;
	
	@Column(unique=true, nullable=false)
	private String descricao;

	@Column(name = "ativo" , nullable = false, columnDefinition = "tinyint(3) default 1",  insertable = false, updatable = true)
	private Integer ativo;

	@Transient
	private Integer quantidadeTurmas;
	
	public Curso() {

	}
	
	public Curso(Categoria categoria, String descricao, Integer ativo) {

		this.categoria = categoria;
		this.descricao = descricao;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
	public Integer getQuantidadeTurmas() {
		return quantidadeTurmas;
	}

	public void setQuantidadeTurmas(Integer quantidadeTurmas) {
		this.quantidadeTurmas = quantidadeTurmas;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", categoria=" + categoria + ", descricao=" + descricao + ", ativo=" + ativo + "]";
	}
	
}
