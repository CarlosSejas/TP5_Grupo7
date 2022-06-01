package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;
@Controller
@RequestMapping("/alumno")

public class AlumnoController {
	
	@Autowired
	private IAlumnoService alumnoService;
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	@GetMapping("/nuevo")
	public String getAlumnoPage(Model modelo) {
		modelo.addAttribute("alumno",alumnoService.getAlumno());
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
		if(alumnoService.agregarAlumno(alumno))
		{
		LOGGER.info("se agrego un objeto a la lista de alumnos");
		}
		mav.addObject("lista",alumnoService.getLista().getAlumnos());
		return mav;
}

@GetMapping("/lista")
public ModelAndView getLista()
{
	ModelAndView mav = new ModelAndView("lista_alumnos");
	mav.addObject("lista",alumnoService.getLista().getAlumnos());
	return mav;
}



@GetMapping("/editar/{dni}")
public ModelAndView getEditarPage(@PathVariable(value="dni")int dni)
{
	ModelAndView mav = new ModelAndView("edicion_alumno");
	mav.addObject("alumno",alumnoService.buscarAlumno(dni));
	return mav;
	
}

@PostMapping("/modificar")
public ModelAndView getEditarPage(@Validated @ModelAttribute("alumno")Alumno alumno,BindingResult bindingResult)
{
	if(bindingResult.hasErrors()) {
		ModelAndView mav = new ModelAndView("edicion_alumno");
		mav.addObject("alumno", alumno);
		return mav;
	}
	ModelAndView mav = new ModelAndView("redirect:/alumno/lista");
	if(alumnoService.modificarAlumno(alumno))
	{
		LOGGER.info("se modifico un alumno de la lista de alumnos");
	}
   
	return mav;
}
	
@GetMapping("/eliminar/{dni}")
public ModelAndView eliminarAlumno(@PathVariable(value="dni")int dni)
{
	if(alumnoService.eliminarAlumno(dni))
	{
		LOGGER.info("se elimino un alumno de la lista de alumnos");
	}
	ModelAndView mav = new ModelAndView("redirect:/alumno/lista");
	return mav;
	
	
	
}


}



