package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public final class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        initializeDeck();
        cards.removeIf(card -> card.rank() != Rank.TWO);
        Collections.shuffle(cards);
    }

    public Deck(Predicate<Card> config) {
        initializeDeck();
        cards.removeIf(config);
        Collections.shuffle(cards);
    }
    
    public Deck(ConfigPredicate config) {
        initializeDeck();
        
        for (Card card : new ArrayList<>(cards)) {
            if (config.reject(card)) {
                cards.remove(card);
            }
        }
        
        Collections.shuffle(cards);
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
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
