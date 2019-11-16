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
import model.Enfermedad;
import model.Evento;
import model.Dueno;
import model.Mascota;

public class EnfermedadTest {

	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno duenoMascota;
	private static Enfermedad eventoD1;
	private static MascotaDAO mascotaJPA = FactoryDAO.getMascotaDAO();
	private static DuenoDAO duenoJPA = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAO configFichaJPA = FactoryDAO.getConfigFichaDAO();
	private static EventoDAO eventoJPA = FactoryDAO.getEventoDAO();

	@BeforeClass
	public static void beforeClass() {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false); 
		duenoMascota = new Dueno("seba", "pose", "seba@gmail.com", "1234", 22155620);	
		mascota = new Mascota("america", "perro", "callejero", "macho", "negro", "ninguna", null , null, duenoMascota, config);
		eventoD1 = new Enfermedad(LocalDate.now(), mascota, "gripe");
		duenoJPA.save(duenoMascota);
	}
	@Test
	public void test() {
		ArrayList<Mascota> mascotas; 
		
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		assertEquals(1,mascotas.size());
		Mascota m1 = mascotas.get(0);
		assertEquals(1, m1.getHistorial().size());
		Enfermedad e1 = (Enfermedad) m1.getHistorial().get(0);
		assertEquals("gripe", e1.getDescripcion());
		
		Enfermedad eventoD2 = new Enfermedad(LocalDate.now(), m1, "rabia");
		mascotaJPA.save(m1);
		m1 = mascotaJPA.getAll().get(0);
		assertEquals(2, m1.getHistorial().size());
		Enfermedad e = (Enfermedad) eventoJPA.getAll().get(1);
		m1.borrarEvento(e);
		mascotaJPA.save(m1);
		m1 = mascotaJPA.getAll().get(0);
		assertEquals(1, m1.getHistorial().size());	
		
		e1 = (Enfermedad) eventoJPA.getAll().get(0);
		e1.setDescripcion("gangrena");
		eventoJPA.update(e1);
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		Enfermedad e3 = (Enfermedad) mascotas.get(0).getHistorial().get(0);
		assertTrue(e3.getDescripcion().equals("gangrena"));
		
		Enfermedad e4 = (Enfermedad) eventoJPA.getAll().get(0);
		assertEquals("gangrena", e4.getDescripcion());
	}
	@AfterClass
	public static void AfterClass() {
		Dueno duenoo = duenoJPA.getAll().get(0);
		duenoJPA.delete(duenoo);
	}


}
