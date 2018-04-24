
import mayflower.*;

import java.awt.*;


public class Main extends World {

    public Main()
    {
        //Picture bgPicture = new Picture("src/img/BG/main.png");
        //setBackground("src/img/BG/title.png");
        Player player = new Player();
        this.addObject(player, 0, 0);
    }

    public void act()
    {
    }

}