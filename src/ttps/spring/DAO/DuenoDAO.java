package ttps.spring.DAO;

import ttps.spring.model.Dueno;

public interface DuenoDAO extends Dao<Dueno> {
	public Dueno getByName(String name);
}
