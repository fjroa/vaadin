package es.indra.hlf.vaadin.isfar.ui.header;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@UIScope
@VaadinComponent
public class Header extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private HorizontalLayout isfarCabecera;
	@Autowired
	private HorizontalLayout isfarMenuPrincipal;
	@Autowired
	private HorizontalLayout isfarToolBar;
	
	@PostConstruct
	protected void init() {
		
		// Cabecera
		isfarCabecera.setHeight(40, Unit.PIXELS);
		isfarCabecera.setWidth(100, Unit.PERCENTAGE);
		isfarCabecera.setStyleName("cabecera");


		// menuPrincipal
		isfarMenuPrincipal.setHeight(22, Unit.PIXELS);
		isfarMenuPrincipal.setWidth(100, Unit.PERCENTAGE);
		isfarMenuPrincipal.setStyleName("menuPrincipal");

		// barraHerramientas
		isfarToolBar.setHeight(30, Unit.PIXELS);
		isfarToolBar.setWidth(100, Unit.PERCENTAGE);
		isfarToolBar.setStyleName("barraHerramientas");

		this.addComponents(isfarCabecera, isfarMenuPrincipal, isfarToolBar);
		this.setSpacing(false);
		
	}

	public HorizontalLayout getCabecera() {
		return isfarCabecera;
	}

	public void setCabecera(HorizontalLayout cabecera) {
		this.isfarCabecera = cabecera;
	}

	public HorizontalLayout getMenuPrincipal() {
		return isfarMenuPrincipal;
	}

	public void setMenuPrincipal(HorizontalLayout menuPrincipal) {
		this.isfarMenuPrincipal = menuPrincipal;
	}

	public HorizontalLayout getBarraHerramientas() {
		return isfarToolBar;
	}

	public void setBarraHerramientas(HorizontalLayout barraHerramientas) {
		this.isfarToolBar = barraHerramientas;
	}
	
	
}
