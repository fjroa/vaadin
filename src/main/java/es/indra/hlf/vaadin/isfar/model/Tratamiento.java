/**
 *
 */
package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

//import javax.persistence.AttributeOverride;
//import javax.persistence.AttributeOverrides;
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

/** Clase de dominio para la entidad PrescripcionPaciente.
 * @author INDRA
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TRATAMIENTO")
@SequenceGenerator(name = "SEQ_TRATAMIENTO",
		sequenceName = "SEQ_TRATAMIENTO", allocationSize = 1)
/*@AttributeOverrides(
        {@AttributeOverride(name = "codUsuarioCreacion", column = @Column(name = "CODUSUARIOPRESCRIPTOR")),
        @AttributeOverride(name = "descUsuarioCreador", column = @Column(name = "DESCUSUARIOPRESCRIPTOR"))})*/
public class Tratamiento extends EntidadBase implements Serializable {


	/**
	 * COD_AREA_HOSPITALIZACION String "HOS" código de area de hospitalización.
	 */
	public static final String COD_AREA_HOSPITALIZACION = "HOS";
	/**
	 * COD_AREA_HOSPITAL_DE_DIA String "HDI" código de area de hospital de día.
	 */
	public static final String COD_AREA_HOSPITAL_DE_DIA = "HDI";
	/**
	 * COD_AREA_URGENCIAS String "URG" código de area de urgencias.
	 */
	public static final String COD_AREA_URGENCIAS = "URG";
	/**
	 * COD_AREA_CEX String "CEX" código del area de consultas externas.
	 */
	public static final String COD_AREA_CEX = "CEX";
	/**
	 * COD_AREA_PRI String "PRI" código de area de primaria.
	 */
	public static final String COD_AREA_PRI = "PRI";

	/** Literal error_hbm_version . */
	public static final String ERROR_HBM_VERSION_TRATAMIENTOS = "error_hbm_version_tratamiento";
	
	/**
	 * Constructor.
	 *
	 */
	public Tratamiento() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * Objeto de la clase Paciente.
	 */
	private Paciente paciente;
	/**
	 * Observaciones de la prescripcion.
	 */
	private String observacionesRechazo;
	/**
	 * Fecha y hora de validacion de la prescripcion.
	 */
	private Date fechaHoraValidacion;
	/**
	 * Codigo del motivo de rechazo de la prescripcion.
	 */
	private Motivo motivoRechazo;
	/**
	 * Fecha y hora del rechazo de la prescripcion.
	 */
	private Date fechaHoraRechazo;
	/**
	 * Codigo del episodio.
	 */
	private String codEpisodio;
	/**
	 * codAsistencia String.
	 */
	private String codAsistencia;
	/**
	 * Codigo del urea.
	 */
	private String codArea;
	/**
	 * Codigo del prescriptor.
	 */
	private String codUsuarioPrescriptor;
	/**
	 * Descripcion del prescriptor.
	 */
	private String descUsuarioPrescriptor;
	/**
	 * Descripcion del ultimo usuario en modificar la prescripcion.
	 */
	private String descUsuarioUltimaModificacion;
	/**
	 * Codigo de la ubicacion.
	 */
	private String codUbicacion;
	/**
	 * Descripcion de la ubicacion.
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
	 * Codigo del diagnostico.
	 */
	private String codDiagnostico;
	/**
	 * Descripcion del diagnostico.
	 */
	private String descDiagnostico;
	/**
	 * Codigo del servicio en el que se encuentra el paciente.
	 */
	private String codServicio;
	/**
	 * Descripcion del servicio en el que se encuentra el paciente.
	 */
	private String descServicio;
	/**
	 * Indica si hay que suministrarlo inmediatamente.
	 */
	private boolean suministroInmediato;
	/**
	 * Codigo del centro.
	 */
	private String codCentro;
	/**
	 * Descripcion del centro.
	 */
	private String descCentro;
	/**
	 * Codigo del profesional del tratamiento.
	 */
	private String codProfesional;

