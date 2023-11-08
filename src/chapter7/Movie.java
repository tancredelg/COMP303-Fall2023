package chapter7;

public class Movie extends AbstractShow {
    private final int year;

    public Movie(String title, int year, int time) {
        super(title, time);
        this.year = year;
    }
    
    @Override
    protected String extraInformation() {
        return String.format("(%d)", year);
    }

    @Override
    public Show copy() {
        return null;
    }
}
