package cs5004.animator.view;

import java.awt.Graphics;

/**
 * This interface defines the method implemented by View.
 */
public interface IViewShape {

  /**
   * This method draws the shape on the screen given the Graphics object.
   *
   * @param g The graphics object.
   */
  public void draw(Graphics g);

}
