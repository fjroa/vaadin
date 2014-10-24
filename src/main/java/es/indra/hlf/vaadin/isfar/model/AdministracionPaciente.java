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
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Clase de dominio para la entidad AdministracionPaciente.
 *
 * @author INDRA
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ADMINISTRACION_PACIENTE")
@SequenceGenerator(name = "SEQ_ADMIN_PACIENTE", sequenceName = "SEQ_ADMIN_PACIENTE", allocationSize = 1)
public class AdministracionPaciente implements Serializable {

    /**
     * Codigo de la administracion.
     */
    private Integer id;

    /**
     * Objeto de la clase Paciente.
     */
    private Paciente paciente;

    /**
     * Codigo del Medicamento.
     */
    private Long codMedicamento;
    /**
	 * codMedicamentoCentro String.
	 */
	private String codMedicamentoCentro;

    /**
     * Descripcion del Medicamento.
     */
    private String descMedicamento;
    /**
     * Descripcion del Medicamento, en un formato mas legible.
     */
    private String descPresentacion;
    /**
	 * Indica en que unidades esta especificada la frecuencia
	 *  posibles valores especificados en PrescripcionMedicamento.UNIDAD_FREC_XXX
	 * tipoUnidadFrecuencia int.
	 */
	private int tipoUnidadFrecuencia;

    /**
     * Frecuencia del medicamento.
     */
    private Float frecuencia;

    /**
     * Cantidad prescrita del medicamento.
     */
    private Float cantidadPrescrita;

    /**
     * Cantidad prescrita del medicamento modificada (Es la nueva cantidad a administrar).
     */
    private Float cantidadAdministracion;

    /**
     * Fecha y Hora de la administracion.
     */
    private Date fechaHoraAdm;

    /**
     * Motivo de la administracion.
     */
    private Motivo motivoAdm;

    /**
     * Observaciones sobre la administracion.
     */
    private String observaciones;

    /**
     * Codigo del responsable de la administracion.
     */
    private String codUsuarioResponsable;

    /**
     * Fecha y Hora de la creacion.
     */
    private Date fechaHoraCreacion;
    /**
     * codUnidades Integer.
     */
    private Integer codUnidades;
    /**
     * Unidades del medicamento.
     */
    private String unidades;

    /**
	 * Modo de administracion del medicamento si es no unidosis.
	 */
	private String modoAdministracion;

    /**
     * Codigo de la via de administracion.
     */
    private Integer codViaAdministracion;

    /**
     * Descripcion de la via de administracion.
     */
    private String descViaAdministracion;

    /**
     * nResultados.
     */
    private Integer nResultados;

    /**
     * Codigo de fluido al que pertenece el multimedicamento.
     */
    private Integer codFluido;

    /**
     * Indica si es componente base.
     */
    private boolean base;

    /**
     * fechaHoraPrevistaAdministracion Date.
     */
    private Date fechaHoraPrevistaAdmin;

    /**
     * Codigo de centro.
     */
    private String codCentro;

    /**
     * Descripcion del centro.
     */
    private String descCentro;
    /**
     * Linea asistencial de ejecución de la administración.
     * codAreaEjecucion String.
     */
    private String codAreaEjecucion;
    /**
     * Codigo del episodio asociado.
     */
    private String codEpisodio;
    /**
     * codEpisodioEjecucion String.
     */
    private String codEpisodioEjecucion;
    /**
     * codAsistenciaEjecucion String.
     */
    private String codAsistenciaEjecucion;

    /**
     * Numero de lote.
     */
    private String numLote;

    /**
     * hbmVersion long.
     */
    private long hbmVersion;

	/**
     * Attribute codUsuarioAuditoria.
     */
    private String codUsuarioAuditoria; //NOPMD
    /**
     * codCentroEjecucion String.
     */
    private String codCentroEjecucion;
    /**
     * descCentroEjecucion String.
     */
    private String descCentroEjecucion;

