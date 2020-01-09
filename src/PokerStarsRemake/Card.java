package PokerStarsRemake;

public class Card {
    private String cardString;
    private int cardIndex;
    private int cardPriority;

    Card(String cardString) {
        this.cardString = cardString;
    }

    Card(String name, int index, int priority) {
        this.cardString = name;
        this.cardIndex = index;
        this.cardPriority = priority;
    }

    String getCardString() {
        return cardString;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public void setCardIndex(int cardIndex) {
        this.cardIndex = cardIndex;
    }

    public int getCardPriority() {
        return cardPriority;
    }

    public void setCardPriority(int cardPriority) {
        this.cardPriority = cardPriority;
    }
}
