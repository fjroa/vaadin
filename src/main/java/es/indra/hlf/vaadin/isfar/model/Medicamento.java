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
public class Medicamento implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;

	/**
	 * Constructor.
	 *
	 */
	public Medicamento() {
		super();
	}

	/**
	 * Attribute codMedicamento.
	 */
	private Long codMedicamento;
	/**
	 * Attribute descMedicamento.
	 */
	private String descMedicamento;

	/**
	 * Attribute urlMasDatos.
	 */
	private String urlMasDatos;

	public Long getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(Long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	public String getDescMedicamento() {
		return descMedicamento;
	}

	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
	}

	public String getUrlMasDatos() {
		return urlMasDatos;
	}

	public void setUrlMasDatos(String urlMasDatos) {
		this.urlMasDatos = urlMasDatos;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


}
