package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Dominio de PautaUnidadEnfermeria
 * @author indra
 */
@Entity
@Table(name = "PAUTA_UNIDAD_ENFERMERIA")
@SequenceGenerator(name = "SEQ_PAUTA_UNIDAD_ENFERMERIA", sequenceName = "SEQ_PAUTA_UNIDAD_ENFERMERIA", allocationSize = 1)
public class PautaUnidadEnfermeria extends EntidadBase implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 4272953493636372708L;
	
	/**
	 * Constructor.
	 *
	 */
	public PautaUnidadEnfermeria() {
		super();
	}

	/**
	 * Identificador de persistencia
	 */
	private Integer id;
	
	/**
	 * Codigo del centro.
	 */
	private String codCentro;
	
	/**
	 * Descripcion del centro.
	 */
	private String descCentro;
	
	/**
	 * Codigo de la Unidad de Enfermeria.
	 */
	private String codUE;
	
	/**
	 * Descripcion de la Unidad de Enfermeria.
	 */
	private String descUE;
	
	/**
	 * Lista de pautas de la unidad de enfermeria.
	 */
	private List < PautaAdministracion > pautas; 

	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODPAUTAUE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAUTA_UNIDAD_ENFERMERIA")
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
	 * Obtiene el valor del campo "codCentro".
	 *
	 * @return El valor del campo "codCentro".
	 */
	public String getCodCentro() {
		return codCentro;
	}
	
	/**
	 * Establece el valor del campo "codCentro".
	 *
	 * @param codCentro
	 *            El valor del campo "codCentro".
	 */
	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
	}
	
	/**
	 * Obtiene el valor del campo "descCentro".
	 *
	 * @return El valor del campo "descCentro".
	 */
	public String getDescCentro() {
		return descCentro;
	}
	
	/**
	 * Establece el valor del campo "descCentro".
	 *
	 * @param descCentro
	 *            El valor del campo "descCentro".
	 */
	public void setDescCentro(String descCentro) {
		this.descCentro = descCentro;
	}
	
	/**
	 * Obtiene el valor del campo "codUE".
	 * @return the codUE
	 */
	public String getCodUE() {
		return codUE;
	}
	
	/**
	 * Establece el valor del campo "codUE".
	 * @param codUE the codUE to set
	 */
	public void setCodUE(String codUE) {
		this.codUE = codUE;
	}
	
	/**
	 * Obtiene el valor del campo "descUE".
	 * @return the descUE
	 */
	public String getDescUE() {
		return descUE;
	}
	
	/**
	 * Establece el valor del campo "descUE".
	 * @param descUE the descUE to set
	 */
	public void setDescUE(String descUE) {
		this.descUE = descUE;
	}
	
	/**
	 * Obtiene el valor del campo "pautas".
	 * @return the pautas
	 */
	@OneToMany(mappedBy = "unidadEnfermeria", fetch=FetchType.LAZY)
	public List<PautaAdministracion> getPautas() {
		return pautas;
	}
	
	/**
	 * Establece el valor del campo "pautas".
	 * @param pautas the pautas to set
	 */
	public void setPautas(List<PautaAdministracion> pautas) {
		this.pautas = pautas;
	}
	
	/**
	 * ToString
	 * @return
	 */
	@Override
	public String toString() {
		return "PautaUnidadEnfermeria [id=" + id
				+ ", codCentro=" + codCentro + ", descCentro=" + descCentro
				+ ", codUE=" + codUE + ", descUE=" + descUE
				+ ", pautas=" + pautas.toString() + "]";
	}
}
