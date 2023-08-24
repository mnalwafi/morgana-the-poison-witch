import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Winpage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Winpage extends World
{

    /**
     * Constructor for objects of class Endpage.
     * 
     */
    public Winpage()
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
        exit exit = new exit();
        addObject(exit,156,328);
    }
}
