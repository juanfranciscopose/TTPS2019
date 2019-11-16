package ttps.spring.DAO;

import java.util.List;

import ttps.spring.model.Mascota;
import ttps.spring.model.Veterinario;

public interface VeterinarioDAO extends Dao<Veterinario> {
	public List<Mascota> getMascotas(Veterinario vet);
}
