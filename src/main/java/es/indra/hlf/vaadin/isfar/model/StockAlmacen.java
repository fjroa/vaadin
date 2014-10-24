package es.indra.hlf.vaadin.isfar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase de dominio de la tabla STOCK_ALMACEN.
 * @author cgromero
 */
@Entity
@Table(name = "STOCK_ALMACEN")
public class StockAlmacen {

	/**
	 * Constructor.
	 *
	 */
	public StockAlmacen() {
		super();
	}

	/**
	 * Codigo de medicamento.
	 */
	@Column
	@Id
	private Long codMedicamento;

	/**
	 * Descripcion de medicamento.
	 */
	@Column
	private String descMedicamento;

	/**
	 * Codigo de almacen.
	 */
	@Column
	private String codAlmacen;

	/**
	 * Descripcion de almacen.
	 */
	@Column
	private String descAlmacen;

	/**
	 * Unidades en stock.
	 */
	@Column
	private Integer cantidadStock;

	/**
	 * Fecha y hora ultima modificacion.
	 */
	@Column
	private Date fechaHoraUltimaModificacion;

	/**
	 * Obtiene el valor del campo "codMedicamento".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "codMedicamento".
	 */
	public Long getCodMedicamento() {
		return codMedicamento;
	}

	/**
	 * Establece el valor del campo "codMedicamento".
	 *
	 * @author cgromero
	 *
	 * @param codMedicamento
	 *            El valor del campo "codMedicamento".
	 */
	public void setCodMedicamento(Long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	/**
	 * Obtiene el valor del campo "descMedicamento".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "descMedicamento".
	 */
	public String getDescMedicamento() {
		return descMedicamento;
	}

	/**
	 * Establece el valor del campo "descMedicamento".
	 *
	 * @author cgromero
	 *
	 * @param descMedicamento
	 *            El valor del campo "descMedicamento".
	 */
	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
	}

	/**
	 * Obtiene el valor del campo "codAlmacen".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "codAlmacen".
	 */
	public String getCodAlmacen() {
		return codAlmacen;
	}

	/**
	 * Establece el valor del campo "codAlmacen".
	 *
	 * @author cgromero
	 *
	 * @param codAlmacen
	 *            El valor del campo "codAlmacen".
	 */
	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	/**
	 * Obtiene el valor del campo "descAlmacen".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "descAlmacen".
	 */
	public String getDescAlmacen() {
		return descAlmacen;
	}

	/**
	 * Establece el valor del campo "descAlmacen".
	 *
	 * @author cgromero
	 *
	 * @param descAlmacen
	 *            El valor del campo "descAlmacen".
	 */
	public void setDescAlmacen(String descAlmacen) {
		this.descAlmacen = descAlmacen;
	}



	/**
	 * Obtiene el valor del campo "fechaHoraUltimaModificacion".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "fechaHoraUltimaModificacion".
	 */
	public Date getFechaHoraUltimaModificacion() {
		return fechaHoraUltimaModificacion;
	}

	/**
	 * Establece el valor del campo "fechaHoraUltimaModificacion".
	 *
	 * @author cgromero
	 *
	 * @param fechaHoraUltimaModificacion
	 *            El valor del campo "fechaHoraUltimaModificacion".
	 */
	public void setFechaHoraUltimaModificacion(Date fechaHoraUltimaModificacion) {
		this.fechaHoraUltimaModificacion = fechaHoraUltimaModificacion;
	}

	/**
	 * Obtiene el valor del campo "cantidadStock".
	 *
	 * @author cgromero
	 *
	 * @return El valor del campo "cantidadStock".
	 */
	public Integer getCantidadStock() {
		return cantidadStock;
	}

	/**
	 * Establece el valor del campo "cantidadStock".
	 *
	 * @author cgromero
	 *
	 * @param cantidadStock
	 *            El valor del campo "cantidadStock".
	 */
	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

}
