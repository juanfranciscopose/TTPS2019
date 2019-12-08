package ttps.spring.DAO;

import java.util.List;

import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;

public interface DuenoDAO extends Dao<Dueno> {
	public Dueno getByName(String name);
	public List<Mascota> getAllMascotas(int id);
}
