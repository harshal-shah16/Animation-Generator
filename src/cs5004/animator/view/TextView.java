package cs5004.animator.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.IAnimation;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Transformations;

/**
 * This class represents the creation of Textual view of the animations.
 */
public class TextView implements IView {

  // This method is not supported in this class.
  @Override
  public void draw(List<IShape> shapes) {
    throw new UnsupportedOperationException();
  }

  /**
   * This method creates the string representation of the animations happening.
   *
   * @param speed      Speed of the animation.
   * @param shapes     Hashmap of all the shapes.
   * @param animations Linked Hashmap of all the animations happening on a shape.
   * @return textual view of the animation as a string representation.
   */
  public String textView(int speed, HashMap<String, IShape> shapes, LinkedHashMap<IAnimation,
          String> animations) throws IllegalArgumentException {

    if (speed <= 0) {
      throw new IllegalArgumentException("Speed cannot be less than or equal to zero");
    }

    StringBuilder stringBuilder = new StringBuilder();


    //This loop prints out all shapes with their attributes
    for (Map.Entry<String, IShape> entry : shapes.entrySet()) {


      stringBuilder.append("Create " + entry.getValue().getColor().toString() + " color " +
              entry.getValue().getShapeType() + " " + entry.getKey());

      if (entry.getValue().getShapeType().equalsIgnoreCase("rectangle")) {
        stringBuilder.append(" with corner at (" + String.valueOf(entry.getValue().getX())
                + "," + String.valueOf(entry.getValue().getY()) + "), " + "width "
                + String.valueOf(entry.getValue().getParam1())
                + " and height " + String.valueOf(entry.getValue().getParam2()));
      }
      if (entry.getValue().getShapeType().equalsIgnoreCase("ellipse")) {

        stringBuilder.append(" with center at (" + String.valueOf(entry.getValue().getX())
                + "," + String.valueOf(entry.getValue().getY()) + "), " + "radius "
                + String.valueOf(entry.getValue().getParam1())
                + " and " + String.valueOf(entry.getValue().getParam2()));
      }
      stringBuilder.append("\n");
    }

    //This loop prints out all shapes appearance and disappearance time.
    stringBuilder.append("\n");
    for (Map.Entry<String, IShape> entry : shapes.entrySet()) {
      stringBuilder.append(entry.getKey() + " appears at time t="
              + String.valueOf((int) (entry.getValue().getStartTime() / speed))
              + " and disappears" + " at time t="
              + String.valueOf((int) (entry.getValue().getEndTime() / speed)));
      stringBuilder.append("\n");
    }

    stringBuilder.append("\n");

    //This loop prints out all the animation of the model
    for (Map.Entry<IAnimation, String> entry : animations.entrySet()) {
      if (entry.getKey().getTransformType() != Transformations.APPEAR) {
        stringBuilder.append(entry.getValue());
      }


      if (entry.getKey().getTransformType().equals(Transformations.MOVE)) {
        stringBuilder.append(" moves from (" + String.valueOf(entry.getKey().getFromX()) + ","
                + String.valueOf(entry.getKey().getFromY()) + ")" + " to ("
                + String.valueOf(entry.getKey().getToX()) + ","
                + String.valueOf(entry.getKey().getToY())
                + ") from time t="
                + String.valueOf((int) (entry.getKey().getActionStartTime() / speed))
                + " to t=" + String.valueOf((int) (entry.getKey().getActionEndTime() / speed)));
      } else if (entry.getKey().getTransformType().equals(Transformations.SCALE)) {
        stringBuilder.append(" changes width from " + String.valueOf(entry.getKey().getFromWidth())
                + " to " + String.valueOf(entry.getKey().getToWidth())
                + " and changes height from " + String.valueOf(entry.getKey().getFromHeight())
                + " to " + String.valueOf(entry.getKey().getToHeight())
                + " from t=" + String.valueOf((int) (entry.getKey().getActionStartTime() / speed))
                + " to t=" + String.valueOf((int) (entry.getKey().getActionEndTime() / speed)));
      } else if (entry.getKey().getTransformType().equals(Transformations.COLORCHANGE)) {
        stringBuilder.append(" changes color from "
                + String.valueOf(entry.getKey().getFromColor().toString())
                + " to " + String.valueOf(entry.getKey().getToColor().toString())
                + " from t=" + String.valueOf((int) (entry.getKey().getActionStartTime() / speed))
                + " to t=" + String.valueOf((int) (entry.getKey().getActionEndTime() / speed)));
      }
      if (entry.getKey().getTransformType() != Transformations.APPEAR) {
        stringBuilder.append("\n");
      }

    }
    return stringBuilder.toString();
  }

}








