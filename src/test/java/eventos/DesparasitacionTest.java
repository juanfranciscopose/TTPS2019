package eventos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import clasesDAOjpa.ConfigFichaDAOjpa;
import clasesDAOjpa.DuenoDAOjpa;
import clasesDAOjpa.EventoDAOjpa;
import clasesDAOjpa.MascotaDAOjpa;
import factory.FactoryDAO;
import model.ConfigFicha;
import model.Desparasitacion;
import model.Dueno;
import model.Mascota;
import model.Visita;


public class DesparasitacionTest {

	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno duenoMascota;
	private static Desparasitacion eventoD;
	private static MascotaDAOjpa mascotaJPA = FactoryDAO.getMascotaDAO();
	private static DuenoDAOjpa duenoJPA = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAOjpa configFichaJPA = FactoryDAO.getConfigFichaDAO();
	private static EventoDAOjpa eventoJPA = FactoryDAO.getEventoDAO();

	@BeforeClass
	public static void beforeClass() {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false); 
		duenoMascota = new Dueno("seba", "pose", "seba@gmail.com", "1234", 22155620);	
		mascota = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna", null , null, duenoMascota, config);
		eventoD = new Desparasitacion(new Date(), mascota, "fenbendazol", "positivo");
		duenoJPA.save(duenoMascota);
		configFichaJPA.save(config);
		mascotaJPA.save(mascota);
		eventoJPA.save(eventoD);
		mascota.agregarEvento(eventoD);		
	}
	
	@Test
	public void test() {
		ArrayList<Mascota> mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		assertEquals(1,mascotas.size());
		Mascota m1 = mascotas.get(0);
		assertEquals(1, m1.getHistorial().size());
		Desparasitacion e1 = (Desparasitacion) m1.getHistorial().get(0);
		assertTrue(e1.equals(eventoD));
		Desparasitacion e2 = new Desparasitacion(new Date(), m1, "praziquantel", "positivo. Qedan dosis pendientes");
		m1.agregarEvento(e2);
		assertEquals(2, m1.getHistorial().size());
		m1.borrarEvento(e2);		
		assertEquals(1, m1.getHistorial().size());
		
		e1.setResultado("resultado esperado por todos");
		eventoJPA.update(e1);
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		e1 = (Desparasitacion) mascotas.get(0).getHistorial().get(0);
		assertTrue(e1.getResultado().equals("resultado esperado por todos"));
		
		Desparasitacion e3 = (Desparasitacion) eventoJPA.getById(1);
		assertTrue(e3.equals(eventoD));
	}
	@AfterClass
	public static void AfterClass() {
		mascota.borrarEvento(eventoD);
		eventoJPA.delete(eventoD);	
		mascotaJPA.delete(mascota);	
		configFichaJPA.delete(config);
		duenoJPA.delete(duenoMascota);	    
	}


}