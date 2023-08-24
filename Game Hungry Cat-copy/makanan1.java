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
