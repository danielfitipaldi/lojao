package br.unit.lojaoDasPecas.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unit.lojaoDasPecas.entidades.Cliente;
import br.unit.lojaoDasPecas.entidades.Vendedor;

public class ClienteDAO {
	static Session session;

	public void inserir(Cliente cliente) {
		Transaction transaction = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();
			session.saveOrUpdate(cliente);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public List<Cliente> getClientes() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Cliente", Cliente.class).list();
		}
	}

	public void atualizar(Cliente cliente) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(cliente);
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

	public void deletar(Cliente cliente) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(cliente);

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

	public Cliente procurar(String cpf) {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";

			Query query = session.createQuery(hql, Cliente.class);
			query.setParameter("cpf", cpf);

			Cliente cliente = (Cliente) query.getSingleResult();

			session.close();

			return cliente;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public Cliente procurarNome(String nome) {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			String hql = "SELECT c FROM Cliente c WHERE c.nome = :nome";

			Query query = session.createQuery(hql, Cliente.class);
			query.setParameter("nome", nome);

			Cliente cliente = (Cliente) query.getSingleResult();

			session.close();

			return cliente;

		} catch (Exception e) {

		}
		return null;

	}

}
