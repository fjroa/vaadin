package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.List;

/**
 * VO para paginacion.
 * @author tnevado
 */
public class Pagina implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5360881956321097629L;

	/**
	 * Constructor.
	 *
	 */
	public Pagina() {
		super();
	}

	/**
	 * Numero total de registros que produce la consulta.
	 */
	private Integer totalPaginas;

	/**
	 * Numero total de registros que produce la query lanzada.
	 */
	private Integer totalRegistrosQuery;

	/**
	 * Indice de la primera fila de esta pagina dentro del total de resultados.
	 */
	private Integer numPagina;

	/**
	 * Numero de filas por pagina.
	 */
	private Integer filasPorPagina;

	/**
	 * Filas de esta pagina.
	 */
	@SuppressWarnings("unchecked")
	private List resultados;



	/**
	 * Obtiene el valor del campo "totalPaginas".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "totalPaginas".
	 */
	public Integer getTotalPaginas() {
		return totalPaginas;
	}

	/**
	 * Establece el valor del campo "totalPaginas".
	 *
	 * @author tnevado
	 *
	 * @param totalPaginas
	 *            El valor del campo "totalPaginas".
	 */
	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	/**
	 * Obtiene el valor del campo "totalRegistrosQuery".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "totalRegistrosQuery".
	 */
	public Integer getTotalRegistrosQuery() {
		return totalRegistrosQuery;
	}

	/**
	 * Establece el valor del campo "totalRegistrosQuery".
	 *
	 * @author tnevado
	 *
	 * @param totalRegistrosQuery
	 *            El valor del campo "totalRegistrosQuery".
	 */
	public void setTotalRegistrosQuery(Integer totalRegistrosQuery) {
		this.totalRegistrosQuery = totalRegistrosQuery;
	}

	/**
	 * Obtiene el valor del campo "numPagina".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "numPagina".
	 */
	public Integer getNumPagina() {
		return numPagina;
	}

	/**
	 * Establece el valor del campo "numPagina".
	 *
	 * @author tnevado
	 *
	 * @param numPagina
	 *            El valor del campo "numPagina".
	 */
	public void setNumPagina(Integer numPagina) {
		this.numPagina = numPagina;
	}

	/**
	 * Obtiene el valor del campo "filasPorPagina".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "filasPorPagina".
	 */
	public Integer getFilasPorPagina() {
		return filasPorPagina;
	}

	/**
	 * Establece el valor del campo "filasPorPagina".
	 *
	 * @author tnevado
	 *
	 * @param filasPorPagina
	 *            El valor del campo "filasPorPagina".
	 */
	public void setFilasPorPagina(Integer filasPorPagina) {
		this.filasPorPagina = filasPorPagina;
	}

	/**
	 * Obtiene el valor del campo "resultados".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "resultados".
	 */
	@SuppressWarnings("unchecked")
	public List getResultados() {
		return resultados;
	}

	/**
	 * Establece el valor del campo "resultados".
	 *
	 * @author tnevado
	 *
	 * @param resultados
	 *            El valor del campo "resultados".
	 */
	@SuppressWarnings("unchecked")
	public void setResultados(List resultados) {
		this.resultados = resultados;
	}


}
