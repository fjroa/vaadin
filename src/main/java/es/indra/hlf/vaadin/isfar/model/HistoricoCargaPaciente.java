package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 * Almacena informacion del cambio de carga de un determinado medicamento para un paciente en un carro durante
 * la preparacion del mismo.
 * @author tnevado
 */
@SuppressWarnings("serial")
@Entity
@BatchSize(size=500)
@Table(name = "CARRO_UNI_HISTORICO_CARGA")
@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_CARRO_UNI_HISTORICO", allocationSize = 1)
public class HistoricoCargaPaciente implements Serializable, Comparable < HistoricoCargaPaciente > {

	/**
	 * Constante para asignar al campo tipoModificacion cuando la modificacion supone anadir tomas de
	 * prescripciones que aun no estaban en el carro.
	 * TIPO_CAMBIO_CREACION int.
	 */
	public static final int TIPO_CAMBIO_CREACION = 0;
	/**
     * Constante para asignar al campo tipoModificacion cuando la modificacion supone modificar las tomas de
	 * prescripciones que estaban en el carro.
	 * TIPO_CAMBIO_MODIFICACION int.
	 */
	public static final int TIPO_CAMBIO_MODIFICACION = 1;
	/**
	 * Constante para asignar al campo tipoModificacion cuando la modificacion supone eliminar tomas de
	 * prescripciones que estaban en el carro.
	 * TIPO_CAMBIO_ANULACION int.
	 */
	public static final int TIPO_CAMBIO_ANULACION = 2;

