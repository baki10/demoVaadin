package com.bakigoal.vaadin.view;

import com.bakigoal.vaadin.util.MyInputStreamImageSource;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Image;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = ResourcesView.VIEW_NAME)
public class ResourcesView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "resources";

  @PostConstruct
  void init() {
    setMargin(true);
    setSpacing(true);

    addImage();
    addLink();
    addStreamImage();
  }

  private void addLink() {
    // Find the application directory
    String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
    FileResource smileResource = new FileResource(new File(basepath + "/WEB-INF/images/nice.jpg"));
    // Let the user view the file in browser or download it
    Link link = new Link("Link to the image file", smileResource);
    addComponent(link);
  }

  private void addImage() {
    // Find the application directory
    String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
    // Image as a file resource
    FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/goal.jpg"));
    // Show the image in the application
    Image image = new Image("Image from file", resource);
    addComponent(image);
  }

  private void addStreamImage() {
    // Create an instance of our stream source.
    StreamResource.StreamSource imagesource = new MyInputStreamImageSource();
    // Create a resource that uses the stream source and give it a name.
    // The constructor will automatically register the resource in
    // the application.
    StreamResource resource =
        new StreamResource(imagesource, "myimage.png");
    // Create an image component that gets its contents
    // from the resource.
    Image image = new Image("Image title", resource);
    addComponent(image);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
