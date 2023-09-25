package chapter3;

import java.util.Iterator;

public final class Client {    
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        
        printCards(deck);
    }

    private static void printCards(Iterable<Card> iterable) {
        for (Card card : iterable) {
            System.out.println(card);
        }
    }
}