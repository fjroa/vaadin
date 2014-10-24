package es.indra.hlf.vaadin.isfar.ui.header;

import javax.annotation.PostConstruct;

import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

import es.indra.hlf.vaadin.isfar.ui.view.EstadoView;
import es.indra.hlf.vaadin.isfar.ui.view.HomeView;
import es.indra.hlf.vaadin.isfar.ui.view.MainView;
import es.indra.hlf.vaadin.isfar.ui.view.PautaView;
import es.indra.hlf.vaadin.isfar.ui.view.TurnoView;

@UIScope
@VaadinComponent
public class IsfarMenuPrincipal extends HorizontalLayout {

	@PostConstruct
	void init() {
		MenuBar menubar = new MenuBar();
		menubar.setAutoOpen(true);
		menubar.addItem("Prescripciones Pendientes", new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(HomeView.NAME);
			}
		});

		menubar.addItem("Fuera de carro", new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(EstadoView.NAME);
			}
		});
		menubar.addItem("Itinerarios", new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(MainView.NAME);
			}
		});
		menubar.addItem("Turnos", new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(TurnoView.NAME);
			}
		});

		MenuItem listados = menubar.addItem("Listados", null);
		
		listados.addItem("Listado Totales de Medicamentos", null);
		listados.addItem("Listado de Administraciones por Paciente", null);
		listados.addItem("Ficha Farmacoterpéutica por Paciente", null);
		listados.addItem("Hoja de Administración de Medicamentos", null);
		listados.addItem("Hoja de Administración individual", null);
		listados.addItem("Listado de Itinerario de Carro", null);
		listados.addItem("Listado de Devoluciones", null);
		listados.addItem("Listado de Prescripciones Rechazadas", null);
		
		MenuItem catalogos = menubar.addItem("Catálogos", null);
		catalogos.addItem("Horarios de Administración", new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(PautaView.NAME);
			}
		});
		catalogos.addItem("Horarios de Administración asociados a Comidas", null);
		catalogos.addItem("Configuración", null);
		catalogos.addItem("Medicamentos no unidosis", null);
		catalogos.addItem("Formas farmacéuticas no unidosis", null);
		
		menubar.addItem("Salir", null);
		addComponent(menubar);

	}
}
