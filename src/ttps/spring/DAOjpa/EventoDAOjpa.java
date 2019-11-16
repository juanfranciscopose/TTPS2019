package ttps.spring.DAOjpa;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import ttps.spring.DAO.EventoDAO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Evento;

public class EventoDAOjpa extends GenericDAOjpa<Evento>
implements EventoDAO {
	
	public EventoDAOjpa() {
		super(Evento.class);
	}

	@Override
	public List<Evento> getByDate(LocalDate d) {
		EntityManager em = getEntityManager();
		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int year = calendar.get(Calendar.YEAR);*/
		return (List<Evento>) em.createQuery("select e from Evento e where e.fecha >= ?1")
				.setParameter(1, d).getResultList();
	}
}
