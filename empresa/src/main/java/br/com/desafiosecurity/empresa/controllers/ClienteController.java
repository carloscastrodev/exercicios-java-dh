package br.com.desafiosecurity.empresa.controllers;

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

import br.com.desafiosecurity.empresa.model.entities.Cliente;
import br.com.desafiosecurity.empresa.model.repositories.ClientRepository;

@RestController
@RequestMapping(path = "clientes")
public class ClienteController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping()
	public Iterable<Cliente> getClientes() {
		return clientRepository.findAll();
	}

	@GetMapping("/{idCliente}")
	public Optional<Cliente> getById(@PathVariable int idCliente) {
		return clientRepository.findById(idCliente);
	}

	@PostMapping()
	public Cliente addCliente(@RequestBody Cliente cliente) {
		clientRepository.save(cliente);

		return cliente;
	}

	@PutMapping("/{idCliente}")
	public Cliente updateCliente(@PathVariable int idCliente, @RequestBody Cliente dadosCliente) throws Exception {
		Cliente meuCliente = clientRepository.findById(idCliente).orElseThrow(() -> new IllegalAccessException());

		if (!dadosCliente.getCpf().isEmpty())
			meuCliente.setCpf(dadosCliente.getCpf());
		if (!dadosCliente.getNome().isEmpty())
			meuCliente.setNome(dadosCliente.getNome());

		clientRepository.save(meuCliente);

		return meuCliente;

	}

	@DeleteMapping("/{idCliente}")
	public void deleteCliente(@PathVariable int idCliente) {
		clientRepository.deleteById(idCliente);
	}

}
