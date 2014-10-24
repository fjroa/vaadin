package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase de dominio para la entidad Paciente.
 * @author INDRA
 */
@Entity
@Table(name = "PACIENTE")
@SequenceGenerator(name = "SEQ_PACIENTE", sequenceName = "SEQ_PACIENTE", allocationSize = 1)
public class Paciente implements Serializable {
    /**
     * Identificador de la clase.
     */
    private static final long serialVersionUID = 1413724746116552069L;
    /**
     * Constante para designar a pacientes de sexo masculino.
     * SEXO_MASCULINO char.
     */
    public static final char SEXO_MASCULINO = 'H';
    /**
     * Constante para designar a pacientes de sexo femenino.
     * SEXO_FEMENINO char.
     */
    public static final char SEXO_FEMENINO = 'M';
    /**
     * Constante para designar a pacientes de sexo indefinido.
     * SEXO_INDEFINIDO char.
     */
    public static final char SEXO_INDEFINIDO = 'I';

    /**
     * Codigo del paciente.
     */
    private Integer id;

    /**
     * Codigo del tipo de documento identificativo.
     */
    private String codTipoDocumento;

    /**
     * Descripcion de dicho tipo de documento.
     */
    private String descTipoDocumento;

    /**
     * Numero del documento identificativo.
     */
    private String numDocumento;

    /**
     * Codigo de la nacionalidad del paciente.
     */
	private String codNacionalidad;

    /**
     * Nombre del paciente.
     */
    private String nombrePaciente;

    /**
     * nombrePadre String.
     */
    private String nombrePadre;
    /**
     * nombreAbuelo String.
     */
    private String nombreAbuelo;
    /**
     * nombreFamilia String.
     */
    private String nombreFamilia;

    /**
     * Fecha del nacimiento del paciente.
     */
    private Date fechaNacimiento;

    /**
     * Sexo del paciente 'H'-Hombre, 'M'-Mujer.
     */
    private char sexo;

    /**
     * Pasivo.
     */
    private boolean pasivo;

    /**
     * Codigo del Sistema de Salud.
     */
    private Integer codSistemaSalud;

    /**
     * Descripcion del Sistema de Salud.
     */
    private String descSistemaSalud;

    /**
     * Numero de Beneficiario.
     */
    private String numBeneficiario;

    /**
     * Indicativo de tutor.
     */
    private boolean tutor;

    /**
     * idSRRU Codigo propio del modulo SRRU.
     */
    private String idSRRU;

    /**
     * Numero Nacional de Paciente (MRN).
     */
    private String numNacionalUtente;

    /**
     * Peso del Paciente.
     */
    private Float peso;

    /**
     * Superficie Corporal del Paciente.
     */
    private Float superficieCorporal;

    /**
     * Talla del Paciente.
     */
    private Float talla;

    /**
     * Inidica si el paciente es o no pediatrico.
     */
    private boolean pediatrico;

    /**
     * Codigo del bloque.
     */
	private String codBloque;
	

      /*************/
     /** METODOS **/
    /*************/

    /**
     * Constructor.
     *
     * @param codPaciente Integer
     */
    public Paciente(Integer codPaciente) {
        super();
        this.id = codPaciente;
    }

    /**
     * Constructor por defecto.
     */
    public Paciente() {
        super();
    }

    /**
     * Devuelvo el codPaciente.
     *
     * @return the codPaciente
     */
    @Basic
    @Id
    @Column(name = "CODPACIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PACIENTE")
    public Integer getId() {
        return id;
    }

    /**
     * Establezco el codPaciente.
     *
     * @param codPaciente the codPaciente to set
     */
    public void setId(Integer codPaciente) {
        this.id = codPaciente;
    }

    /**
     * Devuelvo el codTipoDocumento.
     *
     * @return the codTipoDocumento
     */
    @Basic
    @Column(name = "CODTIPODOCUMENTO")
    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    /**
     * Establezco el codTipoDocumento.
     *
     * @param codTipoDocumento the codTipoDocumento to set
     */
    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    /**
     * Devuelvo el descTipoDocumento.
     *
     * @return the descTipoDocumento
     */
    @Basic
    @Column(name = "DESCTIPODOCUMENTO", length = 80)
    public String getDescTipoDocumento() {
        return descTipoDocumento;
    }

