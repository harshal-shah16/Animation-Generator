package cs5004.animator.model;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This class represents the Transformation factory which creates a type of transformation on a
 * shape according to the inputs given.
 */

public class TransformationFactory {

  private IAnimation animation;

  /**
   * Constructs a animation object based on the parameters given to it.
   * @param name shape name
   * @param t1 start tick of the animation
   * @param x1 current x coordinate of the shape
   * @param y1 current y coordinate of the shape
   * @param w1 current width (or outer radius) of the shape
   * @param h1 current height (or inner radius) of the shape
   * @param r1 starting R component of color of the shape
   * @param g1 starting R component of color of the shape
   * @param b1 starting R component of color of the shape
   * @param t2 Integer end tick of the animation.
   * @param x2 Integer x-coordinate of the shape up to where the animation last.
   * @param y2 Integer y-coordinate of the shape up to where the animation last.
   * @param w2 Integer width (or outer radius) of the animation at end tick
   * @param h2 Integer height(or inner radius) of the animation at end tick
   * @param r2 End R component of color of the shape
   * @param g2 End G component of color of the shape
   * @param b2 End B component of color of the shape
   */
  protected void createAnimation(String name, int t1, int x1, int y1, int w1,
                                 int h1, int r1, int g1, int b1, int t2, int x2,
                                 int y2, int w2, int h2, int r2, int g2, int b2,
                                 LinkedHashMap<IAnimation, String> animations,
                                 HashMap<String, IShape> shapes) {


    IShape shape = shapes.get(name);

    if (!animations.containsValue(name)) {
      shape.setX(x1);
      shape.setY(y1);
      shape.setWidth(w1);
      shape.setHeight(h1);
      shape.setStartTime(t1);
      shape.setColor(new Color(r1, g1, b1));
    }

    if (x1 != x2 || y1 != y2) {
      animations.put(new Move(name, t1, x1, y1, w1, h1, new Color(r1, g1, b1), t2, x2, y2, w2,
              h2, new Color(r2, g2, b2)), name);
    }
    if (r1 != r2 || g1 != g2 || b1 != b2) {
      animations.put(new ColorChange(name, t1, x1, y1, w1, h1, new Color(r1, g1, b1), t2, x2, y2,
              w2, h2, new Color(r2, g2, b2)), name);

    }
    if (w1 != w2 || h1 != h2) {
      animations.put(new Scale(name, t1, x1, y1, w1, h1, new Color(r1, g1, b1), t2, x2, y2, w2,
              h2, new Color(r2, g2, b2)), name);

    }

    if (x1 == x2 && y1 == y2 && r1 == r2 && g1 == g2 && g1 == g2 && h1 == h2 && w1 == w2) {
      animations.put(new Appear(name, t1, x1, y1, w1, h1, new Color(r1, g1, b1), t2, x2, y2, w2,
              h2, new Color(r2, g2, b2)), name);
    }

    shape.setEndTime(t2);

  }
}

