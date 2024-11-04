import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class WordChecker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordChecker {
    private String targetWord;

    public WordChecker(String targetWord) {
        this.targetWord = targetWord.toUpperCase();
    }

    public List<String> checkGuess(String guess) {
        guess = guess.toUpperCase();
        List<String> feedback = new ArrayList<>();
        
        for (int i = 0; i < guess.length(); i++) {
            char guessedChar = guess.charAt(i);
            if (guessedChar == targetWord.charAt(i)) {
                feedback.add("green"); // Correct position
            } else if (targetWord.contains(String.valueOf(guessedChar))) {
                feedback.add("yellow"); // Wrong position but correct letter
            } else {
                feedback.add("default"); // Not in the word
            }
        }
        return feedback;
    }

    public boolean isCorrectGuess(String guess) {
        return guess.equalsIgnoreCase(targetWord);
    }
}