	/**
	 * Descripcion del  profesional del tratamiento.
	 */
	private String descProfesional;
	/**
	 * Codigo de Unidad de Enfermeroa del paciente HOS.
	 */
	private String codUE;
	/**
	 * Descripcion de Unidad de Enfermeroa del paciente HOS.
	 */
	private String descUE;
	/**
	 * incluidoEnItinerario boolean.
	 */
	private Boolean incluidoEnItinerario;
	/**
	 * Codigo del proceso de facturacion.
	 */
	private String codProcesoFacturacion;
	/**
	 * Codigo del financiador.
	 */
	private String codFinanciador;
	/**
	 * Descripcion del financiador.
	 */
	private String descFinanciador;
	/**
	 * Codigo del garante.
	 */
	private String codGarante;
	/**
	 * Descripcion del garante.
	 */
	private String descGarante;
	/**
	 * Numero de poliza.
	 */
	private String numPoliza;
	/**
	 * Lista de medicamentos.
	 */
    private SortedSet < PrescripcionMedicamento > prescripciones = new TreeSet < PrescripcionMedicamento >();

    /**
     * fechaHoraCambioUbicacion Date.
     */
    private Date fechaHoraCambioUbicacion;

    /**
     * causaCambioUbicacion String.
     */
    private String causaCambioUbicacion;
    /**
	 * ISPRE: codActividad String.
	 */
	private String codActividad;
	/**
	 * ISPRE: codHojaVisita String.
	 */
	private String codHojaVisita;


	  /*************/
	 /** METODOS **/
	/*************/


	/** Devuelvo el objeto Paciente.
	 * @return the codPaciente
	 */
	@ManyToOne
	@JoinColumn(name = "CODPACIENTE")
	public Paciente getPaciente() {
		return paciente;
	}
	/** Establezco el Paciente.
	 * @param pac the Paciente to set
	 */
	public void setPaciente(final Paciente pac) {
		this.paciente = pac;
	}
	/** Devuelvo el observaciones.
	 * @return the observaciones
	 */
	@Basic
	@Column(name = "OBSERVACIONESRECHAZO")
	public String getObservacionesRechazo() {
		return observacionesRechazo;
	}
	/** Establezco las observacionesRechazo.
	 * @param obsRechazo the observacionesRechazo to set
	 */
	public void setObservacionesRechazo(final String obsRechazo) {
		this.observacionesRechazo = obsRechazo;
	}
	/** Devuelvo el fechaHoraValidacion.
	 * @return the fechaHoraValidacion
	 */
	@Basic
	@Column(name = "FECHAHORAVALIDACION")
	public Date getFechaHoraValidacion() {
		return fechaHoraValidacion;
	}
	/** Establezco el fechaHoraValidacion.
	 * @param fHoraValidacion the fechaHoraValidacion to set
	 */
	public void setFechaHoraValidacion(final Date fHoraValidacion) {
		this.fechaHoraValidacion = fHoraValidacion;
	}
	/** Devuelvo el codMotivoRechazo.
	 * @return the codMotivoRechazo
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODMOTIVORECHAZO")
	public Motivo getMotivoRechazo() {
		return motivoRechazo;
	}
	/** Establezco el motivoRechazo.
	 * @param motivoRech the MotivoRechazo to set
	 */
	public void setMotivoRechazo(final Motivo motivoRech) {
		this.motivoRechazo = motivoRech;
	}
	/** Devuelvo el fechaHoraRechazo.
	 * @return the fechaHoraRechazo
	 */
	@Basic
	@Column(name = "FECHAHORARECHAZO")
	public Date getFechaHoraRechazo() {
		return fechaHoraRechazo;
	}
	/** Establezco el fechaHoraRechazo.
	 * @param fHoraRechazo the fechaHoraRechazo to set
	 */
	public void setFechaHoraRechazo(final Date fHoraRechazo) {
		this.fechaHoraRechazo = fHoraRechazo;
	}
	/** Devuelvo el codEpisodio.
	 * @return the codEpisodio
	 */
	@Basic
	@Column(name = "CODEPISODIO")
	public String getCodEpisodio() {
		return codEpisodio;
	}
	/** Establezco el codEpisodio.
	 * @param codEpi the codEpisodio to set
	 */
	public void setCodEpisodio(final String codEpi) {
		this.codEpisodio = codEpi;
	}
	
