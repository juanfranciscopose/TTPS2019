package ttps.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.model.Dueno;

@Service
public class DuenoService {
	
	@Autowired
	private DuenoDAO duenoDAO;
	
	public List<Dueno> getAll() {
		return duenoDAO.getAll();
	}
}
