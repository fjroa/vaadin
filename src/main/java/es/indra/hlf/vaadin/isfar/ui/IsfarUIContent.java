package es.indra.hlf.vaadin.isfar.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;
import org.vaadin.spring.navigator.SpringViewProvider;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import es.indra.hlf.vaadin.isfar.ui.footer.Footer;
import es.indra.hlf.vaadin.isfar.ui.header.Header;
import es.indra.hlf.vaadin.isfar.ui.view.ErrorView;

/**
 * @author petter@vaadin.com
 */
@UIScope
@VaadinComponent
public class IsfarUIContent extends VerticalLayout {

    @Autowired
    private SpringViewProvider viewProvider;
//    @Autowired
//    private Security security;
//    @Autowired
//    Authentication currentUser;
    @Autowired
    ErrorView errorView;
    @Autowired
    Header header;
    @Autowired
    Footer footer;
    @Autowired
    IsfarSideMenuUI isfarSideMenuUI;
	private HorizontalLayout content;

	@PostConstruct
	protected void init() {
        setSizeFull();
        setMargin(false);
        setSpacing(false);

		addComponent(header);
		HorizontalLayout principal = new HorizontalLayout();
		principal.setSizeFull();
		
        isfarSideMenuUI.setHeight("100%");
		principal.addComponent(isfarSideMenuUI);
		
		content = new HorizontalLayout();
		content.setSizeFull();
        principal.addComponent(content);
        principal.setExpandRatio(content, 3.5f);
		principal.setExpandRatio(isfarSideMenuUI, 1f);
		addComponent(principal);
		setExpandRatio(principal, 1f);
		// footer
		addComponent(footer);
		// fin footer
	}

    @Override
    public void attach() {
    	super.attach();
        final Navigator navigator = new Navigator(getUI(), content);
        navigator.addProvider(viewProvider);
        navigator.setErrorView(errorView);
    }
}
