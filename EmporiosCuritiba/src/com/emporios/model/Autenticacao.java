package com.emporios.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "AUTENTICACAO")
public class Autenticacao implements Serializable, Cloneable {

	private static final long serialVersionUID = -476427518987927494L;

	private int id;
	private String email;
	private String senha;
	private char nivel;
	private Date dataCadastro;
	private List<Endereco> enderecos;

	public Autenticacao() {
		super();
	}

	public Autenticacao(int id, String email, String senha, List<Endereco> enderecos) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.enderecos = enderecos;
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

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SENHA")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autenticacao")
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Column(name = "NIVEL")
	public char getNivel() {
		return nivel;
	}

	public void setNivel(char nivel) {
		this.nivel = nivel;
	}

	@Column(name = "DATA_CADASTRO")
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((id == null) ? 0 : id.hashCode()); return
	 * result; }
	 */

}
