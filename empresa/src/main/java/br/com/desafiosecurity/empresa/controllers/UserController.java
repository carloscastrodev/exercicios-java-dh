package br.com.desafiosecurity.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiosecurity.empresa.model.entities.Usuario;
import br.com.desafiosecurity.empresa.model.projections.UserProjection;
import br.com.desafiosecurity.empresa.model.repositories.UserRepository;

@RestController
@RequestMapping(path = "funcionarios")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping()
	public List<UserProjection> getFuncionarios() {
		return userRepository.index();
	}

	@GetMapping("/{idFuncionario}")
	public Optional<Usuario> getById(@PathVariable int idFuncionario) {
		return userRepository.findById(idFuncionario);
	}

	@PostMapping()
	public Usuario addUser(@RequestBody Usuario usuario) {
		userRepository.save(usuario);

		return usuario;
	}

	@PutMapping("/reajuste/{idFuncionario}")
	public Usuario updateUser(@PathVariable int idFuncionario, @RequestBody Usuario reajuste) throws Exception {
		Usuario user = userRepository.findById(idFuncionario).orElseThrow(() -> new IllegalAccessException());

		if (reajuste.getSalario() != user.getSalario()) {
			user.setSalario(reajuste.getSalario());
		}

		userRepository.save(user);

		return user;

	}

	@DeleteMapping("/demitir/{idFuncionario}")
	public void deleteUser(@PathVariable int idFuncionario) {
		userRepository.deleteById(idFuncionario);
	}

}
