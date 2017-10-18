package com.emporios.daointerface;

import com.emporios.dao.hibernate.AutenticacaoHibernateDAO;
import com.emporios.dao.hibernate.CategoriaHibernateDAO;
import com.emporios.dao.hibernate.ClienteHibernateDAO;
import com.emporios.dao.hibernate.EnderecoHibernateDAO;
import com.emporios.dao.hibernate.FornecedorHibernateDAO;
import com.emporios.dao.hibernate.FuncionarioHibernateDAO;
import com.emporios.dao.hibernate.ProdutoHibernateDAO;
import com.emporios.dao.hibernate.ProdutoFornecedorHibernateDAO;

public class DaoFactory {
	
    public static AutenticacaoDAO getAutenticacaoDAO() {
        return new AutenticacaoHibernateDAO();
    }

    public static FornecedorDAO getFornecedorDAO() {
        return new FornecedorHibernateDAO();
    }

    public static EnderecoDAO getEnderecoDAO() {
        return new EnderecoHibernateDAO();
    }

    public static ClienteDAO getClienteDAO() {
        return new ClienteHibernateDAO();
    }

    public static FuncionarioDAO getFuncionarioDAO() {
        return new FuncionarioHibernateDAO();
    }

    public static CategoriaDAO getCategoriaDAO() {
        return new CategoriaHibernateDAO();
    }
    
    public static ProdutoDAO getProdutoDAO() {
        return new ProdutoHibernateDAO();
    }
    
    public static ProdutoFornecedorDAO getProduto_FornecedorDAO() {
        return new ProdutoFornecedorHibernateDAO();
    }
}
