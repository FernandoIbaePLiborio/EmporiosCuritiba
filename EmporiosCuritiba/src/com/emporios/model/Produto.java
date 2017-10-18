package com.emporios.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PRODUTO")
public class Produto implements Serializable, Cloneable {

	private static final long serialVersionUID = -476427518987927494L;

	private int id;
	private String nome;
	private String foto;
	private String descricao;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	public void setId(int pId)
    {
        id = pId;
    }

	@Column(name = "NOME")
	public String getNome()
    {
        return nome;
    }

    public void setNome(String pNome)
    {
        nome = pNome;
    }
    @Column(name = "FOTO")
    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String pFoto)
    {
        foto = pFoto;
    }

    @Column(name = "DESCRICAO")
    public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
