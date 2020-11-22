package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents the Rectangle shape to be drawn on screen given x,y coordinates, width,
 * height and color of the shape.
 */
public class MyRectangle extends AbstractViewShape implements IViewShape {

  /**
   * Constructs an object for the Rectangle shape of animation given its x,y coordinates, width,
   * height and color of the shape.
   *
   * @param x     x-coordinate of the shape.
   * @param y     y-coordinate of the shape.
   * @param w     width of the shape.
   * @param h     height of the shape.
   * @param color color of the shape.
   */
  public MyRectangle(int x, int y, int w, int h, Color color) {
    super(x, y, w, h, color);
  }

  /**
   * This method creates the oval on the screen.
   *
   * @param g The graphics object.
   */
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y, w, h);
  }
}
