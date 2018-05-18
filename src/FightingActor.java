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
        switch (currentState.get(currentState.size() -1)){
            case "WALK_LEFT":
                setAnimation(1);
                break;
            case "WALK_RIGHT":
                setAnimation(2);
                break;
            case "JUMP":
                startSequence(3);
                break;
            case "PUNCH":
                startSequence(4);
                break;
            case "KICK":
                startSequence(5);
                break;
            default:
                setAnimation(0);
        }
        for (String actions : currentState){
            switch (actions){
                case "WALK_LEFT":
                    move("LEFT");
                    setDirection("LEFT");
                    break;
                case "WALK_RIGHT":
                    move("RIGHT");
                    setDirection("RIGHT");
                    break;
                case "JUMP":
                     move("JUMP");
            }
        }
        System.out.println(currentState);
    }
    public void setState ( List<String> state) {
        currentState = state;
    }

    public List<String> getState() {
        return currentState;
    }
}
