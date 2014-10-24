/**
 *  29/10/2013
 */
package es.indra.hlf.vaadin.isfar.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Preparación de medicación para tomas cuando se realiza desde Farmacia externa.
 */
@Entity
@Table(name = "PREPARACION_TOMA")
public class PreparacionFarExterna  implements Serializable {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id String.
	 */
	private String id;
	/**
	 * codPrescripcionPre long.
	 */
	private long codPrescripcionPre;
	/**
	 * codPrescOriginal long.
	 */
	private long codPrescOriginal;
	/**
	 * fechaAdministracion Date.
	 */
	private Date fechaAdministracion;
	/**
	 * orden int.
	 */
	private int orden;
	/**
	 * bloquea boolean.
	 */
	private boolean bloquea;
	/**
	 * administracionPrescripcion AdministracionPrescripcion.
	 */
	private AdministracionPrescripcion administracionPrescripcion;
	/**
	 * productos Set<ProductoFarExterna>.
	 */
	private Set<ProductoFarExterna> productos = new HashSet<ProductoFarExterna>();
	/**
	 * Obtiene el valor del campo "id".
	 *
	 * @return El valor del campo "id".
	 */
	@Id
	@Column(name = "CODPREPARACIONTOMA")
	public String getId() {
		return id;
	}
	/**
	 * Establece el valor del campo "id".
	 *
	 * @param ident
	 *            El valor del campo "id".
	 */
	public void setId(final String ident) {
		this.id = ident;
	}
	/**
	 * Obtiene el valor del campo "codPrescripcionPre".
	 *
	 * @return El valor del campo "codPrescripcionPre".
	 */
	@Column
	public long getCodPrescripcionPre() {
		return codPrescripcionPre;
	}
	/**
	 * Establece el valor del campo "codPrescripcionPre".
	 *
	 * @param codPrescPre
	 *            El valor del campo "codPrescripcionPre".
	 */
	public void setCodPrescripcionPre(final long codPrescPre) {
		this.codPrescripcionPre = codPrescPre;
	}
	/**
	 * Obtiene el valor del campo "codPrescOriginal".
	 *
	 * @return El valor del campo "codPrescOriginal".
	 */
	@Column
	public long getCodPrescOriginal() {
		return codPrescOriginal;
	}
	/**
	 * Establece el valor del campo "codPrescOriginal".
	 *
	 * @param codPrescOriginal
	 *            El valor del campo "codPrescOriginal".
	 */
	public void setCodPrescOriginal(long codPrescOriginal) {
		this.codPrescOriginal = codPrescOriginal;
	}
	/**
	 * Obtiene el valor del campo "fechaAdministracion".
	 *
	 * @return El valor del campo "fechaAdministracion".
	 */
	@Column
	public Date getFechaAdministracion() {
		return fechaAdministracion;
	}
	/**
	 * Establece el valor del campo "fechaAdministracion".
	 *
	 * @param fechaAdm
	 *            El valor del campo "fechaAdmiistracion".
	 */
	public void setFechaAdministracion(final Date fechaAdm) {
		this.fechaAdministracion = fechaAdm;
	}
	/**
	 * Obtiene el valor del campo "orden".
	 *
	 * @return El valor del campo "orden".
	 */
	@Column
	public int getOrden() {
		return orden;
	}
	/**
	 * Establece el valor del campo "orden".
	 *
	 * @param orden
	 *            El valor del campo "orden".
	 */
	public void setOrden(final int ord) {
		this.orden = ord;
	}
	
	/**
	 * Obtiene el valor del campo "bloquea".
	 *
	 * @return El valor del campo "bloquea".
	 */
	@Column
	public boolean isBloquea() {
		return bloquea;
	}
	/**
	 * Establece el valor del campo "bloquea".
	 *
	 * @param bloquea
	 *            El valor del campo "bloquea".
	 */
	public void setBloquea(boolean bloquea) {
		this.bloquea = bloquea;
	}
	/**
	 * Obtiene el valor del campo "administracionPrescripcion".
	 *
	 * @return El valor del campo "administracionPrescripcion".
	 */
	@ManyToOne
    @JoinColumn(name = "CODADMINISTRACIONPRESCRIPCION")
	public AdministracionPrescripcion getAdministracionPrescripcion() {
		return administracionPrescripcion;
	}
	/**
	 * Establece el valor del campo "administracionPrescripcion".
	 *
	 * @param admPrescripcion
	 *            El valor del campo "admPrescripcion".
	 */
	public void setAdministracionPrescripcion(final AdministracionPrescripcion admPrescripcion) {
		this.administracionPrescripcion = admPrescripcion;
	}
	/**
	 * Obtiene el valor del campo "productos".
	 *
	 * @return El valor del campo "productos".
	 */
	@OneToMany(mappedBy = "preparacion")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE
    	, CascadeType.PERSIST, CascadeType.EVICT, CascadeType.DELETE_ORPHAN })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id asc")
	public Set<ProductoFarExterna> getProductos() {
		return productos;
	}
	/**
	 * Establece el valor del campo "productos".
	 *
	 * @param prods
	 *            El valor del campo "productos".
	 */
	public void setProductos(final Set<ProductoFarExterna> prods) {
		this.productos = prods;
	}
	/**
	 * Anade un producto.
	 * @param prod ProductoFarExterna
	 * @return boolean
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean addProducto(ProductoFarExterna prod) {
		prod.setPreparacion(this);
		return productos.add(prod);
	}
	/**
	 * Anade productos al campo productos.
	 * @param prods Collection&lt;? extends ProductoFarExterna&gt;
	 * @return boolean
	 * @see java.util.Set#addAll(java.util.Collection)
	 */
	public boolean addProductos(Collection<? extends ProductoFarExterna> prods) {
		boolean ret = false;
		if (prods != null && !prods.isEmpty()) {
			for (ProductoFarExterna prod : prods) {
				if (addProducto(prod)) {
					ret = true;
				}
			}
		}
		return ret;
	}
	/**
	 * Quita un producto del campo productos.
	 * @param prod ProductoFarExterna
	 * @return boolean
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean removeProducto(ProductoFarExterna prod) {
		prod.setPreparacion(null);
		return productos.remove(prod);
	}
	/**
	 * @param prods Collection&lt;? extends ProductoFarExterna&gt;
	 * @return boolean
	 */
	public boolean removeProductos(Collection<? extends ProductoFarExterna> prods) {
		boolean ret = false;
		if (prods != null && !prods.isEmpty()) {
			for (ProductoFarExterna prod : prods) {
				if (removeProducto(prod)) {
					ret = true;
				}
			}
		}
		return ret;
	}

}
