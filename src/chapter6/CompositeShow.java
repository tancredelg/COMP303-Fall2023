package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class CompositeShow implements Show {
    private List<Show> shows = new ArrayList<>();

    public CompositeShow(Show...shows) {
        assert shows != null;
        this.shows = Arrays.asList(shows);
    }
    
    public static CompositeShow doubleBill(Movie movie1, Movie movie2) {
        return new CompositeShow(movie1, movie2);
    }

    @Override
    public int getTime() {
        int time = 0;
        for (Show show: shows) {
            time += show.getTime();
        }
        return time;
    }

    @Override
    public String description() {
        StringJoiner description = new StringJoiner(", ", "[ ", " ]");
        for (Show show : shows) {
            description.add(show.description());
        }
        return description.toString();
    }

    @Override
    public Show copy() {
        List<Show> shows = new ArrayList<>();
        for (Show show : this.shows) {
            shows.add(show.copy());
        }
        
        return new CompositeShow(shows.toArray(new Show[shows.size()]));
    }
}