    /**
     * codServicioEjecucion String.
     */
    private String codServicioEjecucion;
    /**
     * descServicioEjecucion String.
     */
    private String descServicioEjecucion;

	/**
	 * ISEC: codProtocoloEjecucion.
	 */
	private String codProtocoloEjecucion;
	/**
	 * ISEC: codActividadEjecucion.
	 */
	private String codActividadEjecucion;
	/**
	 * ISEC: codHojaVisitaEjecucion.
	 */
	private String codHojaVisitaEjecucion;

    /*************/
    /** METODOS **/
    /*************/

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
     * Constructor por defecto.
     */
    public AdministracionPaciente() {
    	super();
    }

    /**
     * Constructor.
     *
     * @param codAdmPaciente Integer
     */
    public AdministracionPaciente(final Integer codAdmPaciente) {
        super();
        this.id = codAdmPaciente;
    }

    /**
     * Obtiene el valor del campo "id".
     *
     * @return El valor del campo "id".
     */
    @Basic
    @Id
    @Column(name = "CODADMINISTRACIONPACIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADMIN_PACIENTE")
    public Integer getId() {
        return id;
    }

    /**
     * Establece el valor del campo "id".
     *
     * @param idNew El valor del campo "id".
     */
    public void setId(final Integer idNew) {
        this.id = idNew;
    }

    /**
     * Devuelvo el objeto Paciente.
     *
     * @return the paciente
     */
    @ManyToOne
    @JoinColumn(name = "CODPACIENTE")
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establezco el objeto Paciente.
     *
     * @param pacienteNew the Paciente to set
     */
    public void setPaciente(final Paciente pacienteNew) {
        this.paciente = pacienteNew;
    }

    /**
     * Devuelvo el codigo del medicamento.
     *
     * @return the codMedicamento
     */
    @Basic
    @Column(name = "CODMEDICAMENTO", length = 25)
    public Long getCodMedicamento() {
        return codMedicamento;
    }

    /**
     * Establezco el codigo del medicamento.
     *
     * @param codMedicamentoNew new value for codMedicamento
     */
    public void setCodMedicamento(final Long codMedicamentoNew) {
        this.codMedicamento = codMedicamentoNew;
    }

    /**
	 * Obtiene el valor del campo "codMedicamentoCentro".
	 *
	 * @return El valor del campo "codMedicamentoCentro".
	 */
    @Column
	public String getCodMedicamentoCentro() {
		return codMedicamentoCentro;
	}
	/**
	 * Establece el valor del campo "codMedicamentoCentro".
	 *
	 * @param codMedicamentoCentro
	 *            El valor del campo "codMedicamentoCentro".
	 */
	public void setCodMedicamentoCentro(String codMedicamentoCentro) {
		this.codMedicamentoCentro = codMedicamentoCentro;
	}
	/**
     * Devuelvo la descripcion del medicamento.
     *
     * @return the descMedicamento
     */
    @Basic
    @Column(name = "DESCMEDICAMENTO", length = 255)
    public String getDescMedicamento() {
        return descMedicamento;
    }

    /**
     * Establezco la descripcion del medicamento.
     *
     * @param descMedicamentoNew new value for descMedicamento
     */
    public void setDescMedicamento(final String descMedicamentoNew) {
        this.descMedicamento = descMedicamentoNew;
    }

    /**
	 * Obtiene el valor del campo "descPresentacion".
	 *
	 * @return El valor del campo "descPresentacion".
	 */
    @Column(name = "DESCPRESENTACION", length = 255)
	public String getDescPresentacion() {
		return descPresentacion;
	}

	/**
	 * Establece el valor del campo "descPresentacion".
	 *
	 * @param descPresentacionNew
	 *            El valor del campo "descPresentacion".
	 */
	public void setDescPresentacion(final String descPresentacionNew) {
		this.descPresentacion = descPresentacionNew;
	}

