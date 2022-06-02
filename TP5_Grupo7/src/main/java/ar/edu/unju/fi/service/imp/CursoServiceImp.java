package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaCurso;
@Service
public class CursoServiceImp implements ICursoService {
	@Autowired
	private ListaCurso listaCurso;
	
	
	@Override
	public Curso getCurso() {
	
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		// guarda un objeto a la lista
		
		return listaCurso.getCurso().add(curso);
	}

	@Override
	public void modificarCurso(Curso curso) {
		for (Curso c : listaCurso.getCurso()) {
			if(c.getCodigo()==curso.getCodigo()) {
				c.setTitulo(curso.getTitulo());
				c.setCanthoras(curso.getCanthoras());
				c.setFinicio(curso.getFinicio());
				c.setFfin(curso.getFfin());
				c.setCategoria(curso.getCategoria());
				c.setModalidad(curso.getModalidad());
				c.setDocente(curso.getDocente());
				
			}
		}

	}

	@Override
	public boolean eliminarCurso(int codigo) {
	
		for(Curso c: listaCurso.getCurso() )
		{
			if(c.getCodigo() == codigo)
			{
				listaCurso.getCurso().remove(listaCurso.getCurso().indexOf(c));
				return true; 
			}
		}
		
		return false;

	}

	@Override
	public ListaCurso getListaCurso() {
		
		return listaCurso;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		Optional<Curso> curso = listaCurso.getCurso().stream().filter(a -> a.getCodigo()==codigo).findFirst();
		return curso.get();
	}

}
