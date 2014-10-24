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
import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.filter.Compare.Equal;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

import es.indra.hlf.vaadin.isfar.model.PautaAdministracion;
import es.indra.hlf.vaadin.isfar.repository.PautaAdministracionRepository;

@UIScope
@VaadinView(name = PautaView.NAME)
public class PautaView extends HorizontalLayout implements View {

	@Autowired
	PautaAdministracionRepository repository;
	@Autowired
	I18N i18n;
	@PersistenceContext
	private transient EntityManager entityManager;

	public static final String NAME = "pauta";

	private JPAContainer<PautaAdministracion> pautasContainer;
	private Table pautasTable;
	private Button search;

	@Autowired
	private PautaSearch contenidoSecundario;

	public PautaView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init() {
		setSizeFull();

		HorizontalLayout principal = new HorizontalLayout();
		principal.setSizeFull();

		Label title = new Label(i18n.get("contact.titulo", null, getLocale()));
		title.addStyleName(Reindeer.LABEL_H1);
		principal.addComponent(title);

		pautasContainer = JPAContainerFactory.makeReadOnly(
				PautaAdministracion.class, entityManager);

		pautasContainer.addContainerFilter(new Equal("codCentro", "KHUH")) ;
		//pautasContainer.addContainerFilter(new Equal("codPautaPosologiaPRE", 0)) ;
		
		pautasTable = new Table(null, pautasContainer);
		pautasTable.setSizeFull();
		pautasTable.setVisibleColumns("descPauta", "horario");
		pautasTable.setColumnHeader("descPauta", "Pauta (en horas)");
		pautasTable
				.setColumnHeader("horario", "Horas Administación");
		principal.addComponent(pautasTable);


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
		principal.setExpandRatio(pautasTable, 1f);
		addComponent(principal);

		contenidoSecundario.setVisible(false);
		addComponent(contenidoSecundario);

		setExpandRatio(principal, 2.5f);
		setExpandRatio(contenidoSecundario, 1f);

		// refresh();
	}

	public void refresh() {
		// PautasContainer.removeAllItems();
		// PautasContainer.addAll(repository.findAll());
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

	@Override
	public void attach() {
		super.attach();
	}

}
