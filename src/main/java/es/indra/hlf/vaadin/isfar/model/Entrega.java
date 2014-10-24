package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Version;

/**
 * Clase de dominio para la entidad Entrega.
 * @author INDRA
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ENTREGA")
@SequenceGenerator(name = "SEQ_ENTREGA",
		sequenceName = "SEQ_ENTREGA", allocationSize = 1)
public class Entrega implements Serializable {
	/** Estado Pendiente de Preparar para Dispensaciones. */
	private static final int COD_ESTADO_DISP_PENDIENTE_PREP = 7;
	/**
	 * Codigo interno de la administracion de prescripcion.
	 */
	private Integer id;
	/**
	 * Prescripcion del paciente.
	 */
	private PrescripcionMedicamento prescripcionMedicamento;
    /**
     * Paciente que recogera la entrega.
     */
    private Paciente paciente;
	/**
	 * Estado de la entrega.
	 */
	private Estado estado;
	/**
	 * Codigo del episodio creado.
	 */
	private String codEpisodio;
	/**
	 * Codigo del medicamento.
	 */
	private Long codMedicamento;
	/**
	 * Descripcion del medicamento.
	 */
	private String descMedicamento;
    /**
     * Fecha en que se espera que se recoga la dispensacion.
     */
    private Date fechaPrevistaDispensacion;
    /**
     * Fecha/hora real en la que se recoge.
     */
    private Date fechaHoraDispensada;
    /**
     * Codigo del usuario que realiza la ultima modificacion.
     */
    private String codUsuarioUltimaModificacion;
    /**
     * Fecha/hora de la ultima modificacion.
     */
    private Date fechaHoraUltimaModificacion;
    /**
     * Cantidad.
     */
    private Float cantidad;
    /**
     * Unidades.
     */
    private String unidades;
    /**
	 * Modo de administracion del medicamento si es no unidosis.
	 */
	private String modoAdministracion;
    /**
     * Si tiene fluidos indica si es una base.
     */
    private boolean base;
    /**
     * Codigo del fluido (si se trata de un multimedicamento).
     */
    private Integer codFluido;
	/**
	 * Codigo de la agenda (consulta)
	 *
	private Integer codAgenda;
	**
	 * Descripcion de la agenda (consulta)
	 *
	private String descAgenda;*/
	/**
	 * Numero de lote del medicamento.
	 */
	private String numLote;
	/**
	 * HBM Version.
	 */
	private long hbmVersion;
	
	/**
     * Attribute codUsuarioAuditoria.
     */
    private String codUsuarioAuditoria; //NOPMD

    
	  /*************/
	 /** METODOS **/
	/*************/

	/**
	 * Constructor por defecto.
	 */
	public Entrega() {
		super();
	}

	/**
	 * Devuelve el codigo de la entrega.
	 * @return Integer
	 */
	@Basic
	@Id
	@Column(name = "CODENTREGA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENTREGA")
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el codigo de la entrega.
	 * @param codEntrega the codEntrega to set
	 */
	public void setId(Integer codEntrega) {
		this.id = codEntrega;
	}

	/**
	 * Devuelve el objeto PrescripcionMedicamento.
	 * @return the prescMed
	 */
	@ManyToOne
	@JoinColumn(name = "CODPRESCRIPCIONMEDICAMENTO")
	public PrescripcionMedicamento getPrescripcionMedicamento() {
		return prescripcionMedicamento;
	}

	/**
	 * Establece el objeto PrescripcionMedicamento.
	 * @param prescMed the PrescripcionMedicamento to set
	 */
	public void setPrescripcionMedicamento(PrescripcionMedicamento prescMed) {
		this.prescripcionMedicamento = prescMed;
	}

    /**
     * Devuelve el objeto Paciente.
     * @return the paciente
     */
	@ManyToOne
    @JoinColumn(name = "CODPACIENTE")
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el objeto Paciente.
     * @param paciente the Paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

	/**
	 * Devuelve el objeto Estado.
	 * @return the estado
	 */
	@ManyToOne
	@JoinColumn(name = "CODESTADO")
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Establece el objeto Estado.
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

    /**
     * Devuelve el valor del campo "codEpisodio".
	 * @return the codEpisodio
	 */
	@Column (length = 25)
	public String getCodEpisodio() {
		return codEpisodio;
	}

	/**
	 * Establece el valor del campo "codEpisodio".
	 * @param codEpisodio the codEpisodio to set
	 */
	public void setCodEpisodio(String codEpisodio) {
		this.codEpisodio = codEpisodio;
	}

	/**
	 * Devuelve el valor del campo "codMedicamento".
	 * @return the codMedicamento
	 */
	@Column
	public Long getCodMedicamento() {
		return codMedicamento;
	}

	/**
	 * Establece el valor del campo "codMedicamento".
	 * @param codMedicamento the codMedicamento to set
	 */
	public void setCodMedicamento(Long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	/**
	 * Devuelve el valor del campo "descMedicamento".
	 * @return the descMedicamento
	 */
	@Column (length = 255)
	public String getDescMedicamento() {
		return descMedicamento;
	}

	/**
	 * Establece el valor del campo "descMedicamento".
	 * @param descMedicamento the descMedicamento to set
	 */
	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
	}

	/**
	 * Obtiene el valor del campo "fechaPrevistaDispensacion".
	 * @return El valor del campo "fechaPrevistaDispensacion".
	 */
	@Column(name = "FECHAPREVISTADISPENSACION")
	public Date getFechaPrevistaDispensacion() {
		return fechaPrevistaDispensacion;
	}

	/**
	 * Establece el valor del campo "fechaPrevistaDispensacion".
	 * @param fechaPrevistaDispensacion El valor del campo "fechaPrevistaDispensacion".
	 */
	public void setFechaPrevistaDispensacion(Date fechaPrevistaDispensacion) {
		this.fechaPrevistaDispensacion = fechaPrevistaDispensacion;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraDispensada".
	 * @return El valor del campo "fechaHoraDispensada".
	 */
	@Column(name = "FECHAHORADISPENSADA")
	public Date getFechaHoraDispensada() {
		return fechaHoraDispensada;
	}

	/**
	 * Establece el valor del campo "fechaHoraDispensada".
	 * @param fechaHoraDispensada El valor del campo "fechaHoraDispensada".
	 */
	public void setFechaHoraDispensada(Date fechaHoraDispensada) {
		this.fechaHoraDispensada = fechaHoraDispensada;
	}

	/**
	 * Devuelve el valor del campo "codUsuarioUltimaModificacion".
	 * @return the codUsuarioUltimaModificacion
	 */
	@Column(length = 25)
	public String getCodUsuarioUltimaModificacion() {
		return codUsuarioUltimaModificacion;
	}

	/**
	 * Establece el valor del campo "codUsuarioUltimaModificacion".
	 * @param codUsuarioUltimaModificacion the codUsuarioUltimaModificacion to set
	 */
	public void setCodUsuarioUltimaModificacion(String codUsuarioUltimaModificacion) {
		this.codUsuarioUltimaModificacion = codUsuarioUltimaModificacion;
	}

	/**
	 * Devuelve el valor del campo "fechaHoraUltimaModificacion".
	 * @return the fechaHoraUltimaModificacion
	 */
	@Column
	public Date getFechaHoraUltimaModificacion() {
		return fechaHoraUltimaModificacion;
	}

	/**
	 * Establece el valor del campo "fechaHoraUltimaModificacion".
	 * @param fechaHoraUltimaModificacion the fechaHoraUltimaModificacion to set
	 */
	public void setFechaHoraUltimaModificacion(
			Date fechaHoraUltimaModificacion) {
		this.fechaHoraUltimaModificacion = fechaHoraUltimaModificacion;
	}

	/**
	 * Devuelve el valor del campo "cantidad".
	 * @return the cantidad
	 */
	@Column
	public Float getCantidad() {
		return cantidad;
	}

	/**
	 * Establece el valor del campo "cantidad".
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Devuelve el valor del campo "unidades".
	 * @return the unidades
	 */
	@Column(length = 80)
	public String getUnidades() {
		return unidades;
	}

	/**
	 * Establece el valor del campo "unidades".
	 * @param unidades the unidades to set
	 */
	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	/**
	 * Obtiene el valor del campo "modoAdministracion".
	 * @return the modoAdministracion
	 */
    @Column(length = 100)
	public String getModoAdministracion() {
		return modoAdministracion;
	}

	/**
	 * Establece el valor del campo "modoAdministracion".
	 * @param modoAdministracion the modoAdministracion to set
	 */
	public void setModoAdministracion(String modoAdministracion) {
		this.modoAdministracion = modoAdministracion;
	}

	/**
	 * Devuelve el valor del campo "base".
	 * @return the base
	 */
	@Column
	public boolean isBase() {
		return base;
	}

	/**
	 * Establece el valor del campo "base".
	 * @param base the base to set
	 */
	public void setBase(boolean base) {
		this.base = base;
	}

	/**
	 * Devuelve el valor del campo "codFluido".
	 * @return the codFluido
	 */
	@Column
	public Integer getCodFluido() {
		return codFluido;
	}

	/**
	 * Establece el valor del campo "codFluido".
	 * @param codFluido the codFluido to set
	 */
	public void setCodFluido(Integer codFluido) {
		this.codFluido = codFluido;
	}

	/**
	 * Devuelve el valor del campo "codAgenda"
	 * @return the codAgenda
	 *
	@Column
	public Integer getCodAgenda() {
		return codAgenda;
	}

	**
	 * Establece el valor del campo "codAgenda"
	 * @param codAgenda the codAgenda to set
	 *
	public void setCodAgenda(Integer codAgenda) {
		this.codAgenda = codAgenda;
	}

	/**
	 * Devuelve el valor del campo "descAgenda"
	 * @return the descAgenda
	 *
	@Column(length = 255)
	public String getDescAgenda() {
		return descAgenda;
	}

	**
	 * Establece el valor del campo "descAgenda"
	 * @param descAgenda the descAgenda to set
	 *
	public void setDescAgenda(String descAgenda) {
		this.descAgenda = descAgenda;
	}*/

	/**
	 * Devuelve el valor del campo "numLote".
	 * @return the numLote
	 */
	@Column(name = "NLOTE", length = 25)
	public String getNumLote() {
		return numLote;
	}

	/**
	 * Establece el valor del campo "numLote".
	 * @param numLote the numLote to set
	 */
	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}

	/**
	 * Obtiene el valor del campo "hbmVersion".
	 * @return El valor del campo "hbmVersion".
	 */
	@Version
	@Column(name = "HBM_VERSION")
	public long getHbmVersion() {
		return hbmVersion;
	}

	/**
	 * Establece el valor del campo "hbmVersion".
	 * @param hbmVersion El valor del campo "hbmVersion".
	 */
	public void setHbmVersion(long hbmVersion) {
		this.hbmVersion = hbmVersion;
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

}
