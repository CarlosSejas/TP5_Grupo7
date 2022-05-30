package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Beca;
import ar.edu.unju.fi.service.IBecaService;
import ar.edu.unju.fi.util.ListaBeca;

@Service
public class BecaServiceImp implements IBecaService {

	@Autowired
	private ListaBeca listaBeca;
	
	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		// TODO Auto-generated method stub
		return listaBeca.getBecas().add(beca);
	}

	@Override
	public void modificarBeca(Beca beca) {
		// buscar un docente con ese legajo y actualizar sus atributos
		for (Beca b : listaBeca.getBecas()) {
			if(b.getCodigo()==beca.getCodigo()) {
				b.setCurso(beca.getCurso());
				b.setEstado(beca.getEstado());
				b.setFinicio(beca.getFinicio());
				b.setFcierre(beca.getFcierre());
			}
		}
	}

	@Override
	public void eliminarBeca(int codigo) {
		// TODO Auto-generated method stub
		int indice=0;
		for (Beca b : listaBeca.getBecas()) {
			if(b.getCodigo()==codigo) {
				indice = listaBeca.getBecas().indexOf(b);
			}
		}
		listaBeca.getBecas().remove(indice);
	}

	@Override
	public ListaBeca getListaBeca() {
		// TODO Auto-generated method stub
		return listaBeca;
	}

	@Override
	public Beca buscarBeca(int codigo) {
		// busca un docente por su legajo y devuelve el objeto asociado al legajo
		Optional<Beca> beca = listaBeca.getBecas().stream().filter(b -> b.getCodigo()==codigo).findFirst();
		return beca.get();
	}

}
