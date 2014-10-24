package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase de dominio que representa una ubicacion de un itinerario.
 * @author tnevado
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ITINERARIO_UBICACION")
@SequenceGenerator(name = "SEQ_ITINERARIO_UBICACION",
		sequenceName = "SEQ_ITINERARIO_UBICACION", allocationSize = 1)
public class Ubicacion implements Serializable, Comparable < Ubicacion > {

	/**
	 * Constructor.
	 *
	 */
	public Ubicacion() {
		super();
	}
	/**
	 * Codigo.
	 */
	private Integer id;
	/**
	 * Codigo de ubicacion. (Urgencias)
	 */
	private String codUbicacion;
	/**
	 * Descripcion de la ubicacion. (Urgencias)
	 */
	private String descUbicacion;

    /**
     * codHabitacion String. (Hospitalizacion)
     */
    private String codHabitacion;

    /**
     * descHabitacion String.  (Hospitalizacion)
     */
    private String descHabitacion;


	/**
	 * Itinerario al que pertenece la ubicacion.
	 */
	private Itinerario itinerario;

	/**
	 * orden Integer orden Integer orden de ubicaciones en el itinerario.
	 */
	private Integer orden;

	/**
	 * codPlanta String.
	 */
	private String codPlanta;
	/**
	 * descPlanta String.
	 */
	private String descPlanta;
	/**
	 * codEdificio String.
	 */
	private String codEdificio;
	/**
	 * descEdificio String.
	 */
	private String descEdificio;
	/**
	 * codUnidadEnfermeria String.
	 */
	private String codUnidadEnfermeria;
	/**
	 * descUnidadEnfermeria String.
	 */
	private String descUnidadEnfermeria;

	/**
	 * codArea String.
	 */
	private String codArea;
	/**
	 * Control a nivel de BBDD para asegurar que una ubicación pertenece solo
	 * a un itinerario habilitado. Si el itinerario al
	 * que pertenece esta habilitado, su valor coincide con el codHabitacion, si esta deshabilitado se le
     * concatena antes el id del itinerario, a la columna tiene una restriccion de unicidad, de modo que una
	 * habitación solo puede estar dentro de un itinerario habilitado.
	 *
	 * uniqueId String.
	 */
	private String uniqueId;

	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODITINERARIOUBICACION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITINERARIO_UBICACION")
	public Integer getId() {
		return id;
	}
	/**
	 * Establece el valor del campo "id".
	 *
	 * @author tnevado
	 *
	 * @param codItinerarioUbicacion
	 *            El valor del campo "id".
	 */
	public void setId(Integer codItinerarioUbicacion) {
		this.id = codItinerarioUbicacion;
	}
	/**
	 * Obtiene el valor del campo "codUbicacion".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "codUbicacion".
	 */
	@Column
	public String getCodUbicacion() {
		return codUbicacion;
	}
	/**
	 * Establece el valor del campo "codUbicacion".
	 *
	 * @author tnevado
	 *
	 * @param codUbicacion
	 *            El valor del campo "codUbicacion".
	 */
	public void setCodUbicacion(String codUbicacion) {
		this.codUbicacion = codUbicacion;
	}
	/**
	 * Obtiene el valor del campo "descUbicacion".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "descUbicacion".
	 */
	@Column
	public String getDescUbicacion() {
		return descUbicacion;
	}
	/**
	 * Establece el valor del campo "descUbicacion".
	 *
	 * @author tnevado
	 *
	 * @param descUbicacion
	 *            El valor del campo "descUbicacion".
	 */
	public void setDescUbicacion(String descUbicacion) {
		this.descUbicacion = descUbicacion;
	}

	/**
	 * Obtiene el valor del campo "codHabitacion".
	 *
	 * @return El valor del campo "codHabitacion".
	 */
	@Basic
	@Column(name = "CODHABITACION", length = 25)
	public String getCodHabitacion() {
		return codHabitacion;
	}
	/**
	 * Establece el valor del campo "codHabitacion".
	 *
	 * @param codHabitacion
	 *            El valor del campo "codHabitacion".
	 */
	public void setCodHabitacion(String codHabitacion) {
		this.codHabitacion = codHabitacion;
	}
	/**
	 * Obtiene el valor del campo "descHabitacion".
	 *
	 * @return El valor del campo "descHabitacion".
	 */
	@Basic
	@Column(name = "DESCHABITACION", length = 255)
	public String getDescHabitacion() {
		return descHabitacion;
	}
	/**
	 * Establece el valor del campo "descHabitacion".
	 *
	 * @param descHabitacion
	 *            El valor del campo "descHabitacion".
	 */
	public void setDescHabitacion(String descHabitacion) {
		this.descHabitacion = descHabitacion;
	}

