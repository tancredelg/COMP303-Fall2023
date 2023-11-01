package chapter7;

public class Comedy implements Show {
    private final String title;
    private final String comedian;
    private final int time;

    public Comedy(String title, String comedian, int time) {
        this.title = title;
        this.comedian = comedian;
        this.time = time;
    }

    private Comedy(Comedy comedy) {
        this.title = comedy.title;
        this.comedian = comedy.comedian;
        this.time = comedy.time;
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
