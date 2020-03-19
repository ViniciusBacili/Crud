package br.com.cast.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.com.cast.avaliacao.model.Curso;

@RepositoryRestResource(path = "rest-curso")
public interface CursoRepository extends JpaRepository<Curso, Integer>, QuerydslPredicateExecutor<Curso> {


}
