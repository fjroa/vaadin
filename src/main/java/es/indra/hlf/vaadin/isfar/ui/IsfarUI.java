package es.indra.hlf.vaadin.isfar.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinUI;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@VaadinUI
@Theme("demo")
public class IsfarUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Autowired
    IsfarUIContent uiContent;

    @Override
    protected void init(VaadinRequest request) {
        setContent(uiContent);
    }
}
