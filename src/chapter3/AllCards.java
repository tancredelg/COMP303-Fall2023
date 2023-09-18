package chapter3;

public class AllCards implements ConfigPredicate {
    @Override
    public boolean reject(Card card) {
        return false;
    }
}
