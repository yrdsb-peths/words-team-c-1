import greenfoot.*;

public class Label extends Actor {
    private GreenfootImage image;
    private String text;
    private int fontSize;
    private Color textColor;
    private Color backgroundColor;

    // Constructor with text and font size only (default colors)
    public Label(String text, int fontSize) {
        this(text, fontSize, Color.BLACK, Color.WHITE);  // Default text and background color
    }

    // Constructor with text, font size, text color, and background color
    public Label(String text, int fontSize, Color textColor, Color backgroundColor) {
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        updateImage();
    }

    public void setText(String text) {
        this.text = text;
        updateImage();
    }

    public void setColors(Color textColor, Color backgroundColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        updateImage();
    }

    private void updateImage() {
        // Set image with background color and text color
        image = new GreenfootImage(text, fontSize, textColor, backgroundColor);
        setImage(image);
    }
    
    // Method to change only the background color
    public void setImageColor(Color color) {
        this.backgroundColor = color;
        updateImage();
    }
}
