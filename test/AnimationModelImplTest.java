import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.IAnimation;
import cs5004.animator.model.IShape;
import static org.junit.Assert.assertEquals;

/**
 * This class is for testing AnimationModelImpl class.
 */

public class AnimationModelImplTest {

  //Shapes with default values created
  @Test
  public void addShape() {
    AnimationModelImpl model = new AnimationModelImpl();
    model.addShape("R1", "rectangle");
    model.addShape("Oval1","ellipse");
    assertEquals("Shapes: \n" +
            "Name: R1\n" +
            "Type: Rectangle\n" +
            "Min corner:(0,0), Width: 1, Height: 1, Color: (255,255,255)\n" +
            "Appears at t=0\n" +
            "Disappears at t=0\n" +
            "\n" +
            "Name: Oval1\n" +
            "Type: Ellipse\n" +
            "Center:(0,0), X Radius: 1, Y Radius: 1, Color: (1,1,1)\n" +
            "Appears at t=0\n" +
            "Disappears at t=0\n\n", model.getState());
  }

  @Test
  public void emptyAnimation() {
    AnimationModelImpl model = new AnimationModelImpl();
    assertEquals("Shapes: \n", model.getState());
  }

  @Test
  public void addAction() {
    AnimationModelImpl model = new AnimationModelImpl();
    model.addShape("R1", "rectangle");
    //Two motions are happening at the same interval
    model.addAction("R1",2,2,4,5,10,100,100,100,
            20,4,8, 5, 10, 200,200,200 );
    assertEquals("Shapes: \n" +
            "Name: R1\n" +
            "Type: Rectangle\n" +
            "Min corner:(2,4), Width: 5, Height: 10, Color: (100,100,100)\n" +
            "Appears at t=2\n" +
            "Disappears at t=20\n" +
            "\n" +
            "Shape R1  moves from (2,4) to (4,8) from t=2 to t=20\n" +
            "Shape R1 changes color from  (100,100,100) to (200,200,200) " +
            "from t=2 to t=20\n", model.getState());

  }

  //Trying to add animation to a shape which does not exist/not declared
  @Test(expected = IllegalArgumentException.class)
  public void addActionTwo() {
    AnimationModelImpl model = new AnimationModelImpl();
    model.addShape("R1", "rectangle");
    model.addAction("A1",2,2,4,5,10,100,100,100,
            20,4,8, 5, 10, 200,200,200 );
  }

  //t2 < t1
  @Test(expected = IllegalArgumentException.class)
  public void addActionThree() {
    AnimationModelImpl model = new AnimationModelImpl();
    model.addShape("R1", "rectangle");
    model.addAction("R1",100,2,4,5,10,100,100,100,
            90,4,8, 5, 10, 200,200,200 );
  }


  @Test
  public void getShapesAtFrame() {
    AnimationModelImpl model = new AnimationModelImpl();
    model.addShape("R1", "rectangle");
    model.addShape("Oval1","ellipse");
    model.addAction("R1",2,2,4,5,10,200,200,200,
            20,4,8, 5, 10, 200,200,200 );
    model.addAction("Oval1",2,2,4,5,10,200,200,200,
            30,4,8, 5, 10, 200,200,200 );
    model.createShapesAtTickTable();

    //Two shapes have each 1 attribute (location) changing at tick 3
    List<IShape> shapesAtTickThree = model.getShapesAtFrame(3);
    assertEquals("[Min corner:(2,4), Width: 5, Height: 10, Color: (200,200,200)," +
            " Center:(2,4), X Radius: 5, Y Radius: 10, Color: (200,200,200)]",
            shapesAtTickThree.toString());

    //Only 1 shape which has only 1 attribute(location) changing at tick 23
    List<IShape> shapesAtTickTwentyThree = model.getShapesAtFrame(23);
    assertEquals("[Center:(3,7), X Radius: 5, Y Radius: 10, Color: (200,200,200)]",
            shapesAtTickTwentyThree.toString());

    try {
      List<IShape> shapesAtTickThirtyThree = model.getShapesAtFrame(33);
    }
    catch (NullPointerException e) {
      //No animations at tick 33 - So list should be empty
    }

  }

  @Test
  public void getShapes() {
    AnimationModelImpl model = new AnimationModelImpl();
    model.addShape("R1", "rectangle");
    model.addShape("Oval1","ellipse");
    HashMap<String, IShape> shapeList = new HashMap<>();
    shapeList = model.getShapes();
    assertEquals("[R1, Oval1]",shapeList.keySet().toString());
  }

  @Test
  public void getAnimations() {
    AnimationModelImpl model = new AnimationModelImpl();
    model.addShape("R1", "rectangle");
    //Two motions are happening at the same interval
    model.addAction("R1",2,2,4,5,10,100,100,100,
            20,4,8, 5, 10, 200,200,200 );
    HashMap<IAnimation, String> animationList = new HashMap<>();
    animationList = model.getAnimations();
    assertEquals("[ moves from (2,4) to (4,8) from t=2 to t=20\n" +
            ", changes color from  (100,100,100) to (200,200,200) from t=2 to t=20\n" +
            "]", animationList.keySet().toString());
  }

}