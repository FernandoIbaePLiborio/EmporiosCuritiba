package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Produto;

public interface ProdutoDAO {

	// Método para criar um usuário na base de dados (INSERT)
    Produto create(Produto pProduto);

    // Método para recuperar um usuário da base de dados (SELECT)
    Produto recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    Produto update(Produto pProduto);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);

    // Método para pesquisar todos os usuários da base de dados
    List<Produto> search();

    // Método para pesquisar por nome todos os usuários da base de dados
    List<Produto> searchByNome(String pNome);
}
