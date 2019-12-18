package FullPokerStars;

class Player {
    private String name = "Неизвестный игрок";
    private String[] hand = new String[] {"", ""};
    //private int point = 0;
    private String combination = "none combination";
    Player() {}
    String getName() {return name;}
    void setName(String name) {this.name = name;}
    //public int getPoint() {return point;}
    //public void setPoint(int point) {this.point = point;}
    String getCombination() {return combination;}
    void setCombination(String combination) {this.combination = combination;}
    String getHand(){
        String s;
        s = this.hand[0];
        s += this.hand[1];
        return s;
    }
    void setHand(String[] hand) {this.hand = hand;}
}
