package animationLogic;

import application.GameApplication;
import model.Chip;

public class AnimationFacadeImpl implements AnimationFacade {
    public GameApplication application;
    public AnimationFacadeImpl(GameApplication application) {
        this.application = application;
    }
    public void animate(Chip chip) {
//        Bounds boundsInScene = chip.localToScene(chip.getBoundsInLocal());
//        TranslateTransition translateTransition = new TranslateTransition(new Duration(1000), chip);
//        System.out.println("" + boundsInScene.getMinX() + boundsInScene.getMinY());
//        Bounds startBounds = application
//                .getBoardFacade()
//                .getColumn(
//                        chip.getColumn())
//                .get(0)
//                .localToScene(
//                        application
//                                .getBoardFacade()
//                                .getColumn(chip.getColumn())
//                                .get(0).getBoundsInLocal()
//                );
//
//        System.out.println("" + startBounds.getMinX() + startBounds.getMinX());
//
//        translateTransition.setFromY(startBounds.getMinY());
//        translateTransition.setFromX(boundsInScene.getMinY());
//
//        translateTransition.setToX(boundsInScene.getMinX());
//        translateTransition.setToY(boundsInScene.getMinY());
//
//        translateTransition.play();
    }
}
