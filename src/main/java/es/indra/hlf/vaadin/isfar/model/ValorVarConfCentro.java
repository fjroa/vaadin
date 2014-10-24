package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase de dominio para la entidad VariableConfiguracionCentro.
 */
@Entity
@Table(name = "VALOR_VAR_CONF_CENTRO")
@SequenceGenerator(name = "SEQ_VAR_CONFIGURACION_CENTRO", sequenceName = "SEQ_VAR_CONFIGURACION_CENTRO",
		allocationSize = 1)
public class ValorVarConfCentro extends EntidadBase implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;

	/**
	 * Indica si la lectura de productos por codigo de barras esta habilitada.
	 * VAR_CONF_BARCODE_ENABLED String.
	 */
	public static final String VAR_CONF_BARCODE_ENABLED = "INPUT_FROM_BARCODE_ENABLED";
	/**
	 * Indica si se bloquea la dispensación o no en caso de que no se tenga suficiente stock en el almacen..
	 * VAR_CONF_BLOCK_NO_STOCK String.
	 */
	public static final String VAR_CONF_BLOCK_NO_STOCK = "DISPENSATION_BLOCKED_WHEN_NO_STOCK";
	/**
	 * Indica si esta activa la integración con inventario.
	 * VAR_CONF_INT_INVENTARIO String.
	 */
	public static final String VAR_CONF_INT_INVENTARIO = "INT_INVENTARIO";
	/**
	 * Indica si a la hora de imprimir etiquetas de medicación se imprime lo prescrito
	 * , o lo seleccionado y lo prescrito en caso de no tener productos seleccionados.
	 * VAR_CONF_ETIQUETAS_MED_PRESCRITO String.
	 */
	public static final String VAR_CONF_ETIQUETAS_MED_PRESCRITO = "FILL_LABEL_WITH_PRESCRIPTIONS";
	/**
	 * id Integer.
	 */
	private Integer id;

	/**
	 * Attribute variableConfiguracion.
	 */
	private VariableConfiguracion variableConfiguracion;

	/**
	 * Attribute valor.
	 */
	private String valor;

	/**
	 *  codigo del centro de la variable de configuracion.
	 */
	private String codCentro;
	/**
	 *  descripcion de la variable de configuracion.
	 */
	private String descCentro;

	/**
	 * Constructor por codigo.
	 * @param codVariableConfiguracionCentro Integer
	 */
	public ValorVarConfCentro(Integer codValorVarConfCentro) {
		super();
		this.id = codValorVarConfCentro;
	}

	/**
	 * Constructor vacio.
	 */
	public ValorVarConfCentro() {
		super();
	}

	/**
     * Obtiene el valor del campo "codValorVarConfCentro".
     * @return the codValorVarConfCentro
     */
	@Basic
	@Id
	@Column(name = "CODVALORVARCONFCENTRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VAR_CONFIGURACION_CENTRO")
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
     * Obtiene el valor del campo "variableConfiguracion".
     * @return the variableConfiguracion
     */
	@ManyToOne
	@JoinColumn(name = "CODVARIABLECONFIGURACION")
	public VariableConfiguracion getVariableConfiguracion() {
		return variableConfiguracion;
	}

	/**
     * Establece el valor del campo "variableConfiguracion".
     * @param variableConfiguracion the variableConfiguracion to set
     */
	public void setVariableConfiguracion(VariableConfiguracion variableConfiguracion) {
		this.variableConfiguracion = variableConfiguracion;
	}

	/**
     * Obtiene el valor del campo "valor".
     * @return the valor
     */
	@Column(name = "VALOR")
	public String getValor() {
		return valor;
	}

	/**
     * Establece el valor del campo "valor".
     * @param valor the valor to set
     */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene el valor del campo "codCentro".
	 * @return El valor del campo "codCentro".
	 */
	@Basic
	@Column(name = "CODCENTRO", length = 25)
	public String getCodCentro() {
		return codCentro;
	}

	/**
	 * Establece el valor del campo "codCentro".
	 * @param codCentro
	 *            El valor del campo "codCentro".
	 */
	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
	}

	/**
	 * Obtiene el valor del campo "descCentro".
	 * @return El valor del campo "descCentro".
	 */
	@Basic
	@Column(name = "DESCCENTRO", length = 255)
	public String getDescCentro() {
		return descCentro;
	}

	/**
	 * Establece el valor del campo "descCentro".
	 * @param descCentro
	 *            El valor del campo "descCentro".
	 */
	public void setDescCentro(String descCentro) {
		this.descCentro = descCentro;
	}
}
