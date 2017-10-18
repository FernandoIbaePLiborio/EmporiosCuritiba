package com.emporios.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_venda database table.
 * 
 */
@Embeddable
public class ItemVendaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pedido", insertable=false, updatable=false)
	private Integer idPedido;

	@Column(name="id_produto", insertable=false, updatable=false)
	private Integer idProduto;

	public ItemVendaPK() {
	}
	public Integer getIdPedido() {
		return this.idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getIdProduto() {
		return this.idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemVendaPK)) {
			return false;
		}
		ItemVendaPK castOther = (ItemVendaPK)other;
		return 
			this.idPedido.equals(castOther.idPedido)
			&& this.idProduto.equals(castOther.idProduto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPedido.hashCode();
		hash = hash * prime + this.idProduto.hashCode();
		
		return hash;
	}
}