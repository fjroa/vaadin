package es.indra.hlf.vaadin.isfar.ui.header;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public class ContactToolBar extends HorizontalLayout {
	
	public ContactToolBar() {
		HorizontalLayout icons = new HorizontalLayout();
		icons.setStyleName("barraHeramientasIcons");
		Resource resHombre = new ThemeResource("img/hombre.png");
		// Display the image without caption
		Image imageHombre = new Image(null, resHombre);
		imageHombre.addClickListener(new ClickListener() {
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub

			}
		});
		icons.addComponent(imageHombre);

		Resource resMujer = new ThemeResource("img/mujer.png");
		// Display the image without caption
		Image imageMujer = new Image(null, resMujer);
		imageHombre.addClickListener(new ClickListener() {
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub

			}
		});
		icons.addComponent(imageMujer);
		icons.setSpacing(true);

		HorizontalLayout pacienteInfo = new HorizontalLayout();
		pacienteInfo.setStyleName("barraHerramientasPacienteInfo");
		pacienteInfo.setSpacing(true);
		Image imageSexo = new Image(null, new ThemeResource("img/femenino.png"));

		pacienteInfo.addComponent(imageSexo);

		Label nombrePaciente = new Label("NOMBRE APELLIDO APELLIDO");
		nombrePaciente.setStyleName("nombrePaciente");

		Label nacimientoPaciente = new Label("12 OCT 1978");

		Label edadPaciente = new Label("97A");

		Label pesoPaciente = new Label("91KG");

		Label idPaciente = new Label("RUN 5454504");

		pacienteInfo.addComponents(nombrePaciente, nacimientoPaciente,
				edadPaciente, pesoPaciente, idPaciente);

		addComponents(icons, pacienteInfo);
	}
}
