import mayflower.*;

import java.util.List;

public class CollisionActor extends Actor
{
    private MayflowerImage img;
    private int[][] pixelLocation;

    public CollisionActor()
    {

    }

    public void act()
    {

    }

    @Override
    public void setImage(MayflowerImage newImage)
    {
        img = newImage;
        pixelLocation = new int[img.getWidth()][img.getHeight()];

        for(int r = 0; r < pixelLocation.length; r++)
        {
            for(int c = 0; c < pixelLocation[0].length; c++)
            {
                if(img.getColorAt(r, c).getAlpha() == 255)
                {
                    pixelLocation[r][c] = 0;
                }
                else
                {
                    pixelLocation[r][c] = 1;
                }
            }
        }

        super.setImage(img);
    }

    public boolean checkPixelCollision(CollisionActor actor)
    {
        if(!this.intersects(actor))
        {
            return false;
        }

        int currXLeft = getX();
        int currXRight = getX() + img.getWidth();
        int currYTop = getY();
        int currYBottom = getY() + img.getHeight();

        int otherXLeft = actor.getX();
        int otherXRight = actor.getX() + img.getWidth();
        int otherYTop = actor.getY();
        int otherYBottom = actor.getY() + img.getHeight();

        int mixXLeft = Math.abs(currXLeft - otherXLeft);
        int mixXRight = Math.abs(currXRight - otherXRight);
        int mixYTop = Math.abs(currYTop - otherYTop);
        int mixYBottom = Math.abs(currYBottom - otherYBottom);

        int finLeft = mixXLeft < mixXRight ? mixXLeft : mixXRight;
        int finRight = mixXLeft > mixXRight ? mixXLeft : mixXRight;
        int finTop = mixYTop < mixYBottom ? mixYTop : mixYBottom;
        int finBottom = mixYTop > mixYBottom ? mixYTop : mixYBottom;

        for(int r = finLeft; r <= finRight; r++)
        {
            for(int c = finTop; c <= finBottom; c++)
            {
                if(pixelLocation[r][c] + actor.getPixelLocation()[r][c] == 2)
                    return true;
            }
        }
        return false;
    }


    public MayflowerImage getImg() {
        return img;
    }

    public int[][] getPixelLocation() {
        return pixelLocation;
    }
}
