package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = TreeView.VIEW_NAME)
public class TreeView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "tree";

  @PostConstruct
  void init() {
    HorizontalLayout layout = new HorizontalLayout();
    Tree tree = getTree();
    layout.addComponent(tree);

    Panel panel = new Panel("Panel");
    layout.addComponent(panel);
    addComponent(layout);

    VerticalLayout content = new VerticalLayout();
    panel.setContent(content);
    content.setSizeFull();

    Label question = new Label("Where is the cat?");
    content.addComponent(question);

    Label answer = new Label("I don't know!");
    answer.setImmediate(true);
    content.addComponent(answer);

    tree.addItemClickListener(event -> {
      Object value = tree.getValue();
      String ans = "I don't know!";
      if(value != null){
        ans = "In " + value.toString();
      }
      answer.setValue(ans);
    });
  }

  private Tree getTree() {
    final Object[][] planets = new Object[][]{
        new Object[]{"Mercury"},
        new Object[]{"Venus"},
        new Object[]{"Earth", "The Moon"},
        new Object[]{"Mars", "Phobos", "Deimos"},
        new Object[]{"Jupiter", "Io", "Europa", "Ganymedes", "Callisto"},
        new Object[]{"Saturn", "Titan", "Tethys", "Dione", "Rhea", "Iapetus"},
        new Object[]{"Uranus", "Miranda", "Ariel", "Umbriel", "Titania", "Oberon"},
        new Object[]{"Neptune", "Triton", "Proteus", "Nereid", "Larissa"}};
    Tree tree = new Tree("The Planets and Major Moons");
    /* Add planets as root items in the tree. */
    for (Object[] planet1 : planets) {
      String planet = (String) (planet1[0]);
      tree.addItem(planet);
      if (planet1.length == 1) {
        // The planet has no moons so make it a leaf.
        tree.setChildrenAllowed(planet, false);
      } else {
        // Add children (moons) under the planets.
        for (int j = 1; j < planet1.length; j++) {
          String moon = (String) planet1[j];
          // Add the item as a regular item.
          tree.addItem(moon);
          // Set it to be a child.
          tree.setParent(moon, planet);
          // Make the moons look like leaves.
          tree.setChildrenAllowed(moon, false);
        }
        // Expand the subtree.
        tree.expandItemsRecursively(planet);
      }
    }
    tree.setImmediate(true);
    return tree;
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
