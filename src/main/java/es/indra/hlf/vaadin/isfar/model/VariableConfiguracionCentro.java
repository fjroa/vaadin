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
@Table(name = "VARIABLE_CONFIGURACION_CENTRO")
@SequenceGenerator(name = "SEQ_VAR_CONF_CENTRO", sequenceName = "SEQ_VAR_CONF_CENTRO",
		allocationSize = 1)
public class VariableConfiguracionCentro extends EntidadBase implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;
	
	/**
	 * Variable que determina la ventana temporal de modificación de una administración
	 *  desde que se modifica(administración/no administracion).
	 * VAR_CONF_ADMPRES String.
	 */
	public static final String VAR_CONF_ADMPRES = "ADMPRES";

	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * Attribute variableConfiguracion.
	 */
	private VariableConfiguracion variableConfiguracion;

	/**
	 * Attribute duracion.
	 */
	private Integer duracion;

	/**
	 * Attribute tiempoActualizacion.
	 */
	private TiempoActualizacion tiempoActualizacion;

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
	public VariableConfiguracionCentro(Integer codVariableConfiguracionCentro) {
		super();
		this.id = codVariableConfiguracionCentro;
	}

	/**
	 * Constructor vacio.
	 */
	public VariableConfiguracionCentro() {
		super();
	}

	/**
     * Obtiene el valor del campo "codVariableConfiguracionCentro".
     * @return the codVariableConfiguracionCentro
     */
	@Basic
	@Id
	@Column(name = "CODVARIABLECONFIGURACIONCENTRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VAR_CONF_CENTRO")
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
     * Obtiene el valor del campo "duracion".
     * @return the duracion
     */
	@Column(name = "DURACION")
	public Integer getDuracion() {
		return duracion;
	}

	/**
     * Establece el valor del campo "duracion".
     * @param duracion the duracion to set
     */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	/**
     * Obtiene el valor del campo "tiempoActualizacion".
     * @return the tiempoActualizacion
     */
	@ManyToOne
	@JoinColumn(name = "CODTIEMPOACTUALIZACION")
	public TiempoActualizacion getTiempoActualizacion() {
		return tiempoActualizacion;
	}

	/**
     * Establece el valor del campo "tiempoActualizacion".
     * @param tiempoActualizacion the tiempoActualizacion to set
     */
	public void setTiempoActualizacion(TiempoActualizacion tiempoActualizacion) {
		this.tiempoActualizacion = tiempoActualizacion;
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
