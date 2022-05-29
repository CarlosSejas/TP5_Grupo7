package ar.edu.unju.fi.controller;

import java.util.Optional;

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

import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.util.ListaBeca;
import ar.edu.unju.fi.util.ListaCurso;
import ar.edu.unju.fi.model.Beca;



@Controller
@RequestMapping("/becas")
public class BecaController {
	private static final Log LOGGER = LogFactory.getLog(BecaController.class);
	@GetMapping("/listaBecas")
	public ModelAndView getListadoBecasPage() {
		ModelAndView mav = new ModelAndView("lista_becas");
		ListaBeca listaBecas = new ListaBeca();
		mav.addObject("becas", listaBecas.getBecas());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", new Beca());
		ListaCurso listaCursos = new ListaCurso();
		model.addAttribute("cursos", listaCursos.getCurso());
		return "nuevo_beca";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("beca")Beca beca,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca",beca);
			ListaCurso listaCursos = new ListaCurso();
			mav.addObject("cursos", listaCursos.getCurso());
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_becas");
		// creo un objeto de la clase ListaAlumno, donde está el arrayList
		ListaBeca listaBecas = new ListaBeca();
		ListaCurso listaCursos = new ListaCurso();
		Optional<Curso> curso = listaCursos.getCurso().stream().filter(d -> d.getCodigo() == beca.getCurso().getCodigo()).findFirst();
		beca.setCurso(curso.get());
		//recupero el arrayList y agrego un objeto alumno a lista
		if(listaBecas.getBecas().add(beca)) {
			LOGGER.info("Se agregó un objeto al arrayList de beca");
		}
		//enviar el arrayList de alumnos a la página lista_alumnos
		mav.addObject("becas", listaBecas.getBecas());
		return mav;
	}
	
	}
