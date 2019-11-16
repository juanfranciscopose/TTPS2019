package ttps.spring.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.model.Dueno;

public class TestSpringSimple {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		//registra una o mas componentes que seran procesadas
		ctx.register(ttps.spring.config.PersistenceConfig.class);
		//busca clases anotadas en el paquete base pasado por parametro
		ctx.scan("ttps");
		ctx.refresh();
		
		DuenoDAO duenoDAO = ctx.getBean("duenoDAOjpa", DuenoDAO.class);
		duenoDAO.save(new Dueno("hola", "hola", "hola", "asf", 1234));
		Dueno d = duenoDAO.getById(1);
		duenoDAO.delete(d);
		System.out.println(duenoDAO.getAll());
	}

}