	/**
	 * Constante para asignar al campo causa cuando el cambio se trata del traslado de un paciente.
	 * CAUSA_UBICACION_TRASLADO String = "causa_cambio_traslado".
	 */
	public static final String CAUSA_TRASLADO = "causa_cambio_traslado";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata del intercambio de dos
	 * pacientes.
	 * CAUSA_INTERCAMBIO String = "causa_cambio_intercambio".
	 */
	public static final  String CAUSA_INTERCAMBIO = "causa_cambio_intercambio";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la confirmacion del
     * ingreso de un paciente. Lo que conlleva el paso de ubicacion no incluida en itinerario a ubicacion si
	 * incluida en itinerario.
	 * CAUSA_CONFIRMACION_INGRESO String = "causa_cambio_confirmacion_ingreso".
	 */
	public static final  String CAUSA_CONFIRMACION_INGRESO = "causa_cambio_confirmacion_ingreso";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la confiramcion del
	 * alta temporal de un paciente o la creacion del alta temporal confirmada. Lo que conlleva el paso de
	 * estado con ubicacion incluida en itinerario a estado sin ubicacion.
     * CAUSA_CREACION_CONFIRMACION_ALTA_TEMPORAL String = "causa_cambio_creacion_confirmacion_alta_temporal".
	 */
	public static final  String CAUSA_CREACION_CONFIRMACION_ALTA_TEMPORAL
		= "causa_cambio_creacion_confirmacion_alta_temporal";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la creacion del
     * reingreso de un paciente sin confirmar. Lo que conlleva el paso de estado sin ubicacion a ubicacion no
	 * incluida en itinerario.
	 * CAUSA_CREACION_REINGRESO String = "causa_cambio_creacion_reingreso".
	 */
	public static final  String CAUSA_CREACION_REINGRESO = "causa_cambio_creacion_reingreso";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la confirmacion del
     * reingreso de un paciente o Creacion de un reingreso confirmado. Lo que conlleva el paso de ubicacion no
	 * incluida en itinerario a ubicacion si incluida en itinerario.
	 * CAUSA_CONFIRMACION_REINGRESO String = "causa_cambio_confirmacion_reingreso".
	 */
	public static final  String CAUSA_CONFIRMACION_REINGRESO = "causa_cambio_confirmacion_reingreso";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la anulacion del alta
	 * temporal de un paciente (equivalente a reingreso temporal). Lo que conlleva el paso de estado sin
	 * ubicacion, a estar con ubicacion incluyda en itinerario.
	 * CAUSA_ANULACION_ALTA_TEMPORAL String = "causa_cambio_anulacion_alta_temporal".
	 */
	public static final  String CAUSA_ANULACION_ALTA_TEMPORAL = "causa_cambio_anulacion_alta_temporal";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la anulacion del
     * reingreso temporal de un paciente (equivalente a alta temporal). Lo que conlleva el paso de estado con
	 * ubicacion, a estar sin ubicacion.
	 * CAUSA_ANULACION_REINGRESO_TEMPORAL String = "causa_cambio_anulacion_reingreso_temporal".
	 */
	public static final  String CAUSA_ANULACION_REINGRESO_TEMPORAL
		= "causa_cambio_anulacion_reingreso_temporal";
	/**
     * Constante para asignar al campo causa cuando el cambio se trata de la anulacion de
	 * la prescripcion desde el modulo de prescripciones.
	 * CAUSA_CREACION_PRESC String = "causa_cambio_creacion_prescripcion".
	 */
	public static final  String CAUSA_CREACION_PRESC = "causa_cambio_creacion_prescripcion";
	/**
     * Constante para asignar al campo causa cuando el cambio se trata de la modificacion de
	 * la prescripcion desde el modulo de prescripciones.
	 * CAUSA_MODIFICACION_PRESC String = "causa_modificacion_prescripcion".
	 */
	public static final  String CAUSA_MODIFICACION_PRESC = "causa_cambio_modificacion_prescripcion";
	/**
     * Constante para asignar al campo causa cuando el cambio se trata de la anulacion de
	 * la prescripcion desde el modulo de prescripciones.
	 * CAUSA_CANCELACION_PRESC String = "causa_cambio_cancelacion_prescripcion".
	 */
	public static final  String CAUSA_CANCELACION_PRESC = "causa_cambio_cancelacion_prescripcion";
	/**
     * Constante para asignar al campo causa cuando el cambio se trata de la anulacion de
	 * la prescripcion desde el modulo de prescripciones al realizar una modificación.
	 * CAUSA_CANCELACION_POR_MOD_PRESC String = "causa_cambio_cancelacion_por_mod_presc".
	 */
	public static final  String CAUSA_CANCELACION_POR_MOD_PRESC = "causa_cambio_cancelacion_por_mod_presc";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la modificación del estado de
	 * necesidad de reposicion. CAUSA_NECESITA_REPOSICION String = "causa_cambio_necesita_reposicion".
	 */
	public static final  String CAUSA_NECESITA_REPOSICION = "causa_cambio_necesita_reposicion";
	/**
     * Constante para asignar al campo causa cuando el cambio se trata de la anulacion.
	 * CAUSA_PASO_ITINERARIO_CONFIRMAR String = "causa_cambio_paso_a_itinerario_al_confirmar".
	 */
	public static final  String CAUSA_PASO_ITINERARIO_CONFIRMAR
		= "causa_cambio_paso_a_itinerario_al_confirmar";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la anulacion .
	 * CAUSA_VALIDAR_PRESC String = "causa_cambio_validar_prescripcion".
	 */
	public static final  String CAUSA_VALIDAR_PRESC = "causa_cambio_validar_prescripcion";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata de la reactivación .
	 * CAUSA_REACTIVAR_PRESC String = "causa_cambio_reactivar_prescripcion".
	 */
	public static final  String CAUSA_REACTIVAR_PRESC = "causa_cambio_reactivar_prescripcion";
	/**
	 * Constante para asignar al campo causa cuando el cambio se trata del recalculo
	 *  de tomas en fluidos al seleccionar productos concretos.
	 * CAUSA_RECALCULO_TOMAS_FLUIDO String = "causa_cambio_recalculo_tomas_fluido".
	 */
	public static final  String CAUSA_RECALCULO_TOMAS_FLUIDO = "causa_cambio_recalculo_tomas_fluido";
	
	/**
	 * Constructor.
	 *
	 */
	public HistoricoCargaPaciente() {
		super();
	}

	/**
	 * Identificador de la entidad.
	 * id Integer.
	 */
	private Integer id;
	/**
     * CarroUnidosisDetalle para el medicamento al que esta asociado dentro de un carro el historico de carga
	 * del paciente.
	 * carroUnidosisDetalle CarroUnidosisDetalle.
	 */
	private CarroUnidosisDetalle carroUnidosisDetalle;
	/**
	 * Paciente al que esta asociado el registro.
	 * paciente Paciente.
	 */
	private Paciente paciente;
	/**
	 * Cantidad actual de medicamento para el paciente en el carro en el que se encuentra.
	 * cantidadActual float.
	 */
	private float cantidadActual;
	/**
     * Cantidad de medicamento en el momento de la carga completa para el paciente en el carro en el que se
	 * encuentra.
	 * cantidadCargaCompleta float.
	 */
	private float cantidadCargaCompleta;
	/**
	 * Cantidad de medicamento en el momento de la generacion anterior a la actual para el paciente en el
	 * carro en el que se encuentra.
	 * cantidadGeneracionAnterior float.
	 */
	private float cantidadGeneracionAnterior;


