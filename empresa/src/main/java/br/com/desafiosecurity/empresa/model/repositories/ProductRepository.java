package br.com.desafiosecurity.empresa.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.desafiosecurity.empresa.model.entities.Produto;

public interface ProductRepository extends CrudRepository<Produto, Integer> {

	@Query(value = "SELECT p FROM Produto p WHERE nome LIKE %:nome%")
	List<Produto> findByNameLike(@Param("nome") String nome);

	@Query(value = "SELECT p FROM Produto p WHERE estoque > :min")
	List<Produto> findProductByMinEstoque(@Param("min") Integer min);

}
