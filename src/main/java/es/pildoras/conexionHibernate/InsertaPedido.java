package es.pildoras.conexionHibernate;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class InsertaPedido {

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
			
			//forma alternativa si el cliente tiene fetchtype lazy
//			Query<Cliente> consulta = session.createQuery("SELECT cl FROM cliente cl JOIN FETCH cl.pedidos WHERE cl.id=:elClienteId",Cliente.class);
//			consulta.setParameter("elClienteId", 1);
//			Cliente cliente1 = consulta.getSingleResult();
			
			//Agregar pedido
			Pedido pedido1 = new Pedido(Date.from(LocalDate.of(2022, 1, 15).atStartOfDay().toInstant(ZoneOffset.ofHours(-3))));
			cliente1.agregarPedido(pedido1);
			session.save(pedido1);
			
			session.getTransaction().commit();
			
			//consulta pedidos
			System.out.println(cliente1.getPedidos());
			
			session.close();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
			factory.close();
		}
	}

}
