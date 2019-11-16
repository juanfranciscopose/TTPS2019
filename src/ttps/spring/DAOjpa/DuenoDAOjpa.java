package ttps.spring.DAOjpa;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.model.Dueno;


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
	
}
