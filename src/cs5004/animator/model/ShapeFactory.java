package cs5004.animator.model;

/**
 * This class represents the shape creation according to the given parameters.
 */

public class ShapeFactory {

  /**
   * Constructs shape as per given parameters.
   *
   * @param type Type of the shape to be created. For ex. Rectangle or circle or oval.
   * @throws IllegalArgumentException if shape type provides is null.
   */
  protected IShape createShape(String type) throws IllegalArgumentException {

    IShape shape;
    switch (type) {
      case "rectangle":
        shape = new Rectangle();
        break;
      case "ellipse":
        shape = new Oval();
        break;
      default:
        throw new IllegalArgumentException("Shape Type cannot be null");
    }

    return shape;
  }

}
