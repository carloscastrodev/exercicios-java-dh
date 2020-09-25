package br.com.dh.lojaonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Telefone;
import br.com.dh.lojaonline.model.repositories.TelefoneRepository;

@RestController
@RequestMapping(path = "telefones")
public class TelefoneController {

	@Autowired
	private TelefoneRepository telefoneRepository;

	@GetMapping()
	public Iterable<Telefone> findAllTelefones() {
		return telefoneRepository.findAll();
	}

	@GetMapping("/{ddd}")
	public List<Telefone> getByDdd(@PathVariable int ddd) {
		return telefoneRepository.findByDdd(ddd);
	}

	@PostMapping()
	public Telefone addTelefone(@RequestBody Telefone tel) {
		telefoneRepository.save(tel);

		return tel;
	}

}
