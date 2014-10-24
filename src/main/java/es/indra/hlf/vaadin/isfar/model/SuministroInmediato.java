package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *	Clase que alberga la información de una actualización de la carga de un carro.
 */
@SuppressWarnings("serial")
@Entity
@BatchSize(size=500)
@Table(name = "ADMIN_INMEDIATA_ACT_CARRO")
@SequenceGenerator(name = "SEQ_ADMIN_INMEDIATA_ACT_CARRO",
		sequenceName = "SEQ_ADMIN_INMEDIATA_ACT_CARRO", allocationSize = 1)
public class SuministroInmediato implements Serializable {

	/**
	 *  Constante para asignar al campo tipo cuando se trata de un suministro inmediato.
	 * TIPO_SUM_INMEDIATO int = 0.
	 */
	public static final int TIPO_SUM_INMEDIATO = 0;
	/**
	 * Constante para asignar al campo tipo cuando se trata de una actualización de carro.
	 * TIPO_ACT_CARRO int = 1.
	 */
	public static final int TIPO_ACT_CARRO = 1;
	/**
	 * Constante para asignar al campo tipo cuando se trata de medicación al alta.
	 * TIPO_MED_AL_ALTA int = 2.
	 */
	public static final int TIPO_MED_AL_ALTA = 2;

	/**
	 * Constructor.
	 *
	 */
	public SuministroInmediato() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * tipo int.
	 */
	private Integer tipo;
	/**
	 * Fecha de creación.
	 */
	private Date fechaCreacion;
	/**
	 * codProfesional String.
	 */
	private String codProfesional;
	/**
	 * descProfesional String.
	 */
	private String descProfesional;
	/**
	 * CarroUnidosisDetalle actualizado.
	 * vacio en el caso de que sea de tipo TIPO_SUM_INMEDIATO y TIPO_MED_AL_ALTA
	 */
    private CarroUnidosisDetalle carroUnidosisDetalle;
	/**
	 * prescripcion PrescripcionMedicamento.
	 */
	private PrescripcionMedicamento prescripcion;
	/**
	 * estadoMedPaciente EstadoMedicacionPaciente.
	 */
	private EstadoMedicacionPaciente estadoMedPaciente;
	/**
	 * cantidad Float. cantidad medicamento en el carro antes a la actualización.
	 */
	private Float cantidadAnterior;
	/**
	 * cantidad Float. cantidad de medicamento.
	 */
	private Float cantidad;
	/**
	 * Indica si ha sido suministrada o no la cantidad requerida de medicamento por farmacia.
	 * suministrado boolean.
	 */
	private boolean suministrado;

	/**
	 * Para suministros inmediatos indica la fecha prevista de la toma.
	 * fechaPrevAdministracion Date.
	 */
	private Date fechaPrevAdministracion;
	/**
	 * Fecha de caducidad.
	 */
	private Date fechaCaducidad;

	/**
	 * numero de tomas que componen la actualización en el momento de producirse Integer.
	 */
	private Integer numTomas;
	/**
	 * Lista de Administraciones asociadas a la actualizacion de carro o al suministro inmediato.
	 * vacio en el caso de que sea de tipo TIPO_MED_AL_ALTA
	 */
    private Set < AdministracionPrescripcion >
		administracionesPaciente = new HashSet < AdministracionPrescripcion >();
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
	@Basic
	@Id
	@Column(name = "CODADMININMEDIATAACTCARRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADMIN_INMEDIATA_ACT_CARRO")
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
	 * Obtiene el valor del campo "tipo".
	 *
	 * @return El valor del campo "tipo".
	 */
	@Column
	public Integer getTipo() {
		return tipo;
	}
	/**
	 * Establece el valor del campo "tipo".
	 *
	 * @param tipo
	 *            El valor del campo "tipo".
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	/**
	 * Obtiene el valor del campo "fechaCreacion".
	 *
	 * @return El valor del campo "fechaCreacion".
	 */
	@Column
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Establece el valor del campo "fechaCreacion".
	 *
	 * @param fechaCreacion
	 *            El valor del campo "fechaCreacion".
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Obtiene el valor del campo "codProfesional".
	 *
	 * @return El valor del campo "codProfesional".
	 */
	@Column(name = "CODPRESCRIPTOR")
	public String getCodProfesional() {
		return codProfesional;
	}
	/**
	 * Establece el valor del campo "codProfesional".
	 *
	 * @param codProfesional
	 *            El valor del campo "codProfesional".
	 */
	public void setCodProfesional(String codProfesional) {
		this.codProfesional = codProfesional;
	}
	/**
	 * Obtiene el valor del campo "descProfesional".
	 *
	 * @return El valor del campo "descProfesional".
	 */
	@Column(name = "DESCPRESCRIPTOR")
	public String getDescProfesional() {
		return descProfesional;
	}
	/**
	 * Establece el valor del campo "descProfesional".
	 *
	 * @param descProfesional
	 *            El valor del campo "descProfesional".
	 */
	public void setDescProfesional(String descProfesional) {
		this.descProfesional = descProfesional;
	}
	/**
	 * Obtiene el valor del campo "carroUnidosisDetalle".
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
	 * @param carroUnidosisDetalle
	 *            El valor del campo "carroUnidosisDetalle".
	 */
	public void setCarroUnidosisDetalle(CarroUnidosisDetalle carroUnidosisDetalle) {
		this.carroUnidosisDetalle = carroUnidosisDetalle;
	}
	/**
	 * Obtiene el valor del campo "prescripcion".
	 *
	 * @return El valor del campo "prescripcion".
	 */
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CODPRESCRIPCIONMEDICAMENTO")
	public PrescripcionMedicamento getPrescripcion() {
		return prescripcion;
	}
	/**
	 * Establece el valor del campo "prescripcion".
	 *
	 * @param prescripcion
	 *            El valor del campo "prescripcion".
	 */
	public void setPrescripcion(PrescripcionMedicamento prescripcion) {
		this.prescripcion = prescripcion;
	}
	
