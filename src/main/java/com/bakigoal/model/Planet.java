package com.bakigoal.model;

import java.io.Serializable;

/**
 * A bean with a "name" property.
 */
public class Planet implements Serializable {
  private int id;
  private String name;

  public Planet(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
