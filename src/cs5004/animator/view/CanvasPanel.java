package cs5004.animator.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * This class creates Canvas panel using JPanel.
 */
public class CanvasPanel extends JPanel {
  private List<IViewShape> shapes;

  /**
   * Constructs a Canvas Panel given the required width and height of the panel.
   *
   * @param width Width of the panel.
   * @param height Height of the panel.
   */
  public CanvasPanel(int width, int height) {
    setPreferredSize(new Dimension(width, height));
    shapes = new ArrayList<>();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (IViewShape shape : shapes) {
      shape.draw(g);
    }
  }

  /**
   * This method add shapes that are need to be drawn on the screen.
   * @param shape The shape to be added.
   */
  public void drawShape(IViewShape shape) {
    shapes.add(shape);
  }

  /**
   * This method clears the shape.
   */
  public void clearShapes() {
    this.shapes.clear();
  }

}
