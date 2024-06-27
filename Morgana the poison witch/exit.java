import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exit extends Actor
{
    public exit() {
        GreenfootImage image = new GreenfootImage("MENU.png");
        
        // Scale the image to 96x96 pixels
        image.scale(100, 40);
        
        // Set the scaled image as the actor's image
        setImage(image);
    }
    /**
     * Act - do whatever the exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            getImage().scale((int)Math.round(getImage().getWidth()*0.9),(int)Math.round(getImage().getHeight()*0.9));
    } 
    if(Greenfoot.mouseClicked(this)){
        Greenfoot.delay(1);
        Greenfoot.setWorld(new Homepage());
    }
    }  
}
