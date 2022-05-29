package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Beca {

	private int codigo;
	private Curso curso;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate finicio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fcierre;
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
