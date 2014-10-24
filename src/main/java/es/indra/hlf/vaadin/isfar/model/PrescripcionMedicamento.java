package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import es.indra.hlf.vaadin.isfar.vo.DosisAdminVO;

//import org.hibernate.annotations.Formula;

/**
 * Clase de dominio para prescripcion.
 *
 * @author dcruzg
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PRESCRIPCION_MEDICAMENTO")
@SequenceGenerator(name = "SEQ_PRESCRIPCION", sequenceName = "SEQ_PRESCRIPCION", allocationSize = 1)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("1")
public class PrescripcionMedicamento extends EntidadBase implements Serializable,
	Comparable < PrescripcionMedicamento > {

	/**
     * INMEDIATO_NO_INMEDIATO int = 0.
     *  Constante que representa el valor que toma la variable suministroInmediato
	 * cuando se trata de un suministro no inmediato.
	 */
	public static final char INMEDIATO_NO_INMEDIATO = '0';
	/**
	 * INMEDIATO_UNICA_TOMA int = 1.
	 *  Constante que representa el valor que toma la variable suministroInmediato
	 * cuando se trata de un suministro inmediato de una unica toma.
	 */
	public static final char INMEDIATO_UNICA_TOMA = '1';
	/**
     * INMEDIATO_PRIMERA_TOMA int = 2.
     *  Constante que representa el valor que toma la variable suministroInmediato
	 * cuando se trata de un suministro inmediato solo para la primera toma.
	 */
	public static final char INMEDIATO_PRIMERA_TOMA = '2';
	/**
     * INMEDIATO_NO_INMEDIATO int = 0.
     *  Constante que representa el valor que toma la variable suministroInmediato
	 * cuando se trata de un suministro no inmediato.
	 */
	public static final int INMEDIATO_NO_INMEDIATO_INT = 0;
	/**
	 * INMEDIATO_UNICA_TOMA int = 1.
	 *  Constante que representa el valor que toma la variable suministroInmediato
	 * cuando se trata de un suministro inmediato de una unica toma.
	 */
	public static final int INMEDIATO_UNICA_TOMA_INT = 1;
	/**
     * INMEDIATO_PRIMERA_TOMA int = 2.
     *  Constante que representa el valor que toma la variable suministroInmediato
	 * cuando se trata de un suministro inmediato solo para la primera toma.
	 */
	public static final int INMEDIATO_PRIMERA_TOMA_INT = 2;
	/**
	 * TIPO_NORMAL int = 1. Constante que representa el valor que toma la variable tipo
	 * cuando se trata de una prescripcion normal.
	 */
	public static final int TIPO_NORMAL = 1;
	/**
	 * TIPO_FLUIDO int = 2. Constante que representa el valor que toma la variable tipo
	 * cuando se trata de una prescripcion de un fluido.
	 */
	public static final int TIPO_FLUIDO = 2;
	/**
	 * TIPO_PROTOCOLO int = 3. Constante que representa el valor que toma la variable tipo
	 * cuando se trata de una prescripcion tipo protocolo.
	 */
	public static final int TIPO_PROTOCOLO = 3;
	/**
	 * ESTADO_PENDIENTE int = 1. Constante que representa el valor que toma la variable estado
	 * cuando se trata de una prescripcion pendiente de validar.
	 */
	public static final int ESTADO_PENDIENTE = 1;
	/**
	 * ESTADO_VALIDADA int = 2. Constante que representa el valor que toma la variable estado
	 * cuando se trata de una prescripcion validada.
	 */
	public static final int ESTADO_VALIDADA = 2;
	/**
	 * ESTADO_RECHAZADA int = 3. Constante que representa el valor que toma la variable estado
	 * cuando se trata de una prescripcion rechazada.
	 */
	public static final int ESTADO_RECHAZADA = 3;
	/**
	 * TIPO_APORTACION_ENTERICA char = 'E'. Tipo aportacion Enterica.
	 */
	public static final char TIPO_APORTACION_ENTERICA = 'E';
	/**
	 * TIPO_APORTACION_PARENTERICA char = 'P'. Tipo aportacion Parenterica.
	 */
	public static final char TIPO_APORTACION_PARENTERICA = 'P';
	/**
	 * Valor con que llegan en el campo duracion las presc sin fecha de fin.
	 *  Prescripcion con duracion indeterminada */
	public static final int VALOR_DURACION_SIN_FECHA_FIN = 999999;
	
	/**
	 * Constante para asignar al campo tipoUnidadDuracion
	 *  cuando se especifica la duración en Horas.
	 * UNIDAD_DURACION_HORAS int = 0.
	 */
	public static final int UNIDAD_DURACION_HORAS = 0;
	/**
	 * Constante para asignar al campo tipoUnidadDuracion
	 *  cuando se especifica la duración en Dias.
	 * UNIDAD_DURACION_DIAS int = 1.
	 */
	public static final int UNIDAD_DURACION_DIAS = 1;
	/**
	 * Constante para asignar al campo tipoUnidadDuracion
	 *  cuando se especifica la duración en Meses.
	 * UNIDAD_DURACION_MESES int = 2.
	 */
	public static final int UNIDAD_DURACION_MESES = 2;
	/**
	 * Constante para asignar al campo tipoUnidadDuracion
	 *  cuando se especifica la duración en Minutos.
	 * UNIDAD_DURACION_MINUTOS int = 3.
	 */
	public static final int UNIDAD_DURACION_MINUTOS = 3;
	/**
	 * Constante para asignar al campo tipoUnidadDuracion
	 *  cuando se especifica la duración en Segundos.
	 * UNIDAD_DURACION_SEGUNDOS int = 4.
	 */
	public static final int UNIDAD_DURACION_SEGUNDOS = 4;
	
	/**
	 * Constante para asignar al campo tipoUnidadFrecuencia
	 *  cuando se especifica la duración en Horas.
	 * UNIDAD_FREC_HORAS int = 0.
	 */
	public static final int UNIDAD_FREC_HORAS = 0;
	/**
	 * Constante para asignar al campo tipoUnidadFrecuencia
	 *  cuando se especifica la duración en Dias.
	 * UNIDAD_FREC_DIAS int = 1.
	 */
	public static final int UNIDAD_FREC_DIAS = 1;
	/**
	 * Constante para asignar al campo tipoUnidadFrecuencia
	 *  cuando se especifica la duración en Meses.
	 * UNIDAD_FREC_MESES int = 2.
	 */
	public static final int UNIDAD_FREC_MESES = 2;
	/**
	 * Constante para asignar al campo tipoUnidadFrecuencia
	 *  cuando se especifica la duración en Minutos.
	 * UNIDAD_FREC_MINUTOS int = 3.
	 */
	public static final int UNIDAD_FREC_MINUTOS = 3;
	/**
	 * Constante para asignar al campo tipoUnidadFrecuencia
	 *  cuando se especifica la duración en Segundos.
	 * UNIDAD_FREC_SEGUNDOS int = 4.
	 */
	public static final int UNIDAD_FREC_SEGUNDOS = 4;

	/**
	 * SEPARADOR_PPIOS_ACTIVOS String.
	 */
	public static final String SEPARADOR_PPIOS_ACTIVOS = ",";

	/**
	 * Unidades en mililitros
	 * UNIDADES_ML String.
	 */
	public static final String UNIDADES_ML = "ml";
	/**
	 * Unidades en litros.
	 * UNIDADES_L String.
	 */
	public static final String UNIDADES_L = "l";
	
	/**
	 * Constante de número de horas en un día
	 * HORAS_POR_DIA int.
	 */
	public static final int HORAS_POR_DIA = 24;
	/**
	 * DIAS_POR_MES int.
	 */
	public static final int DIAS_POR_MES = 30;
	/**
	 * Constante de numero de minutos en un dia.
	 * MINUTOS_POR_DIA int.
	 */
	public static final int MINUTOS_POR_DIA = 1440;
	/**
	 * Constante de numero de segundos en un día.
	 * SEGUNDOS_POR_DIA int.
	 */
	public static final int SEGUNDOS_POR_DIA = 86400;
	
	
	/**
	 * Constructor.
	 *
	 */
	public PrescripcionMedicamento() {
		super();
	}
	/**
	 * id Integer.
	 */
	private Integer id;

	/**
	 * tipo Integer.
	 */
	private Integer tipo;
	/**
	 * Tratamiento relacionado con este item Medicamento.
	 */
	private Tratamiento tratamiento;
	/**
	 * Codigo de la prescripcion en el modulo ISPRE..
	 */
	private Long codPrescripcionPRE;
	/**
	 * Codigo del medicamento.
	 */
	private Long codMedicamento;
	
	/**
	 * codMedicamentoCentro String.
	 */
	private String codMedicamentoCentro;
	/**
	 * Descripcion del medicamento.
	 */
	private String descMedicamento;
	/**
	 * Descripcion del medicamento en formato mas legible.
	 */
	private String descPresentacion;
	/**
	 * Estado de la perscripcion.
	 * {@value 1: Pendiente}
	 * {@value 2: Validada}
	 * {@value 3: Rechazada}
	 */
	private Integer estado;
	/**
	 * Codigo de la prescripcion padre en PRE
	 * Indica el codico de la prescripcion que se modifico para obtener la actual.
	 */
	private Long codPrescripcionPadre;
	/**
	 * Codigo interno del modulo ISPRE, que indica el codigo de.
	 * la prescripcion Origen desde la que se migra la prescripcion URG/HOS
	 */
	private Long codPrescripcionOrigen;
	/**
	 * Codigo del almacen del medicamento.
	 */
	private String codAlmacen;
	/**
	 * Descripcion del almacen del medicamento.
	 */
	private String descAlmacen;
	/**
	 * codUnidades Integer.
	 */
	private Integer codUnidades;
	/**
	 * Unidades empleadas.
	 */
	private String unidades;
	/**
	 * Fecha de inicio de la administracion del medicamento.
	 */
	private Date fechaInicioAdministracion;
	/**
	 * Fecha de fin de la administracion del medicamento.
	 */
	private Date fechaFinAdministracion;
	/**
	 * Suministro inmediato.
	 * {@value 0: no inmediato}
	 * {@value 1: inmediato unica toma}
	 * {@value 2: inmediato primera toma}
	 */
	private char suministroInmediato;
	/**
	 * Codigo de la via de administracion del medicamento.
	 */
	private Integer codViaAdmin;
	/**
	 * descripcion de la via de administracion del medicamento.
	 */
	private String descViaAdmin;
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
	 * Codigo de los Principio activo del medicamento.
	 */
	private String codPrincipioActivo;
	/**
	 * Descripcion de los principios activos del medicamento.
	 */
	private String descPrincipioActivo;
	/**
	 * Cantidad de unidades de producto.
	 * cantidad float.
	 */
	private Float cantidad;
	/**
	 * Cantidad de medicamento por unidad.
	 * fuerza Float.
	 */
	private Float fuerza;
	/**
	 * Url del prospecto de la prescripcion.
	 * urlProspecto String.
	 */
	private String urlProspecto;
	/**
	 * codUnidadesFuerza Integer.
	 */
