package br.com.desafiosecurity.empresa.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_produto;
	private String nome;

	private Double preco;
	private String descricao;
	private Integer estoque;

	public Produto() {
	};

	public Produto(String nome, Double preco, String descricao, int estoque) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.estoque = estoque;
	}

	public int getId() {
		return id_produto;
	}

	public void setId(int id) {
		this.id_produto = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
