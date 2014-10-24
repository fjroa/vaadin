package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Clase de dominio para la entidad Itinerario.
 * @author INDRA
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Itinerario")
public class Itinerario extends EntidadBase implements Serializable {
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * Attribute idItinerario.
	 */
	private String idItinerario;

	/**
	 * Attribute descripcion Itinerario.
	 */
	private String descItinerario;

	/**
	 * Attribute codCentro.
	 */
	private String codCentro;

	/**
	 *  Attribute descCentro.
	 */
	private String descCentro;

	/**
	 *  Attribute codMotivoInhabilitacion.
	 */
	private Integer codMotivoInhabilitacion;

	/**
	 *  Attribute fechaHoraInhabilitacion.
	 */
	private Date fechaHoraInhabilitacion;

	/**
	 *  Attribute observacionesInhabilitacion.
	 */
	private String observacionesInhabilitacion;

	/**
	 * Ubicaciones por las que pasa el itinerario.
	 */
    private Set < Ubicacion > ubicaciones = new HashSet < Ubicacion >();

	/**
	 * Constructor.
	 * @param codItinerario Integer
	 */
	public Itinerario(Integer codItinerario) {
		super();
		this.id = codItinerario;
		
	}

	/**
	 * Constructor sin parametros.
	 */
	public Itinerario() {
		super();
	}

	/**
	 * Obtiene el valor del campo "id".
	 * @return El valor del campo "id".
	 */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_ITINERARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODITINERARIO")
	public Integer getId() {
		return this.id;
	}

	/**
	 * Establece el valor del campo "id".
	 *
	 * @param id
	 *            El valor del campo "id".
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter.
	 * @return idItinerario
	 */
	@Basic
	@Column(name = "IDITINERARIO", length = 25)
	public String getIdItinerario() {
		return idItinerario;
	}

	/** Setter.
	 * @param idItinerario new value for idItinerario
	 */
	public void setIdItinerario(String idItinerario) {
		this.idItinerario = idItinerario;
	}

	/** Getter.
	 * @return descItinerario
	 */
	@Basic
	@Column(name = "DESCITINERARIO", length = 80)
	public String getDescItinerario() {
		return descItinerario;
	}

	/** Setter.
	 * @param descItinerario the descItinerario to set
	 */
	public void setDescItinerario(String descItinerario) {
		this.descItinerario = descItinerario;
	}


	/**  Getter.
	 * @return codCentro
	 */
	@Basic
	@Column(name = "CODCENTRO", length = 25)
	public String getCodCentro() {
		return codCentro;
	}

	/** Setter.
	 * @param codCentro String
	 */
	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
	}

	/** Getter.
	 * @return descCentro
	 */
	@Basic
	@Column(name = "DESCCENTRO", length = 255)
	public String getDescCentro() {
		return descCentro;
	}

	/** Setter.
	 * @param descCentro String
	 */
	public void setDescCentro(String descCentro) {
		this.descCentro = descCentro;
	}

	/**
	 * Obtiene el valor del campo "ubicaciones".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "ubicaciones".
	 */
	@OneToMany(mappedBy = "itinerario")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST,
    	CascadeType.EVICT, CascadeType.DELETE_ORPHAN })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("orden asc, codHabitacion asc, codUbicacion asc")
	public Set < Ubicacion > getUbicaciones() {
		return ubicaciones;
	}

	/**
	 * Establece el valor del campo "ubicaciones".
	 *
	 * @author tnevado
	 *
	 * @param ubicaciones
	 *            El valor del campo "ubicaciones".
	 */
	public void setUbicaciones(Set < Ubicacion > ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	/** Getter.
	 * @return codMotivoInhabilitacion
	 */
	public Integer getCodMotivoInhabilitacion() {
		return codMotivoInhabilitacion;
	}

	/** Setter.
	 * @param codMotivoInhabilitacion Integer
	 */
	public void setCodMotivoInhabilitacion(Integer codMotivoInhabilitacion) {
		this.codMotivoInhabilitacion = codMotivoInhabilitacion;
	}

	/** Getter.
	 * @return fechaHoraInhabilitacion
	 */
	public Date getFechaHoraInhabilitacion() {
		return fechaHoraInhabilitacion;
	}

	/** Setter.
	 * @param fechaHoraInhabilitacion Date
	 */
	public void setFechaHoraInhabilitacion(Date fechaHoraInhabilitacion) {
		this.fechaHoraInhabilitacion = fechaHoraInhabilitacion;
	}

	/** Getter.
	 * @return observacionesInhabilitacion
	 */
	@Basic
	@Column(name = "OBSERVACIONES", length = 255)
	public String getObservacionesInhabilitacion() {
		return observacionesInhabilitacion;
	}
	/** Setter.
	 * @param observacionesInhabilitacion String
	 */
	public void setObservacionesInhabilitacion(String observacionesInhabilitacion) {
		this.observacionesInhabilitacion = observacionesInhabilitacion;
	}

	/**
	 * Indica si una ubicacion esta entre las contenidas en un itinerario.
	 *
	 * @param ubicaciones
	 *            SortedSet&lt;Ubicacion&gt;
	 * @param codHabitacion String.
	 * @return boolean
	 */
	public boolean ubiContenidaEnItinerario(String codHabitacion) {
		boolean ret = false;
		if (ubicaciones != null && !ubicaciones.isEmpty()) {
			Iterator < Ubicacion > ubics = ubicaciones.iterator();
			Ubicacion ubi = null;
			while (ubics.hasNext()) {
				ubi = ubics.next();
                if (ubi.getCodHabitacion() != null && ubi.getCodHabitacion().equals(codHabitacion)) {
					ret = true;
					break;
				}
			}
		}
		return ret;
	}

	/**
	 * Metodo delegado para añadir ubicaciones al itinerario.
	 * @param e
	 * @return
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean add(Ubicacion e) {
		if (e != null) {
			e.setItinerario(this);
		}
		return ubicaciones.add(e);
	}

}
