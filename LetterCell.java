import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LetterCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterCell extends Actor {
    private String letter = "";
    
    public void setLetter(String letter) {
        this.letter = letter;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(40, 40);  
        img.setColor(Color.WHITE);  
        img.fillRect(0, 0, 40, 40);
        
        if (!letter.isEmpty()) {
            img.setColor(Color.BLACK);
            img.drawString(letter, 15, 25);
        }
        
        setImage(img);
    }
    
    public void setFeedbackColor(Color color) {
        GreenfootImage img = getImage();
        img.setColor(color);
        img.fillRect(0, 0, 40, 40);
        setImage(img);
    }
}

