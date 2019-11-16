package ttps.spring.DAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import ttps.spring.DAO.VeterinarioDAO;
import ttps.spring.model.Mascota;
import ttps.spring.model.Veterinario;

public class VeterinarioDAOjpa extends GenericDAOjpa<Veterinario> implements VeterinarioDAO {

	public VeterinarioDAOjpa() {
		super(Veterinario.class);
	}

	@Override
	public List<Mascota> getMascotas(Veterinario vet) {
		EntityManager em = getEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.veterinario_id=:vet.veterinario_id").getResultList();
	}

}
