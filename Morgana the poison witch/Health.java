import greenfoot.*;  // Import Greenfoot API

public class Health extends Actor
{
    private int health; // Initial health
    private GreenfootImage fullHeart = new GreenfootImage("Heart-full.png");
    private GreenfootImage emptyHeart = new GreenfootImage("Heart-null.png");
    private int heartSize = 32; // Size of the heart images
    private String currentDifficulties;

    public Health(String difficulties, int currentHealth) {
        this.health = currentHealth;
        this.currentDifficulties = difficulties;
        fullHeart.scale(heartSize, heartSize);
        emptyHeart.scale(heartSize, heartSize);
        updateImage();
    }

    public void act() {
        // Check health status
        if (health <= 0) {
            Greenfoot.delay(1); // Short delay before switching to the end page
            Greenfoot.setWorld(new Endpage());
        }
    }

    public void reduceHealth() {
        if (health > 0) {
            health--;
            updateImage();
        }
    }

    public int getHealth() {
        return health;
    }

    private void updateImage() {
        int currentHealth = this.health;
        GreenfootImage image;
        int totalHearts;

        if (currentDifficulties.equals("sulit")) {
            image = new GreenfootImage(heartSize * 3, heartSize);
            totalHearts = 3;
        } else {
            image = new GreenfootImage(heartSize * 5, heartSize);
            totalHearts = 5;
        }
        for (int i = 0; i < totalHearts; i++) {
            if (i < currentHealth) {
                image.drawImage(fullHeart, i * heartSize, 0);
            } else {
                image.drawImage(emptyHeart, i * heartSize, 0);
            }
        }
        setImage(image);
    }
}