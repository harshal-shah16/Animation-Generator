package cs5004.animator.model;

/**
 * An abstract class for all the animation operations on a particular shape.
 */
public abstract class Animation implements IAnimation {

  protected String shapeName;
  protected int fromX;
  protected int fromY;
  protected int toX;
  protected int toY;
  protected int startTime;
  protected int endTime;
  protected Color fromColor;
  protected Color toColor;
  protected int r1;
  protected int g1;
  protected int b1;
  protected int r2;
  protected int g2;
  protected int b2;
  protected int fromWidth;
  protected int toWidth;
  protected int fromHeight;
  protected int toHeight;

  /**
   * Default constructor when no Parameters are given.
   */
  public Animation() {
    // Default Constructor.
  }

  /**
   * Constructs an object with a transformation Action for a particular shape.
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
  public Animation(String name, int t1, int x1, int y1, int w1,
                   int h1, Color fromColor, int t2, int x2,
                   int y2, int w2, int h2, Color toColor)
          throws IllegalArgumentException {

    if (t1 > t2) {
      throw new IllegalArgumentException("start time cannot be greater than endTime");
    }

    this.shapeName = name;
    this.fromX = x1;
    this.fromY = y1;
    this.toX = x2;
    this.toY = y2;
    this.fromWidth = w1;
    this.toWidth = w2;
    this.fromHeight = h1;
    this.toHeight = h2;
    this.fromColor = fromColor;
    this.toColor = toColor;
    this.startTime = t1;
    this.endTime = t2;

  }

  public abstract Transformations getTransformType();

  public int getActionStartTime() {
    return this.startTime;
  }

  public int getActionEndTime() {
    return this.endTime;
  }

  public int getFromX() {
    return this.fromX;
  }

  public int getToX() {
    return this.toX;
  }

  public int getFromY() {
    return this.fromY;
  }

  public int getToY() {
    return this.toY;
  }

  public int getFromWidth() {
    return this.fromWidth;
  }

  public int getToWidth() {
    return this.toWidth;
  }

  public int getFromHeight() {
    return this.fromHeight;
  }

  public int getToHeight() {
    return this.toHeight;
  }

  public Color getFromColor() {
    return this.fromColor;
  }

  public Color getToColor() {
    return this.toColor;
  }

}
