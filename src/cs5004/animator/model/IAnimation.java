package cs5004.animator.model;

/**
 * This Interface defines the methods provided by a class that creates and modifies animations that
 * will be performed by shapes given to it as parameters.
 */
public interface IAnimation {

  /**
   * Getter for Transformation type on a particular shape.
   *
   * @return The particular transformation on a shape.
   */
  Transformations getTransformType();

  /**
   * Getter for the start time frame of any action on a shape.
   *
   * @return The start time of any transformation type/action on a shape.
   */
  int getActionStartTime();

  /**
   * Getter for the end time frame of any action on a shape.
   *
   * @return The end time of any transformation type/action on a shape.
   */
  int getActionEndTime();

  /**
   * Getter for the new width of a shape after animation/transformation is performed.
   *
   * @return The new width of the shape.
   */
  int getToWidth();

  /**
   * Getter for the new height of a shape after animation/transformation is performed.
   *
   * @return The new height of the shape.
   */
  int getToHeight();

  /**
   * This method creates a string representation of the animation.
   *
   * @return The string Representation.
   */
  String toString();

  /**
   * Getter for the new x-coordinate of a shape after animation/transformation is performed.
   *
   * @return The new x-coordinate of the shape.
   */
  int getToX();

  /**
   * Getter for the new y-coordinate of a shape after animation/transformation is performed.
   *
   * @return The new y-coordinate of the shape.
   */
  int getToY();

  /**
   * Getter for the x-coordinate of a shape from where the animation starts.
   *
   * @return The starting x-coordinate of the shape.
   */
  int getFromX();

  /**
   * Getter for the y-coordinate of a shape from where the animation starts.
   *
   * @return The starting y-coordinate of the shape.
   */
  int getFromY();

  /**
   * Getter for the width of a shape when the animation starts.
   *
   * @return The starting width of the shape.
   */
  int getFromWidth();

  /**
   * Getter for the height of a shape when the animation starts.
   *
   * @return The starting height of the shape.
   */
  int getFromHeight();

  /**
   * Getter for the color of a shape when the animation starts.
   *
   * @return The starting color of the shape.
   */
  Color getFromColor();

  /**
   * Getter for the new color of a shape after animation/transformation is performed.
   *
   * @return The new color of the shape.
   */
  Color getToColor();

}
