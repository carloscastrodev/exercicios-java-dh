package br.com.dh.lojaonline.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Produto;
import br.com.dh.lojaonline.model.repositories.ProdutoRepository;

@RestController
@RequestMapping(path = "produtos")
public class ProductController {

	@Autowired
	private ProdutoRepository productRepository;

	@GetMapping()
	public Iterable<Produto> getProduct() {
		return productRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Produto> getById(@PathVariable int id) {
		return productRepository.findById(id);
	}

	@PostMapping()
	public Produto addProduto(@RequestBody Produto produto) {
		productRepository.save(produto);

		return produto;
	}

	@PutMapping("/{idProduto}")
	public Produto updateProduto(@PathVariable int idProduto, @RequestBody Produto dadosProduto) throws Exception {
		Produto prod = productRepository.findById(idProduto).orElseThrow(() -> new IllegalAccessException());

		if (!dadosProduto.getNome().isEmpty())
			prod.setNome(dadosProduto.getNome());
		if (!dadosProduto.getDescricao().isEmpty())
			prod.setDescricao(dadosProduto.getDescricao());
		if (!dadosProduto.getPreco().isNaN())
			prod.setPreco(dadosProduto.getPreco());
		if (dadosProduto.getEstoque() != null)
			prod.setEstoque(dadosProduto.getEstoque());

		productRepository.save(prod);

		return prod;
	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable int id) {
		productRepository.deleteById(id);
	}

	@GetMapping("/nome")
	public Produto getByName(@RequestParam String nome) {
		return productRepository.findOneByNome(nome);
	}

	@GetMapping("/ano")
	public List<Produto> getByYear(@RequestParam String ano) {
		return productRepository.findProductByNomeContaining(ano);
	}

	@GetMapping("/nomelike")
	public List<Produto> getByNameLike(@RequestParam String nome) {
		return productRepository.encontrarNomeParecido(nome);
	}

	@GetMapping("/estoque")
	public List<Produto> getByMinEstoque(@RequestParam int min) {
		return productRepository.findProductByMinEstoque(min);
	}

}
