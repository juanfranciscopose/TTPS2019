package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Dueno;
import ttps.spring.services.DuenoService;

@RestController
@RequestMapping
public class DuenoController {
	
	@Autowired
	DuenoService duenoservice;
	
	
	//recupero todos los duenos
	@GetMapping("/duenos2")
	public ResponseEntity<List<Dueno>> listar(){
		List<Dueno> lista = duenoservice.getAll();
		if(! lista.isEmpty()) {
			return new ResponseEntity<List<Dueno>>(lista, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Dueno>>(HttpStatus.NO_CONTENT);
		}
	}
}
