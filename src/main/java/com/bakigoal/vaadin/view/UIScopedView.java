package com.bakigoal.vaadin.view;

import com.bakigoal.service.Greeter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = UIScopedView.VIEW_NAME)
public class UIScopedView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "ui";

  @Autowired
  private Greeter greeter;

  @PostConstruct
  void init() {
    setMargin(true);
    setSpacing(true);
    addComponent(new Label("UI scoped view. Greeter says: " + greeter.sayHello()));
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