//	private Integer codUnidadesFuerza;
	/**
	 * Unidades de la fuerza.
	 * unidadesFuerza String.
	 */
//	private String unidadesFuerza;
	/**
	 * Frecuencia con la que se debe tomar el medicamento.
	 */
	private Float frecuencia;
	/**
	 * Indica en que unidades esta especificada la frecuencia
	 * tipoUnidadFrecuencia int.
	 */
	private int tipoUnidadFrecuencia;
	/**
	 * Tipo de infeccion.
	 */
	private String tipoInfeccionAntibiotico;
	/**
	 * Profilaxis.
	 */
	private String profilaxisAntibiotico;
	/**
	 * Tipo de toma del antibiotico.
	 */
	private String tipoTomaAntibiotico;
	/**
	 * Terapeutica antibiotico.
	 */
	private String terapeuticaAntibiotico;
	/**
	 * Justificacion antibiotico.
	 */
	private String justificacionAntibiotico;
	/**
	 * Observaciones sobre el rechazo de la prescripcion.
	 */
	private String observacionesRechazo;
	/**
	 * Motivo de rechazo.
	 */
	private Motivo motivoRechazo;
	/**
	 * Fecha del rechazo.
	 */
	private Date fechaHoraRechazo;
	/**
	 * Fecha de validacion.
	 */
	private Date fechaHoraValidacion;
	/**
	 * Fecha y hora de la ultima administracion generada (preparada o no) del medicamento.
	 */
	private Date fechaUltimaTomaPrevista;
	/**
	 * Fecha y hora de la ultima administracion preparada del medicamento.
	 * fechaUltimaTomaPreparada Date.
	 */
	private Date fechaUltimaTomaPreparada;
	/**
	 * Instrucciones sobre el medicamento.
	 */
	private String instrucciones;
	/**
	 * Medicamento pediotrico.
	 */
	private boolean pediatrico;
	/**
	 * Indica la pauta de administracion.
	 * {@value si dolor}
	 * {@value si fiebre}
	 * {@value otros}
	 */
	private String pautaVariable;
	/**
	 * Perfil del medicamento.
	 * {@value 1:estupefacientes/psicotropicos}
	 * {@value 2: antibioticos}
	 * {@value 3: hemoderivados}
	 */
	private Integer perfil;
	/**
	 * Antibiotico necesita autorizacion o no.
	 */
	private boolean autorizado;
	/**
	 * Codigo del protocolo al que puede pertenecer la prescripcion.
	 */
	private String codProtocolo;
	/**
	 * Si pertenece a un protocolo, indica si es o no modificable.
	 */
	private boolean modificable;
	/**
	 * Si el medicamento presenta interacciones con otro medicamento prescrito.
	 */
	private boolean interaccion;
	/**
	 * Lista de principios activos prescritos con los que el medicamento interacciona.
	 */
	private String interaccionPrincipiosActivos;
	/**
	 * Instrucciones para el enfermero.
	 */
	private String observacionesEnfermero;
	/**
	 * descUsuarioCreacion String.
	 */
	private String descUsuarioCreacion;
	/**
	 * codUsuarioValidacion String.
	 */
	private String codUsuarioValidacion;
	/**
	 * descUsuarioValidacion String.
	 */
	private String descUsuarioValidacion;
	/**
	 * codUsuarioRechazo String.
	 */
	private String codUsuarioRechazo;
	/**
	 * descUsuarioRechazo String.
	 */
	private String descUsuarioRechazo;
	/**
	 * descUsuarioUltimaModificacion String.
	 */
	private String descUsuarioUltimaModificacion;

	/**
	 * Numero de lote de la medicacion.
	 */
	private String numLote;

	/**
	 * causaAnulacion String.
	 */
	private String causaAnulacion;
	/**
	 * pauta PautaAdministracion.
	 */
	private PautaAdministracion pauta;

	/**
	 * Primera fecha de recogida de la medicacion.
	 */
	private Date fechaInicioRecogida;
	/**
	 * Periodo de tiempo en el que el paciente debe de pasar a recoger la medicacion.
	 */
	private Integer diasRecogida;
	/**
	 * codFormaFarma long.
	 */
	private long codFormaFarma;
	/**
	 * descFormaFarma String.
	 */
	private String descFormaFarma;
	/**
	 * noUnidosis boolean.
	 */
	private boolean noUnidosis;
	/**
	 * necesitaReposicion boolean.
	 */
	private Date fechaNecesitaReposicion;
	/**
	 * aporteHidrico boolean.
	 */
	private boolean aporteHidrico;
	/**
	 * Codigo de la posologia en Prescripciones.
	 */
	private Integer codPosologiaPRE;
	/**
	 * Modo de administracion del medicamento si tiene un codFormaFarma = 1.
	 */
	private String modoAdministracion;
	/**
	 * fechaHoraModificacionReposicion Date.
	 */
	private Date fechaHoraModificacionReposicion;

	/**
	 * Indica si la dosis podra ser modificada por el enfermero.
	 */
	private boolean dosisModificable;
	/**
	 * codPrescOriginal Long.
	 */
	private Long codPrescOriginal;
	/**
	 * Nuevos campos v06.00
	 */
	/**
	 * medicALAlta boolean.
	 */
//	private boolean medicAlAlta;
	/**
	 * Indica si se deben aplicar o no pautas de farmacia a la hora de generar tomas para la prescripción.
	 * aplicarPautasFar boolean.
	 */
