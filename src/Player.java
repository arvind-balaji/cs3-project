import mayflower.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static mayflower.Keyboard.*;


public class Player extends AnimatedActor{
    public Player() {
        super(new String[][]{
                {"src/img/test.jpg", "src/img/test1.jpg", "src/img/test2.jpg", "src/img/test3.jpg"},
                {"src/img/test_left.jpg", "src/img/test1_left.jpg", "src/img/test2_left.jpg", "src/img/test3_left.jpg"},
                {"src/img/test_right.jpg", "src/img/test1_right.jpg", "src/img/test2_right.jpg", "src/img/test3_right.jpg"}
        });
        this.setImage("src/img/test.jpg");
        resizeAll(100, 100);
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
            }
            if (Mayflower.isKeyDown(KEY_RIGHT)) {
                move("RIGHT");
                setAnimation(2);
            }
        }else{
            setAnimation(0);
        }
    }
}
