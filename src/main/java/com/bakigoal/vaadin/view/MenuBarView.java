package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = MenuBarView.VIEW_NAME)
public class MenuBarView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "menuBar";

  @PostConstruct
  void init() {
    // A feedback component
    final Label selection = new Label("-");
    addComponent(selection);
    // Define a common menu command for all the menu items.
    MenuBar.Command mycommand = selected -> selection.setValue("Ordered a " + selected.getText() + " from menu.");
    addComponent(getMenuBar(mycommand));
  }

  private MenuBar getMenuBar(MenuBar.Command mycommand) {
    MenuBar barmenu = new MenuBar();
    // A top-level menu item that opens a submenu
    MenuBar.MenuItem drinks = barmenu.addItem("Beverages", null, null);
    // Submenu item with a sub-submenu
    MenuBar.MenuItem hots = drinks.addItem("Hot", null, null);
    hots.addItem("Tea",
        new ThemeResource("../runo/icons/16/ok.png"),
        mycommand);
    hots.addItem("Coffee",
        new ThemeResource("../runo/icons/16/reload.png"),
        mycommand);
    // Another submenu item with a sub-submenu
    MenuBar.MenuItem colds = drinks.addItem("Cold", null, null);
    colds.addItem("Milk",
        null, mycommand);
    colds.addItem("Weissbier", null, mycommand);
    // Another top-level item
    MenuBar.MenuItem snacks = barmenu.addItem("Snacks", null, null);
    snacks.addItem("Weisswurst", null, mycommand);
    snacks.addItem("Bratwurst", null, mycommand);
    snacks.addItem("Currywurst", null, mycommand);
    // Yet another top-level item
    MenuBar.MenuItem servs = barmenu.addItem("Services", null, null);
    servs.addItem("Car Service", null, mycommand);

    return barmenu;
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