    /**
     * Establezco el descTipoDocumento.
     *
     * @param descTipoDocumento the descTipoDocumento to set
     */
    public void setDescTipoDocumento(String descTipoDocumento) {
        this.descTipoDocumento = descTipoDocumento;
    }

    /**
     * Devuelvo el numDocumento.
     *
     * @return the numDocumento
     */
    @Basic
    @Column(name = "NUMDOCUMENTO", length = 25)
    public String getNumDocumento() {
        return numDocumento;
    }

    /**
     * Establezco el numDocumento.
     *
     * @param numDocumento the numDocumento to set
     */
    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    /**
     * Obtiene el valor del campo "codNacionalidad".
     * @return the codNacionalidad
     */
    @Basic
	@Column(name = "CODNACIONALIDAD")
    public String getCodNacionalidad() {
        return codNacionalidad;
    }

    /**
     * Establece el valor del campo "codNacionalidad".
     * @param codNacionalidad the codNacionalidad to set
     */
    public void setCodNacionalidad(String codNacionalidad) {
        this.codNacionalidad = codNacionalidad;
    }

    /**
     * Devuelvo el nombrePaciente.
     *
     * @return the nombrePaciente
     */
    @Basic
    @Column(name = "NOMBREPACIENTE", length = 80)
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * Establezco el nombrePaciente.
     *
     * @param nombrePaciente the nombrePaciente to set
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
	 * Obtiene el valor del campo "nombrePadre".
	 *
	 * @return El valor del campo "nombrePadre".
	 */
	 @Column(name = "NOMBREPADRE", length = 80)
	public String getNombrePadre() {
		return nombrePadre;
	}

	/**
	 * Establece el valor del campo "nombrePadre".
	 *
	 * @param nombrePadre
	 *            El valor del campo "nombrePadre".
	 */
	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	/**
	 * Obtiene el valor del campo "nombreAbuelo".
	 *
	 * @return El valor del campo "nombreAbuelo".
	 */
	 @Column(name = "NOMBREABUELO", length = 80)
	public String getNombreAbuelo() {
		return nombreAbuelo;
	}

	/**
	 * Establece el valor del campo "nombreAbuelo".
	 *
	 * @param nombreAbuelo
	 *            El valor del campo "nombreAbuelo".
	 */
	public void setNombreAbuelo(String nombreAbuelo) {
		this.nombreAbuelo = nombreAbuelo;
	}

	/**
	 * Obtiene el valor del campo "nombreFamilia".
	 *
	 * @return El valor del campo "nombreFamilia".
	 */
	 @Column(name = "NOMBREFAMILIA", length = 80)
	public String getNombreFamilia() {
		return nombreFamilia;
	}

	/**
	 * Establece el valor del campo "nombreFamilia".
	 *
	 * @param nombreFamilia
	 *            El valor del campo "nombreFamilia".
	 */
	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	/**
     * Devuelvo el fechaNacimiento.
     *
     * @return the fechaNacimiento
     */
    @Basic
    @Column(name = "FECHANACIMIENTO")
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establezco el fechaNacimiento.
     *
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelvo el sexo.
     *
     * @return the sexo
     */
    @Basic
    @Column(name = "SEXO", length = 1)
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el valor del campo "sexo".
     *
     * @param sexo El valor del campo "sexo".
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * Devuelvo el codigo del sistema de salud.
     *
     * @return the codSistemaSalud
     */
    @Basic
    @Column(name = "CODSISTEMASALUD")
    public Integer getCodSistemaSalud() {
        return codSistemaSalud;
    }

    /**
     * Establezco el codigo del sistema de salud.
     *
     * @param codSistemaSalud the codSistemaSalud to set
     */
    public void setCodSistemaSalud(Integer codSistemaSalud) {
        this.codSistemaSalud = codSistemaSalud;
    }

