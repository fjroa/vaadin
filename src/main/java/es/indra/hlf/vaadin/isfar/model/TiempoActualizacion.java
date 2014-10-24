package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase de dominio para la entidad TiempoActualizacion.
 */
@Entity
@Table(name = "TIEMPO_ACTUALIZACION")
@SequenceGenerator(name = "SEQ_TIEMPO_ACTUALIZACION", sequenceName = "SEQ_TIEMPO_ACTUALIZACION",
		allocationSize = 1)
public class TiempoActualizacion implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;

	/**
	 * Attribute id.
	 */
	private Integer id;

	/**
	 * Attribute descTiempoActualizacion.
	 */
	private String descTiempoActualizacion;

	/**
	 * Constructor por codigo.
	 * @param codTiempoActualizacion Integer
	 */
	public TiempoActualizacion(Integer codTiempoActualizacion) {
		super();
		this.id = codTiempoActualizacion;
	}

	/**
	 * Constructor vacio.
	 */
	public TiempoActualizacion() {
		super();
	}

	/**
     * Obtiene el valor del campo "codTiempoActualizacion".
     * @return the codTiempoActualizacion
     */
	@Basic
	@Id
	@Column(name = "CODTIEMPOACTUALIZACION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIEMPO_ACTUALIZACION")
	public Integer getId() {
		return id;
	}

	/**
     * Establece el valor del campo "codTiempoActualizacion".
     * @param codTiempoActualizacion the codTiempoActualizacion to set
     */
	public void setId(Integer codTiempoActualizacion) {
		this.id = codTiempoActualizacion;
	}

	/**
     * Obtiene el valor del campo "descTiempoActualizacion".
     * @return the descTiempoActualizacion
     */
	@Basic
	@Column(name = "DESCTIEMPOACTUALIZACION", length = 80)
	public String getDescTiempoActualizacion() {
		return descTiempoActualizacion;
	}

	/**
     * Establece el valor del campo "descTiempoActualizacion".
     * @param descTiempoActualizacion the descTiempoActualizacion to set
     */
	public void setDescTiempoActualizacion(String descTiempoActualizacion) {
		this.descTiempoActualizacion = descTiempoActualizacion;
	}
}
