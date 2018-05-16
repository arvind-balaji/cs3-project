import mayflower.*;
import java.util.ArrayList;
import static mayflower.Keyboard.*;
public class Player extends FightingActor{
    public Player() {
        super(
            new String[] {
                "src/img/makoto/idle/",
                "src/img/makoto/walk/",
                "src/img/makoto/walk/",
                "src/img/makoto/jump/",
                "src/img/makoto/punch/",
                "src/img/makoto/kick/"
            },
            new int[] {
                16,
                40,
                40,
                35,
                14,
                17
            },
            ".gif"
        );
        resize(1.5);
    }

    public void act(){
        super.act();
        ArrayList<String> state = new ArrayList<String>();
        state.add("IDLE");
        if (Mayflower.isKeyDown(KEY_SPACE)) {
            state.add("JUMP");
        }
        if (Mayflower.isKeyDown(KEY_X)) {
            state.add("KICK");
        }
        if (Mayflower.isKeyDown(KEY_Z)) {
            state.add("PUNCH");
        }
        if (Mayflower.isKeyDown(KEY_LEFT)) {
            state.add("WALK_LEFT");
        }
        if (Mayflower.isKeyDown(KEY_RIGHT)) {
            state.add("WALK_RIGHT");
        }
        setState(state);
    }
}
