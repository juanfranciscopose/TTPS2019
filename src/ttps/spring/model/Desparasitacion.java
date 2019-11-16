package ttps.spring.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Desparacitacion")
public class Desparasitacion extends Evento {
	@Column(name = "droga", length = 100)
	private String droga;
	
	@Column(name = "resultado", length = 200)
	private String resultado;
	
	public Desparasitacion() {}

	public Desparasitacion(LocalDate fecha, Mascota mascota, String droga, String resultado) {
		super(fecha, mascota);
		this.droga = droga;
		this.resultado = resultado;
	}

	public String getDroga() {
		return droga;
	}
	public void setDroga(String droga) {
		this.droga = droga;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
