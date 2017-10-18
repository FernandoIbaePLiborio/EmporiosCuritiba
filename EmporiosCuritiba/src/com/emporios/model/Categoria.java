package com.emporios.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CATEGORIA")
public class Categoria implements Serializable, Cloneable {

	private static final long serialVersionUID = -476427518987927494L;

	private int id;
	private String nome;
	private String foto;

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

    @Override
	public String toString() {
		StringBuilder tBuilder = new StringBuilder();
		tBuilder.append(id);
		tBuilder.append(", ");
		tBuilder.append(nome);
		tBuilder.append(", ");
		tBuilder.append(foto);
		tBuilder.append(", ");
		return tBuilder.toString();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
