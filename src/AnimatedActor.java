import mayflower.*;
public class AnimatedActor extends PhysicsActor {
    private Animation[] animationSet;
    private int animationIndex;
    private Timer animationTimer;
    public AnimatedActor(String[][] a) {
        animationSet =  new Animation[a.length];
        animationIndex = 0;
        for (int r=0; r<a.length; r++){
            animationSet[r] = new Animation(a[r], 100);
        }
        animationTimer = new Timer();
    }
    public AnimatedActor(String[] paths, int[] lengths){
        //String[][] ret = new String[paths.length][lengths.length];
        animationSet =  new Animation[paths.length];
        animationIndex = 0;
        animationTimer = new Timer();
        for (int i = 0; i < paths.length; i++) {
            String[] frames = new String[lengths[i]];
            for (int j = 0; j < lengths[i]; j++) {
                frames[j] = paths[i]+j+".gif";
            }
            animationSet[i] = new Animation(frames, 100);
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
    public void resize(int w, int h, int index){
        animationSet[index].resize(w,h);
    }

}
