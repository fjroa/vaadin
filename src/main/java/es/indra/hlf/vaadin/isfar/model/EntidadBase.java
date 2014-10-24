package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Clase que contiene campos comunes de creacion y modificacion.
 * @author tnevado
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class EntidadBase implements Serializable {	
	/**
	 * Usuario creador.
	 */
	private String codUsuarioCreacion;
	/**
	 * Fecha y hora de la creacion.
	 */
	private Date fechaHoraCreacion;
	/**
	 * Usuario de la ultima modificacion.
	 */
	private String codUsuarioUltimaModificacion;
	/**
	 * Fecha y hora de la ultima modificacion.
	 */
	private Date fechaHoraUltimaModificacion;

	/**
	 * Indica si esta activo o no.
	 */
	private boolean activo;

	/**
	 * Control de concurrencia de hibernate, tecnica de bloqueo optimista.
	 */
	private long hbmVersion;
	
	/**
	 * Usuario de auditoria
	 */
	private String codUsuarioAuditoria;

	
	
	/**
	 * Obtiene el valor del campo "codUsuarioCreacion".
	 *
	 * @author tnevado
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
	 * @author tnevado
	 *
	 * @param codUsuarioCreacion
	 *            El valor del campo "codUsuarioCreacion".
	 */
	public void setCodUsuarioCreacion(String codUsuarioCreacion) {
		this.codUsuarioCreacion = codUsuarioCreacion;
	}
	/**
	 * Obtiene el valor del campo "fechaHoraCreacion".
	 *
	 * @author tnevado
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
	 * @author tnevado
	 *
	 * @param fechaHoraCreacion
	 *            El valor del campo "fechaHoraCreacion".
	 */
	public void setFechaHoraCreacion(Date fechaHoraCreacion) {
		this.fechaHoraCreacion = fechaHoraCreacion;
	}
	/**
	 * Obtiene el valor del campo "codUsuarioUltimaModificacion".
	 *
	 * @author tnevado
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
	 * @author tnevado
	 *
	 * @param codUsuarioUltimaModificacion
	 *            El valor del campo "codUsuarioUltimaModificacion".
	 */
	public void setCodUsuarioUltimaModificacion(String codUsuarioUltimaModificacion) {
		this.codUsuarioUltimaModificacion = codUsuarioUltimaModificacion;
	}
	/**
	 * Obtiene el valor del campo "fechaHoraUltimaModificacion".
	 *
	 * @author tnevado
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
	 * @author tnevado
	 *
	 * @param fechaHoraUltimaModificacion
	 *            El valor del campo "fechaHoraUltimaModificacion".
	 */
	public void setFechaHoraUltimaModificacion(Date fechaHoraUltimaModificacion) {
		this.fechaHoraUltimaModificacion = fechaHoraUltimaModificacion;
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
	 * @return the codUsuarioAuditoria
	 */
	@Column(name = "USER_AUDIT")
	public String getCodUsuarioAuditoria() {
		return codUsuarioAuditoria;
	}
	/**
	 * @param codUsuarioAuditoria the codUsuarioAuditoria to set
	 */
	public void setCodUsuarioAuditoria(String codUsuarioAuditoria) {
		this.codUsuarioAuditoria = codUsuarioAuditoria;
	}
	
	/**
	 * Constructor vacio.
	 *
	 */
	public EntidadBase() {
		super();
	}
}