	/**
	 * horasAdmActual String.
	 */
	private String horasAdmActual;

	/**
	 * horasAdmCargaCompleta String.
	 */
	private String horasAdmCargaCompleta;

	/**
	 * horasAdmGeneracionAnterior String.
	 */
	private String horasAdmGeneracionAnterior;
	/**
	 * Tipo de modificacion.
	 * tipoModificacion Integer.
	 */
	private Integer tipoModificacion;
	/**
	 * Causa de la modificacion
	 * causaModificacion String.
	 */
	private String causaModificacion;
	/**
	 * Fecha en la que se produjo la modificacion.
	 * fechaHoraModificacion Date.
	 */
	private Date fechaHoraModificacion;

	/**
	 * Lista de Administraciones del medicamento a los pacientes.
	 */
    private SortedSet < AdministracionPrescripcion >
		administracionesPaciente = new TreeSet < AdministracionPrescripcion >();
	/**
     * Attribute codUsuarioAuditoria.
     */
    private String codUsuarioAuditoria; //NOPMD

    /**
     * Devuelve el valor de codUsuarioAuditoria.
     * @return the codUsuarioAuditoria
     */
    @Column(name = "USER_AUDIT")
    public String getCodUsuarioAuditoria() {
        return codUsuarioAuditoria;
    }
    /**
     * Modifica el valor de codUsuarioAuditoria.
     * @param codUsuarioAuditoriaValue a asignar
     */
    public void setCodUsuarioAuditoria(final String codUsuarioAuditoriaValue) { //NOPMD
        this.codUsuarioAuditoria = codUsuarioAuditoriaValue;
    }
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODCARROUNIHISTORICO")
	public Integer getId() {
		return id;
	}
	/**
	 * Establece el valor del campo "id".
	 *
	 * @param idAux
	 *            El valor del campo "id".
	 */
	public void setId(final Integer idAux) {
		this.id = idAux;
	}
	/**
	 * Obtiene el valor del campo "carroUnidosisDetalle".
	 *
	 * @return El valor del campo "carroUnidosisDetalle".
	 */
	@ManyToOne
	@JoinColumn(name = "CODCARROUNIDOSISDETALLE")
	public CarroUnidosisDetalle getCarroUnidosisDetalle() {
		return carroUnidosisDetalle;
	}
	/**
	 * Establece el valor del campo "carroUnidosisDetalle".
	 *
	 * @param cUnidosisDetalle
	 *            El valor del campo "carroUnidosisDetalle".
	 */
	public void setCarroUnidosisDetalle(final CarroUnidosisDetalle cUnidosisDetalle) {
		this.carroUnidosisDetalle = cUnidosisDetalle;
	}
	/**
	 * Obtiene el valor del campo "paciente".
	 *
	 * @return El valor del campo "paciente".
	 */
	@ManyToOne
	@JoinColumn(name = "CODPaciente")
	public Paciente getPaciente() {
		return paciente;
	}
	/**
	 * Establece el valor del campo "paciente".
	 *
	 * @param pac
	 *            El valor del campo "paciente".
	 */
	public void setPaciente(final Paciente pac) {
		this.paciente = pac;
	}
	/**
	 * Obtiene el valor del campo "cantidadActual".
	 *
	 * @return El valor del campo "cantidadActual".
	 */
	@Column(name = "CANTIDAD")
	public float getCantidadActual() {
		return cantidadActual;
	}
	/**
	 * Establece el valor del campo "cantidadActual".
	 *
	 * @param cActual
	 *            El valor del campo "cantidadActual".
	 */
	public void setCantidadActual(final float cActual) {
		this.cantidadActual = cActual;
	}
	/**
	 * Obtiene el valor del campo "cantidadCargaCompleta".
	 *
	 * @return El valor del campo "cantidadCargaCompleta".
	 */
	@Column(name = "CANTIDADCARGACOMPLETA")
	public float getCantidadCargaCompleta() {
		return cantidadCargaCompleta;
	}
	/**
	 * Establece el valor del campo "cantidadCargaCompleta".
	 *
	 * @param cCargaCompleta
	 *            El valor del campo "cantidadCargaCompleta".
	 */
	public void setCantidadCargaCompleta(final float cCargaCompleta) {
		this.cantidadCargaCompleta = cCargaCompleta;
	}
	/**
	 * Obtiene el valor del campo "cantidadGeneracionAnterior".
	 *
	 * @return El valor del campo "cantidadGeneracionAnterior".
	 */
	@Column(name = "CANTIDADULTIMAGENERACION")
	public float getCantidadGeneracionAnterior() {
		return cantidadGeneracionAnterior;
	}
	/**
	 * Establece el valor del campo "cantidadGeneracionAnterior".
	 *
	 * @param cGeneracionAnterior
	 *            El valor del campo "cantidadGeneracionAnterior".
	 */
	public void setCantidadGeneracionAnterior(final float cGeneracionAnterior) {
		this.cantidadGeneracionAnterior = cGeneracionAnterior;
	}



