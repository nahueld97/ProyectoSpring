package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ObtenerCliente {

	public static void main(String[] args) {
		
		//Crear el registro de servicio que leera el archivo xml de configuracion
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate_relacionesHibernate.cfg.xml").build();
		//Crear la sessionFactory utilizando un objeto metadata
		Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		SessionFactory factory = meta.buildSessionFactory();
		
		//inicia la sesion que permitira modificar la DB
		Session session = factory.openSession();
		try {
			
			session.beginTransaction();
			
			DetallesCliente detallesCliente1 = session.get(DetallesCliente.class, 1);
			System.out.println(detallesCliente1);
			System.out.println(detallesCliente1.getCliente());	
			
			session.getTransaction().commit();
			session.close();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
			factory.close();
		}
	}

}
