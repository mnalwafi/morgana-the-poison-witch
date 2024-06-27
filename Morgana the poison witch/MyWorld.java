import greenfoot.*;
import java.util.List;

public class MyWorld extends World
{
    private GreenfootSound backgroundMusic;
    private int objectAddDelay = 50; // Delay between adding objects
    private int timer = 0; // Timer for delaying object addition
    private String GameDifficulties;
    private int maxObjects = 10; // Maximum number of objects in the world
    private int minBombs = 1; // Minimum number of bombs in the world
    private int maxBombs = 2; // Maximum number of bombs in the world

    public MyWorld(String difficulties)
    {    
        super(300, 500, 1); 
        
        GreenfootImage bg = new GreenfootImage("background_1.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        this.GameDifficulties = difficulties;

        // Initialize and play background music
        backgroundMusic = new GreenfootSound("morning ambience.mp3");
        backgroundMusic.setVolume(40);
        backgroundMusic.playLoop();

        prepareStaticObjects();
    }

    public void act() {
        timer++;
        if (timer % this.objectAddDelay == 0) {
            if (getNumberOfObjects() < maxObjects) {
                addNextObject();
            }
        }
    }

    private void prepareStaticObjects()
    {
        // Ensure there is at least one bomb in the world initially
        while (getBombCount() < minBombs) {
            addObject(new bom(), Greenfoot.getRandomNumber(getWidth()), randomY());
        }
        
        kucing kucing = new kucing(this.GameDifficulties, "Stage 1");
        addObject(kucing, getWidth() / 2, 431);
        
        Fence additionalImage = new Fence();
        int x = getWidth() / 2;
        int y = getHeight() - additionalImage.getImage().getHeight() / 2;
        addObject(additionalImage, x, y);
        
        Counter counter = new Counter("");
        int counterX = getWidth() - 16 - counter.getImage().getWidth() / 2;
        int counterY = 16 + counter.getImage().getHeight() / 2;
        addObject(counter, counterX, counterY);
        
        if (this.GameDifficulties.equals("sulit")) {
            Health health = new Health("sulit", 3);
            int healthX = 16 + health.getImage().getWidth() / 2;
            int healthY = 16 + health.getImage().getHeight() / 2;
            addObject(health, healthX, healthY);
        } else {
            Health health = new Health("mudah", 5);
            int healthX = 16 + health.getImage().getWidth() / 2;
            int healthY = 16 + health.getImage().getHeight() / 2;
            addObject(health, healthX, healthY);
        }
    }

    private int randomY() {
        int minY = -250; // Minimum negative y value
        int maxY = -10; // Maximum negative y value
        return minY + Greenfoot.getRandomNumber(maxY - minY + 1);
    }

    private void addNextObject() {
        Actor nextObject = null;
        int x = 0;
        int bombCount = getBombCount();
        
        if (this.GameDifficulties.equals("sulit")) {
            if (bombCount < maxBombs && Greenfoot.getRandomNumber(2) == 0) {
                nextObject = new bom();
                x = Greenfoot.getRandomNumber(getWidth());
            } else {
                int choice = Greenfoot.getRandomNumber(4);
                switch (choice) {
                    case 0: nextObject = new makanan1(); x = Greenfoot.getRandomNumber(getWidth()); break;
                    case 1: nextObject = new makanan2(); x = Greenfoot.getRandomNumber(getWidth()); break;
                    case 2: nextObject = new makanan3(); x = Greenfoot.getRandomNumber(getWidth()); break;
                    case 3: nextObject = new makanan4(); x = Greenfoot.getRandomNumber(getWidth()); break;
                }
            }
        } else {
            if (bombCount < maxBombs && Greenfoot.getRandomNumber(3) == 0) {
                nextObject = new bom();
                x = Greenfoot.getRandomNumber(getWidth());
            } else {
                int choice = Greenfoot.getRandomNumber(4);
                switch (choice) {
                    case 0: nextObject = new makanan1(); x = Greenfoot.getRandomNumber(getWidth()); break;
                    case 1: nextObject = new makanan2(); x = Greenfoot.getRandomNumber(getWidth()); break;
                    case 2: nextObject = new makanan3(); x = Greenfoot.getRandomNumber(getWidth()); break;
                    case 3: nextObject = new makanan4(); x = Greenfoot.getRandomNumber(getWidth()); break;
                }
            }
        }

        if (nextObject != null) {
            addObject(nextObject, x, randomY());
        }
    }

    private int getNumberOfObjects() {
        List<makanan1> makanan1List = getObjects(makanan1.class);
        List<makanan2> makanan2List = getObjects(makanan2.class);
        List<makanan3> makanan3List = getObjects(makanan3.class);
        List<makanan4> makanan4List = getObjects(makanan4.class);
        List<bom> bomList = getObjects(bom.class);
        return makanan1List.size() + makanan2List.size() + makanan3List.size() + makanan4List.size() + bomList.size();
    }

    private int getBombCount() {
        List<bom> bomList = getObjects(bom.class);
        return bomList.size();
    }

    // Stop the music when the world is stopped
    public void stopped() {
        backgroundMusic.stop();
    }

    // Restart the music when the world is started
    public void started() {
        backgroundMusic.playLoop();
    }
    
    // Ensure the music stops when changing to another world
    public void changeWorld(World newWorld) {
        backgroundMusic.stop();
        Greenfoot.setWorld(newWorld);
    }
}