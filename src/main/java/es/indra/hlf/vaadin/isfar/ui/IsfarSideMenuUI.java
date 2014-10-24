package es.indra.hlf.vaadin.isfar.ui;

import javax.annotation.PostConstruct;

import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@UIScope
@VaadinComponent
public class IsfarSideMenuUI extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	protected void init() {
		Accordion accordion = new Accordion();
		accordion.setSizeFull();

		// Some components to put in the Accordion.
		Label l1 = new Label("There are no previously saved actions.");
		Label l2 = new Label("There are no saved notes.");
		Label l3 = new Label("There are currently no issues.");
		// Add the components as tabs in the Accordion.
		accordion.addTab(l1, "Saved actions", null);
		accordion.addTab(l2, "Notes", null);
		accordion.addTab(l3, "Issues", null);

		addComponent(accordion);
		setExpandRatio(accordion, 1f);
	}
}
