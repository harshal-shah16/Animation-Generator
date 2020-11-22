package cs5004.animator.view;

/**
 * Class designed to create the appropriate views for use by the controller.
 */
public class ViewFactory {
  /**
   * Constructs the appropriate view based on the selected type (Visual/Text).
   *
   * @param viewType     The view type(visual/text).
   * @param canvasX      The x-coordinate of canvas.
   * @param canvasY      The y-coordinate of canvas.
   * @param canvasWidth  The width of canvas.
   * @param canvasHeight The height of canvas.
   * @return The created view.
   */
  public static IView makeView(String viewType, int canvasX, int canvasY, int canvasWidth,
                               int canvasHeight) {

    IView view = null;

    if (viewType.equalsIgnoreCase("visual")) {
      view = new VisualView(canvasX, canvasY, canvasWidth, canvasHeight);
    } else {
      view = new TextView();
    }
    return view;
  }

}
