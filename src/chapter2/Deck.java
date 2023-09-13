package chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Deck {
    private List<Card> cards = new ArrayList<>();
    

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
    
    public Card draw() {
        assert !isEmpty();
        return cards.get(0);
    }
}
