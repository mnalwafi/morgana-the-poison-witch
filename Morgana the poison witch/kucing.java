import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class kucing here.
 * 
 * @version (a version number or a date)
 */
public class kucing extends Actor
{
    int count = 0;
    GreenfootImage currentImage = getImage();
    String position = "right"; 
    String difficulties = "start";
    String stage = "start";
    
    public kucing(String difficulties, String stage) {
        this.difficulties = difficulties;
        this.stage = stage;
        // Load the initial image
        GreenfootImage image = new GreenfootImage("player_morning.png");
        
        // Scale the image to 96x96 pixels
        image.scale(72, 72);
        
        // Set the scaled image as the actor's image
        setImage(image);
        
        this.currentImage = getImage();
    }
    
    void dimakan() {
        Counter.add(1);
        getWorld().removeObject(this);
    }
    
    public void act() 
    {
        List<Health> healthList = getWorld().getObjects(Health.class);
        String exPosition = position;
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+3, getY());
            position = "right";
        } else if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-3, getY());
            position = "left";
        }
    
        if (!position.equals(exPosition)) {
            currentImage.mirrorHorizontally();
        }
        
        if(Counter.value == 10){
            int currentHealth = 3;
            if (!healthList.isEmpty()) {
                Health health = healthList.get(0);
                currentHealth = health.getHealth();
            }
            World currentWorld = getWorld();
            if (currentWorld instanceof MyWorld) {
                ((MyWorld) currentWorld).stopped();
            } else if (currentWorld instanceof Stage2) {
                ((Stage2) currentWorld).stopped();
            } else if (currentWorld instanceof Stage3) {
                ((Stage3) currentWorld).stopped();
            }
            
            if (this.stage.equals("Stage 3")) {
                Greenfoot.setWorld(new Winpage());
            } else if (this.stage.equals("Stage 2")) {
                playSoundForDuration("newstage.wav", 600);
                Greenfoot.setWorld(new Stage3(this.difficulties, currentHealth));
            } else {
                playSoundForDuration("newstage.wav", 600);
                Greenfoot.setWorld(new Stage2(this.difficulties, currentHealth));
                }
            }
    }
    
    public void playSoundForDuration(String soundFile, int durationMs) {
        GreenfootSound sound = new GreenfootSound(soundFile);
        sound.play();
        Greenfoot.delay(durationMs / 17); // Greenfoot.delay menggunakan 1/60 detik sebagai satuan waktu, jadi 17 milidetik mendekati 0,6 detik
        sound.stop();
    }
}