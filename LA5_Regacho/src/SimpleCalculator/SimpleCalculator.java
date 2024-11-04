package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JPanel pMain;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JTextField tfResult;
    private JButton btnCompute;
    private JLabel lblNumber1;
    private JLabel lblNumber2;
    private JLabel lblResult;

    SimpleCalculator() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(tfNumber1.getText());
                    int num2 = Integer.parseInt(tfNumber2.getText());
                    String op = "";
                    int result = 0;

                    if (cbOperations.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Choose an operation!");
                    } else {
                        op = (String) cbOperations.getSelectedItem();
                    }

                    switch (op) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/":
                            if (num2 == 0) {
                                JOptionPane.showMessageDialog(null, "You cannot divide by 0");
                            } else {
                                result = num1 / num2;
                            }
                            break;
                    }

                    tfResult.setText(Integer.toString(result));

                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator s = new SimpleCalculator();
        s.setContentPane(s.pMain);
        s.setSize(700, 200);
        s.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        s.setVisible(true);
    }
}
