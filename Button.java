import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor {
    private String label;
    private String action;

    public Button(String label, String action) {
        this.label = label;
        this.action = action;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(120, 40);  
        img.setColor(Color.LIGHT_GRAY); 
        img.fillRect(0, 0, 120, 40);  

        img.setColor(Color.BLACK);  
        img.drawString(label, 30, 25);  

        setImage(img);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            performAction();
        }
    }

    private void performAction() {
        if ("Submit".equals(action)) {
            submitGuess();
        } else if ("Restart".equals(action)) {
            restartGame();
        }
    }

    private void submitGuess() {
        //System.out.println("Submit button clicked");
        
    }

    private void restartGame() {
        //System.out.println("Restart button clicked");
        Greenfoot.setWorld(new WordleWorld()); 
    }
}

