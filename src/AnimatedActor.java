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
