import mayflower.*;

public class PhysicsActor extends Actor{
    private boolean hasLanded;
    private double vSpeed;
    private boolean isGravity;
    private int speed;
    private Timer jumpTimer;

    public PhysicsActor() {
        speed = 2;
        vSpeed = 1.00;
        hasLanded = false;
        isGravity = true;
        //jumpTimer = new Timer();
    }

    public PhysicsActor(boolean grav) {
        vSpeed = 1.00;
        hasLanded = false;
        isGravity = grav;
    }
    public void act() {

    }

    public void move(String dir){
        if(dir.equals("LEFT")){
            setLocation(this.getX() - speed, this.getY());
        }
        if(dir.equals("RIGHT")){
            setLocation(this.getX() + speed, this.getY());
        }
        if(dir.equals("JUMP")){
            setLocation(this.getX(), this.getY()-speed);
        }
    }
    private boolean isGrounded(){
        if (this.getY() <= 50){
            return true;
        }
        return false;
    }
}
