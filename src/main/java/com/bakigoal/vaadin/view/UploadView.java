package com.bakigoal.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by ilmir on 13.07.16.
 */
@SpringView(name = UploadView.VIEW_NAME)
public class UploadView extends VerticalLayout implements View {

  public static final String VIEW_NAME = "upload";

  @PostConstruct
  void init() {
    // Show uploaded file in this placeholder
    final Embedded image = new Embedded("Uploaded Image");
    image.setVisible(false);
    // Implement both receiver that saves upload in a file and
    // listener for successful upload
    class ImageUploader implements Upload.Receiver, Upload.SucceededListener {
      public File file;
      public OutputStream receiveUpload(String filename,
                                        String mimeType) {
        // Create upload stream
        FileOutputStream fos; // Stream to write to
        try {
          // Open the file for writing.
          file = new File("/tmp/uploads/" + filename);
          fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
          new Notification("Could not open file<br/>",
              e.getMessage(),
              Notification.Type.ERROR_MESSAGE)
              .show(Page.getCurrent());
          return null;
        }
        return fos; // Return the output stream to write to
      }
      public void uploadSucceeded(Upload.SucceededEvent event) {
        // Show the uploaded file in the image viewer
        image.setVisible(true);
        image.setSource(new FileResource(file));
      }
    };
    ImageUploader receiver = new ImageUploader();
    // Create the upload with a caption and set receiver later
    Upload upload = new Upload("Upload Image Here", receiver);
    upload.setButtonCaption("Start Upload");
    upload.addSucceededListener(receiver);
    // Put the components in a panel
    Panel panel = new Panel("Cool Image Storage");
    Layout panelContent = new VerticalLayout();
    panelContent.addComponents(upload, image);
    panel.setContent(panelContent);
    addComponent(panel);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {

  }
}
