import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Winpage here.
 * 
 * @version (a version number or a date)
 */
public class Winpage extends World
{
    private GreenfootSound nextStageSound;

    /**
     * Constructor for objects of class Winpage.
     */
    public Winpage()
    {    
        super(300, 500, 1); 
        GreenfootImage bg = new GreenfootImage("Win.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        // Initialize and play next stage sound
        nextStageSound = new GreenfootSound("nextstage.mp3");
        nextStageSound.setVolume(60); // Set volume if needed
        nextStageSound.play();
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        exit exit = new exit();
        int centerX = getWidth() / 2;
        addObject(exit, centerX, 328);
    }
}