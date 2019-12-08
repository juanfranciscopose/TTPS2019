package ttps.spring.DAOjpa;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@Repository
public class UsuarioDAOjpa extends GenericDAOjpa<Usuario> implements UsuarioDAO {

	public UsuarioDAOjpa() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getByNombre(String nombre) {
		EntityManager em = getEntityManager();
		return (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.nombre=:name");
	}

	@Override
	public Usuario getByEmailAndPass(String email, String pass) {
		try {
			EntityManager em = getEntityManager();
			return (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.email= :email AND u.password= :pass")
					.setParameter("email",email)
					.setParameter("pass", pass).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public Usuario getByEmail(String email) {
		try {
			EntityManager em = getEntityManager();
			return (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.email= :email")
					.setParameter("email",email).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
