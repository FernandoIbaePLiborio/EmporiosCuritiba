package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Produto;

public interface ProdutoDAO {

	// M�todo para criar um usu�rio na base de dados (INSERT)
    Produto create(Produto pProduto);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    Produto recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    Produto update(Produto pProduto);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<Produto> search();

    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<Produto> searchByNome(String pNome);
}
