import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Homepage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Homepage extends World
{

    /**
     * Constructor for objects of class Homepage.
     * 
     */
    public Homepage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 500, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        play play = new play();
        addObject(play,153,314);
    }
}
