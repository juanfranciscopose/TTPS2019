package ttps.spring.DAOjpa;

import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.MascotaDAO;
import ttps.spring.model.Mascota;
@Repository
public class MascotaDAOjpa extends GenericDAOjpa<Mascota>
implements MascotaDAO{

	public MascotaDAOjpa() {
		super(Mascota.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Mascota> getByDueno_id(int id) {
		EntityManager em = getEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.dueno.id= ?1").setParameter(1, id).getResultList();
	}

	@Override
	public List<Mascota> getByVet(int id) {
		EntityManager em = getEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.veterinario.id= ?1").setParameter(1, id).getResultList();
	}

}
