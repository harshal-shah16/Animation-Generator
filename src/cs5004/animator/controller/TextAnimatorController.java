package cs5004.animator.controller;

import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IModelBonus;
import cs5004.animator.view.TextView;

/**
 * A class to implement the IAnimatorController Interface which is made to produce the textual
 * animation using the model and view.
 */
public class TextAnimatorController implements IAnimatorController {

  private int speed;
  private TextView view;
  private IModelBonus model;
  private String output;
  private Appendable out;

  /**
   * Creates a Controller for the textual output of the animator using the given model, TextView,
   * speed.
   *
   * @param model The model.
   * @param view The view.
   * @param speed The speed of animation.
   * @param output The output.
   * @param ap appendable object
   * @throws IllegalArgumentException when invalid appendable or speed values are provided
   */
  public TextAnimatorController(IModelBonus model, TextView view, int speed, String output,
                                Appendable ap) throws IllegalArgumentException {

    if (speed <= 0 || ap == null) {
      throw new IllegalArgumentException("Speed cannot be less than or equal to zero" +
              " or appendable is null");
    }

    this.speed = speed;
    this.model = model;
    this.view = view;
    this.output = output;
    this.out = ap;
  }

  /**
   * This method renders textual animation either to the console or to a text file
   * specified by user.
   * @throws IllegalStateException if string representation of textual view could not be
   *        transmitted to appendable or could not be written to a file specified by the user.
   *
   */

  public void animate() {
    //System.out.println("Output filename:   " + output);
    //Print to console if no output file is give in command line argument
    if (output.equalsIgnoreCase("System.out")) {
      try {
        this.out.append(view.textView(speed, model.getShapes(), model.getAnimations()));
      } catch (IOException e) {
        throw new IllegalStateException("Count not transmit to appendable ");
      }
    } else {
      try {
        FileWriter writer = new FileWriter(output);
        writer.write(view.textView(speed, model.getShapes(), model.getAnimations()));
        writer.close();
      } catch (IOException e) {
        throw new IllegalStateException("Could not write to file");
      }
    }
  }
}
