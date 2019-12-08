package ttps.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;
import ttps.spring.utils.TokenValidator;

@Service
public class DuenoService {
	
	@Autowired
	private DuenoDAO duenoDAO;
	
	@Autowired
	private TokenValidator tokenValidator;
	
	public List<Dueno> getAll() {
		return duenoDAO.getAll();
	}
	
	public List<Mascota> getAllMascotas(int id, String token) throws Exception {
		try {
			this.tokenValidator.validateTokenAndGetUser(token);
			return duenoDAO.getAllMascotas(id);
		}
		catch (Exception e){
			throw new Exception();
		}
	}
}
