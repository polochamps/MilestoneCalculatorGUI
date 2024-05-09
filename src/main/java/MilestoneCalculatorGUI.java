import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MilestoneCalculatorGUI extends JFrame implements ActionListener {
    private JLabel milestone1Label, milestone2Label, terminalAssessmentLabel, resultLabel;
    private JTextField milestone1Field, milestone2Field, terminalAssessmentField;
    private JButton calculateButton;

    public MilestoneCalculatorGUI() {
        setTitle("Milestone Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        milestone1Label = new JLabel("Milestone 1 (0-25): ");
        milestone1Field = new JTextField();
        mainPanel.add(milestone1Label);
        mainPanel.add(milestone1Field);

        milestone2Label = new JLabel("Milestone 2 (0-40): ");
        milestone2Field = new JTextField();
        mainPanel.add(milestone2Label);
        mainPanel.add(milestone2Field);

        terminalAssessmentLabel = new JLabel("Terminal Assessment (0-35): ");
        terminalAssessmentField = new JTextField();
        mainPanel.add(terminalAssessmentLabel);
        mainPanel.add(terminalAssessmentField);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        resultLabel = new JLabel();
        mainPanel.add(calculateButton);
        mainPanel.add(resultLabel);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double milestone1 = Double.parseDouble(milestone1Field.getText());
                double milestone2 = Double.parseDouble(milestone2Field.getText());
                double terminalAssessment = Double.parseDouble(terminalAssessmentField.getText());

                if (milestone1 < 0 || milestone1 > 25 || milestone2 < 0 || milestone2 > 40 || terminalAssessment < 0 || terminalAssessment > 35) {
                    JOptionPane.showMessageDialog(this, "Invalid input value! Please enter values between 0 and the maximum points per Milestone.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double totalScore = milestone1 + milestone2 + terminalAssessment;
                double totalPerfectScore = 25 + 40 + 35; // Perfect scores for each milestone
                double percentage = (totalScore / totalPerfectScore) * 100;
                resultLabel.setText("Total Grade: " + String.format("%.2f%%", percentage)); // Display percentage with two decimal places
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input format! Please enter numerical values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
