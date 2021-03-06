package ttps.spring.DAO;

import java.util.List;

public interface GenericDAO<T> {
	T getById(int id);
	List<T> getAll();
	T save(T t);
	T update(T t);
	void delete(T t);
}
