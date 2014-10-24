package es.indra.hlf.vaadin.isfar.ui.view;

import javax.annotation.PostConstruct;

import org.vaadin.spring.UIScope;
import org.vaadin.spring.navigator.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author petter@vaadin.com
 */
@VaadinView(name = HomeView.NAME)
@UIScope
//@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class HomeView extends VerticalLayout implements View {

    public static final String NAME = "";

    @PostConstruct
    void init() {
        addComponent(new Label("This is the home view"));
        addComponent(new Button("OK"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}