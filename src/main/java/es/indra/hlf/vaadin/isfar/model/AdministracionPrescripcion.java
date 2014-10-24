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
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import es.indra.hlf.vaadin.isfar.vo.DosisAdminVO;

/**Clase de dominio para la entidad AdministracionPrescripcion.
 * @author INDRA
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ADMINISTRACION_PRESCRIPCION")
@SequenceGenerator(name = "SEQ_ADMIN_PRESCRIPCION",
		sequenceName = "SEQ_ADMIN_PRESCRIPCION", allocationSize = 1)
public class AdministracionPrescripcion implements Serializable, Comparable < AdministracionPrescripcion > {

	/**
	 * Codigo interno de la administracion de prescripcion.
	 */
	private Integer id;

	/**
	 * Codigo de la administracion.
	 */
	private AdministracionPaciente admPaciente;

	/**
	 * PrescripcionPaciente.
	 */
	private Tratamiento tratamiento;

    /**
     * PrescripcionMedicamento.
     */
    private PrescripcionMedicamento prescripcionMedicamento;

    /**
     * Aviso asociado en caso de suministros inmediatos o actualización de carros.
     * suministroInmediato SuministroInmediato.
     */
    private SuministroInmediato suministroInmediato;

	/**
	 * Motivo de la No administracion.
	 */
	private Motivo motivoNoAdm;

	/**
	 * Devuelto.
	 */
	private boolean devuelto;

	/**
	 * Observaciones sobre la NO administracion.
	 */
	private String observacionesNoAdministracion;

	 /**
     * Codigo de la ubicacion (Urgencias).
     */
    private String codUbicacion;

    /**
     * Descripcion de la ubicacion (Urgencias).
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
     * codCama String.  (Hospitalizacion)
     */
    private String codCama;

    /**
     * descCama String.  (Hospitalizacion)
     */
    private String descCama;

    /**
     * orden Integer.
     */
    private Integer orden;

    /**
     * activo boolean.
     */
    private boolean activo;

    /**
     * fechaHoraPrevistaAdministracion Date.
     */
    private Date fechaHoraPrevistaAdmin;

    /**
     * Detalle de medicamento en carro.
     */
    private CarroUnidosisDetalle carroUnidosisDetalle;

    /**
     * nResultados.
     */
    private Integer nResultados;

    /**
	 * Codigo de la tarea generada para controlar las administraciones.
     */
	private String codTarea;

	/**
	 * fechaHoraCita Date.
	 */
	private Date fechaHoraCita;

	/**
	 * codAgenda Integer.
	 */
	private String codAgenda;

	/**
	 * descAgenda String.
	 */
	private String descAgenda;

	/**
     * Codigo del servicio/especialidad de la cita.
     */
    private String codEspecialidadConsulta;

    /**
     * Descripcion del servicio/especialidad de la cita.
     */
    private String descEspecialidadConsulta;

	/**
	 * estado Estado.
	 */
	private Estado estado;
	/**
	 * noUnidosis boolean.
	 */
	private boolean noUnidosis;
	/**
	 * Indica que se indico que en esta toma se finalizo el envase actual
	 * (medicación no unidosis).
	 * necesitaReposicion boolean.
	 */
	private boolean necesitaReposicion;
	/**
	 * Indica si esta toma fue la primera de un nuevo envase
	 *  (medicación no unidosis).
	 * inicioEnvase boolean.
	 */
	private boolean inicioEnvase;

	/**
	 * historicoCargaPaciente HistoricoCargaPaciente.
	 */
	private HistoricoCargaPaciente historicoCargaPaciente;

	/**
	 * Fecha y hora de la primera firma.
	 */
	private Date fechaHoraFirma1;

	/**
	 * Codigo del profesional que hace la primera firma.
	 */
	private String codProfesionalFirma1;

	/**
	 * descProfesionalFirma1 String.
	 */
	private String descProfesionalFirma1;

	/**
	 * Fecha y hora de la segunda firma.
	 */
	private Date fechaHoraFirma2;

	/**
	 * Codigo del profesional que hace la segunda firma.
	 */
	private String codProfesionalFirma2;

	/**
	 * descProfesionalFirma2 String.
	 */
	private String descProfesionalFirma2;

	/**
	 * observacionesAdministracion String.
	 */
	private String observacionesAdministracion;

	/**
	 * Fecha y hora de inicio de la ventana temporal.
	 * (Fecha de la que partimos para poder modificar)
	 */
	private Date fechaHoraIniVentTemp;

	/**
	 * Codigo del profesional que puede modificar dentro de la ventana temporal.
	 */
	private String codProfesionalVentTemp;

	/**
	 * Descripcion del profesional que puede modificar dentro de la ventana temporal.
	 */
	private String descProfesionalVentTemp;

	/**
	 * Fecha y hora de la ultima actualizacion.
	 */
	private Date fechaHoraUltActualizacion;

	/**
	 * Codigo del profesional que realizo a ultima actualizacion.
	 */
	private String codProfesionalUltActualizacion;

	/**
	 * Descripcion del profesional que realizo la ultima actualizacion.
	 */
	private String descProfesionalUltActualizacion;

	/**
     * Indica si una toma se ha registrado como doble firma
     * valor 1 : Se marco como doble firma
     * valor 0: En caso contrario.
     */
    private boolean dobleFirma;

    /**
	 * fechaHoraNoAdministracion Date.
	 */
	private Date fechaHoraNoAdministracion;

	/**
	 * hbmVersion long.
	 */
	private long hbmVersion;
	
	/**
     * Attribute codUsuarioAuditoria.
     */
    private String codUsuarioAuditoria; //NOPMD
    
    /**
     * administracionesMarca Set<AdministracionPacienteMarca>.
     */
    private SortedSet<AdministracionPacienteMarca> administracionesMarca = new TreeSet<AdministracionPacienteMarca>();
    /**
     * lineaPosologia LineaPosologia.
     */
    private LineaPosologia lineaPosologia;

    
	  /*************/
	 /** METODOS **/
	/*************/

    /**
	 * Constructor.
	 * @param codAdmPrescripcion Integer
	 */
	public AdministracionPrescripcion(Integer codAdmPrescripcion) {
		super();
		this.id = codAdmPrescripcion;
	}

	/**
	 * Constructor por defecto.
	 */
	public AdministracionPrescripcion() {
		super();
	}

	/** Devuelvo el codigo de la administracion de la prescripcion.
	 * @return codAdmPrescripcion
	 */
	@Basic
	@Id
	@Column(name = "CODADMINISTRACIONPRESCRIPCION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADMIN_PRESCRIPCION")
	public Integer getId() {
		return id;
	}

	/** Estableco el codigo de la administracion de la prescripcion.
	 * @param codAdmPrescripcion the codAdmPrescripcion to set
	 */
	public void setId(Integer codAdmPrescripcion) {
		this.id = codAdmPrescripcion;
	}

	/** Devuelvo el objeto administracionPaciente.
	 * @return admPaciente
	 */
	@ManyToOne
	@JoinColumn(name = "CODADMINISTRACIONPACIENTE")
	@Cascade({CascadeType.ALL })
	public AdministracionPaciente getAdmPaciente() {
		return admPaciente;
	}

	/** Establezco el codigo de la administracion del paciente.
	 * @param admPaciente the codAdmPaciente to set
	 */
	public void setAdmPaciente(AdministracionPaciente admPaciente) {
		this.admPaciente = admPaciente;
	}

	/** Devuelvo el objeto Tratamiento.
	 * @return the tratamiento
	 */
	@ManyToOne
	@JoinColumn(name = "CODTRATAMIENTO")
	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	/** Establezco el objeto Tratamiento.
	 * @param tratamiento the Tratamiento to set
	 */
	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

    /** Devuelvo el objeto PrescripcionMedicamento.
     * @return the tratamiento
     */
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CODPRESCRIPCIONMEDICAMENTO")
    public PrescripcionMedicamento getPrescripcionMedicamento() {
        return prescripcionMedicamento;
    }

    /** Establezco el objeto PrescripcionMedicamento.
     * @param prescripcionMedicamento the PrescripcionMedicamento to set
     */
    public void setPrescripcionMedicamento(
                              PrescripcionMedicamento prescripcionMedicamento) {
        this.prescripcionMedicamento = prescripcionMedicamento;
    }


	

	/**
	 * Obtiene el valor del campo "suministroInmediato".
	 *
	 * @return El valor del campo "suministroInmediato".
	 */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CODADMININMEDIATAACTCARRO")
	public SuministroInmediato getSuministroInmediato() {
		return suministroInmediato;
	}

	/**
	 * Establece el valor del campo "suministroInmediato".
	 *
	 * @param suministroInmediato
	 *            El valor del campo "suministroInmediato".
	 */
	public void setSuministroInmediato(SuministroInmediato suministroInmediato) {
		this.suministroInmediato = suministroInmediato;
	}

	/** Devuelvo el objeto Motivo.
	 * @return the motivoNoAdm
	 */
	@ManyToOne
	@JoinColumn(name = "CODMOTIVONOADMINISTRACION")
	public Motivo getMotivoNoAdm() {
		return motivoNoAdm;
	}

	/** Establezco el objeto Motivo.
	 * @param motivoNoAdm the motivoNoAdm to set
	 */
	public void setMotivoNoAdm(Motivo motivoNoAdm) {
		this.motivoNoAdm = motivoNoAdm;
	}



	/**
	 * Obtiene el valor del campo "devuelto".
	 *
	 * @return El valor del campo "devuelto".
	 */
	@Column
	public boolean isDevuelto() {
		return devuelto;
	}

	/**
	 * Establece el valor del campo "devuelto".
	 *
	 * @param devuelto
	 *            El valor del campo "devuelto".
	 */
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	/** Devuelvo las observaciones de la No administracion.
	 * @return the observaciones
	 */
	@Basic
	@Column(name = "OBSERVACIONESNOADMINISTRACION", length = 255)
	public String getObservacionesNoAdministracion() {
		return observacionesNoAdministracion;
	}

	/** Establezco las observaciones de la No administracion.
	 * @param observaciones the observaciones to set
	 */
	public void setObservacionesNoAdministracion(String observaciones) {
		this.observacionesNoAdministracion = observaciones;
	}

	/** Devuelvo el codigo de ubicacion.
	 * @return the codUbicacion
	 */
	@Basic
	@Column(name = "CODUBICACION", length = 25)
	public String getCodUbicacion() {
		return codUbicacion;
	}

	/** Establezco el codigo de ubicacion.
	 * @param codUbicacion the codUbicacion to set
	 */
	public void setCodUbicacion(String codUbicacion) {
		this.codUbicacion = codUbicacion;
	}

	/** Devuelvo la descripcion de ubicacion.
	 * @return the descUbicacion
	 */
	@Basic
	@Column(name = "DESCUBICACION", length = 255)
	public String getDescUbicacion() {
		return descUbicacion;
	}

	/** Establezco la descripcion de ubicacion.
	 * @param descUbicacion the descUbicacion to set
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
	 * Obtiene el valor del campo "codCama".
	 *
	 * @return El valor del campo "codCama".
	 */
	@Basic
	@Column(name = "CODCAMA", length = 25)
	public String getCodCama() {
		return codCama;
	}

	/**
	 * Establece el valor del campo "codCama".
	 *
	 * @param codCama
	 *            El valor del campo "codCama".
	 */
	public void setCodCama(String codCama) {
		this.codCama = codCama;
	}

	/**
	 * Obtiene el valor del campo "descCama".
	 *
	 * @return El valor del campo "descCama".
	 */
	@Basic
	@Column(name = "DESCCAMA", length = 255)
	public String getDescCama() {
		return descCama;
	}

	/**
	 * Establece el valor del campo "descCama".
	 *
	 * @param descCama
	 *            El valor del campo "descCama".
	 */
	public void setDescCama(String descCama) {
		this.descCama = descCama;
	}

	/**
	 * Obtiene el valor del campo "carroUnidosisDetalle".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "carroUnidosisDetalle".
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODCARROUNIDOSISDETALLE")
	public CarroUnidosisDetalle getCarroUnidosisDetalle() {
		return carroUnidosisDetalle;
	}

	/**
	 * Establece el valor del campo "carroUnidosisDetalle".
	 *
	 * @author tnevado
	 *
	 * @param carroUnidosisDetalle
	 *            El valor del campo "carroUnidosisDetalle".
	 */
	public void setCarroUnidosisDetalle(CarroUnidosisDetalle carroUnidosisDetalle) {
		this.carroUnidosisDetalle = carroUnidosisDetalle;
	}


	/**
	 * Obtiene el valor del campo "fechaHoraPrevistaAdmin".
	 *
	 * @return El valor del campo "fechaHoraPrevistaAdmin".
	 */
	@Column(name = "FECHAHORAPREVISTAADMINISTRACIO")
	public Date getFechaHoraPrevistaAdmin() {
		return fechaHoraPrevistaAdmin;
	}

	/**
	 * Establece el valor del campo "fechaHoraPrevistaAdmin".
	 *
	 * @param fechaHoraPrevistaAdmin
	 *            El valor del campo "fechaHoraPrevistaAdmin".
	 */
	public void setFechaHoraPrevistaAdmin(Date fechaHoraPrevistaAdmin) {
		this.fechaHoraPrevistaAdmin = fechaHoraPrevistaAdmin;
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
	 * Obtiene el valor del campo "activo".
	 *
	 * @return El valor del campo "activo".
	 */
	@Column
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Establece el valor del campo "activo".
	 *
	 * @param activo
	 *            El valor del campo "activo".
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/** nResultados.
	 * @return the nResultados
	 */
	@Transient
	public Integer getNResultados() {
		return nResultados;
	}

	/** nResultados.
	 * @param resultados the nResultados to set
	 */
	public void setNResultados(Integer resultados) {
		nResultados = resultados;
	}

	/**
	 * Obtiene el valor del campo "codTarea".
	 * @return the codTarea
	 */
	@Column
	public String getCodTarea() {
		return codTarea;
	}

	/**
	 * Establece el valor del campo "codTarea".
	 * @param codTarea the codTarea to set
	 */
	public void setCodTarea(String codTarea) {
		this.codTarea = codTarea;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraCita".
	 * @return the fechaHoraCita
	 */
	@Column(name = "FECHAHORACITA")
	public Date getFechaHoraCita() {
		return fechaHoraCita;
	}

	/**
	 * Establece el valor del campo "fechaHoraCita".
	 * @param fechaHoraCita the fechaHoraCita to set
	 */
	public void setFechaHoraCita(Date fechaHoraCita) {
		this.fechaHoraCita = fechaHoraCita;
	}

	/**
	 * Obtiene el valor del campo "codAgenda".
	 * @return the codAgenda
	 */
	@Column(name = "CODAGENDA", length = 25)
	public String getCodAgenda() {
		return codAgenda;
	}

	/**
	 * Establece el valor del campo "codAgenda".
	 * @param codAgenda the codAgenda to set
	 */
	public void setCodAgenda(String codAgenda) {
		this.codAgenda = codAgenda;
	}

	/**
	 * Obtiene el valor del campo "descAgenda".
	 * @return the descAgenda
	 */
	@Column(name = "DESCAGENDA", length = 255)
	public String getDescAgenda() {
		return descAgenda;
	}

	/**
	 * Establece el valor del campo "descAgenda".
	 * @param descAgenda the descAgenda to set
	 */
	public void setDescAgenda(String descAgenda) {
		this.descAgenda = descAgenda;
	}

	/**
	 * Obtiene el valor del campo "codEspecialidadConsulta".
	 * @return the codEspecialidadConsulta
	 */
	@Column(name = "CODSERVICIOAGENDA", length = 25)
	public String getCodEspecialidadConsulta() {
		return codEspecialidadConsulta;
	}

	/**
	 * Establece el valor del campo "codEspecialidadConsulta".
	 * @param codEspecialidadConsulta the codEspecialidadConsulta to set
	 */
	public void setCodEspecialidadConsulta(String codEspecialidadConsulta) {
		this.codEspecialidadConsulta = codEspecialidadConsulta;
	}

	/**
	 * Obtiene el valor del campo "descEspecialidadConsulta".
	 * @return the descEspecialidadConsulta
	 */
	@Column(name = "DESCSERVICIOAGENDA", length = 255)
	public String getDescEspecialidadConsulta() {
		return descEspecialidadConsulta;
	}

	/**
	 * Establece el valor del campo "descEspecialidadConsulta".
	 * @param descEspecialidadConsulta the descEspecialidadConsulta to set
	 */
	public void setDescEspecialidadConsulta(String descEspecialidadConsulta) {
		this.descEspecialidadConsulta = descEspecialidadConsulta;
	}

	/**
	 * Devulevo el objeto Estado.
	 * @return the estado
	 */
	@ManyToOne
	@JoinColumn(name = "CODESTADO")
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Establezco el objeto Estado.
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene el valor del campo "noUnidosis".
	 *
	 * @return El valor del campo "noUnidosis".
	 */
	@Column
	public boolean isNoUnidosis() {
		return noUnidosis;
	}

	/**
	 * Establece el valor del campo "noUnidosis".
	 *
	 * @param noUnidosis
	 *            El valor del campo "noUnidosis".
	 */
	public void setNoUnidosis(boolean noUnidosis) {
		this.noUnidosis = noUnidosis;
	}

	/**
	 * Obtiene el valor del campo "necesitaReposicion".
	 *
	 * @return El valor del campo "necesitaReposicion".
	 */
	@Column
	public boolean isNecesitaReposicion() {
		return necesitaReposicion;
	}

	/**
	 * Establece el valor del campo "necesitaReposicion".
	 *
	 * @param necesitaReposicion
	 *            El valor del campo "necesitaReposicion".
	 */
	public void setNecesitaReposicion(boolean necesitaReposicion) {
		this.necesitaReposicion = necesitaReposicion;
	}
	/**
	 * Obtiene el valor del campo "historicoCargaPaciente".
	 *
	 * @return El valor del campo "historicoCargaPaciente".
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODCARROUNIHISTORICO")
	@Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE, CascadeType.EVICT })
	public HistoricoCargaPaciente getHistoricoCargaPaciente() {
		return historicoCargaPaciente;
	}

	/**
	 * Establece el valor del campo "historicoCargaPaciente".
	 *
	 * @param historicoCargaPaciente
	 *            El valor del campo "historicoCargaPaciente".
	 */
	public void setHistoricoCargaPaciente(HistoricoCargaPaciente historicoCargaPaciente) {
		this.historicoCargaPaciente = historicoCargaPaciente;
	}
	/**
	 * Obtiene el valor del campo "hbmVersion".
	 *
	 * @return El valor del campo "hbmVersion".
	 */
	@Version
	@Column(name = "HBM_VERSION")
	public long getHbmVersion() {
		return hbmVersion;
	}

	/**
	 * Establece el valor del campo "hbmVersion".
	 *
	 * @param hbmVersion
	 *            El valor del campo "hbmVersion".
	 */
	public void setHbmVersion(long hbmVersion) {
		this.hbmVersion = hbmVersion;
	}



	/**
	 * Ordenacion.
	 * @param o AdministracionPrescripcion
	 * @return int
	 */
	public int compareTo(AdministracionPrescripcion o) {
		int ret = 0;
		if (o.getOrden() == null) {
			if (this.orden == null) {
				ret = 0;
			} else {
				ret = 1;
			}
		} else {
			if (this.orden == null) {
				ret = -1;
			} else {
				ret = o.orden.compareTo(this.orden);
			}
		}

		if (ret == 0) {
			if (o.getFechaHoraPrevistaAdmin() == null) {
				if (this.fechaHoraPrevistaAdmin == null) {
					ret = 0;
				} else {
					ret = 1;
				}
			} else {
				if (this.fechaHoraPrevistaAdmin == null) {
					ret = -1;
				} else {
                    ret = this.fechaHoraPrevistaAdmin.compareTo(o.getFechaHoraPrevistaAdmin());
				}
			}
		}
		if (ret == 0) {
			if (o.getId() == null) {
				if (this.id == null) {
					ret = 0;
				} else {
					ret = 1;
				}
			} else {
				if (this.id == null) {
					ret = -1;
				} else {
					ret = o.getId().compareTo(this.id);
				}
			}
		}
		if (ret == 0) {
			if (o.getPrescripcionMedicamento() == null) {
				if (this.prescripcionMedicamento == null) {
					ret = 0;
				} else {
					ret = 1;
				}
			} else {
				if (this.prescripcionMedicamento == null) {
					ret = -1;
				} else {
					ret = o.getPrescripcionMedicamento().getId()
                                .compareTo(this.prescripcionMedicamento.getId());
				}
			}
		}
		if (ret == 0) {
			if (o.getCodTarea() == null) {
				if (this.getCodTarea() == null) {
					ret = 0;
				} else {
					ret = 1;
				}
			} else {
				if (this.getCodTarea() == null) {
					ret = -1;
				} else {
					ret = o.getCodTarea().compareTo(this.getCodTarea());
				}
			}
		}
		return ret;
	}

	/**
     * Obtiene el valor del campo "fechaHoraFirma1".
     * @return the fechaHoraFirma1
     */
	@Column(name = "FECHAHORAFIRMA1")
	public Date getFechaHoraFirma1() {
		return fechaHoraFirma1;
	}

    /**
     * Establece el valor del campo "fechaHoraFirma1".
     * @param fechaHoraFirma1New the fechaHoraFirma1 to set
     */
	public void setFechaHoraFirma1(final Date fechaHoraFirma1New) {
		this.fechaHoraFirma1 = fechaHoraFirma1New;
	}

	/**
     * Obtiene el valor del campo "codProfesionalFirma1".
     * @return the codProfesionalFirma1
     */
	@Column(name = "CODPROFESIONALFIRMA1", length = 25)
	public String getCodProfesionalFirma1() {
		return codProfesionalFirma1;
	}
    /**
     * Establece el valor del campo "codProfesionalFirma1".
     * @param codProfesionalFirma1New the codProfesionalFirma1 to set
     */
	public void setCodProfesionalFirma1(final String codProfesionalFirma1New) {
		this.codProfesionalFirma1 = codProfesionalFirma1New;
	}

	/**
     * Obtiene el valor del campo "fechaHoraFirma2".
     * @return the fechaHoraFirma2
     */
	@Column(name = "FECHAHORAFIRMA2")
	public Date getFechaHoraFirma2() {
		return fechaHoraFirma2;
	}

    /**
     * Establece el valor del campo "fechaHoraFirma2".
     * @param fechaHoraFirma2New the fechaHoraFirma2 to set
     */
	public void setFechaHoraFirma2(final Date fechaHoraFirma2New) {
		this.fechaHoraFirma2 = fechaHoraFirma2New;
	}

	/**
     * Obtiene el valor del campo "codProfesionalFirma2".
     * @return the codProfesionalFirma2
     */
	@Column(name = "CODPROFESIONALFIRMA2", length = 25)
	public String getCodProfesionalFirma2() {
		return codProfesionalFirma2;
	}

    /**
	 * Obtiene el valor del campo "descProfesionalFirma1".
	 *
	 * @return El valor del campo "descProfesionalFirma1".
	 */
	@Column(name = "DESCPROFESIONALFIRMA1")
	public String getDescProfesionalFirma1() {
		return descProfesionalFirma1;
	}

	/**
	 * Establece el valor del campo "descProfesionalFirma1".
	 *
	 * @param descProfesionalFirma1New
	 *            El valor del campo "descProfesionalFirma1".
	 */
	public void setDescProfesionalFirma1(final String descProfesionalFirma1New) {
		this.descProfesionalFirma1 = descProfesionalFirma1New;
	}

	/**
	 * Obtiene el valor del campo "descProfesionalFirma2".
	 *
	 * @return El valor del campo "descProfesionalFirma2".
	 */
	@Column(name = "DESCPROFESIONALFIRMA2")
	public String getDescProfesionalFirma2() {
		return descProfesionalFirma2;
	}

	/**
	 * Establece el valor del campo "descProfesionalFirma2".
	 *
	 * @param descProfesionalFirma2New
	 *            El valor del campo "descProfesionalFirma2".
	 */
	public void setDescProfesionalFirma2(final String descProfesionalFirma2New) {
		this.descProfesionalFirma2 = descProfesionalFirma2New;
	}

	/**
     * Establece el valor del campo "codProfesionalFirma2".
     * @param codProfesionalFirma2New the codProfesionalFirma2 to set
     */
	public void setCodProfesionalFirma2(final String codProfesionalFirma2New) {
		this.codProfesionalFirma2 = codProfesionalFirma2New;
	}

	/**
	 * Obtiene el valor del campo "observacionesAdministracion".
	 * @return El valor del campo "observacionesAdministracion".
	 */
	@Basic
	@Column(name = "OBSERVACIONESADMINISTRACION", length = 255)
	public String getObservacionesAdministracion() {
		return observacionesAdministracion;
	}

	/**
	 * Establece el valor del campo "observacionesAdministracion".
	 * @param observacionesAdministracionNew
	 *            El valor del campo "observacionesAdministracion".
	 */
	public void setObservacionesAdministracion(final String observacionesAdministracionNew) {
		this.observacionesAdministracion = observacionesAdministracionNew;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraIniVentTemp".
	 * @return El valor del campo "fechaHoraIniVentTemp".
	 */
	@Column(name = "FECHAHORAINIVENTTEMP")
	public Date getFechaHoraIniVentTemp() {
		return fechaHoraIniVentTemp;
	}

	/**
     * Establece el valor del campo "fechaHoraIniVentTemp".
     * @param fechaHoraIniVentTempNew the fechaHoraIniVentTemp to set
     */
	public void setFechaHoraIniVentTemp(final Date fechaHoraIniVentTempNew) {
		this.fechaHoraIniVentTemp = fechaHoraIniVentTempNew;
	}

	/**
	 * Obtiene el valor del campo "codProfesionalVentTemp".
	 * @return El valor del campo "codProfesionalVentTemp".
	 */
	@Column(name = "CODPROFESIONALVENTTEMP", length = 25)
	public String getCodProfesionalVentTemp() {
		return codProfesionalVentTemp;
	}

	/**
     * Establece el valor del campo "codProfesionalVentTemp".
     * @param codProfesionalVentTempNew the codProfesionalVentTemp to set
     */
	public void setCodProfesionalVentTemp(final String codProfesionalVentTempNew) {
		this.codProfesionalVentTemp = codProfesionalVentTempNew;
	}

	/**
	 * Obtiene el valor del campo "descProfesionalVentTemp".
	 * @return El valor del campo "descProfesionalVentTemp".
	 */
	@Column(name = "DESCPROFESIONALVENTTEMP", length = 255)
	public String getDescProfesionalVentTemp() {
		return descProfesionalVentTemp;
	}

	/**
     * Establece el valor del campo "descProfesionalVentTemp".
     * @param descProfesionalVentTempNew the descProfesionalVentTemp to set
     */
	public void setDescProfesionalVentTemp(final String descProfesionalVentTempNew) {
		this.descProfesionalVentTemp = descProfesionalVentTempNew;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraUltActualizacion".
	 * @return El valor del campo "fechaHoraUltActualizacion".
	 */
	@Column(name = "FECHAHORAULTACTUALIZACION")
	public Date getFechaHoraUltActualizacion() {
		return fechaHoraUltActualizacion;
	}

	/**
     * Establece el valor del campo "fechaHoraUltActualizacion".
     * @param fechaHoraUltActualizacionNew the fechaHoraUltActualizacion to set
     */
	public void setFechaHoraUltActualizacion(final Date fechaHoraUltActualizacionNew) {
		this.fechaHoraUltActualizacion = fechaHoraUltActualizacionNew;
	}

	/**
	 * Obtiene el valor del campo "codProfesionalUltActualizacion".
	 * @return El valor del campo "codProfesionalUltActualizacion".
	 */
	@Column(name = "CODPROFESIONALULTACTUALIZACION", length = 25)
	public String getCodProfesionalUltActualizacion() {
		return codProfesionalUltActualizacion;
	}

	/**
     * Establece el valor del campo "codProfesionalUltActualizacion".
     * @param codProfesionalUltActualizacionNew the codProfesionalUltActualizacion to set
     */
	public void setCodProfesionalUltActualizacion(
			final String codProfesionalUltActualizacionNew) {
		this.codProfesionalUltActualizacion = codProfesionalUltActualizacionNew;
	}

	/**
	 * Obtiene el valor del campo "descProfesionalUltActualizacion".
	 * @return El valor del campo "descProfesionalUltActualizacion".
	 */
	@Column(name = "DESCPROFESIONALULTACTUALIZACIO", length = 255)
	public String getDescProfesionalUltActualizacion() {
		return descProfesionalUltActualizacion;
	}

	/**
     * Establece el valor del campo "descProfesionalUltActualizacion".
     * @param descProfesionalUltActualizacionNew the descProfesionalUltActualizacion to set
     */
	public void setDescProfesionalUltActualizacion(
			final String descProfesionalUltActualizacionNew) {
		this.descProfesionalUltActualizacion = descProfesionalUltActualizacionNew;
	}

	/**
	 * Obtiene el valor del campo "dobleFirma".
	 * @return El valor del campo "dobleFirma".
	 */
	@Column
	public boolean isDobleFirma() {
		return dobleFirma;
	}

	/**
     * Establece el valor del campo "dobleFirma".
     * @param dobleFirmaNew the dobleFirma to set
     */
	public void setDobleFirma(final boolean dobleFirmaNew) {
		this.dobleFirma = dobleFirmaNew;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraNoAdministracion".
	 * @return El valor del campo "fechaHoraNoAdministracion".
	 */
	@Column(name = "FECHAHORANOADMINISTRACION")
	public Date getFechaHoraNoAdministracion() {
		return fechaHoraNoAdministracion;
	}

	/**
     * Establece el valor del campo "fechaHoraNoAdministracion".
     * @param fechaHoraNoAdmNew the fechaHoraNoAdministracion to set
     */
	public void setFechaHoraNoAdministracion(final Date fechaHoraNoAdmNew) {
		this.fechaHoraNoAdministracion = fechaHoraNoAdmNew;
	}
	
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
	 * Obtiene el valor del campo "administracionesMarca".
	 *
	 * @return El valor del campo "administracionesMarca".
	 */
    @OneToMany(mappedBy = "administracionPrescripcion")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.EVICT, CascadeType.DELETE_ORPHAN })
    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size=500)
    @Sort(type = SortType.NATURAL)
	public SortedSet<AdministracionPacienteMarca> getAdministracionesMarca() {
		return administracionesMarca;
	}

	/**
	 * Establece el valor del campo "administracionesMarca".
	 *
	 * @param administracionesMarca
	 *            El valor del campo "administracionesMarca".
	 */
	public void setAdministracionesMarca(SortedSet<AdministracionPacienteMarca> administracionesMarca) {
		this.administracionesMarca = administracionesMarca;
	}

	/**
	 * Obtiene el valor del campo "inicioEnvase".
	 *
	 * @return El valor del campo "inicioEnvase".
	 */
	@Column
	public boolean isInicioEnvase() {
		return inicioEnvase;
	}

	/**
	 * Establece el valor del campo "inicioEnvase".
	 *
	 * @param inicioEnvase
	 *            El valor del campo "inicioEnvase".
	 */
	public void setInicioEnvase(boolean inicioEnvase) {
		this.inicioEnvase = inicioEnvase;
	}

	/**
	 * Obtiene el valor del campo "lineaPosologia".
	 *
	 * @return El valor del campo "lineaPosologia".
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODLINEAPOSOLOGIA")
	public LineaPosologia getLineaPosologia() {
		return lineaPosologia;
	}

	/**
	 * Establece el valor del campo "lineaPosologia".
	 *
	 * @param lineaPosologia
	 *            El valor del campo "lineaPosologia".
	 */
	public void setLineaPosologia(LineaPosologia lineaPosologia) {
		this.lineaPosologia = lineaPosologia;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addAdministracionMarca(AdministracionPacienteMarca e) {
		if (e != null) {
			e.setAdministracionPrescripcion(this);
		}
		return administracionesMarca.add(e);
	}

	/**
	 * 
	 * @see java.util.Set#clear()
	 */
	public void clearAdministracionesMarca() {
		if (administracionesMarca != null) {
			administracionesMarca.clear();
		}
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean removeAdministracionMarca(AdministracionPacienteMarca o) {
		if (o != null) {
			o.setAdministracionPrescripcion(null);
		}
		return administracionesMarca.remove(o);
	}
	
	/**
	 * Indica si esta toma esta pendiente.
	 * @return boolean
	 */
	public boolean esPendiente() {
		boolean ret = false;
		if (this.admPaciente != null
			&& this.admPaciente.getFechaHoraAdm() == null
			&& this.motivoNoAdm == null) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Indica si esta toma esta administrada.
	 * @return boolean
	 */
	public boolean esAdministrada() {
		boolean ret = false;
		if (this.admPaciente != null
				&& this.admPaciente.getFechaHoraAdm() != null) {
				ret = true;
			}
		return ret;
	}
	/**
	 * Indica si esta toma esta no administrada.
	 * @return boolean
	 */
	public boolean esNoAdministrada() {
		boolean ret = true;
		if (this.motivoNoAdm == null) {
				ret = false;
			}
		return ret;
	}
	/**
	 * Obtiene la cantidad y unidades de medicamento de una prescripción en unidad contenedora
	 * , si no se ha especificado la unidad contenedora en unidad prescrita.
	 * @return float
	 */
	public DosisAdminVO obtenerDosisAdministracion() {
		DosisAdminVO dosis = null;
		float cant = 0;
		if (getPrescripcionMedicamento() != null) {
			 PrescripcionMedicamento presc = getPrescripcionMedicamento();
			if (presc.esFluido()) {				
				if (presc.getVolumenTotal() == null) {
					//Version anterior de fluidos sin compuestos.
					if (presc.usarUnidadContenedora()) {
						cant = presc.getCantidad().floatValue()
								/ presc.getFuerza().floatValue();
						dosis = new DosisAdminVO(
								cant, presc.getCodUnidadContenedora()
								, presc.getUnidadContenedora());
					} else {
						cant = presc.getCantidad().floatValue();
						dosis = new DosisAdminVO(
								cant, presc.getCodUnidades()
								, presc.getUnidades());
					}
				} else {
//					dosis = new DosisAdminVO(
//							presc.getVolumenTotal(), null
//							, MensajesUtil.getMensaje("ml"
//							, MensajesUtil.getLocale("es_ES")));
				}
			} else {
				if (presc.esPosologiaVariable()
						&& getLineaPosologia() != null) {
					LineaPosologia linea = getLineaPosologia();
					if (linea.usarUnidadContenedora(
							presc.getCodUnidadContenedora())) {
						//Si las uidades prescritas y las contenedoras no coinciden se emplea
						//la fuerza para obtener la equivalencia en unidad contenedora
						cant = getAdmPaciente()
								.getCantidadPrescrita().floatValue()
								/ linea.getFuerza();
						dosis = new DosisAdminVO(
								cant, presc.getCodUnidadContenedora()
								, presc.getUnidadContenedora());
					} else {
						//Fuerza no especificada o unidad contenedora = unidad prescrita.
						cant = getAdmPaciente().getCantidadPrescrita().floatValue();
						dosis = new DosisAdminVO(
								cant, linea.getCodUnidades()
								, linea.getUnidades());
					}
				} else {
					if (presc.usarUnidadContenedora()) {
						//Si las uidades prescritas y las contenedoras no coinciden se emplea
						//la fuerza para obtener la equivalencia en unidad contenedora
						cant = getAdmPaciente().getCantidadPrescrita().floatValue()
								/ presc.getFuerza().floatValue();
						dosis = new DosisAdminVO(
								cant, presc.getCodUnidadContenedora()
								, presc.getUnidadContenedora());
					} else {
						cant = getAdmPaciente().getCantidadPrescrita().floatValue();
						dosis = new DosisAdminVO(
								cant, presc.getCodUnidades()
								, presc.getUnidades());
					}
				}
			}
		} else {
			cant = getAdmPaciente().getCantidadPrescrita().floatValue();
			dosis = new DosisAdminVO(
					cant, null
					, admPaciente.getUnidades());
		}
		return dosis;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">>> AdministracionPrescripcion {");
		sb.append(" id: " + this.id);
		if (this.admPaciente != null) {
			sb.append(" fechaHoraPrevistaAdmin: " + this.admPaciente.getFechaHoraPrevistaAdmin());			
			sb.append(" descMedicamento: " + this.admPaciente.getDescMedicamento());
			sb.append(" codMedicamento: " + this.admPaciente.getCodMedicamento());
			sb.append(" descPresentacion: " + this.admPaciente.getDescPresentacion());
			sb.append(" cantidadPrescrita: " + this.admPaciente.getCantidadPrescrita());
			sb.append(" cantidadAdministracion: " + this.admPaciente.getCantidadAdministracion());			
			sb.append(" codViaAdministracion: " + this.admPaciente.getCodViaAdministracion());
			sb.append(" codDescViaAdministracion: " + this.admPaciente.getDescViaAdministracion());
			sb.append(" modoAdministracion: " + this.admPaciente.getModoAdministracion());
			sb.append(" frecuencia: " + this.admPaciente.getFrecuencia());
			sb.append(" tipoUnidadFrecuencia: " + this.admPaciente.getTipoUnidadFrecuencia());
			sb.append(" codEpisodio: " + this.admPaciente.getCodEpisodio());
			sb.append(" codCentro: " + this.admPaciente.getCodCentro());
			sb.append(" descCentro: " + this.admPaciente.getDescCentro());
			sb.append(" codUsuarioAuditoria: " + this.admPaciente.getCodUsuarioAuditoria());
			sb.append(" codUsuarioResponsable: " + this.admPaciente.getCodUsuarioResponsable());
			sb.append(" numLote: " + this.admPaciente.getNumLote());
			sb.append(" fechaHoraAdm: " + this.admPaciente.getFechaHoraAdm());
			sb.append(" fechaHoraCreacion: " + this.admPaciente.getFechaHoraCreacion());
			sb.append(" unidades: " + this.admPaciente.getUnidades());
			sb.append(" observaciones: " + this.admPaciente.getObservaciones());
		}
		if (this.prescripcionMedicamento != null) {
			sb.append(" codPrescripcionPre: " + this.prescripcionMedicamento.getCodPrescripcionPRE());
			sb.append(" codPrescripcion: " + this.prescripcionMedicamento.getId());
		}
		sb.append(" codUbicacion: " + this.codUbicacion);
		sb.append(" descUbicacion: " + this.descUbicacion);
		sb.append(" codHabitacion: " + this.codHabitacion);
		sb.append(" descHabitacion: " + this.descHabitacion);
		sb.append(" codCama: " + this.codCama);
		sb.append(" descCama: " + this.descCama);
		sb.append(" codTarea: " + this.codTarea);
		sb.append(" observacionesAdministracion: " + this.observacionesAdministracion);
		sb.append(" observacionesNoAdministracion: " + this.observacionesNoAdministracion);
		sb.append(" codAgenda: " + this.codAgenda);
		sb.append(" descAgenda: " + this.descAgenda);
		sb.append(" codEspecialidadConsulta: " + this.codEspecialidadConsulta);
		sb.append(" descEspecialidadConsulta: " + this.descEspecialidadConsulta);
		sb.append(" codProfesionalFirma1: " + this.codProfesionalFirma1);
		sb.append(" descProfesionalFirma1: " + this.descProfesionalFirma1);
		sb.append(" codProfesionalFirma2: " + this.codProfesionalFirma2);
		sb.append(" descProfesionalFirma2: " + this.descProfesionalFirma2);
		sb.append(" codProfesionalUltActualizacion: " + this.codProfesionalUltActualizacion);
		sb.append(" descProfesionalUltActualizacion: " + this.descProfesionalUltActualizacion);
		sb.append(" codProfesionalVentTemp: " + this.codProfesionalVentTemp);
		sb.append(" descProfesionalVentTemp: " + this.descProfesionalVentTemp);
				sb.append(" activo: " + this.activo);						
		return sb.toString();
	}
    
}
