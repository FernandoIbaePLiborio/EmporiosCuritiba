package com.emporios.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "PRODUTO_FORNECEDOR")
public class ProdutoFornecedor implements Serializable, Cloneable {

	private static final long serialVersionUID = -5965125464424485228L;

	private int id;
	private Produto produto;
	private Fornecedor fornecedor;
	private Set<Categoria> categorias;
	private double quantidade;
	private String descricao;
	private BigDecimal preco_unitario;

	public ProdutoFornecedor() {
	}

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ID_PRODUTO")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ID_FORNECEDOR")
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/*
	 * @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	 *
	 * @JoinTable(name = "ID_CATEGORIA"JoinColumn)
	 */

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PRODUTO_FORNECEDOR_CATEGORIA",
	joinColumns = @JoinColumn(name = "ID_PRODUTO_FORNECEDOR"),
	inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIA"))
	public Set<Categoria> getCategorias() {
		if (categorias == null) {
			categorias = new HashSet<Categoria>();
		}
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Column(name = "QUANTIDADE")
	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "DESCRICAO")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "PRECO_UNITARIO")
	public BigDecimal getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(BigDecimal preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Categoria getItemCategoria(String item) {
	    Set<Categoria> categorias = getCategorias();
		if (categorias != null) {
			for (Categoria categ : categorias) {
				if (categ.getNome().equals(item)) {
					return categ;
				}
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoFornecedor other = (ProdutoFornecedor) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
