package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase de dominio para la entidad Estado Carro.
 * @author ardiego
 */
@Entity
@Table(name = "ESTADO_CARRO")
@SequenceGenerator(name = "SEQ_ESTADO_CARRO",
				   sequenceName = "SEQ_ESTADO_CARRO",
				   allocationSize = 1)
public class EstadoCarro implements Serializable {

	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = 1413724746116552069L;

	//Estados posibles
	/** Pendiente de preparacion. */
    public static final String ESTADO_CARRO_PENDIENTE = "Pendiente de preparacion";
    /** En Preparacion. */
    public static final String ESTADO_CARRO_PREPARACION = "En Preparacion";
    /** Preparado/Cerrado. */
    public static final String ESTADO_CARRO_PREPARADO = "Preparado/Cerrado";
    /** En Destino. */
    public static final String ESTADO_CARRO_EN_DESTINO = "En Destino";
    /** Devuelto. */
    public static final String ESTADO_CARRO_DEVUELTO = "Devuelto";


    //Codigos asociados a los estados
    /** Pendiente de preparacion. */
    public static final int ESTADO_CARRO_PENDIENTE_COD = 1;
    /** En Preparacion. */
    public static final int ESTADO_CARRO_PREPARACION_COD = 2;
    /** Preparado/Cerrado. */
    public static final int ESTADO_CARRO_PREPARADO_COD = 3;
    /** En Destino. */
    public static final int ESTADO_CARRO_EN_DESTINO_COD = 4;
    /** Devuelto .*/
    public static final int ESTADO_CARRO_DEVUELTO_COD = 5;

    /** Mapeo del estado con su codigo. */
    private static final Map < Integer, String > MAP = new HashMap < Integer, String >();
    static {
    	MAP.put(ESTADO_CARRO_PENDIENTE_COD, ESTADO_CARRO_PENDIENTE);
    	MAP.put(ESTADO_CARRO_PREPARACION_COD, ESTADO_CARRO_PREPARACION);
    	MAP.put(ESTADO_CARRO_PREPARADO_COD, ESTADO_CARRO_PREPARADO);
    	MAP.put(ESTADO_CARRO_EN_DESTINO_COD, ESTADO_CARRO_EN_DESTINO);
    	MAP.put(ESTADO_CARRO_DEVUELTO_COD, ESTADO_CARRO_DEVUELTO);
    }

	/**
	 * Attribute id.
	 */
	private Integer id;

	/**
	 * Attribute descEstadoCarro.
	 */
	private String descEstadoCarro;

	/**
	 * Constructor.
	 * @param codEstadoCarro Integer
	 */
	public EstadoCarro(Integer codEstadoCarro) {
		super();
		this.id = codEstadoCarro;
		this.descEstadoCarro = MAP.get(codEstadoCarro);
	}

	/**
	 * Constructor por defecto.
	 */
	public EstadoCarro() {
		super();
	}

	/** Getter codEstadoCarro.
	 * @return codEstadoCarro
	 */
	@Basic
	@Id
	@Column(name = "CODESTADOCARRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADO_CARRO")
	public Integer getId() {
		return id;
	}


	/** Setter codEstadoCarro.
	 * @param codEstadoCarro the codEstadoCarro to set
	 */
	public void setId(Integer codEstadoCarro) {
		this.id = codEstadoCarro;
	}

	/** Getter descEstadoCarro.
	 * @return descEstadoCarro
	 */
	@Basic
	@Column(name = "DESCESTADOCARRO", length = 255)
	public String getDescEstadoCarro() {
		return descEstadoCarro;
	}

	/** Setter descEstadoCarro.
	 * @param descEstadoCarro new value for descEstadoCarro
	 */
	public void setDescEstadoCarro(String descEstadoCarro) {
		this.descEstadoCarro = descEstadoCarro;
	}
}
