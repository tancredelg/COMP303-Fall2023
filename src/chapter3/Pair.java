package chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public record Pair(String first, String second) implements Iterable<String> {
    @Override
    public Iterator<String> iterator() {
        return List.of(first(), second()).iterator(); // Use default List iterator instead of PairIterator
        // return new PairIterator(this);
    }
}

class PairIterator implements Iterator<String> {
    private List<String> pair = new ArrayList<>();
    public PairIterator(Pair pair) {
        this.pair.add(pair.first());
        this.pair.add(pair.second());
    }

    @Override
    public boolean hasNext() {
        return pair.iterator().hasNext();
    }

    @Override
    public String next() {
        return pair.iterator().next();
    }
}