package com.bakigoal.vaadin.view;

import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = TextFieldsView.VIEW_NAME)
public class TextFieldsView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "textFields";

  @PostConstruct
  void init() {
    addTextField();
    addTextAreas();
    addPasswordField();
    addRichTextArea();
  }

  private void addRichTextArea() {
    // Create a rich text area
    final RichTextArea rtarea = new RichTextArea();
    rtarea.setCaption("My Rich Text Area");
    // Set initial content as HTML
    rtarea.setValue("<h1>Hello</h1>\n" +
        "<p>This rich text area contains some text.</p>");
    addComponent(rtarea);
  }

  private void addTextField() {
    // Text field with maximum length
    final TextField tf = new TextField("My Eventful Field");
    tf.setValue("Initial content");
    tf.setMaxLength(20);
    // Counter for input length
    final Label counter = new Label();
    counter.setValue(tf.getValue().length() + " of " + tf.getMaxLength());
    // Display the current length interactively in the counter
    tf.addTextChangeListener(event -> {
      int len = event.getText().length();
      counter.setValue(len + " of " + tf.getMaxLength());
    });
    addComponent(tf);
    addComponent(counter);
  }

  private void addPasswordField() {
    PasswordField passwordField = new PasswordField("Password field!");
    addComponent(passwordField);
  }

  private void addTextAreas() {
    TextArea area1 = new TextArea("Wrapping");
    area1.setWordwrap(true); // The default
    area1.setValue("A quick brown fox jumps over the lazy dog");
    TextArea area2 = new TextArea("Nonwrapping");
    area2.setWordwrap(false);
    area2.setValue("Victor jagt zw&ouml;lf Boxk&auml;mpfer quer " +
        "&uuml;ber den Sylter Deich");
    addComponent(area1);
    addComponent(area2);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
