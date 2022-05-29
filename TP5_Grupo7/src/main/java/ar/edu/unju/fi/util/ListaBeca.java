package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Beca;






public class ListaBeca {
	
	private ArrayList<Beca> becas;
	
	
	public ListaBeca() {
		becas = new ArrayList<Beca>();
		ListaCurso listaCursos = new ListaCurso();
			
		becas.add(new Beca(1, listaCursos.getCurso().get(0),LocalDate.of(2022, 5, 4),LocalDate.of(2022, 5, 9),"aprobado"));
		becas.add(new Beca(2, listaCursos.getCurso().get(1),LocalDate.of(2022, 6, 1),LocalDate.of(2022, 6, 10),"aprobado"));
		becas.add(new Beca(3, listaCursos.getCurso().get(2),LocalDate.of(2022, 5, 3),LocalDate.of(2022, 5, 10),"aprobado"));
		
	}

	/*métodos accesores*/
	public ArrayList<Beca> getBecas() {
		return becas;
	}


	public void setBecas(ArrayList<Beca> becas) {
		this.becas = becas;
	}
	
	

}
