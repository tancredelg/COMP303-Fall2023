package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TestCard {
    @Test
    void testGet() {
        for (Rank r: Rank.values()) {
            for (Suit s: Suit.values()) {
                assertSame(Card.get(r, s), Card.get(r, s));
            }
        }
    }
}
