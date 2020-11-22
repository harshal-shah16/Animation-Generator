package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cs5004.animator.util.AnimationBuilder;

public class AnimationModelImplBonus extends AnimationModelImpl implements IModelBonus {

  public AnimationModelImplBonus() {
    super();
  }

  @Override
  public void removeShape(String shapeId) {
    this.shapes.remove(shapeId);
    List<IAnimation> animationsToRemove = new ArrayList<>();
    for(Map.Entry<IAnimation, String> entry: animations.entrySet()){
      if (entry.getValue().equals(shapeId)){
        animationsToRemove.add(entry.getKey());
      }
    }
    for(IAnimation animation: animationsToRemove){
      animations.remove(animation);
    }
    createShapesAtTickTable();
  }

  /**
   * A subclass which implements AnimationBuilder interface and incorporates all its methods.
   */
  public static final class Builder implements AnimationBuilder<IModelBonus> {

    IModelBonus model = new AnimationModelImplBonus();

    @Override
    public IModelBonus build() {
      return model;
    }

    @Override
    public AnimationBuilder<IModelBonus> setBounds(int x, int y, int width, int height) {
      SCREEN.setCanvasX(x);
      SCREEN.setCanvasY(y);
      SCREEN.setCanvasWidth(width);
      SCREEN.setCanvasHeight(height);
      return this;
    }

    @Override
    public AnimationBuilder<IModelBonus> declareShape(String name, String type) {
      model.addShape(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<IModelBonus> addMotion(String name, int t1, int x1, int y1, int w1,
                                              int h1, int r1, int g1, int b1, int t2, int x2,
                                              int y2, int w2, int h2, int r2, int g2, int b2) {


      model.addAction(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
      return this;

    }

  }
}
