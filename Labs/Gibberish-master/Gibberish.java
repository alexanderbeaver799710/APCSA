
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
    /**Variable Declaration**/
    private String ss; //Source String
    

    /**
     * Create a gibberish based off a CSV file
     * 
     * @param   WordList5000    The CSV to import
     */
    public String makeGibberish(WordList5000 wl){
        /**Initialize Data**/
        ss = new Template("data/myGibberishOne.txt").getSourceString();
        System.out.println(ss);
        boolean runLoop = true;
        while(runLoop){
            /**Get the segment of tag**/
            int index = ss.indexOf("<");
            int finalIndex;
            int tagLen = 0;
            if ((finalIndex = ss.indexOf(">", index + 5) + 1)!=0){
                // You could add something here for closable tags, but I don't use it
            } else{
                
                finalIndex = -32767; //Random value chosen because it is negative and never will naturally occur
            }
            String placeHolderString = "";
            /**
             * Account for irregular tags
             */
            if(! Character.isWhitespace(ss.charAt(index + 1))){ // If the tag name is left-justified
                placeHolderString = String.valueOf(ss.charAt(index + 1));
            } else if(! Character.isWhitespace(ss.charAt(index + 2))){ // If the tag name is right justified
                placeHolderString = String.valueOf(ss.charAt(index + 2));
            }
            
            String randomWord = wl.getRandomWordString(placeHolderString); // Get Random Word for the desired type
            /**
             * In-place concatenation for the string
             */
            if(index > -1 && finalIndex != -32767){
                ss = ss.substring(0,index) + randomWord + ss.substring(finalIndex); // Insert the random word into its location
                
            } else if(finalIndex == -32767){ //If there is a non-closed XML tab
                ss = ss.substring(0,index) + ss.substring(ss.indexOf(">")+1); 
                runLoop = false;
                
            }else{ //If there are no more tags
                runLoop = false;
            }
        }
        
        
        return ss;
    }
}
