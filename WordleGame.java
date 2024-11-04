import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordleGame extends JFrame {
    private final JTextField inputField;
    private final JTextArea resultArea;
    private final JButton submitButton;
    private final String targetWord = "APPLE";  // 目标单词，可以设为随机选取

    public WordleGame() {
        setTitle("Wordle Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField(5);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter your guess: "));
        inputPanel.add(inputField);
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        inputPanel.add(submitButton);
        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String guess = inputField.getText().toUpperCase();
            if (guess.length() != targetWord.length()) {
                JOptionPane.showMessageDialog(null, "Please enter a 5-letter word!");
                return;
            }
            StringBuilder feedback = new StringBuilder();
            for (int i = 0; i < guess.length(); i++) {
                char guessedChar = guess.charAt(i);
                if (guessedChar == targetWord.charAt(i)) {
                    feedback.append(guessedChar).append(" "); // correct
                } else if (targetWord.contains(String.valueOf(guessedChar))) {
                    feedback.append("* "); // wrong place
                } else {
                    feedback.append("_ "); // wrong letter
                }
            }
            resultArea.append("Guess: " + guess + " -> " + feedback.toString() + "\n");

            // check if win the game
            if (guess.equals(targetWord)) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the word!");
                resultArea.append("You've guessed the word!\n");
                submitButton.setEnabled(false);
            }

            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordleGame game = new WordleGame();
            game.setVisible(true);
        });
    }
}
