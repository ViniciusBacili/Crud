package br.com.cast.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.com.cast.avaliacao.model.Categoria;

@RepositoryRestResource(path = "rest-categoria")
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>, QuerydslPredicateExecutor<Categoria>  {

}
