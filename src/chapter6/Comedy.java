package chapter6;

public class Comedy implements Show {
    private final int time;
    private final String comedian;
    private final String title;

    public Comedy(int time, String comedian, String title) {
        this.time = time;
        this.comedian = comedian;
        this.title = title;
    }

    public Comedy(Comedy comedy) {
        this.time = comedy.time;
        this.comedian = comedy.comedian;
        this.title = comedy.title;
    }
    
    @Override
    public int getTime() {
        return time;
    }

    @Override
    public String description() {
        return String.format("%s by %s: %d minutes.", title, comedian, time);
    }

    @Override
    public Show copy() {
        return new Comedy(this);
    }

    @Override
    public String toString() {
        return description();
    }
}
