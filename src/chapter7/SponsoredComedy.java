package chapter7;

public class SponsoredComedy extends Comedy {
    private final String sponsor;
    private final int sponsorTime;

    public SponsoredComedy(String title, String comedian, int time, String sponsor, int sponsorTime) {
        super(title, comedian, time);
        this.sponsor = sponsor;
        this.sponsorTime = sponsorTime;
    }
}
