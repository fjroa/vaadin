package es.indra.hlf.vaadin.isfar.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import es.indra.hlf.vaadin.isfar.repository.ContactRepository;
import es.indra.hlf.vaadin.isfar.ui.ContactUI.NewContactWindow;

public class ContactSearchUI extends VerticalLayout{

	private Button refresh;
	private Button add;
	
	ContactRepository repository;
	MessageSource messageSource;
	
	public ContactSearchUI(IsfarUI parent) {
		
		messageSource = parent.getMessageSource();
		repository = parent.getRepository();
		
		Panel panel = new Panel("Búsqueda");
		panel.setSizeFull(); // Shrink to fit content
		addComponent(panel);
		
		// A FormLayout used outside the context of a Form
		FormLayout fl = new FormLayout();
		// Make the FormLayout shrink to its contents
		fl.setSizeFull();
		TextField tf = new TextField("A Field");
		fl.addComponent(tf);
		// Mark the first field as required
		tf.setRequired(true);
		tf.setRequiredError("The Field may not be empty.");
		
		TextField tf2 = new TextField("Another Field");
		fl.addComponent(tf2);
		refresh = new Button(messageSource.getMessage("contact.refrescar",
				null, getLocale()), new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				//refresh();
			}
		});
		// toolbar.addComponent(refresh);

		add = new Button(messageSource.getMessage("contact.nuevo", null,
				getLocale()) + "...", new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				//addWindow(new NewContactWindow());
			}
		});
		
		HorizontalLayout botonera = new HorizontalLayout();
		botonera.addComponent(refresh);
		botonera.addComponent(add);
		
		botonera.setSpacing(true);
		fl.addComponent(botonera);
		// Set the second field straing to error state with a message.
		tf2.setComponentError(new UserError(
				"This is the error indicator of a Field."));
		panel.setContent(fl);
		
		setVisible(false);
	}
}
