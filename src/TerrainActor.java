import mayflower.*;
public class TerrainActor extends Actor{
    public TerrainActor() {
        MayflowerImage img = new MayflowerImage("img/ground.jpg");
        img.scale(500, 100);
        this.setImage(img);
        //resizeAll(100, 100);
    }
    public void act(){

    }

}
