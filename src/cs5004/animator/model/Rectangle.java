package cs5004.animator.model;

/**
 * This class represents the shape Rectangle which is extending AbstractShape class.
 */

public class Rectangle extends AbstractShape {
  /**
   * Default constructor where the position of the lower left corner is set to (0, 0) and the width
   * and height are 1.
   */
  public Rectangle() {
    this(0, 0, 1, 1, new Color(255, 255, 255));
  }

  /**
   * Constructor which takes in all the parameters and sets the protected variables of the super
   * class.
   *
   * @param x      X-coordinate of the lower left corner's position.
   * @param y      Y-coordinate of the lower left corner's position.
   * @param width  Width of this rectangle.
   * @param height Height of this rectangle.
   * @param color  Color (RGB)
   */
  public Rectangle(int x, int y, int width, int height, Color color) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and Height of the shape must be greater" +
              " than 0");
    }

    if (color == null) {
      throw new IllegalArgumentException("Invalid color object");
    }

    super.x = x;
    super.y = y;
    super.param1 = width;
    super.param2 = height;
    super.color = color;
  }

  /**
   * This method creates String representation for the shape creation.
   *
   * @return String Representation.
   */
  public String toString() {

    return "Min corner:" + "(" + String.valueOf(this.getX()) + "," + String.valueOf(this.getY())
            + ")" + "," + " Width: " + String.valueOf(this.getParam1()) + "," + " Height: "
            + String.valueOf(this.getParam2()) + "," + " Color: " + this.color.toString();

  }

  @Override
  public String getShapeType() {
    return "Rectangle";
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

}
