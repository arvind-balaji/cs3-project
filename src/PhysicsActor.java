import mayflower.*;
import java.util.*;

public class PhysicsActor extends Actor{
    private double vSpeed;
    private int speed;
    private boolean isJumping;
    private Timer jumpTimer;

    public PhysicsActor() {
        isJumping = false;
        jumpTimer = new Timer();
        speed = 3;
        vSpeed = 1.00;
    }

    public void act() {
        //System.out.println(isGrounded());
        if(isJumping){
            jump();
        }
        if(!isGrounded()){
            setLocation(this.getX(), this.getY()+vSpeed);
            vSpeed += .1;
        }else{
            vSpeed = 1.00;
            isJumping = false;
        }

    }

    public void move(String dir){
        if(dir.equals("LEFT") && canMoveLeft()){
            setLocation(this.getX() - speed, this.getY());
        }
        if(dir.equals("RIGHT") && canMoveRight()){
            setLocation(this.getX() + speed, this.getY());
        }
        if(dir.equals("JUMP")){
            isJumping = true;
            jumpTimer.reset();
        }
    }
    private void jump(){
        setLocation(this.getX(), this.getY()-4);
    }


    private boolean isGrounded(){
        return this.getObjectsAtOffset(0, getImage().getHeight()/2, TerrainActor.class).size() > 0;

    }
    private boolean canMoveLeft(){
        return !(this.getObjectsAtOffset(-1*(getImage().getWidth()/2 + 1) , 0, TerrainActor.class).size() > 0);

    }
    private boolean canMoveRight(){
        return !(this.getObjectsAtOffset(getImage().getWidth()/2 + 1, 0, TerrainActor.class).size() > 0);

    }
}
