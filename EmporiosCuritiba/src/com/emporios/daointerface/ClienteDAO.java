package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Cliente;

public interface ClienteDAO {

	// M�todo para criar um usu�rio na base de dados (INSERT)
	Cliente create(Cliente pCliente);

	// M�todo para recuperar um usu�rio da base de dados (SELECT)
	Cliente recovery(int id);

	// M�todo para atualizar um usu�rio na base de dados (UPDATE)
	Cliente update(Cliente pCliente);

	// M�todo para deletar um usu�rio na base de dados (DELETE)
	boolean delete(int id);

	// M�todo para pesquisar todos os usu�rios da base de dados
	List<Cliente> search();

	// M�todo para pesquisar por nome todos os usu�rios da base de dados
	List<Cliente> searchByNome(String pNome);

	// M�todo para pesquisar por email todos os usu�rios da base de dados
	List<Cliente> searchByCpf(String pCpf);

	/*// Verifica se usuario logado ja possui cadastro cliente.
	Cliente logar(Cliente pCliente);*/
}