	/**
	 * Obtiene el valor del campo "codAsistencia".
	 *
	 * @return El valor del campo "codAsistencia".
	 */
	@Column(name="CODASISTENCIA")
	public String getCodAsistencia() {
		return codAsistencia;
	}
	/**
	 * Establece el valor del campo "codAsistencia".
	 *
	 * @param codAsistencia
	 *            El valor del campo "codAsistencia".
	 */
	public void setCodAsistencia(String codAsistencia) {
		this.codAsistencia = codAsistencia;
	}
	/** Devuelvo el codArea.
	 * @return the codArea
	 */
	@Basic
	@Column(name = "CODAREA")
	public String getCodArea() {
		return codArea;
	}
	/** Establezco el codArea.
	 * @param cArea the codArea to set
	 */
	public void setCodArea(final String cArea) {
		this.codArea = cArea;
	}
	/**
	 * Devuelvo el codUsuarioPrescriptor.
	 * @return the codUsuarioPrescriptor
	 */
	@Basic
	@Column(name = "CODUSUARIOPRESCRIPTOR")
	public String getCodUsuarioPrescriptor() {
		return codUsuarioPrescriptor;
	}
	/**
	 * Establezco el codUsuarioPrescriptor.
	 * @param cUsuarioPrescriptor the codUsuarioPrescriptor to set
	 */
	public void setCodUsuarioPrescriptor(final String cUsuarioPrescriptor) {
		this.codUsuarioPrescriptor = cUsuarioPrescriptor;
	}
	/** Devuelvo el descUsuarioPrescriptor.
	 * @return the descUsuarioPrescriptor
	 */
	@Basic
	@Column(name = "DESCUSUARIOPRESCRIPTOR")
	public String getDescUsuarioPrescriptor() {
		return descUsuarioPrescriptor;
	}
	/** Establezco el descUsuarioPrescriptor.
	 * @param dUsuarioPrescriptor the descUsuarioPrescriptor to set
	 */
	public void setDescUsuarioPrescriptor(final String dUsuarioPrescriptor) {
		this.descUsuarioPrescriptor = dUsuarioPrescriptor;
	}
	/** Devuelvo el descUsuarioUltimaModificacion.
	 * @return the descUsuarioUltimaModificacion
	 */
	@Basic
	@Column(name = "DESCUSUARIOULTIMAMODIFICACION")
	public String getDescUsuarioUltimaModificacion() {
		return descUsuarioUltimaModificacion;
	}
	/** Establezco el descUsuarioUltimaModificacion.
	 * @param dUsuarioUltimaModificacion the descUsuarioUltimaModificacion to set
	 */
	public void setDescUsuarioUltimaModificacion(
			final String dUsuarioUltimaModificacion) {
		this.descUsuarioUltimaModificacion = dUsuarioUltimaModificacion;
	}
	/** Devuelvo el codUbicacion.
	 * @return the codUbicacion
	 */
	@Basic
	@Column(name = "CODUBICACION")
	public String getCodUbicacion() {
		return codUbicacion;
	}
	/** Establezco el codUbic.
	 * @param codUbic the codUbicacion to set
	 */
	public void setCodUbicacion(final String codUbic) {
		this.codUbicacion = codUbic;
	}
	/** Devuelvo el descUbicacion.
	 * @return the descUbicacion
	 */
	@Basic
	@Column(name = "DESCUBICACION")
	public String getDescUbicacion() {
		return descUbicacion;
	}
	/** Establezco el descUbicacion.
	 * @param descUbic the descUbicacion to set
	 */
	public void setDescUbicacion(final String descUbic) {
		this.descUbicacion = descUbic;
	}

