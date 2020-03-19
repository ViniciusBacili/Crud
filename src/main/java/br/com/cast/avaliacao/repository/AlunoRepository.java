package br.com.cast.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.cast.avaliacao.model.Aluno;

@RepositoryRestResource(path = "rest-aluno")
public interface AlunoRepository extends JpaRepository<Aluno, Integer>, QuerydslPredicateExecutor<Aluno>  {

}
