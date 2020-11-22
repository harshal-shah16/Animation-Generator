package cs5004.animator.model;

/**
 * This class represents the shape Oval which is extending AbstractShape class.
 */

public class Oval extends AbstractShape {

  /**
   * Default constructor where the position of the center is set to (0, 0) and the radius of the
   * xRadius is 1 and yRadius 1.
   */
  public Oval() {
    this(0, 0, 1, 1, new Color(1, 1, 1));
  }

  /**
   * Constructor which takes in all the parameters and sets the protected variables of the super
   * class accordingly.
   *
   * @param x       X-coordinate of the center.
   * @param y       Y-coordinate of the center.
   * @param xRadius Radius of the xRadius.
   * @param yRadius Radius of the yRadius.
   * @param color   RGB color code
   */
  public Oval(int x, int y, int xRadius, int yRadius, Color color) {
    if (xRadius <= 0 || yRadius <= 0) {
      throw new IllegalArgumentException("X-radius and Y-radius of the shape must be greater" +
              " than 0");
    }
    if (color == null) {
      throw new IllegalArgumentException("Invalid color object");
    }

    super.x = x;
    super.y = y;
    super.param1 = xRadius;
    super.param2 = yRadius;
    super.color = color;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void setWidth(int width) {
    this.param1 = width;
  }

  @Override
  public void setHeight(int height) {
    this.param2 = height;
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * This method creates String representation for the shape formation.
   *
   * @return String Representation.
   */
  public String toString() {

    return "Center:" + "(" + String.valueOf(this.getX()) + "," + String.valueOf(this.getY()) + ")" +
            "," + " X Radius: " + String.valueOf(this.getParam1()) + "," + " Y Radius: "
            + String.valueOf(this.getParam2()) + "," + " Color: " + this.color.toString();
  }

  @Override
  public String getShapeType() {
    return "Ellipse";
  }

}
