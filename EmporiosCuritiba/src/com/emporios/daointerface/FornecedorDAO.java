package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Fornecedor;

public interface FornecedorDAO {
	
	// M�todo para criar um usu�rio na base de dados (INSERT)
    Fornecedor create(Fornecedor pFornecedor);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    Fornecedor recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    Fornecedor update(Fornecedor pFornecedor);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<Fornecedor> search();

    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<Fornecedor> searchByCompanhia(String pCompanhia);

    // M�todo para pesquisar por email todos os usu�rios da base de dados
    List<Fornecedor> searchByCnpj(String pCnpj);

}
