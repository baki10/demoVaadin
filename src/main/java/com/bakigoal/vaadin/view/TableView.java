package com.bakigoal.vaadin.view;

import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = TableView.VIEW_NAME)
public class TableView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "table";

  @PostConstruct
  void init() {
    addTable();
  }

  private void addTable() {
    Table table = new Table("The Brightest Stars");

    table.addContainerProperty("Name", String.class, null);
    table.addContainerProperty("Mag", Float.class, null);

    // Add a row the hard way
    Object newItemId = table.addItem();
    Item row1 = table.getItem(newItemId);
    row1.getItemProperty("Name").setValue("Sirius");
    row1.getItemProperty("Mag").setValue(-1.46f);

    // Add a few other rows using shorthand addItem()
    table.addItem(new Object[]{"Canopus", -0.72f}, 2);
    table.addItem(new Object[]{"Arcturus", -0.04f}, 3);
    table.addItem(new Object[]{"Alpha Centauri", -0.01f}, 4);

    // Show exactly the currently contained rows (items)
    table.setPageLength(table.size());
    // Allow selecting items from the table.
    table.setSelectable(true);
    // Send changes in selection immediately to server.
    table.setImmediate(true);
    // Shows feedback from selection.
    final Label current = new Label("Selected: -");
    // Handle selection change.
    table.addValueChangeListener(e -> current.setValue("Selected: " + table.getValue()));
    addComponent(table);
    addComponent(current);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
