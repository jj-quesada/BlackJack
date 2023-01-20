
package main;

import static model.Card.*;
import model.*;

public class BlackJack {
    public static void main(String[] args) {
        String[] ganadores = new Game(new Deck(_5, _4, King, _2), new Hand("Player1", Jack, Ace), 
                             new Hand("Player2", _10, _5, _6), new Hand("Player3", _3, _6, Ace, _3, Ace, King), 
                             new Hand("Croupier", _9, _7)).getWinners();
        
        String[] ganadores2 = new Game(new Deck(Ace, _3, King, _2), new Hand("Player1", _10, King), 
                              new Hand("Player2", _10, _2, _6), new Hand("Player3", _8, _8, _5), 
                              new Hand("Croupier", _5, _10)).getWinners();
        
        for (String ganador : ganadores)
            System.out.println(ganador);
        
        System.out.println("-------------------");    
        
        for (String ganador : ganadores2) 
            System.out.println(ganador);
        
    }
    
    
}
