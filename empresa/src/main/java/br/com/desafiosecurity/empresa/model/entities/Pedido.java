package br.com.desafiosecurity.empresa.model.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	private String nfe;

	private Date data_emissao;
	private double valor_total;
	private String status_pedido;
	private int id_cliente;

	public Pedido() {
	};

	public Pedido(String nfe, Date data_emissao, double valor_total, int id_cliente) {
		this.nfe = nfe;
		this.data_emissao = data_emissao;
		this.valor_total = valor_total;
		this.status_pedido = "Processando";
		this.id_cliente = id_cliente;
	}

	public String getNfe() {
		return nfe;
	}

	public void setNfe(String nfe) {
		this.nfe = nfe;
	}

	public Date getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public String getStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(String status_pedido) {
		this.status_pedido = status_pedido;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
}
