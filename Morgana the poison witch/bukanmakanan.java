import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bukanmakanan here.
 * 
 * @version (a version number or a date)
 */
public abstract class bukanmakanan extends Actor
{
    private GreenfootSound wrongSound = new GreenfootSound("wrong.wav");
    
    /**
     * Act - do whatever the bukanmakanan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    abstract void cetakbaru();
    abstract void maju();
    
    void dimakan() 
    {
        cetakbaru();
        getWorld().removeObject(this);
    }    
    
    public void act()
    {
        maju();
        if(getY() >= 499){
            setLocation(Greenfoot.getRandomNumber(300), 0);
        }

        if (isTouching(kucing.class)) {
            // Play the wrong sound
            wrongSound.setVolume(75);
            wrongSound.play();
            
            // Ensure that Health object exists before accessing it
            java.util.List<Health> healthList = getWorld().getObjects(Health.class);
            if (!healthList.isEmpty()) {
                Health health = healthList.get(0);
                health.reduceHealth();
                if (health.getHealth() <= 0) {
                    World currentWorld = getWorld();
                    if (currentWorld instanceof MyWorld) {
                        ((MyWorld) currentWorld).stopped();
                    } else if (currentWorld instanceof Stage2) {
                        ((Stage2) currentWorld).stopped();
                    } else if (currentWorld instanceof Stage3) {
                        ((Stage3) currentWorld).stopped();
                    }
                    Greenfoot.delay(1); // Short delay before switching to the end page
                    Greenfoot.setWorld(new Endpage());
                }
            }
            dimakan();
        }
    }
}