package chapter7;

public class Movie implements Show {
    private final String title;
    private final int year;
    private final int time;

    public Movie(String title, int year, int time) {
        assert !title.isEmpty();
        assert year >= 1800;
        assert time > 0;
        this.title = title;
        this.year = year;
        this.time = time;
    }
    
    public Movie(Movie movie) {
        this.title = movie.title;
        this.year = movie.year;
        this.time = movie.time;
    }
    
    public int getTime() {
        return time;
    }

    @Override
    public String description() {
        return String.format("%s (%s) - %d minutes", title, year, time);
    }

    @Override
    public Movie copy() {
        return new Movie(this);
    }

    @Override
    public String toString() {
        return description();
    }
}
