package com.bakigoal.vaadin.view;

import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = FormLayoutView.VIEW_NAME)
public class FormLayoutView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "formLayout";

  @PostConstruct
  void init(){
    FormLayout form = new FormLayout();
    TextField tf1 = new TextField("Name");
    tf1.setIcon(FontAwesome.USER);
    tf1.setRequired(true);
    tf1.addValidator(new NullValidator("Must be given", false));
    form.addComponent(tf1);
    TextField tf2 = new TextField("Street address");
    tf2.setIcon(FontAwesome.ROAD);
    form.addComponent(tf2);
    TextField tf3 = new TextField("Postal code");
    tf3.setIcon(FontAwesome.ENVELOPE);
    tf3.addValidator(new IntegerRangeValidator("Doh!", 1, 99999));
    form.addComponent(tf3);

    addComponent(form);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
