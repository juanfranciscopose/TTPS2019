package usuario;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clasesDAO.ConfigFichaDAO;
import clasesDAO.DuenoDAO;
import clasesDAO.EventoDAO;
import clasesDAO.MascotaDAO;
import clasesDAO.VeterinarioDAO;
import factory.FactoryDAO;
import model.ConfigFicha;
import model.Desparasitacion;
import model.Dueno;
import model.Mascota;
import model.Veterinario;
import model.Visita;

public class DuenoTest {
	
	private static Mascota mas;
	private static Mascota mas2;
	private static ConfigFicha config;
	private static Dueno due;
	private static Veterinario vet;
	private static Visita evento;
	private static Desparasitacion evento2;
	private static MascotaDAO mascotajpa = FactoryDAO.getMascotaDAO();
	private static VeterinarioDAO veterinariojpa = FactoryDAO.getVeterinarioDAO();
	private static EventoDAO eventojpa = FactoryDAO.getEventoDAO();
	private static DuenoDAO duenojpa = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAO fichajpa = FactoryDAO.getConfigFichaDAO();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false);
		vet = new Veterinario("manu", "martinez", "manu@gmail.com", "1234", 4456677,
				"mascotas Manu", "calle 1 678", 442312345);
		due = new Dueno("pepe", "mujica", "elPepe@gmail.com", "1234", 22155620);
		mas = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna",
				null, null, due, config);
		mas2 = new Mascota("fufi2", "perro", "chihuahua", "femenino", "negro", "ninguna",
				null, null, due, config);
		evento = new Visita(LocalDate.now(), mas, 22.2f , "se escapa seguido", "no sabe volver",
				"usar correa");
		evento2 = new Desparasitacion(LocalDate.now(), mas, "nitazoxanida", "volvio a la normalidad");
		duenojpa.save(due);
		/*mascotajpa.save(mas);
		mascotajpa.save(mas2);*/
	}
	
	@Test
	public void test() {
		ArrayList<Mascota> mascotas;
		
		assertEquals(1, duenojpa.getAll().size());
		Dueno dueno = duenojpa.getById(1);
		assertEquals(2, dueno.getMascotas().size());
		assertEquals(2, dueno.getMascotas().size());
		List<Mascota> mascotasdeDue = (List<Mascota>) dueno.getMascotas();
		Desparasitacion des = (Desparasitacion) mascotasdeDue.get(0).getHistorial().get(1);
		Visita vis = (Visita) mascotasdeDue.get(0).getHistorial().get(0);
		assertEquals("nitazoxanida", des.getDroga());
		assertEquals("se escapa seguido", vis.getMotivo());
		vis.setDescripcion("hola");
		eventojpa.update(vis);
		mascotasdeDue = duenojpa.getById(dueno.getId()).getMascotas();
		vis = (Visita) mascotasdeDue.get(0).getHistorial().get(0);
		assertEquals("hola", vis.getDescripcion());
	}

}