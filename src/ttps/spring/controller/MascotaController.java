package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.MascotaDTO;
import ttps.spring.services.MascotaService;

@RestController
@RequestMapping
public class MascotaController {
	
	private MascotaService mascotaService;

	@Autowired
	public MascotaController(MascotaService mascotaService) {
		this.mascotaService = mascotaService;

	}
	public MascotaController() {}

	@PostMapping("/mascota")
	public ResponseEntity<?> altaMascota (@RequestHeader("Authorization") String token,
												@RequestBody MascotaDTO mascota ) {
		if(mascotaService.altaMascota(mascota, token)) {
			return new ResponseEntity<String>("mascota creada correctamente", HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
}
