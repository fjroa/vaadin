package es.indra.hlf.vaadin.isfar.ui.header;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

public class Header extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HorizontalLayout cabecera;
	private HorizontalLayout menuPrincipal;
	private HorizontalLayout barraHerramientas;
	
	public Header() {
		
		// Cabecera
		cabecera = new IsfarCabecera();
		cabecera.setHeight(40, Unit.PIXELS);
		cabecera.setWidth(100, Unit.PERCENTAGE);
		cabecera.setStyleName("cabecera");


		// menuPrincipal
		menuPrincipal = new IsfarMenuPrincipal();
		menuPrincipal.setHeight(22, Unit.PIXELS);
		menuPrincipal.setWidth(100, Unit.PERCENTAGE);
		menuPrincipal.setStyleName("menuPrincipal");

		// barraHerramientas
		barraHerramientas = new ContactToolBar();
		barraHerramientas.setHeight(30, Unit.PIXELS);
		barraHerramientas.setWidth(100, Unit.PERCENTAGE);
		barraHerramientas.setStyleName("barraHerramientas");

		this.addComponents(cabecera, menuPrincipal, barraHerramientas);
		this.setSpacing(false);
		
	}

	public HorizontalLayout getCabecera() {
		return cabecera;
	}

	public void setCabecera(HorizontalLayout cabecera) {
		this.cabecera = cabecera;
	}

	public HorizontalLayout getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(HorizontalLayout menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public HorizontalLayout getBarraHerramientas() {
		return barraHerramientas;
	}

	public void setBarraHerramientas(HorizontalLayout barraHerramientas) {
		this.barraHerramientas = barraHerramientas;
	}
	
	
}
