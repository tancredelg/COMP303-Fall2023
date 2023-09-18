package chapter3;

public class Face implements ConfigPredicate {
    @Override
    public boolean reject(Card card) {
        return !card.isFace();
    }
}
