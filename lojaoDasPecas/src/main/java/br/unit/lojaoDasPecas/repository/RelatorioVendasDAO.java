package br.unit.lojaoDasPecas.repository;

import java.util.List;

import org.hibernate.Session;

import br.unit.lojaoDasPecas.entidades.RelatorioVendas;



public class RelatorioVendasDAO {
static Session session;
	
	public List<RelatorioVendas> getConsulta() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from RelatorioVendas").list();
			 
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
