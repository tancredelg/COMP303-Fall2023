package chapter3;

public class NoFace implements ConfigPredicate {
    @Override
    public boolean reject(Card card) {
        return card.isFace();
    }
}
