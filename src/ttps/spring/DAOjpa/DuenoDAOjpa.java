package ttps.spring.DAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;


@Repository
public class DuenoDAOjpa extends GenericDAOjpa<Dueno>
implements DuenoDAO {

	public DuenoDAOjpa() {
		super(Dueno.class);
	}
	
	public Dueno getByName(String name) {
		EntityManager em = getEntityManager();
		return (Dueno) em.createQuery("SELECT d FROM Dueno d WHERE d.nombre=:name");
	}

	@Override
	public List<Mascota> getAllMascotas(int id) {
		EntityManager em = getEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.dueno.id =?1").setParameter(1, id).getResultList();
	}
	
}