	/**
	 * Obtiene el valor del campo "horasAdmActual".
	 *
	 * @return El valor del campo "horasAdmActual".
	 */
	public String getHorasAdmActual() {
		return horasAdmActual;
	}
	/**
	 * Establece el valor del campo "horasAdmActual".
	 *
	 * @param hAdmActual
	 *            El valor del campo "horasAdmActual".
	 */
	public void setHorasAdmActual(final String hAdmActual) {
		this.horasAdmActual = hAdmActual;
	}
	/**
	 * Obtiene el valor del campo "horasAdmCargaCompleta".
	 *
	 * @return El valor del campo "horasAdmCargaCompleta".
	 */
	public String getHorasAdmCargaCompleta() {
		return horasAdmCargaCompleta;
	}
	/**
	 * Establece el valor del campo "horasAdmCargaCompleta".
	 *
	 * @param hAdmCargaCompleta
	 *            El valor del campo "horasAdmCargaCompleta".
	 */
	public void setHorasAdmCargaCompleta(final String hAdmCargaCompleta) {
		this.horasAdmCargaCompleta = hAdmCargaCompleta;
	}
	/**
	 * Obtiene el valor del campo "horasAdmGeneracionAnterior".
	 *
	 * @return El valor del campo "horasAdmGeneracionAnterior".
	 */
	public String getHorasAdmGeneracionAnterior() {
		return horasAdmGeneracionAnterior;
	}
	/**
	 * Establece el valor del campo "horasAdmGeneracionAnterior".
	 *
	 * @param hAdmGeneracionAnterior
	 *            El valor del campo "horasAdmGeneracionAnterior".
	 */
	public void setHorasAdmGeneracionAnterior(final String hAdmGeneracionAnterior) {
		this.horasAdmGeneracionAnterior = hAdmGeneracionAnterior;
	}
	/**
	 * Obtiene el valor del campo "tipoModificacion".
	 *
	 * @return El valor del campo "tipoModificacion".
	 */
	@Column
	public Integer getTipoModificacion() {
		return tipoModificacion;
	}
	/**
	 * Establece el valor del campo "tipoModificacion".
	 *
	 * @param tModificacion
	 *            El valor del campo "tipoModificacion".
	 */
	public void setTipoModificacion(final Integer tModificacion) {
		this.tipoModificacion = tModificacion;
	}
	/**
	 * Obtiene el valor del campo "causaModificacion".
	 *
	 * @return El valor del campo "causaModificacion".
	 */
	@Column
	public String getCausaModificacion() {
		return causaModificacion;
	}
	/**
	 * Establece el valor del campo "causaModificacion".
	 *
	 * @param cModificacion
	 *            El valor del campo "causaModificacion".
	 */
	public void setCausaModificacion(final String cModificacion) {
		this.causaModificacion = cModificacion;
	}
	/**
	 * Obtiene el valor del campo "fechaHoraModificacion".
	 *
	 * @return El valor del campo "fechaHoraModificacion".
	 */
	@Column
	public Date getFechaHoraModificacion() {
		return fechaHoraModificacion;
	}
	/**
	 * Establece el valor del campo "fechaHoraModificacion".
	 *
	 * @param fModificacion
	 *            El valor del campo "fechaHoraModificacion".
	 */
	public void setFechaHoraModificacion(final Date fModificacion) {
		this.fechaHoraModificacion = fModificacion;
	}

