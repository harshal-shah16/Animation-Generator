package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.util.AnimationBuilder;


/**
 * This class represents the animations performed on a shape with the given parameters.Model
 * containing the shapes and associated animations for a given animation session.  A unique string
 * ID is associated with each shape. A shape's animation can be found in a second mapping. This
 * modularity allows for ease of applying the same animation to multiple shapes.
 */
public class AnimationModelImpl implements IModel {

  public static Canvas SCREEN;
  private  ShapeFactory factory;
  protected  LinkedHashMap<IAnimation, String> animations;
  protected  HashMap<String, IShape> shapes;
  static HashMap<Integer, List<IShape>> shapesAtFrame;
  private  TransformationFactory transformFactory;

  /**
   * Default constructor when no parameters are given.
   */
  public AnimationModelImpl() {

    this.animations = new LinkedHashMap<>();
    this.shapes = new HashMap<>();
    this.factory = new ShapeFactory();
    this.transformFactory = new TransformationFactory();
    SCREEN = new Canvas();
    this.shapesAtFrame = new HashMap<>();

  }

  /**
   * This method adds shapes to the hashmap taking various shape inputs and ID as the key.
   *
   * @param id   String ID of the shape.
   * @param type The shape type i.e. Rectangle, oval.
   * @throws IllegalArgumentException if ID of the shape and type of the shape is null and if shape
   *                                  with provided Identifier already exists.
   */
  public void addShape(String id, String type) throws
          IllegalArgumentException {

    if (id == null || type == null) {
      throw new IllegalArgumentException("Shape identifier or its type cannot be null");
    }

    IShape shape = this.factory.createShape(type);

    if (!shapes.containsKey(id)) {
      shapes.put(id, shape);
    } else {
      throw new IllegalArgumentException("Shape with provided Identifier already exists");
    }

  }

  /**
   * This method add other transformations/animations to a particular shape given all the inputs.
   *
   * @param name String Name/Id of the shape.
   * @param t1 Integer Starting time of the animation.
   * @param x1 Integer x-coordinate from where the animation is starting.
   * @param y1 Integer y-coordinate from where the animation is starting.
   * @param w1 Integer width of the animation in starting.
   * @param h1 Integer height of the animation in starting.
   * @param r1 starting R component of color.
   * @param g1 starting G component of color.
   * @param b1 starting B component of color.
   * @param t2 Integer end time of the animation.
   * @param x2 Integer x-coordinate up to where the animation last.
   * @param y2 Integer y-coordinate up to where the animation last.
   * @param w2 Integer width of the animation in end.
   * @param h2 Integer width of the animation in end.
   * @param r2 End R component of color.
   * @param g2 End G component of color.
   * @param b2 End B component of color.
   * @throws IllegalArgumentException if start time and end time is less than 0 or is equal to each
   *                                  other and if incorrect id of shape.
   */
  public void addAction(String name, int t1, int x1, int y1, int w1,
                        int h1, int r1, int g1, int b1, int t2, int x2,
                        int y2, int w2, int h2, int r2,
                        int g2, int b2) throws IllegalArgumentException {

    if (!(shapes.containsKey(name))) {
      throw new IllegalArgumentException("Incorrect id of the shape");
    }

    if (t1 < 0 || t2 < 0 || t1 > t2) {
      throw new IllegalArgumentException("Invalid start and end times");
    }

    IShape shape = shapes.get(name);

    this.transformFactory.createAnimation(name, t1, x1, y1, w1, h1, r1,
            g1, b1, t2, x2, y2, w2, h2, r2, g2, b2, animations, shapes);

  }

  /**
   * This method creates the string representation of all the animation done on a shape.
   *
   * @return The string representation of a shape after all the animation.
   */
  @Override
  public String getState() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Shapes: \n");

    for (Map.Entry<String, IShape> entry : shapes.entrySet()) {
      stringBuilder.append("Name: " + entry.getKey() + "\n");
      stringBuilder.append("Type: " + entry.getValue().getShapeType() + "\n");
      stringBuilder.append(entry.getValue().toString());
      stringBuilder.append("\n");
      stringBuilder.append("Appears at t="
              + entry.getValue().getStartTime() + "\n");
      stringBuilder.append("Disappears at t="
              + entry.getValue().getEndTime() + "\n");
      stringBuilder.append("\n");
    }

