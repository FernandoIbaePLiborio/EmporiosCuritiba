package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Fornecedor;

public interface FornecedorDAO {
	
	// Método para criar um usuário na base de dados (INSERT)
    Fornecedor create(Fornecedor pFornecedor);

    // Método para recuperar um usuário da base de dados (SELECT)
    Fornecedor recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    Fornecedor update(Fornecedor pFornecedor);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);

    // Método para pesquisar todos os usuários da base de dados
    List<Fornecedor> search();

    // Método para pesquisar por nome todos os usuários da base de dados
    List<Fornecedor> searchByCompanhia(String pCompanhia);

    // Método para pesquisar por email todos os usuários da base de dados
    List<Fornecedor> searchByCnpj(String pCnpj);

}
