
/**
 * Write a description of class Gibberish here.
 *
 * @author (Alex)
 * @version (11 OCT)
 */
public class Gibberish
{
    public Gibberish(){
    }
    private String ss; //Source String

    
    public String makeGibberish(WordList5000 wl){
        ss = new Template().getSourceString();
        System.out.println(ss);
        boolean runLoop = true;
        while(runLoop){
            int index = ss.indexOf("<");
            int finalIndex = ss.indexOf("</>") + 3;
            String placeHolderString = String.valueOf(ss.charAt(index + 1));
            String randomWord = wl.getRandomWordString(placeHolderString);
            if(index > -1){
                ss = ss.substring(0,index) + randomWord + ss.substring(finalIndex);
                
            }
            else{
                runLoop = false;
            }
        }
        
        
        return ss;
    }
}
