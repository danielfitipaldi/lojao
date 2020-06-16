package br.unit.lojaoDasPecas.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unit.lojaoDasPecas.entidades.Vendedor;

public class VendedorDAO {
	static Session session;

	public void inserir(Vendedor vendedor) {
		Transaction transaction = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();
			session.saveOrUpdate(vendedor);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public List<Vendedor> getVendedores() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Vendedor", Vendedor.class).list();
		}
	}

	public void atualizar(Vendedor vendedor) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(vendedor);
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

	public void deletar(Vendedor vendedor) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(vendedor);

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

	public Vendedor procurar(String cpf) {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String hql = "SELECT f FROM Vendedor f WHERE f.cpf = :cpf";

			Query query = session.createQuery(hql, Vendedor.class);
			query.setParameter("cpf", cpf);

			Vendedor vendedor = (Vendedor) query.getSingleResult();

			session.close();

			return vendedor;

		} catch (Exception e) {

		}
		return null;

	}

}