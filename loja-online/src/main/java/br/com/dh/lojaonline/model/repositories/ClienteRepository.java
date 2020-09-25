package br.com.dh.lojaonline.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.dh.lojaonline.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	Cliente findOneByNome(String nome);

	@Query(value = "SELECT c FROM Cliente c WHERE nome LIKE %:nome%")
	List<Cliente> encontrarNomeParecido(@Param("nome") String nome);

	@Query(value = "SELECT c from Cliente c WHERE cpf LIKE %:cpf%")
	List<Cliente> encontrarClientePorCPF(@Param("cpf") String cpf);

	// List<Cliente> findByNomeContaint(String nome);

}
