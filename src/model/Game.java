package model;

import java.util.ArrayList;
import static model.Card.*;

public class Game {

    private final Hand[] players;
    private final Deck deck;

    public Game(Deck deck, Hand... players) {
        this.deck = deck;
        this.players = players;
    }
    
    public String[] getWinners() {
        ArrayList<String> winners = new ArrayList<>();

        if (croupierHasBlackJack()){
            return new String[]{"Croupier"};
        }

        for (Hand player : players) {
            if ((player.value() > getCroupierGameValue() && player.value() <= 21) || player.isBlackJack())
                winners.add(player.name());
        }

        String[] result = new String[winners.size()];
        return winners.toArray(result);

    }

    public Hand getCroupier() {
        for (Hand hand : players) {
            if (hand.name().equals("Croupier")) {
                return hand;
            }
        }
        return null;
    }

    public boolean croupierHasBlackJack() {
        return getCroupier().isBlackJack() ? true : false;
    }

    public int getCroupierGameValue(){
        int value = getCroupier().value();


        while (value < 17){
            Card newc = deck.getOneCard();

            if (newc == Ace && value <= 10)
                value = value + newc.value() + 10;
            else
                value = value + newc.value();

        }

        deck.reload();
        return value;

    }
}