	/**
	 * Obtiene el valor del campo "codHabitacion".
	 *
	 * @return El valor del campo "codHabitacion".
	 */
	@Basic
	@Column(name = "CODHABITACION")
	public String getCodHabitacion() {
		return codHabitacion;
	}
	/**
	 * Establece el valor del campo "codHabitacion".
	 *
	 * @param codHab
	 *            El valor del campo "codHabitacion".
	 */
	public void setCodHabitacion(final String codHab) {
		this.codHabitacion = codHab;
	}
	/**
	 * Obtiene el valor del campo "descHabitacion".
	 *
	 * @return El valor del campo "descHabitacion".
	 */
	@Basic
	@Column(name = "DESCHABITACION")
	public String getDescHabitacion() {
		return descHabitacion;
	}
	/**
	 * Establece el valor del campo "descHabitacion".
	 *
	 * @param descHab
	 *            El valor del campo "descHabitacion".
	 */
	public void setDescHabitacion(final String descHab) {
		this.descHabitacion = descHab;
	}
	/**
	 * Obtiene el valor del campo "codCama".
	 *
	 * @return El valor del campo "codCama".
	 */
	@Basic
	@Column(name = "CODCAMA")
	public String getCodCama() {
		return codCama;
	}
	/**
	 * Establece el valor del campo "codCama".
	 *
	 * @param cCama
	 *            El valor del campo "codCama".
	 */
	public void setCodCama(final String cCama) {
		this.codCama = cCama;
	}
	/**
	 * Obtiene el valor del campo "descCama".
	 *
	 * @return El valor del campo "descCama".
	 */
	@Basic
	@Column(name = "DESCCAMA")
	public String getDescCama() {
		return descCama;
	}
	/**
	 * Establece el valor del campo "descCama".
	 *
	 * @param dCama
	 *            El valor del campo "descCama".
	 */
	public void setDescCama(final String dCama) {
		this.descCama = dCama;
	}
	/** Devuelvo el codDiagnostico.
	 * @return the codDiagnostico
	 */
	@Basic
	@Column(name = "CODDIAGNOSTICO")
	public String getCodDiagnostico() {
		return codDiagnostico;
	}
	/** Establezco el codDiagnostico.
	 * @param codDiag the codDiagnostico to set
	 */
	public void setCodDiagnostico(final String codDiag) {
		this.codDiagnostico = codDiag;
	}
	/** Devuelvo el descDiagnostico.
	 * @return the descDiagnostico
	 */
	@Basic
	@Column(name = "DESCDIAGNOSTICO")
	public String getDescDiagnostico() {
		return descDiagnostico;
	}
	/** Establezco el descDiagnostico.
	 * @param descDiag the descDiagnostico to set
	 */
	public void setDescDiagnostico(final String descDiag) {
		this.descDiagnostico = descDiag;
	}
	/** Devuelvo el codServicio.
	 * @return the codServicio
	 */
	@Basic
	@Column(name = "CODSERVICIO")
	public String getCodServicio() {
		return codServicio;
	}
	/** Establezco el codServicio.
	 * @param cServicio the codServicio to set
	 */
	public void setCodServicio(final String cServicio) {
		this.codServicio = cServicio;
	}
	/** Devuelvo el descServicio.
	 * @return the descServicio
	 */
	@Basic
	@Column(name = "DESCSERVICIO")
	public String getDescServicio() {
		return descServicio;
	}
	/** Establezco el descServicio.
	 * @param dServicio the descServicio to set
	 */
	public void setDescServicio(final String dServicio) {
		this.descServicio = dServicio;
	}

