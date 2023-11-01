package chapter7;

public class IntroducedShow implements Show {
    private final int extraTime;
    private final String speaker;
    private final Show show;

    public IntroducedShow(int extraTime, String speaker, Show show) {
        this.extraTime = extraTime;
        this.speaker = speaker;
        this.show = show;
    }

    @Override
    public int getTime() {
        return show.getTime() + extraTime;
    }

    @Override
    public String description() {
        return String.format("%s (introduced by %s - %d minutes)", show.description(), speaker, getTime());
    }

    @Override
    public Show copy() {
        return new IntroducedShow(extraTime, speaker, show.copy());
    }
}
