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
 * Clase de dominio para Formas Farmaceuticas no Unidosis.
 * @author tnevado
 *
 */
@Entity
@Table(name = "FORMA_FARMA_NO_UNIDOSIS")
public class FormaFarmaceuticaNoUnidosis implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = -3659825202268457362L;
	
	/**
	 * Constructor.
	 *
	 */
	public FormaFarmaceuticaNoUnidosis() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * codForma long.
	 */
	private long codForma;
	/**
	 * descForma String.
	 */
	private String descForma;
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
	 * codUsuarioUltimaModificacion String.
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
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_FORMA_NO_UNIDOSIS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODFORMAFARMANOUNIDOSIS")
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
	 * Obtiene el valor del campo "codForma".
	 *
	 * @return El valor del campo "codForma".
	 */
	@Column(name = "CODFORMAFARMA")
	public long getCodForma() {
		return codForma;
	}
	/**
	 * Establece el valor del campo "codForma".
	 *
	 * @param codForma
	 *            El valor del campo "codForma".
	 */
	public void setCodForma(long codForma) {
		this.codForma = codForma;
	}
	/**
	 * Obtiene el valor del campo "descForma".
	 *
	 * @return El valor del campo "descForma".
	 */
	@Column(name = "DESCFORMAFARMA")
	public String getDescForma() {
		return descForma;
	}
	/**
	 * Establece el valor del campo "descForma".
	 *
	 * @param descForma
	 *            El valor del campo "descForma".
	 */
	public void setDescForma(String descForma) {
		this.descForma = descForma;
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