	/**
	 * Obtiene el valor del campo "tipoUnidadFrecuencia".
	 *
	 * @return El valor del campo "tipoUnidadFrecuencia".
	 */
	 @Column
	public int getTipoUnidadFrecuencia() {
		return tipoUnidadFrecuencia;
	}
	/**
	 * Establece el valor del campo "tipoUnidadFrecuencia".
	 *
	 * @param tipoUnidadFrecuencia
	 *            El valor del campo "tipoUnidadFrecuencia".
	 */
	public void setTipoUnidadFrecuencia(int tipoUnidadFrecuencia) {
		this.tipoUnidadFrecuencia = tipoUnidadFrecuencia;
	}
	/**
     * Devuelvo la frecuencia del medicamento.
     *
     * @return the frecuencia
     */
    @Basic
    @Column(name = "FRECUENCIA")
    public Float getFrecuencia() {
        return frecuencia;
    }

    /**
     * Establezco la frecuencia del medicamento.
     *
     * @param frecuenciaNew new value for frecuencia
     */
    public void setFrecuencia(final Float frecuenciaNew) {
        this.frecuencia = frecuenciaNew;
    }

    /**
     * Obtiene el valor del campo "cantidadPrescrita".
     *
     * @return El valor del campo "cantidadPrescrita".
     */
    @Basic
    @Column(name = "CANTIDADPRESCRITA")
     public Float getCantidadPrescrita() {
		return cantidadPrescrita;
	}

    /**
     * Establece el valor del campo "cantidadPrescrita".
     *
     * @param cantidadPrescritaNew El valor del campo "cantidadPrescrita".
     */
    public void setCantidadPrescrita(final Float cantidadPrescritaNew) {
		this.cantidadPrescrita = cantidadPrescritaNew;
	}

    /**
     * Obtiene el valor del campo "cantidadAdministracion".
     *
     * @return El valor del campo "cantidadAdministracion".
     */
    @Basic
    @Column(name = "CANTIDADADMINISTRACION")
    public Float getCantidadAdministracion() {
		return cantidadAdministracion;
	}

    /**
     * Establece el valor del campo "cantidadAdministracion".
     *
     * @param cantidadAdministracionNew El valor del campo "cantidadAdministracion".
     */
	public void setCantidadAdministracion(final Float cantidadAdministracionNew) {
		this.cantidadAdministracion = cantidadAdministracionNew;
	}

    /**
     * Devuelvo la Fecha y Hora de la administracion.
     *
     * @return the fechaHoraAdm
     */
    @Basic
    @Column(name = "FECHAHORAADMINISTRACION")
    public Date getFechaHoraAdm() {
        return fechaHoraAdm;
    }

    /**
     * Establezco la Fecha y Hora de la administracion.
     *
     * @param fechaHoraAdmNew new value for fechaHoraAdm
     */
    public void setFechaHoraAdm(final Date fechaHoraAdmNew) {
        this.fechaHoraAdm = fechaHoraAdmNew;
    }

    /**
     * Devuelvo el objeto Motivo.
     *
     * @return the motivoAdm
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODMOTIVOADMINISTRACION")
    public Motivo getMotivoAdm() {
        return motivoAdm;
    }

    /**
     * Establezco el objeto Motivo.
     *
     * @param motivoAdmNew the motivoAdm to set
     */
    public void setMotivoAdm(final Motivo motivoAdmNew) {
        this.motivoAdm = motivoAdmNew;
    }

    /**
     * Devuelvo las observaciones.
     *
     * @return the observaciones
     */
    @Basic
    @Column(name = "OBSERVACIONESADMINISTRACION", length = 255)
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establezco las observaciones.
     *
     * @param observacionesNew the observaciones to set
     */
    public void setObservaciones(final String observacionesNew) {
        this.observaciones = observacionesNew;
    }

    /**
     * Devuelvo el codigo del responsable.
     *
     * @return the codUsuarioResponsable
     */
    @Basic
    @Column(name = "CODUSUARIORESPONSABLE", length = 25)
    public String getCodUsuarioResponsable() {
        return codUsuarioResponsable;
    }

