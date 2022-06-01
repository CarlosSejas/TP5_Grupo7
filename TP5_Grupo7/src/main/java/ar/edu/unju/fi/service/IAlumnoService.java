package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;

public interface IAlumnoService {

	public Alumno getAlumno();
	public ListaAlumno getLista();
	public boolean agregarAlumno(Alumno alumno);
	public Alumno buscarAlumno(int dni);
	public boolean modificarAlumno(Alumno alumno);
	public boolean eliminarAlumno(int dni);
	
}
