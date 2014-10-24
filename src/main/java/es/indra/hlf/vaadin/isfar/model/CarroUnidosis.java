package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 *	Clase de dominio para carro unidosis.
 * @author tnevado
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CARRO_UNIDOSIS")
@SequenceGenerator(name = "SEQ_CARRO_UNIDOSIS",
		sequenceName = "SEQ_CARRO_UNIDOSIS", allocationSize = 1)
public class CarroUnidosis extends EntidadBase implements Serializable {

	/**
	 * Constructor.
	 *
	 */
	public CarroUnidosis() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * Carro fisico asociado.
	 */
	private Carro carro;
	/**
	 * Fecha de generacion del carro.
	 */
	private Date fechaAnteriorGeneracion;
	/**
	 * fechaInicioTurno Date.
	 */
	private Date fechaInicioTurno;
	/**
	 * fechaFinTurno Date.
	 */
	private Date fechaFinTurno;

	/**
	 * Fecha de Preparado del carro.
	 */
	private Date fechaPreparado;

	/**
	 * codUsuarioPreparado String.
	 */
	private String codUsuarioPreparado;
	/**
	 * descUsuarioPreparado String.
	 */
	private String descUsuarioPreparado;

	/**
	 * Fecha de Salida del carro.
	 */
	private Date fechaSalida;
	/**
	 * codUsuarioSalida String.
	 */
	private String codUsuarioSalida;
	/**
	 * descUsuarioSalida String.
	 */
	private String descUsuarioSalida;

	/**
	 * Fecha de Entrada del carro.
	 */
	private Date fechaEntrada;

	/**
	 * codUsuarioEntrada String.
	 */
	private String codUsuarioEntrada;
	/**
	 * descUsuarioEntrada String.
	 */
	private String descUsuarioEntrada;

	/**
	 * Fecha de Ultima Generacion del carro.
	 */
	private Date fechaUltimaGeneracion;
	/**
	 * codUsuarioUltimaGeneracion String.
	 */
	private String codUsuarioUltimaGeneracion;
	/**
	 * descUsuarioUltimaGeneracion String.
	 */
	private String descUsuarioUltimaGeneracion;

	/**
	 * Fecha de Carga Completa del carro.
	 */
	private Date fechaCargaCompleta;
	/**
	 * codUsuarioCargaCompleta String.
	 */
	private String codUsuarioCargaCompleta;
	/**
	 * descUsuarioCargaCompleta String.
	 */
	private String descUsuarioCargaCompleta;

	/**
	 * Fecha de Confirmacion del carro.
	 */
	private Date fechaConfirmacion;
	/**
	 * codUsuarioConfirmacion String.
	 */
	private String codUsuarioConfirmacion;
	/**
	 * descUsuarioConfirmacion String.
	 */
	private String descUsuarioConfirmacion;

	/**
	 * descUsuarioUltimaModificacion String.
	 */
	private String descUsuarioUltimaModificacion;
	/**
	 * Itinerario que sige el carro.
	 */
	private Itinerario itinerario;
	/**
	 * Turno al que pertenece el carro.
	 */
	private Turno turno;
	/**
	 * Orden del carro.
	 */
	private Integer orden;
	/**
	 * Indica si es el ultimo carro.
	 */
	private boolean ultimo;

	/**
	 * Ubicaciones por las que pasa el itinerario.
	 */
    private SortedSet < CarroUnidosisDetalle > carroUnidosisDetalle = new TreeSet < CarroUnidosisDetalle >();



