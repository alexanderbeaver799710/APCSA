
/**
 * StatTester finds loads an Array of int
 * and finds the sum, mean, median, and mode.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// imports go here
import java.util.*;
public class StatTester{
    //  Instance variables
    private int[] nums;
    
    // Constructor
    public StatTester(){
        nums = new int[100];
        Arrays.sort(nums);
    }
    
    
    //  Methods
    public void loadArray(){
        for(int i = 0; i < 100; i++){
            nums[i] = (int)(Math.random()*10+1);
        }
    }
    public void printArray(){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ", ");
            if((i+1) % 10 == 0 && i != 1){
                System.out.println(" ");
            }
        }
        
    }
    
    public int getSum(){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }
    
    public double getMean(){
        return getSum()/nums.length;
    }
    
    public double getMedian(){
        
        double valueToReturn;
        if(nums.length % 2 == 0){
            int index = (int)Math.floor(nums.length/2);
            valueToReturn = (nums[index]+nums[index+1])/2;
        }
        else{
            int index = (int)Math.floor(nums.length/2);
            valueToReturn = nums[index];
        }
        return valueToReturn;
    }
    
    public int[] getMode(){
        int[] valuesMet = new int[10];
        int[] numberOfOccurances = new int[10];
        int nocAsInt = 0;
        for(int i = 1; i < nums.length; i++){
            numberOfOccurances[nums[i] - 1] += 1;
        }
        int maxNOC = 0;
        for(int i = 1; i <= 10; i++){
            if(numberOfOccurances[i - 1] > maxNOC){
                maxNOC = numberOfOccurances[i-1];
                valuesMet = new int[1];
                valuesMet[0] = i;
                nocAsInt = 1;
            }
            else if(numberOfOccurances[i-1] == maxNOC){
                int[] placeHolderValues = new int[nocAsInt + 1];
                placeHolderValues = valuesMet;
                placeHolderValues[nocAsInt] = i;
                valuesMet = new int[placeHolderValues.length];
                valuesMet = placeHolderValues;
                nocAsInt += 1;
                
            }
        }
        return valuesMet;
        
        
        
    }
    
    
}
