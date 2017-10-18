package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Funcionario;

public interface FuncionarioDAO {

	// Método para criar um usuário na base de dados (INSERT)
    Funcionario create(Funcionario pFuncionario);

    // Método para recuperar um usuário da base de dados (SELECT)
    Funcionario recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    Funcionario update(Funcionario pFuncionario);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);

    // Método para pesquisar todos os usuários da base de dados
    List<Funcionario> search();

    // Método para pesquisar por nome todos os usuários da base de dados
    List<Funcionario> searchByFuncionario(String pFuncionario);

    // Método para pesquisar por email todos os usuários da base de dados
    List<Funcionario> searchByAtivo(char pAtivo);

}
