package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Detalle de producto de una determinada marca para un paciente en un carro.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MARCA_MEDICACION_PACIENTE")
@SequenceGenerator(name = "SEQ_MARCA_MED_PAC",
		sequenceName = "SEQ_MARCA_MED_PAC", allocationSize = 1)
public class ProductoSeleccionado implements Serializable {

	/**
	 * Constructor.
	 *
	 */
	public ProductoSeleccionado() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * codMedicamento Long.
	 */
	private Long codMedicamento;
	/**
	 * codMedicamentoCentro String.
	 */
	private String codMedicamentoCentro;
	/**
	 * descMedicamento String.
	 */
	private String descMedicamento;
	/**
	 * descPresentacion String.
	 */
	private String descPresentacion;
	/**
	 * cantidad Float.
	 */
	private Float cantidad;
	/**
	 * Cantidad de medicamento por unidad de producto.
	 * fuerza Float.
	 */
	private Float fuerza;
	/**
	 * Unidades de la fuerza.
	 * unidadesFuerza String.
	 */
	private String unidadesFuerza;
	/**
	 * Unidades de la cantidad.
	 * unidades String.
	 */
	private String unidades;
	/**
	 * lote String.
	 */
	private String numLote;
	/**
	 * codAlmacen String.
	 */
	private String codAlmacen;
	/**
	 * fechaCaducidad Date.
	 */
	private Date fechaCaducidad;
	/**
	 * estadoMedicacionPaciente EstadoMedicacionPaciente.
	 */
	private EstadoMedicacionPaciente estadoMedicacionPaciente;
	/**
	 * compuesto CompuestoMultimedicamento.
	 */
	private CompuestoMultimedicamento compuesto;
	/**
	 * carroUnidosisDetalleMarca CarroUnidosisDetalleMarca.
	 */
	private CarroUnidosisDetalleMarca carroUnidosisDetalleMarca;
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODMARCAMEDPAC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MARCA_MED_PAC")
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
	 * Obtiene el valor del campo "codMedicamentoCentro".
	 *
	 * @return El valor del campo "codMedicamentoCentro".
	 */
	@Column
	public String getCodMedicamentoCentro() {
		return codMedicamentoCentro;
	}

