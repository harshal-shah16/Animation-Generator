package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;

/**
 * An abstract class to draw graphics on the screen given x,y coordinates, width, height and color
 * of the shape.
 */
public abstract class AbstractViewShape implements IViewShape {
  protected final int x;
  protected final int y;
  protected final int w;
  protected final int h;
  protected final Color color;

  /**
   * Constructs an object for the shape of animation given its x,y coordinates, width, height and
   * color of the shape.
   *
   * @param x     x-coordinate of the shape.
   * @param y     y-coordinate of the shape.
   * @param w     width of the shape.
   * @param h     height of the shape.
   * @param color color of the shape.
   */
  protected AbstractViewShape(int x, int y, int w, int h, Color color) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = color;
  }

  /**
   * This method creates the graphics on the screen.
   *
   * @param g The Graphics object.
   */
  public abstract void draw(Graphics g);
}