    /**
     * Devuelvo la descripcion del sistema de salud.
     *
     * @return the descSistemaSalud
     */
    @Basic
    @Column(name = "DESCSISTEMASALUD", length = 255)
    public String getDescSistemaSalud() {
        return descSistemaSalud;
    }

    /**
     * Establezco la descripcion del sistema de salud.
     *
     * @param descSistemaSalud the descSistemaSalud to set
     */
    public void setDescSistemaSalud(String descSistemaSalud) {
        this.descSistemaSalud = descSistemaSalud;
    }

    /**
     * Devuelvo el numero de Beneficiario.
     *
     * @return numBeneficio
     */
    @Basic
    @Column(name = "NUMBENEFICIARIO", length = 80)
    public String getNumBeneficiario() {
        return numBeneficiario;
    }

    /**
     * Establezco el numero de Beneficiario.
     *
     * @param numBeneficiario the numBeneficiario to set
     */
    public void setNumBeneficiario(String numBeneficiario) {
        this.numBeneficiario = numBeneficiario;
    }

    /**
     * Devuelvo el tutor.
     *
     * @return tutor
     */
    @Basic
    @Column(name = "TUTOR")
    public boolean isTutor() {
        return tutor;
    }

    /**
     * Establezco el tutor.
     *
     * @param tutor the tutor to set
     */
    public void setTutor(boolean tutor) {
        this.tutor = tutor;
    }

    /**
     * Devuelvo el ID_SRRU.
     *
     * @return ID_SRRU
     */
    @Basic
    @Column(name = "ID_SRRU")
    public String getIdSRRU() {
        return idSRRU;
    }

    /**
     * Establezco el ID_SRRU.
     *
     * @param idSRRU the idSRRU to set
     */
    public void setIdSRRU(String idSRRU) {
        this.idSRRU = idSRRU;
    }

    /**
     * Devuelvo el NUMNACIONALUTENTE.
     *
     * @return numNacionalUtente
     */
    @Basic
    @Column(name = "NNACIONALUTENTE")
    public String getNumNacionalUtente() {
        return numNacionalUtente;
    }

    /**
     * Establezco el NUMNACIONALUTENTE.
     *
     * @param numNacionalUtente the numNacionalUtente to set
     */
    public void setNumNacionalUtente(String numNacionalUtente) {
        this.numNacionalUtente = numNacionalUtente;
    }

    /**
     * Delvuelvo el peso.
     *
     * @return peso
     */
    @Basic
    @Column(name = "PESO")
    public Float getPeso() {
        return peso;
    }

    /**
     * Establezco el peso.
     *
     * @param peso the peso to set
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     * Delvuelvo la superficieCorporal.
     *
     * @return superficieCorporal
     */
    @Basic
    @Column(name = "SUPERFICIECORPORAL")
    public Float getSuperficieCorporal() {
        return superficieCorporal;
    }

    /**
     * Establezco la superficieCorporal.
     *
     * @param superficieCorporal the superficieCorporal to set
     */
    public void setSuperficieCorporal(Float superficieCorporal) {
        this.superficieCorporal = superficieCorporal;
    }

    /**
     * Delvuelvo la talla.
     *
     * @return talla
     */
    @Basic
    @Column(name = "TALLA")
    public Float getTalla() {
        return talla;
    }

    /**
     * Establezco la talla.
     *
     * @param talla the talla to set
     */
    public void setTalla(Float talla) {
        this.talla = talla;
    }

    /**
     * Devuelvo el serialVersionUID.
     *
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Obtiene el valor del campo "pasivo".
     *
     * @author cgromero
     * @return El valor del campo "pasivo".
     */
    @Column(name = "PASIVO")
    public boolean isPasivo() {
        return pasivo;
    }

    /**
     * Establece el valor del campo "pasivo".
     *
     * @author cgromero
     * @param pasivo El valor del campo "pasivo".
     */
    public void setPasivo(boolean pasivo) {
        this.pasivo = pasivo;
    }

