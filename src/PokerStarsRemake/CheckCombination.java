package PokerStarsRemake;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CheckCombination {
  private static String cards = "";
  private static Pattern p;
  private static Matcher m;

  private static final String ROYALFLUSH_REGEXP = "([\\u2666\\u2665\\u2663\\u2660])[1AJQK].*\\1[1AJQK].*\\1[1AJQK].*\\1[1AJQK].*\\1[1AJQK]";
  private static final String FOUROFAKIND_REGEXP = "([123456789JQKA])\\1\\1\\1";
  private static final String FULLHOUSE_REGEXP = "([123456789JQKA])\\1\\1.*([123456789JQKA])\\2";
  private static final String FULLHOUSE2_REGEXP = "([123456789JQKA])\\1.*([123456789JQKA])\\2\\2";
  private static final String FLUSH_REGEXP = "([\\u2666\\u2665\\u2663\\u2660])\\1\\1\\1\\1";
  private static final String THREEOFAKIND_REGEXP = "([123456789JQKA])\\1\\1";
  private static final String TWOPAIR_REGEXP = "([123456789JQKA])\\1.*([123456789JQKA])\\2";
  private static final String ONEPAIR_REGEXP = "([123456789JQKA])\\1";

  private static final String ROYALFLUSH_STRING = "Royal Flush";
  private static final String FOUROFAKIND_STRING = "Four Of A Kind";
  private static final String FULLHOUSE_STRING = "Full House";
  private static final String FLUSH_STRING = "Flush";
  private static final String STRAIGHT_STRING = "Straight";
  private static final String THREEOFAKIND_STRING = "Three Of A Kind";
  private static final String TWOPAIR_STRING = "Two Pair";
  private static final String ONEPAIR_STRING = "One Pair";
  private static final String HIGHCARD_STRING = "High Card";


    static void setAllPlayers(ArrayList<Player> players){
        for (Player p : players) {
            setCombinations(p);
        }
    }

    private static void setCombinations(Player player) {
        String stash = "";
        String toRoyal;
        if (Game.computerHandNotNull()) {
            stash = Game.getStringComputerHand();
        }
        stash += player.getStringHand();
        toRoyal = stash;
        char[] forSort = stash.toCharArray();
        Arrays.sort(forSort);
        stash = new String(forSort);
        cards = stash;
        check1RoyalFlush(toRoyal, player);
    }

    private static void check1RoyalFlush(String unsorted, Player player) {
        p = Pattern.compile(ROYALFLUSH_REGEXP);
        m = p.matcher(unsorted);
        if (m.find()) {
            player.setCombination(ROYALFLUSH_STRING);
        } else {check2StraightFlush(player);}
    }

    static void check2StraightFlush(Player player){
    if (Game.computerHandNotNull()) {
      int count = 1;
      ArrayList<Card> cards = new ArrayList<>(Game.getComputerHand());
      cards.addAll(player.getHand());
      cards.sort(Comparator.comparing(Card::getCardIndex));
      for (int i = 1; i < cards.size(); i++) {
        if (cards.get(i).getCardIndex() == (cards.get(i - 1).getCardIndex() + 1)) {
          count++;
        } else count = (count == 5) ? 5 : 1;
      }
      if (count == 5) {
        player.setCombination(STRAIGHT_STRING);
      } else check7ThreeOfAKind(player);
        } else check3FourOfAKind(player);
    }

    private static void check3FourOfAKind(Player player) {
        p = Pattern.compile(FOUROFAKIND_REGEXP);
        m = p.matcher(cards);
        if (m.find()) {
            player.setCombination(FOUROFAKIND_STRING);
        } else {
            check4FullHouse(player);
        }
    }

    private static void check4FullHouse(Player player) {
        p = Pattern.compile(FULLHOUSE_REGEXP);
        m = p.matcher(cards);
        if (m.find()) {
            player.setCombination(FULLHOUSE_STRING);
        } else {
            p = Pattern.compile(FULLHOUSE2_REGEXP);
            m = p.matcher(cards);
            if (m.find()) {
                player.setCombination(FULLHOUSE_STRING);
            } else {check5Flush(player);}
        }
    }

    private static void check5Flush(Player player) {
        p = Pattern.compile(FLUSH_REGEXP);
        m = p.matcher(cards);
        if (m.find()) {
            player.setCombination(FLUSH_STRING);
        } else {check6Straight(player);}
    }

    static void check6Straight(Player player) {
    if (Game.computerHandNotNull()) {
      int count = 1;
      ArrayList<Card> cards = new ArrayList<>(Game.getComputerHand());
      cards.addAll(player.getHand());
      cards.sort(Comparator.comparing(Card::getCardPriority));
      for (int i = 1; i < cards.size(); i++) {
        if (cards.get(i).getCardPriority() == (cards.get(i - 1).getCardPriority() + 1)) {
          count++;
        } else count = (count == 5) ? 5 : 1;
      }
      if (count == 5) {
        player.setCombination(STRAIGHT_STRING);
      } else check7ThreeOfAKind(player);
        } else check7ThreeOfAKind(player);
    }

    private static void check7ThreeOfAKind(Player player) {
        p = Pattern.compile(THREEOFAKIND_REGEXP);
        m = p.matcher(cards);
        if (m.find()) {
            player.setCombination(THREEOFAKIND_STRING);
        } else {
            check8TwoPair(player);}
    }

    private static void check8TwoPair(Player player) {
        p = Pattern.compile(TWOPAIR_REGEXP);
        m = p.matcher(cards);
        if (m.find()) {
            player.setCombination(TWOPAIR_STRING);
        } else {check9OnePair(player);}
    }

    private static void check9OnePair(Player player) {
        p = Pattern.compile(ONEPAIR_REGEXP);
        m = p.matcher(cards);
        if (m.find()) {
            player.setCombination(ONEPAIR_STRING);
        } else {
            player.setCombination(HIGHCARD_STRING);
        }
    }
}
