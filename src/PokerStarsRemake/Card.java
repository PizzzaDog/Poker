package PokerStarsRemake;

public class Card {
    private String cardString;
    private int cardIndex;
    private int cardPriority;
    Card(String cardString) {
        this.cardString = cardString;
    }
    Card(String name, int Index, int Priority) {
        this.cardString = name;
        this.cardIndex = Index;
        this.cardPriority = Priority;
    }
    String getCardString() {
        return cardString;
    }
}
