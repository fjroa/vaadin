package es.indra.hlf.vaadin.isfar.ui.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import es.indra.hlf.vaadin.isfar.model.Estado;
import es.indra.hlf.vaadin.isfar.repository.EstadoRepository;

@UIScope
@VaadinComponent
public class EstadoDetailWindow extends Window {

	@Autowired
	EstadoRepository repository;

	private TextField id = new TextField("id");
	private TextField descEstado = new TextField("descEstado");
	private TextField tipo = new TextField("tipo");

	private Button commit = new Button("Guardar", new Button.ClickListener() {
		@Override
		public void buttonClick(Button.ClickEvent event) {
			try {
                fg.commit();
            } catch (FieldGroup.CommitException e) {
                Notification.show("Couldn't commit values: "
                        + e.getCause().getMessage(),
                        Notification.Type.ERROR_MESSAGE);
            }
			close();
			// refresh();
		}
	});

	private final FieldGroup fg;
	
	public EstadoDetailWindow(Item item) {
		if (item == null) {
			setCaption("Nuevo Estado");
		} else {
			setCaption("Editar Estado");
		}
		setModal(true);
		setResizable(false);

		// Build layout containing fields and button
		FormLayout form = new FormLayout(id, descEstado, tipo);
		VerticalLayout verticalLayout = new VerticalLayout(form, commit);
		verticalLayout.setMargin(true);
		verticalLayout.setSpacing(true);
		setContent(verticalLayout);

		// Just edit the first item in the JPAContainer
       fg = new FieldGroup(item) {
            /*
             * Override configureField to add a bean validator to each field.
             */
            @Override
            protected void configureField(Field<?> field) {
                super.configureField(field);
                // Add Bean validators if there are annotations
                // Note that this requires a bean validation implementation to
                // be available.
                BeanValidator validator = new BeanValidator(Estado.class,
                        getPropertyId(field).toString());
                field.addValidator(validator);
                if (field.getLocale() != null) {
                    validator.setLocale(field.getLocale());
                }
            }
        };
        
		fg.setBuffered(false);
		fg.bindMemberFields(EstadoDetailWindow.this);

		// Automatically focus the id field
		id.focus();
	}
}
