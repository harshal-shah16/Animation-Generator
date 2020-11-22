package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import cs5004.animator.model.IShape;

/**
 * This class represents the creation of Visual view of the animations.
 */
public class VisualView extends JFrame implements IView {
  JButton playButton;
  JButton restartButton;
  JButton stopButton;
  JButton showAllShapesButton;
  JButton removeShapeButton;
  JComboBox shapesCombobox;
  private CanvasPanel panel;
  private JMenuItem saveItem;
  JFileChooser fileChooser = new JFileChooser();

  /**
   * This method creates the Visual/graphical representation of the animations happening.
   *
   * @param x      x-coordinate of the canvas
   * @param y      y-coordinate of the canvas.
   * @param width  width of the canvas.
   * @param height height of the canvas.
   */
  public VisualView(int x, int y, int width, int height) {
    super();
    setSize(1000, 1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel animationControlPanel = new JPanel();
    playButton = new JButton("Play");
    restartButton = new JButton("Restart");
    stopButton = new JButton("Stop");
    playButton.setActionCommand("Start Button");
    restartButton.setActionCommand("Restart Button");
    stopButton.setActionCommand("Stop Button");

    JPanel shapesViewPanel = new JPanel();

    showAllShapesButton = new JButton("Show All Shapes");
    showAllShapesButton.setActionCommand("Show All Shapes Button");
    removeShapeButton = new JButton("Remove Shape");
    removeShapeButton.setActionCommand("Remove Shape");
    shapesCombobox = new JComboBox();
    shapesViewPanel.add(showAllShapesButton);
    shapesViewPanel.add(shapesCombobox);
    shapesViewPanel.add(removeShapeButton);
    animationControlPanel.add(playButton);
    animationControlPanel.add(stopButton);
    animationControlPanel.add(restartButton);
    panel = new CanvasPanel(width, height);
    panel.setPreferredSize(new Dimension(x, y));
    JScrollPane scrollPane = new JScrollPane(panel);
    add(animationControlPanel, BorderLayout.LINE_START);
    add(shapesViewPanel, BorderLayout.PAGE_START);
    add(scrollPane, BorderLayout.CENTER);

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");  ;
    saveItem = new JMenuItem("Save");
    saveItem.setActionCommand("Save File");
    menu.add(saveItem);
    menuBar.add(menu);
    setJMenuBar(menuBar);

    setVisible(true);
  }


  /**
   * This method sets the listeners for buttons added to the visual view panel from which
   * we would like to trigger action calls when user presses the button
   *
   * @param listener
   */

  public void setListener(ActionListener listener) {
    playButton.addActionListener(listener);
    restartButton.addActionListener(listener);
    stopButton.addActionListener(listener);
    showAllShapesButton.addActionListener(listener);
    removeShapeButton.addActionListener(listener);
    saveItem.addActionListener(listener);
    fileChooser.addActionListener(listener);
  }


  /**
   * This method displays save file dialog box. It pre-populates save file type as .txt
   * extension. So that user just needs to enter the file name and file select file path
   * where textual view of the animation would be saved.
   */

  public void showFileChooser(){
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt",
            "txt"));
    fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt","txt"));
    fileChooser.showSaveDialog(this);
  }

  /**
   * This method draws the shape on the canvas given the type of shape.
   *
   * @param shapes List of shapes.
   */
  @Override
  public void draw(List<IShape> shapes) {
    panel.clearShapes();
    shapes.forEach((shape) -> {
      if (shape.getShapeType().equalsIgnoreCase("Rectangle")) {
        Color color = new Color(shape.getColor().getRed(), shape.getColor().getGreen(),
                shape.getColor().getBlue());
        IViewShape viewShape = new MyRectangle(shape.getX(), shape.getY(), shape.getParam1(),
                shape.getParam2(), color);
        panel.drawShape(viewShape);
      }
      if (shape.getShapeType().equalsIgnoreCase("Ellipse")) {
        Color color = new Color(shape.getColor().getRed(),
                shape.getColor().getGreen(), shape.getColor().getBlue());
        IViewShape viewShape = new MyOval(shape.getX(), shape.getY(),
                shape.getParam1(), shape.getParam2(), color);
        panel.drawShape(viewShape);
      }
    });
    panel.repaint();
  }


  /**
   * This method populates the drop down box with all shape IDs when
   * Show All Shapes box is pressed
   *
   * @param shapeIds List of shapes.
   */

  public void setDropdownItems(List<String> shapeIds) {
    this.shapesCombobox.removeAllItems();
    for (String shapeId : shapeIds) {
      this.shapesCombobox.addItem(shapeId);
    }
  }


  /**
   * This method returns the shape ID selected from drop-down box that
   * needs to be removed from model's shape and animation list.
   */

  public String getSelectedItem() {
    Object selectedItem = this.shapesCombobox.getSelectedItem();
    if (selectedItem != null) {
      return this.shapesCombobox.getSelectedItem().toString();
    }
    return "";
  }

}


