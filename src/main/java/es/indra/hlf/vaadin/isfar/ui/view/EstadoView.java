package es.indra.hlf.vaadin.isfar.ui.view;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.spring.navigator.VaadinView;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

import es.indra.hlf.vaadin.isfar.model.Estado;

@UIScope
@VaadinView(name = EstadoView.NAME)
public class EstadoView extends HorizontalLayout implements View {

	@Autowired
	I18N i18n;
	@PersistenceContext
	private transient EntityManager entityManager;

	public static final String NAME = "estado";

	private JPAContainer<Estado> estadosContainer;
	private Table estadosTable;
	private Button search;

	@Autowired
	private EstadoSearch contenidoSecundario;

	public EstadoView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
    private void init() {
    	setSizeFull();
    	
		HorizontalLayout principal = new HorizontalLayout();
		principal.setSizeFull();
		
		VerticalLayout mainContent = new VerticalLayout();
		mainContent.setSizeFull();
		mainContent.setMargin(true);
		
		Label title = new Label("Estados");
		title.addStyleName(Reindeer.LABEL_H1);
		mainContent.addComponent(title);

		HorizontalLayout opcionesTabla = new HorizontalLayout();
		opcionesTabla.setHeight(50, Unit.PIXELS);
		opcionesTabla.setWidth("100%");
		opcionesTabla.setStyleName("opcionesTabla");
		
		HorizontalLayout icons = new HorizontalLayout();
		icons.setStyleName("opcionesTablaIcons");

		final Button nuevo = new Button("Nuevo", new ThemeResource("img/NuevoItinerario.png"));
		nuevo.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().addWindow(new EstadoDetailWindow(null));
			}
		});
		nuevo.setReadOnly(false);
		icons.addComponent(nuevo);

		final Button modificar = new Button("Modificar", new ThemeResource("img/ModificarItinerario.png"));
		modificar.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().addWindow(new EstadoDetailWindow(estadosTable.getItem(estadosTable.getValue())));
			} 
		});
		modificar.setEnabled(false);
		icons.addComponent(modificar);
		icons.setSpacing(true);
		
		opcionesTabla.addComponent(icons);
		mainContent.addComponent(opcionesTabla);
		estadosContainer = JPAContainerFactory.make(Estado.class, entityManager);
        
		estadosTable = new Table();
		estadosTable.setSizeFull();
		estadosTable.setContainerDataSource(estadosContainer);
		estadosTable.addGeneratedColumn("seleccionable", new ColumnGenerator() {
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
		        CheckBox ret = new CheckBox(null, ((Integer)itemId) != 0);
		        ret.setReadOnly(!source.isReadOnly());
		        return ret;
			}
		});
		estadosTable.setVisibleColumns("id", "descEstado", "tipo", "seleccionable");
		//estadosTable.addContainerProperty("seleccionable", CheckBox.class, null);
//		EstadosTable.setColumnHeader("firstName",
//				messageSource.getMessage("contact.nombre", null, getLocale()));
//		EstadosTable
//				.setColumnHeader("lastName", messageSource.getMessage(
//						"contact.apellido", null, getLocale()));
//		EstadosTable.setColumnHeader("email",
//				messageSource.getMessage("contact.email", null, getLocale()));
		estadosTable.setSelectable(true);
		
		estadosTable.addValueChangeListener(new Property.ValueChangeListener() {
		    public void valueChange(ValueChangeEvent event) {
		    	if (estadosTable.getValue() != null) {
		    		nuevo.setEnabled(false);
		    		modificar.setEnabled(true);
		    	} else {
		    		nuevo.setEnabled(true);
		    		modificar.setEnabled(false);
		    	}
		    }
		});
		
		mainContent.addComponent(estadosTable);
		mainContent.setExpandRatio(estadosTable, 1f);
		principal.addComponent(mainContent);
		
		final VerticalLayout toolbar = new VerticalLayout();
		toolbar.setSpacing(false);
		toolbar.setMargin(false);
		toolbar.setWidth(22, Unit.PIXELS);
		toolbar.setHeight("100%");
		search = new Button("", new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				if (contenidoSecundario.isVisible()) {
					contenidoSecundario.setVisible(false);
					toolbar.setStyleName("barraBusqueda");
					search.setIcon(new ThemeResource(
							"img/BusquedaNoPulsado.png"));
				} else {
					contenidoSecundario.setVisible(true);
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
		principal.setExpandRatio(mainContent, 1f);
		addComponent(principal);
		
		contenidoSecundario.setVisible(false);
		addComponent(contenidoSecundario);

		setExpandRatio(principal, 2.5f);
		setExpandRatio(contenidoSecundario, 1f);
		
		//refresh();
	}

	public void refresh() {
		// EstadosContainer.removeAllItems();
		// EstadosContainer.addAll(repository.findAll());
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

	@Override
	public void attach() {
		super.attach();
	}

}
