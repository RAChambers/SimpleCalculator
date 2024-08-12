import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subtractionButton,multiplyButton, divideButton;
    JButton decimalButton, equalButton, deleteButton, clearButton, negativeNumButton;
    JPanel panel;

    Font chosenFont = new Font("Georgia", Font.BOLD,25);
    double num1=0, num2=0, result=0;
    char operator;

    Calculator(){

        frame = new JFrame("Calculaor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(chosenFont);
        textField.setEditable(false);
        textField.setBackground(Color.YELLOW);

        addButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalButton = new JButton("=");
        decimalButton = new JButton(".");
        deleteButton = new JButton("DEL");
        clearButton = new JButton("CLR");

        functionButtons[0] = addButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = equalButton;
        functionButtons[5] = decimalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;


        for(int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(chosenFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.ORANGE);
        }
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(chosenFont);
            numberButtons[i].setFocusable(false);
        }

        deleteButton.setBounds(50, 430, 145, 50);
        clearButton.setBounds(205, 430, 145, 50);


        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.CYAN);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractionButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args){

        Calculator startCalculator = new Calculator();    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++){
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));

            }
        }
        if (e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subtractionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton){
            num2 = Double.parseDouble(textField.getText());

            switch(operator){
                case '+':
                    result= num1 + num2;
                    break;
                case '-':
                    result= num1 - num2;
                    break;
                case '*':
                    result= num1 * num2;
                    break;
                case '/':
                    result= num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource() == clearButton) {
           textField.setText("");
        }
        if (e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i=0; i< string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}