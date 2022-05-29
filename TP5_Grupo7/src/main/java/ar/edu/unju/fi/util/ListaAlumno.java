package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Alumno;


public class ListaAlumno {
	
		private ArrayList<Alumno> alumnos;
		
		public ListaAlumno() {
		
			alumnos = new ArrayList<Alumno>();
			
			alumnos.add(new Alumno(45124378,"Alonso Alamo","Barreiro","alonsobarreirol@mail.com","3884259626"));
			alumnos.add(new Alumno(21459650,"Eduard Soriano","Rovira","edrovira@mail.com","3882138356"));
			alumnos.add(new Alumno(30487130,"Aurelio Hidalgo","Robledo","auhidalgo@mail.com","3884005452"));
			alumnos.add(new Alumno(47904329,"Adan Pineda","Llorens","pineda@mail.com","3885601412"));
		}
		
		
		
		public ArrayList<Alumno> getAlumnos() {
			return alumnos;
		}

		public void setAlumnos(ArrayList<Alumno> alumnos) {
			this.alumnos = alumnos;
		}
		
		

	}


