import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class makanan3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class makanan3 extends makanan
{
    /**
     * Act - do whatever the makanan3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public makanan3() {
        GreenfootImage image = new GreenfootImage("Potion-low.png");
        image.scale(36, 36);
        
        // Set the scaled image as the actor's image
        setImage(image);
    }
    void cetakbaru(){
        makanan3 makanan3 = new makanan3();
        getWorld().addObject(makanan3,Greenfoot.getRandomNumber(300),0);
    }
    void maju(){
        setLocation(getX(), getY()+3);
    }
    public void act() 
    {
        super.act();
    }    
}
