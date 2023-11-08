package chapter7;

public class Comedy extends AbstractShow implements Cloneable {
    private final String comedian;

    public Comedy(String title, String comedian, int time) {
        super(title, time);
        this.comedian = comedian;
    }

    @Override
    protected String extraInformation() {
        return String.format("by %s", comedian);
    }
    
    protected Comedy clone() {
        try {
            return (Comedy) super.clone();
        } catch (CloneNotSupportedException e) {
            // Cannot happen
            return null;
        }
    }

    @Override
    public Show copy() {
        return clone();
    }
}
