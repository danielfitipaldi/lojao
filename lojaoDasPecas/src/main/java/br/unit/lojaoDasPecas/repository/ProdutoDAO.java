package br.unit.lojaoDasPecas.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unit.lojaoDasPecas.entidades.Produto;

public class ProdutoDAO {
	static Session session;

	public void inserir(Produto produto) {
		Transaction transaction = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();
			session.saveOrUpdate(produto);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void editar(Produto produto) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(produto);
			session.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deletar(Produto produto) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(produto);

			session.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public Produto procurar(String nome) {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "SELECT p FROM Produto p WHERE p.nome = :nome";
			
			Query query = session.createQuery(hql, Produto.class);
			query.setParameter("nome", nome);
			
			Produto produto = (Produto) query.getSingleResult();
			
			session.close();
			
			return produto;
			
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		}
		return null;
		
	}
	public List<Produto> getProdutos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Produto", Produto.class).list();
		}
	}

}
