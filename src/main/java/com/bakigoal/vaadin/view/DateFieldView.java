package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = DateFieldView.VIEW_NAME)
public class DateFieldView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "dateField";

  @PostConstruct
  void init() {

  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {
    // Component for which the locale is meaningful
    for (Resolution resolution : Resolution.values()) {
      InlineDateField date = new InlineDateField("Дата :" + resolution.name());
      date.setLocale(new Locale("ru", "RU"));
      date.setResolution(resolution);
      addComponent(date);
    }
  }
}
