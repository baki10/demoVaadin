package com.bakigoal.vaadin.mvp.view;

/**
 * Created by ilmir on 16.07.16.
 */
public interface CalculatorView {
  public void setDisplay(double value);

  public interface CalculatorViewListener {
    void buttonClick(char operation);
  }

  public void addListener(CalculatorViewListener listener);
}
