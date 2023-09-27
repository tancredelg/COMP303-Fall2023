package chapter4;

public enum Suit {
    CLUBS, DIAMONDS, SPADES, HEARTS;
    
    public boolean isRed() {
        return this == DIAMONDS || this == HEARTS;
    }
}
