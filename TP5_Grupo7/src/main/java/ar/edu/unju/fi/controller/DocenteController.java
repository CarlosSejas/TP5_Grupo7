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

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;


@Controller 
@RequestMapping("/docente")
public class DocenteController {
	
	
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	
	@Autowired
	private IDocenteService docenteService;
	
	@GetMapping("/nuevo")
	public String getFormulario(Model model)
	{
		model.addAttribute("docente",docenteService.getDocente() );
		return "nuevo_docente";
	}
	
 @PostMapping("/guardar")
  public ModelAndView getListaDocente(@Validated @ModelAttribute("docente")Docente docente,BindingResult bindingResult) {
	
	if(bindingResult.hasErrors()) {
		LOGGER.error("No se cumplen las reglas de validación");
		ModelAndView mav = new ModelAndView("nuevo_docente");
		mav.addObject("docente",docente);	
		return mav;
	}
	 
	 ModelAndView mav = new ModelAndView("lista_docentes");
	 if(docenteService.guardarDocente(docente)) {
		LOGGER.info("Se agregó un objeto al arrayList de Docentes");
	 }
	 mav.addObject("lista",docenteService.getListaDocente().getDocentes());
	 return mav;
  }
  
 @GetMapping("/lista")
	public ModelAndView getLista()
	{
	    ModelAndView mav = new ModelAndView("lista_Docentes");
	    mav.addObject("lista",docenteService.getListaDocente().getDocentes());
		return mav;
	}
	
 @GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value = "legajo")int legajo) {
		ModelAndView mav = new ModelAndView("edicion_docente");
		Docente docente = docenteService.buscarDocente(legajo);
		mav.addObject("docente",docente);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error" + docente);
			ModelAndView mav = new ModelAndView("edicion_docente");
			mav.addObject("docente",docente);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/docente/lista");
		docenteService.modificarDocente(docente);
		return mav;
	}
	
	@GetMapping("/eliminar/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable("legajo")int legajo) {
		
		docenteService.eliminarDocente(legajo);
		ModelAndView mav = new ModelAndView("redirect:/docente/lista");
		
		return mav;
	}
  

 }
