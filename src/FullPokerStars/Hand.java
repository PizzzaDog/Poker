package FullPokerStars;
import java.util.Scanner;

class Hand {
    //private static Player p = new Player();
    private static Scanner sc = new Scanner(System.in);
    private static Player[] players = new Player[] {new Player(), new Player(), new Player(), new Player(), new Player(), new Player(), new Player(), new Player(), new Player(), new Player()};
    private static int numPlayers = 0;
    private static String[][] koloda = {
            {"\u26662", "\u26663", "\u26664", "\u26665", "\u26666", "\u26667", "\u26668", "\u26669", "\u266610", "\u2666J", "\u2666Q", "\u2666K", "\u2666A"},
            {"\u26652", "\u26653", "\u26654", "\u26655", "\u26656", "\u26657", "\u26658", "\u26659", "\u266510", "\u2665J", "\u2665Q", "\u2665K", "\u2665A"},
            {"\u26632", "\u26633", "\u26634", "\u26635", "\u26636", "\u26637", "\u26638", "\u26639", "\u266310", "\u2663J", "\u2663Q", "\u2663K", "\u2663A"},
            {"\u26602", "\u26603", "\u26604", "\u26605", "\u26606", "\u26607", "\u26608", "\u26609", "\u266010", "\u2660J", "\u2660Q", "\u2660K", "\u2660A"}};
    static String[][] getKoloda() {return koloda;}
    static Player[] getPlayers() {return players;}
    static void setNumPlayers(int n) {numPlayers = n;}
    static int getNumPlayers() {return numPlayers;}
    static void setNamePlayers() {
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Введите имя для " + (i + 1) + " игрока:");
            players[i].setName(sc.nextLine());
        }
    }
    static void setPlayerCombination(String s, int index) {players[index].setCombination(s);}
}
