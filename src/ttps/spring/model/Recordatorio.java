package ttps.spring.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "recordatorio")
public class Recordatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario;
	
	public Recordatorio() {}
	public Recordatorio(String titulo, LocalDateTime fecha, String descripcion, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.descripcion = descripcion;
		setUsuario(usuario);
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		usuario.agregarRecordatorio(this);
		this.usuario = usuario;
	}
    @Override
    public boolean equals(Object obj)
    {
    	if(this == obj) 
            return true; 
    	if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
    	Recordatorio r = (Recordatorio) obj;
    	return (r.getTitulo().equals(this.titulo) && r.getId()==this.getId());
    }
    
    @Override
    public int hashCode() 
    { 
    	return this.getId(); 
    }
	
}
