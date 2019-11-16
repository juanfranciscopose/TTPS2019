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
import model.Enfermedad;
import model.Mascota;
import model.HistorialReproductivo;

public class HistorialReproductivoTest {

	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno duenoMascota;
	private static HistorialReproductivo eventoD1;
	private static MascotaDAO mascotaJPA = FactoryDAO.getMascotaDAO();
	private static DuenoDAO duenoJPA = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAO configFichaJPA = FactoryDAO.getConfigFichaDAO();
	private static EventoDAO eventoJPA = FactoryDAO.getEventoDAO();

	@BeforeClass
	public static void beforeClass() {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false); 
		duenoMascota = new Dueno("seba", "pose", "seba@gmail.com", "1234", 22155620);	
		mascota = new Mascota("america", "perro", "callejero", "macho", "negro", "ninguna", null , null, duenoMascota, config);
		eventoD1 = new HistorialReproductivo(LocalDate.now(), mascota, 6);
		duenoJPA.save(duenoMascota);
	}
	@Test
	public void test() {
		ArrayList<Mascota> mascotas; 
		
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		assertEquals(1,mascotas.size());
		Mascota m1 = mascotas.get(0);
		assertEquals(1, m1.getHistorial().size());
		HistorialReproductivo e1 = (HistorialReproductivo) m1.getHistorial().get(0);
		assertEquals(6, e1.getNroNacidos());
		
		HistorialReproductivo eventoD2 = new HistorialReproductivo(LocalDate.now(), m1, 7);
		mascotaJPA.save(m1);
		m1 = mascotaJPA.getAll().get(0);
		assertEquals(2, m1.getHistorial().size());
		eventoD2 = (HistorialReproductivo) m1.getHistorial().get(1);
		m1.borrarEvento(eventoD2);	
		mascotaJPA.save(m1);
		m1 = mascotaJPA.getAll().get(0);
		assertEquals(1, m1.getHistorial().size());
		
		e1.setNroNacidos(5);
		eventoJPA.update(e1);
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		HistorialReproductivo e3 = (HistorialReproductivo) mascotas.get(0).getHistorial().get(0);
		assertTrue(e3.getNroNacidos() == 5);
		
		HistorialReproductivo e4 = (HistorialReproductivo) eventoJPA.getAll().get(0);
		assertEquals(5, e4.getNroNacidos());
	}
	@AfterClass
	public static void AfterClass() {
		duenoMascota = duenoJPA.getAll().get(0);
		duenoJPA.delete(duenoMascota);
	}
}
