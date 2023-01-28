package es.pildoras.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConsultaClientes {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		SessionFactory factory = meta.buildSessionFactory();
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			
			//Consultas SELECT
			
			//Ver todos los clientes
//			List<Cliente> clientes=session.createQuery("from Cliente").getResultList();
//			print(clientes);
			
			//Ver los clientes con apellido Diaz
//			clientes=session.createQuery("from Cliente cl where cl.apellidos='Diaz' ").getResultList();
//			print(clientes);
			
			//Ver los que viven en "casa 1234" o que se apelliden Sosa
//			clientes=session.createQuery(
//			"from Cliente cl where cl.apellidos='Sosa' "+
//			"or cl.direccion='casa 1234'").getResultList();
//			print(clientes);
			
			//Consultas UPDATE
//			int clienteId=1; //Cambiar nombre al id 1
//			Cliente cliente=session.get(Cliente.class, clienteId);
//			cliente.setNombre("Manuel");
			
//			session.createQuery("update Cliente set Apellido='Fernandez' where Apellido LIKE 'D%' ").executeUpdate(); //Cambiar todos los apellidos que comiencen con D por Fernandez
			
			session.createQuery("delete Cliente where Apellido='Sosa' ").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	private static void print(List<Cliente> clientes) {
		for(Cliente cliente:clientes) {
			System.out.println(cliente);
		}
	}

}
