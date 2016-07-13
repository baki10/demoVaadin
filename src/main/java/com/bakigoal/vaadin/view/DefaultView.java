package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "";

  @PostConstruct
  void init(){
    addComponent(new Label("Default view!"));
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
