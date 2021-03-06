package ttps.spring.DAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.VeterinarioDAO;
import ttps.spring.model.Mascota;
import ttps.spring.model.Veterinario;
@Repository
public class VeterinarioDAOjpa extends GenericDAOjpa<Veterinario> implements VeterinarioDAO {

	public VeterinarioDAOjpa() {
		super(Veterinario.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mascota> getMascotas(int id) {
		EntityManager em = getEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.veterinario.id=?1").setParameter(1, id).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veterinario> getAllVet() {
		EntityManager em = getEntityManager();
		return (List<Veterinario>) em.createQuery("SELECT v FROM Veterinario v").getResultList();
	}

}
