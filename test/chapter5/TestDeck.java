package chapter5;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class TestDeck {
    private final Deck deck = new Deck();
    
    @Test
    void testIsEmpty_False() {
        assertFalse(deck.isEmpty());
    }
    
    @Test
    void testIsEmpty_True() {
        emptyDeck();
        assertTrue(deck.isEmpty());
    }

    @Test
    void testDraw() {
        assertSame(getTopCard(), deck.draw());
    }
    
    @Test
    void testDraw_IsEmpty_v1() {
        try {
            emptyDeck();
            deck.draw();
            fail();
        } catch (IllegalStateException ignored) {}
    }

    @Test
    void testDraw_IsEmpty_v2() {
        assertThrows(IllegalStateException.class, deck::draw);
    }
    
    @Test
    void testConstructor() {
        Deck deck = new Deck(new Counter());
        //for
    }
    
    class Counter implements Predicate<Card> {
        private int total;

        @Override
        public boolean test(Card card) {
            total++;
            return false;
        }
    }

    private void emptyDeck() {
        for (int i = 0; i < 52; i++) {
            deck.draw();
        }
    }

    private Card getTopCard() {
        try {
            Field field = Deck.class.getDeclaredField("cards");
            field.setAccessible(true);
            return ((List<Card>) field.get(deck)).get(0);
        } catch (ReflectiveOperationException e) {
            fail();
        }
        assert false;
        return null;
    }
}
