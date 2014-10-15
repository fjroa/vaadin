package es.indra.hlf.vaadin.isfar.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.vaadin.spring.VaadinUI;

import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

import es.indra.hlf.vaadin.isfar.model.Contact;
import es.indra.hlf.vaadin.isfar.repository.ContactRepository;
import es.indra.hlf.vaadin.isfar.ui.footer.Footer;
import es.indra.hlf.vaadin.isfar.ui.header.Header;

@VaadinUI
@Theme("demo")
class IsfarUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ContactRepository repository;
	@Autowired
	MessageSource messageSource;

	VerticalLayout contenidoSecundario;
	VerticalLayout menuSecundario;
	VerticalLayout principal;

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		setContent(layout);
		
		// Header
		layout.addComponent(new Header());
		// Fin Header

		HorizontalLayout content = new HorizontalLayout();
		content.setSizeFull();

		menuSecundario = new IsfarSideMenuUI(this);
		menuSecundario.setHeight("100%");
		
		principal = new ContactUI(this);
		principal.setSizeFull();
		
		contenidoSecundario = new ContactSearchUI(this);
		contenidoSecundario.setSizeFull();
		
		
		content.addComponents(menuSecundario, principal, contenidoSecundario);

		content.setExpandRatio(principal, 2.5f);
		content.setExpandRatio(menuSecundario, 1f);
		content.setExpandRatio(contenidoSecundario, 1f);

		layout.addComponent(content);
		layout.setExpandRatio(content, 1f);
		// footer
		layout.addComponent(new Footer());
		// fin footer
	}

	public VerticalLayout getContenidoSecundario() {
		return contenidoSecundario;
	}

	public VerticalLayout getMenuSecundario() {
		return menuSecundario;
	}

	public VerticalLayout getPrincipal() {
		return principal;
	}

	public ContactRepository getRepository() {
		return repository;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}	

}
