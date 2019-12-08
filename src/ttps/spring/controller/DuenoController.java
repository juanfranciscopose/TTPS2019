package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;
import ttps.spring.services.DuenoService;

@RestController
@RequestMapping
public class DuenoController {
	
	@Autowired
	DuenoService duenoservice;
	
	//recupero todas las mascotas de un dueno
	@GetMapping("/dueno/mascota/{id}")
	public ResponseEntity<List<Mascota>> todasLasMascotasDeUnDueno (@PathVariable("id") int id,
			@RequestHeader("Authorization") String token) throws Exception {
		//System.out.println(id);
		List<Mascota> lista = duenoservice.getAllMascotas(id, token);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<Mascota>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Mascota>>(lista, HttpStatus.OK);
	}
	//recupero todos los duenos
	@GetMapping("/duenos")
	public ResponseEntity<List<Dueno>> listar(){
		List<Dueno> lista = duenoservice.getAll();
		if(! lista.isEmpty()) {
			return new ResponseEntity<List<Dueno>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<List<Dueno>>(HttpStatus.NO_CONTENT);
	}
}
