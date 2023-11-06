package chapter7;

public class DoubleBill implements Show {
    private final Movie movie1;
    private final Movie movie2;

    /**
     * @param movie1 The first movie to air in the show
     * @param movie2 The second movie to air in the show
     */
    public DoubleBill(Movie movie1, Movie movie2) {
        this.movie1 = movie1;
        this.movie2 = movie2;
    }

    @Override
    public int getTime() {
        return movie1.getTime() + movie2.getTime();
    }

    @Override
    public String description() {
        return "1: " + movie1.description() + "\n2: " + movie2.description();
    }

    @Override
    public Show copy() {
        return null;//new DoubleBill(movie1.copy(), movie2.copy());
    }
}
