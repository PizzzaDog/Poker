package PokerStarsRemake;

import java.util.ArrayList;
import java.util.Arrays;

class Player {
  private ArrayList<Card> hand = new ArrayList<>(Arrays.asList(new Card(""), new Card("")));
  private String name;
  private String combination;

  Player(String name) {
    this.name = name;
  }

  void setHand(ArrayList<Card> hand) {
    this.hand = hand;
  }

  String getStringHand() {
    return (hand.get(0).getCardString() + hand.get(1).getCardString());
  }

  String getName() {
    return name;
  }

  String getCombination() {
    return combination;
  }

  void setCombination(String combination) {
    this.combination = combination;
  }
}