	/**
	 * Obtiene el valor del campo "estadoMedPaciente".
	 *
	 * @return El valor del campo "estadoMedPaciente".
	 */
	@OneToOne(mappedBy = "suministroInmediato")
   public EstadoMedicacionPaciente getEstadoMedPaciente() {
		return estadoMedPaciente;
	}
	/**
	 * Establece el valor del campo "estadoMedPaciente".
	 *
	 * @param estadoMedPaciente
	 *            El valor del campo "estadoMedPaciente".
	 */
	public void setEstadoMedPaciente(EstadoMedicacionPaciente estadoMedPaciente) {
		this.estadoMedPaciente = estadoMedPaciente;
	}
	/**
	 * Obtiene el valor del campo "cantidadAnterior".
	 *
	 * @return El valor del campo "cantidadAnterior".
	 */
	@Column
	public Float getCantidadAnterior() {
		return cantidadAnterior;
	}
	/**
	 * Establece el valor del campo "cantidadAnterior".
	 *
	 * @param cantidadAnterior
	 *            El valor del campo "cantidadAnterior".
	 */
	public void setCantidadAnterior(Float cantidadAnterior) {
		this.cantidadAnterior = cantidadAnterior;
	}

	/**
	 * Obtiene el valor del campo "cantidad".
	 *
	 * @return El valor del campo "cantidad".
	 */
	@Column
	public Float getCantidad() {
		return cantidad;
	}
	/**
	 * Establece el valor del campo "cantidad".
	 *
	 * @param cantidad
	 *            El valor del campo "cantidad".
	 */
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Obtiene el valor del campo "suministrado".
	 *
	 * @return El valor del campo "suministrado".
	 */
	@Column
	public boolean isSuministrado() {
		return suministrado;
	}
	/**
	 * Establece el valor del campo "suministrado".
	 *
	 * @param suministrado
	 *            El valor del campo "suministrado".
	 */
	public void setSuministrado(boolean suministrado) {
		this.suministrado = suministrado;
	}

	/**
	 * Obtiene el valor del campo "fechaPrevAdministracion".
	 *
	 * @return El valor del campo "fechaPrevAdministracion".
	 */
	@Column
	public Date getFechaPrevAdministracion() {
		return fechaPrevAdministracion;
	}
	/**
	 * Establece el valor del campo "fechaPrevAdministracion".
	 *
	 * @param fechaPrevAdministracion
	 *            El valor del campo "fechaPrevAdministracion".
	 */
	public void setFechaPrevAdministracion(Date fechaPrevAdministracion) {
		this.fechaPrevAdministracion = fechaPrevAdministracion;
	}
	/**
     * Obtiene el valor del campo "fechaCaducidad".
     * @return the fechaCaducidad
     */
	@Column(name = "FECHACADUCIDAD")
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

    /**
     * Establece el valor del campo "fechaCaducidad".
     * @param fechaCaducidad the fechaCaducidad to set
     */
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * Obtiene el valor del campo "numTomas".
	 *
	 * @return El valor del campo "numTomas".
	 */
	@Column
	public Integer getNumTomas() {
		return numTomas;
	}
	/**
	 * Establece el valor del campo "numTomas".
	 *
	 * @param numTomas
	 *            El valor del campo "numTomas".
	 */
	public void setNumTomas(Integer numTomas) {
		this.numTomas = numTomas;
	}
	/**
	 * Obtiene el valor del campo "administracionesPaciente".
	 *
	 * @return El valor del campo "administracionesPaciente".
	 */
	@OneToMany(mappedBy = "suministroInmediato", fetch = FetchType.LAZY)
   @Fetch(FetchMode.SUBSELECT)
    @OrderBy("fechaHoraPrevistaAdmin asc, orden asc")
	public Set < AdministracionPrescripcion > getAdministracionesPaciente() {
		return administracionesPaciente;
	}
	/**
	 * Establece el valor del campo "administracionesPaciente".
	 *
	 * @param administracionesPaciente
	 *            El valor del campo "administracionesPaciente".
	 */
  public void setAdministracionesPaciente(Set < AdministracionPrescripcion > administracionesPaciente) {
		this.administracionesPaciente = administracionesPaciente;
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
