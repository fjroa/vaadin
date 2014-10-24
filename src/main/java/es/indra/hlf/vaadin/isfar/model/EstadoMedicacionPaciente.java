package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Estado de preparación de la medicación de un paciente en un carro.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ESTADO_MEDICACION_PACIENTE")
@SequenceGenerator(name = "SEQ_ESTADO_MED_PAC",
		sequenceName = "SEQ_ESTADO_MED_PAC", allocationSize = 1)
public class EstadoMedicacionPaciente implements Serializable {
	/**
	 * Estado que indica que se ha realizado una creación de una prescripción al paciente
	 *  despues de estar en estado ESTADO_PREPARADO.
	 * ESTADO_MODIFICADO int = 0.
	 */
	public static final  int ESTADO_MODIFICADO = 0;
	/**
	 * Estado que indica que la prescripción ha sido anulada despues de estar preparada su medicación en el carro.
	 * ESTADO_MOD_CANCELACION_PRESC int = 1.
	 */
	public static final  int ESTADO_MOD_CANCELACION_PRESC = 1;
	/**
	 * Estado que indica que los productos para la prescripción
	 *  estan pendientes de preparar.
	 * ESTADO_PENDIENTE int = 2.
	 */
	public static final int ESTADO_PENDIENTE = 2;
	/**
	 * Estado que indica que los productos para la prescripción
	 *  estan en progreso.
	 * ESTADO_EN_PROGRESO int = 3.
	 */
	public static final int ESTADO_EN_PROGRESO = 3;
	/**
	 * Estado que indica que los productos para la prescripción
	 *  estan preparados.
	 * ESTADO_PREPARADO int = 4.
	 */
	public static final int ESTADO_PREPARADO = 4;
	/**
	 * Constante para asignar al campo tipo cuando el elemento se ha generado
	 *  al generar un carro de manera normal.
	 * TIPO_MED_CARRO int = 0.
	 */
	public static final int TIPO_MED_CARRO = 0;
	/**
	 * Constante para asignar al campo tipo cuando el elemento se ha generado
	 *  para medicación al alta.
	 * TIPO_MED_AL_ALTA int = 1.
	 */
	public static final int TIPO_MED_AL_ALTA = 1;
	/**
	 * Constante para asignar al campo tipo cuando el elemento se ha generado
	 *  al producirse una modificación al estar el carro ya preparado.
	 * TIPO_MED_ACT_CARRO int = 1.
	 */
	public static final int TIPO_MED_ACT_CARRO = 2;
	/**
	 * Constante para asignar al campo tipo cuando el elemento se ha generado
	 *  para tomas inmediatas.
	 * TIPO_MED_SUM_INM int = 2.
	 */
	public static final int TIPO_MED_SUM_INM = 3;
	/**
	 * SEPARADOR String.
	 */
	private static final String SEPARADOR = ",";
	
	/**
	 * Constructor.
	 *
	 */
	public EstadoMedicacionPaciente() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * prescripcion PrescripcionMedicamento.
	 */
	private PrescripcionMedicamento prescripcion;
	/**
	 * paciente Paciente.
	 */
	private Paciente paciente;
	/**
	 * codMedicamento Long.
	 */
	private Long codMedicamento;
	/**
	 * tipo int.
	 */
	private int tipo;
	/**
	 * estado int.
	 */
	private int estado;
	/**
	 * Causa de modificación cuando el estado es ESTADO_MODIFICADO.
	 * causaModificacion String.
	 */
	private String causaModificacion;
	/**
	 * suministrado boolean.
	 */
	private boolean suministrado;
	/**
	 * Opcional, solo en medicación incluida en carro.
	 * carroUnidosis CarroUnidosis.
	 */
	private CarroUnidosis carroUnidosis;
	/**
	 * Opcional, solo en medicación fuera de carro.
	 * suministroInmediato SuministroInmediato.
	 */
	private SuministroInmediato suministroInmediato;
	
