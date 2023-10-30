package chapter5;

public final class Client {    
    public static void main(String[] args)
    {
        Card c1 = Card.get(Rank.ACE, Suit.CLUBS);
        Card c2 = Card.get(Rank.ACE, Suit.CLUBS);
        System.out.println("c1 == c2: " + (c1 == c2));
        System.out.println("c1.equals(c2): " + c1.equals(c2));
    }
}