package br.unit.lojaoDasPecas.repository;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.unit.lojaoDasPecas.entidades.Cliente;
import br.unit.lojaoDasPecas.entidades.Comissao;
import br.unit.lojaoDasPecas.entidades.ConsultaProduto;
import br.unit.lojaoDasPecas.entidades.ConsultaVendas;
import br.unit.lojaoDasPecas.entidades.MaisVendidos;
import br.unit.lojaoDasPecas.entidades.Pedido;
import br.unit.lojaoDasPecas.entidades.Produto;
import br.unit.lojaoDasPecas.entidades.RelatorioVendas;
import br.unit.lojaoDasPecas.entidades.Vendedor;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=lojao");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "yourStrong(!)Password");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(Vendedor.class);
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(ConsultaProduto.class);
				configuration.addAnnotatedClass(Pedido.class);
				configuration.addAnnotatedClass(ConsultaVendas.class);
				configuration.addAnnotatedClass(RelatorioVendas.class);
				configuration.addAnnotatedClass(MaisVendidos.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}