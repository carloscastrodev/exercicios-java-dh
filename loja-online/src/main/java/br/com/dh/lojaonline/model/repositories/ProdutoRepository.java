package br.com.dh.lojaonline.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.dh.lojaonline.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	Produto findOneByNome(String nome);

	@Query(value = "SELECT p FROM Produto p WHERE nome LIKE %:nome%")
	List<Produto> encontrarNomeParecido(@Param("nome") String nome);

	List<Produto> findProductByNomeContaining(@Param("year") String year);

	@Query(value = "SELECT p FROM Produto p WHERE estoque > :min")
	List<Produto> findProductByMinEstoque(@Param("min") Integer min);

	// List<Cliente> findByNomeContaint(String nome);

}
