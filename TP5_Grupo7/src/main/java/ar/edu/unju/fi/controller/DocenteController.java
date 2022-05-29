package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.util.ListaDocente;

@Controller 
@RequestMapping("/docente")
public class DocenteController {
	
	
	@GetMapping("/nuevo")
	public String getFormulario(Model model)
	{
		model.addAttribute("docente",new Docente() );
		return "nuevo_docente";
	}
	
 @PostMapping("/guardar")
  public ModelAndView getListaDocente(@ModelAttribute("docente")Docente docente) {
	ModelAndView mav = new ModelAndView("lista_docentes");
    ListaDocente lista = new ListaDocente();
	 lista.getDocentes().add(docente);
	 mav.addObject("lista",lista.getDocentes());
	 return mav;
  }
  
 @GetMapping("/lista")
	public ModelAndView getLista()
	{
	    ModelAndView mav = new ModelAndView("lista_Docentes");
	    ListaDocente lista = new ListaDocente();
	    mav.addObject("lista",lista.getDocentes());
		return mav;
	}
	

  

 }
