import mayflower.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static mayflower.Keyboard.*;


public class Player extends PhysicsActor{
    public Player() {
        this.setImage("img/test.jpg");
    }

    public void act(){
        super.act();

        if(Mayflower.isKeyDown(KEY_LEFT)){
            move("LEFT");
        }
        if(Mayflower.isKeyDown(KEY_RIGHT)){
            move("RIGHT");
        }
        if(Mayflower.isKeyDown(KEY_UP)){
            move("JUMP");
        }
    }
}
