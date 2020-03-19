package br.com.cast.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.com.cast.avaliacao.model.Turma;

@RepositoryRestResource(path = "rest-turma-alunos")
public interface TurmaAlunosRepository extends JpaRepository<Turma, Integer>, QuerydslPredicateExecutor<Turma> {

}
