import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.IModel;
import cs5004.animator.model.IShape;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.TextView;
import static org.junit.Assert.assertEquals;

/**
 * This class is for testing TextView class.
 */

public class TextViewTest {

  @Test(expected = UnsupportedOperationException.class)
  public void draw() {

    AnimationBuilder<IModel> builder = new AnimationModelImpl.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModel model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    List<IShape> shapeList = new ArrayList<>();
    for (IShape shape : model.getShapes().values()) {
      shapeList.add(shape);
    }
    textualView.draw(shapeList);
  }

  @Test
  public void textViewOne() {
    AnimationBuilder<IModel> builder = new AnimationModelImpl.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModel model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    assertEquals("Create (255,0,0) color Rectangle R with corner at (200,200)," +
                    " width 50 and height 100\n" +
                    "Create (0,0,255) color Ellipse C with center at (440,70), " +
                    "radius 120 and 60\n" + "\n" +
                    "R appears at time t=1 and disappears at time t=100\n" +
                    "C appears at time t=6 and disappears at time t=100\n" +
                    "\n" +
                    "R moves from (200,200) to (300,300) from time t=10 to t=50\n" +
                    "R changes width from 50 to 25 and changes height from 100 to 100 " +
                    "from t=51 to t=70\n" +
                    "R moves from (300,300) to (200,200) from time t=70 to t=100\n" +
                    "C moves from (440,70) to (440,250) from time t=20 to t=50\n" +
                    "C moves from (440,250) to (440,370) from time t=50 to t=70\n" +
                    "C changes color from (0,0,255) to (0,170,85) from t=50 to t=70\n" +
                    "C changes color from (0,170,85) to (0,255,0) from t=70 to t=80\n",
            textualView.textView(1, model.getShapes(),model.getAnimations()));

  }


  //Trying a different speed on same input file
  @Test
  public void textViewTwo() {
    AnimationBuilder<IModel> builder = new AnimationModelImpl.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModel model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    assertEquals("Create (255,0,0) color Rectangle R with corner at (200,200)," +
                    " width 50 and height 100\n" +
                    "Create (0,0,255) color Ellipse C with center at (440,70)," +
                    " radius 120 and 60\n" +
                    "\n" +
                    "R appears at time t=0 and disappears at time t=50\n" +
                    "C appears at time t=3 and disappears at time t=50\n" +
                    "\n" +
                    "R moves from (200,200) to (300,300) from time t=5 to t=25\n" +
                    "R changes width from 50 to 25 and changes height from 100 to 100" +
                    " from t=25 to t=35\n" +
                    "R moves from (300,300) to (200,200) from time t=35 to t=50\n" +
                    "C moves from (440,70) to (440,250) from time t=10 to t=25\n" +
                    "C moves from (440,250) to (440,370) from time t=25 to t=35\n" +
                    "C changes color from (0,0,255) to (0,170,85) from t=25 to t=35\n" +
                    "C changes color from (0,170,85) to (0,255,0) from t=35 to t=40\n",
            textualView.textView(2, model.getShapes(),model.getAnimations()));

  }

  //Try Invalid Speed value
  @Test(expected = IllegalArgumentException.class)
  public void textViewThree() {
    AnimationBuilder<IModel> builder = new AnimationModelImpl.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModel model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    textualView.textView(0, model.getShapes(),model.getAnimations());
  }

  //Try Invalid Speed value
  @Test(expected = IllegalArgumentException.class)
  public void textViewFour() {
    AnimationBuilder<IModel> builder = new AnimationModelImpl.Builder();
    Readable readable;
    try {
      readable = new FileReader("smalldemo.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModel model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    textualView.textView(-1, model.getShapes(),model.getAnimations());
  }


  //Trying textual view on empty input file
  @Test
  public void textViewFive() {
    AnimationBuilder<IModel> builder = new AnimationModelImpl.Builder();
    Readable readable;
    try {
      readable = new FileReader("empty.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModel model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    assertEquals("\n\n",
            textualView.textView(1, model.getShapes(),model.getAnimations()));

  }

  //Trying textual view for input file which has declared only 1 shape and no animations
  //Default attribute values of shape and its appearing and disappearing time are set.
  @Test
  public void textViewSix() {
    AnimationBuilder<IModel> builder = new AnimationModelImpl.Builder();
    Readable readable;
    try {
      readable = new FileReader("demoOneShape.txt");
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Wrong filename given or incorrect file location");
    }
    IModel model = AnimationReader.parseFile(readable, builder);
    Appendable appendable = new StringBuilder();
    TextView textualView = new TextView();
    assertEquals("Create (255,255,255) color Rectangle R with corner at (0,0), " +
                    "width 1 and height 1\n" +
                    "\n" +
                    "R appears at time t=0 and disappears at time t=0\n" +
                    "\n",
            textualView.textView(1, model.getShapes(),model.getAnimations()));

  }
}