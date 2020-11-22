package cs5004.animator.model;

/**
 * An abstract class to implement getters for IShape object and setter for start time of any
 * action.
 */
public abstract class AbstractShape implements IShape {
  protected int x;
  protected int y;
  protected int param1;
  protected int param2;
  protected Color color;
  protected int startTime;
  protected int endTime;

  /**
   * Getter for the x-coordinate of a particular point.
   *
   * @return The x coordinate of the point's location.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Getter for the y-coordinate of a particular point.
   *
   * @return The y coordinate of the point's location.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Getter for the first parameter of a particular point. Example, width for rectangle, radius for
   * oval.
   *
   * @return The first parameter of the point's location.
   */
  public int getParam1() {
    return this.param1;
  }

  /**
   * Getter for the second parameter of a particular point. Example, height for rectangle
   *
   * @return The second parameter of the point's location.
   */
  public int getParam2() {
    return this.param2;
  }

  /**
   * Getter for the color of the shape.
   *
   * @return the color of this shape represented by a color object of java inbuilt class for colors.
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Getter for a String representation of the shape type.
   *
   * @return String for the shape type.
   */
  public abstract String getShapeType();

  /**
   * Setter for start time of the animation.
   *
   * @param startTime Integer start time.
   */
  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  /**
   * Setter for end time of the animation.
   *
   * @param endTime Integer end time.
   */
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  /**
   * Getter for the start time of the animation.
   *
   * @return Start time.
   */
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Getter for the end time of the animation.
   *
   * @return end time.
   */
  public int getEndTime() {
    return this.endTime;
  }

}
