
/**
 * StatTester finds loads an Array of int
 * and finds the sum, mean, median, and mode.
 * 
 * @author (Alex) 
 * @version (906)
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
        Arrays.sort(nums); // Sort to make it look prettier
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
        int nocAsInt = 1;
        for(int i = 1; i < nums.length; i++){
            numberOfOccurances[nums[i] - 1] += 1;
        }
        int maxNOC = 0;
        // Go through the number of occurances for each number
        for(int i = 1; i <= 10; i++){
            if(numberOfOccurances[i - 1] > maxNOC){
                maxNOC = numberOfOccurances[i-1]; //Set the maximum number of occurances to the index
                valuesMet = new int[1]; //Array with the numbers that are met as the highest num; This will be what is returned
                valuesMet[0] = i;
                nocAsInt = 1;
            }
            else if(numberOfOccurances[i-1] == maxNOC){
                int[] placeHolderValues = new int[nocAsInt + 1]; //Create a new array for copying the data over as you clear the valuesMet array
                placeHolderValues = valuesMet;
                System.out.println(placeHolderValues.length);
                System.out.println(nocAsInt);
                placeHolderValues[nocAsInt-1] = i;
                
                valuesMet = new int[placeHolderValues.length]; //This creates a de-facto unspecified length array
                valuesMet = placeHolderValues; //Copies the new data over
                nocAsInt += 1; //Add one to the number of maximum occurances
                
            }
        }
        return valuesMet;
        
        
        
    }
    
    
}
