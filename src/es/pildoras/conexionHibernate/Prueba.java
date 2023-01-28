package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Prueba {

	public static void main(String[] args) {
		
		//Crear el registro de servicio que leera el archivo xml de configuracion
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		//Crear la sessionFactory utilizando un objeto metadata
		Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		SessionFactory factory = meta.buildSessionFactory();
		
		//inicia la sesion que permitira modificar la DB
		Session session = factory.openSession();
		try {
			Cliente cliente1 = new Cliente("Julieta","Sosa","casa 1235"); //Creo un cliente para agregar
			session.beginTransaction();	//comienza la transaccion
			session.save(cliente1); //agrego al cliente
			session.getTransaction().commit(); //Si todo salio bien confirmo los cambios
			System.out.println("Registro insertado correctamente en DB");
			
			//Lectura de registro
			session.beginTransaction();
			System.out.println("Lectura de registro con Id: "+ cliente1.getId());
			Cliente clienteInsertado=session.get(Cliente.class, cliente1.getId());
			System.out.println("Registro: "+ clienteInsertado);
			session.getTransaction().commit();
			
			session.close();
		} finally {
			factory.close();
		}
	}

}
