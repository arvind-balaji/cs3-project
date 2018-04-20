//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import mayflower.Mayflower;
import mayflower.World;

public class Runner extends Mayflower {
    public Runner() {
        super("Mayflower", 800, 480);
    }

    public void init() {
        Mayflower.setFullScreen(false);
        World world = new Main();
        Mayflower.setWorld(world);
    }

    public static void main(String[] args) {
        new Runner();
    }
}
