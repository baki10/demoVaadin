package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = AccordionView.VIEW_NAME)
public class AccordionView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "accordion";

  @PostConstruct
  void init() {
    Accordion accordion = new Accordion();
    addComponent(accordion);

    //create first tab
    VerticalLayout tab1 = new VerticalLayout();
    tab1.addComponent(new Button("Button in 1st tab"));
    accordion.addTab(tab1, "Tab1", FontAwesome.BEER);

    //second tab
    VerticalLayout tab2 = new VerticalLayout();
    tab2.addComponent(new Label("Label in 2nd tab"));
    tab2.setCaption("Tab2");
    accordion.addTab(tab2).setIcon(FontAwesome.WIFI);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
