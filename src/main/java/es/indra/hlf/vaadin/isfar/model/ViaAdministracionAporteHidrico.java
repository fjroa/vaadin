package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa una via de administracion que conlleva tener aporte hidrico.
 * @author tnevado
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "VIAS_ADMIN_APORTE_HIDRICO")
public class ViaAdministracionAporteHidrico implements Serializable {

	/**
	 * Constructor.
	 *
	 */
	public ViaAdministracionAporteHidrico() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * codVia Integer.
	 */
	private Integer codVia;
	/**
	 * descVia String.
	 */
	private String descVia;
	/**
	 * tipo char.
	 */
	private char tipo;
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Id
	@Column(name = "CODVIAADMINTIPOAPORTE")
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
	 * Obtiene el valor del campo "codVia".
	 *
	 * @return El valor del campo "codVia".
	 */
	@Column
	public Integer getCodVia() {
		return codVia;
	}
	/**
	 * Establece el valor del campo "codVia".
	 *
	 * @param codVia
	 *            El valor del campo "codVia".
	 */
	public void setCodVia(Integer codVia) {
		this.codVia = codVia;
	}
	/**
	 * Obtiene el valor del campo "descVia".
	 *
	 * @return El valor del campo "descVia".
	 */
	@Column
	public String getDescVia() {
		return descVia;
	}
	/**
	 * Establece el valor del campo "descVia".
	 *
	 * @param descVia
	 *            El valor del campo "descVia".
	 */
	public void setDescVia(String descVia) {
		this.descVia = descVia;
	}
	/**
	 * Obtiene el valor del campo "tipo".
	 *
	 * @return El valor del campo "tipo".
	 */
	@Column
	public char getTipo() {
		return tipo;
	}
	/**
	 * Establece el valor del campo "tipo".
	 *
	 * @param tipo
	 *            El valor del campo "tipo".
	 */
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}


}
