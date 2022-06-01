package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;

@Service
public class AlumnoServiceImp implements IAlumnoService {

	@Autowired
	private ListaAlumno listaAlumno;
	
	@Override
	public Alumno getAlumno()
	{
		return new Alumno();
	}
	
	@Override
	public ListaAlumno getLista()
	{
		return listaAlumno;
	}
	
	@Override
	public boolean agregarAlumno(Alumno alumno)
	{
		return listaAlumno.getAlumnos().add(alumno);
	}
	@Override
	public Alumno buscarAlumno(int dni)
	{
		Optional<Alumno> alumno = listaAlumno.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
		return alumno.get();
	}
	
	@Override
	public boolean modificarAlumno(Alumno alumno)
	{
		for(Alumno alu: listaAlumno.getAlumnos() )
		{
			if(alu.getDni() == alumno.getDni())
			{
				alu.setApellido(alumno.getApellido());
				alu.setEmail(alumno.getEmail());
				alu.setNombre(alumno.getNombre());
				alu.setTelefono(alumno.getTelefono());
				return true;
			}
			
		}
		return false;
	}

	@Override
	public boolean eliminarAlumno(int dni)
	{ 
		for(Alumno alu: listaAlumno.getAlumnos() )
		{
			if(alu.getDni() == dni)
			{
				listaAlumno.getAlumnos().remove(listaAlumno.getAlumnos().indexOf(alu));
				return true; 
			}
		}
		
		return false;
		
	}
	
	
}
