import mayflower.*;

import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class FightingActor extends AnimatedActor{
    List<String> currentState;
    public FightingActor(String[] paths, int[] lengths, String fileType) {
        super(paths, lengths, fileType);
        currentState = new ArrayList<String>();
        currentState.add("IDLE");
        //this.setImage("src/img/test.jpg");
        resize(1.5);
    }

    public void act(){
        super.act();
        switch (currentState.get(0)){
            case "WALK_LEFT":
                setAnimation(1);
            case "WALK_RIGHT":
                setAnimation(2);
            case "JUMP":
                startSequence(3);
            case "PUNCH":
                startSequence(4);
            case "KICK":
                startSequence(5);
            default:
                setAnimation(0);
        }
        for (String actions : currentState){
            switch (actions){
                case "WALK_LEFT":
                    move("LEFT");
                    setDirection("LEFT");
                case "WALK_RIGHT":
                    move("RIGHT");
                    setDirection("RIGHT");
                case "JUMP":
                    move("JUMP");
            }
        }
        System.out.println(currentState.toArray().toString());
    }
    public void setState ( List<String> state) {
        currentState = state;
    }
}
