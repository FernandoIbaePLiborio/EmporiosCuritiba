package com.emporios.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the item_venda database table.
 * 
 */
@Entity
@Table(name="item_venda")
@NamedQuery(name="ItemVenda.findAll", query="SELECT i FROM ItemVenda i")
public class ItemVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemVendaPK id;

	private BigDecimal desconto;

	private BigDecimal preco;

	private Integer quantidade;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	//bi-directional many-to-one association to ProdutoFornecedor
	@ManyToOne
	@JoinColumn(name="id_produto")
	private ProdutoFornecedor produtoFornecedor;

	public ItemVenda() {
	}

	public ItemVendaPK getId() {
		return this.id;
	}

	public void setId(ItemVendaPK id) {
		this.id = id;
	}

	public BigDecimal getDesconto() {
		return this.desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ProdutoFornecedor getProdutoFornecedor() {
		return this.produtoFornecedor;
	}

	public void setProdutoFornecedor(ProdutoFornecedor produtoFornecedor) {
		this.produtoFornecedor = produtoFornecedor;
	}

}