package es.indra.hlf.vaadin.isfar.ui.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;
import org.vaadin.spring.i18n.I18N;

import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@VaadinComponent
@UIScope
public class EstadoSearch extends VerticalLayout {

	private Button refresh;
	private Button add;

	@Autowired
	I18N i18n;

	public EstadoSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init() {
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
		refresh = new Button(i18n.get("contact.refrescar", null, getLocale()),
				new Button.ClickListener() {
					@Override
					public void buttonClick(Button.ClickEvent event) {
						// refresh();
					}
				});
		// toolbar.addComponent(refresh);

		add = new Button(i18n.get("contact.nuevo", null, getLocale()) + "...",
				new Button.ClickListener() {
					@Override
					public void buttonClick(Button.ClickEvent event) {
						// addWindow(new NewContactWindow());
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
	}

}
