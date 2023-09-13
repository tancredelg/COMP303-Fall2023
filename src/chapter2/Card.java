package chapter2;

public final class Card {    
    private Rank rank;
    private Suit suit;
    private static final int CARDS_PER_SUIT = Rank.values().length;

    public Card(Rank rank, Suit suit) {
        if (rank == null || suit == null) throw new IllegalArgumentException();
        
        this.rank = rank;
        this.suit = suit;
    }
    
    public Card next() {
        int id = suit.ordinal() * CARDS_PER_SUIT + rank.ordinal();
        return new Card(Rank.values()[id % CARDS_PER_SUIT], Suit.values()[id / CARDS_PER_SUIT]);
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
