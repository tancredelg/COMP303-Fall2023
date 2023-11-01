package chapter7;

public class Client {
    private static final Movie A_NEW_HOPE = new Movie("Star Wars: Episode IV - A New Hope", 1977, 121);
    private static final Movie EMPIRE_STRIKES_BACK = new Movie("Star Wars: Episode V - The Empire Strikes Back", 1980, 124);
    private static final Movie RETURN_OF_THE_JEDI = new Movie("Star Wars: Episode VI - Return of the Jedi", 1983, 131);
    
            
    public static void main(String[] args) {
        Show show = new CompositeShow(A_NEW_HOPE, EMPIRE_STRIKES_BACK, RETURN_OF_THE_JEDI);
        Show show2 = new IntroducedShow(15, "George Lucas", show);
        
        Program p = new Program();
        Command setCommand = p.createSetCommand(Day.MONDAY, EMPIRE_STRIKES_BACK);
        Command unsetCommand = p.createUnsetCommand(Day.MONDAY);
        System.out.println(p);
    }
}
