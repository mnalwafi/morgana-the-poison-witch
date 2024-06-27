import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class makanan here.
 * 
 * @version (a version number or a date)
 */
public abstract class makanan extends Actor
{
    private GreenfootSound successSound = new GreenfootSound("success2.mp3");
    
    /**
     * Act - do whatever the makanan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    abstract void cetakbaru();
    abstract void maju();
    
    void dimakan(int points){
        Counter.add(points);
        
        cetakbaru();
        getWorld().removeObject(this);
    }
    
    public void act() 
    {
        maju();
        if (getY() >= 499) {
            int newY = -Greenfoot.getRandomNumber(250);
            setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), newY);
        }
        
        if(isTouching(kucing.class)){
            successSound.setVolume(32);
            successSound.play();
            
            if (this instanceof makanan1) {
                dimakan(3);
            } else if (this instanceof makanan2) {
                dimakan(2);
            } else if (this instanceof makanan3) {
                dimakan(1);
            } else if (this instanceof makanan4) {
                dimakan(0);
            }
        }
    }    
}