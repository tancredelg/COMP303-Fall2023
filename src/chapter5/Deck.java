package chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck(Predicate<Card> predicate) {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(Card.get(rank, suit));
            }
        }
        cards.removeIf(predicate);
        Collections.shuffle(cards);
    }
    
    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(Card.get(rank, suit));
            }
        }

        Collections.shuffle(cards);
    }
    
    /**
     * 
     * @return The card at the top of the deck
     */
    public Card draw() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}