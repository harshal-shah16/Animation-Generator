import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import cs5004.animator.controller.IAnimatorController;
import cs5004.animator.controller.TextAnimatorController;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationModelImplBonus;
import cs5004.animator.model.IModel;
import cs5004.animator.model.IModelBonus;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.TextView;

import static org.junit.Assert.assertEquals;

/**
 * This class is for testing TextAnimatorController class.
 */


public class TextAnimatorControllerTest {


  @Test(expected = IllegalArgumentException.class)
  public void testAppendableNull() {
    AnimationBuilder<IModelBonus> builder = new AnimationModelImplBonus.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModelBonus model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = null;
    TextView textualView = new TextView();
    IAnimatorController controller = new TextAnimatorController(model, textualView ,
            1, "System.out", appendable);
    controller.animate();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSpeedInvalidValue() {
    AnimationBuilder<IModelBonus> builder = new AnimationModelImplBonus.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModelBonus model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    IAnimatorController controller = new TextAnimatorController(model, textualView ,
            0, "System.out", appendable);
    controller.animate();
  }

  @Test
  public void animate() {
    //System.out.println(System.getProperty("user.dir"));
    AnimationBuilder<IModelBonus> builder = new AnimationModelImplBonus.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModelBonus model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    IAnimatorController controller = new TextAnimatorController(model, textualView ,
            1, "System.out", appendable);
    controller.animate();
    assertEquals("Create (255,0,0) color Rectangle R with corner at (200,200)," +
            " width 50 and height 100\n" +
            "Create (0,0,255) color Ellipse C with center at (440,70), radius 120 and 60\n" +
            "\n" +
            "R appears at time t=1 and disappears at time t=100\n" +
            "C appears at time t=6 and disappears at time t=100\n" +
            "\n" +
            "R moves from (200,200) to (300,300) from time t=10 to t=50\n" +
            "R changes width from 50 to 25 and changes height from 100 to 100 from t=51 to t=70\n" +
            "R moves from (300,300) to (200,200) from time t=70 to t=100\n" +
            "C moves from (440,70) to (440,250) from time t=20 to t=50\n" +
            "C moves from (440,250) to (440,370) from time t=50 to t=70\n" +
            "C changes color from (0,0,255) to (0,170,85) from t=50 to t=70\n" +
            "C changes color from (0,170,85) to (0,255,0) " +
            "from t=70 to t=80\n", appendable.toString());

  }
}