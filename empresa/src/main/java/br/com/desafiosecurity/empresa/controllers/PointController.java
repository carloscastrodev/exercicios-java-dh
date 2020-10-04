package br.com.desafiosecurity.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiosecurity.empresa.model.entities.Ponto;
import br.com.desafiosecurity.empresa.model.repositories.PointRepository;

@RestController
@RequestMapping(path = "ponto")
public class PointController {

	@Autowired
	private PointRepository pointRepository;

	@GetMapping("/{id_funcionario}")
	public List<Ponto> getByFuncId(@PathVariable int id_funcionario) {
		return pointRepository.findByFuncId(id_funcionario);
	}

	@PostMapping()
	public Ponto addPonto(@RequestBody Ponto ponto) {
		pointRepository.save(ponto);

		return ponto;
	}

}
