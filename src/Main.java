
import mayflower.*;

import java.awt.*;


public class Main extends World {

    public Main()
    {
        //Picture bgPicture = new Picture("src/img/BG/main.png");
        //setBackground("src/img/BG/title.png");
        TerrainActor ground = new TerrainActor();
        TerrainActor ground2 = new TerrainActor();
        Player player = new Player();
        this.addObject(player, 25, 0);
        this.addObject(ground, 20, 300);
        this.addObject(ground2, 200, 400);
        Mayflower.showBounds(true);
    }

    public void act()
    {
    }

}