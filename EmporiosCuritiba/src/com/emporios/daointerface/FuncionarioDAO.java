package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Funcionario;

public interface FuncionarioDAO {

	// M�todo para criar um usu�rio na base de dados (INSERT)
    Funcionario create(Funcionario pFuncionario);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    Funcionario recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    Funcionario update(Funcionario pFuncionario);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<Funcionario> search();

    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<Funcionario> searchByFuncionario(String pFuncionario);

    // M�todo para pesquisar por email todos os usu�rios da base de dados
    List<Funcionario> searchByAtivo(char pAtivo);

}
