package br.com.dh.lojaonline.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.dh.lojaonline.model.entities.Telefone;

public interface TelefoneRepository extends CrudRepository<Telefone, Integer> {

	List<Telefone> findByDdd(@Param("ddd") int ddd);

	// List<Cliente> findByNomeContaint(String nome);

}
