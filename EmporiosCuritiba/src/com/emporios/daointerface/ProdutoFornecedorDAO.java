package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.ProdutoFornecedor;

public interface ProdutoFornecedorDAO {

	// M�todo para criar um usu�rio na base de dados (INSERT)
    ProdutoFornecedor create(ProdutoFornecedor pProduto_Fornecedor);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    ProdutoFornecedor recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    ProdutoFornecedor update(ProdutoFornecedor pProduto_Fornecedor);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<ProdutoFornecedor> search();
    
    // M�todo para recuperar todos os produtos pertencentes ao Fornecedor
    List<ProdutoFornecedor> produtosFornecedor(int pFornecedor);
    
    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<ProdutoFornecedor> buscaPorCategoria(String pProduto_Categoria);

    // M�todo para pesquisar por email todos os usu�rios da base de dados
    List<ProdutoFornecedor> searchByProduto_Fornecedor(String pProduto_Fornecedor);

	List<ProdutoFornecedor> quantidadeVendaSemanal();

	List<ProdutoFornecedor> produtoPorFornecedor();

}
