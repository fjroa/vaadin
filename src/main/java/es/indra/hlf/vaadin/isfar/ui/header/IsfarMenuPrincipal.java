package es.indra.hlf.vaadin.isfar.ui.header;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class IsfarMenuPrincipal extends HorizontalLayout {
	
	IsfarMenuPrincipal() {
		MenuBar menubar = new MenuBar();
		menubar.setAutoOpen(true);
		menubar.addItem("SECTION 1", null);
		MenuItem section2 = menubar.addItem("SECTION 2", null);
		section2.addItem("OPTION 1", null);
		section2.addItem("OPTION 2", null);
		section2.addItem("OPTION 3", null);

		menubar.addItem("SECTION 3", null);
		menubar.addItem("DESKTOP", null);
		addComponent(menubar);
	}
}
