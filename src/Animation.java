import mayflower.*;
public class Animation {
    private MayflowerImage[] frames;
    private int fps;
    private int currentFrame;

    public Animation(String[] a, int b){
        //frames = a;
        frames = new MayflowerImage[a.length];
        fps = b;
        currentFrame=0;
        for (int i=0; i<a.length; i++){
            frames[i] = new MayflowerImage(a[i]);
        }
    }
    public MayflowerImage getNextFrame() {
        MayflowerImage ret = frames[currentFrame];
        currentFrame++;
        if (currentFrame >= frames.length){
            currentFrame = 0;
        }
        return ret;
    }

}
