package ttps.spring.DAOjpa;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.ConfigFichaDAO;
import ttps.spring.model.ConfigFicha;

@Repository
public class ConfigFichaDAOjpa extends GenericDAOjpa<ConfigFicha>
implements ConfigFichaDAO {

	public ConfigFichaDAOjpa() {
		super(ConfigFicha.class);
	}
	
	public ConfigFicha getById(int id) {
		Query consulta = this.getEntityManager().createQuery("select e from ConfigFicha e where e.id =:id ").setParameter("id", id);
    	return (ConfigFicha) consulta.getSingleResult();
	}
}
