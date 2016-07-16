package com.bakigoal.vaadin.ui;

import com.bakigoal.vaadin.view.AccordionView;
import com.bakigoal.vaadin.view.ButtonsView;
import com.bakigoal.vaadin.view.ComponentsView;
import com.bakigoal.vaadin.view.DateFieldView;
import com.bakigoal.vaadin.view.FontAwesomeView;
import com.bakigoal.vaadin.view.FormLayoutView;
import com.bakigoal.vaadin.view.MenuBarView;
import com.bakigoal.vaadin.view.NotificationsView;
import com.bakigoal.vaadin.view.ProgressBarView;
import com.bakigoal.vaadin.view.ResourcesView;
import com.bakigoal.vaadin.view.TabSheetView;
import com.bakigoal.vaadin.view.TableView;
import com.bakigoal.vaadin.view.TextFieldsView;
import com.bakigoal.vaadin.view.TreeView;
import com.bakigoal.vaadin.view.UIScopedView;
import com.bakigoal.vaadin.view.UploadView;
import com.bakigoal.vaadin.view.ValidatorView;
import com.bakigoal.vaadin.view.ViewScopedView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringUI
@Title("My UI")
@Theme("valo")
@PreserveOnRefresh
public class MyVaadinUI extends UI {

  @Autowired
  private SpringViewProvider viewProvider;

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout root = new VerticalLayout();
    root.setSizeFull();
    root.setMargin(true);
    root.setSpacing(true);
    setContent(root);

    final CssLayout navigationBar = new CssLayout();
    navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

    navigationBar.addComponent(createNavigationButton("UI Scoped View", UIScopedView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("View Scoped View", ViewScopedView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Resources", ResourcesView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Notifications", NotificationsView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Date Field", DateFieldView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Validator", ValidatorView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Components", ComponentsView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("TextFields", TextFieldsView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Buttons", ButtonsView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Table", TableView.VIEW_NAME));
    navigationBar.addComponent(createNavigationButton("Tree", TreeView.VIEW_NAME));

    root.addComponent(navigationBar);

    final CssLayout navigationBar2 = new CssLayout();
    navigationBar2.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

    navigationBar2.addComponent(createNavigationButton("MenuBar", MenuBarView.VIEW_NAME));
    navigationBar2.addComponent(createNavigationButton("Upload", UploadView.VIEW_NAME));
    navigationBar2.addComponent(createNavigationButton("ProgressBar", ProgressBarView.VIEW_NAME));
    navigationBar2.addComponent(createNavigationButton("FormLayout", FormLayoutView.VIEW_NAME));
    navigationBar2.addComponent(createNavigationButton("FontAwesome", FontAwesomeView.VIEW_NAME));
    navigationBar2.addComponent(createNavigationButton("TabSheet", TabSheetView.VIEW_NAME));
    navigationBar2.addComponent(createNavigationButton("Accordion", AccordionView.VIEW_NAME));

    root.addComponent(navigationBar2);

    final Panel viewContainer = new Panel();
    viewContainer.setSizeFull();
    root.addComponent(viewContainer);
    root.setExpandRatio(viewContainer, 1.0f);

    Navigator navigator = new Navigator(this, viewContainer);
    navigator.addProvider(viewProvider);

    root.addComponent(new Button("Logout Page", event -> getPage().setLocation(MyLogoutUI.UI_NAME)));
  }

  private Component createNavigationButton(String caption, String viewName) {
    Button button = new Button(caption);
    button.addStyleName(ValoTheme.BUTTON_SMALL);
    button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
    return button;
  }
}
