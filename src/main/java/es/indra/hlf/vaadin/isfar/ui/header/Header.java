package es.indra.hlf.vaadin.isfar.ui.header;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;


public class Header extends VerticalLayout {
	public Header() {
		// TODO Auto-generated constructor stub
		HorizontalLayout cabecera = new HorizontalLayout();
        cabecera.setHeight(40, Unit.PIXELS);
        ThemeResource resource = new ThemeResource("img/logo.png");
        cabecera.addComponent(new Image("", resource));
        HorizontalLayout menuPrincipal = new HorizontalLayout();
        menuPrincipal.setHeight(22, Unit.PIXELS);
        HorizontalLayout barraHerramientas = new HorizontalLayout();
        barraHerramientas.setHeight(30, Unit.PIXELS);
        this.addComponents(cabecera, menuPrincipal, barraHerramientas);
	}
}
