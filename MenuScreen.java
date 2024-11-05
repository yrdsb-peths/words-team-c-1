import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

public class MenuScreen extends World {
    
    //main menu screen
    public MenuScreen() {    
        super(600, 350, 1);
        addObject(new Button(this::goInstructions, "Instructions"), 300, 310); 

        // Avatar Selection


    }
    
    //going back to intruction screen
    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
    }
}
