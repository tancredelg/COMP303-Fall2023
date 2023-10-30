package chapter6;

import java.util.EnumMap;
import java.util.Map;

/**
 * A program can aggregate at most one show per day.
 * How do we implement the aggregation?
 */
public class Program {
    /**
     * Invariant: There is always a value for each day
     */
    private final Map<Day, Show> shows = new EnumMap<>(Day.class);
    private Show defaultShow = Show.NULL;

    public Program() {
        clear();
    }

    public Show get(Day day) {
        return shows.get(day);
    }
    
    /**
     * Overrides if shows[Day] already has a show
     * @param day The day of the show
     * @param show The show being aired
     * @pre
     */
    public void set(Day day, Show show) {
        shows.put(day, show);
    }
    
    public void unset(Day day) {
        shows.remove(day);
    }
    
    public void setDefaultShow(Show show) {
        defaultShow = show;
    }
    
    public void clear() {
        for (Day day: Day.values()) {
            shows.put(day, defaultShow);
        }
    }

    @Override
    public String toString() {
        return shows.toString();
    }
}
