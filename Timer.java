/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer  
{
    // instance variables - replace the example below with your own
    private long start;
    /**
     * Constructor for objects of class Timer
     */
    public Timer()
    {
        start = System.currentTimeMillis();        
    }
    public long getTimePassed()
    {
        long diff = System.currentTimeMillis() - start;
        return diff;
    }
    public boolean hasTimePassed(long x)
    {
        if(x > getTimePassed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void reset()
    {
        start = System.currentTimeMillis();
    }
}



