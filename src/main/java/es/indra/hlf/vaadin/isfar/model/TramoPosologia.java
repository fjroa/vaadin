/**
 *  22/10/2013
 */
package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Representa un tramo de posología dentro de una prescripción con posología variable.
 */
@Entity
@Table(name = "TRAMO_POSOLOGIA")
@SequenceGenerator(name = "SEQ_TRAMO_POSOLOGIA", sequenceName = "SEQ_TRAMO_POSOLOGIA", allocationSize = 1)
public class TramoPosologia implements Serializable, Comparable<TramoPosologia> {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * prescripcionMedicamento PrescripcionMedicamento.
	 */
	private PrescripcionMedicamento prescripcionMedicamento;
	/**
	 * fechaInicio Date.
	 */
	private Date fechaInicio;
	/**
	 * fechaFin Date.
	 */
	private Date fechaFin;
	/**
	 * tipoUnidadDuracion int.
	 */
	private int tipoUnidadDuracion; 
	/**
	 * Duracion de la administracion del medicamento
	 *  (en las unidades especificadas en tipoUnidadDuracion).
	 */
	private Integer duracion;
	/**
	 * frecuenciaDescanso Integer.
	 */
	private Integer frecuenciaDescanso;
	/**
	 * duracionDescanso Integer.
	 */
	private Integer duracionDescanso;
	/**
	 * lineasPosologia List&lt;LineaPosologia&gt;.
	 */
	private List<LineaPosologia> lineasPosologia = new ArrayList<LineaPosologia>();
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODTRAMOPOSOLOGIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRAMO_POSOLOGIA")
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
	 * Obtiene el valor del campo "prescripcionMedicamento".
	 *
	 * @return El valor del campo "prescripcionMedicamento".
	 */
	@ManyToOne
	@JoinColumn(name = "CODPRESCRIPCIONMEDICAMENTO")
	public PrescripcionMedicamento getPrescripcionMedicamento() {
		return prescripcionMedicamento;
	}
	/**
	 * Establece el valor del campo "prescripcionMedicamento".
	 *
	 * @param prescripcionMedicamento
	 *            El valor del campo "prescripcionMedicamento".
	 */
	public void setPrescripcionMedicamento(PrescripcionMedicamento prescripcionMedicamento) {
		this.prescripcionMedicamento = prescripcionMedicamento;
	}
	/**
	 * Obtiene el valor del campo "fechaInicio".
	 *
	 * @return El valor del campo "fechaInicio".
	 */
	@Column
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * Establece el valor del campo "fechaInicio".
	 *
	 * @param fechaInicio
	 *            El valor del campo "fechaInicio".
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * Obtiene el valor del campo "fechaFin".
	 *
	 * @return El valor del campo "fechaFin".
	 */
	@Column
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * Establece el valor del campo "fechaFin".
	 *
	 * @param fechaFin
	 *            El valor del campo "fechaFin".
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Obtiene el valor del campo "tipoUnidadDuracion".
	 *
	 * @return El valor del campo "tipoUnidadDuracion".
	 */
	@Column
	public int getTipoUnidadDuracion() {
		return tipoUnidadDuracion;
	}
	/**
	 * Establece el valor del campo "tipoUnidadDuracion".
	 *
	 * @param tipoUnidadDuracion
	 *            El valor del campo "tipoUnidadDuracion".
	 */
	public void setTipoUnidadDuracion(int tipoUnidadDuracion) {
		this.tipoUnidadDuracion = tipoUnidadDuracion;
	}
	/**
	 * Obtiene el valor del campo "duracion".
	 *
	 * @return El valor del campo "duracion".
	 */
	@Column
	public Integer getDuracion() {
		return duracion;
	}
	/**
	 * Establece el valor del campo "duracion".
	 *
	 * @param duracion
	 *            El valor del campo "duracion".
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	/**
	 * Obtiene el valor del campo "frecuenciaDescanso".
	 *
	 * @return El valor del campo "frecuenciaDescanso".
	 */
	@Column
	public Integer getFrecuenciaDescanso() {
		return frecuenciaDescanso;
	}
	/**
	 * Establece el valor del campo "frecuenciaDescanso".
	 *
	 * @param frecuenciaDescanso
	 *            El valor del campo "frecuenciaDescanso".
	 */
	public void setFrecuenciaDescanso(Integer frecuenciaDescanso) {
		this.frecuenciaDescanso = frecuenciaDescanso;
	}
	/**
	 * Obtiene el valor del campo "duracionDescanso".
	 *
	 * @return El valor del campo "duracionDescanso".
	 */
	@Column
	public Integer getDuracionDescanso() {
		return duracionDescanso;
	}
	/**
	 * Establece el valor del campo "duracionDescanso".
	 *
	 * @param duracionDescanso
	 *            El valor del campo "duracionDescanso".
	 */
	public void setDuracionDescanso(Integer duracionDescanso) {
		this.duracionDescanso = duracionDescanso;
	}
	/**
	 * Obtiene el valor del campo "lineasPosologia".
	 *
	 * @return El valor del campo "lineasPosologia".
	 */
	@OneToMany(mappedBy = "tramoPosologia")
  @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST, CascadeType.EVICT, CascadeType.MERGE})
  @Fetch(FetchMode.SUBSELECT)
	public List<LineaPosologia> getLineasPosologia() {
		return lineasPosologia;
	}
	/**
	 * Establece el valor del campo "lineasPosologia".
	 *
	 * @param lineasPosologia
	 *            El valor del campo "lineasPosologia".
	 */
	public void setLineasPosologia(List<LineaPosologia> lineasPosologia) {
		this.lineasPosologia = lineasPosologia;
	}
	/**
	 * @param linea LineaPosologia.
	 * @return boolean
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addLineaPosologia(final LineaPosologia linea) {
		if (linea != null) {
			linea.setTramoPosologia(this);
		}
		return lineasPosologia.add(linea);
	}
	/**
	 * @param linea LineaPosologia.
	 * @return boolean
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean removeLineaPosologia(final LineaPosologia linea) {
		if (linea != null) {
			linea.setTramoPosologia(null);
		}
		return lineasPosologia.remove(linea);
	}
	
	/**
	 * Comparación de tramos de posologia.
	 * @param arg0 TramoPosologia
	 * @return int
	 */
	public int compareTo(final TramoPosologia arg0) {
		int ret = 0;
		if (arg0 == null) {
			ret = 1;
		} else if (this.getFechaInicio() != null && arg0.getFechaInicio() != null){
			ret = this.getFechaInicio().compareTo(arg0.getFechaInicio());
		} else {
			if (this.getId() != null && arg0.getId() != null) {
				ret = this.getId().compareTo(arg0.getId());
			}
		}
		return ret;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "TramoPosologia [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", frecuenciaDescanso="
				+ frecuenciaDescanso + ", duracionDescanso=" + duracionDescanso + ", lineasPosologia="
				+ lineasPosologia + "]";
	}
	
	/**
	 * Indica el numero máximode tomas por día en base a la posología cuando no es posología variable.
	 * devuelve -1 cuando la prescripción tiene posología variable.
	 * @return int
	 */
	public int maxTomasPorDia() {
		int ret = 0;
		if (getLineasPosologia() != null
			&& !getLineasPosologia().isEmpty()) {
			int iAux = 0;
			for (LineaPosologia linea : getLineasPosologia()) {
				iAux = linea.maxTomasPorDia();
				if (iAux > 0) {
					ret += iAux;
				}
			}
		}		
		return ret;
	}
	/**
	 *
	 * @return
	 */
	public boolean esPosVarFrecuenciaMesesDias() {
		boolean ret = false;
		if (getLineasPosologia() != null
			&& !getLineasPosologia().isEmpty()) {
			for (LineaPosologia lineaAux : getLineasPosologia()) {
				if (lineaAux.esPosVarFrecuenciaMesesDias()) {
					ret = true;
					break;
				}
			}
		}
		return ret;
	}
}
