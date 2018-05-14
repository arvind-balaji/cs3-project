import mayflower.*;
public class AnimatedActor extends PhysicsActor {
    private Animation[] animationSet;
    private int animationIndex;
    private int sequenceIndex;
    private Timer animationTimer;
    private String currentDirection;

    // directly pass in 2d array of file paths.
    // each array is the set a file paths for a single animation, each row is a different animation
    public AnimatedActor(String[][] a) {
        currentDirection = "RIGHT";
        animationSet =  new Animation[a.length];
        animationIndex = 0;
        sequenceIndex =  -1;
        for (int r=0; r<a.length; r++){
            animationSet[r] = new Animation(a[r], 10);
        }
        animationTimer = new Timer();
        this.setImage(a[0][0]);
    }

    public AnimatedActor(String[] paths, int[] lengths){
        this(paths, lengths, ".gif");
    }

    // pass in array of directories for each animation and corresponding array of frame lengths
    public AnimatedActor(String[] paths, int[] lengths, String fileType){
        //String[][] ret = new String[paths.length][lengths.length];
        currentDirection = "RIGHT";
        animationSet =  new Animation[paths.length];
        animationIndex = 0;
        sequenceIndex = -1;
        animationTimer = new Timer();
        for (int i = 0; i < paths.length; i++) {
            String[] frames = new String[lengths[i]];
            for (int j = 0; j < lengths[i]; j++) {
                frames[j] = paths[i]+j+fileType;
            }
            animationSet[i] = new Animation(frames, 30);
        }
        this.setImage(paths[0]+"0"+fileType);
    }

    public void act (){
        super.act();
        if(sequenceIndex < 0){
            runLoop();
        }else{
            runSequence();
        }

    }

    public void setAnimation(int index){
        animationIndex = index;
    }
    public void startSequence(int index) {
        sequenceIndex = index;
    }

    public void resize(int w, int h){
        for (int i = 0; i < animationSet.length; i++) {
            animationSet[i].resize(w,h);
        }
    }
    public void resize(double f){
        for (int i = 0; i < animationSet.length; i++) {
            animationSet[i].resize(f);
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

    private void runLoop(){
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
    private void runSequence(){
        if(animationSet[sequenceIndex] != null)
        {
            //System.out.println(animationTimer.getTimeLeft());
            if(animationTimer.hasTimePassed(animationSet[sequenceIndex].getFps()))
            {
                animationTimer.reset();
                setImage(animationSet[sequenceIndex].getNextFrameInSequence());
                if(animationSet[sequenceIndex].isSequenceDone())
                    sequenceIndex = -1;
            }
        }
    }
//    public void resize(int w, int h, int index){
//        animationSet[index].resize(w,h);
//    }

}
