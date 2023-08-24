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
