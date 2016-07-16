package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = FontAwesomeView.VIEW_NAME)
public class FontAwesomeView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "fontAwesome";

  @PostConstruct
  void init(){

    for(FontAwesome fontAwesome: FontAwesome.values()){
      Button button = new Button(fontAwesome.name());
      button.setIcon(fontAwesome);
      addComponent(button);
    }
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
