
/**
 * Write a description of class GibberishRunner here.
 *
 * @author (Alex Beaver)
 * @version (11 OCT)
 */
public class GibberishRunner
{
    
    /**
     * Constructor for objects of class GibberishRunner
     */
    public GibberishRunner()
    {
        
    }
    
    /**
     * The runner method for the Gibberish class. Create a WordList 5000 and makes/prints a parsed gibberish MadLib
     */
    public static void main(){
        WordList5000 wl= new WordList5000();
        Gibberish g = new Gibberish();
        String gibberish = g.makeGibberish(wl);
        
        System.out.println(gibberish);
    }
    
}
