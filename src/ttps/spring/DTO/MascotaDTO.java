package ttps.spring.DTO;

import java.awt.image.BufferedImage;
import java.util.Date;

import ttps.spring.model.ConfigFicha;

public class MascotaDTO {
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private String color;
	private String senas;
	private Date nacimiento;
	private ConfigFicha configFicha;
	private BufferedImage[] fotos;
	
	public MascotaDTO() {}
	
	public MascotaDTO(String nombre, String especie, String raza, String sexo, String color, String senas,
			Date nacimiento, ConfigFicha configFicha, BufferedImage[] fotos) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.nacimiento = nacimiento;
		this.configFicha = configFicha;
		this.fotos = fotos;
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
	public ConfigFicha getConfigFicha() {
		return configFicha;
	}
	public void setConfigFichaId(ConfigFicha configFicha) {
		this.configFicha = configFicha;
	}
	public BufferedImage[] getFotos() {
		return fotos;
	}
	public void setFotos(BufferedImage[] fotos) {
		this.fotos = fotos;
	}
	
	
}
