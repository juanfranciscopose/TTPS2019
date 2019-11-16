package ttps.spring.DAO;

import java.util.List;

import ttps.spring.model.Recordatorio;

public interface RecordatorioDAO extends Dao<Recordatorio>{
	public List<Recordatorio> getAllByUsuarioId(int id);
}
