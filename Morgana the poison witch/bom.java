import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bom extends bukanmakanan
{
    void cetakbaru(){
        bom bom = new bom();
        getWorld().addObject(bom,Greenfoot.getRandomNumber(300),0);
    }
    void maju(){
       setLocation(getX(), getY()+4);
    }    
    public void act(){
        super.act();
    }
}
