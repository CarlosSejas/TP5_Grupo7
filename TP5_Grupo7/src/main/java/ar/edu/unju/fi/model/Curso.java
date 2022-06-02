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
public class Curso {
	@Min(value=1, message="El valor mínimo es 1") @Max(value=9999,message="El valor máximo permitido es 9999")
	private int codigo;
	@NotEmpty(message="El título no puede ser vacío")
	private String titulo;
	@NotEmpty(message="Categoría no puede ser vacío")
	private String categoria;
	@NotNull @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate finicio;
	@NotNull @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate ffin;
	@Min(value=1,message="Cantidad de horas debe ser mayor a 1")
	private int canthoras;
	@NotEmpty(message="Modalidad no puede ser vacío")
	private String modalidad;
	@NotNull(message="Debe seleccionar un docente")
	private Docente docente;
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	public Curso(int codigo, String titulo, String categoria, LocalDate finicio, LocalDate ffin, int canthoras,
			String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.finicio = finicio;
		this.ffin = ffin;
		this.canthoras = canthoras;
		this.modalidad = modalidad;
		this.docente = docente;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getFinicio() {
		return finicio;
	}
	public void setFinicio(LocalDate finicio) {
		this.finicio = finicio;
	}
	public LocalDate getFfin() {
		return ffin;
	}
	public void setFfin(LocalDate ffin) {
		this.ffin = ffin;
	}
	public int getCanthoras() {
		return canthoras;
	}
	public void setCanthoras(int canthoras) {
		this.canthoras = canthoras;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
}
