package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {
    private JTextField yearTextField;
    private JButton checkYearButton;
    private JPanel pMain;

    LeapYearChecker() {
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(yearTextField.getText());
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        JOptionPane.showMessageDialog(null, "Leap year");
                    } else {
                        JOptionPane.showMessageDialog(null, "Not a leap year");
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "No input!");
                }
            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker l = new LeapYearChecker();
        l.setContentPane(l.pMain);
        l.setSize(300, 300);
        l.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        l.setVisible(true);
    }
}
