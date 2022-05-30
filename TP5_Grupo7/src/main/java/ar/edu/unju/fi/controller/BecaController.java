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

import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.IBecaService;
import ar.edu.unju.fi.util.ListaCurso;
import ar.edu.unju.fi.model.Beca;



@Controller
@RequestMapping("/becas")
public class BecaController {
	private static final Log LOGGER = LogFactory.getLog(BecaController.class);
	@Autowired
	private IBecaService becaService;
	
	@GetMapping("/listaBecas")
	public ModelAndView getListadoBecasPage() {
		ModelAndView mav = new ModelAndView("lista_becas");
		mav.addObject("becas", becaService.getListaBeca().getBecas());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", becaService.getBeca());
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
		ListaCurso listaCursos = new ListaCurso();
		Optional<Curso> curso = listaCursos.getCurso().stream().filter(d -> d.getCodigo() == beca.getCurso().getCodigo()).findFirst();
		beca.setCurso(curso.get());
		//recupero el arrayList y agrego un objeto alumno a lista
		if(becaService.guardarBeca(beca)) {
			LOGGER.info("Se agregó un objeto al arrayList de beca");
		}
		//enviar el arrayList de alumnos a la página lista_alumnos
		mav.addObject("becas", becaService.getListaBeca().getBecas());
		return mav;
	}
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarBecaPage(@PathVariable(value = "codigo")int codigo) {
		ModelAndView mav = new ModelAndView("edicion_beca");
		ListaCurso listaCursos = new ListaCurso();
		mav.addObject("cursos", listaCursos.getCurso());
		Beca beca = becaService.buscarBeca(codigo);
		mav.addObject("beca",beca);
		
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosBeca(@Validated @ModelAttribute("beca")Beca beca,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error");
			ModelAndView mav = new ModelAndView("edicion_beca");
			mav.addObject("beca",beca);
			ListaCurso listaCursos = new ListaCurso();
			mav.addObject("cursos", listaCursos.getCurso());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/becas/listaBecas");
		ListaCurso listaCursos = new ListaCurso();
		Optional<Curso> curso = listaCursos.getCurso().stream().filter(d -> d.getCodigo() == beca.getCurso().getCodigo()).findFirst();
		beca.setCurso(curso.get());
		becaService.modificarBeca(beca);
		return mav;
	}
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarBeca(@PathVariable("codigo")int codigo) {
		becaService.eliminarBeca(codigo);
		ModelAndView mav = new ModelAndView("redirect:/becas/listaBecas");
	return mav;
	}
	
	}
