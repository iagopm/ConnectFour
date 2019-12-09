package animationLogic;

import application.GameApplication;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import model.Chip;

public class AnimationFacadeImpl implements AnimationFacade {
    public GameApplication application;
    public AnimationFacadeImpl(GameApplication application) {
        this.application = application;
    }
    public void animate(Chip chip) {
      
    }
}
