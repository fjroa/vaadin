package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase de dominio para la entidad Turno.
 * @author INDRA
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TURNO")
public class Turno extends EntidadBase implements Serializable {

	/**
	 * TIPO_TURNO_SEMANAL String Constante para tipo de turno semanal.
	 */
	public static final String TIPO_TURNO_SEMANAL = "S";
	/**
	 * TIPO_TURNO_DIARIO String Constante para tipo de turno diario.
	 */
	public static final String TIPO_TURNO_DIARIO = "D";
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * Attribute idTurno.
	 */
	private String idTurno;

	/**
	 * Attribute descTurno.
	 */
	private String descTurno;

	/**
	 * Attribute tipo.
	 */
	private String tipo;

	/**
	 * Attribute diaDesde.
	 */
	private Integer diaDesde;

	/**
	 * Attribute diaHasta.
	 */
	private Integer diaHasta;

	/**
	 * Attribute horaInicio.
	 */
	private Date horaInicio;

	/**
	 * Attribute horaFin.
	 */
	private Date horaFin;

	/**
	 * Attribute numCarros.
	 */
	private Integer numCarros;

	/**
	 *  Attribute fechaHoraInhabilitacion.
	 */
	private Date fechaHoraInhabilitacion;
	/**
	 *  Attribute codMotivoInhabilitacion.
	 */
	private Integer codMotivoInhabilitacion;
	/**
	 *  Attribute observaciones.
	 */
	private String observaciones;

	/**
	 *  codigo del centro del turno.
	 */
	private String codCentro;

	/**
	 *  descripcion del centro del turno.
	 */
	private String descCentro;

	/**
	 * Constructor por codigo.
	 * @param id Integer
	 */
	public Turno(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Constructor vacio.
	 *
	 */
	public Turno() {
		super();
	}

	/**
	 * Obtiene el valor del campo "id".
	 * @return El valor del campo "id".
	 */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_TURNO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODTURNO")
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

	/** Getter.
	 * @return idTurno
	 */
	@Basic
	@Column(name = "IDTURNO", length = 25)
	public String getIdTurno() {
		return idTurno;
	}

	/** Setter.
	 * @param idTurno new value for idTurno
	 */
	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}

	/** Getter.
	 * @return descTurno
	 */
	@Basic
	@Column(name = "DESCTURNO", length = 80)
	public String getDescTurno() {
		return descTurno;
	}

	/** Setter.
	 * @param descTurno the descTurno to set
	 */
	public void setDescTurno(String descTurno) {
		this.descTurno = descTurno;
	}

	/** Getter.
	 * @return tipo
	 */
	@Basic
	@Column(name = "TIPO", length = 1)
	public String getTipo() {
		return tipo;
	}

	/** Setter.
	 * @param tipo new value for tipoTurno
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/** Getter.
	 * @return diaDesde
	 */
	@Basic
	@Column(name = "DIADESDE", length = 15)
	public Integer getDiaDesde() {
		return diaDesde;
	}

	/** Setter.
	 * @param diaDesde new value for diaDesde
	 */
	public void setDiaDesde(Integer diaDesde) {
		this.diaDesde = diaDesde;
	}

	/** Getter.
	 * @return diaHasta
	 */
	@Basic
	@Column(name = "DIAHASTA", length = 15)
	public Integer getDiaHasta() {
		return diaHasta;
	}

	/** Setter.
	 * @param diaHasta new value for diaHasta
	 */
	public void setDiaHasta(Integer diaHasta) {
		this.diaHasta = diaHasta;
	}

	/** Getter.
	 * @return the horaInicio
	 */
	@Column
	public Date getHoraInicio() {
		return horaInicio;
	}

	/** Setter.
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	/** Getter.
	 * @return the horaFin
	 */
	@Column
	public Date getHoraFin() {
		return horaFin;
	}

	/** Setter.
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	/** Getter.
	 * @return numCarros
	 */
	@Basic
	@Column(name = "NUMCARROS")
	public Integer getNumCarros() {
		return numCarros;
	}

