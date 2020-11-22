package cs5004.animator.model;

/**
 * An interface to represent the operations offered by an IShape object.
 */
public interface IShape {

  /**
   * Getter for the x-coordinate of a particular point.
   *
   * @return The x coordinate of the point's location.
   */
  int getX();

  /**
   * Getter for the y-coordinate of a particular point.
   *
   * @return The y coordinate of the point's location.
   */
  int getY();

  /**
   * Getter for the first parameter of a particular point. Example, width for rectangle, radius for
   * oval.
   *
   * @return The first parameter of the point's location.
   */
  int getParam1();

  /**
   * Getter for the second parameter of a particular point. Example, height for rectangle
   *
   * @return The second parameter of the point's location.
   */
  int getParam2();

  /**
   * Getter for the color of the shape.
   *
   * @return the color of this shape represented by a color object of java inbuilt class for colors.
   */
  Color getColor();

  /**
   * Getter for a String representation of the shape type.
   *
   * @return String for the shape type.
   */
  String getShapeType();

  /**
   * Getter for the start time of the animation.
   *
   * @return Start time.
   */
  int getStartTime();

  /**
   * Getter for the end time of the animation.
   *
   * @return Start time.
   */
  int getEndTime();

  /**
   * Setter for x coordinate of the animation.
   *
   * @param x Integer x-coordinate.
   */
  void setX(int x);

  /**
   * Setter for y coordinate of the animation.
   *
   * @param y Integer y-coordinate.
   */
  void setY(int y);

  /**
   * Setter for width of the animation.
   *
   * @param width Integer width.
   */
  void setWidth(int width);

  /**
   * Setter for height of the animation.
   *
   * @param height Integer height.
   */
  void setHeight(int height);

  /**
   * Setter for color of the animation.
   *
   * @param color Color color.
   */
  void setColor(Color color);

  /**
   * Setter for start time of the animation.
   *
   * @param startTime Integer start time.
   */
  void setStartTime(int startTime);

  /**
   * Setter for end time of the animation.
   *
   * @param endTime Integer end time.
   */
  void setEndTime(int endTime);

}
