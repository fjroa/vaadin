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
 * Clase de dominio para la entidad VariableConfiguracion.
 */
@Entity
@Table(name = "VARIABLE_CONFIGURACION")
@SequenceGenerator(name = "SEQ_VARIABLE_CONFIGURACION", sequenceName = "SEQ_VARIABLE_CONFIGURACION",
		allocationSize = 1)
public class VariableConfiguracion implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;

	/**
	 * Attribute id.
	 */
	private Integer id;

	/**
	 * Attribute idVariableConfiguracion.
	 */
	private String idVariableConfiguracion;

	/**
	 * Attribute descVariableConfiguracion.
	 */
	private String descVariableConfiguracion;

	/**
	 * Constructor por codigo.
	 * @param codVariableConfiguracion Integer
	 */
	public VariableConfiguracion(Integer codVariableConfiguracion) {
		super();
		this.id = codVariableConfiguracion;
	}

	/**
	 * Constructor vacio.
	 */
	public VariableConfiguracion() {
		super();
	}

	/**
     * Obtiene el valor del campo "codVariableConfiguracion".
     * @return the codVariableConfiguracion
     */
	@Basic
	@Id
	@Column(name = "CODVARIABLECONFIGURACION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VARIABLE_CONFIGURACION")
	public Integer getId() {
		return id;
	}

	/**
     * Establece el valor del campo "codVariableConfiguracion".
     * @param codVariableConfiguracion the codVariableConfiguracion to set
     */
	public void setId(Integer codVariableConfiguracion) {
		this.id = codVariableConfiguracion;
	}

	/**
     * Obtiene el valor del campo "idVariableConfiguracion".
     * @return the idVariableConfiguracion
     */
	@Basic
	@Column(name = "IDVARIABLECONFIGURACION", length = 50)
	public String getIdVariableConfiguracion() {
		return idVariableConfiguracion;
	}

	/**
     * Establece el valor del campo "idVariableConfiguracion".
     * @param idVariableConfiguracion the idVariableConfiguracion to set
     */
	public void setIdVariableConfiguracion(String idVariableConfiguracion) {
		this.idVariableConfiguracion = idVariableConfiguracion;
	}

	/**
     * Obtiene el valor del campo "descVariableConfiguracion".
     * @return the descVariableConfiguracion
     */
	@Basic
	@Column(name = "DESCVARIABLECONFIGURACION", length = 255)
	public String getDescVariableConfiguracion() {
		return descVariableConfiguracion;
	}

	/**
     * Establece el valor del campo "descVariableConfiguracion".
     * @param descVariableConfiguracion the descVariableConfiguracion to set
     */
	public void setDescVariableConfiguracion(String descVariableConfiguracion) {
		this.descVariableConfiguracion = descVariableConfiguracion;
	}
}
