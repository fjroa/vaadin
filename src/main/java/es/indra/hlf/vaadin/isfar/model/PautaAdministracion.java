package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

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
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 * Pauta de administracion de medicamentos que define un horario prefijado en el que se realizaran las
 * administraciones de las prescripciones asociadas a el.
 * @author tnevado
 */
@Entity
@Table(name = "PAUTA_ADMINISTRACION")
public class PautaAdministracion implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 4272953493636372708L;
	/**
	 * ERROR_HABILITAR_PAUTA_YA_EXISTE_HABILITADA String.
	 */
	public static final String ERROR_HABILITAR_PAUTA_YA_EXISTE_HABILITADA =
		"error_habilitar_pauta_ya_existe_habilitada";
	/**
	 * Restriccion de unicidad de itinerarios activos por unidad de enfermeria
	 * String RESTRICCION_CENTRO_UE_UK.
	 */
	public static String RESTRICCION_IDX_PAUTA_UE_CENTRO_UK = "IDX_PAUTA_UE_CENTRO_UK";
	
	/**
	 * Constructor.
	 *
	 */
	public PautaAdministracion() {
		super();
	}
	/**
	 * Id.
	 * codPauta Integer.
	 */
	private Integer id;
	/**
	 * Descripcion de la pauta.
	 * descPauta Float.
	 */
	private Float descPauta;
	/**
	 *  codigo del centro de la pauta.
	 */
	private String codCentro;
	/**
	 *  descripcion del centro de la pauta.
	 */
	private String descCentro;
	/**
	 * Horario asociado a esta pauta.
	 * horario Set&lt;HoraPauta&gt;.
	 */
	private SortedSet < HoraPauta > horario = new TreeSet < HoraPauta >();
	/**
	 * Indica si el registro esta activo o no;
	 * activo boolean.
	 */
	private boolean activo;
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
	 * Codigo de la posologia en ISPRE.
	 */
	private Integer codPautaPosologiaPRE;
	/**
	 * Descripcion de la posologia en ISPRE.
	 */
	private String descPautaPosologiaPRE;
	/**
	 * Control de concurrencia con Hibernate.
	 * hbmVersion long.
	 */
	private long hbmVersion;
	
	/**
     * Attribute codUsuarioAuditoria.
     */
    private String codUsuarioAuditoria; //NOPMD

    /**
    * Unidad de enfermería a la que aplica la pauta.
    */
    private PautaUnidadEnfermeria unidadEnfermeria;

	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_PAUTA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODPAUTA")
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
	 * Obtiene el valor del campo "descPauta".
	 *
	 * @return El valor del campo "descPauta".
	 */
	@Column
	public Float getDescPauta() {
		return descPauta;
	}
	/**
	 * Establece el valor del campo "descPauta".
	 *
	 * @param descPauta
	 *            El valor del campo "descPauta".
	 */
	public void setDescPauta(Float descPauta) {
		this.descPauta = descPauta;
	}
	/**
	 * Obtiene el valor del campo "codCentro".
	 *
	 * @return El valor del campo "codCentro".
	 */
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
	 * Obtiene el valor del campo "horario".
	 *
	 * @return El valor del campo "horario".
	 */
	@OneToMany(mappedBy = "pauta", fetch=FetchType.LAZY)
    @Sort(type = SortType.NATURAL)
	@BatchSize(size=500)
	public SortedSet < HoraPauta > getHorario() {
		return horario;
	}
	/**
	 * Establece el valor del campo "horario".
	 *
	 * @param horario
	 *            El valor del campo "horario".
	 */
	public void setHorario(SortedSet < HoraPauta > horario) {
		this.horario = horario;
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
	 * Obtiene el valor del campo "codPautaPosologiaPRE".
	 * @return the codPautaPosologiaPRE
	 */
	@Column
	public Integer getCodPautaPosologiaPRE() {
		return codPautaPosologiaPRE;
	}
	/**
	 * Establece el valor del campo "codPautaPosologiaPRE".
	 * @param codPautaPosologiaPRE the codPautaPosologiaPRE to set
	 */
	public void setCodPautaPosologiaPRE(Integer codPautaPosologiaPRE) {
		this.codPautaPosologiaPRE = codPautaPosologiaPRE;
	}
	/**
	 * Obtiene el valor del campo "descPautaPosologiaPRE".
	 * @return the descPautaPosologiaPRE
	 */
	@Column (length = 80)
	public String getDescPautaPosologiaPRE() {
		return descPautaPosologiaPRE;
	}
	/**
	 * Establece el valor del campo "descPautaPosologiaPRE".
	 * @param descPautaPosologiaPRE the descPautaPosologiaPRE to set
	 */
	public void setDescPautaPosologiaPRE(String descPautaPosologiaPRE) {
		this.descPautaPosologiaPRE = descPautaPosologiaPRE;
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
	 * Anade una hora de una pauta.
	 * @param o HoraPauta
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addHoraPauta(final HoraPauta hora) {
		if (hora != null) {
			hora.setPauta(this);
		}
		return horario.add(hora);
	}
	/**
	 * Elimina una hora de una pauta.
	 * @param o HoraPauta
	 * @return boolean
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean removeHoraPauta(final HoraPauta hora) {
		if (hora != null) {
			hora.setPauta(null);
		}
		return horario.remove(hora);
	}
	/**
	 * Devuelve la lista de horas que tiene el horario.
	 * @return List&lt;Date&gt;
	 */
	public List < Date > obtenerHorasPauta() {
		List < Date > ret = new ArrayList < Date >();
		Iterator < HoraPauta > iter = this.horario.iterator();
		HoraPauta hora = null;
		if (this.horario != null && !this.horario.isEmpty()) {
			while (iter.hasNext()) {
				hora = iter.next();
				if (hora.isActivo()) {
					ret.add(hora.getDescHora());
				}
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
     * Devuelve el valor de unidadEnfermeria
     * @return the unidadEnfermeria
     */
    @ManyToOne
    @JoinColumn(name = "CODPAUTAUE")
    public PautaUnidadEnfermeria getUnidadEnfermeria () {
    	return unidadEnfermeria;
    }

	/**
	 * Modifica el valor de codUsuarioAuditoria.
	 * @param unidadEnfermeria the unidadEnfermeria to set
	 */
	public void setUnidadEnfermeria(PautaUnidadEnfermeria unidadEnfermeria) {
		this.unidadEnfermeria = unidadEnfermeria;
	}
	
	/**
	 * Crea una copia de esta pauta.
	 * @return
	 */
	public PautaAdministracion copiar() {
		PautaAdministracion ret = new PautaAdministracion();
		ret.setId(null);
		ret.setActivo(this.isActivo());
		ret.setCodCentro(this.getCodCentro());
		ret.setCodPautaPosologiaPRE(this.getCodPautaPosologiaPRE());
		ret.setDescCentro(this.getDescCentro());
		ret.setDescPauta(this.getDescPauta());
		ret.setDescPautaPosologiaPRE(this.getDescPautaPosologiaPRE());
		ret.setHorario(this.copiarHorario());
		return ret;
	}
	
	/**
	 * Crea una copia de la lista de horas de la pauta.
	 * @return
	 */
	private SortedSet<HoraPauta> copiarHorario() {
		SortedSet < HoraPauta > ret = new TreeSet < HoraPauta >();
		if (this.getHorario() != null
			&& !this.getHorario().isEmpty()) {
			for (HoraPauta hora : this.getHorario()) {
				ret.add(hora.copiar());
			}
		}
		return ret;
	}
	/**
	 * ToString
	 * @return
	 */
	@Override
	public String toString() {
		return "PautaAdministracion [id=" + id + ", descPauta=" + descPauta
				+ ", codCentro=" + codCentro + ", descCentro=" + descCentro
				+ ", horario=" + horario + ", activo=" + activo
				+ ", codPautaPosologiaPRE=" + codPautaPosologiaPRE
				+ ", descPautaPosologiaPRE=" + descPautaPosologiaPRE + "]";
	}
}
