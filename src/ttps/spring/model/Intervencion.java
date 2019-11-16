package ttps.spring.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Intervencion")
public class Intervencion extends Evento {
	
	@Column(name = "descripcion", length = 255)
	private String descripcion;
	
	public Intervencion() {}
	
	public Intervencion(LocalDate fecha, Mascota mascota, String descripcion) {
		super(fecha, mascota);
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
