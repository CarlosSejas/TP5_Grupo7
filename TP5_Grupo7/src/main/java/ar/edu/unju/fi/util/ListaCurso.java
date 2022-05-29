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
		cursos.add(new Curso(3,"Base de datos","Desarrollo",LocalDate.of(2022, 7, 22),LocalDate.of(2022, 11, 1),200,"Virtual",listaDocente.getDocentes().get(2)));
		cursos.add(new Curso(4,"C++ Básico","Desarrollo",LocalDate.of(2022, 6, 15),LocalDate.of(2022, 10, 15),300,"Presencial",listaDocente.getDocentes().get(3)));
	}

	public ArrayList<Curso> getCurso(){
		return cursos;
	}
	
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
	
}
