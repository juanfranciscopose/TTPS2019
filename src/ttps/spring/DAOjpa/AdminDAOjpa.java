package ttps.spring.DAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import ttps.spring.DAO.AdminDAO;
import ttps.spring.model.Admin;
import ttps.spring.model.Veterinario;

public class AdminDAOjpa extends GenericDAOjpa<Admin> implements AdminDAO{

	public AdminDAOjpa() {
		super(Admin.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Veterinario> getAllVeterinarioInhabilitados() {
		EntityManager em = getEntityManager();
		return (List<Veterinario>) em.createQuery("FROM Veterinario WHERE habilitado = 0").getResultList();
	}

}
