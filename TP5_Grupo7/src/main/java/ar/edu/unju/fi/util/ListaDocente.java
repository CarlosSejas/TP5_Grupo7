package ar.edu.unju.fi.util;

import java.util.ArrayList;
import java.util.Optional;

import ar.edu.unju.fi.model.Docente;


public class ListaDocente {
private ArrayList<Docente> docentes;
	
	public ListaDocente() {
	
		docentes = new ArrayList<Docente>();
		docentes.add(new Docente(100,"Luciana", "Moron","lmoron@mail.com","3885409562"));
		docentes.add(new Docente(101,"Braulio","Lamas","blamas@mail.com","3884812010"));
		docentes.add(new Docente(102,"Javi" ,"Carbonell","javicar@mail.com","3886030130"));
		docentes.add(new Docente(103,"Edurne","Gaspar","edugaspar@mail.com","3885491279"));
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
	
	public Docente buscarDocente(int legajo) {
		Optional<Docente> docente = getDocentes().stream().filter(d -> d.getLegajo() == legajo).findFirst();
		return docente.get();
	}
	
}
