package FoodOrderingSystem;

import SimpleCalculator.SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private JPanel pMain;
    private JCheckBox cPizza;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JCheckBox cBurger;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    FoodOrderingSystem() {
        JCheckBox[] foods = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};
        int[] prices = {100, 80, 65, 55, 50, 40};
        JRadioButton[] discounts = {rbNone, rb5, rb10, rb5};
        double [] disc = {0, 0.05, 0.10, 0.15};

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                double current_total = 0;

                for (int i = 0; i < foods.length; i++) {
                    if (foods[i].isSelected()) {
                        total += prices[i];
                    }
                }

                double d = 0;
                for (int i = 0; i < discounts.length; i++) {
                    if (discounts[i].isSelected()) {
                        d = total * disc[i];
                    }
                }

                total -= d;

                String result = String.format("%.2f", total);

                JOptionPane.showMessageDialog(null, "The total price is Php " + result);
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSystem f = new FoodOrderingSystem();
        f.setContentPane(f.pMain);
        f.setSize(700, 700);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
