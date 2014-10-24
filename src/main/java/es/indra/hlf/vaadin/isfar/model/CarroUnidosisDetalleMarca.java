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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Detalle de un medicamento de una marca comercial en un carro.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CARRO_UNI_DETALLE_MEDICAMENTO")
@SequenceGenerator(name = "SEQ_CARRO_UNI_DET_MED",
		sequenceName = "SEQ_CARRO_UNI_DET_MED", allocationSize = 1)
public class CarroUnidosisDetalleMarca implements Serializable {

	/**
	 * Constructor.
	 *
	 */
	public CarroUnidosisDetalleMarca() {
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
	 * noUnidosis boolean.
	 */
	private boolean noUnidosis;
	/**
	 * nLote String.
	 */
	private String nLote;
	/**
	 * codAlmacen String.
	 */
	private String codAlmacen;
	/**
	 * fechaCaducidad Date.
	 */
	private Date fechaCaducidad;
	/**
	 * Indica si el elemento esta activo.
	 * activo boolean.
	 */
	private boolean activo;
	/**
	 * hbmVersion long.
	 */
	private long hbmVersion;
//	/**
//     * Attribute codUsuarioAuditoria.
//     */
//    private String codUsuarioAuditoria; //NOPMD
    /**
     * detalleMarcaPaciente List<DetallePacienteCarroMarca>.
     */
    private Set<ProductoSeleccionado> productosSeleccionados = new HashSet<ProductoSeleccionado>();
//    /**
//	 * Observaciones.
//	 */
//	private String observaciones;
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODCARROUNIDETALLEMED")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARRO_UNI_DET_MED")
	public Integer getId() {
		return id;
	}
	/**
	 * Establece el valor del campo "id".
	 *
	 * @param id
	 *            El valor del campo "id".
	 */
	public void setId(final Integer id) {
		this.id = id;
	}
	/**
	 * Obtiene el valor del campo "carroUnidosis".
	 *
	 * @return El valor del campo "carroUnidosis".
	 */
	@ManyToOne(fetch = FetchType.LAZY)
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
	public void setCarroUnidosis(final CarroUnidosis carroUnidosis) {
		this.carroUnidosis = carroUnidosis;
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
	public void setCodMedicamento(final Long codMedicamento) {
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
	public void setDescMedicamento(final String descMedicamento) {
		this.descMedicamento = descMedicamento;
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
	 * @param descPresentacion
	 *            El valor del campo "descPresentacion".
	 */
	public void setDescPresentacion(final String descPresentacion) {
		this.descPresentacion = descPresentacion;
	}
	/**
	 * Obtiene el valor del campo "cantidad".
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
	 * @param cantidad
	 *            El valor del campo "cantidad".
	 */
	public void setCantidad(final Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Obtiene el valor del campo "devoluciones".
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
	 * @param devoluciones
	 *            El valor del campo "devoluciones".
	 */
	public void setDevoluciones(final Integer devoluciones) {
		this.devoluciones = devoluciones;
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
	 * @param codViaAdministracion
	 *            El valor del campo "codViaAdministracion".
	 */
	public void setCodViaAdministracion(final Integer codViaAdministracion) {
		this.codViaAdministracion = codViaAdministracion;
	}
	/**
	 * Obtiene el valor del campo "descViaAdministracion".
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
	 * @param descViaAdministracion
	 *            El valor del campo "descViaAdministracion".
	 */
	public void setDescViaAdministracion(final String descViaAdministracion) {
		this.descViaAdministracion = descViaAdministracion;
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
	public void setSuministrado(final boolean suministrado) {
		this.suministrado = suministrado;
	}
	/**
	 * Obtiene el valor del campo "unidades".
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
	 * @param unidades
	 *            El valor del campo "unidades".
	 */
	public void setUnidades(final String unidades) {
		this.unidades = unidades;
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
	 * @param noUnidosis
	 *            El valor del campo "noUnidosis".
	 */
	public void setNoUnidosis(final boolean noUnidosis) {
		this.noUnidosis = noUnidosis;
	}
	/**
	 * Obtiene el valor del campo "nLote".
	 *
	 * @return El valor del campo "nLote".
	 */
	 @Column
	public String getNLote() {
		return nLote;
	}
	/**
	 * Establece el valor del campo "nLote".
	 *
	 * @param lote
	 *            El valor del campo "nLote".
	 */
	public void setNLote(String lote) {
		nLote = lote;
	}
	/**
	 * Obtiene el valor del campo "codAlmacen".
	 *
	 * @return El valor del campo "codAlmacen".
	 */
	@Column
	public String getCodAlmacen() {
		return codAlmacen;
	}
	/**
	 * Establece el valor del campo "codAlmacen".
	 *
	 * @param codAlmacen
	 *            El valor del campo "codAlmacen".
	 */
	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}
	/**
	 * Obtiene el valor del campo "fechaCaducidad".
	 *
	 * @return El valor del campo "fechaCaducidad".
	 */
	 @Column
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	/**
	 * Establece el valor del campo "fechaCaducidad".
	 *
	 * @param fechaCaducidad
	 *            El valor del campo "fechaCaducidad".
	 */
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
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
	public void setActivo(final boolean activo) {
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
	public void setHbmVersion(final long hbmVersion) {
		this.hbmVersion = hbmVersion;
	}
//	/**
//	 * Obtiene el valor del campo "codUsuarioAuditoria".
//	 *
//	 * @return El valor del campo "codUsuarioAuditoria".
//	 */
//	@Column
//	public String getCodUsuarioAuditoria() {
//		return codUsuarioAuditoria;
//	}
//	/**
//	 * Establece el valor del campo "codUsuarioAuditoria".
//	 *
//	 * @param codUsuarioAuditoria
//	 *            El valor del campo "codUsuarioAuditoria".
//	 */
//	public void setCodUsuarioAuditoria(final String codUsuarioAuditoria) {
//		this.codUsuarioAuditoria = codUsuarioAuditoria;
//	}
	/**
	 * Obtiene el valor del campo "productosSeleccionados".
	 *
	 * @return El valor del campo "productosSeleccionados".
	 */
	@OneToMany(mappedBy = "carroUnidosisDetalleMarca")
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
	public void setProductosSeleccionados(final Set<ProductoSeleccionado> productosSeleccionados) {
		this.productosSeleccionados = productosSeleccionados;
	}
//	/**
//	 * Obtiene el valor del campo "observaciones".
//	 *
//	 * @return El valor del campo "observaciones".
//	 */
//	@Column
//	public String getObservaciones() {
//		return observaciones;
//	}
//	/**
//	 * Establece el valor del campo "observaciones".
//	 *
//	 * @param observaciones
//	 *            El valor del campo "observaciones".
//	 */
//	public void setObservaciones(final String observaciones) {
//		this.observaciones = observaciones;
//	}
	/**
	 * Id cadena unico para clave al almacenar en mapas.
	 * @return String
	 */
	@Transient
	public String getStringIdMap() {
		String ret = null;
		if (this.codMedicamento != null) {
			ret = this.getCodMedicamento().toString() + "_"
		+ this.getUnidades() + "_" + this.nLote;
		} else {
			ret = "_" + this.getUnidades() + "_"
		+ this.nLote;
		}
		return ret;
	}
	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addProductoSeleccionado(ProductoSeleccionado e) {
		if (e != null) {
			e.setCarroUnidosisDetalleMarca(this);
		}
		return productosSeleccionados.add(e);
	}
	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean removeProductoSeleccionado(ProductoSeleccionado o) {
		boolean ret = false;
		if (o != null){
			o.setCarroUnidosisDetalleMarca(null);
		}
		if (productosSeleccionados != null) {
			ret = productosSeleccionados.remove(o);
		}
		return ret;
	}
	/**
	 *
	 * @see java.util.List#clear()
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
	 *
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activo ? 1231 : 1237);
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((carroUnidosis == null) ? 0 : carroUnidosis.hashCode());
		result = prime * result + ((codMedicamento == null) ? 0 : codMedicamento.hashCode());
		result = prime * result + ((unidades == null) ? 0 : unidades.hashCode());
		return result;
	}
	/**
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final CarroUnidosisDetalleMarca other = (CarroUnidosisDetalleMarca) obj;
		if (carroUnidosis == null) {
			if (other.carroUnidosis != null)
				return false;
		} else if (!carroUnidosis.equals(other.carroUnidosis))
			return false;
		if (codMedicamento == null) {
			if (other.codMedicamento != null)
				return false;
		} else if (!codMedicamento.equals(other.codMedicamento))
			return false;		
		if (noUnidosis != other.noUnidosis)
			return false;		
		if (unidades == null) {
			if (other.unidades != null)
				return false;
		} else if (!unidades.equals(other.unidades))
			return false;
		return true;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">>> CarroUnidosisDetalleMarca {id: " + id);
		if (carroUnidosis != null) {
			sb.append("codCarroUnidosis: " + carroUnidosis.getId());
		}
		sb.append(" codMedicamento:" + codMedicamento);
		sb.append(" descMedicamento:" + descMedicamento);
		sb.append(" descPresentacion:" + descPresentacion);
		sb.append(" cantidad:" + cantidad);
		sb.append(" unidades:" + unidades);
		sb.append(" suministrado:" + suministrado);
		sb.append(" devoluciones:" + devoluciones);
		sb.append(" codViaAdministracion:" + codViaAdministracion);
		sb.append(" descViaAdministracion:" + descViaAdministracion);
		sb.append(" noUnidosis:" + noUnidosis);
		sb.append(" nLote:" + nLote);
		sb.append(" fechaCaducidad:" + fechaCaducidad);
		sb.append(" activo:" + activo);
		sb.append(" hbmVersion:" + hbmVersion);
		return sb.toString();
	}
}
