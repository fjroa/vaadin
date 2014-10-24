package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 *	Clase de dominio que especifica el detalle de un medicamento en un carro.
 * @author tnevado
 */
@SuppressWarnings("serial")
@BatchSize(size=100)
@Entity
@Table(name = "CARRO_UNIDOSIS_DETALLE")
@SequenceGenerator(name = "SEQ_CARRO_UNI_DETALLE",
		sequenceName = "SEQ_CARRO_UNIDOSIS_DETALLE", allocationSize = 1)
public class CarroUnidosisDetalle implements Serializable, Comparable < CarroUnidosisDetalle > {

	/**
	 * Constructor.
	 *
	 */
	public CarroUnidosisDetalle() {
		super();
	}
	/**
	 * Codigo.
	 */
	private Integer id;
	/**
	 * Carro genenerado al que pertenece el detalle de medicamento.
	 */
	private CarroUnidosis carroUnidosis;
	/**
	 * Codigo del medicamento.
	 */
	private Long codMedicamento;
	/**
	 * Descripcion del medicamento.
	 */
	private String descMedicamento;
	/**
	 * Descripcion del medicamento, en un formato mas legible.
	 */
	private String descPresentacion;
	/**
	 * Numero de dosis del medicamento en el carro generado asociado.
	 */
	private Integer cantidad;
	/**
	 * Numero de dosis del medicamento devueltas.
	 */
	private Integer devoluciones;
	/**
	 * Codigo del a via de administracion del medicamento.
	 */
	private Integer codViaAdministracion;
	/**
	 * Descripcion de la via de administracion del medicamento.
	 */
	private String descViaAdministracion;
	/**
	 * Lista de Administraciones del medicamento a los pacientes.
	 */
    private Set < AdministracionPrescripcion >
		administracionesPaciente = new HashSet < AdministracionPrescripcion >();
    /**
	 * Historico de carga por paciente y medicamento.
	 */
    private SortedSet < HistoricoCargaPaciente > historicoCargaPacientes
    	= new TreeSet < HistoricoCargaPaciente >();
	/**
	 * Observaciones.
	 */
	private String observaciones;
	/**
	 * Indica si se suministra o no.
	 * 		Si no tenia stock suficiente, no se suministra --> false
	 * 		Por defecto, se suministra --> true
	 */
	private boolean suministrado;

	/**
	 * Tipo de unidad de medida del medicamento.
	 */
	private String unidades;

	/**
     * Codigo de fluido al que pertenece el multimedicamento.
     */
    private Integer codFluido;

    /**
	 *  Indica si es componente base.
	 */
	private boolean base;

	/**
	 * No de lote al que pertenece el medicamento.
	 */
	private String numLote;
	/**
	 * Fecha de caducidad.
	 */
	private Date fechaCaducidad;
	/**
	 * noUnidosis boolean.
	 */
	private boolean noUnidosis;
	/**
	 * Indica si el elemento esta activo.
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
	 * Obtiene el valor del campo "codCarroUnidosisDetalle".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "codCarroUnidosisDetalle".
	 */
	@Basic
	@Id
	@Column(name = "CODCARROUNIDOSISDETALLE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARRO_UNI_DETALLE")
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el valor del campo "codCarroUnidosisDetalle".
	 *
	 * @author tnevado
	 *
	 * @param codCarroUnidosisDetalle
	 *            El valor del campo "codCarroUnidosisDetalle".
	 */
	public void setId(final Integer codCarroUnidosisDetalle) {
		this.id = codCarroUnidosisDetalle;
	}

	/**
	 * Obtiene el valor del campo "carroUnidosis".
	 *
	 * @return El valor del campo "carroUnidosis".
	 */
	@ManyToOne
	@JoinColumn(name = "CODCARROUNIDOSIS")
	public CarroUnidosis getCarroUnidosis() {
		return carroUnidosis;
	}

