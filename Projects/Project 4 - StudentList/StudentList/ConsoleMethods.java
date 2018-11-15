import java.util.*;
/**
 * Write a description of class ConsoleMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ConsoleMethods
{
    /**
     * Clears the screen
     */
    public static void clearScreen(){
        
          System.out.println("\u000c");
    }
    
    /**
     * Delays for any user input
     */
    public static void waitForInput(){
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
    }

}
