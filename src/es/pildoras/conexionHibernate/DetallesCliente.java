package es.pildoras.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="detalles_cliente")
public class DetallesCliente {
	
	private int id;
	private String web;
	private String telefono;
	private String comentarios;
	private Cliente cliente;
	
	public DetallesCliente() {
	}

	public DetallesCliente(String web, String telefono, String comentarios) {
		this.web = web;
		this.telefono = telefono;
		this.comentarios = comentarios;
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

	@Column(name="web")
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Column(name="tfno")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="comentarios")
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "DetallesCliente [id=" + id + ", web=" + web + ", telefono=" + telefono + ", comentarios=" + comentarios
				+ ", cliente=" + cliente + "]";
	}
}
