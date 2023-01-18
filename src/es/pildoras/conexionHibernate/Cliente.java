package es.pildoras.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String direccion;
	
	public Cliente() {
	}

	public Cliente(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	@Id
	@Column(name="Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="Nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="Apellido")
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name="Direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}
	
	
}
