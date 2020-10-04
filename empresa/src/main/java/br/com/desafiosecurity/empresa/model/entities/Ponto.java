package br.com.desafiosecurity.empresa.model.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ponto_funcionario")
public class Ponto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ponto;

	private int id_funcionario;
	private Date entrada;
	private Date saida;

	public Ponto() {
	};

	public Ponto(int id_funcionario, Date entrada, Date saida) {
		this.id_funcionario = id_funcionario;
		this.entrada = entrada;
		this.saida = saida;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

}