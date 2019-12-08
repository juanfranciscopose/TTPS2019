package ttps.spring.DAOjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.DAO.Dao;

@Transactional
public class GenericDAOjpa<T> implements Dao<T> {
	
	private EntityManager entityManager;
	
	protected Class<T> clase;
	
	public GenericDAOjpa(Class<T> clase) {
		this.clase = clase;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*@Override
	public List<Usuario> getByName(String name) {
		return (List<Usuario>) em.createQuery("SELECT u FROM User u WHERE u.")
	}*/

	@Override
	public T getById(int id) {
		return this.entityManager.find(clase, id);
	}

	@Override
	public List<T> getAll() {
		return this.entityManager.createQuery("from " + getClase().getSimpleName()).getResultList();
	}

	@Override
	public T save(T t) {
		this.entityManager.persist(t);
		return t;
	}

	@Override
	public T update(T entity) {
		this.entityManager.merge(entity);
		return entity;
	}

	@Override
	public void delete(T t) {
		this.entityManager.remove(this.entityManager.merge(t));
	}

	public Class<T> getClase() {
		return clase;
	}

	public void setClase(Class<T> clase) {
		this.clase = clase;
	}

}
