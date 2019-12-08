package ttps.spring.model;

import javax.persistence.*;

@Entity
@Table(name="config_ficha")
public class ConfigFicha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre", nullable = false)
	private boolean nombre;
	
	@Column(name="especie", nullable = false)
	private boolean especie;
	
	@Column(name="raza", nullable = false)
	private boolean raza;
	
	@Column(name="sexo", nullable = false)
	private boolean sexo;
	
	@Column(name="color", nullable = false)
	private boolean color;
	
	@Column(name="senas", nullable = false)
	private boolean senas;
	
	@Column(name="nacimiento", nullable = false)
	private boolean nacimiento;
	
	@Column(name="dueno", nullable = false)
	private boolean dueno;
	
	@Column(name="fotos", nullable = false)
	private boolean fotos;
	
	@Column(name="veterinario", nullable = false)
	private boolean veterinario;
	
	public ConfigFicha() {}
	public ConfigFicha(boolean nombre, boolean especie, boolean raza, boolean sexo, boolean color, boolean senas,
			 boolean nacimiento, boolean dueno, boolean fotos, boolean veterinario) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.nacimiento = nacimiento;
		this.dueno = dueno;
		this.fotos = fotos;
		this.veterinario = veterinario;
	}
	public boolean isNombre() {
		return nombre;
	}
	public void setNombre(boolean nombre) {
		this.nombre = nombre;
	}
	public boolean isEspecie() {
		return especie;
	}
	public void setEspecie(boolean especie) {
		this.especie = especie;
	}
	public boolean isRaza() {
		return raza;
	}
	public void setRaza(boolean raza) {
		this.raza = raza;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	public boolean isSenas() {
		return senas;
	}
	public void setSenas(boolean senas) {
		this.senas = senas;
	}
	public boolean isNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(boolean nacimiento) {
		this.nacimiento = nacimiento;
	}
	public boolean isDueno() {
		return dueno;
	}
	public void setDueno(boolean dueno) {
		this.dueno = dueno;
	}
	public boolean isFotos() {
		return fotos;
	}
	public void setFotos(boolean fotos) {
		this.fotos = fotos;
	}
	public boolean isVeterinario() {
		return veterinario;
	}
	public void setVeterinario(boolean veterinario) {
		this.veterinario = veterinario;
	}
}
