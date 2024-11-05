import greenfoot.*;

public class Label extends Actor {
    private GreenfootImage image;
    private String text;
    private int fontSize;

    public Label(String text, int fontSize) {
        this.text = text;
        this.fontSize = fontSize;
        updateImage();
    }

    public void setText(String text) {
        this.text = text;
        updateImage();
    }

    private void updateImage() {
        image = new GreenfootImage(text, fontSize, Color.BLACK, Color.WHITE);
        setImage(image);
    }
    
    public void setImageColor(Color color) {
    GreenfootImage img = getImage();
    img.setColor(color);
    img.fill();
    img.setColor(Color.BLACK); 
    img.drawString(text, 5, fontSize);
    setImage(img);
}

}