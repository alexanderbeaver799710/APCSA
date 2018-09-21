import java.util.*;
/**
 * Lab 906::Find Mean Median and Mode
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatRunner{
    
    
    public static void main(){
        StatTester st = new StatTester();
        st.loadArray();
        st.printArray();
        System.out.println(st.getSum());
        System.out.println(st.getMean());
        System.out.println(st.getMedian());
        System.out.println(Arrays.toString(st.getMode()));
    }
}
