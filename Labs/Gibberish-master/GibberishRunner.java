
/**
 * Write a description of class GibberishRunner here.
 *
 * @author (Alex Beaver)
 * @version (11 OCT)
 */
public class GibberishRunner
{
    // instance variables - replace the example below with your own
    private int x;
    

    /**
     * Constructor for objects of class GibberishRunner
     */
    public GibberishRunner()
    {
        // initialise instance variables
        x = 0;
    }
    
    
    public static void main(){
        WordList5000 wl= new WordList5000();
        Gibberish g = new Gibberish();
        String gibberish = g.makeGibberish(wl);
        
        System.out.println(gibberish);
    }
    
}
