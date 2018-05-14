import mayflower.*;
public class Animation {
    private MayflowerImage[] frames;
    private int fps;
    private int currentFrame;
    private boolean isSequenceDone;

    public Animation(String[] a, int b){
        //frames = a;
        isSequenceDone = false;
        frames = new MayflowerImage[a.length];
        fps = b;
        currentFrame=0;
        for (int i=0; i<a.length; i++){
            frames[i] = new MayflowerImage(a[i]);
        }
    }
    public MayflowerImage getNextFrame() {
        isSequenceDone = false;
        MayflowerImage ret = frames[currentFrame];
        currentFrame++;
        if (currentFrame >= frames.length){
            currentFrame = 0;
        }
        return ret;
    }
    public MayflowerImage getNextFrameInSequence() {
        isSequenceDone = false;
        MayflowerImage ret = frames[currentFrame];
        currentFrame++;
        if (currentFrame >= frames.length){
            currentFrame = 0;
            isSequenceDone = true;
        }
        return ret;
    }
    public int getFps() {
        return fps;
    }

    public void resize(int w, int h) {
        for (int i=0; i < frames.length; i++){
            frames[i].scale(w, h);
        }
    }
    public void resize(double f){
        for (int i=0; i < frames.length; i++){
            frames[i].scale(f);
        }
    }
    public void flip(){
        for (int i=0; i < frames.length; i++){
            frames[i].mirrorHorizontally();
        }
    }

    public boolean isSequenceDone() {
        return isSequenceDone;
    }
}
