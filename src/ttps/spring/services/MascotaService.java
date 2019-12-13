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
	
	@Autowired
	public MascotaService(MascotaDAO mascotaDAO, DuenoDAO duenodao, ConfigFichaDAO configdao) {
		super();
		this.mascotaDAO = mascotaDAO;
		this.duenodao = duenodao;
	}
	public MascotaService() {}
	
	public boolean altaMascota(MascotaDTO mascota, int id){
		try {
			Dueno dueno = duenodao.getById(id);
			System.out.println("traje dueno" + dueno);
			Mascota mascotaSave = new Mascota(mascota.getNombre(), mascota.getEspecie(), mascota.getRaza()
					, mascota.getSexo(), mascota.getColor(), mascota.getSenas(), mascota.getNacimiento()
					, mascota.getFotos(), dueno, mascota.getConfigFicha());
			System.out.println("cree mascota " + mascotaSave);
			mascotaDAO.save(mascotaSave);
			System.out.println("guarde mascota " + mascotaSave);
			return true;
		}catch (Exception e) {
			System.out.println("excepcion");
			return false;
		}
	}
	
}
