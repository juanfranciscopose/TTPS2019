package ttps.spring.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="evento")
@Inheritance
public abstract class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fecha", nullable = false)
	private LocalDate fecha;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="mascota_id")
	private Mascota mascota;
	
	public Evento() {}
	
	public Evento(LocalDate fecha, Mascota mascota) {
		this.fecha = fecha;
		setMascota(mascota);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		mascota.agregarEvento(this);
		this.mascota = mascota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    @Override
    public boolean equals(Object obj)
    {
        if ( obj == null ) return false;
        if ( this == obj ) return true;
        if ( ! (obj instanceof Evento ) ) return false;
        Evento e = (Evento) obj;
        return this.getId() == e.getId();
    }
	
}
