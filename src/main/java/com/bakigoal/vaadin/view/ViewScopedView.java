package com.bakigoal.vaadin.view;

import com.bakigoal.service.Greeter;
import com.bakigoal.service.ViewGreeter;
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
@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View{

  public static final String VIEW_NAME = "view";

  // a new instance will be created for every view instance
  @Autowired
  private ViewGreeter viewGreeter;

  // the same instance will be used by all views of the UI
  @Autowired
  private Greeter uiGreeter;

  @PostConstruct
  void init(){
    setMargin(true);
    setSpacing(true);
    addComponent(new Label("View scoped view"));
    addComponent(new Label(uiGreeter.sayHello()));
    addComponent(new Label(viewGreeter.sayHello()));
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
