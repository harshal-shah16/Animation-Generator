package cs5004.animator.model;

/**
 * This class creates and modifies ColorChange animation to be performed by provided shape, given
 * its r, g, b components.
 */
public class ColorChange extends Animation implements IAnimation {

  /**
   * Constructs an object with the color change for the object given the ID of the shape.
   *
   * @param name      String Name/Id of the shape.
   * @param t1        Integer Starting time of the animation.
   * @param x1        Integer x-coordinate from where the animation is starting.
   * @param y1        Integer y-coordinate from where the animation is starting.
   * @param w1        Integer width of the animation in starting.
   * @param h1        Integer height of the animation in starting.
   * @param fromColor The starting color of the shape animation.
   * @param t2        Integer end time of the animation.
   * @param x2        Integer x-coordinate up to where the animation last.
   * @param y2        Integer y-coordinate up to where the animation last.
   * @param w2        Integer width of the animation in end.
   * @param h2        Integer height of the animation in end.
   * @param toColor   The end color of the shape animation.
   * @throws IllegalArgumentException if start time of the animation is greater than the end time.
   */
  public ColorChange(String name, int t1, int x1, int y1, int w1,
                     int h1, Color fromColor, int t2, int x2,
                     int y2, int w2, int h2, Color toColor)
          throws IllegalArgumentException {
    super(name, t1, x1, y1, w1, h1, fromColor, t2, x2, y2, w2, h2, toColor);

    if (t1 > t2) {
      throw new IllegalArgumentException("start time cannot be greater than endTime");
    }

  }

  @Override
  public Transformations getTransformType() {
    return Transformations.COLORCHANGE;
  }


  @Override
  public String toString() {
    return "changes color from  " + this.fromColor.toString() + " to " + this.toColor.toString()
            + " from t=" + String.valueOf(this.startTime) + " to t=" +
            String.valueOf(this.endTime) + "\n";
  }


}
