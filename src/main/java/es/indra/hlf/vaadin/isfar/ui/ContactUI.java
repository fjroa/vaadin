package es.indra.hlf.vaadin.isfar.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.vaadin.spring.VaadinUI;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

import es.indra.hlf.vaadin.isfar.model.Contact;
import es.indra.hlf.vaadin.isfar.repository.ContactRepository;
import es.indra.hlf.vaadin.isfar.ui.header.Header;

@VaadinUI
class ContactUI extends UI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    ContactRepository repository;
    @Autowired
    MessageSource messageSource;
    
    private BeanItemContainer<Contact> contactsContainer;
    private Table contactsTable;
    private Button refresh;
    private Button add;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
        
        layout.addComponent(new Header());

        
        Label title = new Label(messageSource.getMessage("contact.titulo", null, getLocale()));
        title.addStyleName(Reindeer.LABEL_H1);
        layout.addComponent(title);

        contactsContainer = new BeanItemContainer<>(Contact.class);

        contactsTable = new Table();
        contactsTable.setSizeFull();
        contactsTable.setContainerDataSource(contactsContainer);
        contactsTable.setVisibleColumns("firstName", "lastName", "email");
        contactsTable.setColumnHeader("firstName", messageSource.getMessage("contact.nombre", null, getLocale()));
        contactsTable.setColumnHeader("lastName", messageSource.getMessage("contact.apellido", null, getLocale()));
        contactsTable.setColumnHeader("email", messageSource.getMessage("contact.email", null, getLocale()));
        layout.addComponent(contactsTable);
        layout.setExpandRatio(contactsTable, 1f);

        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.setSpacing(true);
        layout.addComponent(toolbar);

        refresh = new Button(messageSource.getMessage("contact.refrescar", null, getLocale()), new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                refresh();
            }
        });
        toolbar.addComponent(refresh);

        add = new Button(messageSource.getMessage("contact.nuevo", null, getLocale())+"...", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                addWindow(new NewContactWindow());
            }
        });
        toolbar.addComponent(add);

        //footer
        VerticalLayout footer = new VerticalLayout(); 
        footer.setHeight(20, Unit.PIXELS);
        Label footerLabel = new Label(messageSource.getMessage("footer.label", null, getLocale()));
        footer.addComponent(footerLabel);
        layout.addComponent(footer);
        //fin footer
        refresh();
    }

    private void refresh() {
        contactsContainer.removeAllItems();
        contactsContainer.addAll(repository.findAll());
    }

    class NewContactWindow extends Window {

        private TextField firstName = new TextField(messageSource.getMessage("contact.nombre", null, getLocale()));
        private TextField lastName = new TextField(messageSource.getMessage("contact.apellido", null, getLocale()));
        private TextField email = new TextField(messageSource.getMessage("contact.email", null, getLocale()));

        private Button commit = new Button(messageSource.getMessage("contact.nuevo.guardar", null, getLocale()), new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                repository.saveAndFlush(newContact);
                close();
                refresh();
            }
        });

        private Contact newContact = new Contact();

        public NewContactWindow() {
            setCaption(messageSource.getMessage("contact.nuevo.titulo", null, getLocale()));
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
