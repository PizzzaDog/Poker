package PokerStarsRemake;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GameFrame extends JFrame {
    private static final String NEXT_ROUND = "Next round";
    GameFrame() {
        super("PokerStarsRemake");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ArrayList<Player> players = Game.getPlayers();
        setSize(400, players.size() * 50 + 20);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width/2-getSize().width/2), (dim.height/2-getSize().height/2));
        setContentPane(startGame());
        setVisible(true);
    }
    private JPanel startGame() {
        Game.startGame();
        JPanel panel = panelPattern();
        JButton next = new JButton(NEXT_ROUND);
        next.addActionListener(actionEvent -> {
            setVisible(false);
            setContentPane(round1());
            setVisible(true);
        });
        panel.add(next);
        return panel;
    }
    private JPanel round1() {
        Game.round1();
        JPanel panel = panelPattern();
        JButton next = new JButton(NEXT_ROUND);
        next.addActionListener(actionEvent -> {
            setVisible(false);
            setContentPane(round2());
            setVisible(true);
        });
        panel.add(next);
        return panel;
    }
    private JPanel round2() {
        Game.round2();
        JPanel panel = panelPattern();
        JButton next = new JButton(NEXT_ROUND);
        next.addActionListener(actionEvent -> {
            setVisible(false);
            setContentPane(round3());
            setVisible(true);
        });
        panel.add(next);
        return panel;
    }
    private JPanel round3() {
        Game.round3();
        JPanel panel = panelPattern();
        JButton next = new JButton("Reset Game");
        JButton exit = new JButton("Exit");
        next.addActionListener(actionEvent -> {
            setVisible(false);
            setContentPane(startGame());
            setVisible(true);
        });
        exit.addActionListener(actionEvent -> dispose());
        panel.add(next);
        panel.add(exit);
        return panel;
    }
    private JPanel panelPattern() {
        ArrayList<Player> players = Game.getPlayers();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(players.size() + 2, 3, 5, 5));
        panel.add(new JLabel("Computer Hand"));
        panel.add(new JLabel(Game.getStringComputerHand()));
        panel.add(new JLabel());
        for(Player p : players) {
            panel.add(new JLabel(p.getName()));
            panel.add(new JLabel(p.getStringHand()));
            panel.add(new JLabel(p.getCombination()));
        }
        return panel;
    }
}