	/**
	 * Obtiene el valor del campo "administracionesPaciente".
	 *
	 * @return El valor del campo "administracionesPaciente".
	 */
	@OneToMany(mappedBy = "historicoCargaPaciente")
    @Sort(type = SortType.NATURAL)
    @Fetch(FetchMode.SUBSELECT)
	public SortedSet < AdministracionPrescripcion > getAdministracionesPaciente() {
		return administracionesPaciente;
	}
	/**
	 * Establece el valor del campo "administracionesPaciente".
	 *
	 * @param admsPaciente
	 *            El valor del campo "administracionesPaciente".
	 */
	public void setAdministracionesPaciente(
			final SortedSet < AdministracionPrescripcion > admsPaciente) {
		this.administracionesPaciente = admsPaciente;
	}
	/**
	 * Compara dos objetos de tipo HistoricoCargaPaciente.
	 * @param hcp
	 * @return int
	 */
	public int compareTo(final HistoricoCargaPaciente hcp) {
		int ret = 0;

		if (hcp.getPaciente() == null) {
			if (this.paciente == null) {
				ret = 0;
			} else {
				ret = 1;
			}
		} else {
			if (this.paciente == null) {
				ret = -1;
			} else {
				ret = this.getPaciente().getId().compareTo(hcp.getPaciente().getId());				
			}
		}
		if (ret == 0) {
			if (hcp.getCarroUnidosisDetalle() == null) {
				if (this.carroUnidosisDetalle == null) {
					ret = 0;
				} else {
					ret = 1;
				}
			} else {
				if (this.carroUnidosisDetalle == null) {
					ret = -1;
				} else {
                    ret = this.getCarroUnidosisDetalle().getCodMedicamento().compareTo(
                            hcp.getCarroUnidosisDetalle().getCodMedicamento());
				}
			}
		}
		if (ret == 0) {
			if (hcp.getCarroUnidosisDetalle() == null) {
				if (this.carroUnidosisDetalle == null) {
					ret = 0;
				} else {
					ret = 1;
				}
			} else {
				if (this.carroUnidosisDetalle == null) {
					ret = -1;
				} else {
					if (this.getCarroUnidosisDetalle().getUnidades() != null
							&& hcp.getCarroUnidosisDetalle().getUnidades() != null) {
						ret = this.getCarroUnidosisDetalle().getUnidades().compareTo(
	                            hcp.getCarroUnidosisDetalle().getUnidades());
					}                    
				}
			}
		}
		if (ret == 0) {
			if (hcp == null) {
				ret = 1;
			} else {
				if (hcp.getFechaHoraModificacion() == null) {
					if (this.fechaHoraModificacion == null) {
						ret = 0;
					} else {
						ret = 1;
					}
				} else {
					if (this.getFechaHoraModificacion() == null) {
						ret = -1;
					} else {
                        ret = this.fechaHoraModificacion.compareTo(hcp.getFechaHoraModificacion());
					}
				}
			}
		}		
		return ret;
	}
	/**
	 * Metodo delegado.
	 * @param ap AdministracionPrescripcion
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addAdministracionPrescripcion(final AdministracionPrescripcion ap) {
		return administracionesPaciente.add(ap);
	}
	/**
	 * Metodo delegado.
	 * @param ap AdministracionPrescripcion
	 * @return boolean
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean removeAdministracionPrescripcion(final AdministracionPrescripcion ap) {
		return administracionesPaciente.remove(ap);
	}

	/**
	 * Devuelve una cadena que representa las horas de administración de un medicamento
	 * para un paciente en un carro.
	 * @return String
	 */
	private String horasAdministracionToString() {
		String ret = null;
		if (administracionesPaciente != null && !administracionesPaciente.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			for (AdministracionPrescripcion ap : administracionesPaciente) {
				if (ap.isActivo()) {
                  //  sb.append(DateFormatUtils.format("HHmm", ap.getFechaHoraPrevistaAdmin()));
				}
			}
			ret = sb.toString();
		}
		return ret;
	}

	/**
	 *  Actualiza la cadena que representa las horas de administración.
	 */
	public void actualizaHorasAdmNuevaGeneracion() {
		this.horasAdmGeneracionAnterior = this.horasAdmActual;
		this.horasAdmActual = horasAdministracionToString();
	}

	/**
	 *  Actualiza la cadena que representa las horas de administración.
	 */
	public void actualizaHorasAdmActual() {
		this.horasAdmActual = horasAdministracionToString();
	}

