package ttps.spring.model;

import java.util.Date;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="mascota")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="especie", nullable = false, length = 100)
	private String especie;
	
	@Column(name="raza", nullable = false, length = 150)
	private String raza;
	
	@Column(name="sexo", nullable = false, length = 50)
	private String sexo;
	
	@Column(name="color", nullable = false, length = 50)
	private String color;
	
	@Column(name="senas", length = 255)
	private String senas;
	
	@Column(name="nacimiento")
	@Temporal(TemporalType.DATE)
	private Date nacimiento;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="dueno_id")
	private Dueno dueno;
	
	private BufferedImage[] fotos;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="veterinario_id")
	private Veterinario veterinario;
	
	@OneToMany(mappedBy="mascota", orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Evento> historial;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	private ConfigFicha configFicha;
	
	public Mascota() {}
	
	public Mascota(String nombre, String especie, String raza, String sexo, String color, String senas,
			Date nacimiento, BufferedImage[] fotos) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.nacimiento = nacimiento;
		this.fotos = fotos;
		this.historial = new ArrayList<Evento>();
	}
	public Mascota(String nombre, String especie, String raza, String sexo, String color, String senas,
			Date nacimiento, BufferedImage[] fotos,Dueno dueno, ConfigFicha config ) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.nacimiento = nacimiento;
		this.fotos = fotos;
		this.veterinario = null;
		setDueno(dueno);
		this.configFicha = config;
		this.historial = new ArrayList<Evento>();
		
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		veterinario.agregarMascota(this);
		this.veterinario = veterinario;
	}
	public void nullVeterinario(Veterinario veterinario) {
		veterinario.borrarMascota(this);
		this.veterinario = null;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSenas() {
		return senas;
	}
	public void setSenas(String senas) {
		this.senas = senas;
	}

	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public BufferedImage[] getFotos() {
		return fotos;
	}
	public void setFotos(BufferedImage[] fotos) {
		this.fotos = fotos;
	}

	public Usuario getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		dueno.agregarMascota(this);
		this.dueno = dueno;
	}

	public ConfigFicha getConfigFicha() {
		return configFicha;
	}

	public void setConfigFicha(ConfigFicha configFicha) {
		this.configFicha = configFicha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void agregarEvento(Evento e) {
		this.historial.add(e);
	}
	public void borrarEvento(Evento e) {
		this.historial.remove(e);
	}

	public List<Evento> getHistorial() {
		return historial;
	}

	public void setHistorial(List<Evento> historial) {
		this.historial = historial;
	}
	
	public Mascota(String nombre, String especie, String raza, String sexo, String color, String senas,
			Date nacimiento, BufferedImage[] fotos, ConfigFicha config) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.nacimiento = nacimiento;
		this.fotos = fotos;
		this.configFicha = config;
		this.historial = new ArrayList<Evento>();
	}
	
}
