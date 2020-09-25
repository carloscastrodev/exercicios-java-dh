package br.com.dh.lojaonline.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;

	private String nome;
	private String cpf;

	@OneToMany(mappedBy = "id_cliente", cascade = CascadeType.ALL)
	private List<Telefone> telefones;

	public Cliente() {

	}

	public Cliente(int id, String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getId() {
		return id_cliente;
	}

	public void setId(int id) {
		this.id_cliente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
