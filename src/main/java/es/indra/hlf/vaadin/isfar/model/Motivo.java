package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase de dominio para la entidad Motivo.
 * @author INDRA
 */
@Entity
@Table(name = "MOTIVO")
@SequenceGenerator(name = "SEQ_MOTIVO", sequenceName = "SEQ_MOTIVO", allocationSize = 1)
public class Motivo implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;

	/**
	 * Attribute id.
	 */

	private Integer id;

	/**
	 * Attribute descMotivo.
	 */
	private String descMotivo;

	/**
	 * Attribute tipo.
	 */
	private Integer tipo;

	/**
	 * Attribute activo.
	 */
	private boolean activo;

	/**
	 *  codigo del centro del motivo.
	 */
	private String codCentro;

	/**
	 *  descripcion del centro del motivo.
	 */
	private String descCentro;

	/**
	 * Constructor.
	 * @param codMotivo Integer
	 */
	public Motivo(Integer codMotivo) {
		super();
		this.id = codMotivo;
	}

	/**
	 * Constructor por defecto.
	 */
	public Motivo() {
		super();
	}

	/** Getter.
	 * @return idMotivo
	 */
	@Basic
	@Id
	@Column(name = "CODMOTIVO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MOTIVO")
	public Integer getId() {
		return id;
	}


	/** Setter.
	 * @param codMotivo the codMotivo to set
	 */
	public void setId(Integer codMotivo) {
		this.id = codMotivo;
	}

	/** Getter.
	 * @return descMotivo
	 */
	@Basic
	@Column(name = "DESCMOTIVO", length = 80)
	public String getDescMotivo() {
		return descMotivo;
	}

	/** Setter.
	 * @param descMotivo the descMotivo to set
	 */
	public void setDescMotivo(String descMotivo) {
		this.descMotivo = descMotivo;
	}

	/** Getter.
	 * @return tipo
	 */
	@Basic
	@Column(name = "TIPO", length = 1)
	public Integer getTipo() {
		return tipo;
	}

	/** Setter.
	 * @param tipo new value for tipoMotivo
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}



	/**
	 * Obtiene el valor del campo "activo".
	 *
	 * @return El valor del campo "activo".
	 */
	@Column
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Establece el valor del campo "activo".
	 *
	 * @param activo
	 *            El valor del campo "activo".
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**  Getter.
	 * @return codCentro
	 */
	@Basic
	@Column(name = "CODCENTRO", length = 25)
	public String getCodCentro() {
		return codCentro;
	}

	/** Setter.
	 * @param codCentro String
	 */
	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
	}

	/** Getter.
	 * @return descCentro
	 */
	@Basic
	@Column(name = "DESCCENTRO", length = 255)
	public String getDescCentro() {
		return descCentro;
	}

	/** Setter.
	 * @param descCentro String
	 */
	public void setDescCentro(String descCentro) {
		this.descCentro = descCentro;
	}

	/** Getter.
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
