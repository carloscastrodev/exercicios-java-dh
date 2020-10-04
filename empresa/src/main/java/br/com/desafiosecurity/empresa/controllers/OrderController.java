package br.com.desafiosecurity.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiosecurity.empresa.model.entities.Pedido;
import br.com.desafiosecurity.empresa.model.repositories.OrderRepository;

@RestController
@RequestMapping(path = "pedidos")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/{nfe}")
	public Optional<Pedido> getByNfe(@PathVariable int nfe) {
		return orderRepository.findById(nfe);
	}

	@GetMapping("cliente/{id_cliente}")
	public List<Pedido> getByClient(@PathVariable int id_cliente) {
		return orderRepository.findByClientId(id_cliente);
	}

	@PostMapping()
	public Pedido addPedido(@RequestBody Pedido pedido) {
		orderRepository.save(pedido);

		return pedido;
	}

	@DeleteMapping("/{nfe}")
	public void deletePedido(@PathVariable int nfe) {
		orderRepository.deleteById(nfe);
	}

}
