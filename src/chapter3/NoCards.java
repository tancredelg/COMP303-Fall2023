package chapter3;

public class NoCards implements ConfigPredicate {
    @Override
    public boolean reject(Card card) {
        return true;
    }
}
