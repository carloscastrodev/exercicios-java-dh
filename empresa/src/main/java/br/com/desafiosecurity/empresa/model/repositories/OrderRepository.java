package br.com.desafiosecurity.empresa.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.desafiosecurity.empresa.model.entities.Pedido;

public interface OrderRepository extends CrudRepository<Pedido, Integer> {

	@Query(value = "select p from Pedido p where id_cliente = :id_cliente")
	List<Pedido> findByClientId(int id_cliente);

}
