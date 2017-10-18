package com.emporios.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "FUNCIONARIO")
public class Funcionario implements Serializable, Cloneable {

	private static final long serialVersionUID = -5965125464424485228L;

	private int id;
	private Autenticacao autenticacao;
	private Fornecedor fornecedor;
	private String nome;
	private String sobrenome;
	private String cpf;
	private Date data_contrato;
	private Date data_nascimento;
	private String cargo;
	private char ativo;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ID_USUARIO")
	public Autenticacao getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Autenticacao autenticacao) {
		this.autenticacao = autenticacao;
	}

	@ManyToOne
	@JoinColumn(name = "ID_FORNECEDOR")
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor pFornecedor) {
		fornecedor = pFornecedor;
	}

	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String pNome) {
		nome = pNome;
	}

	@Column(name = "SOBRENOME")
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String pSobrenome) {
		sobrenome = pSobrenome;
	}

	@Column(name = "CPF")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String pCpf) {
		cpf = pCpf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CONTRATO")
	public Date getData_contrato() {
		return data_contrato;
	}

	public void setData_contrato(Date pData_contrato) {
		data_contrato = pData_contrato;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_NASC")
	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date pData_nascimento) {
		data_nascimento = pData_nascimento;
	}

	@Column(name = "CARGO")
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Column(name = "ATIVO")
	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
}