    /**
     * Establezco el codigo del responsable.
     *
     * @param codUsuarioResponsableNew the codUsuarioResponsable to set
     */
    public void setCodUsuarioResponsable(final String codUsuarioResponsableNew) {
        this.codUsuarioResponsable = codUsuarioResponsableNew;
    }

    /**
     * Devuelvo la Fecha y Hora de creacion.
     *
     * @return the fechaHoraCreacion
     */
    @Basic
    @Column(name = "FECHAHORACREACION")
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establezco la Fecha y Hora de creacion.
     *
     * @param fechaHoraCreacionNew the fechaHoraCreacion to set
     */
    public void setFechaHoraCreacion(final Date fechaHoraCreacionNew) {
        this.fechaHoraCreacion = fechaHoraCreacionNew;
    }

    /**
     * nResultados.
     *
     * @return the nResultados
     */
    @Transient
    public Integer getNResultados() {
        return nResultados;
    }

    /**
     * nResultados.
     *
     * @param resultados the nResultados to set
     */
    public void setNResultados(final Integer resultados) {
        nResultados = resultados;
    }

    /**
	 * Obtiene el valor del campo "codUnidades".
	 *
	 * @return El valor del campo "codUnidades".
	 */
    @Column
	public Integer getCodUnidades() {
		return codUnidades;
	}
	/**
	 * Establece el valor del campo "codUnidades".
	 *
	 * @param codUnidades
	 *            El valor del campo "codUnidades".
	 */
	public void setCodUnidades(Integer codUnidades) {
		this.codUnidades = codUnidades;
	}
	/**
     * unidades.
     *
     * @return the unidades
     */
    @Basic
    @Column
    public String getUnidades() {
        return unidades;
    }

    /**
     * unidades.
     *
     * @param unidadesNew the unidades to set
     */
    public void setUnidades(final String unidadesNew) {
        this.unidades = unidadesNew;
    }

    /**
	 * Obtiene el valor del campo "modoAdministracion".
	 * @return the modoAdministracion
	 */
    @Basic
    @Column(length = 100)
	public String getModoAdministracion() {
		return modoAdministracion;
	}

	/**
	 * Establece el valor del campo "modoAdministracion".
	 * @param modoAdministracionNew the modoAdministracion to set
	 */
	public void setModoAdministracion(final String modoAdministracionNew) {
		this.modoAdministracion = modoAdministracionNew;
	}

    /**
     * codViaAdministracion.
     *
     * @return the codViaAdministracion
     */
    @Basic
    @Column
    public Integer getCodViaAdministracion() {
        return codViaAdministracion;
    }

    /**
     * codViaAdministracion.
     *
     * @param codViaAdministracionNew the codViaAdministracion to set
     */
    public void setCodViaAdministracion(final Integer codViaAdministracionNew) {
        this.codViaAdministracion = codViaAdministracionNew;
    }

    /**
     * descViaAdministracion.
     *
     * @return the descViaAdministracion
     */
    @Basic
    @Column
    public String getDescViaAdministracion() {
        return descViaAdministracion;
    }

    /**
     * descViaAdministracion.
     *
     * @param descViaAdministracionNew the descViaAdministracion to set
     */
    public void setDescViaAdministracion(final String descViaAdministracionNew) {
        this.descViaAdministracion = descViaAdministracionNew;
    }

    /**
     * Obtiene el valor del campo "codFluido".
     *
     * @return codFluido
     */
    @Basic
    @Column(name = "CODFLUIDO")
    public Integer getCodFluido() {
        return codFluido;
    }

    /**
     * Establece el valor del campo "codFluido".
     *
     * @param codFluidoNew Integer the codFluido to set
     */
    public void setCodFluido(final Integer codFluidoNew) {
        this.codFluido = codFluidoNew;
    }

    /**
     * Obtiene el valor del campo "base".
     *
     * @return base
     */
    @Basic
    @Column(name = "BASE")
    public boolean isBase() {
        return base;
    }

