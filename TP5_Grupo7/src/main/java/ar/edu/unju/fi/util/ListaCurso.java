package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Curso;

public class ListaCurso {

	private ArrayList<Curso> cursos;
	
	public ListaCurso() {
	
		ListaDocente listaDocente = new ListaDocente();
		
		
		cursos = new ArrayList<Curso>();
		cursos.add(new Curso(1,"C++ basico","Desarrollo",LocalDate.now(),LocalDate.of(2022, 12, 12),20,"virtual",listaDocente.getDocentes().get(0)));
		cursos.add(new Curso(2,"Ingles","Idioma",LocalDate.now(),LocalDate.of(2022, 9, 12),25,"virtual",listaDocente.getDocentes().get(1)));
	}

	public ArrayList<Curso> getCurso(){
		return cursos;
	}
	
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
	
}
