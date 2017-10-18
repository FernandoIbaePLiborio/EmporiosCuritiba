package com.emporios.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrega")
	private Date dataEntrega;

	@Temporal(TemporalType.DATE)
	@Column(name="data_envio")
	private Date dataEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_pedido")
	private Date dataPedido;

	@Column(name="id_pagamento")
	private Integer idPagamento;

	private String status;

	private String transporte;

	//bi-directional many-to-one association to ItemVenda
	@OneToMany(mappedBy="pedido")
	private List<ItemVenda> itemVendas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;

	public Pedido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEnvio() {
		return this.dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Integer getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransporte() {
		return this.transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public List<ItemVenda> getItemVendas() {
		return this.itemVendas;
	}

	public void setItemVendas(List<ItemVenda> itemVendas) {
		this.itemVendas = itemVendas;
	}

	public ItemVenda addItemVenda(ItemVenda itemVenda) {
		getItemVendas().add(itemVenda);
		itemVenda.setPedido(this);

		return itemVenda;
	}

	public ItemVenda removeItemVenda(ItemVenda itemVenda) {
		getItemVendas().remove(itemVenda);
		itemVenda.setPedido(null);

		return itemVenda;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}