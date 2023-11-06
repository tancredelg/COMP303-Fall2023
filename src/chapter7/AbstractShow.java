package chapter7;

public abstract class AbstractShow implements Show {
    private String title;
    private int time;

    protected AbstractShow(String title, int time) {
        this.title = title;
        this.time = time;
    }
    
    @Override
    public int getTime() {
        return time;
    }

    // TEMPLATE PATTERN: 'template' method needs to be final to be respected
    @Override
    public final String description() {
        return String.format("%s %s : %d minutes", title, extraInformation(), getTime());
    }

    protected abstract String extraInformation();

    @Override
    public String toString() {
        return description();
    }

    @Override
    public Show copy() {
        return null;
    }
}
