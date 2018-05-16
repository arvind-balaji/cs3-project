import mayflower.*;
import java.util.*;

public class PhysicsActor extends Actor{
    private double vSpeed;
    private int speed;
    private boolean isJumping;
    private Timer jumpTimer;
    private int height;
    private int width;

    public PhysicsActor() {
        height = -1;
        width = 100;
        isJumping = false;
        jumpTimer = new Timer();
        speed = 5;
        vSpeed = 1.00;
    }

    public void act() {
        if(isSunk()){
            setLocation(this.getX(), this.getY()-1);
        }

        if(this.getImage().getHeight() != height){
            setLocation(this.getX(), this.getY() + (height - this.getImage().getHeight()));
            height = this.getImage().getHeight();
        }
        if(this.getImage().getHeight() != width){
            setLocation(this.getX() + (width - this.getImage().getWidth())/2, this.getY());
            width = this.getImage().getWidth();
        }
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
    private boolean isSunk(){
        return this.getObjectsAtOffset(0, getImage().getHeight()/2 - 5, TerrainActor.class).size() > 0;

    }
}
