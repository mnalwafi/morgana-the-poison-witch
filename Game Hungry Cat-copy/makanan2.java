import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class makanan2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class makanan2 extends makanan
{
    /**
     * Act - do whatever the makanan2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    void cetakbaru(){
        makanan2 makanan2 = new makanan2();
        getWorld().addObject(makanan2 ,Greenfoot.getRandomNumber(300),0);
    }
    void maju(){
        setLocation(getX(), getY()+3);
    }
    public void act() 
    {
        super.act();
    }      
}
