package ttps.spring.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends Usuario {
		
	public Admin() {}
	public Admin(String nombre, String apellido, String email, String password, int telefono) {
		super(nombre, apellido, email, password, telefono);
		// TODO Auto-generated constructor stub
	}
	
	public void habilitarVeterinario(Veterinario v) {
		v.setHabilitado(true);
	}
}
