import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Homepage extends World {
    private Sulit sulit;
    private Mudah mudah;
    private int fadeInStep = 0; // Langkah memudar
    private boolean fadeInStarted = false; // Status memudar

    public Homepage() {    
        super(300, 500, 1); 
        GreenfootImage bg = new GreenfootImage("MainMenu.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
    }

    public void act() {
        if (fadeInStarted) {
            fadeInObjects();
        }
    }

    private void prepare() {
        BouncingPlayer bouncingKucing = new BouncingPlayer();
        addObject(bouncingKucing, getWidth() / 2, -bouncingKucing.getImage().getHeight());

        sulit = new Sulit();
        addObject(sulit, 200, 314);
        sulit.getImage().setTransparency(0); // Awalnya transparan

        mudah = new Mudah();
        addObject(mudah, 100, 314);
        mudah.getImage().setTransparency(0); // Awalnya transparan
    }

    public void startFadeIn() {
        fadeInStarted = true;
    }

    private void fadeInObjects() {
        if (fadeInStep < 255) {
            fadeInStep += 5; // Kecepatan memudar
            sulit.getImage().setTransparency(fadeInStep);
            mudah.getImage().setTransparency(fadeInStep);
        } else {
            fadeInStarted = false; // Hentikan memudar setelah selesai
        }
    }
}