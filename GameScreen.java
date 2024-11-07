import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameScreen extends World {
    private WordChecker wordChecker;
    private Label inputLabel;
    private String input = "";
    private List<List<Label>> guessLabels; 
    private int guessYPosition = 50; 

    public GameScreen() {
        super(600, 400, 1);
        
        String[] words = {"APPLE", "BERRY", "GRAPE", "LEMON", "ERROR", "GREAT", "LIMIT"};
        
        String targetWord = words[new Random().nextInt(words.length)];
        wordChecker = new WordChecker(targetWord);
        
        inputLabel = new Label("Guess: ", 24);
        guessLabels = new ArrayList<>();
        
        addObject(inputLabel, 300, 325);  
        addObject(new Button(this::submitGuess, "Submit"), 300, 375);
    }

    public void act() {
        String key = Greenfoot.getKey();
        if (key != null) {
            handleKeyInput(key);
        }
    }

    public void submitGuess() {
        if (input.length() == 5) {
            List<String> feedback = wordChecker.checkGuess(input);
            List<Label> guessRow = new ArrayList<>();

            // Build a row of labels with color feedback
            for (int i = 0; i < feedback.size(); i++) {
                String color = feedback.get(i);
                char guessedChar = input.charAt(i);
                
                // Create a label for letter with appropriate color
                Label letterLabel = createColoredLabel(guessedChar, color);
                addObject(letterLabel, 250 + i * 30, guessYPosition); 
                guessRow.add(letterLabel);
            }

            guessLabels.add(guessRow);
            guessYPosition += 30;

            if (wordChecker.isCorrectGuess(input)) {
                inputLabel.setText("Congratulations! You've guessed the word!");
            } else {
                inputLabel.setText("Guess: ");
            }

            input = "";  // Clear input for the next guess
        } else {
            inputLabel.setText("Please enter a 5-letter word.");
        }
    }

    private Label createColoredLabel(char letter, String color) {
        Color bgColor;
        switch (color) {
            case "green":
                bgColor = Color.GREEN;
                break;
            case "yellow":
                bgColor = Color.YELLOW;
                break;
            default:
                bgColor = Color.GRAY;
                break;
        }

        GreenfootImage image = new GreenfootImage(24, 24);  // Set image size for each letter
        image.setColor(bgColor);
        image.fill();  // Fill the background with color
        image.setColor(Color.BLACK);
        image.drawString(String.valueOf(letter), 8, 20);  // Draw letter in the center

        Label coloredLabel = new Label("", 24);  // Empty text, just using as an image holder
        coloredLabel.setImage(image);
        return coloredLabel;
    }

    public void handleKeyInput(String key) {
        if (input.length() < 5 && key.length() == 1 && Character.isLetter(key.charAt(0))) {
            input += key.toUpperCase();
            inputLabel.setText("Guess: " + input);
        } else if (key.equals("backspace") && input.length() > 0) {
            input = input.substring(0, input.length() - 1);
            inputLabel.setText("Guess: " + input);
        }
    }
}
