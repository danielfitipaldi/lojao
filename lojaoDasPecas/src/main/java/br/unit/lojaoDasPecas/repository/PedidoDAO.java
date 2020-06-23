package br.unit.lojaoDasPecas.repository;

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

}
