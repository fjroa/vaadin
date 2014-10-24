package es.indra.hlf.vaadin.isfar.ui.footer;


import javax.annotation.PostConstruct;

import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
@UIScope
@VaadinComponent
public class Footer extends VerticalLayout {
	
	class Separator extends Label {

		private static final long serialVersionUID = 1L;

		Separator() {
			super("|", ContentMode.TEXT);
		}
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	protected void init() {
		HorizontalLayout footerText = new HorizontalLayout();
		footerText.setSpacing(true);
		footerText.addComponent(new Label("HOSPITAL NAME"));
		footerText.addComponent(new Separator());
		footerText.addComponent(new Label("HEALTH NETWORK"));
		footerText.addComponent(new Separator());
		footerText.addComponent(new Label("INDRA FOR HEALTH"));

		this.addComponent(footerText);
		this.setExpandRatio(footerText, 1.0f);
		this.setHeight(20, Unit.PIXELS);
		this.setWidth(100, Unit.PERCENTAGE);
		this.setStyleName("footer");
	}
}
