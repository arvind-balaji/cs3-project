import mayflower.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static mayflower.Keyboard.*;


public class Player extends AnimatedActor{
    public Player() {
        super(new String[] {"src/img/makoto/idle/", "src/img/makoto/walk/", "src/img/makoto/walk/"}, new int[] {15, 40, 40});
        this.setImage("src/img/test.jpg");
    }

    public void act(){
        super.act();
        if(Mayflower.isKeyDown(KEY_UP) || Mayflower.isKeyDown(KEY_LEFT) || Mayflower.isKeyDown(KEY_RIGHT)) {
            if (Mayflower.isKeyDown(KEY_UP)) {
                move("JUMP");
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
