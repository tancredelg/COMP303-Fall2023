package chapter5;

import java.util.EnumMap;
import java.util.Objects;

public final class Card {
    
    private static EnumMap<Suit, EnumMap<Rank, Card>> cards = new EnumMap<>(Suit.class); // EnumMap - useful for enum keys
    private Rank rank;
    private Suit suit;
    
    private Card(Rank rank, Suit suit) { // Blocked constructor
        if (rank == null || suit == null) throw new IllegalArgumentException();

        this.rank = rank;
        this.suit = suit;
    }
    
    public static Card get(Rank rank, Suit suit) { // Flyweight pattern: initialize every card within the Card class
        if (cards.containsKey(suit) && cards.get(suit).containsKey(rank)) {
            return cards.get(suit).get(rank);
        }
        return new Card(rank, suit);
    }

    public Rank rank() { return rank; }
    
    public Suit suit() { return suit; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
