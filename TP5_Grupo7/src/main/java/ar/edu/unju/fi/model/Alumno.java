package ar.edu.unju.fi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Alumno {
	@Min(value=1000000 ,message="el dni debe ser mayor a 1000000")
	private int dni;
	@NotEmpty(message="El nombre no puede estar vacío")
	private String nombre;
	@NotEmpty(message="El apellido no puede estar vacío")
	private String apellido;
	@NotEmpty @Email
	private String email;
	@NotEmpty(message = "el telefono no puede estar vacío")
	private String telefono;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
