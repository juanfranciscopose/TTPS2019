package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "dueno")
@PrimaryKeyJoinColumn(name = "dueno_id")
public class Dueno extends Usuario {
	
	@OneToMany(mappedBy="dueno", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER )
	private List<Mascota> mascotas;
	
	public Dueno() {}
	public Dueno(String nombre, String apellido, String email, String password, int telefono) {
		super(nombre, apellido, email, password, telefono);
		this.mascotas = new ArrayList<Mascota>();
	}
		
	public List<Mascota> getMascotas() {
		return mascotas;
	}
	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	public void agregarMascota(Mascota mascota) {
		mascotas.add(mascota);
		
	}	
	
}
