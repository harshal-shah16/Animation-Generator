package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.*;


import cs5004.animator.model.IAnimation;
import cs5004.animator.model.IModel;
import cs5004.animator.model.IModelBonus;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;

import cs5004.animator.view.TextView;
import cs5004.animator.view.VisualView;

/**
 * A class to implement the IAnimatorController Interface which is made to produce the visual
 * animation using the model and view.
 */
public class VisualAnimatorController implements IAnimatorController, ActionListener {
  private final IModelBonus model;
  private final Timer timer;
  private boolean isAnimationRunning = false;
  private int tick = 1;
  private VisualView view;
  private int speed = 1;

  /**
   * Creates a Controller for the textual output of the animator using the given model, VisualView,
   * speed.
   *
   * @param model model for the animator.
   * @param view  Type of View.
   * @param speed speed for the animator.
   * @throw IllegalArgumentException if invalid values of speed provided.
   */
  public VisualAnimatorController(IModelBonus model, VisualView view, int speed)
          throws IllegalArgumentException {
    if (speed <= 0) {
      throw new IllegalArgumentException("Speed cannot be less than or equal to 0");
    }
    int fps = (int) (1000 / speed);
    this.speed = speed;
    this.model = model;
    this.view = view;
    view.setListener(this);
    this.timer = new Timer(fps, new ActionListener() {


      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          List<IShape> shapes = model.getShapesAtFrame(tick++);
          view.draw(shapes);
        } catch (Exception exception) {
          tick = 1;
        }
      }

    });
  }

  /**
   * This method starts the animation (Either textual or Visual) after calling on the model to
   * create tick-table which creates a list of shapes that exist for each tick.
   */
  @Override
  public void animate() {
    model.createShapesAtTickTable();
    //timer.start();
    //isAnimationRunning = true;
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Save File":
        showFileChooserDialog();
        break;

      case "Start Button":
        if (!isAnimationRunning) {
          this.timer.start();
          isAnimationRunning = true;
        }
        break;

      case "Stop Button":
        if (isAnimationRunning) {
          this.timer.stop();
          isAnimationRunning = false;
        }
        break;

      case "Restart Button":
        this.tick = 1;
        if (!isAnimationRunning) {
          timer.start();
          isAnimationRunning = true;
        }
        break;

      case "Remove Shape":
        String shapeIdToRemove = view.getSelectedItem();
        if (shapeIdToRemove != "") {
          model.removeShape(shapeIdToRemove);
          displayShapesAndPopulateDropdown();
        }
        break;

      case "Show All Shapes Button":
        this.timer.stop();
        isAnimationRunning = false;
        displayShapesAndPopulateDropdown();
        break;

      case "ApproveSelection":
        JFileChooser fileChooser = (JFileChooser) e.getSource();
        File selectedFile = fileChooser.getSelectedFile();
        saveToFile(selectedFile);
    }
  }


  /**
   * This method tells view to show file chooser dialog box when user clicks on save button
   * on file menu.
   */

  private void showFileChooserDialog() {
    view.showFileChooser();
  }


  /**
   * This method tells taken in filepath of the text file given by user to where textual view
   * of the animation from visual view would be written.
   * @param filePath filepath given by the user to save the file on their system
   */

  private void saveToFile(File filePath) {
    //System.out.println(filePath.toString());
    TextView textView = new TextView();
    HashMap<String, IShape> shapes = model.getShapes();
    LinkedHashMap<IAnimation, String> animations = model.getAnimations();
    String output = textView.textView(speed, shapes, animations);
    try {
      FileWriter writer = new FileWriter(filePath + ".txt");
      writer.write(output);
      writer.close();
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }


  /**
   * This method tells taken in filepath of the text file given by user to where textual view
   * of the animation from visual view would be written.
   */

  private void displayShapesAndPopulateDropdown() {
    HashMap<String, IShape> shapes = model.getShapes();
    List<IShape> shapesToDisplay = new ArrayList<>();
    for (IShape shape : shapes.values()) {
      IShape newShape = null;
      if (shape.getShapeType().equals("Rectangle")) {
        newShape = new Rectangle(shape.getX(), shape.getY(), shape.getParam1(),
                shape.getParam2(), shape.getColor());
      } else if (shape.getShapeType().equals("Ellipse")) {
        newShape = new Oval(shape.getX(), shape.getY(), shape.getParam1(),
                shape.getParam2(), shape.getColor());
      }
      shapesToDisplay.add(newShape);
    }
    this.view.draw(shapesToDisplay);
    List<String> shapeIds = new ArrayList<>();
    for (String shapeId : shapes.keySet()) {
      shapeIds.add(shapeId);
    }
    this.view.setDropdownItems(shapeIds);
  }
}