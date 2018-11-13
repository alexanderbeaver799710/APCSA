
/**
 * Write a description of class Main here.
 *
 * @author (Alex Beaver)
 * @version (1019 - Warmup)
 */
public class Main
{
    // instance variables - replace the example below with your own
    private int x;

    public Main()
    {
        
    }
    
    /**
     * Gets the number of occurences of the key in the search string
     * @param   keyString       the value that will be searched for
     * @param   searchString    the string that will be searched
     * @return                  the number of occurances of keyString in searchString
     */
    public static int strOccurs(String keyString, String searchString){
        keyString = keyString.toLowerCase();
        searchString = searchString.toLowerCase();
        int beginIndex = 0;
        int valueToReturn = 0;
        while(searchString.indexOf(keyString, beginIndex)>= 0){
            beginIndex = searchString.indexOf(keyString, beginIndex) + 1;
            valueToReturn++;
        }
        return valueToReturn;
        
    }
    /**
     * Runner method that tests the number of occurances in a string
     * 
     * <br />
     * See {@link #strOccurs}
     */
    public static void main(){
        String keyString = "e";
        String searchString = "This wEek is Homecoming wEEk";
        System.out.println(strOccurs(keyString,searchString));
    }
}
