package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase de dominio para la entidad Carro.
 * @author ardiego
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CARRO")
public class Carro extends EntidadBase implements Serializable {

	/**
	 * id Integer.
	 */
	private Integer id;
    /**
	 * Attribute id.
	 */
	private String idCarro;

	/**
	 *  Attribute descCarro.
	 */
	private String descCarro;

	/**
	 *  Attribute descCompletaCarro.
	 */
	private String descCompletaCarro;

	/**
	 *  Attribute codCentro.
	 */
	private String codCentro;

	/**
	 *  Attribute descCentro.
	 */
	private String descCentro;



	/**
	 *  Attribute codAlmacen.
	 */
	private String codAlmacen;

	/**
	 *  Attribute descAlmacen.
	 */
	private String descAlmacen;


	/**
	 *  Attribute idEstadoCarro.
	 */
	private EstadoCarro estadoCarro;

	/**
	 * Attribute idItinerario.
	 */
	private Itinerario itinerario;

	/**
	 * Attribute idTurno.
	 */
	private Turno turno;

	/**
	 *  Attribute codMotivoInhabilitacion.
	 */
	private Motivo motivoInhabilitacion;

	/**
	 *  Attribute fechaHoraInhabilitacion.
	 */
	private Date fechaHoraInhabilitacion;

	/**
	 *  Attribute observacionesInhabilitacion.
	 */
	private String observacionesInhabilitacion;


	/**
	 * Constructor.
	 * @param idCarro Integer
	 */
	public Carro(String idCarro) {
		super();
		this.idCarro = idCarro;
	}

	/**
	 * Constructor por defecto.
	 */
	public Carro() {
		super();
	}

	/** Getter.
	 * @return idCarro
	 */
	@Basic
	@Column(name = "IDCARRO", length = 25)
	public String getIdCarro() {
		return idCarro;
	}


	/** Setter.
	 * @param idCarro the idCarro to set
	 */
	public void setIdCarro(String idCarro) {
		this.idCarro = idCarro;
	}

	/** Getter.
	 * @return descCarro
	 */
	@Basic
	@Column(name = "DESCCARRO", length = 80)
	public String getDescCarro() {
		return descCarro;
	}

	/** Setter.
	 * @param descCarro String
	 */
	public void setDescCarro(String descCarro) {
		this.descCarro = descCarro;
	}

	/** Getter.
	 * @return descCompletaCarro
	 */
	@Basic
	@Column(name = "DESCCOMPLETACARRO", length = 255)
	public String getDescCompletaCarro() {
		return descCompletaCarro;
	}

	/** Setter.
	 * @param descCompletaCarro String the descCompletaCarro to set
	 */
	public void setDescCompletaCarro(String descCompletaCarro) {
		this.descCompletaCarro = descCompletaCarro;
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



	/** Getter.
	 * @return codAlmacen
	 */
	@Basic
	@Column(name = "CODALMACEN", length = 25)
	public String getCodAlmacen() {
		return codAlmacen;
	}

	/** Setter.
	 * @param codAlmacen String
	 */
	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	/** Getter.
	 * @return descAlmacen
	 */
	@Basic
	@Column(name = "DESCALMACEN", length = 255)
	public String getDescAlmacen() {
		return descAlmacen;
	}

	/** Setter.
	 * @param descAlmacen String
	 */
	public void setDescAlmacen(String descAlmacen) {
		this.descAlmacen = descAlmacen;
	}

	/** Getter.
	 * @return estadoCarro
	 */
	@ManyToOne
	@JoinColumn(name = "CODESTADOCARRO")
	public EstadoCarro getEstadoCarro() {
		return estadoCarro;
	}

	/** Setter.
	 * @param estadoCarro Integer
	 */
	public void setEstadoCarro(EstadoCarro estadoCarro) {
		this.estadoCarro = estadoCarro;
	}

	/** Getter.
	 * @return itinerario
	 */
	@ManyToOne
	@JoinColumn(name = "CODITINERARIO")
	public Itinerario getItinerario() {
		return itinerario;
	}

	/** Setter.
	 * @param itinerario Itinerario
	 */
	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	/** Getter.
	 * @return turno
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CODTURNO")
	public Turno getTurno() {
		return turno;
	}

	/** Setter.
	 * @param turno Turno
	 */
	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	/**
	 * Obtiene el valor del campo "motivoInhabilitacion".
	 *
	 * @return El valor del campo "motivoInhabilitacion".
	 */
	@ManyToOne
	@JoinColumn(name = "CODMOTIVOINHABILITACION")
	public Motivo getMotivoInhabilitacion() {
		return motivoInhabilitacion;
	}

	/**
	 * Establece el valor del campo "motivoInhabilitacion".
	 *
	 * @param motivoInhabilitacion
	 *            El valor del campo "motivoInhabilitacion".
	 */
	public void setMotivoInhabilitacion(Motivo motivoInhabilitacion) {
		this.motivoInhabilitacion = motivoInhabilitacion;
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
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_CARRO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODCARRO")
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

}
