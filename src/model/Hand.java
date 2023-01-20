package model;

import static model.Card.*;

public class Hand {

    private final Card[] cards;
    private final String name;

    public Hand(String name, Card... cards) {
        this.name = name;
        this.cards = cards;
    }
    
    public int value() {
        return canUseExtendAce() ? sum() + 10 : sum();
    }

    
    public int sum() {
        int sum = 0;
        for (Card card : cards)
            sum += card.value();
        return sum;
    }

    
    public boolean canUseExtendAce() {
        return isAce() && sum() <= 11 ? true : false;
    }

    
    public boolean isAce() {
        for (Card card : cards)
            if(card == Ace){
                return true;
            }
        return false;
    }

    
    public boolean isBlackJack() {
        return value() == 21 && cards.length == 2 ? true : false;
    }

    
    public boolean isBust() {
        return value() <= 21 ? false : true;
    }

    
    public String name(){
        return name;
    }

}
