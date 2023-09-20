package chapter3;

public final class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;
    public Rank rank() {
        return rank;
    }
    public Suit suit() {
        return suit;
    }

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

    public boolean isRed() {
        return suit.isRed();
    }
    
    public boolean isFace() {
        return rank.ordinal() >= Rank.JACK.ordinal();
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card card) {
        if (suit().compareTo(card.suit()) == 0) {
            return rank().compareTo(card.rank());
        }
        return suit().compareTo(card.suit());
    }
}
