package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Produto_Fornecedor;

public interface Produto_FornecedorDAO {

	// Método para criar um usuário na base de dados (INSERT)
    Produto_Fornecedor create(Produto_Fornecedor pProduto_Fornecedor);

    // Método para recuperar um usuário da base de dados (SELECT)
    Produto_Fornecedor recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    Produto_Fornecedor update(Produto_Fornecedor pProduto_Fornecedor);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);

    // Método para pesquisar todos os usuários da base de dados
    List<Produto_Fornecedor> search();
    
    // Método para recuperar todos os produtos pertencentes ao Fornecedor
    List<Produto_Fornecedor> produtosFornecedor(int pFornecedor);
    
    // Método para pesquisar por nome todos os usuários da base de dados
    List<Produto_Fornecedor> buscaPorCategoria(String pProduto_Categoria);

    // Método para pesquisar por email todos os usuários da base de dados
    List<Produto_Fornecedor> searchByProduto_Fornecedor(String pProduto_Fornecedor);

	List<Produto_Fornecedor> quantidadeVendaSemanal();

	List<Produto_Fornecedor> produtoPorFornecedor();

}
