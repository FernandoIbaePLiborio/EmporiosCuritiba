package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.ClienteDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Cliente;
import com.emporios.util.ExceptionUtil;

public class ClienteHibernateDAO implements ClienteDAO {

	@Override
	public Cliente create(Cliente pCliente) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pCliente);
			tSessao.flush();

			return pCliente;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Cliente");
		}

		return null;
	}

	@Override
	public Cliente recovery(int pId) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Cliente tCliente = (Cliente) tSessao.get(Cliente.class, pId);
			return tCliente;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Cliente");
		}
		return null;
	}

	@Override
	public Cliente update(Cliente pCliente) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.merge(pCliente);
			tSessao.flush();
			return pCliente;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Cliente");
		}
		return null;
	}

	@Override
	public boolean delete(int pId) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.delete(tSessao.get(Cliente.class, pId));
			tSessao.flush();
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Cliente");
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> search() {
		List<Cliente> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query tQuery = tSessao.createQuery("FROM CLIENTE");
			tLista = tQuery.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de CLIENTE");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> searchByNome(String pNome) {
		String tNomePesquisa = "%" + pNome.toUpperCase() + "%";
		List<Cliente> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Criteria tCriterio = tSessao.createCriteria(Cliente.class).add(Restrictions.like("nome", tNomePesquisa).ignoreCase());
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Companhia");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> searchByCpf(String pCpf) {
		String tCpfPesquisa = "%" + pCpf + "%";
		List<Cliente> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Criteria tCriterio = tSessao.createCriteria(Cliente.class).add(Restrictions.like("CPF", tCpfPesquisa).ignoreCase());
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Cnpj");
		}
		return tLista;
	}

/*	@Override
	public Cliente logar(Cliente pCliente) {
		Cliente cliente = new Cliente();
		cliente.setAutenticacao(pCliente.getAutenticacao());
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.getTransaction().toString();
			cliente = (Cliente) tSessao.get(Cliente.class, pCliente.getAutenticacao().getId());
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Cliente");
		}
		return cliente;
	}*/
}
