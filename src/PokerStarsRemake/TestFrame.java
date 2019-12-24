package PokerStarsRemake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame {
    TestFrame() {
        super("Test");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,5,5));
        panel.add(new JLabel("test1"));
        panel.add(new JLabel("test2"));
        JButton next = new JButton("go");
        panel.add(next);
    next.addActionListener(
            actionEvent -> setContentPane(nextRound(panel)));
        setSize(200, 200);
        setContentPane(panel);
        setVisible(true);
    }
    JPanel nextRound(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new GridLayout(2,2,5,5));
        panel.add(new JLabel("new test"));
        panel.add(new JLabel("new test 2"));
        JButton next = new JButton();
        panel.add(next);
        return panel;
    }
}
