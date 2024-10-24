import greenfoot.*;

public class Button extends Actor {
    private Runnable action;
    private String text;

    public Button(Runnable action, String text) {
        this.action = action;
        this.text = text;
        GreenfootImage image = new GreenfootImage(text, 24, Color.BLACK, Color.WHITE);
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (action != null) {
                action.run();
            }
        }
    }
}