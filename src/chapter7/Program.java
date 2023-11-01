package chapter7;

import java.util.EnumMap;
import java.util.HashMap;
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
    private void set(Day day, Show show) {
        shows.put(day, show);
    }
    public Command createSetCommand(Day day, Show show) {
        return new Command() {
            private Show previous;
            @Override
            public void execute() {
                previous = get(day);
                set(day, show);
            }

            @Override
            public void undo() {
                set(day, previous);
            }

            @Override
            public String toString() {
                return String.format("set(%s, %s)", day, show);
            }
        };
    }
    
    private void unset(Day day) {
        shows.remove(day);
    }
    public Command createUnsetCommand(Day day) {
        return new Command() {
            private Show previous;
            @Override
            public void execute() {
                previous = get(day);
                unset(day);
            }

            @Override
            public void undo() {
                set(day, previous);
            }

            @Override
            public String toString() {
                return String.format("unset(%s)", day);
            }
        };
    }
    
    public void setDefaultShow(Show show) {
        defaultShow = show;
    }
    
    private void clear() {
        for (Day day: Day.values()) {
            shows.put(day, defaultShow);
        }
    }
    public Command createClearCommand() {
        return new Command() {
            private final Map<Day, Show> previous = new HashMap<>();
            @Override
            public void execute() {
                previous.putAll(shows);
                clear();
            }

            @Override
            public void undo() {
                shows.putAll(previous);
            }

            @Override
            public String toString() {
                return "clear()";
            }
        };
    }

    @Override
    public String toString() {
        return shows.toString();
    }
}
