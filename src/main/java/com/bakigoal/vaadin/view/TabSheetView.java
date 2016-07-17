package com.bakigoal.vaadin.view;

import com.bakigoal.vaadin.mvp.view.CalculatorViewImpl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = TabSheetView.VIEW_NAME)
public class TabSheetView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "tabSheet";

  @PostConstruct
  void init() {
    TabSheet tabSheet = new TabSheet();
    addComponent(tabSheet);

    //create first tab
    VerticalLayout tab1 = new VerticalLayout();
    tab1.addComponent(new Button("Button in 1st tab"));
    tabSheet.addTab(tab1, "Tab1", FontAwesome.BEER);

    //second tab
    VerticalLayout tab2 = new VerticalLayout();
    tab2.addComponent(new Label("Label in 2nd tab"));
    tab2.setCaption("Tab2");
    tabSheet.addTab(tab2).setIcon(FontAwesome.WIFI);
    tab2.addComponent(new CalculatorViewImpl());
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
