package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Clase de dominio para Medicamentos no Unidosis.
 * @author tnevado
 */
@Entity
@Table(name = "MEDICAMENTO_NO_UNIDOSIS")
public class MedicamentoNoUnidosis implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = -1850224324602591090L;
	
	/**
	 * Constructor.
	 *
	 */
	public MedicamentoNoUnidosis() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * codMedicamento long.
	 */
	private long codMedicamento;
	/**
	 * descMedicamento String.
	 */
	private String descMedicamento;
	/**
	 * codCentro String.
	 */
	private String codCentro;
	/**
	 * descCentro String.
	 */
	private String descCentro;
	/**
	 * fechaHoraCreacion Date.
	 */
	private Date fechaHoraCreacion;
	/**
	 * codUsuarioCreacion String.
	 */
	private String codUsuarioCreacion;

	/**
	 * fechaHoraUltimaModificacion Date.
	 */
	private Date fechaHoraUltimaModificacion;
	/**
	 * codUsuarioInhabilitacion String.
	 */
	private String codUsuarioUltimaModificacion;
	/**
	 * activo boolean.
	 */
	private boolean activo;
	/**
	 * hbmVersion long.
	 */
	private long hbmVersion;
	
	/**
     * Attribute codUsuarioAuditoria.
     */
    private String codUsuarioAuditoria; //NOPMD

	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_MED_NO_UNIDOSIS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODMEDNOUNIDOSIS")
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
	 * Obtiene el valor del campo "codMedicamento".
	 *
	 * @return El valor del campo "codMedicamento".
	 */
	@Column
	public long getCodMedicamento() {
		return codMedicamento;
	}
	/**
	 * Establece el valor del campo "codMedicamento".
	 *
	 * @param codMedicamento
	 *            El valor del campo "codMedicamento".
	 */
	public void setCodMedicamento(long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	/**
	 * Obtiene el valor del campo "descMedicamento".
	 *
	 * @return El valor del campo "descMedicamento".
	 */
	@Column
	public String getDescMedicamento() {
		return descMedicamento;
	}
	/**
	 * Establece el valor del campo "descMedicamento".
	 *
	 * @param descMedicamento
	 *            El valor del campo "descMedicamento".
	 */
	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
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
	 * @param codCentro
	 *            El valor del campo "codCentro".
	 */
	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
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
	 * @param descCentro
	 *            El valor del campo "descCentro".
	 */
	public void setDescCentro(String descCentro) {
		this.descCentro = descCentro;
	}
	/**
	 * Obtiene el valor del campo "fechaHoraCreacion".
	 *
	 * @return El valor del campo "fechaHoraCreacion".
	 */
	@Column
	public Date getFechaHoraCreacion() {
		return fechaHoraCreacion;
	}
	/**
	 * Establece el valor del campo "fechaHoraCreacion".
	 *
	 * @param fechaHoraCreacion
	 *            El valor del campo "fechaHoraCreacion".
	 */
	public void setFechaHoraCreacion(Date fechaHoraCreacion) {
		this.fechaHoraCreacion = fechaHoraCreacion;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioCreacion".
	 *
	 * @return El valor del campo "codUsuarioCreacion".
	 */
	@Column
	public String getCodUsuarioCreacion() {
		return codUsuarioCreacion;
	}
	/**
	 * Establece el valor del campo "codUsuarioCreacion".
	 *
	 * @param codUsuarioCreacion
	 *            El valor del campo "codUsuarioCreacion".
	 */
	public void setCodUsuarioCreacion(String codUsuarioCreacion) {
		this.codUsuarioCreacion = codUsuarioCreacion;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraUltimaModificacion".
	 *
	 * @return El valor del campo "fechaHoraUltimaModificacion".
	 */
	@Column
	public Date getFechaHoraUltimaModificacion() {
		return fechaHoraUltimaModificacion;
	}
	/**
	 * Establece el valor del campo "fechaHoraUltimaModificacion".
	 *
	 * @param fechaHoraUltimaModificacion
	 *            El valor del campo "fechaHoraUltimaModificacion".
	 */
	public void setFechaHoraUltimaModificacion(Date fechaHoraUltimaModificacion) {
		this.fechaHoraUltimaModificacion = fechaHoraUltimaModificacion;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioUltimaModificacion".
	 *
	 * @return El valor del campo "codUsuarioUltimaModificacion".
	 */
	@Column
	public String getCodUsuarioUltimaModificacion() {
		return codUsuarioUltimaModificacion;
	}
	/**
	 * Establece el valor del campo "codUsuarioUltimaModificacion".
	 *
	 * @param codUsuarioUltimaModificacion
	 *            El valor del campo "codUsuarioUltimaModificacion".
	 */
	public void setCodUsuarioUltimaModificacion(String codUsuarioUltimaModificacion) {
		this.codUsuarioUltimaModificacion = codUsuarioUltimaModificacion;
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
	/**
	 * Obtiene el valor del campo "hbmVersion".
	 *
	 * @return El valor del campo "hbmVersion".
	 */
	@Version
	@Column
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