	/**
	 * Establece el valor del campo "carroUnidosis".
	 *
	 * @param carUnidosis
	 *            El valor del campo "carroUnidosis".
	 */
	public void setCarroUnidosis(final CarroUnidosis carUnidosis) {
		this.carroUnidosis = carUnidosis;
	}

	/**
	 * Obtiene el valor del campo "codMedicamento".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "codMedicamento".
	 */
	@Column
	public Long getCodMedicamento() {
		return codMedicamento;
	}

	/**
	 * Establece el valor del campo "codMedicamento".
	 *
	 * @author tnevado
	 *
	 * @param codMed
	 *            El valor del campo "codMedicamento".
	 */
	public void setCodMedicamento(final Long codMed) {
		this.codMedicamento = codMed;
	}

	/**
	 * Obtiene el valor del campo "descMedicamento".
	 *
	 * @author tnevado
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
	 * @author tnevado
	 *
	 * @param descMed
	 *            El valor del campo "descMedicamento".
	 */
	public void setDescMedicamento(final String descMed) {
		this.descMedicamento = descMed;
	}

	/**
	 * Obtiene el valor del campo "descPresentacion".
	 *
	 * @return El valor del campo "descPresentacion".
	 */
	@Column
	public String getDescPresentacion() {
		return descPresentacion;
	}

	/**
	 * Establece el valor del campo "descPresentacion".
	 *
	 * @param dPresentacion
	 *            El valor del campo "descPresentacion".
	 */
	public void setDescPresentacion(final String dPresentacion) {
		this.descPresentacion = dPresentacion;
	}

	/**
	 * Obtiene el valor del campo "cantidad".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "cantidad".
	 */
	@Column
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Establece el valor del campo "cantidad".
	 *
	 * @author tnevado
	 *
	 * @param cant
	 *            El valor del campo "cantidad".
	 */
	public void setCantidad(final Integer cant) {
		this.cantidad = cant;
	}

	/**
	 * Obtiene el valor del campo "devoluciones".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "devoluciones".
	 */
	@Column
	public Integer getDevoluciones() {
		return devoluciones;
	}

	/**
	 * Establece el valor del campo "devoluciones".
	 *
	 * @author tnevado
	 *
	 * @param devol
	 *            El valor del campo "devoluciones".
	 */
	public void setDevoluciones(final Integer devol) {
		this.devoluciones = devol;
	}

	/**
	 * Obtiene el valor del campo "codViaAdministracion".
	 *
	 * @return El valor del campo "codViaAdministracion".
	 */
	@Column
	public Integer getCodViaAdministracion() {
		return codViaAdministracion;
	}

	/**
	 * Establece el valor del campo "codViaAdministracion".
	 *
	 * @param codViaAdmin
	 *            El valor del campo "codViaAdministracion".
	 */
	public void setCodViaAdministracion(final Integer codViaAdmin) {
		this.codViaAdministracion = codViaAdmin;
	}

	/**
	 * Obtiene el valor del campo "descViaAdministracion".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "descViaAdministracion".
	 */
	@Column
	public String getDescViaAdministracion() {
		return descViaAdministracion;
	}

	/**
	 * Establece el valor del campo "descViaAdministracion".
	 *
	 * @author tnevado
	 *
	 * @param descViaAdmin
	 *            El valor del campo "descViaAdministracion".
	 */
	public void setDescViaAdministracion(final String descViaAdmin) {
		this.descViaAdministracion = descViaAdmin;
	}

