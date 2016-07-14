package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.DateField;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = DateFieldView.VIEW_NAME)
public class DateFieldView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "dateField";

  @PostConstruct
  void init() {
    Locale ru_RU = new Locale("ru", "RU");

    DateField dateField = new DateField("Выберите дату");
    dateField.setValue(new Date());
    dateField.setLocale(ru_RU);
    dateField.setDateFormat("dd-MM-yyyy");
    addComponent(dateField);

    // Component for which the locale is meaningful
    InlineDateField date = new InlineDateField("Дата");
    date.setLocale(ru_RU);
    date.setResolution(Resolution.DAY);
    addComponent(date);

    PopupDateField popupDateField = new PopupDateField();
    // Set the prompt
    popupDateField.setInputPrompt("Выберите дату");
    // Set width explicitly to accommodate the prompt
    popupDateField.setWidth("13em");
    popupDateField.setLocale(ru_RU);

    addComponent(popupDateField);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
