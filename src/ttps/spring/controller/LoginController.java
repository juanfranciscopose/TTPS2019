package ttps.spring.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.LoginDTO;
import ttps.spring.services.LoginService;

@RestController
@RequestMapping
public class LoginController {
	@Autowired
	private LoginService loginservice;
	
	@PostMapping("/autenticacion")
	public ResponseEntity<?> autenticateUser(@RequestBody LoginDTO login){
	 	HttpHeaders headers = loginservice.autenticateUser(login.getUsuario(), login.getPassword());
	 	if (headers != null) {
	       	return new ResponseEntity<HttpHeaders>(headers, HttpStatus.OK);
	    }
	    return new ResponseEntity<String>("error", HttpStatus.FORBIDDEN);
	}
}
