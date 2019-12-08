package ttps.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nombre", nullable = false, length = 150)
	private String nombre;
	
	@Column(name="apellido", nullable = false, length = 200)
	private String apellido;
	
	@Column(name="email", nullable = false, length = 200)
	private String email;
	
	@Column(name="token", nullable= true, length=200)
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	@Column(name="password", nullable = false, length = 50)
	private String password;
	
	@Column(name="telefono", nullable = false, length = 20)
	private long telefono;
	
	@OneToMany(mappedBy="usuario",orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private Set<Recordatorio> recordatorios;
	
	public void agregarRecordatorio(Recordatorio r) {
		this.recordatorios.add(r);
	}
	public void borrarRecordatorio(Recordatorio r) {
		this.recordatorios.remove(r);
	}
	
	public Set<Recordatorio> getRecordatorios() {
		return recordatorios;
	}

	public void setRecordatorios(HashSet<Recordatorio> recordatorios) {
		this.recordatorios = recordatorios;
	}

	public Usuario() { } //necesario para q sea entidad
	
	public Usuario(String nombre, String apellido, String email, String password, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.recordatorios = new HashSet<Recordatorio>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
