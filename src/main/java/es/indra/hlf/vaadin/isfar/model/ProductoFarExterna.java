/**
 *  29/10/2013
 */
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

/**
 * Productos selecionados en una preparacion de farmacia externa.
 */
@Entity
@Table(name = "PREPARACION_TOMA_MARCA")
public class ProductoFarExterna implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * preparacion PreparacionFarExterna.
	 */
	private PreparacionFarExterna preparacion;
	/**
	 * codMedicamento long.
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
	 * cantidad float.
	 */
	private Float cantidad;
	/**
	 * unidades String.
	 */
	private String unidades;
	/**
	 * codUnidades Integer.
	 */
	private Integer codUnidades;
	/**
	 * numLote String.
	 */
	private String numLote;
	/**
	 * fechaCaducidad Date.
	 */
	private Date fechaCaducidad;
	/**
	 * codAlmacen String.
	 */
	private String codAlmacen;
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_PREPARACION_TOMA_MARCA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Column(name = "CODPREPARACIONTOMAMARCA")
	public Integer getId() {
		return id;
	}
	/**
	 * Establece el valor del campo "id".
	 *
	 * @param ident
	 *            El valor del campo "id".
	 */
	public void setId(final Integer ident) {
		this.id = ident;
	}
	/**
	 * Obtiene el valor del campo "preparacion".
	 *
	 * @return El valor del campo "preparacion".
	 */
	@ManyToOne
    @JoinColumn(name = "CODPREPARACIONTOMA")
	public PreparacionFarExterna getPreparacion() {
		return preparacion;
	}
	/**
	 * Establece el valor del campo "preparacion".
	 *
	 * @param prep
	 *            El valor del campo "preparacion".
	 */
	public void setPreparacion(final PreparacionFarExterna prep) {
		this.preparacion = prep;
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
	 * @param codMedic
	 *            El valor del campo "codMedicamento".
	 */
	public void setCodMedicamento(final Long codMedic) {
		this.codMedicamento = codMedic;
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
	 * @param codMedicCentro
	 *            El valor del campo "codMedicamentoCentro".
	 */
	public void setCodMedicamentoCentro(final String codMedicCentro) {
		this.codMedicamentoCentro = codMedicCentro;
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
	 * @param descMedic
	 *            El valor del campo "descMedicamento".
	 */
	public void setDescMedicamento(final String descMedic) {
		this.descMedicamento = descMedic;
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
	 * @param cant
	 *            El valor del campo "cantidad".
	 */
	public void setCantidad(final Float cant) {
		this.cantidad = cant;
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
	 * @param unidad
	 *            El valor del campo "unidades".
	 */
	public void setUnidades(final String unidad) {
		this.unidades = unidad;
	}
	/**
	 * Obtiene el valor del campo "codUnidades".
	 *
	 * @return El valor del campo "codUnidades".
	 */
	@Column
	public Integer getCodUnidades() {
		return codUnidades;
	}
	/**
	 * Establece el valor del campo "codUnidades".
	 *
	 * @param codUnidad
	 *            El valor del campo "codUnidades".
	 */
	public void setCodUnidades(final Integer codUnidad) {
		this.codUnidades = codUnidad;
	}
	/**
	 * Obtiene el valor del campo "nLote".
	 *
	 * @return El valor del campo "nLote".
	 */
	@Column(name = "NLOTE")
	public String getNumLote() {
		return numLote;
	}
	/**
	 * Establece el valor del campo "nLote".
	 *
	 * @param nLote
	 *            El valor del campo "nLote".
	 */
	public void setNumLote(final String nLote) {
		this.numLote = nLote;
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
	 * @param fechaCad
	 *            El valor del campo "fechaCaducidad".
	 */
	public void setFechaCaducidad(final Date fechaCad) {
		this.fechaCaducidad = fechaCad;
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
	 * @param codAlm
	 *            El valor del campo "codAlmacen".
	 */
	public void setCodAlmacen(final String codAlm) {
		this.codAlmacen = codAlm;
	}
}