	/**
	 * Obtiene el valor del campo "carro".
	 * @author tnevado
	 * @return El valor del campo "carro".
	 */
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name = "CODCARRO")
	public Carro getCarro() {
		return carro;
	}
	/**
	 * Establece el valor del campo "carro".
	 * @author tnevado
	 * @param car El valor del campo "carro".
	 */
	public void setCarro(final Carro car) {
		this.carro = car;
	}


	/**
	 * Obtiene el valor del campo "fechaAnteriorGeneracion".
	 *
	 * @return El valor del campo "fechaAnteriorGeneracion".
	 */
	@Column
	public Date getFechaAnteriorGeneracion() {
		return fechaAnteriorGeneracion;
	}
	/**
	 * Establece el valor del campo "fechaAnteriorGeneracion".
	 *
	 * @param fAnteriorGeneracion
	 *            El valor del campo "fechaAnteriorGeneracion".
	 */
	public void setFechaAnteriorGeneracion(final Date fAnteriorGeneracion) {
		this.fechaAnteriorGeneracion = fAnteriorGeneracion;
	}
	/**
	 * Obtiene el valor del campo "fechaInicioTurno".
	 *
	 * @return El valor del campo "fechaInicioTurno".
	 */
	@Column
	public Date getFechaInicioTurno() {
		return fechaInicioTurno;
	}
	/**
	 * Establece el valor del campo "fechaInicioTurno".
	 *
	 * @param fInicioTurno
	 *            El valor del campo "fechaInicioTurno".
	 */
	public void setFechaInicioTurno(final Date fInicioTurno) {
		this.fechaInicioTurno = fInicioTurno;
	}
	/**
	 * Obtiene el valor del campo "fechaFinTurno".
	 *
	 * @return El valor del campo "fechaFinTurno".
	 */
	@Column
	public Date getFechaFinTurno() {
		return fechaFinTurno;
	}
	/**
	 * Establece el valor del campo "fechaFinTurno".
	 *
	 * @param fFinTurno
	 *            El valor del campo "fechaFinTurno".
	 */
	public void setFechaFinTurno(final Date fFinTurno) {
		this.fechaFinTurno = fFinTurno;
	}
	/**
	 * Obtiene el valor del campo "itinerario".
	 * @author tnevado
	 * @return El valor del campo "itinerario".
	 */
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CODITINERARIO")
	public Itinerario getItinerario() {
		return itinerario;
	}
	/**
	 * Establece el valor del campo "itinerario".
	 * @author tnevado
	 * @param iti El valor del campo "itinerario".
	 */
	public void setItinerario(final Itinerario iti) {
		this.itinerario = iti;
	}
	/**
	 * Obtiene el valor del campo "turno".
	 * @author tnevado
	 * @return El valor del campo "turno".
	 */
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name = "CODTURNO")
	public Turno getTurno() {
		return turno;
	}
	/**
	 * Establece el valor del campo "turno".
	 * @author tnevado
	 * @param turn El valor del campo "turno".
	 */
	public void setTurno(final Turno turn) {
		this.turno = turn;
	}

	/**
	 * Obtiene el valor del campo "fechaPreparado".
	 * @return El valor del campo "fechaPreparado".
	 */
	@Column
	public Date getFechaPreparado() {
		return fechaPreparado;
	}
	/**
	 * Establece el valor del campo "fechaPreparado".
	 * @param fPreparado El valor del campo "fechaPreparado".
	 */
	public void setFechaPreparado(final Date fPreparado) {
		this.fechaPreparado = fPreparado;
	}
	/**
	 * Obtiene el valor del campo "fechaSalida".
	 * @return El valor del campo "fechaSalida".
	 */
	@Column
	public Date getFechaSalida() {
		return fechaSalida;
	}
	/**
	 * Establece el valor del campo "fechaSalida".
	 * @param fSalida El valor del campo "fechaSalida".
	 */
	public void setFechaSalida(final Date fSalida) {
		this.fechaSalida = fSalida;
	}
	/**
	 * Obtiene el valor del campo "fechaEntrada".
	 * @return El valor del campo "fechaEntrada".
	 */
	@Column
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	/**
	 * Establece el valor del campo "fechaEntrada".
	 * @param fEntrada El valor del campo "fechaEntrada".
	 */
	public void setFechaEntrada(final Date fEntrada) {
		this.fechaEntrada = fEntrada;
	}

	/**
	 * Obtiene el valor del campo "fechaUltimaGeneracion".
	 * @return El valor del campo "fechaUltimaGeneracion".
	 */
	@Column
	public Date getFechaUltimaGeneracion() {
		return fechaUltimaGeneracion;
	}
	/**
	 * Establece el valor del campo "fechaUltimaGeneracion".
	 * @param fUltimaGeneracion El valor del campo "fechaUltimaGeneracion".
	 */
	public void setFechaUltimaGeneracion(final Date fUltimaGeneracion) {
		this.fechaUltimaGeneracion = fUltimaGeneracion;
	}
	/**
	 * Obtiene el valor del campo "fechaCargaCompleta".
	 * @return El valor del campo "fechaCargaCompleta".
	 */
	@Column
	public Date getFechaCargaCompleta() {
		return fechaCargaCompleta;
	}
	/**
	 * Establece el valor del campo "fechaCargaCompleta".
	 * @param fCargaCompleta El valor del campo "fechaCargaCompleta".
	 */
	public void setFechaCargaCompleta(final Date fCargaCompleta) {
		this.fechaCargaCompleta = fCargaCompleta;
	}
	/**
	 * Obtiene el valor del campo "fechaConfirmacion".
	 * @return El valor del campo "fechaConfirmacion".
	 */
	@Column
	public Date getFechaConfirmacion() {
		return fechaConfirmacion;
	}
	/**
	 * Establece el valor del campo "fechaConfirmacion".
	 * @param fConfirmacion El valor del campo "fechaConfirmacion".
	 */
	public void setFechaConfirmacion(final Date fConfirmacion) {
		this.fechaConfirmacion = fConfirmacion;
	}
	/**
	 * Obtiene el valor del campo "fechaConfirmacion".
	 * @return El valor del campo "fechaConfirmacion".
	 */
	@Column
	public Integer getOrden() {
		return orden;
	}
	/**
	 * Establece el valor del campo "fechaConfirmacion".
	 * @param ord Integer.
	 */
	public void setOrden(final Integer ord) {
		this.orden = ord;
	}
	/**
	 * Obtiene el valor del campo "fechaConfirmacion".
	 * @return El valor del campo "fechaConfirmacion".
	 */
	@Column
	public boolean isUltimo() {
		return ultimo;
	}
	/**
	 * ult boolean.
	 * @param ult boolean
	 */
	public void setUltimo(final boolean ult) {
		this.ultimo = ult;
	}
	/**
	 * Obtiene el valor del campo "carroUnidosisDetalle".
	 * @return El valor del campo "carroUnidosisDetalle".
	 */
	@OneToMany(mappedBy = "carroUnidosis")
    @Sort(type = SortType.NATURAL)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST, CascadeType.EVICT, CascadeType.MERGE})
    @Fetch(FetchMode.SUBSELECT)
    public SortedSet < CarroUnidosisDetalle > getCarroUnidosisDetalle() {
		return carroUnidosisDetalle;
	}
	/**
	 * Establece el valor del campo "carroUnidosisDetalle".
	 * @param cUnidosisDetalle El valor del campo "carroUnidosisDetalle".
	 */
	public void setCarroUnidosisDetalle(
			final SortedSet < CarroUnidosisDetalle > cUnidosisDetalle) {
		this.carroUnidosisDetalle = cUnidosisDetalle;
	}

	/**
	 * Obtiene el valor del campo "id".
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODCARROUNIDOSIS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARRO_UNIDOSIS")
	public Integer getId() {
		return id;
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
	/**
	 * Obtiene el valor del campo "codUsuarioPreparado".
	 *
	 * @return El valor del campo "codUsuarioPreparado".
	 */
	@Column
	public String getCodUsuarioPreparado() {
		return codUsuarioPreparado;
	}
	/**
	 * Establece el valor del campo "codUsuarioPreparado".
	 *
	 * @param cUsuarioPreparado
	 *            El valor del campo "codUsuarioPreparado".
	 */
	public void setCodUsuarioPreparado(final String cUsuarioPreparado) {
		this.codUsuarioPreparado = cUsuarioPreparado;
	}
	/**
	 * Obtiene el valor del campo "descUsuarioPreparado".
	 *
	 * @return El valor del campo "descUsuarioPreparado".
	 */
	@Column
	public String getDescUsuarioPreparado() {
		return descUsuarioPreparado;
	}
	/**
	 * Establece el valor del campo "descUsuarioPreparado".
	 *
	 * @param dUsuarioPreparado
	 *            El valor del campo "descUsuarioPreparado".
	 */
	public void setDescUsuarioPreparado(final String dUsuarioPreparado) {
		this.descUsuarioPreparado = dUsuarioPreparado;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioSalida".
	 *
	 * @return El valor del campo "codUsuarioSalida".
	 */
	@Column
	public String getCodUsuarioSalida() {
		return codUsuarioSalida;
	}
	/**
	 * Establece el valor del campo "codUsuarioSalida".
	 *
	 * @param cUsuarioSalida
	 *            El valor del campo "codUsuarioSalida".
	 */
	public void setCodUsuarioSalida(final String cUsuarioSalida) {
		this.codUsuarioSalida = cUsuarioSalida;
	}
	/**
	 * Obtiene el valor del campo "descUsuarioSalida".
	 *
	 * @return El valor del campo "descUsuarioSalida".
	 */
	@Column
	public String getDescUsuarioSalida() {
		return descUsuarioSalida;
	}
	/**
	 * Establece el valor del campo "descUsuarioSalida".
	 *
	 * @param dUsuarioSalida
	 *            El valor del campo "descUsuarioSalida".
	 */
	public void setDescUsuarioSalida(final String dUsuarioSalida) {
		this.descUsuarioSalida = dUsuarioSalida;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioEntrada".
	 *
	 * @return El valor del campo "codUsuarioEntrada".
	 */
	@Column
	public String getCodUsuarioEntrada() {
		return codUsuarioEntrada;
	}
	/**
	 * Establece el valor del campo "codUsuarioEntrada".
	 *
	 * @param cUsuarioEntrada
	 *            El valor del campo "codUsuarioEntrada".
	 */
	public void setCodUsuarioEntrada(final String cUsuarioEntrada) {
		this.codUsuarioEntrada = cUsuarioEntrada;
	}
	/**
	 * Obtiene el valor del campo "descUsuarioEntrada".
	 *
	 * @return El valor del campo "descUsuarioEntrada".
	 */
	@Column
	public String getDescUsuarioEntrada() {
		return descUsuarioEntrada;
	}
	/**
	 * Establece el valor del campo "descUsuarioEntrada".
	 *
	 * @param dUsuarioEntrada
	 *            El valor del campo "descUsuarioEntrada".
	 */
	public void setDescUsuarioEntrada(final String dUsuarioEntrada) {
		this.descUsuarioEntrada = dUsuarioEntrada;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioUltimaGeneracion".
	 *
	 * @return El valor del campo "codUsuarioUltimaGeneracion".
	 */
	@Column
	public String getCodUsuarioUltimaGeneracion() {
		return codUsuarioUltimaGeneracion;
	}
	/**
	 * Establece el valor del campo "codUsuarioUltimaGeneracion".
	 *
	 * @param cUsuarioUltimaGeneracion
	 *            El valor del campo "codUsuarioUltimaGeneracion".
	 */
	public void setCodUsuarioUltimaGeneracion(final String cUsuarioUltimaGeneracion) {
		this.codUsuarioUltimaGeneracion = cUsuarioUltimaGeneracion;
	}
	/**
	 * Obtiene el valor del campo "descUsuarioUltimaGeneracion".
	 *
	 * @return El valor del campo "descUsuarioUltimaGeneracion".
	 */
	@Column
	public String getDescUsuarioUltimaGeneracion() {
		return descUsuarioUltimaGeneracion;
	}
	/**
	 * Establece el valor del campo "descUsuarioUltimaGeneracion".
	 *
	 * @param dUsuarioUltimaGeneracion
	 *            El valor del campo "descUsuarioUltimaGeneracion".
	 */
	public void setDescUsuarioUltimaGeneracion(final String dUsuarioUltimaGeneracion) {
		this.descUsuarioUltimaGeneracion = dUsuarioUltimaGeneracion;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioCargaCompleta".
	 *
	 * @return El valor del campo "codUsuarioCargaCompleta".
	 */
	@Column
	public String getCodUsuarioCargaCompleta() {
		return codUsuarioCargaCompleta;
	}
	/**
	 * Establece el valor del campo "codUsuarioCargaCompleta".
	 *
	 * @param cUsuarioCargaCompleta
	 *            El valor del campo "codUsuarioCargaCompleta".
	 */
	public void setCodUsuarioCargaCompleta(final String cUsuarioCargaCompleta) {
		this.codUsuarioCargaCompleta = cUsuarioCargaCompleta;
	}
	/**
	 * Obtiene el valor del campo "descUsuarioCargaCompleta".
	 *
	 * @return El valor del campo "descUsuarioCargaCompleta".
	 */
	@Column
	public String getDescUsuarioCargaCompleta() {
		return descUsuarioCargaCompleta;
	}
	/**
	 * Establece el valor del campo "descUsuarioCargaCompleta".
	 *
	 * @param dUsuarioCargaCompleta
	 *            El valor del campo "descUsuarioCargaCompleta".
	 */
	public  void setDescUsuarioCargaCompleta(final String dUsuarioCargaCompleta) {
		this.descUsuarioCargaCompleta = dUsuarioCargaCompleta;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioConfirmacion".
	 *
	 * @return El valor del campo "codUsuarioConfirmacion".
	 */
	@Column
	public String getCodUsuarioConfirmacion() {
		return codUsuarioConfirmacion;
	}
	/**
	 * Establece el valor del campo "codUsuarioConfirmacion".
	 *
	 * @param cUsuarioConfirmacion
	 *            El valor del campo "codUsuarioConfirmacion".
	 */
	public void setCodUsuarioConfirmacion(final String cUsuarioConfirmacion) {
		this.codUsuarioConfirmacion = cUsuarioConfirmacion;
	}
	/**
	 * Obtiene el valor del campo "descUsuarioConfirmacion".
	 *
	 * @return El valor del campo "descUsuarioConfirmacion".
	 */
	@Column
	public String getDescUsuarioConfirmacion() {
		return descUsuarioConfirmacion;
	}
	/**
	 * Establece el valor del campo "descUsuarioConfirmacion".
	 *
	 * @param dUsuarioConfirmacion
	 *            El valor del campo "descUsuarioConfirmacion".
	 */
	public void setDescUsuarioConfirmacion(final String dUsuarioConfirmacion) {
		this.descUsuarioConfirmacion = dUsuarioConfirmacion;
	}
	/**
	 * Obtiene el valor del campo "descUsuarioUltimaModificacion".
	 *
	 * @return El valor del campo "descUsuarioUltimaModificacion".
	 */
	@Column
	public String getDescUsuarioUltimaModificacion() {
		return descUsuarioUltimaModificacion;
	}
	/**
	 * Establece el valor del campo "descUsuarioUltimaModificacion".
	 *
	 * @param dUsuarioUltimaModificacion
	 *            El valor del campo "descUsuarioUltimaModificacion".
	 */
	public void setDescUsuarioUltimaModificacion(final String dUsuarioUltimaModificacion) {
		this.descUsuarioUltimaModificacion = dUsuarioUltimaModificacion;
	}
	/**
	 * @param e CarroUnidosisDetalle
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addCarroUnidosisDetalle(final CarroUnidosisDetalle e) {
		boolean ret = false;
		if (e != null) {
			e.setCarroUnidosis(this);
		}
		if (carroUnidosisDetalle != null) {
			ret = carroUnidosisDetalle.add(e); 
		}
		return ret;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">>> CarroUnidosis { ");
		sb.append(" id: " + this.id);
		if (this.carro != null) {
			sb.append(this.carro.toString());
		}
		if (this.itinerario == null) {
			sb.append(" itinerario: carro sin itinerario ");
		} else {
			sb.append(" codItinerario: " + this.itinerario.getId());
			sb.append(" idItinerario: " + this.itinerario.getIdItinerario());
			sb.append(" descItinerario: " + this.itinerario.getDescItinerario());
			sb.append(" itinerario.activo: " + this.itinerario.isActivo());
		}
		if (this.turno != null) {
			sb.append(" codTurno: " + this.turno.getId());
			sb.append(" idTurno: " + this.turno.getIdTurno());
			sb.append(" descTurno: " + this.turno.getDescTurno());
			sb.append(" tipoTurno: " + this.turno.getTipo());			
		}
		if (this.getFechaInicioTurno() == null) {
			sb.append(" fechaInicioTurno: null");
		} else {
			sb.append(" fechaInicioTurno: " + this.getFechaInicioTurno().toString());
		}
		if (this.getFechaFinTurno() == null) {
			sb.append(" fechaFinTurno: null");
		} else {
			sb.append(" fechaFinTurno: " + this.getFechaInicioTurno().toString());
		}
		sb.append("fechaCreacion: " + this.getFechaHoraCreacion());
		sb.append("fechaCargaCompleta: " + this.getFechaCargaCompleta());
		sb.append("fechaPreparado: " + this.getFechaPreparado());
		sb.append("fechaSalida: " + this.getFechaSalida());
		sb.append("fechaEntrada: " + this.getFechaEntrada());
		sb.append("fechaConfirmacion: " + this.getFechaConfirmacion());
		sb.append("fechaAnteriorGeneracion: " + this.getFechaAnteriorGeneracion());		
		sb.append("fechaUltimaGeneracion: " + this.getFechaUltimaGeneracion());
		if (this.carroUnidosisDetalle != null && !this.carroUnidosisDetalle.isEmpty()) {
			for (CarroUnidosisDetalle cud : this.carroUnidosisDetalle) {
				sb.append("\n\t" + cud.toString());
			}
		}
		return sb.toString();
	}

}
