package chapter2;

public class Card {    
    private Rank aRank;
    private Suit aSuit;
    private static final int CARDS_PER_SUIT = Rank.values().length;

    public Card(int id) {
        aRank = Rank.values()[id % CARDS_PER_SUIT];
        aSuit = Suit.values()[id / CARDS_PER_SUIT];
    }

    public Card(Rank rank, Suit suit) {
        this.aRank = rank;
        this.aSuit = suit;
    }
    
    public Card(String rank, String suit) {
        this.aRank = Rank.valueOf(rank);
        this.aSuit = Suit.valueOf(suit);
    }
    
    public int getId() {
        return aSuit.ordinal() * CARDS_PER_SUIT + aRank.ordinal();
    }

    public void setId(int id) {
        aRank = Rank.values()[id % CARDS_PER_SUIT];
        aSuit = Suit.values()[id / CARDS_PER_SUIT];
    }
    
    public Card next() {
        return new Card((getId() + 1) % 52);
    }

    @Override
    public String toString() {
        return aRank + " of " + aSuit;
    }
}
