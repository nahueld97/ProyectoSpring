package es.pildoras.conexionHibernate;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	private int id;
	private Date fecha;
	private String formaPago;
	private Cliente cliente;
	
	public Pedido() {
		super();
	}

	public Pedido(Date fecha) {
		super();
		this.fecha = fecha;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "forma_pago")
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	@JoinColumn(name = "cliente_id")
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id= "+ id +", fecha=" + fecha + ", formaPago=" + formaPago + "]";
	}

}
