/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hedgeyourbet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HedgeYourBet extends JFrame implements ActionListener {
    private JCheckBox option1, option2, option3, option4, option5;
    private JButton submitButton;
    private JLabel questionLabel, scoreLabel;
    private int currentQuestion = 0, score = 0;

    // Questions
    private String[] questions = {
        "1. How old was Nelson Mandela when he became the president?",
        "2. How many years did he spend in prison?",
        "3. How old is South Africa today?",
        "4. How old was Nelson Mandela when he got out of prison?",
        "5. If he were alive today, how old would he be?"
    };

    // Correct answers
    private String[] correctAnswers = {
        "75 years", 
        "27 years", 
        "116 years", 
        "71 years", 
        "108 years"
    };

    public HedgeYourBet() {
        setLayout(new FlowLayout());

        // Show first question
        questionLabel = new JLabel(questions[currentQuestion]);
        add(questionLabel);

        // Options
        option1 = new JCheckBox("75 years");
        option2 = new JCheckBox("27 years");
        option3 = new JCheckBox("116 years");
        option4 = new JCheckBox("71 years");
        option5 = new JCheckBox("108 years");
        add(option1); add(option2); add(option3); add(option4); add(option5);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);

        setSize(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int selectedCount = 0;
        boolean correctSelected = false;

        // Count selections and check correctness
        if(option1.isSelected()) { selectedCount++; if(correctAnswers[currentQuestion].equals(option1.getText())) correctSelected = true; }
        if(option2.isSelected()) { selectedCount++; if(correctAnswers[currentQuestion].equals(option2.getText())) correctSelected = true; }
        if(option3.isSelected()) { selectedCount++; if(correctAnswers[currentQuestion].equals(option3.getText())) correctSelected = true; }
        if(option4.isSelected()) { selectedCount++; if(correctAnswers[currentQuestion].equals(option4.getText())) correctSelected = true; }
        if(option5.isSelected()) { selectedCount++; if(correctAnswers[currentQuestion].equals(option5.getText())) correctSelected = true; }

        // Scoring rules
        if(correctSelected && selectedCount == 1) score += 5;
        else if(correctSelected && selectedCount == 2) score += 2;
        else if(correctSelected && selectedCount == 3) score += 1;

        // Next questions
        currentQuestion++;
        if(currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion]);
            option1.setSelected(false);
            option2.setSelected(false);
            option3.setSelected(false);
            option4.setSelected(false);
            option5.setSelected(false);
        } else {
            // conditions
            String message;
            if(score > 20) {
                message = "Fantastic!";
            } else if(score >= 16 && score <= 19) {
                message = "Very good";
            } else if(score >= 10 && score <= 15) {
                message = "Good";
            } else if(score == 0) {
                message = "false. Please try again.";
            } else {
                message = "Okay";
            }

            JOptionPane.showMessageDialog(this, "Final Score: " + score + "\n" + message);
        }
        scoreLabel.setText("Score: " + score);
    }

    public static void main(String[] args) {
        new HedgeYourBet();
    }
}

 
