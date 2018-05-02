import mayflower.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static mayflower.Keyboard.*;


public class Player extends AnimatedActor{
    public Player() {
        super(new String[][]{{"src/img/test.jpg", "src/img/test1.jpg", "src/img/test2.jpg", "src/img/test3.jpg"}});
        this.setImage("src/img/test.jpg");
    }

    public void act(){
        super.act();
        if(Mayflower.isKeyDown(KEY_UP)){
            move("JUMP");
        }
        if(Mayflower.isKeyDown(KEY_LEFT)){
            move("LEFT");
        }
        if(Mayflower.isKeyDown(KEY_RIGHT)){
            move("RIGHT");
        }

    }
}
