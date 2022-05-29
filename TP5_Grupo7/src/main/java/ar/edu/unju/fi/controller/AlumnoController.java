package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	@GetMapping("/nuevo")
	public String getAlumnoPage(Model modelo) {
		modelo.addAttribute("alumno",new Alumno());
		return "nuevo_alumno";
	}
	
@PostMapping("/guardar")
public ModelAndView getListaAlumno(@Validated @ModelAttribute("alumno")Alumno alumno,BindingResult bindingResult)
{
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_alumnos");
		ListaAlumno lista = new ListaAlumno();
		if(lista.getAlumnos().add(alumno))
		{
		LOGGER.info("se agrego un objeto a la lista de alumnos");
		}
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
