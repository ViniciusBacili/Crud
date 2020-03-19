package br.com.cast.avaliacao.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cast.avaliacao.model.Curso;

public class CursoDaoImpl implements CursoDao {
	
	@Autowired

	@Override
	public List<Curso> findAll() {
		
		return null;
	}

	@Override
	public List<Curso> findContainsName() {
		return null;
	}

	@Override
	public Curso findByPk(Integer pk) {
		return null;
	}

}
