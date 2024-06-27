import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroScene here.
 * 
 * @version (a version number or a date)
 */
public class IntroScene extends World
{
    private static GreenfootSound backgroundMusic;
    private long startTime;

    /**
     * Constructor for objects of class IntroScene.
     */
    public IntroScene()
    {    
        super(300, 500, 1); 
        GreenfootImage bg = new GreenfootImage("MainMenu.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        // Initialize and play the background music
        backgroundMusic = new GreenfootSound("morning ambience.mp3");
        backgroundMusic.play();

        startTime = System.currentTimeMillis();
    }

    public void act()
    {
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime >= 2000) { // 2000 milliseconds = 2 seconds
            Greenfoot.setWorld(new Homepage());
        }
    }
    
    public static void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }
}