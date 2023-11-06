package chapter7;

public class Client {
    private static final Movie A_NEW_HOPE = new Movie("Star Wars: Episode IV - A New Hope", 1977, 121);
    private static final Movie EMPIRE_STRIKES_BACK = new Movie("Star Wars: Episode V - The Empire Strikes Back", 1980, 124);
    private static final Movie RETURN_OF_THE_JEDI = new Movie("Star Wars: Episode VI - Return of the Jedi", 1983, 131);
    private static final Comedy CHAVES = new Comedy("Rebel Without a Pause", "Martha Chaves", 82);
    private static final SponsoredComedy CHAVES_SPONSORED = new SponsoredComedy("Rebel Without a Pause", "Martha Chaves", 82, "McGill", 10);
    
            
    public static void main(String[] args) {
        Show show = new CompositeShow(A_NEW_HOPE, EMPIRE_STRIKES_BACK, RETURN_OF_THE_JEDI);
        Show show2 = new IntroducedShow(15, "George Lucas", show);

        System.out.println(A_NEW_HOPE);
        System.out.println(CHAVES);
        System.out.println(CHAVES_SPONSORED);
    }
}
