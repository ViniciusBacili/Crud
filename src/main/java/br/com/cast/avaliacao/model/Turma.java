package br.com.cast.avaliacao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table
@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity = Curso.class, fetch=FetchType.LAZY)
	private Curso curso;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataInicio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataFim;

	public Turma() {

	}

	public Turma(Curso curso, Date dataInicio, Date dataFim) {

		this.curso = curso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", curso=" + curso + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}
}