	 /**
     * detalleMarcaPaciente List<DetallePacienteCarroMarca>.
     */
    private Set<ProductoSeleccionado> productosSeleccionados = new HashSet<ProductoSeleccionado>();
    /**
     * fechaCreacion Date.
     */
    private Date fechaCreacion;
    /**
     * fechaCreacion Date.
     */
    private Date fechaSuministro;
    /**
     * hbmVersion long.
     */
    private long hbmVersion;
    /**
     * activo boolean.
     */
    private boolean activo;
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODESTADOMEDPAC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADO_MED_PAC")
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
	 * Obtiene el valor del campo "prescripcion".
	 *
	 * @return El valor del campo "prescripcion".
	 */
	@ManyToOne
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
	 * Obtiene el valor del campo "paciente".
	 *
	 * @return El valor del campo "paciente".
	 */
	@ManyToOne
    @JoinColumn(name = "CODPACIENTE")
	public Paciente getPaciente() {
		return paciente;
	}
	/**
	 * Establece el valor del campo "paciente".
	 *
	 * @param paciente
	 *            El valor del campo "paciente".
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	/**
	 * Obtiene el valor del campo "codMedicamento".
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
	 * @param codMedicamento
	 *            El valor del campo "codMedicamento".
	 */
	public void setCodMedicamento(Long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	
	/**
	 * Obtiene el valor del campo "tipo".
	 *
	 * @return El valor del campo "tipo".
	 */
	@Column
	public int getTipo() {
		return tipo;
	}
	/**
	 * Establece el valor del campo "tipo".
	 *
	 * @param tipo
	 *            El valor del campo "tipo".
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	/**
	 * Obtiene el valor del campo "estado".
	 *
	 * @return El valor del campo "estado".
	 */
	@Column
	public int getEstado() {
		return estado;
	}
	/**
	 * Establece el valor del campo "estado".
	 *
	 * @param estado
	 *            El valor del campo "estado".
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	/**
	 * Obtiene el valor del campo "causaModificacion".
	 *
	 * @return El valor del campo "causaModificacion".
	 */
	@Column
	public String getCausaModificacion() {
		return causaModificacion;
	}
	/**
	 * Establece el valor del campo "causaModificacion".
	 *
	 * @param causaModificacion
	 *            El valor del campo "causaModificacion".
	 */
	public void setCausaModificacion(String causaModificacion) {
		this.causaModificacion = causaModificacion;
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
	 * Obtiene el valor del campo "carroUnidosis".
	 *
	 * @return El valor del campo "carroUnidosis".
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODCARROUNIDOSIS")
	public CarroUnidosis getCarroUnidosis() {
		return carroUnidosis;
	}
	/**
	 * Establece el valor del campo "carroUnidosis".
	 *
	 * @param carroUnidosis
	 *            El valor del campo "carroUnidosis".
	 */
	public void setCarroUnidosis(CarroUnidosis carroUnidosis) {
		this.carroUnidosis = carroUnidosis;
	}
	
	
	/**
	 * Obtiene el valor del campo "suministroInmediato".
	 *
	 * @return El valor del campo "suministroInmediato".
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODADMININMEDIATAACTCARRO")
	public SuministroInmediato getSuministroInmediato() {
		return suministroInmediato;
	}
	/**
	 * Establece el valor del campo "suministroInmediato".
	 *
	 * @param suministroInmediato
	 *            El valor del campo "suministroInmediato".
	 */
	public void setSuministroInmediato(SuministroInmediato suministroInmediato) {
		this.suministroInmediato = suministroInmediato;
	}
	/**
	 * Obtiene el valor del campo "productosSeleccionados".
	 *
	 * @return El valor del campo "productosSeleccionados".
	 */
	@OneToMany(mappedBy = "estadoMedicacionPaciente")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.EVICT, CascadeType.DELETE_ORPHAN })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id asc")
	public Set<ProductoSeleccionado> getProductosSeleccionados() {
		return productosSeleccionados;
	}	
	/**
	 * Establece el valor del campo "productosSeleccionados".
	 *
	 * @param productosSeleccionados
	 *            El valor del campo "productosSeleccionados".
	 */
	public void setProductosSeleccionados(Set<ProductoSeleccionado> productosSeleccionados) {
		this.productosSeleccionados = productosSeleccionados;
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
	 * Obtiene el valor del campo "fechaSuministro".
	 *
	 * @return El valor del campo "fechaSuministro".
	 */
	public Date getFechaSuministro() {
		return fechaSuministro;
	}
	/**
	 * Establece el valor del campo "fechaSuministro".
	 *
	 * @param fechaSuministro
	 *            El valor del campo "fechaSuministro".
	 */
	public void setFechaSuministro(Date fechaSuministro) {
		this.fechaSuministro = fechaSuministro;
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
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addProductoSeleccionado(ProductoSeleccionado e) {
		if (e != null) {
			e.setEstadoMedicacionPaciente(this);
		}
		return productosSeleccionados.add(e);
	}
	
	/**
	 * 
	 * @see java.util.Set#clear()
	 */
	public void clearProductosSeleccionados() {
		if (productosSeleccionados != null && !productosSeleccionados.isEmpty()) {
			for (ProductoSeleccionado prod : productosSeleccionados) {
				prod.setCarroUnidosisDetalleMarca(null);
			}
			productosSeleccionados.clear();
		}
	}
	/**
	 * @param e ProductoSeleccionado
	 * @return boolean
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean removeProductoSeleccionado(ProductoSeleccionado e) {
		if (e != null) {
			e.setEstadoMedicacionPaciente(null);
		}
		return productosSeleccionados.remove(e);
	}
	
	/**
	 * Devuelve la cantidad de medicamento necesaria en función de la prescripción y las tomas a las que afecta.
	 * @param numTomas int.
	 * @return float
	 */
	public float obtenerCantidadFuerza(int numTomas) {
		float cantidadPrescrita = 0f;
		float fuerzaPrescrita = 0f;
		float cantidadFuerza = 0f;
		if (prescripcion != null) {			
			if (prescripcion.getCantidad() != null
				&& prescripcion.getCantidad().floatValue() > 0f) {
				cantidadPrescrita = this.prescripcion.getCantidad().floatValue();
			}
			if (prescripcion.getFuerza() != null
					&& prescripcion.getFuerza().floatValue() > 0f) {
				fuerzaPrescrita = this.prescripcion.getFuerza().floatValue();
			}
		}
		if (numTomas > 0) {
			cantidadFuerza = (cantidadPrescrita*fuerzaPrescrita)*numTomas;
		}
		return cantidadFuerza;
	}
	/**
	 * Representacion como cadena del objeto;
	 * @return String.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">>>EstadoMedicacionPaciente {id: " + id);		
		if (prescripcion != null) {
			sb.append(" codPrescripcionPre: " + prescripcion.getCodPrescripcionPRE());
			sb.append(" codMedicamento: " + prescripcion.getCodMedicamento());
			sb.append(" descMedicamento: " + prescripcion.getDescMedicamento());
		}
		sb.append(" codMedicamento: " + codMedicamento);
		sb.append(" estado: " + estado);
		if (carroUnidosis != null) {
			sb.append(" codCarroUnidosis: " + carroUnidosis.getId());
		}
		sb.append(" productosSeleccionados: " + productosSeleccionados);		
		sb.append(" hbmVersion: " + hbmVersion);
		sb.append(" paciente: " + paciente);
		sb.append("}");
		return sb.toString();
	}
	@Transient
	public String getStringIdMap() {
		return prescripcion.getCodPrescripcionPRE().toString();
	}
}
