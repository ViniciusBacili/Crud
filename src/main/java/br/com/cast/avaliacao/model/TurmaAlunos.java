package br.com.cast.avaliacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames={"aluno_id", "turma_id"})
})
@Entity
public class TurmaAlunos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity = Curso.class)
	private Aluno aluno;

	@ManyToOne(targetEntity = Turma.class)
	private Turma turma;
	
	public TurmaAlunos() {
	
	}
	
	public TurmaAlunos(Aluno aluno, Turma turma) {
		this.aluno = aluno;
		this.turma = turma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "TurmaAlunos [id=" + id + ", aluno=" + aluno + ", turma=" + turma + "]";
	}

	
}