    /**
     * Establece el valor del campo "base".
     *
     * @param baseNew Boolean the base to set
     */
    public void setBase(final boolean baseNew) {
        this.base = baseNew;
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
     * @param fechaHoraPrevistaAdminNew El valor del campo "fechaHoraPrevistaAdmin".
     */
    public void setFechaHoraPrevistaAdmin(final Date fechaHoraPrevistaAdminNew) {
        this.fechaHoraPrevistaAdmin = fechaHoraPrevistaAdminNew;
    }

    /**
     * Obtiene el codigo del centro.
     *
     * @return codCentro
     */
    @Basic
    @Column(name = "CODCENTRO")
    public String getCodCentro() {
        return codCentro;
    }

    /**
     * Establece el codigo del centro.
     *
     * @param codCentroNew String
     */
    public void setCodCentro(final String codCentroNew) {
        this.codCentro = codCentroNew;
    }

    /**
     * Obtiene la descripcion del centro.
     *
     * @return descCentro
     */
    @Basic
    @Column(name = "DESCCENTRO")
    public String getDescCentro() {
        return descCentro;
    }

    /**
     * Establece la descripcion del centro.
     *
     * @param descCentroNew String
     */
    public void setDescCentro(final String descCentroNew) {
        this.descCentro = descCentroNew;
    }
	
	/**
	 * Devuelve el codigo del episodio asociado.
	 * @return the codEpisodio
	 */
    @Column(name="CODEPISODIO")
	public String getCodEpisodio() {
		return codEpisodio;
	}

	/**
	 * Establece el codigo del episodio asociado.
	 * @param codEpisodioNew the codEpisodio to set
	 */
	public void setCodEpisodio(final String codEpisodioNew) {
		this.codEpisodio = codEpisodioNew;
	}
	/**
	 * Obtiene el valor del campo "codEpisodioEjecucion".
	 *
	 * @return El valor del campo "codEpisodioEjecucion".
	 */
	@Column(name="CODEPISODIOEJECUCION")
	public String getCodEpisodioEjecucion() {
		return codEpisodioEjecucion;
	}
	/**
	 * Establece el valor del campo "codEpisodioEjecucion".
	 *
	 * @param codEpisodioEjecucion
	 *            El valor del campo "codEpisodioEjecucion".
	 */
	public void setCodEpisodioEjecucion(String codEpisodioEjecucion) {
		this.codEpisodioEjecucion = codEpisodioEjecucion;
	}
	/**
	 * Obtiene el valor del campo "codAsistenciaEjecucion".
	 *
	 * @return El valor del campo "codAsistenciaEjecucion".
	 */
	@Column(name="CODASISTENCIAEJECUCION")
	public String getCodAsistenciaEjecucion() {
		return codAsistenciaEjecucion;
	}
	/**
	 * Establece el valor del campo "codAsistenciaEjecucion".
	 *
	 * @param codAsistenciaEjecucion
	 *            El valor del campo "codAsistenciaEjecucion".
	 */
	public void setCodAsistenciaEjecucion(String codAsistenciaEjecucion) {
		this.codAsistenciaEjecucion = codAsistenciaEjecucion;
	}
	/**
	 * Devuelve el codigo del numLote.
	 * @return the numLote
	 */
	@Basic
    @Column(name = "NLOTE")
	public String getNumLote() {
		return numLote;
	}

	/**
	 * Establece el codigo del numLote.
	 * @param numLoteNew the numLote to set
	 */
	public void setNumLote(final String numLoteNew) {
		this.numLote = numLoteNew;
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
	 * @param hbmVersionNew
	 *            El valor del campo "hbmVersion".
	 */
	public void setHbmVersion(final long hbmVersionNew) {
		this.hbmVersion = hbmVersionNew;
	}
	
	/**
	 * Obtiene el valor del campo "codCentroEjecucion".
	 *
	 * @return El valor del campo "codCentroEjecucion".
	 */
	@Column
	public String getCodCentroEjecucion() {
		return codCentroEjecucion;
	}
	/**
	 * Establece el valor del campo "codCentroEjecucion".
	 *
	 * @param codCentroEjecucion
	 *            El valor del campo "codCentroEjecucion".
	 */
	public void setCodCentroEjecucion(String codCentroEjecucion) {
		this.codCentroEjecucion = codCentroEjecucion;
	}
	/**
	 * Obtiene el valor del campo "descCentroEjecucion".
	 *
	 * @return El valor del campo "descCentroEjecucion".
	 */
	@Column
	public String getDescCentroEjecucion() {
		return descCentroEjecucion;
	}
	/**
	 * Establece el valor del campo "descCentroEjecucion".
	 *
	 * @param descCentroEjecucion
	 *            El valor del campo "descCentroEjecucion".
	 */
	public void setDescCentroEjecucion(String descCentroEjecucion) {
		this.descCentroEjecucion = descCentroEjecucion;
	}
	/**
	 * Obtiene el valor del campo "codServicioEjecucion".
	 *
	 * @return El valor del campo "codServicioEjecucion".
	 */
	@Column
	public String getCodServicioEjecucion() {
		return codServicioEjecucion;
	}
	/**
	 * Establece el valor del campo "codServicioEjecucion".
	 *
	 * @param codServicioEjecucion
	 *            El valor del campo "codServicioEjecucion".
	 */
	public void setCodServicioEjecucion(String codServicioEjecucion) {
		this.codServicioEjecucion = codServicioEjecucion;
	}
	/**
	 * Obtiene el valor del campo "descServicioEjecucion".
	 *
	 * @return El valor del campo "descServicioEjecucion".
	 */
	@Column
	public String getDescServicioEjecucion() {
		return descServicioEjecucion;
	}
	/**
	 * Establece el valor del campo "descServicioEjecucion".
	 *
	 * @param descServicioEjecucion
	 *            El valor del campo "descServicioEjecucion".
	 */
	public void setDescServicioEjecucion(String descServicioEjecucion) {
		this.descServicioEjecucion = descServicioEjecucion;
	}
	/**
	 * Obtiene el valor del campo "codAreaEjecucion".
	 *
	 * @return El valor del campo "codAreaEjecucion".
	 */
	@Column
	public String getCodAreaEjecucion() {
		return codAreaEjecucion;
	}
	/**
	 * Establece el valor del campo "codAreaEjecucion".
	 *
	 * @param codAreaEjecucion
	 *            El valor del campo "codAreaEjecucion".
	 */
	public void setCodAreaEjecucion(String codAreaEjecucion) {
		this.codAreaEjecucion = codAreaEjecucion;
	}
	/**
	 * @return the codProtocoloEjecucion
	 */
	@Column(name="CODPROTOCOLOEJECUCION")
	public String getCodProtocoloEjecucion() {
		return codProtocoloEjecucion;
	}
	/**
	 * @param codProtocoloEjecucion the codProtocoloEjecucion to set
	 */
	public void setCodProtocoloEjecucion(String codProtocoloEjecucion) {
		this.codProtocoloEjecucion = codProtocoloEjecucion;
	}
	/**
	 * @return the codActividadEjecucion
	 */
	@Column(name="CODACTIVIDADEJECUCION")
	public String getCodActividadEjecucion() {
		return codActividadEjecucion;
	}
	/**
	 * @param codActividadEjecucion the codActividadEjecucion to set
	 */
	public void setCodActividadEjecucion(String codActividadEjecucion) {
		this.codActividadEjecucion = codActividadEjecucion;
	}
	/**
	 * @return the codHojaVisitaEjecucion
	 */
	@Column(name="CODHOJAVISITAEJECUCION")
	public String getCodHojaVisitaEjecucion() {
		return codHojaVisitaEjecucion;
	}
	/**
	 * @param codHojaVisitaEjecucion the codHojaVisitaEjecucion to set
	 */
	public void setCodHojaVisitaEjecucion(String codHojaVisitaEjecucion) {
		this.codHojaVisitaEjecucion = codHojaVisitaEjecucion;
	}

}
