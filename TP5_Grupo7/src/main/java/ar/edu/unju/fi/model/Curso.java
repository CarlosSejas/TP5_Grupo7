package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Curso {

	private int codigo;
	private String titulo;
	private String categoria;
	private LocalDate finicio;
	private LocalDate ffin;
	private int canthoras;
	private String modalidad;
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