	/**
	 * Obtiene el valor del campo "suministroInmediato".
	 *
	 * @return El valor del campo "suministroInmediato".
	 */
	@Column
	public boolean isSuministroInmediato() {
		return suministroInmediato;
	}
	/**
	 * Establece el valor del campo "suministroInmediato".
	 *
	 * @param sumInmed
	 *            El valor del campo "suministroInmediato".
	 */
	public void setSuministroInmediato(final boolean sumInmed) {
		this.suministroInmediato = sumInmed;
	}
	/**
	 * Obtiene el valor del campo "codCentro".
	 *
	 * @return El valor del campo "codCentro".
	 */
	@Column
	public String getCodCentro() {
		return codCentro;
	}
	/**
	 * Establece el valor del campo "codCentro".
	 *
	 * @param cCentro
	 * 			El valor del campo "codCentro".
	 */
	public void setCodCentro(final String cCentro) {
		this.codCentro = cCentro;
	}
	/**
	 * Obtiene el valor del campo "descCentro".
	 *
	 * @return El valor del campo "descCentro".
	 */
	@Column
	public String getDescCentro() {
		return descCentro;
	}
	/**
	 * Establece el valor del campo "descCentro".
	 *
	 * @param dCentro
	 * 			El valor del campo "descCentro".
	 */
	public void setDescCentro(final String dCentro) {
		this.descCentro = dCentro;
	}
	/**
	 * Obtiene el valor del campo "medicamentos".
	 *
	 * @return El valor del campo "medicamentos".
	 */
	@OneToMany(mappedBy = "tratamiento", fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    @Sort(type = SortType.NATURAL)
    @Cascade(CascadeType.ALL)
	public SortedSet < PrescripcionMedicamento > getPrescripciones() {
		return prescripciones;
	}
	/**
	 * Establece el valor del campo "medicamentos".
	 *
	 * @param medicamentos
	 *            El valor del campo "medicamentos".
	 */
	public void setPrescripciones(final SortedSet < PrescripcionMedicamento > medicamentos) {
		this.prescripciones = medicamentos;
	}
	/** Devuelvo el codTratamiento.
	 * @return the codTratamiento
	 */
	@Basic
	@Id
	@Column(name = "CODTRATAMIENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRATAMIENTO")
	public Integer getId() {
		return id;
	}
	/**
	 * Establece el valor del campo "id".
	 *
	 * @param identifier
	 *            El valor del campo "id".
	 */
	public void setId(final Integer identifier) {
		this.id = identifier;
	}

	/**
	 * Obtiene el valor del campo "codProfesional".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "codProfesional".
	 */
	@Column
	public String getCodProfesional() {
		return codProfesional;
	}
	/**
	 * Establece el valor del campo "codProfesional".
	 *
	 * @author cgromero
	 *
	 * @param cProfesional
	 *            El valor del campo "codProfesional".
	 */
	public void setCodProfesional(final String cProfesional) {
		this.codProfesional = cProfesional;
	}
	/**
	 * Obtiene el valor del campo "descProfesional".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "descProfesional".
	 */
	@Column
	public String getDescProfesional() {
		return descProfesional;
	}
	/**
	 * Establece el valor del campo "descProfesional".
	 *
	 * @author cgromero
	 *
	 * @param dProfesional
	 *            El valor del campo "descProfesional".
	 */
	public void setDescProfesional(final String dProfesional) {
		this.descProfesional = dProfesional;
	}
	/**
	 * Obtiene el valor del campo "codUE".
	 *
	 * @author dcruzg
	 *
	 * @return the codUE
	 */
	@Column
	public String getCodUE() {
		return codUE;
	}
	/**
	 * Establece el valor del campo "codUE".
	 *
	 * @author dcruzg
	 *
	 * @param cUE the codUE to set
	 */
	public void setCodUE(final String cUE) {
		this.codUE = cUE;
	}
	/**
	 * Obtiene el valor del campo "descUE".
	 *
	 * @author dcruzg
	 *
	 * @return the descUE
	 */
	@Column
	public String getDescUE() {
		return descUE;
	}
	/**
	 * Establece el valor del campo "descUE".
	 *
	 * @author dcruzg
	 *
	 * @param dUE the descUE to set
	 */
	public void setDescUE(final String dUE) {
		this.descUE = dUE;
	}
	/**
	 * Obtiene el valor del campo "incluidoEnItinerario".
	 *
	 * @return El valor del campo "incluidoEnItinerario".
	 */
	@Column
	public Boolean isIncluidoEnItinerario() {
		return incluidoEnItinerario;
	}
	/**
	 * Establece el valor del campo "incluidoEnItinerario".
	 *
	 * @param incEnItinerario
	 *            El valor del campo "incluidoEnItinerario".
	 */
	public void setIncluidoEnItinerario(final Boolean incEnItinerario) {
		this.incluidoEnItinerario = incEnItinerario;
//		if(incluidoEnItinerario == null) {
//			this.incluidoEnItinerario = false;
//		}
	}
	/**
	 * Obtiene el valor del campo "codProcesoFacturacion".
	 * @return the codProcesoFacturacion
	 */
	@Column
	public String getCodProcesoFacturacion() {
		return codProcesoFacturacion;
	}
	/**
	 * Establece el valor del campo "codProcesoFacturacion".
	 * @param cProcesoFacturacion the codProcesoFacturacion to set
	 */
	public void setCodProcesoFacturacion(final String cProcesoFacturacion) {
		this.codProcesoFacturacion = cProcesoFacturacion;
	}
	/**
	 * Obtiene el valor del campo "codFinanciador".
	 * @return the codFinanciador
	 */
	@Column
	public String getCodFinanciador() {
		return codFinanciador;
	}
	/**
	 * Establece el valor del campo "codFinanciador".
	 * @param cFinanciador the codFinanciador to set
	 */
	public void setCodFinanciador(final String cFinanciador) {
		this.codFinanciador = cFinanciador;
	}
	/**
	 * Obtiene el valor del campo "descFinanciador".
	 * @return the descFinanciador
	 */
	@Column
	public String getDescFinanciador() {
		return descFinanciador;
	}
	/**
	 * Establece el valor del campo "descFinanciador".
	 * @param dFinanciador the descFinanciador to set
	 */
	public void setDescFinanciador(final String dFinanciador) {
		this.descFinanciador = dFinanciador;
	}
	/**
	 * Obtiene el valor del campo "codGarante".
	 * @return the codGarante
	 */
	@Column
	public String getCodGarante() {
		return codGarante;
	}
	/**
	 * Establece el valor del campo "codGarante".
	 * @param cGarante the codGarante to set
	 */
	public void setCodGarante(final String cGarante) {
		this.codGarante = cGarante;
	}
	/**
	 * Obtiene el valor del campo "descGarante".
	 * @return the descGarante
	 */
	@Column
	public String getDescGarante() {
		return descGarante;
	}
	/**
	 * Establece el valor del campo "descGarante".
	 * @param dGarante the descGarante to set
	 */
	public void setDescGarante(final String dGarante) {
		this.descGarante = dGarante;
	}
	/**
	 * Obtiene el valor del campo "numPoliza".
	 * @return the numPoliza
	 */
	@Column
	public String getNumPoliza() {
		return numPoliza;
	}
	/**
	 * Establece el valor del campo "numPoliza".
	 * @param nPoliza the numPoliza to set
	 */
	public void setNumPoliza(final String nPoliza) {
		this.numPoliza = nPoliza;
	}
	/**
	 * Obtiene el valor del campo "fechaHoraCambioUbicacion".
	 *
	 * @return El valor del campo "fechaHoraCambioUbicacion".
	 */
	@Column
	public Date getFechaHoraCambioUbicacion() {
		return fechaHoraCambioUbicacion;
	}
	/**
	 * Establece el valor del campo "fechaHoraCambioUbicacion".
	 *
	 * @param fHoraCambioUbicacion
	 *            El valor del campo "fechaHoraCambioUbicacion".
	 */
	public void setFechaHoraCambioUbicacion(final Date fHoraCambioUbicacion) {
		this.fechaHoraCambioUbicacion = fHoraCambioUbicacion;
	}
	/**
	 * Obtiene el valor del campo "causaCambioUbicacion".
	 *
	 * @return El valor del campo "causaCambioUbicacion".
	 */
	@Column
	public String getCausaCambioUbicacion() {
		return causaCambioUbicacion;
	}
	/**
	 * Establece el valor del campo "causaCambioUbicacion".
	 *
	 * @param causaCambioUbic
	 *            El valor del campo "causaCambioUbicacion".
	 */
	public void setCausaCambioUbicacion(final String causaCambioUbic) {
		this.causaCambioUbicacion = causaCambioUbic;
	}
	/**
	 * Añade una prescripción al listado.
	 * @param e PrescripcionMedicamento
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addPrescripcion(final PrescripcionMedicamento e) {
		e.setTratamiento(this);
		return prescripciones.add(e);
	}
	/**
	 * @return the codActividad
	 */
	@Column(name="CODACTIVIDAD")
	public String getCodActividad() {
		return codActividad;
	}
	/**
	 * @param codActividad the codActividad to set
	 */
	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}
	/**
	 * @return the codHojaVisita
	 */
	@Column(name="CODHOJAVISITA")
	public String getCodHojaVisita() {
		return codHojaVisita;
	}
	/**
	 * @param codHojaVisita the codHojaVisita to set
	 */
	public void setCodHojaVisita(String codHojaVisita) {
		this.codHojaVisita = codHojaVisita;
	}
	
	/**
	 * Indica si es un tratamiento del Area de HOS.
	 * @return boolean.
	 */
	public boolean esTratHOS() {
		return COD_AREA_HOSPITALIZACION.equals(this.codArea);
	}
	/**
	 * Indica si es un tratamiento del Area de URG.
	 * @return boolean.
	 */
	public boolean esTratURG() {
		return COD_AREA_URGENCIAS.equals(this.codArea);
	}
	/**
	 * Indica si es un tratamiento del Area de HDI.
	 * @return boolean.
	 */
	public boolean esTratHDI() {
		return COD_AREA_HOSPITAL_DE_DIA.equals(this.codArea);
	}
	/**
	 * Indica si es un tratamiento del Area de CEX.
	 * @return boolean.
	 */
	public boolean esTratCEX() {
		return COD_AREA_CEX.equals(this.codArea);
	}
	/**
	 * Indica si es un tratamiento del Area de PRI.
	 * @return boolean.
	 */
	public boolean esTratPRI() {
		return COD_AREA_PRI.equals(this.codArea);
	}

}
