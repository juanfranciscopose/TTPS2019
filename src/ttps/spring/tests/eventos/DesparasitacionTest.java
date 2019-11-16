package ttps.spring.tests.eventos;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import clasesDAO.ConfigFichaDAO;
import clasesDAO.DuenoDAO;
import clasesDAO.EventoDAO;
import clasesDAO.MascotaDAO;
import factory.FactoryDAO;
import model.ConfigFicha;
import model.Desparasitacion;
import model.Dueno;
import model.Mascota;


public class DesparasitacionTest {

	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno duenoMascota;
	private static Desparasitacion eventoD1;
	private static MascotaDAO mascotaJPA = FactoryDAO.getMascotaDAO();
	private static DuenoDAO duenoJPA = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAO configFichaJPA = FactoryDAO.getConfigFichaDAO();
	private static EventoDAO eventoJPA = FactoryDAO.getEventoDAO();

	@BeforeClass
	public static void beforeClass() {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false); 
		duenoMascota = new Dueno("seba", "pose", "seba@gmail.com", "1234", 22155620);	
		mascota = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna", null , null, duenoMascota, config);
		eventoD1 = new Desparasitacion(LocalDate.now(), mascota, "fenbendazol", "positivo");
		duenoJPA.save(duenoMascota);
	}
	@Test
	public void test() {
		ArrayList<Mascota> mascotas; 
		
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		assertEquals(1,mascotas.size());
		Mascota m1 = mascotas.get(0);
		assertEquals(1, m1.getHistorial().size());
		Desparasitacion e1 = (Desparasitacion) m1.getHistorial().get(0);
		assertEquals("positivo", e1.getResultado());
		
		Desparasitacion eventoD2 = new Desparasitacion(LocalDate.now(), m1, "praziquantel", "positivo. Qedan dosis pendientes");
		mascotaJPA.save(m1);
		m1 = mascotaJPA.getAll().get(0);
		assertEquals(2, m1.getHistorial().size());
		eventoD2 = (Desparasitacion) m1.getHistorial().get(1);
		m1.borrarEvento(eventoD2);	
		mascotaJPA.save(m1);
		m1 = mascotaJPA.getAll().get(0);
		assertEquals(1, m1.getHistorial().size());
		
		e1.setResultado("resultado esperado por todos");
		eventoJPA.update(e1);
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		Desparasitacion e3 = (Desparasitacion) mascotas.get(0).getHistorial().get(0);
		assertTrue(e3.getResultado().equals("resultado esperado por todos"));
		
		Desparasitacion e4 = (Desparasitacion) eventoJPA.getAll().get(0);
		assertEquals("fenbendazol",e4.getDroga());
	}
	@AfterClass
	public static void afterClass() {
		duenoMascota = duenoJPA.getAll().get(0);
		duenoJPA.delete(duenoMascota);   
	}


}
