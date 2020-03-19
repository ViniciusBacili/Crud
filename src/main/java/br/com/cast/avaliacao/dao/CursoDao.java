package br.com.cast.avaliacao.dao;

import java.util.List;

import br.com.cast.avaliacao.model.Curso;

public interface CursoDao {

	public List<Curso> findAll();
	public List<Curso> findContainsName();
	public Curso findByPk(Integer pk);
}
