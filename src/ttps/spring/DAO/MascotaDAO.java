package ttps.spring.DAO;

import java.util.List;

import ttps.spring.model.Evento;
import ttps.spring.model.Mascota;

public interface MascotaDAO extends Dao<Mascota> {
	List<Mascota> getByDueno_id(int id);
	List<Mascota> getByVet(int id);
}
