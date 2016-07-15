package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = ProgressBarView.VIEW_NAME)
public class ProgressBarView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "progressBar";

  @PostConstruct
  void init() {
    final ProgressBar bar = new ProgressBar(0.0f);
    addComponent(bar);
    addComponent(new Button("Increase", event -> {
      float current = bar.getValue();
      if (current < 1.0f) {
        bar.setValue(current + 0.10f);
      }
    }));


    ProgressBar circularBar = new ProgressBar();
    circularBar.setIndeterminate(true);
    addComponent(circularBar);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
