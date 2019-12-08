package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;
import java.util.UUID;

@Service
public class LoginService {
	@Autowired
	private UsuarioDAO usuariodao;
	
	

	public HttpHeaders autenticateUser(String email, String password) {
		try {
			Usuario user = usuariodao.getByEmail(email);
            if (user.getPassword().equals(password)) {
    			HttpHeaders headers = new HttpHeaders();
    			String token = new String(Integer.toString(user.getId()) + "x" + generateToken());
    			user.setToken(token);
    			usuariodao.update(user);
                headers.add("Authorization",token);
                return headers;
            }
            return null;
		}catch(Exception e) {
			return null;
		}
	}
	
	private static String generateToken() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
	
}
