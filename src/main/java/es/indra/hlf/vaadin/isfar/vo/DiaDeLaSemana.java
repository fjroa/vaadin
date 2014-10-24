/**
 *  22/10/2013
 */
package es.indra.hlf.vaadin.isfar.vo;


/**
 * Enumerado para dias de la semana.
 */
public enum DiaDeLaSemana {
	TODOS(0),
	DOMINGO(1),
	LUNES(2),
	MARTES(3),
	MIERCOLES(4),
	JUEVES(5),
	VIERNES(6),
	SABADO(7);
	
	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Codigo que representa el valor del dia de la semana.
	 * codigo int.
	 */
	private final int codigo;

	/**
	 * Constructor.
	 *
	 * @param codigo
	 */
	private DiaDeLaSemana(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el valor del campo "codigo".
	 *
	 * @return El valor del campo "codigo".
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Crea un enumerado DiaDeLaSemana a partir de un codigo valido.
	 * @param codigo int
	 * @return DiaDeLaSemana
	 */
	public static DiaDeLaSemana fromCodigo(int codigo)
	  {
	    for (DiaDeLaSemana dia : values()) {
	      if (dia.getCodigo() == codigo) {
	        return dia;
	      }
	    }
	    throw new RuntimeException("No enum of " + DiaDeLaSemana.class.toString() + " can be created from code : " + codigo);
	  }
}
