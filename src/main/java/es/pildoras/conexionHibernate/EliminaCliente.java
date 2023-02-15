package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

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
			
			Cliente cliente1 = session.get(Cliente.class, 2);
			if(cliente1 != null) {
				session.delete(cliente1);
				System.out.println("registro eliminado correctamente");
			}else {
				System.out.println("el registro no existe");				
			}
			
			session.getTransaction().commit();
			session.close();
		} finally {
			factory.close();
		}
	}

}
