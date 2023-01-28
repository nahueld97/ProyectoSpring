package es.pildoras.conexionHibernate;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
	
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private DetallesCliente detallesCliente;
	private List<Pedido> pedidos;
	
	public Cliente() {
		this.pedidos = new LinkedList<Pedido>();
	}

	public Cliente(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellido = apellidos;
		this.direccion = direccion;
		this.pedidos = new LinkedList<Pedido>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="apellido")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellidos) {
		this.apellido = apellidos;
	}

	@Column(name="direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellido + ", direccion=" + direccion
				+ "]";
	}
	
	@OneToOne(mappedBy = "cliente",cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	public DetallesCliente getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(DetallesCliente detallesCliente) {
		this.detallesCliente = detallesCliente;
	}
	
	@OneToMany(mappedBy = "cliente",cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
		pedido.setCliente(this);
	}
}
