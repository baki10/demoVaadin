package com.bakigoal.vaadin.view;

import com.bakigoal.model.Person;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = BeanView.VIEW_NAME)
public class BeanView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "beanView";

  @PostConstruct
  void init() {
    // Have an item
    Person person = new Person();
    person.setName("Baki");
    person.setAge(28);
    BeanItem<Person> item = new BeanItem<>(person);

    // Define a form as a class that extends some layout
    class MyForm extends FormLayout {
      // Member that will bind to the "name" property
      TextField name = new TextField("Name");

      // Member that will bind to the "age" property
      @PropertyId("age")
      TextField ageField = new TextField("Age");

      public MyForm() {
        // Customize the layout a bit
        setSpacing(true);

        // Add the fields
        addComponent(name);
        addComponent(ageField);
      }
    }

    // Create one
    MyForm form = new MyForm();

    // Now create a binder that can also creates the fields
    // using the default field factory
    FieldGroup binder = new FieldGroup(item);
    binder.bindMemberFields(form);

    // And the form can be used in an higher-level layout
    addComponent(form);

  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
