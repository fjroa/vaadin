package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;

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

import org.hibernate.annotations.BatchSize;

/**
 * Una de las horas que forma parte del horario de una pauta de administracion.
 * @author tnevado
 */
@Entity
@BatchSize(size=500)
@Table(name = "HORA_PAUTA")
public class HoraPauta implements Serializable, Comparable < HoraPauta > {
	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 9210301314714384845L;
	
	/**
	 * Constructor.
	 *
	 */
	public HoraPauta() {
		super();
	}
	/**
	 * Id
	 * codHora Integer.
	 */
	private Integer id;
	/**
	 * Una de las hora que forma parte del horario de una pauta de administracion.
	 * descHora Date.
	 */
	private Date descHora;
	/**
	 * Referencia a la pauta a la que esta asociada esta hora.
	 * codPauta Integer.
	 */
	private PautaAdministracion pauta;
	/**
	 * codUsuarioCreacion String.
	 */
	private String codUsuarioCreacion;
	/**
	 * fechaHoraCreacion Date.
	 */
	private Date fechaHoraCreacion;
	/**
	 * codUsuarioUltimaModificacion String.
	 */
	private String codUsuarioUltimaModificacion;
	/**
	 * fechaHoraUltimaModificacion String.
	 */
	private Date fechaHoraUltimaModificacion;
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
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_HORA_PAUTA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODHORA")
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
	 * Obtiene el valor del campo "descHora".
	 *
	 * @return El valor del campo "descHora".
	 */
	@Column
	public Date getDescHora() {
		return descHora;
	}
	/**
	 * Establece el valor del campo "descHora".
	 *
	 * @param descHora
	 *            El valor del campo "descHora".
	 */
	public void setDescHora(Date descHora) {
		this.descHora = descHora;
	}

	/**
	 * Obtiene el valor del campo "pauta".
	 *
	 * @return El valor del campo "pauta".
	 */
	@ManyToOne
	@JoinColumn(name = "CODPAUTA")
	public PautaAdministracion getPauta() {
		return pauta;
	}
	/**
	 * Establece el valor del campo "pauta".
	 *
	 * @param pauta
	 *            El valor del campo "pauta".
	 */
	public void setPauta(PautaAdministracion pauta) {
		this.pauta = pauta;
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
	 * Comparacion de objetos HoraPauta.
	 * @author tnevado
	 *
	 * @param o HoraPauta
	 * @return int
	 */
	public int compareTo(HoraPauta o) {
		int ret = 0;
		if (this.descHora != null) {
			if (o.descHora != null) {
				ret = this.descHora.compareTo(o.descHora);
			} else {
				ret = +1;
			}
		} else {
			if (o.descHora != null) {
				ret = -1;
			} else {
				ret = 0;
			}
		}
		return ret;
	}
	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#equals(java.lang.Object)
	 */
	public boolean equals(Object arg0) {
		boolean ret = false;
		if (this.descHora == null) {
			if (arg0 == null) {
				ret = true;
			} else {
				ret = false;
			}
		} else {
			if (arg0 == null) {
				ret = false;
			} else {
				ret = this.descHora.equals(((HoraPauta)arg0).getDescHora());
			}
		}
		return ret;
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
     * Copia esta hora.
     * @return
     */
    public HoraPauta copiar() {
    	HoraPauta ret = new HoraPauta();
    	ret.setId(null);
    	ret.setActivo(this.isActivo());
    	ret.setDescHora(this.getDescHora());    	
    	return ret;
    }
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "HoraPauta [id=" + id + ", descHora=" + descHora + ", activo=" + activo + "]";
	}

}
