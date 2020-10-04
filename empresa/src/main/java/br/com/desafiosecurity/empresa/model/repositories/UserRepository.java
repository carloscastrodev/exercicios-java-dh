package br.com.desafiosecurity.empresa.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.desafiosecurity.empresa.model.entities.Usuario;
import br.com.desafiosecurity.empresa.model.projections.UserProjection;

public interface UserRepository extends CrudRepository<Usuario, Integer> {

	@Query(value = "select * from usuarios", nativeQuery = true)
	List<UserProjection> index();

}