    for (Map.Entry<IAnimation, String> entry : animations.entrySet()) {
      try {
        if (!entry.getKey().getTransformType().equals(Transformations.APPEAR)) {
          stringBuilder.append("Shape " + entry.getValue() + " " + entry.getKey().toString());
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

    }

    return stringBuilder.toString();
  }

  /**
   * This method calculates the intermediate state of shape at any time.
   *
   * @param initialValue Initial value of any attribute for which we want to calculate tweening.
   * @param endValue End value of any attribute for which  we want to calculate tweening.
   * @param startTime Start time of the animation
   * @param endTime End time of the animation.
   * @param tick Specific value at which we want to determine the intermediate state of
   *             the attribute
   * @return returns the value of attribute which is in an intermediate state of the animation
   *          during that specified tick.
   */
  private int getTweenResult(double initialValue, double endValue, double startTime,
                                     double endTime, double tick) {
    //No Tweening Required if any of the below conditions are met
    if (initialValue == endValue || startTime == endTime) {
      return (int)endValue;
    }
    double value = (initialValue * ((endTime - tick) / (endTime - startTime))
            + endValue * ((tick - startTime) / (endTime - startTime)));
    return (int) value;
  }

  /**
   * This method creates a list of shapes that exist for each tick in the animation.
   */
  public void createShapesAtTickTable() {
  if (animations.size()==0){
    shapesAtFrame.clear();
    return;
  }
    System.out.println("tick table being created");
    List<Integer> startTimes = new ArrayList<>();
    List<Integer> endTimes = new ArrayList<>();

    for (IAnimation animation : animations.keySet()) {
      startTimes.add(animation.getActionStartTime());
      endTimes.add(animation.getActionEndTime());
    }

    //Get the start-tick and end-tick of the animation
    int minIndex = startTimes.indexOf(Collections.min(startTimes));
    int startTick = startTimes.get(minIndex);
    int maxIndex = endTimes.indexOf(Collections.max(endTimes));
    int endTick = endTimes.get(maxIndex);


    for (int i = startTick; i <= endTick; i++) {
      List<IShape> newShapes = new ArrayList<>();
      LinkedHashMap<IAnimation, String> selectAnimations = new LinkedHashMap<>();

      for (Map.Entry<IAnimation, String> entry : animations.entrySet()) {
        if ((entry.getKey().getActionStartTime() <= i && i <= entry.getKey().getActionEndTime())) {
          selectAnimations.put(entry.getKey(), entry.getValue());
        }
      }

      //Get intermediate shape states
      for (Map.Entry<IAnimation, String> entry : selectAnimations.entrySet()) {

        int height = getTweenResult(entry.getKey().getFromHeight(), entry.getKey().getToHeight(),
                entry.getKey().getActionStartTime(), entry.getKey().getActionEndTime(), i);
        int width = getTweenResult(entry.getKey().getFromWidth(), entry.getKey().getToWidth(),
                entry.getKey().getActionStartTime(), entry.getKey().getActionEndTime(), i);

        int x = getTweenResult(entry.getKey().getFromX(), entry.getKey().getToX(),
                entry.getKey().getActionStartTime(), entry.getKey().getActionEndTime(), i);
        int y = getTweenResult(entry.getKey().getFromY(), entry.getKey().getToY(),
                entry.getKey().getActionStartTime(), entry.getKey().getActionEndTime(), i);

        int r = getTweenResult(entry.getKey().getFromColor().getRed(),
                entry.getKey().getToColor().getRed(),
                entry.getKey().getActionStartTime(), entry.getKey().getActionEndTime(), i);

        int b = getTweenResult(entry.getKey().getFromColor().getBlue(),
                entry.getKey().getToColor().getBlue(),
                entry.getKey().getActionStartTime(), entry.getKey().getActionEndTime(), i);

        int g = getTweenResult(entry.getKey().getFromColor().getGreen(),
                entry.getKey().getToColor().getGreen(),
                entry.getKey().getActionStartTime(), entry.getKey().getActionEndTime(), i);

        Color color = new Color(r, g, b);

        IShape newShape = null;
        IShape shapeToAnimate = shapes.get(entry.getValue());

        if (shapeToAnimate.getShapeType().equals("Rectangle")) {
          newShape = new Rectangle(x, y, width, height, color);
        } else if (shapeToAnimate.getShapeType().equals("Ellipse")) {
          newShape = new Oval(x, y, width, height, color);
        }

        //newShapes - is list of all shapes active at specific tick "i"
        newShapes.add(newShape);

      }
      //Add newShapes list to hashmap against key of tick "i" for which list was generated
      shapesAtFrame.put(i, newShapes);
    }
    System.out.println("tick table finished");
  }

  /**
   * This method make a list of all the shapes at the particular time frame.
   *
   * @param tick The time at which we want the list of all shapes.
   * @return A list of shapes.
   */
  public List<IShape> getShapesAtFrame(int tick) {

    return shapesAtFrame.get(tick);
  }

  /**
   * A method to make a Hashmap for all Ids as keys and shapes as Value.
   *
   * @return A Hashmap of shapes.
   */
  public HashMap<String, IShape> getShapes() {
    return shapes;
  }

  /**
   * A method to make a Linked Hashmap for getting all the animations related to that shape.
   *
   * @return Linked Hashmap of all animations of a particular shape.
   */
  public LinkedHashMap<IAnimation, String> getAnimations() {
    return animations;
  }





  /**
   * A subclass which implements AnimationBuilder interface and incorporates all its methods.
   */
  public static final class Builder implements AnimationBuilder<IModel> {

    IModel model = new AnimationModelImpl();

    @Override
    public IModel build() {
      return model;
    }

    @Override
    public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
      SCREEN.setCanvasX(x);
      SCREEN.setCanvasY(y);
      SCREEN.setCanvasWidth(width);
      SCREEN.setCanvasHeight(height);
      return this;
    }

    @Override
    public AnimationBuilder<IModel> declareShape(String name, String type) {
      model.addShape(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1,
                                              int h1, int r1, int g1, int b1, int t2, int x2,
                                              int y2, int w2, int h2, int r2, int g2, int b2) {


      model.addAction(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
      return this;

    }

  }

}
