package com.emporios.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the forma_pagamento database table.
 * 
 */
@Entity
@Table(name="forma_pagamento")
@NamedQuery(name="FormaPagamento.findAll", query="SELECT f FROM FormaPagamento f")
public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	public FormaPagamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}