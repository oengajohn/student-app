package io.training;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletAttributeListener implements ServletContextAttributeListener {

  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    ServletContextAttributeListener.super.attributeAdded(event);
    System.out.println("Added attribute");
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent event) {
    ServletContextAttributeListener.super.attributeRemoved(event);
    System.out.println("removed attribute");
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent event) {
    ServletContextAttributeListener.super.attributeReplaced(event);
  }
}