	/**
	 *
	 * Ordenacion.
	 *
	 * @param o Ubicacion
	 * @return int
	 */
	public int compareTo(Ubicacion o) {
		int ret = 0;
		if (o == null) {
			ret = +1;
		} else {
			if (o.getOrden() == null) {
				if (this.orden != null) {
					ret = +1;
				}
			} else {
				if (this.orden == null) {
					ret = -1;
				} else {
					ret = this.orden.compareTo(o.getOrden());
				}
			}
			if (ret == 0) {
				if (o.getCodUbicacion() == null) {
					if (this.codUbicacion != null) {
						ret = +1;
					}
				} else {
					if (this.codUbicacion == null) {
						ret = -1;
					} else {
						ret = this.codUbicacion.compareTo(o.getCodUbicacion());
					}
				}
			}
			if (ret == 0) {
				if (o.getCodHabitacion() == null) {
					if (this.codHabitacion != null) {
						ret = +1;
					}
				} else {
					if (this.codHabitacion == null) {
						ret = -1;
					} else {
						ret = this.codHabitacion.compareTo(o.getCodHabitacion());
					}
				}
			}
			if (ret == 0) {
				if (o.getCodPlanta() == null) {
					if (this.codPlanta != null) {
						ret = +1;
					}
				} else {
					if (this.codPlanta == null) {
						ret = -1;
					} else {
						ret = this.codPlanta.compareTo(o.getCodPlanta());
					}
				}
			}
			if (ret == 0) {
				if (o.getCodEdificio() == null) {
					if (this.codEdificio != null) {
						ret = +1;
					}
				} else {
					if (this.codEdificio == null) {
						ret = -1;
					} else {
						ret = this.codEdificio.compareTo(o.getCodEdificio());
					}
				}
			}
			if (ret == 0) {
				if (o.getCodUnidadEnfermeria() == null) {
					if (this.codUnidadEnfermeria != null) {
						ret = +1;
					}
				} else {
					if (this.codUnidadEnfermeria == null) {
						ret = -1;
					} else {
                        ret = this.codUnidadEnfermeria.compareTo(o.getCodUnidadEnfermeria());
					}
				}
			}
			if (ret == 0) {
				if (o.getCodArea() == null) {
					if (this.codArea != null) {
						ret = +1;
					}
				} else {
					if (this.codArea == null) {
						ret = -1;
					} else {
						ret = this.codArea.compareTo(o.getCodArea());
					}
				}
			}
		}
		return ret;
	}


