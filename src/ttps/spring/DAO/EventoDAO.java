package ttps.spring.DAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import ttps.spring.model.Evento;

public interface EventoDAO extends Dao<Evento> {
	List<Evento> getByDate(LocalDate d);
}
