package es.indra.hlf.vaadin.isfar.ui.header;

import javax.annotation.PostConstruct;

import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;

@UIScope
@VaadinComponent
public class IsfarCabecera extends HorizontalLayout{
	
	class Separator extends Label {

		private static final long serialVersionUID = 1L;

		Separator() {
			super("|", ContentMode.TEXT);
		}
	}
	
	@PostConstruct
	protected void init() {
		ThemeResource resource = new ThemeResource("img/logo.png");
		addComponent(new Image("", resource));

		HorizontalLayout userInfo = new HorizontalLayout();
		userInfo.setSpacing(true);
		userInfo.addComponent(new Label("PROFESIONAL"));
		userInfo.addComponent(new Separator());
		userInfo.addComponent(new Label("ASSISTANCE - SERVICE"));
		userInfo.addComponent(new Separator());
		userInfo.addComponent(new Label("CENTER"));
		userInfo.addComponent(new Separator());
		Link signOut = new Link("sign out", null);
		signOut.setStyleName("signOut");
		userInfo.addComponent(signOut);
		userInfo.setStyleName("userInfo");
		addComponent(userInfo);
		setExpandRatio(userInfo, 1.0f);
	}
}
