import mayflower.*;
public class AnimatedActor extends PhysicsActor {
    private Animation[] animationSet;
    private int animationIndex;
    private Timer animationTimer;
    private String currentDirection;
    public AnimatedActor(String[][] a) {
        currentDirection = "RIGHT";
        animationSet =  new Animation[a.length];
        animationIndex = 0;
        for (int r=0; r<a.length; r++){
            animationSet[r] = new Animation(a[r], 10);
        }
        animationTimer = new Timer();
    }
    public AnimatedActor(String[] paths, int[] lengths){
        //String[][] ret = new String[paths.length][lengths.length];
        currentDirection = "RIGHT";
        animationSet =  new Animation[paths.length];
        animationIndex = 0;
        animationTimer = new Timer();
        for (int i = 0; i < paths.length; i++) {
            String[] frames = new String[lengths[i]];
            for (int j = 0; j < lengths[i]; j++) {
                frames[j] = paths[i]+j+".gif";
            }
            animationSet[i] = new Animation(frames, 30);
        }
    }
    public void setAnimation(int index){
        animationIndex = index;
    }
    public void act (){
        super.act();
        if(animationSet[animationIndex] != null)
        {
            //System.out.println(animationTimer.getTimeLeft());
            if(animationTimer.hasTimePassed(animationSet[animationIndex].getFps()))
            {
                animationTimer.reset();
                setImage(animationSet[animationIndex].getNextFrame());
            }
        }
    }
    public void resizeAll(int w, int h){
        for (int i = 0; i < animationSet.length; i++) {
            resize(w,h,i);
        }
    }
    public void setDirection(String dir) {
        if (!dir.equals(currentDirection)){
            for (Animation animation: animationSet) {
                animation.flip();
            }
        }
        currentDirection = dir;
    }
    public void resize(int w, int h, int index){
        animationSet[index].resize(w,h);
    }

}
