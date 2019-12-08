package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.ConfigFichaDAO;
import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.MascotaDAO;
import ttps.spring.DTO.MascotaDTO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;
import ttps.spring.utils.TokenValidator;

@Service
public class MascotaService {
	
	private MascotaDAO mascotaDAO;
	private DuenoDAO duenodao;
	private TokenValidator tokenValidator;
	
	@Autowired
	public MascotaService(MascotaDAO mascotaDAO, DuenoDAO duenodao, ConfigFichaDAO configdao, TokenValidator tokenValidator) {
		super();
		this.mascotaDAO = mascotaDAO;
		this.duenodao = duenodao;
		this.tokenValidator = tokenValidator;
	}
	public MascotaService() {}
	
	public boolean altaMascota(MascotaDTO mascota, String token){
		try {
			Dueno dueno = (Dueno) this.tokenValidator.validateTokenAndGetUser(token);
			Mascota mascotaSave = new Mascota(mascota.getNombre(), mascota.getEspecie(), mascota.getRaza()
					, mascota.getSexo(), mascota.getColor(), mascota.getSenas(), mascota.getNacimiento()
					, mascota.getFotos(), dueno, mascota.getConfigFicha());
			mascotaDAO.save(mascotaSave);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}
