package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Endereco;


public interface EnderecoDAO {
	
	// Método para criar um usuário na base de dados (INSERT)
    Endereco create(Endereco pEndereco);

    // Método para recuperar um usuário da base de dados (SELECT)
    Endereco recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    Endereco update(Endereco pEndereco);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);

    // Método para pesquisar todos os usuários da base de dados
    List<Endereco> search();

    // Método para pesquisar por nome todos os usuários da base de dados
    List<Endereco> searchByRua(String pRua);

    // Método para pesquisar por email todos os usuários da base de dados
    List<Endereco> searchByCep(String pCep);

}