	/**
	 * Inicializa la cadena que representa las horas de administración en la carga completa.
	 */
	public void initHorasAdmCargaCompleta() {
		this.horasAdmCargaCompleta = horasAdministracionToString();
		this.horasAdmActual = horasAdministracionToString();
	}
	/**
	 * Indica si la causa indicada es de una creacion o modificacion.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esCreacionModificacion(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_CREACION_PRESC.equals(causa)
					|| CAUSA_MODIFICACION_PRESC.equals(causa)
					|| CAUSA_VALIDAR_PRESC.equals(causa)) {
				// Primera generación al crear / modificar /validar prescripciones.
				ret = true;
			}
			if (CAUSA_TRASLADO.equals(causa)
					|| CAUSA_INTERCAMBIO.equals(causa)
					|| CAUSA_CONFIRMACION_INGRESO.equals(causa)
					|| CAUSA_CONFIRMACION_REINGRESO.equals(causa)) {
				//Generar al hacer un cambio de ubicación.
				ret = true;
			}
		}
		return ret;
	}
	//IBCSB-3670 No se está mostrando el estado en progreso en pacientes al preparar carro
	/**
	 * Indica si la causa indicada es de una validacion.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esValidacion(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_VALIDAR_PRESC.equals(causa)) {
				// Primera generación al crear / modificar /validar prescripciones.
				ret = true;
			}
		}
		return ret;
	}
	//FIN - IBCSB-3670 No se está mostrando el estado en progreso en pacientes al preparar carro
	/**
	 * Indica si la causa indicada es de uncambio de ubicación.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esCambioUbicaon(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_TRASLADO.equals(causa)
					|| CAUSA_INTERCAMBIO.equals(causa)
					|| CAUSA_CONFIRMACION_INGRESO.equals(causa)
					|| CAUSA_CONFIRMACION_REINGRESO.equals(causa)) {
				//Generar al hacer un cambio de ubicación.
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de un traslado.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esTraslado(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_TRASLADO.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de un Intercambio.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esIntercambio(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_INTERCAMBIO.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de la anulación de un alta temporal.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esAnulAltaTemp(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_ANULACION_ALTA_TEMPORAL.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de la anulación de un reingreso temporal.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esAnulReingresoTemp(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_ANULACION_REINGRESO_TEMPORAL.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de la confirmación de un ingreso.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esConfIngreso(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_CONFIRMACION_INGRESO.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de la confirmación de un reingreso.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esConfReingreso(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_CONFIRMACION_REINGRESO.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de la creación de un alta temporal confirmada o la confirmación alta temporal.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esCreacionConfAltaTemp(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_CREACION_CONFIRMACION_ALTA_TEMPORAL.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de la ccreación de un reingreso sin confirmar.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esCreacionReingreso(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_CREACION_REINGRESO.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de un cambio en el estado de necesidad de reposicion.
	 *
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esCambioNecesidadRepo(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_NECESITA_REPOSICION.equals(causa)) {
				// Generar al haber un cambio en el
				//estado de necesidad de reposicion.
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de una creacion.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esCreacion(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_CREACION_PRESC.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de una modificacion.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esModificacion(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_MODIFICACION_PRESC.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de una reactivacion.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esReactivacion(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_REACTIVAR_PRESC.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de una anulacion.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esAnulacion(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_CANCELACION_PRESC.equals(causa) || CAUSA_CANCELACION_POR_MOD_PRESC.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	/**
	 * Indica si la causa indicada es de una anulación o reactivacion.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esAnulacionReactivacion(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (esAnulacion(causa)
					|| esReactivacion(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * Indica si la causa indicada es el recalculo de tomas de un fluido.
	 * @param causa String
	 * @return boolean
	 */
	public static boolean esRecalculoTomasFluido(final String causa) {
		boolean ret = false;
		if (causa != null) {
			if (CAUSA_RECALCULO_TOMAS_FLUIDO.equals(causa)) {
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append(">>>HistoricoCargaPaciente {id:" + id);
		ret.append(" carroUnidosisDetalle:" + carroUnidosisDetalle);
		ret.append(" paciente:" + paciente);
		ret.append(" cantidadActual:" + cantidadActual);
		ret.append(" cantidadCargaCompleta:" + cantidadCargaCompleta);
		ret.append(" cantidadGeneracionAnterior:" + cantidadGeneracionAnterior);
//		ret.append(" horasAdmActual:" + horasAdmActual);
//		ret.append(" horasAdmCargaCompleta:" + horasAdmCargaCompleta);
//		ret.append(" horasAdmGeneracionAnterior:" + horasAdmGeneracionAnterior);
		ret.append(" tipoModificacion:" + tipoModificacion);
		ret.append(" causaModificacion:" + causaModificacion);
		ret.append(" fechaHoraModificacion:" + fechaHoraModificacion);
		ret.append(" codUsuarioAuditoria:" + codUsuarioAuditoria);
		ret.append("}");
		return ret.toString();
	}
	
	
}
