package com.bakigoal.service;

import com.vaadin.spring.annotation.ViewScope;
import org.springframework.stereotype.Service;

/**
 * Created by ilmir on 13.07.16.
 */
@Service
@ViewScope
public class ViewGreeter {

  public String sayHello() {
    return "Hello from a view scoped bean " + toString();
  }
}
