package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

/**
 * Información de la administración de un producto de una marca concreta en una determinada toma.
 * Una toma puede tener varios productos de marca diferente.
 */
@SuppressWarnings("serial")
@Entity
@BatchSize(size=500)
@Table(name = "ADMINISTRACION_PACIENTE_MARCA")
@SequenceGenerator(name = "SEQ_ADM_PAC_MARCA",
		sequenceName = "SEQ_ADM_PAC_MARCA", allocationSize = 1)
public class AdministracionPacienteMarca implements Serializable, Comparable<AdministracionPacienteMarca> {

	/**
	 * Constructor.
	 *
	 */
	public AdministracionPacienteMarca() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * detalleMarcaPacienteCarro DetalleMarcaPacienteCarro.
	 */
	private ProductoSeleccionado productoSeleccionado;
	/**
	 * administracionPrescripcion AdministracionPrescripcion.
	 */
	private AdministracionPrescripcion administracionPrescripcion;
	/**
	 * codMedicamento Long.
	 */
	private Long codMedicamento;
	/**
	 * codMedicamentoCentro String.
	 */
	private String codMedicamentoCentro;
	/**
	 * codCompuestoMulti Long.
	 */
	private Long codCompuestoMulti;
	/**
	 * descMedicamento String.
	 */
	private String descMedicamento;
	/**
	 * descPresentacion String.
	 */
	private String descPresentacion;
	/**
	 * cantidadPrescrita Float.
	 */
	private Float cantidad;
	/**
	 * unidades String.
	 */
	private transient String codUnidades;
	/**
	 * unidades String.
	 */
	private String unidades;
	/**
	 * nLote String.
	 */
	private String numLote;
	/**
	 * codAlmacen String.
	 */
	private String codAlmacen;
	/**
	 * fechaCaducidad Date.
	 */
	private Date caducidad;
	/**
	 * base String.
	 */
	private boolean base;
	/**
     * Fecha y Hora de la administracion.
     */
    private Date fechaHoraAdm;
//	/**
//	 * paciente Paciente.
//	 */
//	private Paciente paciente;
//	/**
//	 * codCentro String.
//	 */
//	private String codCentro;
//	/**
//	 * descCentro String.
//	 */
//	private String descCentro;
//	/**
//	 * codEpisodio String.
//	 */
//	private String codEpisodio;
//	/**
//	 * codViaAdministracion Integer.
//	 */
//	private Integer codViaAdministracion;
//	/**
//	 * descViaAdministracion String.
//	 */
//	private String descViaAdministracion;
	
	
	
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
    @Basic
	@Id
	@Column(name = "CODADMINISTRACIONPACIENTEMARCA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADM_PAC_MARCA")
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
	 * Obtiene el valor del campo "productoSeleccionado".
	 *
	 * @return El valor del campo "productoSeleccionado".
	 */
	@ManyToOne
    @JoinColumn(name = "CODMARCAMEDPAC")
	public ProductoSeleccionado getProductoSeleccionado() {
		return productoSeleccionado;
	}
	/**
	 * Establece el valor del campo "productoSeleccionado".
	 *
	 * @param productoSeleccionado
	 *            El valor del campo "productoSeleccionado".
	 */
	public void setProductoSeleccionado(ProductoSeleccionado productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}
	/**
	 * Obtiene el valor del campo "administracionPrescripcion".
	 *
	 * @return El valor del campo "administracionPrescripcion".
	 */
	@ManyToOne
    @JoinColumn(name = "CODADMINISTRACIONPRESCRIPCION")
	public AdministracionPrescripcion getAdministracionPrescripcion() {
		return administracionPrescripcion;
	}
	/**
	 * Establece el valor del campo "administracionPrescripcion".
	 *
	 * @param administracionPrescripcion
	 *            El valor del campo "administracionPrescripcion".
	 */
	public void setAdministracionPrescripcion(AdministracionPrescripcion administracionPrescripcion) {
		this.administracionPrescripcion = administracionPrescripcion;
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
	 * Obtiene el valor del campo "codUnidades".
	 *
	 * @return El valor del campo "codUnidades".
	 */
	@Column
	public String getCodUnidades() {
		return codUnidades;
	}
	/**
	 * Establece el valor del campo "codUnidades".
	 *
	 * @param codUnidades
	 *            El valor del campo "codUnidades".
	 */
	public void setCodUnidades(String codUnidades) {
		this.codUnidades = codUnidades;
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
	 * Obtiene el valor del campo "nLote".
	 *
	 * @return El valor del campo "nLote".
	 */
	@Column(name="NLOTE")
	public String getNumLote() {
		return numLote;
	}
	/**
	 * Establece el valor del campo "nLote".
	 *
	 * @param lote
	 *            El valor del campo "nLote".
	 */
	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}
	
	/**
	 * Obtiene el valor del campo "codAlmacen".
	 *
	 * @return El valor del campo "codAlmacen".
	 */
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
	@Column(name="FECHACADUCIDAD")
	public Date getCaducidad() {
		return caducidad;
	}
	/**
	 * Establece el valor del campo "fechaCaducidad".
	 *
	 * @param fechaCaducidad
	 *            El valor del campo "fechaCaducidad".
	 */
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
	/**
	 * Obtiene el valor del campo "base".
	 *
	 * @return El valor del campo "base".
	 */
	@Column
	public boolean isBase() {
		return base;
	}
	/**
	 * Establece el valor del campo "base".
	 *
	 * @param base
	 *            El valor del campo "base".
	 */
	public void setBase(boolean base) {
		this.base = base;
	}
	/**
	 * Obtiene el valor del campo "fechaHoraAdm".
	 *
	 * @return El valor del campo "fechaHoraAdm".
	 */
	@Column
	public Date getFechaHoraAdm() {
		return fechaHoraAdm;
	}
	/**
	 * Establece el valor del campo "fechaHoraAdm".
	 *
	 * @param fechaHoraAdm
	 *            El valor del campo "fechaHoraAdm".
	 */
	public void setFechaHoraAdm(Date fechaHoraAdm) {
		this.fechaHoraAdm = fechaHoraAdm;
	}
	/**
	 * Obtiene el valor del campo "codCompuestoMulti".
	 *
	 * @return El valor del campo "codCompuestoMulti".
	 */
	@Column
	public Long getCodCompuestoMulti() {
		return codCompuestoMulti;
	}
	/**
	 * Establece el valor del campo "codCompuestoMulti".
	 *
	 * @param codCompuestoMulti
	 *            El valor del campo "codCompuestoMulti".
	 */
	public void setCodCompuestoMulti(Long codCompuestoMulti) {
		this.codCompuestoMulti = codCompuestoMulti;
	}
	/**
	 *
	 * @param o
	 * @return
	 */
	public int compareTo(AdministracionPacienteMarca o) {
		int ret = 0;
		if (o == null) {
			ret = +1;
		} else {
			if (this.getId() == null) {
				if (o.getId() == null) {
					ret = 0;
				} else {
					ret = -1;
				}
			} else {
				if (o.getId() == null) {
					ret = +1;
				} else {
					ret = this.getId().compareTo(o.getId());
				}
			}
		}
		if (ret == 0) {
			if (this.getCodMedicamento() == null) {
				if (o.getCodMedicamento() == null) {
					ret = 0;
				} else {
					ret = -1;
				}
			} else {
				if (o.getCodMedicamento() == null) {
					ret = +1;
				} else {
					ret = this.getCodMedicamento().compareTo(o.getCodMedicamento());
				}
			}
		}
		return ret;
	}
	

}
