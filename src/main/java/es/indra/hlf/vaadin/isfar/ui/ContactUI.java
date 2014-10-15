package es.indra.hlf.vaadin.isfar.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

import es.indra.hlf.vaadin.isfar.model.Contact;
import es.indra.hlf.vaadin.isfar.repository.ContactRepository;

public class ContactUI extends VerticalLayout{
	
	ContactRepository repository;
	MessageSource messageSource;
	
	private BeanItemContainer<Contact> contactsContainer;
	private Table contactsTable;
	private Button search;
	
	public ContactUI(final IsfarUI parent) {
		messageSource = parent.getMessageSource();
		repository = parent.getRepository();
		HorizontalLayout principal = new HorizontalLayout();
		principal.setSizeFull();

		Label title = new Label(messageSource.getMessage("contact.titulo",
				null, getLocale()));
		title.addStyleName(Reindeer.LABEL_H1);
		principal.addComponent(title);

		contactsContainer = new BeanItemContainer<>(Contact.class);

		contactsTable = new Table();
		contactsTable.setSizeFull();
		contactsTable.setContainerDataSource(contactsContainer);
		contactsTable.setVisibleColumns("firstName", "lastName", "email");
		contactsTable.setColumnHeader("firstName",
				messageSource.getMessage("contact.nombre", null, getLocale()));
		contactsTable
				.setColumnHeader("lastName", messageSource.getMessage(
						"contact.apellido", null, getLocale()));
		contactsTable.setColumnHeader("email",
				messageSource.getMessage("contact.email", null, getLocale()));
		principal.addComponent(contactsTable);

		final VerticalLayout toolbar = new VerticalLayout();
		toolbar.setSpacing(false);
		toolbar.setMargin(false);
		toolbar.setWidth(22, Unit.PIXELS);
		toolbar.setHeight("100%");
		search = new Button("", new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				if (parent.getContenidoSecundario().isVisible()) {
					parent.getContenidoSecundario().setVisible(false);
					toolbar.setStyleName("barraBusqueda");
					search.setIcon(new ThemeResource(
							"img/BusquedaNoPulsado.png"));
				} else {
					parent.getContenidoSecundario().setVisible(true);
					toolbar.setStyleName("barraBusquedaPulsada");
					search.setIcon(new ThemeResource("img/BusquedaPulsado.png"));
				}
			}
		});
		search.setIcon(new ThemeResource("img/BusquedaNoPulsado.png"),
				"Pulse para mostrar u ocultar el panel de busqueda");
		search.setWidth(20, Unit.PIXELS);
		search.setHeight(41, Unit.PIXELS);
		toolbar.addComponent(search);
		toolbar.setStyleName("barraBusqueda");

		principal.addComponent(toolbar);
		principal.setExpandRatio(contactsTable, 1f);
		addComponent(principal);
		refresh();
	}
	

	public void refresh() {
		contactsContainer.removeAllItems();
		contactsContainer.addAll(repository.findAll());
	}

	class NewContactWindow extends Window {

		private TextField firstName = new TextField(messageSource.getMessage(
				"contact.nombre", null, getLocale()));
		private TextField lastName = new TextField(messageSource.getMessage(
				"contact.apellido", null, getLocale()));
		private TextField email = new TextField(messageSource.getMessage(
				"contact.email", null, getLocale()));

		private Button commit = new Button(messageSource.getMessage(
				"contact.nuevo.guardar", null, getLocale()),
				new Button.ClickListener() {
					@Override
					public void buttonClick(Button.ClickEvent event) {
						repository.saveAndFlush(newContact);
						close();
						refresh();
					}
				});

		private Contact newContact = new Contact();

		public NewContactWindow() {
			setCaption(messageSource.getMessage("contact.nuevo.titulo", null,
					getLocale()));
			setModal(true);
			setResizable(false);

			// Build layout containing fields and button
			FormLayout form = new FormLayout(firstName, lastName, email);
			VerticalLayout verticalLayout = new VerticalLayout(form, commit);
			verticalLayout.setMargin(true);
			verticalLayout.setSpacing(true);
			setContent(verticalLayout);

			// Bind fields to entity properties by naming convention
			BeanFieldGroup<Contact> binder = new BeanFieldGroup<>(Contact.class);
			binder.setBuffered(false);
			binder.bindMemberFields(NewContactWindow.this);
			binder.setItemDataSource(newContact);

			// Automatically focus the firsName field
			firstName.focus();

		}

	}

}
