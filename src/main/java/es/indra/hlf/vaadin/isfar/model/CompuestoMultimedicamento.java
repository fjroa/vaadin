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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Producto que forma parte de un compuesto multimedicamento asociado a una prescripción.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "COMPUESTO_MULTIMEDICAMENTO")
@SequenceGenerator(name = "SEQ_COMPUESTO_MULTI",
		sequenceName = "SEQ_COMPUESTO_MULTI", allocationSize = 1)
public class CompuestoMultimedicamento implements Serializable, Comparable<CompuestoMultimedicamento> {

	/**
	 * Constructor.
	 */
	public CompuestoMultimedicamento() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;
	/**
	 * Prescripción de la que forma parte el producto en el compuesto
	 * prescripcion PrescripcionMedicamento.
	 */
	private PrescripcionMedicamento prescripcion;
	/**
	 * Código de medicamento
	 * codMedicamento Long.
	 */
	private Long codMedicamento;
	/**
	 * Código de medicamento específico del centro
	 * codMedicamentoCentro String.
	 */
	private String codMedicamentoCentro;
	/**
	 * Descripción del medicamento
	 * descMedicamento String.
	 */
	private String descMedicamento;
	/**
	 * Cantidad de unidades de producto.
	 * cantidad Float.
	 */
	private Float cantidad;
	/**
	 * Cantidad de medicamento por unidad de producto.
	 * fuerza Float.
	 */
	private Float fuerza;
	/**
	 * Unidades de la fuerza.
	 * unidadesFuerza String.
	 */
	private String unidadesFuerza;
	/**
	 * Unidades de la cantidad.
	 * unidades String.
	 */
	private String unidades;
	/**
	 * Volumen del producto
	 * volumen Float.
	 */
	private Float volumen;
	/**
	 * Indica si el producto es la base del compuesto
	 * base boolean.
	 */
	private boolean base;
	/**
	 * Url del prospecto de la prescripcion.
	 * urlProspecto String.
	 */
	private String urlProspecto;
	/**
	 * Código del principio activo del producto
	 */
	private String codPrincipioActivo;
    /**
     * Descripción del principio activo del producto
     */
	private String descPrincipioActivo;
	/**
	 * Descripción de la presentación del producto
	 */
    private String descPresentacion;
    /**
     * Indica si es posible la modificación de la dosis por el enfermero en la administración
     */
    private boolean dosisModificable;
    /**
     * Unidad en la que se entrega el producto al paciente
     */
    private String unidadContenedora;
    /**
     * Indica si el producto es presentación o marca
     */
    private boolean presentacion;
    /**
     * Código de las unidades de fuerza del producto
     */
    private Long codUnidadesFuerza; 
    /**
     * Código de la unidad contenedora usada para el producto
     */
    private Long codUnidadContenedora;
    /**
     * Código de las unidades del producto
     */
    private Long codUnidades;
    /**
	 * Codigo de la forma farmaceutica.
	 */
	private Long codFormaFarma;
	/**
	 * Descripcion de la forma farmaceutica
	 */
	private String descFormaFarma;
	/**
	 * Obtiene el valor del campo "id".
	 * @return El valor del campo "id".
	 */
	@Basic
	@Id
	@Column(name = "CODCOMPUESTOMULTI")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMPUESTO_MULTI")
	public Integer getId() {
		return id;
	}
	/**
	 * Establece el valor del campo "id".
	 * @param id El valor del campo "id".
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Obtiene el valor del campo "prescripcion".
	 * @return El valor del campo "prescripcion".
	 */
	@ManyToOne
    @JoinColumn(name = "CODPRESCRIPCIONMEDICAMENTO")
	public PrescripcionMedicamento getPrescripcion() {
		return prescripcion;
	}
	/**
	 * Establece el valor del campo "prescripcion".
	 * @param prescripcion El valor del campo "prescripcion".
	 */
	public void setPrescripcion(PrescripcionMedicamento prescripcion) {
		this.prescripcion = prescripcion;
	}
	/**
	 * Obtiene el valor del campo "codMedicamento".
	 * @return El valor del campo "codMedicamento".
	 */
	@Column
	public Long getCodMedicamento() {
		return codMedicamento;
	}
	/**
	 * Establece el valor del campo "codMedicamento".
	 * @param codMedicamento El valor del campo "codMedicamento".
	 */
	public void setCodMedicamento(Long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	/**
	 * Obtiene el valor del campo "codMedicamentoCentro".
	 * @return El valor del campo "codMedicamentoCentro".
	 */
	@Column
	public String getCodMedicamentoCentro() {
		return codMedicamentoCentro;
	}
	/**
	 * Establece el valor del campo "codMedicamentoCentro".
	 * @param codMedicamentoCentro El valor del campo "codMedicamentoCentro".
	 */
	public void setCodMedicamentoCentro(String codMedicamentoCentro) {
		this.codMedicamentoCentro = codMedicamentoCentro;
	}
	/**
	 * Obtiene el valor del campo "descMedicamento".
	 * @return El valor del campo "descMedicamento".
	 */
	@Column
	public String getDescMedicamento() {
		return descMedicamento;
	}
	/**
	 * Establece el valor del campo "descMedicamento".
	 * @param descMedicamento El valor del campo "descMedicamento".
	 */
	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
	}
	/**
	 * Obtiene el valor del campo "cantidad".
	 * @return El valor del campo "cantidad".
	 */
	@Column
	public Float getCantidad() {
		return cantidad;
	}
	/**
	 * Establece el valor del campo "cantidad".
	 * @param cantidad El valor del campo "cantidad".
	 */
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Obtiene el valor del campo "fuerza".
	 * @return El valor del campo "fuerza".
	 */
	@Column
	public Float getFuerza() {
		return fuerza;
	}
	/**
	 * Establece el valor del campo "fuerza".
	 * @param fuerza El valor del campo "fuerza".
	 */
	public void setFuerza(Float fuerza) {
		this.fuerza = fuerza;
	}
	/**
	 * Obtiene el valor del campo "unidadesFuerza".
	 * @return El valor del campo "unidadesFuerza".
	 */
	@Column
	public String getUnidadesFuerza() {
		return unidadesFuerza;
	}
	/**
	 * Establece el valor del campo "unidadesFuerza".
	 * @param unidadesFuerza El valor del campo "unidadesFuerza".
	 */
	public void setUnidadesFuerza(String unidadesFuerza) {
		this.unidadesFuerza = unidadesFuerza;
	}
	/**
	 * Obtiene el valor del campo "unidades".
	 * @return El valor del campo "unidades".
	 */
	@Column
	public String getUnidades() {
		return unidades;
	}
	/**
	 * Establece el valor del campo "unidades".
	 * @param unidades El valor del campo "unidades".
	 */
	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}
	/**
	 * Obtiene el valor del campo "volumen".
	 * @return El valor del campo "volumen".
	 */
	@Column
	public Float getVolumen() {
		return volumen;
	}
	/**
	 * Establece el valor del campo "volumen".
	 * @param volumen El valor del campo "volumen".
	 */
	public void setVolumen(Float volumen) {
		this.volumen = volumen;
	}
	/**
	 * Obtiene el valor del campo "base".
	 * @return El valor del campo "base".
	 */
	@Column
	public boolean isBase() {
		return base;
	}
	/**
	 * Establece el valor del campo "base".
	 * @param base El valor del campo "base".
	 */
	public void setBase(boolean base) {
		this.base = base;
	}
	/**
	 * Obtiene el valor del campo "urlProspecto".
	 * @return El valor del campo "urlProspecto".
	 */
	@Column
	public String getUrlProspecto() {
		return urlProspecto;
	}
	/**
	 * Establece el valor del campo "urlProspecto".
	 * @param urlProspecto El valor del campo "urlProspecto".
	 */
	public void setUrlProspecto(String urlProspecto) {
		this.urlProspecto = urlProspecto;
	}
	/**
	 * Obtiene el valor del campo "codPrincipioActivo"
	 * @return El valor del campo "codPrincipioActivo"
	 */
	@Column
	public String getCodPrincipioActivo() {
		return codPrincipioActivo;
	}
	/**
	 * Establece el valor del campo "codPrincipioActivo"
	 * @param codPrincipioActivo El valor del campo "codPrincipioActivo"
	 */
	public void setCodPrincipioActivo(String codPrincipioActivo) {
		this.codPrincipioActivo = codPrincipioActivo;
	}
	/**
	 * Obtiene el valor del campo "descPrincipioActivo"
	 * @return El valor del campo "descPrincipioActivo"
	 */
	@Column
	public String getDescPrincipioActivo() {
		return descPrincipioActivo;
	}
	/**
	 * Establece el valor del campo "descPrincipioActivo"
	 * @param descPrincipioActivo El valor del campo "descPrincipioActivo"
	 */
	public void setDescPrincipioActivo(String descPrincipioActivo) {
		this.descPrincipioActivo = descPrincipioActivo;
	}
	/**
	 * Obtiene el valor del campo "descPresentacion"
	 * @return El valor del campo "descPresentacion"
	 */
	@Column
	public String getDescPresentacion() {
		return descPresentacion;
	}
	/**
	 * Establece el valor del campo "descPresentacion"
	 * @param descPresentacion El valor del campo "descPresentacion"
	 */
	public void setDescPresentacion(String descPresentacion) {
		this.descPresentacion = descPresentacion;
	}
	/**
	 * Obtiene el valor del campo "dosisModificable"
	 * @return El valor del campo "dosisModificable"
	 */
	@Column
	public boolean isDosisModificable() {
		return dosisModificable;
	}
	/**
	 * Establece el valor del campo "dosisModificable"
	 * @param dosisModificable El valor del campo "dosisModificable"
	 */
	public void setDosisModificable(boolean dosisModificable) {
		this.dosisModificable = dosisModificable;
	}
	/**
	 * Obtiene el valor del campo "unidadContenedora"
	 * @return El valor del campo "unidadContenedora"
	 */
	@Column
	public String getUnidadContenedora() {
		return unidadContenedora;
	}
	/**
	 * Establece el valor del campo "unidadContenedora"
	 * @param unidadContenedora El valor del campo "unidadContenedora"
	 */
	public void setUnidadContenedora(String unidadContenedora) {
		this.unidadContenedora = unidadContenedora;
	}
	/**
	 * Obtiene el valor del campo "presentacion"
	 * @return El valor del campo "presentacion"
	 */
	@Column
	public boolean isPresentacion() {
		return presentacion;
	}
	/**
	 * Establece el valor del campo "presentacion"
	 * @param presentacion El valor del campo "presentacion"
	 */
	public void setPresentacion(boolean presentacion) {
		this.presentacion = presentacion;
	}
	/**
	 * Obtiene el valor del campo "codUnidadesFuerza"
	 * @return El valor del campo "codUnidadesFuerza"
	 */
	@Column
	public Long getCodUnidadesFuerza() {
		return codUnidadesFuerza;
	}
	/**
	 * Establece el valor del campo "codUnidadesFuerza"
	 * @param codUnidadesFuerza El valor del campo "codUnidadesFuerza"
	 */
	public void setCodUnidadesFuerza(Long codUnidadesFuerza) {
		this.codUnidadesFuerza = codUnidadesFuerza;
	}
	/**
	 * Obtiene el valor del campo "codUnidadContenedora"
	 * @return El valor del campo "codUnidadContenedora"
	 */
	@Column
	public Long getCodUnidadContenedora() {
		return codUnidadContenedora;
	}
	/**
	 * Establece el valor del campo "codUnidadContenedora"
	 * @param codUnidadContenedora El valor del campo "codUnidadContenedora"
	 */
	public void setCodUnidadContenedora(Long codUnidadContenedora) {
		this.codUnidadContenedora = codUnidadContenedora;
	}
	/**
	 * Obtiene el valor del campo "codUnidades"
	 * @return El valor del campo "codUnidades"
	 */
	@Column
	public Long getCodUnidades() {
		return codUnidades;
	}
	/**
	 * Establece el valor del campo "codUnidades"
	 * @param codUnidades El valor del campo "codUnidades"
	 */
	public void setCodUnidades(Long codUnidades) {
		this.codUnidades = codUnidades;
	}
	/**
	 * Obtiene el valor del campo "codFormaFarma".
	 * @return El valor del campo "codFormaFarma".
	 */
	@Column
	public Long getCodFormaFarma() {
		return codFormaFarma;
	}
	/**
	 * Establece el valor del campo "codFormaFarma".
	 * @param cFormaFarma codigo de la forma farmaceutica
	 *            El valor del campo "codFormaFarma".
	 */
	public void setCodFormaFarma(final Long cFormaFarma) {
		this.codFormaFarma = cFormaFarma;
	}
	/**
	 * Obtiene el valor del campo "descFormaFarma".
	 * @return El valor del campo "descFormaFarma".
	 */
	@Column
	public String getDescFormaFarma() {
		return descFormaFarma;
	}
	/**
	 * Establece el valor del campo "descFormaFarma".
	 * @param descFormaFarma descripcion de la forma famaceutica
	 *            El valor del campo "descFormaFarma".
	 */
	public void setDescFormaFarma(final String descFormaFarma) {
		this.descFormaFarma = descFormaFarma;
	}
	/**
	 * Devuelve la cantidad de medicamento necesaria en función de prescrito y las tomas a las que afecta.
	 * @param numTomas int.
	 * @return float
	 */
	public float obtenerCantidadFuerza(int numTomas) {
		float cantidadPrescrita = 0f;
		float fuerzaPrescrita = 0f;
		float cantidadFuerza = 0f;
		if (getCantidad() != null
				&& getCantidad().floatValue() > 0f) {
				cantidadPrescrita = this.getCantidad().floatValue();
			}
			if (getFuerza() != null
					&& getFuerza().floatValue() > 0f) {
				fuerzaPrescrita = this.getFuerza().floatValue();
			}
		if (numTomas > 0) {
			cantidadFuerza = (cantidadPrescrita*fuerzaPrescrita)*numTomas;
		}
		return cantidadFuerza;
	}
	/**
	 * toString
	 * @return Cadena con las características del objeto
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">>>CompuestoMultimedicamento {id: " + this.id);
		sb.append(" Prescripcion: " + this.prescripcion.getId() + " " + this.prescripcion.getDescMedicamento());
		sb.append(" codMedicamento: " + this.codMedicamento);
		sb.append(" codMedicamentoCentro: " + this.codMedicamentoCentro);
		sb.append(" descMedicamento: " + this.descMedicamento);
		sb.append(" descPresentacion: " + this.descPresentacion);
		sb.append(" descPrincipioActivo: " + this.descPrincipioActivo);
		sb.append(" codPrincipioActivo: " + this.codPrincipioActivo);
		sb.append(" fuerza: " + this.fuerza);
		sb.append(" unidadesFuerza: " + this.unidadesFuerza);
		sb.append(" codUnidadesFuerza: " + this.codUnidadesFuerza);
		sb.append(" cantidad: " + this.cantidad);
		sb.append(" unidades: " + this.unidades);
		sb.append(" codUnidades: " + this.codUnidades);
		sb.append(" codFormaFarma: " + this.codFormaFarma);
		sb.append(" descFormaFarma: " + this.descFormaFarma);
		sb.append(" unidadContenedora: " + this.unidadContenedora);
		sb.append(" codUnidadContenedora: " + this.codUnidadContenedora);
		sb.append(" volumen: " + this.volumen);
		sb.append(" base: " + (this.base ? "Si" : "No"));
		sb.append(" dosisModificable: " + (this.dosisModificable ? "Si" : "No"));
		sb.append(" presentacion: " + (this.presentacion ? "Si" : "No"));
		sb.append(" urlProspecto: " + this.urlProspecto);
		sb.append("}");
		return sb.toString();
	}
	/**
	 * key para mapas.
	 * @return String.
	 */
	@Transient
	public String getStringIdMap() {
		return codMedicamento + "_" + unidades;
	}
	/**
	 * compareTo.
	 * @param o CompuestoMultimedicamento
	 * @return int
	 */
	@Override
	public int compareTo(CompuestoMultimedicamento o) {
		int ret = 0;
		if (o == null) {
			ret = +1;
		}
		if (ret == 0) {
			if (this.isBase()) {
				ret = +1;
			}
		}
		if (ret == 0) {
			if (this.getDescMedicamento() == null) {
				if (o.getDescMedicamento() == null) {
					ret = 0;
				} else {
					ret = -1;
				}
			} else {
				if (o.getDescMedicamento() == null) {
					ret = +1;
				} else {
					ret = this.getDescMedicamento().compareTo(o.getDescMedicamento());
				}
			}
		}
		if (ret == 0) {
			if (this.getId() == null) {
				if (o.getId() == null) {
					ret = 0;
				} else {
					ret = -1;
				}
			} else {
				if (o.getId() == null) {
					ret = +1;
				} else {
					ret = this.getId().compareTo(o.getId());
				}
			}
		}
		return 0;
	}
	/**
	 * Indica si se puede emplear la unidad contenedora, empleable cuando no es un fluido ni hay posología variable.
	 * Debe tener unidadContenedora != unidades y especificado el campo fuerza.
	 * @return boolean
	 */
	public boolean usarUnidadContenedora() {
		boolean ret = false;
		if (getFuerza() != null
				&& getFuerza().floatValue() > 0f && getCodUnidadContenedora() != null
						&& getCodUnidades() != null
						&& getCodUnidades().intValue() != getCodUnidadContenedora().intValue()) {
			ret = true;
		}
		return ret;
	}
	
}