	/**
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if (obj != null) {
			ret = this.compareTo(((Ubicacion)obj)) == 0;
		}
		return ret;
	}
	/**
	 * Obtiene el valor del campo "itinerario".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "itinerario".
	 */
	@ManyToOne
	@JoinColumn(name = "CODITINERARIO")
	public Itinerario getItinerario() {
		return itinerario;
	}
	/**
	 * Establece el valor del campo "itinerario".
	 *
	 * @author tnevado
	 *
	 * @param itinerario
	 *            El valor del campo "itinerario".
	 */
	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}
	/**
	 * Obtiene el valor del campo "orden".
	 *
	 * @return El valor del campo "orden".
	 */
	@Column
	public Integer getOrden() {
		return orden;
	}
	/**
	 * Establece el valor del campo "orden".
	 *
	 * @param orden
	 *            El valor del campo "orden".
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	/**
	 * Obtiene el valor del campo "codPlanta".
	 *
	 * @return El valor del campo "codPlanta".
	 */
	@Column
	public String getCodPlanta() {
		return codPlanta;
	}
	/**
	 * Establece el valor del campo "codPlanta".
	 *
	 * @param codPlanta
	 *            El valor del campo "codPlanta".
	 */
	public void setCodPlanta(String codPlanta) {
		this.codPlanta = codPlanta;
	}
	/**
	 * Obtiene el valor del campo "descPlanta".
	 *
	 * @return El valor del campo "descPlanta".
	 */
	@Column
	public String getDescPlanta() {
		return descPlanta;
	}
	/**
	 * Establece el valor del campo "descPlanta".
	 *
	 * @param descPlanta
	 *            El valor del campo "descPlanta".
	 */
	public void setDescPlanta(String descPlanta) {
		this.descPlanta = descPlanta;
	}
	/**
	 * Obtiene el valor del campo "codEdificio".
	 *
	 * @return El valor del campo "codEdificio".
	 */
	@Column
	public String getCodEdificio() {
		return codEdificio;
	}
	/**
	 * Establece el valor del campo "codEdificio".
	 *
	 * @param codEdificio
	 *            El valor del campo "codEdificio".
	 */
	public void setCodEdificio(String codEdificio) {
		this.codEdificio = codEdificio;
	}
	/**
	 * Obtiene el valor del campo "descEdificio".
	 *
	 * @return El valor del campo "descEdificio".
	 */
	@Column
	public String getDescEdificio() {
		return descEdificio;
	}
	/**
	 * Establece el valor del campo "descEdificio".
	 *
	 * @param descEdificio
	 *            El valor del campo "descEdificio".
	 */
	public void setDescEdificio(String descEdificio) {
		this.descEdificio = descEdificio;
	}


	/**
	 * Obtiene el valor del campo "codUnidadEnfermeria".
	 *
	 * @return El valor del campo "codUnidadEnfermeria".
	 */
	@Column
	public String getCodUnidadEnfermeria() {
		return codUnidadEnfermeria;
	}
	/**
	 * Establece el valor del campo "codUnidadEnfermeria".
	 *
	 * @param codUnidadEnfermeria
	 *            El valor del campo "codUnidadEnfermeria".
	 */
	public void setCodUnidadEnfermeria(String codUnidadEnfermeria) {
		this.codUnidadEnfermeria = codUnidadEnfermeria;
	}
	/**
	 * Obtiene el valor del campo "descUnidadEnfermeria".
	 *
	 * @return El valor del campo "descUnidadEnfermeria".
	 */
	@Column
	public String getDescUnidadEnfermeria() {
		return descUnidadEnfermeria;
	}
	/**
	 * Establece el valor del campo "descUnidadEnfermeria".
	 *
	 * @param descUnidadEnfermeria
	 *            El valor del campo "descUnidadEnfermeria".
	 */
	public void setDescUnidadEnfermeria(String descUnidadEnfermeria) {
		this.descUnidadEnfermeria = descUnidadEnfermeria;
	}
	/**
	 * Obtiene el valor del campo "codArea".
	 *
	 * @return El valor del campo "codArea".
	 */
	@Column
	public String getCodArea() {
		return codArea;
	}
	/**
	 * Establece el valor del campo "codArea".
	 *
	 * @param codArea
	 *            El valor del campo "codArea".
	 */
	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}
	/**
	 * Control a nivel de BBDD para asegurar que una ubicación pertenece solo
	 * a un itinerario habilitado. Si el itinerario al
	 * que pertenece esta habilitado, su valor coincide con el codHabitacion, si esta deshabilitado se le
     * concatena antes el id del itinerario, a la columna tiene una restriccion de unicidad, de modo que una
	 * habitación solo puede estar dentro de un itinerario habilitado.
	 *
	 * @return El valor del campo "uniqueId".
	 */
	@Column(name = "UNIQUE_ID")
	public String getUniqueId() {
		return uniqueId;
	}
	/**
	 * Control a nivel de BBDD para asegurar que una ubicación pertenece solo
	 * a un itinerario habilitado. Si el itinerario al
	 * que pertenece esta habilitado, su valor coincide con el codHabitacion, si esta deshabilitado se le
     * concatena antes el id del itinerario, a la columna tiene una restriccion de unicidad, de modo que una
	 * habitación solo puede estar dentro de un itinerario habilitado.
	 *
	 * @param uniqueId String.
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}



}
