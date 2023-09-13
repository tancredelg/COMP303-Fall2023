package chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Deck {
    private List<Card> cards = new ArrayList<>();
    
    /*
    Deck copy constructor - a constructor which takes 1 param of its own class's type:
    
    public Deck(Deck deck) {
        this.cards = deck.cards;
    }
    */

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public Card getCardAt(int i) {
        assert 0 <= i && i < cards.size();
        return cards.get(i);
    }
    
    public Card draw() {
        assert !isEmpty();
        return cards.get(0);
    }
}
