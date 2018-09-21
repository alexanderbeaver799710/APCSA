
/**
 * Write a description of class project1 here.
 * 
 * @author (Alex Beaver) 
 * @version (828)
 */
public class project1
{ 

    public project1()
    {

    }
    public static void generateStarsInRightTriangleFormation(){
        for(int x=0;x<=5;x++){
            for(int a=0;a<x;a++){
                System.out.print("*");
            }
            System.out.println("");

        }
    }

    public static void generateStarsInDiamondFormation(){
        /*
        for(int c=1;c<=9;c+= 2){
        for(int b=1;b <= 9-c + 1;b++){
        System.out.print(" ");
        }
        for(int a=0;a<c;a++){
        System.out.print("*");
        }
        System.out.println("");

        }
         */

        for(int x=0;x<=10;x++){
            if(x <= 5){
                for(int a=0;a<5-x;a++){
                    System.out.print(" ");
                }
                for(int b=0;b<x;b++){
                    System.out.print("*");
                }
                for(int c = 0; c < x-1; c++){
                    System.out.print("*");
                }
                System.out.println("");
            }
            else{
                for(int a=0;a<5-(10-x);a++){
                    System.out.print(" ");
                }
                for(int b=0;b<(10-x);b++){
                    System.out.print("*");
                }
                for(int c = 0; c < (10-x-1); c++){
                    System.out.print("*");
                }
                System.out.println("");
            }

        }
    }
    
    public static void generateEvenOdd()    {
        for(int x = 1; x<= 99; x++){
            if(x%2 == 0){
                System.out.println("EVEN");
            }
            else{
                System.out.println("ODD");
            }
        }
    }
    
    public static void problemFour(){
       int totalValue = 0;
        for(int n = 0; n <= 98; n += 2){
            totalValue = totalValue +  n;
        }
        System.out.println(totalValue);
    }

    public static void main(){
        //generateStarsInRightTriangleFormation();
        generateStarsInDiamondFormation();
        generateEvenOdd();
        problemFour();
    }

}
