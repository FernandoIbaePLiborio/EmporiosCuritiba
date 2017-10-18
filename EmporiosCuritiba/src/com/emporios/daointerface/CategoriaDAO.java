package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Categoria;

public interface CategoriaDAO {

	// Método para criar um usuário na base de dados (INSERT)
    Categoria create(Categoria pCategoria);

    // Método para recuperar um usuário da base de dados (SELECT)
    Categoria recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    Categoria update(Categoria pCategoria);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);

    // Método para pesquisar todos os usuários da base de dados
    List<Categoria> search();

    // Método para pesquisar por nome todos os usuários da base de dados
    List<Categoria> searchByNome(String pNome);
}
