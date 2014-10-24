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
 * Clase de dominio para la entidad Estado.
 * @author INDRA
  */
@Entity 
@Table(name = "ESTADO") 
@SequenceGenerator(name = "SEQ_ESTADO", sequenceName = "SEQ_ESTADO", allocationSize = 1)
public class Estado implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;

	/** Estado Pendiente de Preparar para Administraciones en Centro. */
	public static final int ESTADO_ADM_PENDIENTE_PREP = 1;
	/** Estado Preparada para Administraciones en Centro. */
	public static final int ESTADO_ADM_PREPARADA = 2;
	/** Estado Suministrada/Dispensada para Administraciones en Centro. */
	public static final int ESTADO_ADM_SUMINISTRADA_DISPENSADA = 3;
	/** Estado Administrada para Administraciones en Centro. */
	public static final int ESTADO_ADM_ADMINISTRADA = 4;
	/** Estado Devuelta para Administraciones en Centro. */
	public static final int ESTADO_ADM_DEVUELTA = 5;
	/** Estado Devolucion confirmada para Administraciones en Centro. */
	public static final int ESTADO_ADM_DEVOLUCION_CONFIRMADA = 6;
	/** Estado No Administrada para Administraciones en Centro. */
	public static final int ESTADO_ADM_NO_ADMINISTRADA = 11;
	/** Estado Pendiente de Preparar para Dispensaciones. */
	public static final int ESTADO_DISP_PENDIENTE_PREP = 7;
	/** Estado Preparada para Dispensaciones. */
	public static final int ESTADO_DISP_PREPARADA = 8;
	/** Estado Suministrada/Dispensada para Dispensaciones. */
	public static final int ESTADO_SUMINISTRADA_DISPENSADA = 9;
	/** Estado Cancelada para Dispensaciones. */
	public static final int ESTADO_CANCELADA = 10;

	/**
	 * Attribute id.
	 */

	private Integer id;

	/**
	 * Attribute descEstado.
	 */
	private String descEstado;

	/**
	 * Attribute tipo.
	 */
	private Integer tipo;

	/**
	 * Attribute seleccionable.
	 */
	private boolean seleccionable;


	/**
	 * Constructor.
	 * @param codEstado Estado
	 */
	public Estado(Integer codEstado) {
		super();
		this.id = codEstado;
	}

	/**
	 * Constructor por defecto.
	 */
	public Estado() {
		super();
	}

	/** Getter.
	 * @return idEstado
	 */
	@Basic
	@Id
	@Column(name = "CODESTADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADO")
	public Integer getId() {
		return id;
	}


	/** Setter.
	 * @param codEstado the codEstado to set
	 */
	public void setId(Integer codEstado) {
		this.id = codEstado;
	}

	/** Getter.
	 * @return descEstado
	 */
	@Basic
	@Column(name = "DESCESTADO", length = 80)
	public String getDescEstado() {
		return descEstado;
	}

	/** Setter.
	 * @param descEstado the descEstado to set
	 */
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
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
	 * @param tipo new value for tipoEstado
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}



	/**
	 * Obtiene el valor del campo "seleccionable".
	 *
	 * @return El valor del campo "seleccionable".
	 */
	@Column
	public boolean isSeleccionable() {
		return seleccionable;
	}

	/**
	 * Establece el valor del campo "seleccionable".
	 *
	 * @param seleccionable
	 *            El valor del campo "seleccionable".
	 */
	public void setSeleccionable(boolean seleccionable) {
		this.seleccionable = seleccionable;
	}

	/** Getter.
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
