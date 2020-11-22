package cs5004.animator.model;

/**
 * This class makes the Canvas screen with the given x, y coordinates, width and height.
 */
public class Canvas {

  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * This is a default constructor.
   */
  public Canvas() {
    this.x = 10;
    this.y = 10;
    this.width = 500;
    this.height = 500;
  }

  /**
   * Constructs a Canvas screen with the given x, y coordinates, width and height.
   *
   * @param x      The x-coordinate of lower left portion of the canvas screen.
   * @param y      The y-coordinate of lower left portion of the canvas screen.
   * @param width  The width of the canvas screen.
   * @param height The height of the canvas screen.
   */
  public Canvas(int x, int y, int width, int height) {

    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

  }

  /**
   * The Setter for the x-coordinate of the canvas screen.
   *
   * @param x The x-coordinate.
   */
  public void setCanvasX(int x) {
    this.x = x;
  }

  /**
   * Getter for x-coordinate of the screen.
   *
   * @return The x-coordinate.
   */
  public int getX() {
    return x;
  }

  /**
   * Getter for y-coordinate of the screen.
   *
   * @return The y-coordinate.
   */
  public int getY() {
    return y;
  }

  /**
   * Getter for width of the screen.
   *
   * @return The width.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Getter for height of the screen.
   *
   * @return The height.
   */
  public int getHeight() {
    return height;
  }

  /**
   * The Setter for the y-coordinate of the canvas screen.
   *
   * @param y The y-coordinate.
   */
  public void setCanvasY(int y) {
    this.y = y;
  }

  /**
   * The Setter for the width of the canvas screen.
   *
   * @param width The width to set.
   */
  public void setCanvasWidth(int width) {
    this.width = width;
  }

  /**
   * The Setter for the height of the canvas screen.
   *
   * @param height The height to set.
   */
  public void setCanvasHeight(int height) {
    this.height = height;
  }

  /**
   * This method creates String representation for the canvas.
   *
   * @return String Representation.
   */
  public String toString() {
    return "Canvas located at (" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ") " +
            "Width: " + String.valueOf(this.width) + " Height: " + String.valueOf(this.height);
  }

}
