package ttps.spring.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Visita")
public class Visita extends Evento {
	@Column(name = "peso")
	private float peso;
	
	@Column(name = "motivo", length = 255)
	private String motivo;
	
	@Column(name = "descripcion", length = 255)
	private String descripcion;
	
	@Column(name = "indicaciones", length = 255)
	private String indicaciones;
	
	public Visita() {}
	public Visita(LocalDate fecha, Mascota mascota, float peso, String motivo, String descripcion, String indicaciones) {
		super(fecha, mascota);
		this.peso = peso;
		this.motivo = motivo;
		this.descripcion = descripcion;
		this.indicaciones = indicaciones;
	}

	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
}
