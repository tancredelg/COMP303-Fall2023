package chapter3;

public final class Client {    
    public static void main(String[] args)
    {
        Deck deck = new Deck(new ConfigPredicate() {
            @Override
            public boolean reject(Card card) {
                return card.rank() != Rank.TWO;
            }
        });
        
        Card card1 = deck.draw();
    }
}