package chapter6;

public interface Show {
    
    static Show NULL = createNULLShow();
    
    private static Show createNULLShow() {
        return new Show() {
            @Override
            public int getTime() {
                return 1;
            }
    
            @Override
            public String description() {
                return "NULL SHOW";
            }
    
            @Override
            public Show copy() {
                return null;
            }
        };
    }
    
    /**
     * @return The running time in minutes
     * @post > 0
     */
    int getTime();

    /**
     * @return A description of the show
     * @post != null && !blank
     */
    String description();

    /**
     * @return A deep copy of the show
     */
    Show copy();
    
    default boolean isNull() {
        return true;
    }
}
