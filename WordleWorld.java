import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordleWorld extends World {
    private LetterCell[][] grid;  // A 2D array of LetterCell actors

    public WordleWorld() {    
        super(600, 400, 1);  // World size
        
        // Initialize the grid
        grid = new LetterCell[6][5];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                LetterCell cell = new LetterCell();
                grid[row][col] = cell;
                addObject(cell, 100 + col * 50, 100 + row * 50);  // Positioning the cells
            }
        }
        
        Button submitButton = new Button("Submit", "Submit");
        addObject(submitButton, 300, 350);
        
        Button restartButton = new Button("Restart", "Restart");
        addObject(restartButton, 450, 350);
    }
}

