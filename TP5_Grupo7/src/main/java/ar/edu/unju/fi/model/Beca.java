package ar.edu.unju.fi.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Beca {

	@Min(value=1, message="El valor mínimo permitido es 1") @Max(value=9999,message="El valor máximo permitido es 9999")
	private int codigo;
	@NotNull(message="Debe seleccionar un curso")
	private Curso curso;
	@NotNull(message="debe ingresar una fecha") @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate finicio;
	@NotNull(message="debe ingresar una fecha") @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fcierre;
	@NotEmpty(message="Estado no puede ser vacío")
	private String estado;
	
	public Beca() {
		// TODO Auto-generated constructor stub
	}

	public Beca(int codigo, Curso curso, LocalDate finicio, LocalDate fcierre, String estado) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.finicio = finicio;
		this.fcierre = fcierre;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFinicio() {
		return finicio;
	}

	public void setFinicio(LocalDate finicio) {
		this.finicio = finicio;
	}

	public LocalDate getFcierre() {
		return fcierre;
	}

	public void setFcierre(LocalDate fcierre) {
		this.fcierre = fcierre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
