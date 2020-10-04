package br.com.desafiosecurity.empresa.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.desafiosecurity.empresa.model.entities.Ponto;

public interface PointRepository extends CrudRepository<Ponto, Integer> {

	@Query(value = "select p from Ponto p where id_funcionario = :id_funcionario")
	List<Ponto> findByFuncId(int id_funcionario);

}
