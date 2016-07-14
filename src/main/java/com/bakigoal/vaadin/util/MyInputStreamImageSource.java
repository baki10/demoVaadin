package com.bakigoal.vaadin.util;

import com.vaadin.server.StreamResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ilmir on 14.07.16.
 */
public class MyInputStreamImageSource implements StreamResource.StreamSource {

  ByteArrayOutputStream imageBuffer = null;
  int reloads = 0;

  @Override
  public InputStream getStream() {
    /* Create an image and draw something on it. */
    BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
    Graphics drawable = image.getGraphics();
    drawable.setColor(Color.lightGray);
    drawable.fillRect(0, 0, 200, 200);
    drawable.setColor(Color.yellow);
    drawable.fillOval(25, 25, 150, 150);
    drawable.setColor(Color.blue);
    drawable.drawRect(0, 0, 199, 199);
    drawable.setColor(Color.black);
    drawable.drawString("Reloads=" + reloads, 75, 100);
    reloads++;
    try {
      /* Write the image to a buffer. */
      imageBuffer = new ByteArrayOutputStream();
      ImageIO.write(image, "png", imageBuffer);
      /* Return a stream from the buffer. */
      return new ByteArrayInputStream(imageBuffer.toByteArray());
    } catch (IOException e) {
      return null;
    }
  }
}
