package com.bakigoal.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

/**
 * Created by ilmir on 14.07.16.
 */
@SpringUI(path = MyLogoutUI.UI_NAME)
@Theme("valo")
public class MyLogoutUI extends UI {

  public final static String UI_NAME = "logout";

  @Override
  protected void init(VaadinRequest request) {
    setContent(new Button("Logout", event -> {// Java 8
      for (UI ui : VaadinSession.getCurrent().getUIs())
        ui.access(() -> {
          // Redirect from the page
          ui.getPage().setLocation("/");
        });
      getSession().close();
    }));
  }
}
