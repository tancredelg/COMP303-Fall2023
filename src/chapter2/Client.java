package chapter2;

public final class Client {    
    public static void main(String[] args)
    {
        Card card = new Card(Rank.Two, Suit.Spades);

        for (int i = 0; i < 3; i++) {
            System.out.println(card);
            card = card.next();
        }
    }
}