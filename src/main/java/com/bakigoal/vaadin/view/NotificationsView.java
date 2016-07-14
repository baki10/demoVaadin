package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = NotificationsView.VIEW_NAME)
public class NotificationsView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "notifications";

  @PostConstruct
  void init() {
    for (Notification.Type type : Notification.Type.values()) {
      addComponent(new Button("Notification: " + type.name(),
          event -> Notification.show("caption", "description", type)));
    }

    addComponent(new Button("Click me once more!",
        event -> {
          Notification notification = new Notification("This is the <b>caption</b>", "<br/>This is the <i>description</i>",
              Notification.Type.WARNING_MESSAGE, true);
          notification.show(Page.getCurrent());
        }));

    Button button = new Button("Look at my description");
    button.setDescription(
        "<h2><img src=\"../VAADIN/themes/myTheme/img/nice.jpg\" width=\"30px\"/>" +
            "A richtext tooltip</h2>" +
            "<ul>" +
            " <li>Use rich formatting with HTML</li>" +
            " <li>Include images from themes</li>" +
            " <li>etc.</li>" +
            "</ul>");
    button.setEnabled(false);
    button.setIcon(new ThemeResource("../runo/icons/16/ok.png"));
    addComponent(button);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