    /**
     * Obtiene el valor del campo "pediatrico".
     *
     * @author cgromero
     * @return El valor del campo "pediatrico".
     */
    @Basic
    @Column(name = "PEDIATRICO")
    public boolean isPediatrico() {
        return pediatrico;
    }

    /**
     * Establece el valor del campo "pediatrico".
     *
     * @author cgromero
     * @param pediatrico El valor del campo "pediatrico".
     */
    public void setPediatrico(boolean pediatrico) {
        this.pediatrico = pediatrico;
    }

    /**
     * Obtiene el valor del campo "codBloque".
     * @return the codBloque
     */
    @Basic
    @Column(name = "CODBLOQUE")
    public String getCodBloque() {
        return codBloque;
    }

    /**
     * Establece el valor del campo "codBloque".
     * @param codBloque the codBloque to set
     */
    public void setCodBloque(String codBloque) {
        this.codBloque = codBloque;
    }
    
    /**
     * Attribute codUsuarioAuditoria.
     */
    private String codUsuarioAuditoria; //NOPMD

    /**
     * Devuelve el valor de codUsuarioAuditoria.
     * @return the codUsuarioAuditoria
     */
    @Column(name = "USER_AUDIT")
    public String getCodUsuarioAuditoria() {
        return codUsuarioAuditoria;
    }
    /**
     * Modifica el valor de codUsuarioAuditoria.
     * @param codUsuarioAuditoriaValue a asignar
     */
    public void setCodUsuarioAuditoria(final String codUsuarioAuditoriaValue) { //NOPMD
        this.codUsuarioAuditoria = codUsuarioAuditoriaValue;
    }

    /**
     * Devuelve una cadena con el nombre completo del paciente.
     * @return String
     */
    @Transient
    public String getNombreCompleto() {
    	StringBuffer ret = new StringBuffer();
    	int tieneContenido = 0;
    	if (this.nombrePaciente != null && !"".equals(this.nombrePaciente)) {
    		ret.append(this.nombrePaciente);
    		tieneContenido++;
    	}
    	if (this.nombrePadre != null && !"".equals(this.nombrePadre)) {
    		if (tieneContenido > 0) {
    			ret.append(" ");
    		}
    		ret.append(this.nombrePadre);
    		tieneContenido++;
    	}
    	if (this.nombreAbuelo != null && !"".equals(this.nombreAbuelo)) {
    		if (tieneContenido > 0) {
    			ret.append(" ");
    		}
    		ret.append(this.nombreAbuelo);
    		tieneContenido++;
    	}
    	if (this.nombreFamilia != null && !"".equals(this.nombreFamilia)) {
    		if (tieneContenido > 0) {
    			ret.append(" ");
    		}
    		ret.append(this.nombreFamilia);
    		tieneContenido++;
    	}
    	return ret.toString();
    }
    /** Metodo toString
	 * @return String
	 */
    @Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("CodTipoDocumento: " +  getCodTipoDocumento() + " DescTipoDocumento: " + getDescTipoDocumento());
		sb.append(" NumDocumento: " + getNumDocumento() + " CodNacionalidad: " + getCodNacionalidad());
		sb.append(" nombrePadre: " + getNombrePadre() + " nombreAbuelo: " + getNombreAbuelo() 
				+ " nombreFamilia: " + getNombreFamilia());
		sb.append(" Nombre Paciente: " + getNombrePaciente() + " Fecha Nacimiento: " + getFechaNacimiento());
		sb.append(" Sexo: " + getSexo() + " Pasivo: " + isPasivo());
		sb.append(" NumBeneficiario: " + getNumBeneficiario() + " CodSistemaSalud: " + getCodSistemaSalud());
		sb.append(" DescSistemaSalud: " + getDescSistemaSalud() + " Tutor: " + isTutor() + " Id_SRRU: " + getIdSRRU());
		sb.append(" Peso: " + getPeso() + " Talla: " + getTalla() + " Superficie Corporal: " + getSuperficieCorporal());
		sb.append(" Pediatrico: " + isPediatrico() + " CodBloque: " + getCodBloque());
		
		return sb.toString();
	}
}
