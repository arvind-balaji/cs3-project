import mayflower.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static mayflower.Keyboard.*;


public class Player extends AnimatedActor{
    public Player() {
        super(new String[] {"src/img/makoto/idle/", "src/img/makoto/walk/", "src/img/makoto/walk/", "src/img/makoto/jump/", "src/img/makoto/punch/", "src/img/makoto/kick/"}, new int[] {15, 40, 40, 39, 14, 17});
        resize(1.5);
    }

    public void act(){
        super.act();
        if(Mayflower.isKeyDown(KEY_SPACE) || Mayflower.isKeyDown(KEY_LEFT) || Mayflower.isKeyDown(KEY_RIGHT) || Mayflower.isKeyDown(KEY_X) || Mayflower.isKeyDown(KEY_Z)) {
            if (Mayflower.isKeyDown(KEY_SPACE)) {
                startAction(3);
                move("JUMP");
            }
            if (Mayflower.isKeyDown(KEY_X)) {
                startAction(4);
            }
            if (Mayflower.isKeyDown(KEY_Z)) {
                startAction(5);
            }
            if (Mayflower.isKeyDown(KEY_LEFT)) {
                move("LEFT");
                setAnimation(1);
                setDirection("LEFT");
            }
            if (Mayflower.isKeyDown(KEY_RIGHT)) {
                move("RIGHT");
                setDirection("RIGHT");
                setAnimation(2);
            }
        }else{
            setAnimation(0);
        }
    }
}
