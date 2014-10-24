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
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

import es.indra.hlf.vaadin.isfar.model.Turno;
import es.indra.hlf.vaadin.isfar.repository.TurnoRepository;

@UIScope
@VaadinView(name = TurnoView.NAME)
public class TurnoView extends HorizontalLayout implements View {
	
	@Autowired
	TurnoRepository repository;
	@Autowired
	I18N i18n;
	@PersistenceContext
	private transient EntityManager entityManager;
	
	public static final String NAME = "turno";
	
	private JPAContainer<Turno> turnosContainer;
	private Table turnosTable;
	private Button search;
	
	@Autowired
	private TurnoSearch contenidoSecundario;
	
	public TurnoView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    @PostConstruct
    private void init() {
    	setSizeFull();
    	
		HorizontalLayout principal = new HorizontalLayout();
		principal.setSizeFull();

		Label title = new Label(i18n.get("contact.titulo",
				null, getLocale()));
		title.addStyleName(Reindeer.LABEL_H1);
		principal.addComponent(title);

		turnosContainer = JPAContainerFactory.make(Turno.class, entityManager);

		turnosTable = new Table();
		turnosTable.setSizeFull();
		turnosTable.setContainerDataSource(turnosContainer);
		turnosTable.setVisibleColumns("idTurno", "descTurno", "tipo", "diaDesde", "diaHasta");
//		turnosTable.setColumnHeader("firstName",
//				messageSource.getMessage("contact.nombre", null, getLocale()));
//		turnosTable
//				.setColumnHeader("lastName", messageSource.getMessage(
//						"contact.apellido", null, getLocale()));
//		turnosTable.setColumnHeader("email",
//				messageSource.getMessage("contact.email", null, getLocale()));
		principal.addComponent(turnosTable);

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
		principal.setExpandRatio(turnosTable, 1f);
		addComponent(principal);
		
		contenidoSecundario.setVisible(false);
		addComponent(contenidoSecundario);

		setExpandRatio(principal, 2.5f);
		setExpandRatio(contenidoSecundario, 1f);
		
		//refresh();
	}
	

	public void refresh() {
		turnosContainer.removeAllItems();
		//turnosContainer.addAll(repository.findAll());
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
