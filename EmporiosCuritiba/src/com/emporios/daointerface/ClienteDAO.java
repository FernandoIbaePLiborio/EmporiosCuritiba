package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Cliente;

public interface ClienteDAO {

	// Método para criar um usuário na base de dados (INSERT)
	Cliente create(Cliente pCliente);

	// Método para recuperar um usuário da base de dados (SELECT)
	Cliente recovery(int id);

	// Método para atualizar um usuário na base de dados (UPDATE)
	Cliente update(Cliente pCliente);

	// Método para deletar um usuário na base de dados (DELETE)
	boolean delete(int id);

	// Método para pesquisar todos os usuários da base de dados
	List<Cliente> search();

	// Método para pesquisar por nome todos os usuários da base de dados
	List<Cliente> searchByNome(String pNome);

	// Método para pesquisar por email todos os usuários da base de dados
	List<Cliente> searchByCpf(String pCpf);

	/*// Verifica se usuario logado ja possui cadastro cliente.
	Cliente logar(Cliente pCliente);*/
}
