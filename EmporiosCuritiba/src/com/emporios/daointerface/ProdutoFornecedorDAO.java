package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.ProdutoFornecedor;

public interface ProdutoFornecedorDAO {

	// Método para criar um usuário na base de dados (INSERT)
    ProdutoFornecedor create(ProdutoFornecedor pProduto_Fornecedor);

    // Método para recuperar um usuário da base de dados (SELECT)
    ProdutoFornecedor recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    ProdutoFornecedor update(ProdutoFornecedor pProduto_Fornecedor);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);

    // Método para pesquisar todos os usuários da base de dados
    List<ProdutoFornecedor> search();
    
    // Método para recuperar todos os produtos pertencentes ao Fornecedor
    List<ProdutoFornecedor> produtosFornecedor(int pFornecedor);
    
    // Método para pesquisar por nome todos os usuários da base de dados
    List<ProdutoFornecedor> buscaPorCategoria(String pProduto_Categoria);

    // Método para pesquisar por email todos os usuários da base de dados
    List<ProdutoFornecedor> searchByProduto_Fornecedor(String pProduto_Fornecedor);

	List<ProdutoFornecedor> quantidadeVendaSemanal();

	List<ProdutoFornecedor> produtoPorFornecedor();

}
