package chapter7;

public class Comedy extends AbstractShow {
    private final String comedian;

    public Comedy(String title, String comedian, int time) {
        super(title, time);
        this.comedian = comedian;
    }

    @Override
    protected String extraInformation() {
        return String.format("by %s", comedian);
    }
}
