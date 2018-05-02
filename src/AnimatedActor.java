import mayflower.*;
public class AnimatedActor extends PhysicsActor {
    private Animation[] animationSet;
    private int animationIndex;
    private Timer animationTimer;
    public AnimatedActor(String[][] a) {
        animationSet =  new Animation[a.length];
        animationIndex = 0;
        for (int r=0; r<a.length; r++){
            animationSet[r] = new Animation(a[r], 10000);
        }
        animationTimer = new Timer(10000);
    }
    public void setAnimation(int index){
        animationIndex = index;
    }
    public void act (){
        super.act();
        if(animationSet[animationIndex] != null)
        {
            System.out.println(animationTimer.isDone());
            if(animationTimer.isDone())
            {
                animationTimer.reset();
                setImage(animationSet[animationIndex].getNextFrame());
            }
        }
    }

}
