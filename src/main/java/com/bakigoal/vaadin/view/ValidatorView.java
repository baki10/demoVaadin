package com.bakigoal.vaadin.view;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = ValidatorView.VIEW_NAME)
public class ValidatorView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "validator";

  @PostConstruct
  void init() {
    TextField field = new TextField("Name");
    field.addValidator(new StringLengthValidator("The name must be 1-10 letters (was {0})", 1, 10, true));
    field.setNullRepresentation("");
    field.setNullSettingAllowed(true);
    addComponent(field);

    TextField email = new TextField("Email");
    email.addValidator(new EmailValidator("Enter valid email address!"));
    email.setNullRepresentation("");
    email.setNullSettingAllowed(true);
    addComponent(email);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
