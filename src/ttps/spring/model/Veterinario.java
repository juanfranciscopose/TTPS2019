package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="veterinario")
@PrimaryKeyJoinColumn(name = "veterinario_id")
public class Veterinario extends Usuario {

	@Column(name="nom_clinica", length = 150)
	private String nomClinica;
	
	@Column(name="dir_clinica", length = 100)
	private String dirClinica;
	
	@Column(name="nro_matricula", nullable = false)
	private int nroMatricula;
	
	@Column(name="habilitado", nullable = false)
	private boolean habilitado;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="veterinario", fetch = FetchType.EAGER)
	private List<Mascota> mascotas;
	
	public Veterinario() {}

	public Veterinario(String nombre, String apellido, String email, String password, int telefono, String nomClinica, String dirClinica, int nroMatricula) {
		super(nombre, apellido, email, password, telefono);
		this.nomClinica = nomClinica;
		this.dirClinica = dirClinica;
		this.nroMatricula = nroMatricula;
		this.habilitado = false;
		this.mascotas = new ArrayList<Mascota>();
	}

	public String getNomClinica() {
		return nomClinica;
	}

	public void setNomClinica(String nomClinica) {
		this.nomClinica = nomClinica;
	}

	public String getDirClinica() {
		return dirClinica;
	}

	public void setDirClinica(String dirClinica) {
		this.dirClinica = dirClinica;
	}

	public int getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(int nroMatricula) {
		this.nroMatricula = nroMatricula;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}
	
	public void agregarMascota(Mascota m) {
		mascotas.add(m);
	}
	public void borrarMascota(Mascota m) {
		mascotas.remove(m);
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
}
