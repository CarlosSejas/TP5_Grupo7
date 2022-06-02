package ar.edu.unju.fi.controller;

import java.util.Optional;

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

import ar.edu.unju.fi.controller.CursoController;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaDocente;


@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private ICursoService cursoService;
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	@GetMapping("/lista")
	public ModelAndView getcursosindex(Model model) {
		ModelAndView mav = new ModelAndView("lista_cursos");
		mav.addObject("lista", cursoService.getListaCurso().getCurso());
		return mav;
	}

   @GetMapping("/nuevo")
   public String getnuevohtml(Model model) {
	   model.addAttribute("curso", cursoService.getCurso());
		ListaDocente listaDocente = new ListaDocente();
		model.addAttribute("docentes", listaDocente.getDocentes());
	   return "nuevo_curso";
   }

   @PostMapping("/guardar")
   public ModelAndView getListaCurso(@Validated @ModelAttribute("curso")Curso curso,BindingResult bindingResult)
   {
	   if(bindingResult.hasErrors()) {
		   ModelAndView mav = new ModelAndView("nuevo_curso");
		   mav.addObject("curso", curso);
		   ListaDocente listaDocente = new ListaDocente();
		   mav.addObject("docentes", listaDocente.getDocentes());
		   return mav;
	   }
   		ModelAndView mav = new ModelAndView("lista_cursos");
   		ListaDocente listaDocente = new ListaDocente();
		Optional<Docente> docente = listaDocente.getDocentes().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
		curso.setDocente(docente.get());
   		if(cursoService.guardarCurso(curso)) {
   		LOGGER.info("Se agrego un objeto a la lista de cursos");
   		}
   		mav.addObject("lista",cursoService.getListaCurso().getCurso());
   		return mav;
   }
	
   @GetMapping("/editar/{codigo}")
	public ModelAndView editarhtml(@PathVariable(value="codigo")int codigo) {
	   ModelAndView mav = new ModelAndView("edicion_curso");
	   ListaDocente listaDocente = new ListaDocente();
	   mav.addObject("docentes", listaDocente.getDocentes());
	   Curso curso = cursoService.buscarCurso(codigo);
	   mav.addObject("curso", curso);
	   return mav;
	}
	
   @PostMapping("/modificar")
   public ModelAndView modificarhtml(@Validated @ModelAttribute("curso") Curso curso ,BindingResult bindingResult ) {
	   if (bindingResult.hasErrors()) {
		   LOGGER.info("error de validacion");
		   ModelAndView mav = new ModelAndView("edicion_curso");
		   mav.addObject("curso", curso);
		   ListaDocente docente = new ListaDocente();
		   mav.addObject("docentes", docente.getDocentes());
		   return mav;
	   }
	   
	   
	   ModelAndView mav = new ModelAndView("redirect:/curso/lista");
	   ListaDocente listaDocente = new ListaDocente();
	   Optional<Docente> docente = listaDocente.getDocentes().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
		curso.setDocente(docente.get());
		cursoService.modificarCurso(curso);
		return mav;
   }
	
   @GetMapping("/eliminar/{codigo}")
   public ModelAndView eliminarcurso(@PathVariable(value="codigo")int codigo) {
	   if(cursoService.eliminarCurso(codigo)) {
		   LOGGER.info("se elimino un objeto de la lista");
	   }
	   ModelAndView mav = new ModelAndView("redirect:/curso/lista");
	   return mav;
   }
	
}
