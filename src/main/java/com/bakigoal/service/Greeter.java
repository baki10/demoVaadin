package com.bakigoal.service;

import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Service;

/**
 * Created by ilmir on 13.07.16.
 */
@Service
@UIScope
public class Greeter {
  public String sayHello() {
    return "Hello from UI scoped bean " + toString();
  }
}
