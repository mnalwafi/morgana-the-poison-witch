import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Endpage here.
 * 
 * @version (a version number or a date)
 */
public class Endpage extends World
{
    private GreenfootSound loseSound;

    /**
     * Constructor for objects of class Endpage.
     */
    public Endpage()
    {    
        super(300, 500, 1);
        
        // Initialize and play lose sound
        loseSound = new GreenfootSound("lose.wav");
        loseSound.setVolume(60); // Set volume if needed
        loseSound.play();
        
        GreenfootImage bg = new GreenfootImage("BGover.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
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
        addObject(exit, centerX, 440);
    }
}