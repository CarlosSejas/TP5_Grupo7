package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;
@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	@GetMapping("/nuevo")
	public String getAlumnoPage(Model modelo) {
		modelo.addAttribute("alumno",new Alumno());
		return "nuevo_alumno";
	}
	
@PostMapping("/guardar")
public ModelAndView getListaAlumno(@ModelAttribute("alumno")Alumno alumno)
{
		ModelAndView mav = new ModelAndView("lista_alumnos");
		ListaAlumno lista = new ListaAlumno();
		lista.getAlumnos().add(alumno);
		mav.addObject("lista",lista.getAlumnos());
		return mav;
}

@GetMapping("/lista")
public ModelAndView getLista()
{
	ModelAndView mav = new ModelAndView("lista_alumnos");
	ListaAlumno lista = new ListaAlumno();
	mav.addObject("lista",lista.getAlumnos());
	return mav;
}

}
