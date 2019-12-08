package ttps.spring.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Enfermedad")
public class Enfermedad extends Evento {
	@Column(name = "descripcion", length = 255)
	private String descripcion;

	public Enfermedad() {}
	
	public Enfermedad(LocalDate fecha, Mascota mascota, String descripcion) {
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
