package cs5004.animator.view;

import java.util.List;

import cs5004.animator.model.IShape;

/**
 * This interface defines the method to be implemented by View classes which creates the animator
 * view on canvas or Terminal.
 */
public interface IView {

  /**
   * This method draws the shape on the canvas given the type of shape.
   * @param shapes List of shapes.
   */
  void draw(List<IShape> shapes);

}
