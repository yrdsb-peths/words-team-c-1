import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class GameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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

    public void submitGuess() {
    if (input.length() == 5) {
        List<String> feedback = wordChecker.checkGuess(input);
        StringBuilder feedbackText = new StringBuilder("<html>");  // Start with HTML

        // Build the feedback with color
        for (int i = 0; i < feedback.size(); i++) {
            String color = feedback.get(i);
            char guessedChar = input.charAt(i);
            if (color.equals("green")) {
                feedbackText.append("<font color='green'>").append(guessedChar).append("</font> ");
            } else if (color.equals("yellow")) {
                feedbackText.append("<font color='yellow'>").append(guessedChar).append("</font> ");
            } else {
                feedbackText.append("<font color='gray'>").append(guessedChar).append("</font> ");
            }
        }

        feedbackText.append("</html>");  // End HTML content
        feedbackLabel.setText("Feedback: " + feedbackText.toString());

        if (wordChecker.isCorrectGuess(input)) {
            feedbackLabel.setText("Congratulations! You've guessed the word!");
        }

        input = "";  // Clear input for the next guess
        inputLabel.setText("Guess: ");
    } else {
        feedbackLabel.setText("Please enter a 5-letter word.");
    }
}

    public void keyPressed(String key) {
        if (input.length() < 5 && key.length() == 1 && Character.isLetter(key.charAt(0))) {
            input += key.toUpperCase();
            inputLabel.setText("Guess: " + input);
        } else if (key.equals("backspace") && input.length() > 0) {
            input = input.substring(0, input.length() - 1);
            inputLabel.setText("Guess: " + input);
        }
    }
}
