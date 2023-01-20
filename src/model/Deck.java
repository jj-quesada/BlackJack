package model;

public class Deck {
    private int helper = 0;
    private final Card[] cards;

    public Deck(Card... cards) {
        this.cards = cards;
    }
            
    public Card getOneCard() {
        Card result = cards[helper];
        helper++;

        return result;
    }

    public void reload() {
        helper = 0;
    }
}
