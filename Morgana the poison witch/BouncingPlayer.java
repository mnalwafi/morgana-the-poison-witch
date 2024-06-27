import greenfoot.*;

public class BouncingPlayer extends Actor {
    private int speed = 5; // Kecepatan jatuh awal
    private int bounceHeight = 50; // Tinggi pantulan
    private int gravity = 1; // Gravitasi
    private int maxBounce = 1; // Jumlah maksimum pantulan
    private int bounceCount = 0; // Penghitung pantulan
    private boolean finishedBouncing = false; // Status pantulan selesai

    public BouncingPlayer() {
        setImage(new GreenfootImage("player_morning.png"));
        getImage().scale(72, 72);
    }

    public void act() {
        if (!finishedBouncing) {
            setLocation(getX(), getY() + speed);
            speed += gravity;

            // Jika mencapai bagian bawah layar, lakukan pantulan
            if (getY() >= 431) {
                speed = -bounceHeight; // Membalik kecepatan untuk pantulan
                bounceCount++;
                if (bounceCount >= maxBounce) {
                    finishedBouncing = true; // Menandai pantulan selesai
                    speed = 0; // Hentikan setelah beberapa kali pantulan
                    setLocation(getX(), 431);
                    ((Homepage) getWorld()).startFadeIn(); // Panggil metode di Homepage
                }
            }
        }
    }

    public boolean isFinishedBouncing() {
        return finishedBouncing;
    }
}