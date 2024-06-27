import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class makanan4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class makanan4 extends makanan
{
    /**
     * Act - do whatever the makanan3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public makanan4() {
        GreenfootImage image = new GreenfootImage("Potion-null.png");
        image.scale(36, 36);
        
        // Set the scaled image as the actor's image
        setImage(image);
    }
    void cetakbaru(){
        makanan4 makanan4 = new makanan4();
        getWorld().addObject(makanan4,Greenfoot.getRandomNumber(300),0);
    }
    void maju(){
        setLocation(getX(), getY()+3);
    }
    public void act() 
    {
        super.act();
    } 
}
