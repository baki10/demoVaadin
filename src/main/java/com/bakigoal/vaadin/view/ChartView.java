package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = ChartView.VIEW_NAME)
public class ChartView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "chart";

  @PostConstruct
  void init(){
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {


  }
}
