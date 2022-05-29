package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.util.ListaCurso;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/curso")
public class CursoController {
	@GetMapping("/lista")
	public ModelAndView getcursosindex(Model model) {
		ModelAndView mav = new ModelAndView("lista_cursos");
		ListaCurso cursos = new ListaCurso();
		mav.addObject("lista", cursos.getCurso());
		return mav;
	}

   @GetMapping("/nuevo")
   public String getnuevohtml(Model model) {
	   model.addAttribute("curso", new Curso());
		ListaDocente listaDocente = new ListaDocente();
		model.addAttribute("docentes", listaDocente.getDocentes());
	   return "nuevo_curso";
   }

   @PostMapping("/guardar")
   public ModelAndView getListaCurso(@ModelAttribute("curso")Curso curso)
   {
   		ModelAndView mav = new ModelAndView("lista_cursos");
   		ListaCurso lista = new ListaCurso();
   		ListaDocente listaDocente = new ListaDocente();
		Optional<Docente> docente = listaDocente.getDocentes().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
		curso.setDocente(docente.get());
   		lista.getCurso().add(curso);
   		mav.addObject("lista",lista.getCurso());
   		
   		return mav;
   }
	
	
	
	
	
	
	
}
