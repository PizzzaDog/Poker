package FullPokerStars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HandChecker {
    private static String cards = "";
    private static int index = 0;
    static void setCards(String computerHand, String playerHand, int ind) {
        String s, toRoyal;
        s = computerHand;
        s += playerHand;
        toRoyal = s;
        char[] forSort = s.toCharArray();
        Arrays.sort(forSort);
        s = new String(forSort);
        cards = s;
        index = ind;
        check1RoyalFlush(toRoyal);
    }
    private static void check1RoyalFlush(String unsorted) {
        Pattern p = Pattern.compile("([\\u2666\\u2665\\u2663\\u2660])[1AJQK].*\\1[1AJQK].*\\1[1AJQK].*\\1[1AJQK].*\\1[1AJQK]");
        Matcher m = p.matcher(unsorted);
        if (m.find()) {
            Hand.setPlayerCombination("Royal Flush, congratulations!", index);
        } else {check3FourOfAKind();}
    }
    //static void check2StraightFlush(){}
    private static void check3FourOfAKind() {
        Pattern p = Pattern.compile("([123456789JQKA])\\1\\1\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            System.out.print("Нашлась четверка");
            Hand.setPlayerCombination("Four Of A Kind", index);
        } else {
            check4FullHouse();
        }
    }
    private static void check4FullHouse() {
        Pattern p = Pattern.compile("([123456789JQKA])\\1\\1.*([123456789JQKA])\\2");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            Hand.setPlayerCombination("Full House", index);
        } else {
            p = Pattern.compile("([123456789JQKA])\\1.*([123456789JQKA])\\2\\2");
            m = p.matcher(cards);
            if (m.find()) {
                Hand.setPlayerCombination("Full House", index);
            } else {check5Flush();}
        }
    }
    private static void check5Flush() {
        Pattern p = Pattern.compile("([\\u2666\\u2665\\u2663\\u2660])\\1\\1\\1\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            Hand.setPlayerCombination("Flush", index);
        } else {check7ThreeOfAKind();}
    }
    //static void check6Straight() {}
    private static void check7ThreeOfAKind() {
        Pattern p = Pattern.compile("([123456789JQKA])\\1\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            Hand.setPlayerCombination("Three Of A Kind", index);
        } else {check8TwoPairs();}
    }
    private static void check8TwoPairs() {
        Pattern p = Pattern.compile("([123456789JQKA])\\1.*([123456789JQKA])\\2");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            Hand.setPlayerCombination("Two Pairs", index);
        } else {check9OnePair();}
    }
    private static void check9OnePair() {
        Pattern p = Pattern.compile("([123456789JQKA])\\1");
        Matcher m = p.matcher(cards);
        if (m.find()) {
            Hand.setPlayerCombination("One Pair", index);
        } else {
            Hand.setPlayerCombination("High card", index);
        }
    }
}
