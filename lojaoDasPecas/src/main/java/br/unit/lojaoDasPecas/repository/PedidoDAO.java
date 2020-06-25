package br.unit.lojaoDasPecas.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unit.lojaoDasPecas.entidades.Pedido;



public class PedidoDAO {	
	static Session session;

	public void inserir(Pedido pedido) {
		Transaction transaction = null;
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			transaction = session.beginTransaction();
			session.saveOrUpdate(pedido);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	
	public List<Pedido> listarPedidos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Pedido", Pedido.class).list();
		}
	}
	
	
	public void editar(Pedido pedido) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(pedido);
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
	
	public void deletar(Pedido pedido) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(pedido);

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
	
	public Pedido procurar(Integer idPedido) {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String hql = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido";

			Query query = session.createQuery(hql, Pedido.class);
			query.setParameter("idPedido", idPedido);

			Pedido pedido = (Pedido) query.getSingleResult();

			session.close();

			return pedido;

		} catch (Exception e) {

		}
		return null;
	}
}