	/** Setter.
	 * @param numCarros the nCarros to set
	 */
	public void setNumCarros(Integer numCarros) {
		this.numCarros = numCarros;
	}



	/** Getter.
	 * @return fechaHoraInhabilitacion
	 */
	public Date getFechaHoraInhabilitacion() {
		return fechaHoraInhabilitacion;
	}

	/** Setter.
	 * Modifica la fecha de inhabilitacion del turno
	 * @param fechaHoraInhabilitacion Date
	 */
	public void setFechaHoraInhabilitacion(Date fechaHoraInhabilitacion) {
		this.fechaHoraInhabilitacion = fechaHoraInhabilitacion;
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
	 * @return observaciones
	 */
	@Basic
	@Column(name = "OBSERVACIONES", length = 255)
	public String getObservaciones() {
		return observaciones;
	}

	/** Setter.
	 * @param observaciones String
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
	 * Calcula el rango de fechas que aplica a un turno, devuelve una secuencia de fechas cada par de las
	 * cuales es un rango de fechas que esta incluido en el turno.
	 *
	 * @param fechaGeneracion Date
     * @return List&lt;Date&gt; fecha de inicio y de fin del rango que aplica para la generacion del carro.
	 */
	public List < Date > calcularFechasParaTurno(Date fechaGeneracion) {
		List < Date > ret = new ArrayList < Date >();
		Date dAux = null;
		GregorianCalendar calendar = new GregorianCalendar();
		GregorianCalendar calendarAux = new GregorianCalendar();
		calendarAux.setTime(horaInicio);
		GregorianCalendar calendarAux2 = new GregorianCalendar();
		calendarAux2.setTime(horaFin);
		calendar.setTime(fechaGeneracion);
		int diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		//Por defecto los valores de dia de la semana son Domingo->1 Sabado->7
		//Utilizamos Lunes->1 Domingo->7
		if (diaDeLaSemana == 1) {
			//Domingo
			diaDeLaSemana = 7;
		} else {
			diaDeLaSemana = diaDeLaSemana - 1;
		}
		if (this.tipo.equals(TIPO_TURNO_DIARIO)) {
			calendar.set(Calendar.HOUR_OF_DAY, calendarAux.get(Calendar.HOUR_OF_DAY));
			calendar.set(Calendar.MINUTE, calendarAux.get(Calendar.MINUTE));
			calendar.set(Calendar.SECOND, calendarAux.get(Calendar.SECOND));
			calendar.set(Calendar.MILLISECOND, calendarAux.get(Calendar.MILLISECOND));
			dAux = calendar.getTime();
			if (!fechaGeneracion.before(dAux)) {
				calendar.add(Calendar.DAY_OF_YEAR, +1);
			}
			dAux = calendar.getTime();
			ret.add(dAux);
			calendar.set(Calendar.HOUR_OF_DAY, calendarAux2.get(Calendar.HOUR_OF_DAY));
			calendar.set(Calendar.MINUTE, calendarAux2.get(Calendar.MINUTE));
			calendar.set(Calendar.SECOND, calendarAux2.get(Calendar.SECOND));
			calendar.set(Calendar.MILLISECOND, calendarAux2.get(Calendar.MILLISECOND));
			if (!dAux.before(calendar.getTime())) {
				calendar.add(Calendar.DAY_OF_YEAR, +1);
			}
			if (!dAux.before(calendar.getTime())) {
				calendar.add(Calendar.DAY_OF_YEAR, +1);
			}
			dAux = calendar.getTime();
			ret.add(dAux);
		} else {
			if (this.tipo.equals(TIPO_TURNO_SEMANAL)) {
				if (diaDeLaSemana <= diaDesde) {
                    calendar.set(Calendar.HOUR_OF_DAY, calendarAux.get(Calendar.HOUR_OF_DAY));
					calendar.set(Calendar.MINUTE, calendarAux.get(Calendar.MINUTE));
					calendar.set(Calendar.SECOND, calendarAux.get(Calendar.SECOND));
                    calendar.set(Calendar.MILLISECOND, calendarAux.get(Calendar.MILLISECOND));
					dAux = calendar.getTime();

					if (diaDeLaSemana < diaDesde) {
                        calendar.add(Calendar.DAY_OF_YEAR, Math.abs(diaDesde - diaDeLaSemana));
					} else {
						if (!fechaGeneracion.before(dAux)) {
                            //Si diaDeLaSemana = diaDesde pero despues de la hora inicio.
                            calendar.add(Calendar.DAY_OF_YEAR, +7);
						}
					}
				} else {
					//diaDeLaSemana > diaDesde
                    calendar.add(Calendar.DAY_OF_YEAR, 7 - Math.abs(diaDesde - diaDeLaSemana));
				}

				//Calculamos la cantidad de dias que hay en el rango
				int cantidadDias = 0;
				if (diaDesde < diaHasta) {
					cantidadDias = (diaHasta + 1) - diaDesde;
				} else if (diaDesde > diaHasta) {
					cantidadDias = (diaHasta + 8) - diaDesde;
				} else {
					//Si tiene el mismo dia desde y hasta, 
					if (horaFin.before(horaInicio)) {
						//Si la horaFin es anterior a la horaInicio
						//Se toma la fecha del diaHasta siguiente
						//por que debe ser posterior.
						cantidadDias = (diaHasta + 8) - diaDesde;
					} else {
						cantidadDias = (diaHasta + 1) - diaDesde;
					}
				}



				calendar.set(Calendar.HOUR_OF_DAY, calendarAux.get(Calendar.HOUR_OF_DAY));
				calendar.set(Calendar.MINUTE, calendarAux.get(Calendar.MINUTE));
				calendar.set(Calendar.SECOND, calendarAux.get(Calendar.SECOND));
				calendar.set(Calendar.MILLISECOND, calendarAux.get(Calendar.MILLISECOND));
				ret.add(calendar.getTime());
				if (cantidadDias > 1) {
					calendar.add(Calendar.DAY_OF_YEAR, cantidadDias - 1);
				}
				calendar.set(Calendar.HOUR_OF_DAY, calendarAux2.get(Calendar.HOUR_OF_DAY));
				calendar.set(Calendar.MINUTE, calendarAux2.get(Calendar.MINUTE));
				calendar.set(Calendar.SECOND, calendarAux2.get(Calendar.SECOND));
				calendar.set(Calendar.MILLISECOND, calendarAux2.get(Calendar.MILLISECOND));
				ret.add(calendar.getTime());
//				for (int i = cantidadDias; i > 0; i--) {
//                  calendar.set(Calendar.HOUR_OF_DAY, calendarAux.get(Calendar.HOUR_OF_DAY));
//					calendar.set(Calendar.MINUTE, calendarAux.get(Calendar.MINUTE));
//					calendar.set(Calendar.SECOND, calendarAux.get(Calendar.SECOND));
//                  calendar.set(Calendar.MILLISECOND, calendarAux.get(Calendar.MILLISECOND));
//					dAux = calendar.getTime();
//					ret.add(dAux);
//                  calendar.set(Calendar.HOUR_OF_DAY, calendarAux2.get(Calendar.HOUR_OF_DAY));
//					calendar.set(Calendar.MINUTE, calendarAux2.get(Calendar.MINUTE));
//					calendar.set(Calendar.SECOND, calendarAux2.get(Calendar.SECOND));
//                  calendar.set(Calendar.MILLISECOND, calendarAux2.get(Calendar.MILLISECOND));
//					if (horaInicio.before(horaFin)) {
//						dAux = calendar.getTime();
//						ret.add(dAux);
//						calendar.add(Calendar.DAY_OF_YEAR, +1);
//					} else {
//						calendar.add(Calendar.DAY_OF_YEAR, +1);
//						dAux = calendar.getTime();
//						ret.add(dAux);
//					}
//				}
			}
		}

		return ret;
	}
}
