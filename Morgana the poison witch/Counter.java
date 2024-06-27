import greenfoot.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 * 
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *     
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *     
 *     public void act()
 *     {
 *         actCounter.setValue(actCounter.getValue() + 1);
 *     }
 * }
 * </pre>
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public static int value;
    private static int target;
    private String prefix;
    
    public Counter()
    {
        this(new String());
        GreenfootImage image = new GreenfootImage("NULL.png");
        
        // Scale the image to 96x96 pixels
        image.scale(100, 40);
        
        // Set the scaled image as the actor's image
        setImage(image);
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        this.prefix = prefix;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public static void add(int score)
    {
        target += score;
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage("NULL.png");
        GreenfootImage text = createPixelatedText(prefix + value, 12, Color.BLACK, new Color(0, 0, 0, 0));
        image.scale(72, 32);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    private GreenfootImage createPixelatedText(String text, int fontSize, Color fontColor, Color bgColor)
    {
        try {
            // Load the pixelated font
            InputStream is = getClass().getClassLoader().getResourceAsStream("fonts/PressStart2P-Regular.ttf");
            Font pixelFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont((float) fontSize);

            // Convert Greenfoot.Color to java.awt.Color
            java.awt.Color awtFontColor = new java.awt.Color(fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue(), fontColor.getAlpha());

            // Create a temporary image to measure the text size
            BufferedImage tempImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = tempImage.createGraphics();
            g2d.setFont(pixelFont);
            int width = g2d.getFontMetrics().stringWidth(text);
            int height = g2d.getFontMetrics().getHeight();
            g2d.dispose();

            // Create the final image with the correct size
            BufferedImage finalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            g2d = finalImage.createGraphics();
            g2d.setFont(pixelFont);
            g2d.setColor(awtFontColor);
            g2d.drawString(text, 0, g2d.getFontMetrics().getAscent());
            g2d.dispose();

            // Convert BufferedImage to GreenfootImage
            GreenfootImage greenfootImage = new GreenfootImage(finalImage.getWidth(), finalImage.getHeight());
            for (int y = 0; y < finalImage.getHeight(); y++) {
                for (int x = 0; x < finalImage.getWidth(); x++) {
                    int pixel = finalImage.getRGB(x, y);
                    greenfootImage.setColorAt(x, y, new Color((pixel >> 16) & 0xff, (pixel >> 8) & 0xff, pixel & 0xff, (pixel >> 24) & 0xff));
                }
            }
            return greenfootImage;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Fallback to default font if loading fails
            return new GreenfootImage(text, fontSize, fontColor, bgColor);
        }
    }
}
