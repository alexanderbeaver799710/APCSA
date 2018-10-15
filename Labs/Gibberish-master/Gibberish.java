
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
    
    private String[] possiblePartsOfSpeech = {"t","N","v"};
    
    public String makeGibberish(WordList5000 wl){
        ss = new Template("data/password-quote.txt").getSourceString();
        System.out.println(ss);
        boolean runLoop = true;
        while(runLoop){
            int index = ss.indexOf("<");
            int finalIndex;
            int tagLen = 0;
            if ((finalIndex = ss.indexOf(">", index + 5) + 1)!=0){
                
            }
            else{
                
                finalIndex = -32767;
            }
            String placeHolderString = "";
            if(! Character.isWhitespace(ss.charAt(index + 1))){
                placeHolderString = String.valueOf(ss.charAt(index + 1));
            }
            else if(! Character.isWhitespace(ss.charAt(index + 2))){
                placeHolderString = String.valueOf(ss.charAt(index + 2));
            }
            
            String randomWord = wl.getRandomWordString(placeHolderString);
            if(index > -1 && finalIndex != -32767){
                ss = ss.substring(0,index) + randomWord + ss.substring(finalIndex);
                
            }
            else if(finalIndex == -32767){
                ss = ss.substring(0,index) + ss.substring(ss.indexOf(">")+1);
                
                
                runLoop = false;
                
            }
            else{
                runLoop = false;
            }
        }
        
        
        return ss;
    }
}
