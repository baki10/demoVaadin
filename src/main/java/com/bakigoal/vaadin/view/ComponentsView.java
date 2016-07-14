package com.bakigoal.vaadin.view;

import com.bakigoal.model.Planet;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = ComponentsView.VIEW_NAME)
public class ComponentsView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "components";

  @PostConstruct
  void init() {
    addComboBox();
    addPlanetComboBox();
    addListSelect();
    addPanel();
    addLabels();
  }

  private void addLabels() {
    Label textLabel = new Label(
        "Text where formatting characters, such as \\n, " +
            "and HTML, such as <b>here</b>, are quoted.",
        ContentMode.TEXT);
    addComponent(textLabel);
    Label preLabel = new Label(
        "Preformatted text is shown in an HTML <pre> tag.\n" +
            "Formatting such as\n" +
            " * newlines\n" +
            " * whitespace\n" +
            "and such are preserved. HTML tags, \n" +
            "such as <b>bold</b>, are quoted.",
        ContentMode.PREFORMATTED);
    addComponent(preLabel);
    Label htmlLabel = new Label(
        "In HTML mode, all HTML formatting tags, such as \n" +
            "<ul>" +
            " <li><b>bold</b></li>" +
            " <li>itemized lists</li>" +
            " <li>etc.</li>" +
            "</ul> " +
            "are preserved.",
        ContentMode.HTML);
    addComponent(htmlLabel);
  }

  private void addPanel() {
    // A container with a defined width.
    Panel panel = new Panel("Panel Containing a Label");
    panel.setWidth("400px");
    panel.setContent(
        new Label("This is a Label inside a Panel. There is " +
            "enough text in the label to make the text " +
            "wrap when it exceeds the width of the panel."));
    addComponent(panel);
  }

  private void addListSelect() {
    // A selection component with some items
    ListSelect select = new ListSelect("My Selection");
    select.addItems("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");
    // Multiple selection mode
    select.setMultiSelect(true);
    // Feedback on value changes
    select.addValueChangeListener(e -> addComponent(new Label("Selected: " + e.getProperty().getValue().toString())));
    select.setImmediate(true);
    addComponent(select);
  }

  private void addPlanetComboBox() {
    // Have a bean container to put the beans in
    BeanItemContainer<Planet> container = new BeanItemContainer<>(Planet.class);
    // Put some example data in it
    container.addItem(new Planet(1, "Mercury"));
    container.addItem(new Planet(2, "Venus"));
    container.addItem(new Planet(3, "Mars"));
    container.addItem(new Planet(4, "Earth"));

    // Create a selection component bound to the container
    ComboBox select = new ComboBox("Planets", container);
    // Set the caption mode to read the caption directly
    // from the 'name' property of the bean
    select.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
    select.setItemCaptionPropertyId("name");
    select.setNullSelectionAllowed(false);
    select.setValue(container.getIdByIndex(2));
    addComponent(select);
    select.setTextInputAllowed(false);

    // Handle selection change
    select.addValueChangeListener(event -> addComponent(new Label("Selected " + event.getProperty().getValue())));
  }

  private void addComboBox() {
    ComboBox select = new ComboBox("My ComboBox");
    select.setNullSelectionAllowed(false);

    select.addItem("Mercury");
    select.addItem("Venus");
    select.addItem("Mars");
    select.addItem("Earth");
    Object itemId = select.addItem();
    select.setItemCaption(itemId, "The Sun");

    select.setValue(itemId);

    select.setNewItemsAllowed(true);
    select.setImmediate(true);

    addComponent(select);
  }


  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
