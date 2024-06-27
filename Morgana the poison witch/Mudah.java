import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class play here.
 * 
 * @version (a version number or a date)
 */
public class Mudah extends Actor
{
    public Mudah() {
        GreenfootImage image = new GreenfootImage("EASY.png");
        
        // Scale the image to 96x96 pixels
        image.scale(100, 40);
        
        // Set the scaled image as the actor's image
        setImage(image);
    }
    
    /**
     * Act - do whatever the play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            getImage().scale((int)Math.round(getImage().getWidth() * 0.9), (int)Math.round(getImage().getHeight() * 0.9));
        }
        
        if (Greenfoot.mouseClicked(this)) {
            IntroScene.stopBackgroundMusic(); // Stop the background music
            Greenfoot.delay(1);
            Greenfoot.setWorld(new MyWorld("mudah"));
        }
    }
}