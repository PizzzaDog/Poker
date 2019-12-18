package PokerStarsRemake;

import javax.swing.*;
import java.awt.*;

class PreFrame extends JFrame {
    PreFrame() {
        super("PokerStarsRemake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Box box = Box.createVerticalBox(), box1 = Box.createHorizontalBox();
        JLabel hello = new JLabel("Поиграем в покер?");
        hello.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(Box.createVerticalGlue());
        box.add(hello);
        box.add(Box.createVerticalGlue());
        JButton yes = new JButton("Yes");
        yes.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        yes.addActionListener(actionEvent -> {
            dispose();
            PrepareFrame togo = new PrepareFrame();
        });
        JButton no = new JButton("No");
        no.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        no.addActionListener(actionEvent -> dispose());
        box1.add(yes);
        box1.add(Box.createHorizontalStrut(20));
        box1.add(no);
        box.add(box1);
        setContentPane(box);
        setSize(250, 200);
        setVisible(true);
    }

    static class PrepareFrame extends JFrame {
        PrepareFrame() {
            super("PokerStarsRemake");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            Box box = Box.createVerticalBox();
            box.add(Box.createVerticalGlue());
            box.add(new JLabel("Введите количество игроков"));
            box.add(Box.createVerticalGlue());
            TextField text = new TextField();
            box.add(text);
            box.add(Box.createVerticalGlue());
            JLabel check = new JLabel();
            JButton ok = new JButton("Ok");
            //Меняем окно для создания имен игроков
            ok.addActionListener(actionEvent -> {
                if(Check.checkNumPlayers(Integer.parseInt(text.getText()))) {
                    int numOfPlayers = Integer.parseInt(text.getText());
                    box.removeAll();
                    JPanel panel = new JPanel();
                    panel.setLayout(new GridLayout(numOfPlayers + 1, 2, 5, 5));
                    JTextField[] fields = new JTextField[numOfPlayers];
                    for (int i = 0; i < numOfPlayers; i++) {
                        fields[i] = new JTextField();
                        panel.add(new JLabel("Player " + (i + 1)));
                        panel.add(fields[i]);
                    }
                    JButton okPlayers = new JButton("Ok");
                    okPlayers.addActionListener(actionEvent1 -> {
                        //Game.setNumPlayers(numOfPlayers);
                        Game.newGame(fields);
                        GameFrame  g = new GameFrame();
                        dispose();
                    });
                    panel.add(okPlayers);
                    setContentPane(panel);
                    setSize(400, (50 * numOfPlayers) + 20);
                } else check.setText("Введите число от 2 до 10!");
            });
            box.add(ok);
            box.add(Box.createVerticalGlue());
            box.add(check);

            setContentPane(box);
            setSize(250, 200);
            setVisible(true);
        }
    }
}
