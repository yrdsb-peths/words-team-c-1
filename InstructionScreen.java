import greenfoot.*;

public class InstructionScreen extends World {
    private MenuScreen menu;
    private String[] instructions;
    private int index;
    private Label instructionLabel;

    public InstructionScreen(MenuScreen menu) {
        super(600, 400, 1);
        this.menu = menu;
        instructions = new String[]{
            "Welcome to the game!",
            "In Wordle, guess a five-letter word in six tries. ",
            "Green, yellow, and gray hints help you refine your guesses ",
            "Green shows that a letter is in the correct position.",
            "Yellow means the letter is in the word but in the wrong position.",
            "Gray means the letter is not in the word at all.",
            "Good luck and have fun!!"
        };
        index = 0;

        instructionLabel = new Label(instructions[index], 24);
        addObject(instructionLabel, 300, 200);
        
        addObject(new Button(this::nextInstruction, "Next"), 450, 350);
        addObject(new Button(this::previousInstruction, "Previous"), 150, 350);
        addObject(new Button(this::goBack, "Back to Menu"), 300, 350);
    }

    public void nextInstruction() {
        if (index < instructions.length - 1) {
            index++;
            instructionLabel.setText(instructions[index]);
        }
    }

    public void previousInstruction() {
        if (index > 0) {
            index--;
            instructionLabel.setText(instructions[index]);
        }
    }

    public void goBack() {
        Greenfoot.setWorld(menu);
    }
}
