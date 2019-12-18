package PokerStarsRemake;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Game {
    private static Random r = new Random();
    //private static int numPlayers;
    private static ArrayList<Card> Deck;
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Card> computerHand = new ArrayList<>();
//    static void setNumPlayers(int num) {
//        numPlayers = num;
//        System.out.println("Players num is " + num);
//    }
    static void newGame(JTextField[] names) {
        for(JTextField name : names) {
            players.add(new Player(name.getText()));
        }
        startGame();
    }
    static void startGame() {
        Deck = new ArrayList<>(Final.DECKCARDS);
        computerHand = new ArrayList<>();
        for(Player p : players) {
            p.setHand(new ArrayList<>(Arrays.asList(getCardFromDeck(), getCardFromDeck())));
        }
        CheckCombination.setAllPlayers(players);
    }
    static void round1() {
        for (int i = 0; i < 3; i++) {
            computerHand.add(getCardFromDeck());
        }
        CheckCombination.setAllPlayers(players);
    }
    static void round2() {
        computerHand.add(getCardFromDeck());
        CheckCombination.setAllPlayers(players);
    }
    static void round3() {
        computerHand.add(getCardFromDeck());
        CheckCombination.setAllPlayers(players);
    }

    private static Card getCardFromDeck() {
        return Deck.remove(r.nextInt(Deck.size() ));
    }
    static boolean computerHandNotNull() {
        return computerHand.size() > 0;
    }
    static String getStringComputerHand() {
        StringBuilder cHand = new StringBuilder();
        for (Card c : computerHand) {
            cHand.append(c.getCardString());
        }
        return (cHand.toString());
    }
    static ArrayList<Player> getPlayers() {
        return players;
    }
}
