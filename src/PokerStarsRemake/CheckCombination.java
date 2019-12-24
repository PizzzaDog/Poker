package PokerStarsRemake;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CheckCombination {
    private static String cards = "";
    //private static int index = 0;
    static void setAllPlayers(ArrayList<Player> players) {
        for (Player p : players) {
            setCombinations(p);
        }
    }
    private static void setCombinations(Player player) {
        String s = "";
        String toRoyal;
        if (Game.computerHandNotNull()) s = Game.getStringComputerHand();
        s += player.getStringHand();
        toRoyal = s;
        char[] forSort = s.toCharArray();
        Arrays.sort(forSort);
        s = new String(forSort);
        cards = s;
        check1RoyalFlush(toRoyal, player);
    }
    private static void check1RoyalFlush(String unsorted, Player player) {
        Pattern p = Pattern.compile("([\\u2666\\u2665\\u2663\\u2660])[1AJQK].*\\1[1AJQK].*\\1[1AJQK].*\\1[1AJQK].*\\1[1AJQK]");
        Matcher m = p.matcher(unsorted);
        if (m.find()) {
            player.setCombination("Royal Flush");
        } else {check3FourOfAKind(player);}
    }
    //static void check2StraightFlush(){}
    private static void check3FourOfAKind(Player player) {
        Pattern p = Pattern.compile("([123456789JQKA])\\1\\1\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            System.out.print("Нашлась четверка");
            player.setCombination("Four Of A Kind");
        } else {
            check4FullHouse(player);
        }
    }
    private static void check4FullHouse(Player player) {
        Pattern p = Pattern.compile("([123456789JQKA])\\1\\1.*([123456789JQKA])\\2");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            player.setCombination("Full House");
        } else {
            p = Pattern.compile("([123456789JQKA])\\1.*([123456789JQKA])\\2\\2");
            m = p.matcher(cards);
            if (m.find()) {
                player.setCombination("Full House");
            } else {check5Flush(player);}
        }
    }
    private static void check5Flush(Player player) {
        Pattern p = Pattern.compile("([\\u2666\\u2665\\u2663\\u2660])\\1\\1\\1\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            player.setCombination("Flush");
        } else {check7ThreeOfAKind(player);}
    }
    //static void check6Straight() {}
    private static void check7ThreeOfAKind(Player player) {
        Pattern p = Pattern.compile("([123456789JQKA])\\1\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            player.setCombination("Three Of A Kind");
        } else {check8TwoPairs(player);}
    }
    private static void check8TwoPairs(Player player) {
        Pattern p = Pattern.compile("([123456789JQKA])\\1.*([123456789JQKA])\\2");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            player.setCombination("Two Pairs");
        } else {check9OnePair(player);}
    }
    private static void check9OnePair(Player player) {
        Pattern p = Pattern.compile("([123456789JQKA])\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            player.setCombination("One Pair");
        } else {
            player.setCombination("High card");
        }
    }
}
