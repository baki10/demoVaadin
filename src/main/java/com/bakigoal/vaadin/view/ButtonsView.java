package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = ButtonsView.VIEW_NAME)
public class ButtonsView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "buttons";

  @PostConstruct
  void init() {
    HorizontalLayout layout = new HorizontalLayout();
    layout.setSpacing(true);
    addComponent(layout);

    addButton(layout);
    addCheckBox(layout);
    addListSelect(layout);
    addOptionGroups(layout);
    addTwinColSelect(layout);
  }

  private void addTwinColSelect(HorizontalLayout layout) {
    VerticalLayout vertLayout = new VerticalLayout();
    TwinColSelect select = new TwinColSelect("Select Targets");
    select.addItems("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");
    select.setRows(select.size());
    select.setValue(new HashSet<>(Arrays.asList("Venus", "Earth", "Mars")));
    // Handle value changes
    select.addValueChangeListener(e -> vertLayout.addComponent(new Label("Selected: " + e.getProperty().getValue())));
    vertLayout.addComponent(select);
    layout.addComponent(vertLayout);
  }

  private void addOptionGroups(HorizontalLayout layout) {
    // A single-select radio button group
    OptionGroup single = new OptionGroup("Single Selection");
    single.addItems("Single", "Sola", "Yksi");
    single.setItemEnabled("Sola", false);
    // A multi-select check box group
    OptionGroup multi = new OptionGroup("Multiple Selection");
    multi.setMultiSelect(true);
    multi.addItems("Many", "Muchos", "Monta");
    layout.addComponent(single);
    layout.addComponent(multi);

  }

  private void addListSelect(HorizontalLayout layout) {
    // Create the selection component
    ListSelect select = new ListSelect("The List");
    // Add some items (here by the item ID as the caption)
    select.addItems("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Sun");
    select.setNullSelectionAllowed(false);
    // Show 5 items and a scrollbar if there are more
    select.setRows(5);
    layout.addComponent(select);
  }

  private void addCheckBox(HorizontalLayout layout) {
    VerticalLayout verticalLayout = new VerticalLayout();
    CheckBox checkbox1 = new CheckBox("Box with no Check");
    CheckBox checkbox2 = new CheckBox("Box with a Check");
    checkbox2.setValue(true);
    checkbox1.addValueChangeListener(event -> // Java 8
        checkbox2.setValue(!checkbox1.getValue()));
    checkbox2.addValueChangeListener(event -> // Java 8
        checkbox1.setValue(!checkbox2.getValue()));
    verticalLayout.addComponent(checkbox1);
    verticalLayout.addComponent(checkbox2);
    layout.addComponent(verticalLayout);
  }

  private void addButton(HorizontalLayout layout) {
    Button button = new Button("Do not press this button");
    button.setStyleName(ValoTheme.BUTTON_DANGER);

    button.addClickListener(event -> Notification.show("Do not press this button again"));
    layout.addComponent(button);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
