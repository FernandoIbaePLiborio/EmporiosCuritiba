package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.AutenticacaoDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Autenticacao;
import com.emporios.util.ExceptionUtil;

public class AutenticacaoHibernateDAO implements AutenticacaoDAO {

	@Override
	public Autenticacao create(Autenticacao pAutenticacao) {
		try {
			pAutenticacao.setNivel('C');
			pAutenticacao.setDataCadastro(new Date());
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.save(pAutenticacao);
			tSessao.flush();
			return pAutenticacao;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação");
		}
		return null;
	}

	@Override
	public Autenticacao recovery(int pId) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query query = tSessao.createQuery("select a from Autenticacao a where a.id = :pId");
			query.setParameter("pId", pId);
			Autenticacao tAutenticacao = (Autenticacao) query.uniqueResult();
			return tAutenticacao;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação");
		}
		return null;
	}

	// Método para atualizar um autenticacao na base de dados (UPDATE)
	@Override
	public Autenticacao update(Autenticacao pAutenticacao) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.merge(pAutenticacao);
			tSessao.flush();
			return pAutenticacao;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização");
		}
		return null;
	}

	// Método para deletar um autenticacao na base de dados (DELETE)

	@Override
	public boolean delete(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.delete(tSessao.get(Autenticacao.class, pMatricula));
			tSessao.flush();
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do autenticacao");
		}

		return false;
	}

	// Método para pesquisar todos os usuários da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> search() {
		List<Autenticacao> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query tQuery = tSessao.createQuery("FROM AUTENTICACAO");
			tLista = tQuery.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de autenticacao");
		}

		return tLista;
	}

	// Método para pesquisar por nome todos os autenticacaos da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> searchByNome(String pNome) {
		String tNomePesquisa = "%" + pNome.toUpperCase() + "%";

		List<Autenticacao> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Criteria tCriterio = tSessao.createCriteria(Autenticacao.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> searchByEmail(String pEmail) {
		List<Autenticacao> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Criteria tCriterio = tSessao.createCriteria(Autenticacao.class)
					.add(Restrictions.like("email", pEmail).ignoreCase());
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista.");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> validar(Autenticacao pAutenticacao) {
		List<Autenticacao> tLista = new ArrayList<>();
		SessionFactory tFactory = HibernateUtil.getSessionFactory();
		Session tSessao = tFactory.getCurrentSession();
		Criteria tCriterio = tSessao.createCriteria(Autenticacao.class);
		tCriterio.add(Restrictions.eq("email", pAutenticacao.getEmail()));
		tCriterio.add(Restrictions.eq("senha", pAutenticacao.getSenha()));
		tCriterio.uniqueResult();
		pAutenticacao = null;
		tLista = tCriterio.list();
		return tLista;
	}
}