//	private boolean aplicarPautasFar;
	//Fluidos
	/**
	 * Velocidad de administración queda determinada por dosisTotalPrescrita y tiempoAdministracion.
	 * velocidad float.
	 */
	private Float velocidad;
	/**
	 * Nuevos campos v06.00
	 */
	/**
	 * codUnidadContenedora Integer.
	 */
	private Integer codUnidadContenedora;
	/**
	 * unidadContenedora String.
	 */
	private String unidadContenedora;
	/**
	 * presentacion boolean.
	 */
	private boolean presentacion;
	/**
	 * Volumen de mezcla prescrito utilizado para el calculo
	 *  de la velocidad junto al campo tiempo.
	 */
	private Float volumen;
	/**
	 * Volumen de mezcla obtenido de la suma
	 *  de los volumenes de los compuestos.
	 */
	private Float volumenTotal;
	/**
	 * Tiempo de administración del volumen prescrito.
	 * tiempo Float.
	 */
	private Float tiempo;
	/**
	 * tramosPosologia List&lt;TramoPosologia&gt;.
	 */
	private SortedSet<TramoPosologia> tramosPosologia = new TreeSet<TramoPosologia>();
	/**
	 * fluidoSinContinuidad boolean.
	 */
	private boolean fluidoSinContinuidad;
	/**
	 * fluidoSinPautas boolean.
	 */
	private boolean fluidoSinFrecAdm;
	/**
	 * compuestos Set&lt;CompuestoMultimedicamento&gt;.
	 */
	private List<CompuestoMultimedicamento> compuestos = new ArrayList<CompuestoMultimedicamento>();
	/**
	 * Fin nuevos campos v06.00
	 */
	/**
     * Indica si las observaciones del enfermero se hicieron con carácteres en árabe
     */
    private boolean observEnfermeroEnArabe;

    /**
     * Indica si las instrucciones al farmaceutico se indicaron con carácteres en árabe
     */
    private boolean instruccionesEnArabe;

    /**
     * Indica si la pauta variable se indicó con carácteres en árabe
     */
    private boolean pautaVariableEnArabe;
	/**
	 * Obtiene el valor del campo "codPrescripcionMedicamento".
	 *
	 * @author dcruzg
	 *
	 * @return El valor del campo "codPrescripcionMedicamento".
	 */
	@Basic
	@Id
	@Column(name = "CODPRESCRIPCIONMEDICAMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRESCRIPCION")
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el valor del campo "id".
	 * @param id
	 *            El valor del campo "id".
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene el valor del campo "tipo".
	 *
	 * @return El valor del campo "tipo".
	 */
	@Column
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * Establece el valor del campo "tipo".
	 *
	 * @param tipo
	 *            El valor del campo "tipo".
	 */
	public void setTipo(final Integer tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el valor del campo "tratamiento".
	 * @return El valor del campo "tratamiento".
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODTRATAMIENTO")
	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	/**
	 * Establece el valor del campo "tratamiento".
	 * @param trat Tratamiento
	 *            El valor del campo "tratamiento".
	 */
	public void setTratamiento(final Tratamiento trat) {
		this.tratamiento = trat;
	}

	/**
	 * Devuelvo el codMedicamento.
	 * @return the codMedicamento
	 */
	@Column
	public Long getCodMedicamento() {
		return codMedicamento;
	}

	/**
	 * Establezco el codMedicamento.
	 * @param codMed Long
	 *            the codMed to set
	 */
	public void setCodMedicamento(final Long codMed) {
		this.codMedicamento = codMed;
	}

	/**
	 * Obtiene el valor del campo "codMedicamentoCentro".
	 *
	 * @return El valor del campo "codMedicamentoCentro".
	 */
	@Column
	public String getCodMedicamentoCentro() {
		return codMedicamentoCentro;
	}

	/**
	 * Establece el valor del campo "codMedicamentoCentro".
	 *
	 * @param codMedicamentoCentro
	 *            El valor del campo "codMedicamentoCentro".
	 */
	public void setCodMedicamentoCentro(String codMedicamentoCentro) {
		this.codMedicamentoCentro = codMedicamentoCentro;
	}

	/**
	 * Devuelvo el descMedicamento.
	 * @return the descMedicamento
	 */
	@Column
	public String getDescMedicamento() {
		return descMedicamento;
	}

	/**
	 * Establezco el descMedicamento.
	 * @param descMed String
	 *            the descMedicamento to set
	 */
	public void setDescMedicamento(final String descMed) {
		this.descMedicamento = descMed;
	}

	/**
	 * Obtiene el valor del campo "descPresentacion".
	 *
	 * @return El valor del campo "descPresentacion".
	 */
	@Column
	public String getDescPresentacion() {
		return descPresentacion;
	}

	/**
	 * Establece el valor del campo "descPresentacion".
	 *
	 * @param dPresentacion
	 *            El valor del campo "descPresentacion".
	 */
	public void setDescPresentacion(final String dPresentacion) {
		this.descPresentacion = dPresentacion;
	}

	/**
	 * Devuelvo el codAlmacen.
	 * @return the codAlmacen
	 */
	@Column
	public String getCodAlmacen() {
		return codAlmacen;
	}

	/**
	 * Establezco el codAlmacen.
	 * @param cAlmacen
	 *            the codAlmacen to set
	 */
	public void setCodAlmacen(final String cAlmacen) {
		this.codAlmacen = cAlmacen;
	}

	/**
	 * Devuelvo el descAlmacen.
	 * @return the descAlmacen
	 */
	@Column
	public String getDescAlmacen() {
		return descAlmacen;
	}

	/**
	 * Establezco el descAlmacen.
	 * @param dAlmacen
	 *            the descAlmacen to set
	 */
	public void setDescAlmacen(final String dAlmacen) {
		this.descAlmacen = dAlmacen;
	}

	/**
	 * Devuelvo el codPrincipioActivo.
	 * @return the codPrincipioActivo
	 */
	@Column
	public String getCodPrincipioActivo() {
		return codPrincipioActivo;
	}

	/**
	 * Establezco el codPrincipioActivo.
	 * @param cPrincipioActivo
	 *            the codPrincipioActivo to set
	 */
	public void setCodPrincipioActivo(final String cPrincipioActivo) {
		this.codPrincipioActivo = cPrincipioActivo;
	}

	/**
	 * Devuelvo el cantidad.
	 * @return the cantidad
	 */
	@Column
	public Float getCantidad() {
		return cantidad;
	}

	/**
	 * Establezco el cantidad.
	 * @param cant
	 *            the cantidad to set
	 */
	public void setCantidad(final Float cant) {
		this.cantidad = cant;
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
	public void setCodUnidades(final Integer codUnidades) {
		this.codUnidades = codUnidades;
	}

	/**
	 * Devuelvo las Unidades.
	 * @return the Unidades
	 */
	@Column
	public String getUnidades() {
		return unidades;
	}

	/**
	 * Establezco el codUnidades.
	 * @param uds
	 *            the unidades to set
	 */
	public void setUnidades(final String uds) {
		this.unidades = uds;
	}

	/**
	 * Devuelvo el suministroInmediato.
	 * @return the suministroInmediato
	 */
	@Column
	public char getSuministroInmediato() {
		return suministroInmediato;
	}

	/**
	 * Establezco el suministroInmediato.
	 * @param sumInmediato
	 *            the suministroInmediato to set
	 */
	public void setSuministroInmediato(final char sumInmediato) {
		this.suministroInmediato = sumInmediato;
	}

	/**
	 * Obtiene el valor del campo "fInicAdmin".
	 * @author tnevado
	 * @return El valor del campo "fInicAdmin".
	 */
	@Column(name = "FECHAINICIOADMINISTRACION")
	public Date getFechaInicioAdministracion() {
		return fechaInicioAdministracion;
	}

	/**
	 * Establece el valor del campo "fInicAdmin".
	 * @author tnevado
	 * @param inicAdmin
	 *            El valor del campo "fInicAdmin".
	 */
	public void setFechaInicioAdministracion(final Date inicAdmin) {
		fechaInicioAdministracion = inicAdmin;
	}

	/**
	 * Obtiene el valor del campo "fFinAdmin".
	 * @author tnevado
	 * @return El valor del campo "fFinAdmin".
	 */
	@Column(name = "FECHAFINADMINISTRACION")
	public Date getFechaFinAdministracion() {
		return fechaFinAdministracion;
	}

	/**
	 * Establece el valor del campo "fFinAdmin".
	 * @author tnevado
	 * @param finAdmin
	 *            El valor del campo "fFinAdmin".
	 */
	public void setFechaFinAdministracion(final Date finAdmin) {
		fechaFinAdministracion = finAdmin;
	}

	/**
	 * Obtiene el valor del campo "codViaAdmin".
	 * @author tnevado
	 * @return El valor del campo "codViaAdmin".
	 */
	@Column(name = "CODVIAADMINISTRACION")
	public Integer getCodViaAdmin() {
		return codViaAdmin;
	}

	/**
	 * Establece el valor del campo "codViaAdmin".
	 * @author tnevado
	 * @param cViaAdmin
	 *            El valor del campo "codViaAdmin".
	 */
	public void setCodViaAdmin(final Integer cViaAdmin) {
		this.codViaAdmin = cViaAdmin;
	}

	/**
	 * Obtiene el valor del campo "descViaAdmin".
	 * @author tnevado
	 * @return El valor del campo "descViaAdmin".
	 */
	@Column(name = "DESCVIAADMINISTRACION")
	public String getDescViaAdmin() {
		return descViaAdmin;
	}

	/**
	 * Establece el valor del campo "descViaAdmin".
	 * @author tnevado
	 * @param dViaAdmin
	 *            El valor del campo "descViaAdmin".
	 */
	public void setDescViaAdmin(final String dViaAdmin) {
		this.descViaAdmin = dViaAdmin;
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
	 * Obtiene el valor del campo "fuerza".
	 *
	 * @return El valor del campo "fuerza".
	 */
	@Column
	public Float getFuerza() {
		return fuerza;
	}

	/**
	 * Establece el valor del campo "fuerza".
	 *
	 * @param fuerza
	 *            El valor del campo "fuerza".
	 */
	public void setFuerza(Float fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * Obtiene el valor del campo "urlProspecto".
	 *
	 * @return El valor del campo "urlProspecto".
	 */
	@Column
	public String getUrlProspecto() {
		return urlProspecto;
	}

	/**
	 * Establece el valor del campo "urlProspecto".
	 *
	 * @param urlProspecto
	 *            El valor del campo "urlProspecto".
	 */
	public void setUrlProspecto(String urlProspecto) {
		this.urlProspecto = urlProspecto;
	}

//	/**
//	 * Obtiene el valor del campo "codUnidadesFuerza".
//	 *
//	 * @return El valor del campo "codUnidadesFuerza".
//	 */
//	@Column
//	public Integer getCodUnidadesFuerza() {
//		return codUnidadesFuerza;
//	}
//
//	/**
//	 * Establece el valor del campo "codUnidadesFuerza".
//	 *
//	 * @param codUnidadesFuerza
//	 *            El valor del campo "codUnidadesFuerza".
//	 */
//	public void setCodUnidadesFuerza(final Integer codUnidadesFuerza) {
//		this.codUnidadesFuerza = codUnidadesFuerza;
//	}
//
//	/**
//	 * Obtiene el valor del campo "unidadesFuerza".
//	 *
//	 * @return El valor del campo "unidadesFuerza".
//	 */
//	@Column
//	public String getUnidadesFuerza() {
//		return unidadesFuerza;
//	}
//
//	/**
//	 * Establece el valor del campo "unidadesFuerza".
//	 *
//	 * @param unidadesFuerza
//	 *            El valor del campo "unidadesFuerza".
//	 */
//	public void setUnidadesFuerza(String unidadesFuerza) {
//		this.unidadesFuerza = unidadesFuerza;
//	}

	/**
	 * Obtiene el valor del campo "frecuencia".
	 * @author tnevado
	 * @return El valor del campo "frecuencia".
	 */
	@Column
	public Float getFrecuencia() {
		return frecuencia;
	}

	/**
	 * Establece el valor del campo "frecuencia".
	 * @author tnevado
	 * @param frec
	 *            El valor del campo "frecuencia".
	 */
	public void setFrecuencia(final Float frec) {
		this.frecuencia = frec;
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
	 * Obtiene el valor del campo "tipoInfeccionAntibiotico".
	 * @author tnevado
	 * @return El valor del campo "tipoInfeccionAntibiotico".
	 */
	@Column
	public String getTipoInfeccionAntibiotico() {
		return tipoInfeccionAntibiotico;
	}

	/**
	 * Establece el valor del campo "tipoInfeccionAntibiotico".
	 * @author tnevado
	 * @param tipoInfecAntibiotico
	 *            El valor del campo "tipoInfeccionAntibiotico".
	 */
	public void setTipoInfeccionAntibiotico(final String tipoInfecAntibiotico) {
		this.tipoInfeccionAntibiotico = tipoInfecAntibiotico;
	}

	/**
	 * Obtiene el valor del campo "profilaxisAntibiotico".
	 * @author tnevado
	 * @return El valor del campo "profilaxisAntibiotico".
	 */
	@Column
	public String getProfilaxisAntibiotico() {
		return profilaxisAntibiotico;
	}

	/**
	 * Establece el valor del campo "profilaxisAntibiotico".
	 * @author tnevado
	 * @param profilaxisAntibio
	 *            El valor del campo "profilaxisAntibiotico".
	 */
	public void setProfilaxisAntibiotico(final String profilaxisAntibio) {
		this.profilaxisAntibiotico = profilaxisAntibio;
	}

	/**
	 * Obtiene el valor del campo "tipoTomaAntibiotico".
	 * @author tnevado
	 * @return El valor del campo "tipoTomaAntibiotico".
	 */
	@Column
	public String getTipoTomaAntibiotico() {
		return tipoTomaAntibiotico;
	}

	/**
	 * Establece el valor del campo "tipoTomaAntibiotico".
	 * @author tnevado
	 * @param tipoTomaAntibio
	 *            El valor del campo "tipoTomaAntibiotico".
	 */
	public void setTipoTomaAntibiotico(final String tipoTomaAntibio) {
		this.tipoTomaAntibiotico = tipoTomaAntibio;
	}

	/**
	 * Obtiene el valor del campo "terapeuticaAntibiotico".
	 * @author tnevado
	 * @return El valor del campo "terapeuticaAntibiotico".
	 */
	@Column
	public String getTerapeuticaAntibiotico() {
		return terapeuticaAntibiotico;
	}

	/**
	 * Establece el valor del campo "terapeuticaAntibiotico".
	 * @author tnevado
	 * @param terapeuticaAntibio
	 *            El valor del campo "terapeuticaAntibiotico".
	 */
	public void setTerapeuticaAntibiotico(final String terapeuticaAntibio) {
		this.terapeuticaAntibiotico = terapeuticaAntibio;
	}

	/**
	 * Obtiene el valor del campo "justificacionAntibiotico".
	 * @author tnevado
	 * @return El valor del campo "justificacionAntibiotico".
	 */
	@Column
	public String getJustificacionAntibiotico() {
		return justificacionAntibiotico;
	}

	/**
	 * Establece el valor del campo "justificacionAntibiotico".
	 * @author tnevado
	 * @param justificacionAntibio
	 *            El valor del campo "justificacionAntibiotico".
	 */
	public void setJustificacionAntibiotico(final String justificacionAntibio) {
		this.justificacionAntibiotico = justificacionAntibio;
	}

	/**
	 * Obtiene el valor del campo "observacionesRechazo".
	 * @author tnevado
	 * @return El valor del campo "observacionesRechazo".
	 */
	@Column
	public String getObservacionesRechazo() {
		return observacionesRechazo;
	}

	/**
	 * Establece el valor del campo "observacionesRechazo".
	 * @author tnevado
	 * @param obsRechazo
	 *            El valor del campo "observacionesRechazo".
	 */
	public void setObservacionesRechazo(final String obsRechazo) {
		this.observacionesRechazo = obsRechazo;
	}

	/**
	 * Obtiene el valor del campo "motivoRechazo".
	 * @author tnevado
	 * @return El valor del campo "motivoRechazo".
	 */
	/**
	 * @ManyToOne
	 * @JoinColumn(name = "CODMOTIVORECHAZO") public Motivo getMotivoRechazo() {
	 *                  return motivoRechazo; } /** Establece el valor del campo
	 *                  "motivoRechazo".
	 *
	 * @author tnevado
	 *
	 * @param motivoRechazo
	 *            El valor del campo "motivoRechazo".
	 */
	/**
	 * public void setMotivoRechazo(Motivo motivoRechazo) { this.motivoRechazo =
	 * motivoRechazo; } /** Obtiene el valor del campo "fechaHoraRechazo".
	 *
	 * @author tnevado
	 *
	 * @return El valor del campo "fechaHoraRechazo".
	 */
	@Column
	public Date getFechaHoraRechazo() {
		return fechaHoraRechazo;
	}

	/**
	 * Establece el valor del campo "fechaHoraRechazo".
	 * @author tnevado
	 * @param fHoraRechazo
	 *            El valor del campo "fechaHoraRechazo".
	 */
	public void setFechaHoraRechazo(final Date fHoraRechazo) {
		this.fechaHoraRechazo = fHoraRechazo;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraValidacion".
	 * @author tnevado
	 * @return El valor del campo "fechaHoraValidacion".
	 */
	@Column
	public Date getFechaHoraValidacion() {
		return fechaHoraValidacion;
	}

	/**
	 * Establece el valor del campo "fechaHoraValidacion".
	 * @author tnevado
	 * @param fHoraValidacion
	 *            El valor del campo "fechaHoraValidacion".
	 */
	public void setFechaHoraValidacion(final Date fHoraValidacion) {
		this.fechaHoraValidacion = fHoraValidacion;
	}



	/**
	 * Obtiene el valor del campo "fechaUltimaTomaPrevista".
	 *
	 * @return El valor del campo "FECHAULTIMATOMAPREVISTA".
	 */
	@Column(name = "FECHAHORAULTIMAADMINISTRACION")
	public Date getFechaUltimaTomaPrevista() {
		return fechaUltimaTomaPrevista;
	}

	/**
	 * Establece el valor del campo "fechaUltimaTomaPrevista".
	 *
	 * @param fUltimaTomaPrevista
	 *            El valor del campo "fechaUltimaTomaPrevista".
	 */
	public void setFechaUltimaTomaPrevista(final Date fUltimaTomaPrevista) {
		this.fechaUltimaTomaPrevista = fUltimaTomaPrevista;
	}

	/**
	 * Obtiene el valor del campo "fechaUltimaTomaPreparada".
	 *
	 * @return El valor del campo "fechaUltimaTomaPreparada".
	 */
	@Column(name = "FECHAHORAULTIMATOMAPREPARADA")
	public Date getFechaUltimaTomaPreparada() {
		return fechaUltimaTomaPreparada;
	}

	/**
	 * Establece el valor del campo "fechaUltimaTomaPreparada".
	 *
	 * @param fUltimaTomaPreparada
	 *            El valor del campo "fechaUltimaTomaPreparada".
	 */
	public void setFechaUltimaTomaPreparada(final Date fUltimaTomaPreparada) {
		this.fechaUltimaTomaPreparada = fUltimaTomaPreparada;
	}

	/**
	 * Obtiene el valor del campo "motivoRechazo".
	 * @return El valor del campo "motivoRechazo".
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODMOTIVORECHAZO")
	public Motivo getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * Establece el valor del campo "motivoRechazo".
	 * @param mRechazo
	 *            El valor del campo "motivoRechazo".
	 */
	public void setMotivoRechazo(final Motivo mRechazo) {
		this.motivoRechazo = mRechazo;
	}
	/**
	 * Obtiene el valor del campo "instrucciones".
	 *
	 * @return El valor del campo "instrucciones".
	 */
	@Column
	public String getInstrucciones() {
		return instrucciones;
	}

	/**
	 * Establece el valor del campo "instrucciones".
	 * @param instruc
	 *            El valor del campo "instrucciones".
	 */
	public void setInstrucciones(final String instruc) {
		this.instrucciones = instruc;
	}

	/**
	 * Obtiene el valor del campo "codPrescripcionPRE".
	 * @author cgromero
	 * @return El valor del campo "codPrescripcionPRE".
	 */
	@Column
	public Long getCodPrescripcionPRE() {
		return codPrescripcionPRE;
	}

	/**
	 * Establece el valor del campo "codPrescripcionPRE".
	 * @author cgromero
	 * @param cPrescripcionPRE
	 *            El valor del campo "codPrescripcionPRE".
	 */
	public void setCodPrescripcionPRE(final Long cPrescripcionPRE) {
		this.codPrescripcionPRE = cPrescripcionPRE;
	}
	/**
	 * Obtiene el valor del campo "estado".
	 * @author cgromero
	 * @return El valor del campo "estado".
	 */
	@Column(name = "ESTADOPRE")
	public Integer getEstado() {
		return estado;
	}

	/**
	 * Establece el valor del campo "estado".
	 * @author cgromero
	 * @param state
	 *            El valor del campo "estado".
	 */
	public void setEstado(final Integer state) {
		this.estado = state;
	}

	/**
	 * Obtiene el valor del campo "codPrescripcionPadre".
	 * @author cgromero
	 * @return El valor del campo "codPrescripcionPadre".
	 */
	@Column(name = "CODPRESCRIPCIONPADREPRE")
	public Long getCodPrescripcionPadre() {
		return codPrescripcionPadre;
	}

	/**
	 * Establece el valor del campo "codPrescripcionPadre".
	 * @author cgromero
	 * @param cPrescripcionPadre
	 *            El valor del campo "codPrescripcionPadre".
	 */
	public void setCodPrescripcionPadre(final Long cPrescripcionPadre) {
		this.codPrescripcionPadre = cPrescripcionPadre;
	}

	/**
	 * Obtiene el valor del campo "codPrescripcionOrigen".
	 * @return the codPrescripcionOrigen
	 */
	@Column(name = "CODPRESCRIPCIONORIGEN")
	public Long getCodPrescripcionOrigen() {
		return codPrescripcionOrigen;
	}

	/**
	 * Establece el valor del campo "codPrescripcionOrigen".
	 * @param cPrescripcionOrigen the codPrescripcionOrigen to set
	 */
	public void setCodPrescripcionOrigen(final Long cPrescripcionOrigen) {
		this.codPrescripcionOrigen = cPrescripcionOrigen;
	}

	/**
	 * Obtiene el valor del campo "descPrincipioActivo".
	 * @author cgromero
	 * @return El valor del campo "descPrincipioActivo".
	 */
	@Column
	public String getDescPrincipioActivo() {
		return descPrincipioActivo;
	}

	/**
	 * Establece el valor del campo "descPrincipioActivo".
	 * @author cgromero
	 * @param dPrincipioActivo
	 *            El valor del campo "descPrincipioActivo".
	 */
	public void setDescPrincipioActivo(final String dPrincipioActivo) {
		this.descPrincipioActivo = dPrincipioActivo;
	}

	/**
	 * Obtiene el valor del campo "pediatrico".
	 * @author cgromero
	 * @return El valor del campo "pediatrico".
	 */
	@Column
	public boolean isPediatrico() {
		return pediatrico;
	}

	/**
	 * Establece el valor del campo "pediatrico".
	 * @author cgromero
	 * @param pediatric
	 *            El valor del campo "pediatrico".
	 */
	public void setPediatrico(final boolean pediatric) {
		this.pediatrico = pediatric;
	}

	/**
	 * Obtiene el valor del campo "pautaVariable".
	 * @author cgromero
	 * @return El valor del campo "pautaVariable".
	 */
	@Column
	public String getPautaVariable() {
		return pautaVariable;
	}

	/**
	 * Establece el valor del campo "pautaVariable".
	 * @author cgromero
	 * @param pVariable
	 *            El valor del campo "pautaVariable".
	 */
	public void setPautaVariable(final String pVariable) {
		this.pautaVariable = pVariable;
	}

	/**
	 * Obtiene el valor del campo "perfil".
	 * @author cgromero
	 * @return El valor del campo "perfil".
	 */
	@Column
	public Integer getPerfil() {
		return perfil;
	}

	/**
	 * Establece el valor del campo "perfil".
	 * @author cgromero
	 * @param perf
	 *            El valor del campo "perfil".
	 */
	public void setPerfil(final Integer perf) {
		this.perfil = perf;
	}

	/**
	 * Obtiene el valor del campo "autorizado".
	 * @author cgromero
	 * @return El valor del campo "autorizado".
	 */
	@Column
	public boolean isAutorizado() {
		return autorizado;
	}

	/**
	 * Establece el valor del campo "autorizado".
	 * @author cgromero
	 * @param authorized
	 *            El valor del campo "autorizado".
	 */
	public void setAutorizado(final boolean authorized) {
		this.autorizado = authorized;
	}

	/**
	 * Obtiene el valor del campo "codProtocolo".
	 * @author cgromero
	 * @return El valor del campo "codProtocolo".
	 */
	@Column
	public String getCodProtocolo() {
		return codProtocolo;
	}

	/**
	 * Establece el valor del campo "codProtocolo".
	 * @author cgromero
	 * @param cProtocolo
	 *            El valor del campo "codProtocolo".
	 */
	public void setCodProtocolo(final String cProtocolo) {
		this.codProtocolo = cProtocolo;
	}

	/**
	 * Obtiene el valor del campo "modificable".
	 * @author cgromero
	 * @return El valor del campo "modificable".
	 */
	@Column
	public boolean isModificable() {
		return modificable;
	}

	/**
	 * Establece el valor del campo "modificable".
	 * @author cgromero
	 * @param modif
	 *            El valor del campo "modificable".
	 */
	public void setModificable(final boolean modif) {
		this.modificable = modif;
	}

	/**
	 * Obtiene el valor del campo "interaccion".
	 * @author cgromero
	 * @return El valor del campo "interaccion".
	 */
	@Column
	public boolean isInteraccion() {
		return interaccion;
	}

	/**
	 * Establece el valor del campo "interaccion".
	 * @author cgromero
	 * @param interac
	 *            El valor del campo "interaccion".
	 */
	public void setInteraccion(final boolean interac) {
		this.interaccion = interac;
	}

	/**
	 * Obtiene el valor del campo "interaccionPrincipiosActivos".
	 * @author cgromero
	 * @return El valor del campo "interaccionPrincipiosActivos".
	 */
	@Column(name = "InteraccionPrincipiosActivos")
	public String getInteraccionPrincipiosActivos() {
		return interaccionPrincipiosActivos;
	}

	/**
	 * Establece el valor del campo "interaccionPrincipiosActivos".
	 * @author cgromero
	 * @param interacPrincipiosActivos
	 *            El valor del campo "interaccionPrincipiosActivos".
	 */
	public void setInteraccionPrincipiosActivos(final String interacPrincipiosActivos) {
		this.interaccionPrincipiosActivos = interacPrincipiosActivos;
	}
	/**
	 * Obtiene el valor del campo "observacionesEnfermero".
	 * @return El valor del campo "observacionesEnfermero".
	 */
	@Column
	public String getObservacionesEnfermero() {
		return observacionesEnfermero;
	}

	/**
	 * Establece el valor del campo "observacionesEnfermero".
	 * @param obsEnfermero String
	 */
	public void setObservacionesEnfermero(final String obsEnfermero) {
		this.observacionesEnfermero = obsEnfermero;
	}

	/**
	 * Obtiene el valor del campo "descUsuarioCreacion".
	 *
	 * @return El valor del campo "descUsuarioCreacion".
	 */
    @Column
	public String getDescUsuarioCreacion() {
		return descUsuarioCreacion;
	}

	/**
	 * Establece el valor del campo "descUsuarioCreacion".
	 *
	 * @param dUsuarioCreacion
	 *            El valor del campo "descUsuarioCreacion".
	 */
	public void setDescUsuarioCreacion(final String dUsuarioCreacion) {
		this.descUsuarioCreacion = dUsuarioCreacion;
	}

	/**
	 * Obtiene el valor del campo "codUsuarioValidacion".
	 *
	 * @return El valor del campo "codUsuarioValidacion".
	 */
    @Column
	public String getCodUsuarioValidacion() {
		return codUsuarioValidacion;
	}

	/**
	 * Establece el valor del campo "codUsuarioValidacion".
	 *
	 * @param cUsuarioValidacion
	 *            El valor del campo "codUsuarioValidacion".
	 */
	public void setCodUsuarioValidacion(final String cUsuarioValidacion) {
		this.codUsuarioValidacion = cUsuarioValidacion;
	}

	/**
	 * Obtiene el valor del campo "descUsuarioValidacion".
	 *
	 * @return El valor del campo "descUsuarioValidacion".
	 */
	@Column
	public String getDescUsuarioValidacion() {
		return descUsuarioValidacion;
	}

	/**
	 * Establece el valor del campo "descUsuarioValidacion".
	 *
	 * @param dUsuarioValidacion
	 *            El valor del campo "descUsuarioValidacion".
	 */
	public void setDescUsuarioValidacion(final String dUsuarioValidacion) {
		this.descUsuarioValidacion = dUsuarioValidacion;
	}

	/**
	 * Obtiene el valor del campo "codUsuarioRechazo".
	 *
	 * @return El valor del campo "codUsuarioRechazo".
	 */
	@Column
	public String getCodUsuarioRechazo() {
		return codUsuarioRechazo;
	}

	/**
	 * Establece el valor del campo "codUsuarioRechazo".
	 *
	 * @param cUsuarioRechazo
	 *            El valor del campo "codUsuarioRechazo".
	 */
	public void setCodUsuarioRechazo(final String cUsuarioRechazo) {
		this.codUsuarioRechazo = cUsuarioRechazo;
	}



	/**
	 * Obtiene el valor del campo "descUsuarioUltimaModificacion".
	 *
	 * @return El valor del campo "descUsuarioUltimaModificacion".
	 */
	@Column
	public String getDescUsuarioUltimaModificacion() {
		return descUsuarioUltimaModificacion;
	}

	/**
	 * Establece el valor del campo "descUsuarioUltimaModificacion".
	 *
	 * @param dUsuarioUltimaModificacion
	 *            El valor del campo "descUsuarioUltimaModificacion".
	 */
	public void setDescUsuarioUltimaModificacion(final String dUsuarioUltimaModificacion) {
		this.descUsuarioUltimaModificacion = dUsuarioUltimaModificacion;
	}

	/**
	 * Obtiene el valor del campo "descUsuarioRechazo".
	 *
	 * @return El valor del campo "descUsuarioRechazo".
	 */
	@Column
	public String getDescUsuarioRechazo() {
		return descUsuarioRechazo;
	}

	/**
	 * Establece el valor del campo "descUsuarioRechazo".
	 *
	 * @param dUsuarioRechazo
	 *            El valor del campo "descUsuarioRechazo".
	 */
	public void setDescUsuarioRechazo(final String dUsuarioRechazo) {
		this.descUsuarioRechazo = dUsuarioRechazo;
	}
	/**
	 * Devuelve el valor del campo "numLote".
	 * @return the numLote
	 */
	@Column(name = "NLOTE")
	public String getNumLote() {
		return numLote;
	}

	/**
	 * Establece el valor del campo "numLote".
	 * @param nLote the numLote to set
	 */
	public void setNumLote(final String nLote) {
		this.numLote = nLote;
	}
	/**
	 * Obtiene el valor del campo "causaAnulacion".
	 *
	 * @return El valor del campo "causaAnulacion".
	 */
	@Column
	public String getCausaAnulacion() {
		return causaAnulacion;
	}

	/**
	 * Establece el valor del campo "causaAnulacion".
	 *
	 * @param causa
	 *            El valor del campo "causaAnulacion".
	 */
	public void setCausaAnulacion(final String causa) {
		this.causaAnulacion = causa;
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
	 * @param pautaAdm
	 *            El valor del campo "pauta".
	 */
	public void setPauta(final PautaAdministracion pautaAdm) {
		this.pauta = pautaAdm;
	}


	/**
	 * Getter de fechaInicioRecogida.
	 * @return the fechaInicioRecogida
	 */
	@Column (name = "FECHAPRIMERAENTREGA")
	public Date getFechaInicioRecogida() {
		return fechaInicioRecogida;
	}

	/**
	 * Setter de fechaInicioRecogida.
	 * @param fInicioRecogida the fechaInicioRecogida to set
	 */
	public void setFechaInicioRecogida(final Date fInicioRecogida) {
		this.fechaInicioRecogida = fInicioRecogida;
	}

	/**
	 * Getter de diasRecogida.
	 * @return the diasRecogida
	 */
	@Column (name = "DIASPERIODOENTREGA")
	public Integer getDiasRecogida() {
		return diasRecogida;
	}

	/**
	 * Setter de diasRecogida.
	 * @param dRecogida the diasRecogida to set
	 */
	public void setDiasRecogida(final Integer dRecogida) {
		this.diasRecogida = dRecogida;
	}

	/**
	 * Obtiene el valor del campo "codFormaFarma".
	 *
	 * @return El valor del campo "codFormaFarma".
	 */
	@Column
	public long getCodFormaFarma() {
		return codFormaFarma;
	}

	/**
	 * Establece el valor del campo "codFormaFarma".
	 *
	 * @param cFormaFarma
	 *            El valor del campo "codFormaFarma".
	 */
	public void setCodFormaFarma(final long cFormaFarma) {
		this.codFormaFarma = cFormaFarma;
	}

	/**
	 * Obtiene el valor del campo "descFormaFarma".
	 *
	 * @return El valor del campo "descFormaFarma".
	 */
	@Column
	public String getDescFormaFarma() {
		return descFormaFarma;
	}

	/**
	 * Establece el valor del campo "descFormaFarma".
	 *
	 * @param cFormaFarma
	 *            El valor del campo "descFormaFarma".
	 */
	public void setDescFormaFarma(final String descFormaFarma) {
		this.descFormaFarma = descFormaFarma;
	}

	/**
	 * Obtiene el valor del campo "noUnidosis".
	 *
	 * @return El valor del campo "noUnidosis".
	 */
	@Column
	public boolean isNoUnidosis() {
		return noUnidosis;
	}

	/**
	 * Establece el valor del campo "noUnidosis".
	 *
	 * @param noUnidose
	 *            El valor del campo "noUnidosis".
	 */
	public void setNoUnidosis(final boolean noUnidose) {
		this.noUnidosis = noUnidose;
	}

	/**
	 * Obtiene el valor del campo "fechaNecesitaReposicion".
	 *
	 * @return El valor del campo "fechaNecesitaReposicion".
	 */
	@Column
	public Date getFechaNecesitaReposicion() {
		return fechaNecesitaReposicion;
	}

	/**
	 * Establece el valor del campo "fechaNecesitaReposicion".
	 *
	 * @param fNecesitaReposicion
	 *            El valor del campo "fechaNecesitaReposicion".
	 */
	public void setFechaNecesitaReposicion(final Date fNecesitaReposicion) {
		this.fechaNecesitaReposicion = fNecesitaReposicion;
	}

	/**
	 * Obtiene el valor del campo "aporteHidrico".
	 *
	 * @return El valor del campo "aporteHidrico".
	 */
	@Column
	public boolean isAporteHidrico() {
		return aporteHidrico;
	}

	/**
	 * Establece el valor del campo "aporteHidrico".
	 *
	 * @param aporteHidric
	 *            El valor del campo "aporteHidrico".
	 */
	public void setAporteHidrico(final boolean aporteHidric) {
		this.aporteHidrico = aporteHidric;
	}

	/**
	 * Obtiene el valor del campo "codPosologiaPRE".
	 * @return the codPosologiaPRE
	 */
	@Column
	public Integer getCodPosologiaPRE() {
		return codPosologiaPRE;
	}

	/**
	 * Establece el valor del campo "codPosologiaPRE".
	 * @param cPosologiaPRE the codPosologiaPRE to set
	 */
	public void setCodPosologiaPRE(final Integer cPosologiaPRE) {
		this.codPosologiaPRE = cPosologiaPRE;
	}

	/**
	 * Obtiene el valor del campo "modoAdministracion".
	 * @return the modoAdministracion
	 */
	@Column
	public String getModoAdministracion() {
		return modoAdministracion;
	}

	/**
	 * Establece el valor del campo "modoAdministracion".
	 * @param modoAdmin the modoAdministracion to set
	 */
	public void setModoAdministracion(final String modoAdmin) {
		this.modoAdministracion = modoAdmin;
	}

	/**
	 * Obtiene el valor del campo "fechaHoraModificacionReposicion".
	 *
	 * @return El valor del campo "fechaHoraModificacionReposicion".
	 */
	@Column(name = "FECHAHORAMODIFICACIONREPOSICIO")
	public Date getFechaHoraModificacionReposicion() {
		return fechaHoraModificacionReposicion;
	}

	/**
	 * Establece el valor del campo "fechaHoraModificacionReposicion".
	 *
	 * @param fHoraModificacionReposicion
	 *            El valor del campo "fechaHoraModificacionReposicion".
	 */
	public void setFechaHoraModificacionReposicion(final Date fHoraModificacionReposicion) {
		this.fechaHoraModificacionReposicion = fHoraModificacionReposicion;
	}

	/**
	 * Obtiene el valor del campo "dosisModificable".
	 * @return El valor del campo "dosisModificable".
	 */
	@Column
	public boolean isDosisModificable() {
		return dosisModificable;
	}

	/**
	 * Establece el valor del campo "dosisModificable".
	 * @param dosisModificableNew
	 *            El valor del campo "dosisModificable".
	 */
	public void setDosisModificable(final boolean dosisModificableNew) {
		this.dosisModificable = dosisModificableNew;
	}

	/**
	 * Obtiene el valor del campo "codPrescOriginal".
	 *
	 * @return El valor del campo "codPrescOriginal".
	 */
	@Column
	public Long getCodPrescOriginal() {
		return codPrescOriginal;
	}

	/**
	 * Establece el valor del campo "codPrescOriginal".
	 *
	 * @param cPrescOriginal
	 *            El valor del campo "codPrescOriginal".
	 */
	public void setCodPrescOriginal(final Long cPrescOriginal) {
		this.codPrescOriginal = cPrescOriginal;
	}

//	/**
//	 * Obtiene el valor del campo "medicAlAlta".
//	 *
//	 * @return El valor del campo "medicAlAlta".
//	 */
//	@Column(name = "MEDALALTA")
//	public boolean isMedicAlAlta() {
//		return medicAlAlta;
//	}
//
//	/**
//	 * Establece el valor del campo "medicAlAlta".
//	 *
//	 * @param medAlAlta boolean
//	 *            El valor del campo "medicAlAlta".
//	 */
//	public void setMedicAlAlta(final boolean medAlAlta) {
//		this.medicAlAlta = medAlAlta;
//	}

//	/**
//	 * Obtiene el valor del campo "aplicarPautasFar".
//	 *
//	 * @return El valor del campo "aplicarPautasFar".
//	 */
//	@Column
//	public boolean isAplicarPautasFar() {
//		return aplicarPautasFar;
//	}
//
//	/**
//	 * Establece el valor del campo "aplicarPautasFar".
//	 *
//	 * @param aplicarPautasFar
//	 *            El valor del campo "aplicarPautasFar".
//	 */
//	public void setAplicarPautasFar(boolean aplicarPautasFar) {
//		this.aplicarPautasFar = aplicarPautasFar;
//	}

	/**
	 * HashCode.
	 * @author tnevado
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codMedicamento == null) ? 0 : codMedicamento.hashCode());
		result = prime * result + ((codPrescripcionPRE == null) ? 0 : codPrescripcionPRE.hashCode());
        result = prime * result + ((codPrescripcionPadre == null) ? 0 : codPrescripcionPadre.hashCode());
		return result;
	}

	/**
	 * Equals.
	 * @author tnevado
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PrescripcionMedicamento other = (PrescripcionMedicamento) obj;
		if (codMedicamento == null) {
			if (other.codMedicamento != null) {
				return false;
			}
		} else if (!codMedicamento.equals(other.codMedicamento)) {
			return false;
		}
		if (codPrescripcionPRE == null) {
			if (other.codPrescripcionPRE != null) {
				return false;
			}
		} else if (!codPrescripcionPRE.equals(other.codPrescripcionPRE)) {
			return false;
		}
		if (codPrescripcionPadre == null) {
			if (other.codPrescripcionPadre != null) {
				return false;
			}
		} else if (!codPrescripcionPadre.equals(other.codPrescripcionPadre)) {
			return false;
		}
		return true;
	}

	/**
	 *
	 * @param o PrescripcionMedicamento
	 * @return int
	 */
	public int compareTo(final PrescripcionMedicamento o) {
		int resultado = 0;
//		if (o != null && o.getCodMedicamento() != null) {
//			if (this.getCodMedicamento() != null) {
//				resultado = this.getCodMedicamento().compareTo(o.getCodMedicamento());
//			} else {
//				resultado = -1;
//			}
//		} else {
//			if (this.getCodMedicamento() != null) {
//				resultado = 1;
//			} else {
//				resultado = 0;
//			}
//		}
		if (resultado == 0) {
			if (o != null && o.getCodPrescripcionPRE() != null) {
				if (this.getCodPrescripcionPRE() != null) {
                    resultado = this.getCodPrescripcionPRE().compareTo(o.getCodPrescripcionPRE());
				} else {
					resultado = -1;
				}
			} else {
				if (this.getCodPrescripcionPRE() != null) {
					resultado = 1;
				} else {
					resultado = 0;
				}
			}
		}
		return resultado;
	}

	/**
	 *  toString.
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(">> Prescripción ");
		if (this.tipo != null) {
			sb.append(" tipo: " + this.tipo.intValue());
		} else {
			sb.append(" tipo: null");
		}
		sb.append(" codPrescripcionpre: " + this.codPrescripcionPRE);
		sb.append(" codPrescripcionpadrepre: " + this.codPrescripcionPadre);
		sb.append(" codPrescripcion: " + this.id);
		if (this.tratamiento == null) {
			sb.append(" codTratamiento: null ");
		} else {
			sb.append(" codTratamiento: " + this.tratamiento.getId());
		}
		sb.append(" fechaInicio: "
				+ this.fechaInicioAdministracion.toString());
		if (this.fechaFinAdministracion == null) {
			sb.append(" fechaFin: null ");
		} else {
			sb.append(" fechaFin: "
					+ this.fechaFinAdministracion.toString());
		}
		if (this.fechaHoraValidacion == null) {
			sb.append(" fechaValidacion: null ");
		} else {
			sb.append(" fechaValidacion: "
					+ this.fechaHoraValidacion.toString());
		}
		if (this.fechaHoraRechazo == null) {
			sb.append(" fechaRechazo: null ");
		} else {
			sb.append(" fechaRechazo: "
					+ this.fechaHoraRechazo.toString());
		}
		sb.append(" cantidad: " + this.cantidad);
		if (this.frecuencia == null) {
			sb.append(" frecuencia: null ");
		} else {
			sb.append(" frecuencia: " + this.frecuencia.toString());
		}		
		sb.append(" noUnidosis: " + this.noUnidosis);
		if (this.fechaNecesitaReposicion == null) {
			sb.append(" fechaNecesitaRepo: null ");
		} else {
			sb.append(" fechaNecesitaRepo: "
					+ this.fechaNecesitaReposicion.toString());
		}
		sb.append(" activo: " + this.isActivo());
		sb.append(" codMedicamento: " + this.codMedicamento);
		sb.append(" descMedicamento: " + this.descMedicamento);
		if (this.pauta == null) {
			sb.append(" codPauta: null ");
		} else {
			sb.append(" codPauta: " + this.pauta.getId());
		}
		sb.append(" aporteHidrico: " + this.aporteHidrico);
		if (this.fechaUltimaTomaPrevista == null) {
			sb.append(" fUltTomaPrev: null ");
		} else {
			sb.append(" fUltTomaPrev: "
					+ this.fechaUltimaTomaPrevista.toString());
		}
		if (compuestos != null
				&& !compuestos.isEmpty()) {
			sb.append("Compuestos: " + compuestos.toString());
		}
		if (tramosPosologia != null
				&& !tramosPosologia.isEmpty()) {
			sb.append("TramosPosologia: " + tramosPosologia.toString());
		}
		return sb.toString();
	}
	/**
	 * Indica si una prescripción es de tipo suministro inmediato.
	 * @return boolean
	 */
	public  boolean esSumInmediato() {
		boolean ret = false;
		if (this.suministroInmediato == INMEDIATO_PRIMERA_TOMA
				|| this.suministroInmediato == INMEDIATO_UNICA_TOMA) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Indica si una prescripción es de tipo suministro inmediato de unica toma.
	 * @return boolean
	 */
	public  boolean esSumInmediatoUnaVez() {
		boolean ret = false;
		if (this.suministroInmediato == INMEDIATO_UNICA_TOMA) {
			ret = true;
		}
		return ret;
	}
	//Metodos de fluidos
	/**
	 * Fin nuevos campos v06.00
	 */
	/**
	 * Obtiene el valor del campo "compuestos".
	 *
	 * @return El valor del campo "compuestos".
	 */
	@OneToMany(mappedBy = "prescripcion")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST, CascadeType.EVICT, CascadeType.MERGE})
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("base desc")
	public List<CompuestoMultimedicamento> getCompuestos() {
		return compuestos;
	}

	/**
	 * Establece el valor del campo "compuestos".
	 *
	 * @param compuestos
	 *            El valor del campo "compuestos".
	 */
	public void setCompuestos(List<CompuestoMultimedicamento> compuestos) {
		this.compuestos = compuestos;
	}
	/**
	 * Obtiene el valor del campo "codUnidadContenedora".
	 *
	 * @return El valor del campo "codUnidadContenedora".
	 */
	@Column
	public Integer getCodUnidadContenedora() {
		return codUnidadContenedora;
	}

	/**
	 * Establece el valor del campo "codUnidadContenedora".
	 *
	 * @param codUnidadContenedora
	 *            El valor del campo "codUnidadContenedora".
	 */
	public void setCodUnidadContenedora(final Integer codUnidadContenedora) {
		this.codUnidadContenedora = codUnidadContenedora;
	}
	/**
	 * Obtiene el valor del campo "unidadContenedora".
	 *
	 * @return El valor del campo "unidadContenedora".
	 */
	@Column
	public String getUnidadContenedora() {
		return unidadContenedora;
	}
	/**
	 * Establece el valor del campo "unidadContenedora".
	 *
	 * @param unidadContenedora
	 *            El valor del campo "unidadContenedora".
	 */
	public void setUnidadContenedora(final String unidadContenedora) {
		this.unidadContenedora = unidadContenedora;
	}

	/**
	 * Obtiene el valor del campo "presentacion".
	 *
	 * @return El valor del campo "presentacion".
	 */
	@Column
	public boolean isPresentacion() {
		return presentacion;
	}

	/**
	 * Establece el valor del campo "presentacion".
	 *
	 * @param presentacion
	 *            El valor del campo "presentacion".
	 */
	public void setPresentacion(final boolean presentacion) {
		this.presentacion = presentacion;
	}

	/**
	 * Obtiene el valor del campo "velocidad".
	 *
	 * @return El valor del campo "velocidad".
	 */
	@Column
	public Float getVelocidad() {
		return velocidad;
	}

	/**
	 * Establece el valor del campo "velocidad".
	 *
	 * @param velocidad
	 *            El valor del campo "velocidad".
	 */
	public void setVelocidad(final Float velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * Obtiene el valor del campo "volumen".
	 *
	 * @return El valor del campo "volumen".
	 */
	@Column
	public Float getVolumen() {
		return volumen;
	}

	/**
	 * Establece el valor del campo "volumen".
	 *
	 * @param volumen
	 *            El valor del campo "volumen".
	 */
	public void setVolumen(final Float volumen) {
		this.volumen = volumen;
	}

	/**
	 * Obtiene el valor del campo "volumenTotal".
	 *
	 * @return El valor del campo "volumenTotal".
	 */
	@Column
	public Float getVolumenTotal() {
		return volumenTotal;
	}

	/**
	 * Establece el valor del campo "volumenTotal".
	 *
	 * @param volumenTotal
	 *            El valor del campo "volumenTotal".
	 */
	public void setVolumenTotal(Float volumenTotal) {
		this.volumenTotal = volumenTotal;
	}

	/**
	 * Obtiene el valor del campo "tiempo".
	 *
	 * @return El valor del campo "tiempo".
	 */
	@Column
	public Float getTiempo() {
		return tiempo;
	}

	/**
	 * Establece el valor del campo "tiempo".
	 *
	 * @param tiempo
	 *            El valor del campo "tiempo".
	 */
	public void setTiempo(final Float tiempo) {
		this.tiempo = tiempo;
	}
	/**
	 * Obtiene el valor del campo "tramosPosologia".
	 *
	 * @return El valor del campo "tramosPosologia".
	 */
	@OneToMany(mappedBy = "prescripcionMedicamento")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.PERSIST, CascadeType.EVICT, CascadeType.MERGE })
	@Fetch(FetchMode.SUBSELECT)
	@Sort(type = SortType.NATURAL)
	public SortedSet<TramoPosologia> getTramosPosologia() {
		return tramosPosologia;
	}

	/**
	 * Establece el valor del campo "tramosPosologia".
	 *
	 * @param lineasPosologia
	 *            El valor del campo "tramosPosologia".
	 */
	public void setTramosPosologia(SortedSet<TramoPosologia> tramosPosologia) {
		this.tramosPosologia = tramosPosologia;
	}
	

	/**
	 * @param tramo TramoPosologia.
	 * @return boolean
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addTramoPosologia(TramoPosologia tramo) {
		if (tramo != null) {
			tramo.setPrescripcionMedicamento(this);
		}
		return tramosPosologia.add(tramo);
	}

	/**
	 * @param tramo TramoPosologia.
	 * @return boolean
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean removeTramoPosologia(TramoPosologia tramo) {
		if (tramo != null) {
			tramo.setPrescripcionMedicamento(null);
		}
		return tramosPosologia.remove(tramo);
	}

	/**
	 * Obtiene el valor del campo "fluidoSinContinuidad".
	 *
	 * @return El valor del campo "fluidoSinContinuidad".
	 */
	@Column
	public boolean isFluidoSinContinuidad() {
		return fluidoSinContinuidad;
	}

	/**
	 * Establece el valor del campo "fluidoSinContinuidad".
	 *
	 * @param fluidoSinContinuidad
	 *            El valor del campo "fluidoSinContinuidad".
	 */
	public void setFluidoSinContinuidad(boolean fluidoSinContinuidad) {
		this.fluidoSinContinuidad = fluidoSinContinuidad;
	}

	/**
	 * @param e CompuestoMultimedicamento
	 * @return
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addCompuesto(CompuestoMultimedicamento e) {
		if (e != null) {
			e.setPrescripcion(this);
		}
		return getCompuestos().add(e);
	}

	/**
	 * @see java.util.Set#clear()
	 */
	public void clearCompuestos() {
		getCompuestos().clear();
	}

	/**
	 * @param o CompuestoMultimedicamento
	 * @return
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean removeCompuesto(CompuestoMultimedicamento o) {
		if (o != null) {
			o.setPrescripcion(null);
		}
		return getCompuestos().remove(o);
	}

	/**
	 * Obtiene el valor del campo "observEnfermeroEnArabe"
	 * @return El valor del campo "observEnfermeroEnArabe"
	 */
	@Column(name = "OBSVENFERMEROARABE")
	public boolean isObservEnfermeroEnArabe() {
		return observEnfermeroEnArabe;
	}

	/**
	 * Establece el valor del campo "observEnfermeroEnArabe"
	 * @param observEnfermeroEnArabe El valor del campo "observEnfermeroEnArabe"
	 */
	public void setObservEnfermeroEnArabe(boolean observEnfermeroEnArabe) {
		this.observEnfermeroEnArabe = observEnfermeroEnArabe;
	}

	/**
	 * Obtiene el valor del campo "instruccionesEnArabe"
	 * @return El valor del campo "instruccionesEnArabe"
	 */
	@Column(name = "INSTRUCCIONESARABE")
	public boolean isInstruccionesEnArabe() {
		return instruccionesEnArabe;
	}

	/**
	 * Establece el valor del campo "instruccionesEnArabe"
	 * @param instruccionesEnArabe El valor del campo "instruccionesEnArabe"
	 */
	public void setInstruccionesEnArabe(boolean instruccionesEnArabe) {
		this.instruccionesEnArabe = instruccionesEnArabe;
	}

	/**
	 * Obtiene el valor del campo "pautaVariableEnArabe"
	 * @return El valor del campo "pautaVariableEnArabe"
	 */
	@Column(name = "PAUTAVARIABLEARABE")
	public boolean isPautaVariableEnArabe() {
		return pautaVariableEnArabe;
	}

	/**
	 * Establece el valor del campo "pautaVariableEnArabe"
	 * @param pautaVariableEnArabe El valor del campo "pautaVariableEnArabe"
	 */
	public void setPautaVariableEnArabe(boolean pautaVariableEnArabe) {
		this.pautaVariableEnArabe = pautaVariableEnArabe;
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
						&& getCodUnidades().intValue()
						!= getCodUnidadContenedora().intValue()) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Obtiene la cantidad de medicamento de una prescripción en unidad contenedora
	 *  si se dan las condiciones, si no en unidad prescrita.
	 *  Para fluidos devuelve el volumen correspondiente a una mezcla
	 *   para el volumen del envase del diluyente.
	 *  Si es una prescripción con posología variable devuelve -1
	 *   ya que la posología se especifica en las lineas de cada tramo.
	 *
	 * @return float
	 */
	public final DosisAdminVO obtenerDosisAdministracion() {
		DosisAdminVO dosis = null;
		float cant = -1;
		if (!esPosologiaVariable()) {
			if (esFluido()) {
				if (volumenTotal == null) {
					//Version anterior de fluidos sin compuestos.
					if (usarUnidadContenedora()) {
						cant = getCantidad().floatValue()
								/ getFuerza().floatValue();
						dosis = new DosisAdminVO(
								cant, getCodUnidadContenedora()
								, getUnidadContenedora());
					} else {
						cant = getCantidad().floatValue();
						dosis = new DosisAdminVO(
								cant, getCodUnidades()
								, getUnidades());
					}
				} else {
//					dosis = new DosisAdminVO(
//							volumenTotal, null
//							, MensajesUtil.getMensaje("ml"
//							, MensajesUtil.getLocale("es_ES")));
				}
			} else {
				if (usarUnidadContenedora()) {
					//Si las uidades prescritas y las contenedoras no coinciden se emplea
					//la fuerza para obtener la equivalencia en unidad contenedora
					cant = getCantidad().floatValue()
							/ getFuerza().floatValue();
					dosis = new DosisAdminVO(
							cant, getCodUnidadContenedora()
							, getUnidadContenedora());
				} else {
					if (getCantidad() != null) {
						cant = getCantidad().floatValue();
					}
					dosis = new DosisAdminVO(
							cant, getCodUnidades()
							, getUnidades());
				}
			}
		}
		return dosis;
	}
	/**
	 * Obtiene la cantidad de medicamento de una prescripción en unidad contenedora
	 *  si se dan las condiciones, si no en unidad prescrita.
	 *  Si es una prescripción con posología variable devuelve -1
	 *   ya que la posología se especifica en las lineas de cada tramo.
	 *
	 * @return float
	 */
	public DosisAdminVO obtenerDosisAdministracionCompuesto(final Integer codCompuesto) {
		DosisAdminVO dosis = null;
		float cant = -1;
		CompuestoMultimedicamento comp = obtenerCompuesto(codCompuesto);
		if (comp != null) {
			if (comp.usarUnidadContenedora()) {
				//Si las uidades prescritas y las contenedoras no coinciden se emplea
				//la fuerza para obtener la equivalencia en unidad contenedora
				cant = obtenerCantAditivoUnidadContenedora(codCompuesto);
				dosis = new DosisAdminVO(
						cant, comp.getCodUnidadContenedora().intValue()
						, comp.getUnidadContenedora());
			} else {
				cant = obtenerCantAditivo(codCompuesto);				
				dosis = new DosisAdminVO(
						cant, comp.getCodUnidades().intValue()
						, comp.getUnidades());
			}
		}
		
		return dosis;
	}
	
	/**
	 * devuelve la cantidad de mezcla por toma de un fluido.
	 * @return float.
	 */
	public float obtenerCantidadTomaFluido() {
		float cantidad = 0F;
		if (getVolumenTotal() != null && getVolumenTotal().floatValue() > 0) {
			cantidad = obtenerVolMezclaEnvaseDiluyente(); 
		 } else {
			 cantidad = getCantidad();
		 }
		return cantidad;
	}
	
	/**
	 * Volumen de la mezcla correspondiente a lo generado al mezclar una unidad de envase
	 *  de diluyente con los demas compuestos en las proporciones prescritas.
	 * @return float.
	 */
	public float obtenerVolMezclaEnvaseDiluyente() {
		float volumen = 0F;
		float volumenTotalMezcla = obtenerVolumenTotalMezcla();
		CompuestoMultimedicamento diluyente = obtenerDiluyente();
		if (diluyente != null) {
			volumen = (diluyente.getVolumen() * volumenTotalMezcla)/diluyente.getCantidad();
		}
		return volumen;
	}

	/**
	 * Devuelve la cantidad de diluyente en la mezcla.
	 * Debe ser igual a volumentotal - (la suma de volumenes de aditivos).
	 * @return float.
	 */
	public float obtenerCantidadDiluyente() {
		float ret = 0;
		if (getCompuestos() != null
				&& !getCompuestos().isEmpty()) {
			for (CompuestoMultimedicamento comp : getCompuestos()) {
				if (comp.isBase()) {
					ret = comp.getCantidad();
					break;
				}
			}
		} else if (getVolumenTotal() != null) {
			ret = getVolumenTotal();
		} else {
			ret = this.getCantidad();
		}
		return ret;
	}
	/**
	 * Devuelve la cantidad de diluyente en unidad contenedora necesaria en el volumen de mezcla indicado.
	 * @return float.
	 */
	public float obtenerCantDiluyenteVolMezcla(float volMezcla) {
		float ret = 0;
		float cantidadMezcla = 0;
		if (getVolumenTotal() != null) {
			cantidadMezcla = this.getVolumenTotal();
		} else {
			cantidadMezcla = this.getCantidad();
		}
		if (cantidadMezcla > 0F) {
			ret = ((Double) Math.ceil(volMezcla/cantidadMezcla)).intValue();
		}
		return ret;
	}
	
	
	/**
	 * Devuelve el volumen de la unidad prescrita de diluyente.
	 * @return float.
	 */
	public float obtenerVolumenEnvaseDiluyente() {
		float ret = 0;
		if (getCompuestos() != null
				&& !getCompuestos().isEmpty()) {
			for (CompuestoMultimedicamento comp : getCompuestos()) {
				if (comp.isBase()) {
					ret = comp.getVolumen();
					break;
				}
			}
		} else {
			ret = getVolumenTotal();
		}
		return ret;
	}
	
	/**
	 * Devuelve la cantidad de aditivo por unidad de envase de diluyente.
	 * @return float.
	 */
	public float obtenerCantAditivo(Integer codCompuesto) {
		float ret = 0;
		float cantidadDiluyente = obtenerCantidadDiluyente();
		float volumenEnvaseDiluyente = obtenerVolumenEnvaseDiluyente();
		if (codCompuesto != null && codCompuesto.intValue() > 0) {
			if (getCompuestos() != null
					&& !getCompuestos().isEmpty()) {
				for (CompuestoMultimedicamento comp : getCompuestos()) {
					if (comp.getId() != null
						&& codCompuesto.intValue() == comp.getId().intValue()) {
						ret = (volumenEnvaseDiluyente*comp.getCantidad())/cantidadDiluyente;
					}
				}
			}
		}		
		return ret;
	}
	/**
	 * Devuelve la cantidad de aditivo por unidad de envase de diluyente.
	 * @return float.
	 */
	public float obtenerCantAditivoVolMezcla(Integer codCompuesto, float volMezcla) {
		float ret = 0;
		//Cantidad de aditivo por unidad de envase de diluyente.
		float cantidadAditivo = obtenerCantAditivo(codCompuesto);
		//Cantidad de unidades de envase de diluyente en el volumen de mezcla indicado.
		float cantDiluyenteVol = obtenerCantDiluyenteVolMezcla(volMezcla);
		if (cantidadAditivo > 0F) {
			ret = cantDiluyenteVol * cantidadAditivo;
		}		
		return ret;
	}
	/**
	 * Devuelve la cantidad de aditivo por unidad de envase de diluyente.
	 * Si no se especifica la unidad contenedora o la fuerza devuelve -1.
	 * @return float.
	 */
	public float obtenerCantAditivoUnidadContenedora(Integer codCompuesto) {
		float ret = 0;
		float cantidadDiluyente = obtenerCantidadDiluyente();
		float volumenEnvaseDiluyente = obtenerVolumenEnvaseDiluyente();
		CompuestoMultimedicamento comp = obtenerCompuesto(codCompuesto);
		if (comp != null) {
			ret = (volumenEnvaseDiluyente*comp.getCantidad())/cantidadDiluyente;
			if (comp.getUnidadContenedora() != null
				&& comp.getFuerza() != null
				&& comp.getFuerza().floatValue() > 0F) {
				ret = ret/comp.getFuerza();
			} else {
				ret = -1;
			}
		}		
		return ret;
	}
	/**
	 * Devuelve la duración de la mezcla de un fluido a partir de lo prescrito,
	 *  sin tener en cuenta productos seleccionados.
	 * @param presc
	 * @return
	 */
	public float obtenerDuracionDosisTotal() {
		float ret = 0f;
		float tiempoAdministracion = getTiempo();
		float dosisTotalPrescrita = getVolumen();
		float dosisTotal = this.getVolumenTotal();
		if (tiempoAdministracion > 0f) {
			if (dosisTotalPrescrita > 0f) {
				ret = (dosisTotal * tiempoAdministracion)/dosisTotalPrescrita;
			}
		}
		return ret;
	}
	/**
	 * Devuelve la frecuencia que le corresponde a un fluido en función
	 *  de los datos prescritos (Volumen, Tiempo y cantidad y volumen del diluyente).
	 * @return float.
	 */
	public float obtenerFrecuenciaFluido() {
		float frec = 0F;
		if (getFrecuencia() != null) {
			frec = getFrecuencia();
		}
		if (getTiempo() != null) {
			frec = getTiempo();
		}
		if (!esIgualVolumenVolumenTotal()) {
			//VolumenTotal != Volumen
			frec = obtenerDuracionDosisTotal();
		}
		if (!esIgualCantidadVolumenDiluyente()) {
			//cantidad != volumen en el diluyente.
			CompuestoMultimedicamento comp = obtenerDiluyente();
			if (comp != null) {
				frec = (comp.getVolumen()*frec)/comp.getCantidad();
			}
		}
		return frec;
	}
	/**
	 * Indica si el campo volumen es igual al volumenTotal.
	 * @return boolean
	 */
	public boolean esIgualVolumenVolumenTotal() {
		boolean ret = false;
		ret = (getVolumen() != null
				&& getVolumenTotal() != null
				&& getVolumen().equals(getVolumenTotal()));
		return ret;
	}
	/**
	 * Indica si la cantidad de diluyente en la mezcla coincide con el volumen real del envase del diluyente.
	 * @param presc
	 * @return
	 */
	public boolean esIgualCantidadVolumenDiluyente() {
		boolean ret = false;
		CompuestoMultimedicamento comp = obtenerDiluyente();
		if (comp != null) {
			ret = (comp.getCantidad() != null
					&& comp.getVolumen() != null
					&& comp.getCantidad().equals(comp.getVolumen()));
		}
		return ret;
	}
	
	/**
	 * Devuelve la dosis total de la suma de los compuestos prescritos.
	 * @return float.
	 */
	private float obtenerVolumenTotalMezcla() {
		float volTotal = this.getVolumenTotal();
		return volTotal;
	}
	/**
	 * Indica si la prescripcion es un fluido.
	 * @return boolean
	 */
	public boolean esFluido() {
		boolean ret = false;
		if (this.getTipo() != null && this.getTipo().intValue() == TIPO_FLUIDO) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Indica si la prescripcion es un fluido.
	 * @return boolean
	 */
	public boolean esProtocolo() {
		boolean ret = false;
		if (this.getTipo() != null && this.getTipo().intValue() == TIPO_PROTOCOLO) {
			ret = true;
		}
		return ret;
	}
	
	/**
	 * Indica si la prescripcion es de tipo posología variable.
	 * @return boolean
	 */
	public boolean esPosologiaVariable() {
		boolean ret = false;
		if (getTramosPosologia() != null && !getTramosPosologia().isEmpty()) {
			ret = true;
		}
		return ret;
	}
	
	/**
	 * Indica si la prescripcion es de tipo posología variable.
	 * @return boolean
	 */
	public boolean esPosVarFrecuenciaMesesDias() {
		boolean ret = false;
		if (getTramosPosologia() != null && !getTramosPosologia().isEmpty()) {
			for (TramoPosologia tramoAux : getTramosPosologia()) {
				if (tramoAux.esPosVarFrecuenciaMesesDias()) {
					ret = true;
					break;
				}
			}
		}
		return ret;
	}
	
	
	/**
	 * Indica si la prescripcion es un fluido.
	 * @return boolean
	 */
	public boolean esPrescNormal() {
		boolean ret = false;
		if (this.getTipo() != null && this.getTipo().intValue() == TIPO_NORMAL) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Indica si la prescripcion es una formula magistral.
	 * @return
	 */
	public boolean esFormulaMagistral() {
		boolean ret = false;
		if (this.getCodMedicamento() != null && this.getCodMedicamento().longValue() > 0L
				&& this.getCodMedicamento().longValue() < 10L) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Devuelve el minimo de las fechas de inicio de los tramos de posologia variable si los tiene.
	 * Si tramosPosologia es null o esta vacia devuelve null
	 * @return Date.
	 */
	public Date obtenerMinFechaTramos() {
		Date ret = null;
		if (this.getTramosPosologia() != null
				&& !this.getTramosPosologia().isEmpty()) {
			for (TramoPosologia tramo : this.getTramosPosologia()) {
				if (ret == null
					|| (tramo.getFechaInicio() != null
					&& ret.after(tramo.getFechaInicio()))) {
					ret = tramo.getFechaInicio();
				}
			}
		}
		return ret;
	}
	/**
	 * Devuelve el compuesto con el id indicado.
	 * @param codCompuesto Integer.
	 * @return CompuestoMultimedicamento.
	 */
	public CompuestoMultimedicamento obtenerCompuesto(Integer codCompuesto) {
		CompuestoMultimedicamento ret = null;
		if (codCompuesto != null && codCompuesto.intValue() > 0
				&& getCompuestos() != null && !getCompuestos().isEmpty()) {
			for (CompuestoMultimedicamento comp : getCompuestos()) {
				if (comp.getId() != null
						&& comp.getId().intValue()
						== codCompuesto.intValue()) {
					ret = comp;
					break;
				}
			}
		}		
		return ret;
	}
	/**
	 * Devuelve el diluyente de la mezcla.
	 * @return CompuestoMultimedicamento
	 */
	public CompuestoMultimedicamento obtenerDiluyente() {
		CompuestoMultimedicamento ret = null;
		if (getCompuestos() != null && !getCompuestos().isEmpty()) {
			for (CompuestoMultimedicamento comp : getCompuestos()) {
				if (comp.isBase()) {
					ret = comp;
					break;
				}
			}
		}		
		return ret;
	}
	
	@Column
	public boolean isFluidoSinFrecAdm() {
		return fluidoSinFrecAdm;
	}

	public void setFluidoSinFrecAdm(
			boolean fluidoSinFrecAdm) {
		this.fluidoSinFrecAdm = fluidoSinFrecAdm;
	}
	
	/**
	 * Indica el numero máximo de tomas por día.
	 * @return int
	 */
	public int maxTomasPorDia() {
		int ret = 0;
		if (esSumInmediatoUnaVez()) {
			ret = 1;
		} else {
			if (getTramosPosologia() != null
					&& !getTramosPosologia().isEmpty()) {
				int iAux = 0;
				int maxActual = 0;
				//En caso de posología variable nos quedamos con el tramo con mayor numero de tomas.
				for (TramoPosologia tramo : getTramosPosologia()) {
					iAux = tramo.maxTomasPorDia();
					if (maxActual < iAux) {
						maxActual = iAux;
					}
				}
				ret = maxActual;
			} else {
				if (getPauta() != null && getPauta().isActivo()){
					//generación por pauta.
					if (getPauta().obtenerHorasPauta() != null && !getPauta().obtenerHorasPauta().isEmpty()) {
						ret = getPauta().obtenerHorasPauta().size();
					}				
				} else if (getFrecuencia() != null
						&& getFrecuencia().floatValue() > 0f) {
					//generación por frecuencia.
					if (getTipoUnidadFrecuencia() == UNIDAD_FREC_HORAS) {
						ret = new Double(Math.ceil(HORAS_POR_DIA/getFrecuencia().floatValue())).intValue();					
					} else if (getTipoUnidadFrecuencia() == UNIDAD_FREC_MINUTOS) {
						ret = new Double(Math.ceil(MINUTOS_POR_DIA/getFrecuencia().floatValue())).intValue();
					} else if (getTipoUnidadFrecuencia() == UNIDAD_FREC_SEGUNDOS) {
						ret = new Double(Math.ceil(SEGUNDOS_POR_DIA/getFrecuencia().floatValue())).intValue();
					} else if (getTipoUnidadFrecuencia() == UNIDAD_FREC_MESES) {
						//Frecuencia en meses el máximo de tomas en un dia es 1.
						ret = 1;
					} else if (getTipoUnidadFrecuencia() == UNIDAD_FREC_DIAS) {
						//Frecuencia en meses el máximo de tomas en un dia es 1.
						ret = 1;
					}				
				}
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
		if (getTipoUnidadFrecuencia() == UNIDAD_FREC_HORAS
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
		if (getTipoUnidadFrecuencia() == UNIDAD_FREC_MESES) {
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
		if (getTipoUnidadFrecuencia() == UNIDAD_FREC_DIAS) {
			ret = true;
		}
		return ret;
	}

	public boolean esFrecuenciaMinutos() {
		boolean ret = false;
		if (getTipoUnidadFrecuencia() == UNIDAD_FREC_MINUTOS) {
			ret = true;
		}
		return ret;
	}

	public boolean esFrecuenciaSegundos() {
		boolean ret = false;
		if (getTipoUnidadFrecuencia() == UNIDAD_FREC_SEGUNDOS) {
			ret = true;
		}
		return ret;
	}
}
