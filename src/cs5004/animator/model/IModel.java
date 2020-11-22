package cs5004.animator.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * This interface defines the methods offered by a model containing the shapes of the animation.
 */
public interface IModel {

  /**
   * This method adds shapes to the hashmap taking various shape inputs and ID as the key.
   *
   * @param id   String ID of the shape.
   * @param type The shape type i.e. Rectangle, oval.
   * @throws IllegalArgumentException if ID of the shape and type of the shape is null.
   */
  void addShape(String id, String type) throws IllegalArgumentException;

  /**
   * This method add other transformations/animations to a particular shape given all the inputs.
   *
   * @param name String Name/Id of the shape.
   * @param t1   Integer Starting time of the animation.
   * @param x1   Integer x-coordinate from where the animation is starting.
   * @param y1   Integer y-coordinate from where the animation is starting.
   * @param w1   Integer width of the animation in starting.
   * @param h1   Integer height of the animation in starting.
   * @param r1   starting R component of color.
   * @param g1   starting G component of color.
   * @param b1   starting B component of color.
   * @param t2   Integer end time of the animation.
   * @param x2   Integer x-coordinate up to where the animation last.
   * @param y2   Integer y-coordinate up to where the animation last.
   * @param w2   Integer width of the animation in end.
   * @param h2   Integer width of the animation in end.
   * @param r2   End R component of color.
   * @param g2   End G component of color.
   * @param b2   End B component of color.
   * @throws IllegalArgumentException if start time and end time is less than 0 or is equal to each
   *                                  other.
   */
  void addAction(String name, int t1, int x1, int y1, int w1,
                 int h1, int r1, int g1, int b1, int t2, int x2,
                 int y2, int w2, int h2, int r2, int g2, int b2) throws IllegalArgumentException;


  /**
   * This method creates the string representation of all the animation done on a shape.
   *
   * @return The string representation of a shape after all the animation.
   */
  String getState();

  /**
   * This method make a list of all the shapes at the particular time frame.
   *
   * @param tick The time at which we want the list of all shapes.
   * @return A list of shapes.
   */
  List<IShape> getShapesAtFrame(int tick);

  /**
   * This method creates a list of shapes that exist for each tick in the animation.
   */
  void createShapesAtTickTable();

  /**
   * A method to make a Hashmap for all Ids as keys and shapes as Value.
   *
   * @return A Hashmap of shapes.
   */
  HashMap<String, IShape> getShapes();

  /**
   * A method to make a Linked Hashmap for getting all the animations related to that shape.
   *
   * @return Linked Hashmap of all animations of a particular shape.
   */
  LinkedHashMap<IAnimation, String> getAnimations();






}

