import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class makanan1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class makanan1 extends makanan
{
    /**
     * Act - do whatever the makanan1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public makanan1() {
        GreenfootImage image = new GreenfootImage("Potion-high.png");
        image.scale(36, 36);
        
        // Set the scaled image as the actor's image
        setImage(image);
    }
    
    void cetakbaru(){
        makanan1 makanan1 = new makanan1();
        getWorld().addObject(makanan1,Greenfoot.getRandomNumber(300),0);
    }
    void maju(){
        setLocation(getX(), getY()+3);
    }
    public void act(){
        super.act();
    }     
}
