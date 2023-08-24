import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
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
        kucing kucing = new kucing();
        addObject(kucing,145,431);
        Counter counter = new Counter("Score : ");
        addObject(counter,53,476);
        Counter2 counter2 = new Counter2("HP : ");
        addObject(counter2,243,475);
        makanan1 makanan1 = new makanan1();
        addObject(makanan1,78,106);
        makanan1 makanan12 = new makanan1();
        addObject(makanan12,256,182);
        makanan2 makanan2 = new makanan2();
        addObject(makanan2,133,231);
        makanan2 makanan22 = new makanan2();
        addObject(makanan22,218,37);
        makanan3 makanan3 = new makanan3();
        addObject(makanan3,169,124);
        makanan3 makanan32 = new makanan3();
        addObject(makanan32,23,191);
        bom bom = new bom();
        addObject(bom,231,191);
        bom bom2 = new bom();
        addObject(bom2,150, 120);
}
}
