/**
 *  07/02/2014
 */
package es.indra.hlf.vaadin.isfar.vo;

import java.io.Serializable;

/**
 * Especificacion de una dosis administrada a un paciente.
 * Si se puede emplear unidadContenedora se emplea
 * , empleandose la unidad prescrita en caso contrario.
 */
public class DosisAdminVO implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 *
	 */
	public DosisAdminVO() {
		super();
	}
	/**
	 * Constructor.
	 *
	 * @param cantidad
	 * @param codUnidades
	 * @param unidades
	 */
	public DosisAdminVO(float cantidad, Integer codUnidades, String unidades) {
		super();
		this.cantidad = cantidad;
		this.codUnidades = codUnidades;
		this.unidades = unidades;
	}
	/**
	 * cantidad float.
	 */
	private float cantidad;
	/**
	 * codUnidades Integer.
	 */
	private Integer codUnidades;
	/**
	 * unidades String.
	 */
	private String unidades;
	/**
	 * Obtiene el valor del campo "cantidad".
	 *
	 * @return El valor del campo "cantidad".
	 */
	public float getCantidad() {
		return cantidad;
	}
	/**
	 * Establece el valor del campo "cantidad".
	 *
	 * @param cantidad
	 *            El valor del campo "cantidad".
	 */
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Obtiene el valor del campo "codUnidades".
	 *
	 * @return El valor del campo "codUnidades".
	 */
	public Integer getCodUnidades() {
		return codUnidades;
	}
	/**
	 * Establece el valor del campo "codUnidades".
	 *
	 * @param codUnidades
	 *            El valor del campo "codUnidades".
	 */
	public void setCodUnidades(Integer codUnidades) {
		this.codUnidades = codUnidades;
	}
	/**
	 * Obtiene el valor del campo "unidades".
	 *
	 * @return El valor del campo "unidades".
	 */
	public String getUnidades() {
		return unidades;
	}
	/**
	 * Establece el valor del campo "unidades".
	 *
	 * @param unidades
	 *            El valor del campo "unidades".
	 */
	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cantidad);
		result = prime * result + ((codUnidades == null) ? 0 : codUnidades.hashCode());
		result = prime * result + ((unidades == null) ? 0 : unidades.hashCode());
		return result;
	}
	/**
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DosisAdminVO other = (DosisAdminVO) obj;
		if (Float.floatToIntBits(cantidad) != Float.floatToIntBits(other.cantidad))
			return false;
		if (codUnidades == null) {
			if (other.codUnidades != null)
				return false;
		} else if (!codUnidades.equals(other.codUnidades))
			return false;
		if (unidades == null) {
			if (other.unidades != null)
				return false;
		} else if (!unidades.equals(other.unidades))
			return false;
		return true;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "DosisAdminVO [cantidad=" + cantidad + ", codUnidades=" + codUnidades + ", unidades="
				+ unidades + "]";
	}

	
}
