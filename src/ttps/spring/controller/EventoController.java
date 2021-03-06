package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.EventoDTO;
import ttps.spring.DTO.IdRequest;
import ttps.spring.DTO.StringResponse;
import ttps.spring.services.EventoService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class EventoController {
	@Autowired
	private EventoService eventoservice;
	
	//para veterinarios retorna eventos anteriores a la fecha enviada como parametro. (Historial)
	@GetMapping("/veterinario/{id}/mascotas/eventos-anteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeTodasLasMascotasDeUnVeterinarioAntesFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("id") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosPasadosVeterinario(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	
	//para veterinarios retorna eventos posteriores a la fecha (inclusive) enviada como parametro
	@GetMapping("/veterinario/{id}/mascotas/eventos-posteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeTodasLasMascotasDeUnVeterinarioPostFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("id") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosFuturosVeterinario(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	
	//para Duenos retorna eventos posteriores a la fecha (inclusive) enviada como parametro
	@GetMapping("/dueno/{id}/mascotas/eventos-posteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeTodasLasMascotasDeUnDuenoPostFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("id") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosFuturosDueno(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	//para Duenos retorna eventos anteriores a la fecha enviada como parametro. (Historial)
	@GetMapping("/dueno/{id}/mascotas/eventos-anteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeTodasLasMascotasDeUnDuenoAntesFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("id") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosPasadosDueno(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	
	//para Mascotas retorna eventos posteriores a la fecha (inclusive) enviada como parametro
	@GetMapping("/dueno/mascotas/{mascotaId}/eventos-posteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeUnaMascotaoPostFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("mascotaId") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosFuturosMascota(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	
	//para Mascotas retorna eventos anteriores a la fecha enviada como parametro. (Historial)
	@GetMapping("/dueno/mascotas/{mascotaId}/eventos-anteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeUnaMascotaAntesFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("mascotaId") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosPasadosMascota(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	
	@PostMapping("/dueno/mascota/{id}/nuevo-evento/")
	public ResponseEntity<StringResponse> altaEventos (
											    @PathVariable("id") int idMascota,
												@RequestBody EventoDTO eventoDTO ) {
		
		if(eventoservice.altaEvento(eventoDTO, idMascota)) {
			StringResponse sr = new StringResponse("Evento creada correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/dueno/mascota/{idMascota}/borrar-evento")
	public ResponseEntity<StringResponse> borrarEvento (@PathVariable("idMascota") int idMascota,
												@RequestBody IdRequest idrequest ) {
		
		if(eventoservice.borrarEvento(idMascota, idrequest.getId())) {
			StringResponse sr = new StringResponse("Evento borrado correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/dueno/mascota/{id}/editar-evento/")
	public ResponseEntity<StringResponse> editarEventos (
											    @PathVariable("id") int idMascota,
												@RequestBody EventoDTO eventoDTO ) {
		if(eventoservice.editarEvento(eventoDTO, idMascota)) {
			StringResponse sr = new StringResponse("Evento editado correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
}
