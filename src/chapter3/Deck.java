package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Deck implements Iterable<Card> {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        initializeDeck();
        // cards.removeIf(card -> card.rank() != Rank.TWO);
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
        return getCardAt(0);
    }
    
    public List<Card> getCards() { return Collections.unmodifiableList(cards); }
    
    public Iterator<Card> getIterator() {
        return cards.iterator();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[empty deck]";
        StringBuilder s = new StringBuilder(getCardAt(0).toString());
        for (int i = 1; i < cards.size(); i++) {
            s.append("\n").append(getCardAt(i));
        }
        return s.toString();
    }

    @Override
    public Iterator<Card> iterator() {
        return getIterator();
    }
}
