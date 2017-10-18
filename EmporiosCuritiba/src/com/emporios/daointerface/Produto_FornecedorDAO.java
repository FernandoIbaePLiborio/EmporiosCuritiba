package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Produto_Fornecedor;

public interface Produto_FornecedorDAO {

	// M�todo para criar um usu�rio na base de dados (INSERT)
    Produto_Fornecedor create(Produto_Fornecedor pProduto_Fornecedor);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    Produto_Fornecedor recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    Produto_Fornecedor update(Produto_Fornecedor pProduto_Fornecedor);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<Produto_Fornecedor> search();
    
    // M�todo para recuperar todos os produtos pertencentes ao Fornecedor
    List<Produto_Fornecedor> produtosFornecedor(int pFornecedor);
    
    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<Produto_Fornecedor> buscaPorCategoria(String pProduto_Categoria);

    // M�todo para pesquisar por email todos os usu�rios da base de dados
    List<Produto_Fornecedor> searchByProduto_Fornecedor(String pProduto_Fornecedor);

	List<Produto_Fornecedor> quantidadeVendaSemanal();

	List<Produto_Fornecedor> produtoPorFornecedor();

}
