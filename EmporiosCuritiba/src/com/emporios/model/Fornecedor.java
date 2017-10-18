package com.emporios.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "FORNECEDOR")
public class Fornecedor implements Serializable, Cloneable {

	private static final long serialVersionUID = -5965125464424485228L;

	public int id;
	private Autenticacao autenticacao;
	public String companhia;
	public String cnpj;
	public String contato;
	public String foto;
	public String fone;
	public String homepg;
	private List<Funcionario> funcionarios;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ID_USUARIO")
	public Autenticacao getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Autenticacao autenticacao) {
		this.autenticacao = autenticacao;
	}

	@Column(name = "COMPANHIA")
	public String getCompanhia() {
		return companhia;
	}

	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}

	@Column(name = "CNPJ")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "CONTATO")
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Column(name = "FOTO")
	public String getCargo() {
		return foto;
	}

	public void setCargo(String foto) {
		this.foto = foto;
	}

	@Column(name = "FONE")
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Column(name = "HOMEPG")
	public String getHomepg() {
		return homepg;
	}

	public void setHomepg(String homepg) {
		this.homepg = homepg;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> pFuncionarios) {
		funcionarios = pFuncionarios;
	}

}