	/**
	 * Establece el valor del campo "codMedicamentoCentro".
	 *
	 * @param codMedicamentoCentro
	 *            El valor del campo "codMedicamentoCentro".
	 */
	public void setCodMedicamentoCentro(String codMedicamentoCentro) {
		this.codMedicamentoCentro = codMedicamentoCentro;
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
	public void setDescPresentacion(String descPresentacion) {
		this.descPresentacion = descPresentacion;
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
	 * Obtiene el valor del campo "fuerza".
	 *
	 * @return El valor del campo "fuerza".
	 */
	@Column
	public Float getFuerza() {
		return fuerza;
	}
	/**
	 * Establece el valor del campo "fuerza".
	 *
	 * @param fuerza
	 *            El valor del campo "fuerza".
	 */
	public void setFuerza(Float fuerza) {
		this.fuerza = fuerza;
	}
	
	/**
	 * Obtiene el valor del campo "unidadesFuerza".
	 *
	 * @return El valor del campo "unidadesFuerza".
	 */
	@Column
	public String getUnidadesFuerza() {
		return unidadesFuerza;
	}
	/**
	 * Establece el valor del campo "unidadesFuerza".
	 *
	 * @param unidadesFuerza
	 *            El valor del campo "unidadesFuerza".
	 */
	public void setUnidadesFuerza(String unidadesFuerza) {
		this.unidadesFuerza = unidadesFuerza;
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
	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}
	
	

	
	/**
	 * Obtiene el valor del campo "numLote".
	 *
	 * @return El valor del campo "numLote".
	 */
	@Column(name="NLOTE")
	public String getNumLote() {
		return numLote;
	}
	/**
	 * Establece el valor del campo "numLote".
	 *
	 * @param numLote
	 *            El valor del campo "numLote".
	 */
	public void setNumLote(String numLote) {
		this.numLote = numLote;
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
	 * Obtiene el valor del campo "estadoMedicacionPaciente".
	 *
	 * @return El valor del campo "estadoMedicacionPaciente".
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODESTADOMEDPAC")
	public EstadoMedicacionPaciente getEstadoMedicacionPaciente() {
		return estadoMedicacionPaciente;
	}
	/**
	 * Establece el valor del campo "estadoMedicacionPaciente".
	 *
	 * @param estadoMedicacionPaciente
	 *            El valor del campo "estadoMedicacionPaciente".
	 */
	public void setEstadoMedicacionPaciente(EstadoMedicacionPaciente estadoMedicacionPaciente) {
		this.estadoMedicacionPaciente = estadoMedicacionPaciente;
	}
	
	/**
	 * Obtiene el valor del campo "compuesto".
	 *
	 * @return El valor del campo "compuesto".
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "CODCOMPUESTOMULTI")
	public CompuestoMultimedicamento getCompuesto() {
		return compuesto;
	}
	/**
	 * Establece el valor del campo "compuesto".
	 *
	 * @param compuesto
	 *            El valor del campo "compuesto".
	 */
	public void setCompuesto(CompuestoMultimedicamento compuesto) {
		this.compuesto = compuesto;
	}
	/**
	 * Obtiene el valor del campo "carroUnidosisDetalleMarca".
	 *
	 * @return El valor del campo "carroUnidosisDetalleMarca".
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODCARROUNIDETALLEMED")
	public CarroUnidosisDetalleMarca getCarroUnidosisDetalleMarca() {
		return carroUnidosisDetalleMarca;
	}
	/**
	 * Establece el valor del campo "carroUnidosisDetalleMarca".
	 *
	 * @param carroUnidosisDetalleMarca
	 *            El valor del campo "carroUnidosisDetalleMarca".
	 */
	public void setCarroUnidosisDetalleMarca(CarroUnidosisDetalleMarca carroUnidosisDetalleMarca) {
		this.carroUnidosisDetalleMarca = carroUnidosisDetalleMarca;
	}
	/**
	 * Id cadena unico para clave al almacenar en mapas.
	 * @return String
	 */
	@Transient
	public String getStringIdMap() {
		String ret = null;
		if (this.codMedicamento != null) {
			ret = this.getCodMedicamento().toString() + "_"
		+ this.getUnidades() + "_" + this.numLote;
		} else {
			ret = "_" + this.getUnidades() + "_"
		+ this.numLote;
		}
		return ret;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());		
		result = prime * result + ((codMedicamento == null) ? 0 : codMedicamento.hashCode());
		result = prime * result + ((descMedicamento == null) ? 0 : descMedicamento.hashCode());		
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numLote == null) ? 0 : numLote.hashCode());
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
		final ProductoSeleccionado other = (ProductoSeleccionado) obj;
		if (codMedicamento == null) {
			if (other.codMedicamento != null)
				return false;
		} else if (!codMedicamento.equals(other.codMedicamento))
			return false;		
		if (unidades == null) {
			if (other.unidades != null)
				return false;
		} else if (!unidades.equals(other.unidades))
			return false;
		return true;
	}
	/**
	 * Representación como cadena del objeto.
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">>>ProductoSeleccionado { id: " + id);
		sb.append(" codMedicamento: " + codMedicamento);
		sb.append(" descMedicamento: " + descMedicamento);
		sb.append(" cantidad: " + cantidad);
		sb.append(" unidades: " + unidades);
		sb.append(" lote: " + numLote);
		sb.append(" fecha caducidad: " + fechaCaducidad);
		if (carroUnidosisDetalleMarca == null) {
			sb.append(" carroUnidosisDetalleMarca: null");
		} else {
			sb.append(" codCarroUnidosisDetalleMarca: " + carroUnidosisDetalleMarca.getId());
		}
		if (estadoMedicacionPaciente == null) {
			sb.append(" estadoMedicacionPaciente: null");
		} else {
			sb.append(" codEstadoMedicacionPaciente: " + estadoMedicacionPaciente.getId());
		}
		sb.append("}");
		return sb.toString();
	}
}
