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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import es.indra.hlf.vaadin.isfar.vo.DiaDeLaSemana;
import es.indra.hlf.vaadin.isfar.vo.DosisAdminVO;

/**
 * Representa una linea de posologia dentro de un tramo de posologia.
 */
@Entity
@Table(name = "LINEA_POSOLOGIA")
@SequenceGenerator(name = "SEQ_LINEA_POSOLOGIA", sequenceName = "SEQ_LINEA_POSOLOGIA", allocationSize = 1)
public class LineaPosologia implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * tramoPosologia TramoPosologia.
	 */
	private TramoPosologia tramoPosologia;
	/**
	 * cantidad float.
	 */
	private float cantidad;
	/**
	 * diaSemana DiaDeLaSemana.
	 */
	private DiaDeLaSemana diaSemana;
	/**
	 * hora Date.
	 */
	private Date hora;
	/**
	 * pauta PautaAdministracion.
	 */
	private PautaAdministracion pauta;
	/**
	 * frecuencia float.
	 */
	private Float frecuencia;
	/**
	 * Indica en que unidades esta especificada la frecuencia
	 * tipoUnidadFrecuencia int.
	 */
	private int tipoUnidadFrecuencia;
	/**
	 * Codigo de la posologia en Prescripciones.
	 */
	private Integer codPosologiaPRE;
	/**
	 * codUnidades Integer.
	 */
	private Integer codUnidades;
	/**
	 * unidades String.
	 */
	private String unidades;
	/**
	 * fuerza float.
	 */
	private float fuerza;
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODLINEAPOSOLOGIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LINEA_POSOLOGIA")
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
	 * Obtiene el valor del campo "tramoPosologia".
	 *
	 * @return El valor del campo "tramoPosologia".
	 */
	@ManyToOne
	@JoinColumn(name = "CODTRAMOPOSOLOGIA")
	public TramoPosologia getTramoPosologia() {
		return tramoPosologia;
	}
	/**
	 * Establece el valor del campo "tramoPosologia".
	 *
	 * @param tramoPosologia
	 *            El valor del campo "tramoPosologia".
	 */
	public void setTramoPosologia(TramoPosologia tramoPosologia) {
		this.tramoPosologia = tramoPosologia;
	}
	
	/**
	 * Obtiene el valor del campo "diaSemana".
	 *
	 * @return El valor del campo "diaSemana".
	 */
	@Column
	@Enumerated(EnumType.ORDINAL)
	public DiaDeLaSemana getDiaSemana() {
		return diaSemana;
	}
	/**
	 * Establece el valor del campo "diaSemana".
	 *
	 * @param diaDeLaSemana
	 *            El valor del campo "diaSemana".
	 */
	public void setDiaSemana(DiaDeLaSemana diaDeLaSemana) {
		this.diaSemana = diaDeLaSemana;
	}
	/**
	 * Obtiene el valor del campo "hora".
	 *
	 * @return El valor del campo "hora".
	 */
	@Column
	public Date getHora() {
		return hora;
	}
	/**
	 * Establece el valor del campo "hora".
	 *
	 * @param hora
	 *            El valor del campo "hora".
	 */
	public void setHora(Date hora) {
		this.hora = hora;
	}
	/**
	 * Obtiene el valor del campo "cantidad".
	 *
	 * @return El valor del campo "cantidad".
	 */
	@Column
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
	 * Obtiene el valor del campo "pauta".
	 *
	 * @return El valor del campo "pauta".
	 */
	@ManyToOne
	@JoinColumn(name = "CODPAUTA")
	public PautaAdministracion getPauta() {
		return pauta;
	}
	/**
	 * Establece el valor del campo "pauta".
	 *
	 * @param pauta
	 *            El valor del campo "pauta".
	 */
	public void setPauta(PautaAdministracion pauta) {
		this.pauta = pauta;
	}
	/**
	 * Obtiene el valor del campo "frecuencia".
	 *
	 * @return El valor del campo "frecuencia".
	 */
	@Column
	public Float getFrecuencia() {
		return frecuencia;
	}
	/**
	 * Establece el valor del campo "frecuencia".
	 *
	 * @param frecuencia
	 *            El valor del campo "frecuencia".
	 */
	public void setFrecuencia(Float frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	/**
	 * Obtiene el valor del campo "tipoUnidadFrecuencia".
	 *
	 * @return El valor del campo "tipoUnidadFrecuencia".
	 */
	@Column
	public int getTipoUnidadFrecuencia() {
		return tipoUnidadFrecuencia;
	}
	/**
	 * Establece el valor del campo "tipoUnidadFrecuencia".
	 *
	 * @param tipoUnidadFrecuencia
	 *            El valor del campo "tipoUnidadFrecuencia".
	 */
	public void setTipoUnidadFrecuencia(int tipoUnidadFrecuencia) {
		this.tipoUnidadFrecuencia = tipoUnidadFrecuencia;
	}
	/**
	 * Obtiene el valor del campo "codPosologiaPRE".
	 *
	 * @return El valor del campo "codPosologiaPRE".
	 */
	@Column
	public Integer getCodPosologiaPRE() {
		return codPosologiaPRE;
	}
	/**
	 * Establece el valor del campo "codPosologiaPRE".
	 *
	 * @param codPosologiaPRE
	 *            El valor del campo "codPosologiaPRE".
	 */
	public void setCodPosologiaPRE(Integer codPosologiaPRE) {
		this.codPosologiaPRE = codPosologiaPRE;
	}
	
	@Transient
	public List<DiaDeLaSemana> getDiasDeLaSemana() {
		 List<DiaDeLaSemana> ret = null;
		 ret = new ArrayList<DiaDeLaSemana>();
		 if (getDiaSemana() != null) {
			 ret.add(getDiaSemana());
		 }		 
		return ret;
	}
	/**
	 * Obtiene el valor del campo "codUnidades".
	 *
	 * @return El valor del campo "codUnidades".
	 */
	@Column
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
	@Column
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
	 * Obtiene el valor del campo "fuerza".
	 *
	 * @return El valor del campo "fuerza".
	 */
	@Column
	public float getFuerza() {
		return fuerza;
	}
	/**
	 * Establece el valor del campo "fuerza".
	 *
	 * @param fuerza
	 *            El valor del campo "fuerza".
	 */
	public void setFuerza(float fuerza) {
		this.fuerza = fuerza;
	}
	
	/**
	 * Devuelve el codigo del dia de la semana como un entero en vez de como un enum.
	 * @return
	 */
	@Transient
	public int getCodDiaSemana() {
		int ret = 0;
		if (getDiaSemana() != null) {
			ret = getDiaSemana().getCodigo();
		}
		return ret;
	}
	/**
	 * Comprueba si la linea contiene el dia de la semana suministrado.
	 * @param diaDeLaSemana DiaDeLaSemana
	 * @return boolean
	 */
	public boolean incluyeDia(DiaDeLaSemana diaDeLaSemana) {
		boolean ret = false;
		List<DiaDeLaSemana> diasSemana = getDiasDeLaSemana();
		if (diasSemana == null || diasSemana.isEmpty()) {
			ret = true;
		} else {
			if (diaDeLaSemana != null) {				
				for (DiaDeLaSemana diaSemana : diasSemana) {
					if (diaSemana.getCodigo() == diaDeLaSemana.getCodigo()) {
						ret = true;
						break;
					}
				}
			}
		}		
		return ret;
	}
	/**
	 * Indica si se puede emplear la unidad contenedora, empleable hay posología variable.
	 * Debe tener unidadContenedora != unidades y especificado el campo fuerza.
	 * @return boolean
	 */
	public boolean usarUnidadContenedora(final Integer codUnidadContenedora) {
		boolean ret = false;
		if (getFuerza() > 0f && codUnidadContenedora != null
						&& getCodUnidades() != null
						&& getCodUnidades().intValue() != codUnidadContenedora) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Obtiene la cantidad de medicamento de una prescripción en unidad contenedora
	 *  si se dan las condiciones, si no en unidad prescrita.
	 * @param codUnidadContenedora Integer.
	 * @param descUnidadContenedora String.
	 * @return DosisAdminVO
	 */
	public DosisAdminVO obtenerDosisAdministracion(
			final Integer codUnidadContenedora, final String descUnidadContenedora) {
		DosisAdminVO dosis = null;
		float cantidad = 0;
		if (usarUnidadContenedora(codUnidadContenedora)) {
			//Si las uidades prescritas y las contenedoras no coinciden se emplea
			//la fuerza para obtener la equivalencia en unidad contenedora
			cantidad = getCantidad()
					/ getFuerza();
			dosis = new DosisAdminVO(
					cantidad, codUnidadContenedora
					, descUnidadContenedora);
		} else {
			cantidad = getCantidad();
			dosis = new DosisAdminVO(
					cantidad, getCodUnidades()
					, getUnidades());
		}
		return dosis;
	}
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "LineaPosologia [id=" + id + ", cantidad=" + cantidad + ", codUnidades="
				+ codUnidades + ", unidades=" + unidades
				+ ", diaSemana=" + diaSemana + ", hora=" + hora + ", pauta=" + pauta + ", frecuencia="
				+ frecuencia + ", codPosologiaPRE=" + codPosologiaPRE
				+ ", fuerza=" + fuerza + "]";
	}
	/**
	 * Indica el numero máximode tomas por día en base a la posología cuando no es posología variable.
	 * devuelve -1 cuando la prescripción tiene posología variable.
	 * @return int
	 */
	public int maxTomasPorDia() {
		int ret = 0;
		if (getPauta() != null
				&& getPauta().isActivo()) {
			if (!(getPauta().obtenerHorasPauta()).isEmpty()) {
				ret = getPauta().obtenerHorasPauta().size();
			}
		} else if (getHora() != null){
			ret = 1;
		} else {
			//generación por frecuencia.
			if (getTipoUnidadFrecuencia() == PrescripcionMedicamento.UNIDAD_FREC_HORAS) {
				ret = new Double(Math.ceil(PrescripcionMedicamento.HORAS_POR_DIA/getFrecuencia().floatValue())).intValue();					
			} else if (getTipoUnidadFrecuencia() == PrescripcionMedicamento.UNIDAD_FREC_MINUTOS) {
				ret = new Double(Math.ceil(PrescripcionMedicamento.MINUTOS_POR_DIA/getFrecuencia().floatValue())).intValue();
			} else if (getTipoUnidadFrecuencia() == PrescripcionMedicamento.UNIDAD_FREC_SEGUNDOS) {
				ret = new Double(Math.ceil(PrescripcionMedicamento.SEGUNDOS_POR_DIA/getFrecuencia().floatValue())).intValue();
			} else if (getTipoUnidadFrecuencia() == PrescripcionMedicamento.UNIDAD_FREC_MESES) {
				//Frecuencia en meses el máximo de tomas en un dia es 1.
				ret = 1;
			} else if (getTipoUnidadFrecuencia() == PrescripcionMedicamento.UNIDAD_FREC_DIAS) {
				//Frecuencia en meses el máximo de tomas en un dia es 1.
				ret = 1;
			}
		}		
		return ret;
	}
	
	/**
	 *  Indica si la frecuencia esta establecida en horas.
	 * @return boolean
	 */
	public boolean esFrecuenciaHoras() {
		boolean ret = false;
		if (getTipoUnidadFrecuencia()
				== PrescripcionMedicamento.UNIDAD_FREC_HORAS
			&& getFrecuencia() != null && getFrecuencia() > 0F) {
			ret = true;
		}
		return ret;
	}
	
	/**
	 *  Indica si la frecuencia esta establecida en meses.
	 * @return boolean
	 */
	public boolean esFrecuenciaMeses() {
		boolean ret = false;
		if (getTipoUnidadFrecuencia()
				== PrescripcionMedicamento.UNIDAD_FREC_MESES) {
			ret = true;
		}
		return ret;
	}

	/**
	 *
	 * @return
	 */
	public boolean esFrecuenciaDias() {
		boolean ret = false;
		if (getTipoUnidadFrecuencia()
				== PrescripcionMedicamento.UNIDAD_FREC_DIAS) {
			ret = true;
		}
		return ret;
	}

	public boolean esFrecuenciaMinutos() {
		boolean ret = false;
		if (getTipoUnidadFrecuencia()
				== PrescripcionMedicamento.UNIDAD_FREC_MINUTOS) {
			ret = true;
		}
		return ret;
	}

	public boolean esFrecuenciaSegundos() {
		boolean ret = false;
		if (getTipoUnidadFrecuencia()
				== PrescripcionMedicamento.UNIDAD_FREC_SEGUNDOS) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Indica si tiene una frecuencia especificada en dias o meses.
	 * @return
	 */
	public boolean esPosVarFrecuenciaMesesDias() {
		boolean ret = false;
		if (esFrecuenciaDias()
				|| esFrecuenciaMeses()) {
			ret = true;
		}
		return ret;
	}
}