	/**
	 * Obtiene el valor del campo "administracionesPaciente".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "administracionesPaciente".
	 */
	@OneToMany(mappedBy = "carroUnidosisDetalle")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.EVICT })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("fechaHoraPrevistaAdmin asc, orden asc")
	public Set < AdministracionPrescripcion > getAdministracionesPaciente() {
		return administracionesPaciente;
	}

	/**
	 * Establece el valor del campo "administracionesPaciente".
	 *
	 * @author tnevado
	 *
	 * @param adminisPaciente
	 *            El valor del campo "administracionesPaciente".
	 */
  public void setAdministracionesPaciente(final Set < AdministracionPrescripcion > adminisPaciente) {
		this.administracionesPaciente = adminisPaciente;
	}

	/**
	 * Obtiene el valor del campo "historicoCargaPacientes".
	 *
	 * @return El valor del campo "historicoCargaPacientes".
	 */
	@OneToMany(mappedBy = "carroUnidosisDetalle")
    @Fetch(FetchMode.SUBSELECT)
    @Sort(type = SortType.NATURAL)
    @OrderBy("fechaHoraModificacion asc")
	public SortedSet < HistoricoCargaPaciente > getHistoricoCargaPacientes() {
		return historicoCargaPacientes;
	}

	/**
	 * Establece el valor del campo "historicoCargaPacientes".
	 *
	 * @param historicoCargaPacs
	 *            El valor del campo "historicoCargaPacientes".
	 */
  public void setHistoricoCargaPacientes(
		  final SortedSet < HistoricoCargaPaciente > historicoCargaPacs) {
		this.historicoCargaPacientes = historicoCargaPacs;
	}

	/**
	 * @param hcp HistoricoCargaPaciente
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addHistoricoCargaPaciente(final HistoricoCargaPaciente hcp) {
		hcp.setCarroUnidosisDetalle(this);
		return historicoCargaPacientes.add(hcp);
	}

	/**
	 * Obtiene el valor del campo "observaciones".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "observaciones".
	 */
	@Column
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Establece el valor del campo "observaciones".
	 *
	 * @author tnevado
	 *
	 * @param obs
	 *            El valor del campo "observaciones".
	 */
	public void setObservaciones(final String obs) {
		this.observaciones = obs;
	}

	/**
	 * Obtiene el valor del campo "suministrado".
	 * @author ardiego
	 * @return El valor del campo "suministrado".
	 */
	@Column
	public boolean isSuministrado() {
		return suministrado;
	}

	/**
	 * Establece el valor del campo "suministrado".
	 * @author ardiego
	 * @param suminis El valor del campo "suministrado".
	 */
	public void setSuministrado(final boolean suminis) {
		this.suministrado = suminis;
	}

	/**
	 * Anade la administracion de medicamento prescrito a la lista.
	 * @param o AdministracionPrescripcion
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addAmninistracionPresc(final AdministracionPrescripcion o) {
		o.setCarroUnidosisDetalle(this);
		return administracionesPaciente.add((AdministracionPrescripcion)o);
	}

	/**
	 * Anade la administracion de medicamento prescrito a la lista.
	 * @param o AdministracionPrescripcion
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean removeAmninistracionPresc(final AdministracionPrescripcion o) {
		o.setCarroUnidosisDetalle(null);
		return administracionesPaciente.remove((AdministracionPrescripcion) o);
	}

	/**
	 * Ordenacion.
	 * @param o CarroUnidosisDetalle
	 * @return int
	 */
	public int compareTo(final CarroUnidosisDetalle o) {
		int resultado = 0;
		if (o == null || o.getCodMedicamento() == null) {
			if (this.getCodMedicamento() == null) {
				resultado = 0;
			} else {
				resultado = +1;
			}

		} else {
			if (this.getCodMedicamento() == null) {
				resultado = -1;
			} else {
				resultado = this.getCodMedicamento().compareTo(o.getCodMedicamento());
			}

		}
		if (resultado == 0) {
			if (o == null || o.getCodFluido() == null) {
				if (this.getCodFluido() == null) {
					resultado = 0;
				} else {
					resultado = +1;
				}

			} else {
				if (this.getCodFluido() == null) {
					resultado = -1;
				} else {
					resultado = this.getCodFluido().compareTo(o.getCodFluido());
				}

			}
		}
		if (resultado == 0) {
			if (o == null || o.getUnidades() == null) {
				if (this.unidades == null) {
					resultado = 0;
				} else {
					resultado = 1;
				}
			} else {
				if (this.unidades == null) {
					resultado = -1;
				} else {
					resultado = this.getUnidades().compareTo(o.getUnidades());
				}
			}
		}
		return resultado;
	}

	/**
	 * Obtiene el valor del campo "unidades".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "unidades".
	 */
	@Column
	public String getUnidades() {
		return unidades;
	}

	/**
	 * Establece el valor del campo "unidades".
	 *
	 * @author cgromero
	 *
	 * @param uds
	 *            El valor del campo "unidades".
	 */
	public void setUnidades(final String uds) {
		this.unidades = uds;
	}

	/**
	 * Obtiene el valor del campo "codFluido".
	 * @return codFluido
	 */
	@Column
	public Integer getCodFluido() {
		return codFluido;
	}

	/**
	 * Establece el valor del campo "codFluido".
	 * @param cFluido Integer the codFluido to set
	 */
	public void setCodFluido(final Integer cFluido) {
		this.codFluido = cFluido;
	}

	/**
	 * Obtiene el valor del campo "base".
	 * @return base
	 */
	@Column
	public boolean isBase() {
		return base;
	}

	/**
	 * Establece el valor del campo "base".
	 * @param bas Boolean the base to set
	 */
	public void setBase(final boolean bas) {
		this.base = bas;
	}

	/**
	 * Obtiene el valor del campo "numLote".
	 * @return the numLote
	 */
	@Column (name = "NLOTE")
	public String getNumLote() {
		return numLote;
	}
	/**
	 * Establece el valor del campo "numLote".
	 * @param lote the numLote to set
	 */
	public void setNumLote(final String lote) {
		this.numLote = lote;
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
     * @param fechaCad the fechaCaducidad to set
     */
	public void setFechaCaducidad(final Date fechaCad) {
		this.fechaCaducidad = fechaCad;
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
	 * @param noUnidose
	 *            El valor del campo "noUnidosis".
	 */
	public void setNoUnidosis(final boolean noUnidose) {
		this.noUnidosis = noUnidose;
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
	 * @param active
	 *            El valor del campo "activo".
	 */
	public void setActivo(final boolean active) {
		this.activo = active;
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
	 * @param hbmVers
	 *            El valor del campo "hbmVersion".
	 */
	public void setHbmVersion(final long hbmVers) {
		this.hbmVersion = hbmVers;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">>>CarroUnidosisDetalle {");
		sb.append(" id: " + this.id);
		sb.append(" codMedicamento: " + this.codMedicamento);
		sb.append(" codFluido: " + this.codFluido);
		sb.append(" descMedicamento: " + this.descMedicamento);
		sb.append(" descPresentacion: " + this.descPresentacion);
		sb.append(" cantidad: " + this.cantidad);
		sb.append(" devoluciones: " + this.devoluciones);
		sb.append(" unidades: " + this.unidades);
		sb.append(" codViaAdministracion: " + this.codViaAdministracion);
		sb.append(" descViaAdministracion: " + this.descViaAdministracion);
		sb.append(" observaciones: " + this.observaciones);
		sb.append(" base: " + this.base);
		sb.append(" suministrado: " + this.suministrado);
		sb.append(" numLote: " + this.numLote);
		sb.append(" fechaCaducidad: " + this.fechaCaducidad);
		sb.append(" noUnidosis: " + this.noUnidosis);
		sb.append(" activo: " + this.activo);
		if (administracionesPaciente != null && !administracionesPaciente.isEmpty()) {
			sb.append(" administracionesPaciente: [");
			for (AdministracionPrescripcion adm : administracionesPaciente) {
				sb.append("\t" + adm.toString() + "\n");
			}
			sb.append("]");
		} else {
			sb.append(" administracionesPaciente: []");
		}
		return sb.toString();
	}
	
	

}
