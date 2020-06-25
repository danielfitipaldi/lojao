package br.unit.lojaoDasPecas.repository;

import java.util.List;

import org.hibernate.Session;

import br.unit.lojaoDasPecas.entidades.MaisVendidos;

public class MaisVendidosDAO {
static Session session;
	
	public List<MaisVendidos> getConsulta() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from MaisVendidos").list();
			 
		} catch(Exception sqlException) {
            if(null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
            return null;
        } finally {
            if(session != null) {
            	session.close();
            }
        }
	}

}
