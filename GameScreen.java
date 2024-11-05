import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class GameScreen extends World {
    private WordChecker wordChecker;
    private Label feedbackLabel;
    private Label inputLabel;
    private String input = "";

    public GameScreen() {
        super(600, 400, 1);
        wordChecker = new WordChecker("APPLE");
        
        inputLabel = new Label("Guess: ", 24);
        feedbackLabel = new Label("", 24);
        
        addObject(inputLabel, 300, 100);
        addObject(feedbackLabel, 300, 150);
        addObject(new Button(this::submitGuess, "Submit"), 300, 300);
    }

    public void act() {
        // Continuously check for key input
        String key = Greenfoot.getKey();
        if (key != null) {
            handleKeyInput(key);
        }
    }

    public void submitGuess() {
        if (input.length() == 5) {
            List<String> feedback = wordChecker.checkGuess(input);

            // Display each letter with appropriate color feedback
            int xPosition = 200;  // Starting x position for feedback labels
            for (int i = 0; i < feedback.size(); i++) {
                String color = feedback.get(i);
                char guessedChar = input.charAt(i);
                Label letterLabel = new Label(String.valueOf(guessedChar), 24);

                // Set color based on feedback
                if (color.equals("green")) {
                    letterLabel.setImageColor(Color.GREEN);
                } else if (color.equals("yellow")) {
                    letterLabel.setImageColor(Color.YELLOW);
                } else {
                    letterLabel.setImageColor(Color.GRAY);
                }

                // Position the label and add it to the world
                addObject(letterLabel, xPosition, 200);
                xPosition += 40;  // Adjust spacing between letters
            }

            if (wordChecker.isCorrectGuess(input)) {
                feedbackLabel.setText("Congratulations! You've guessed the word!");
            }

            // Clear input for the next guess
            input = "";
            inputLabel.setText("Guess: ");
        } else {
            feedbackLabel.setText("Please enter a 5-letter word.");
        }
    }

    public void handleKeyInput(String key) {
        // Handle letter typing
        if (input.length() < 5 && key.length() == 1 && Character.isLetter(key.charAt(0))) {
            input += key.toUpperCase();
            inputLabel.setText("Guess: " + input);
        }
        // Handle backspace
        else if (key.equals("backspace") && input.length() > 0) {
            input = input.substring(0, input.length() - 1);
            inputLabel.setText("Guess: " + input);
        }
    }
}
