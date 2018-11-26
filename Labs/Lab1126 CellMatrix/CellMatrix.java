import java.lang.*;
/**
 * 
 * CellMatrix
 * @author (Alex Beaver) 
 * @version (11-26-18)
 */
public class CellMatrix{
    /**
     * The array of cells
     */
    
    private Cell[][] cells;

    /**
     * +Constructor for objects of class NumberMatrix
     * 
     * @param a the length in the i dimension
     * @param b the length in the x dimension
     */
    public CellMatrix(int a, int b){
       cells = new Cell[a][b];
       
    }

    /**
     * Load neighbor cells into the neighbors array
     */
    
    public void loadNeighbors(){
        for(int i = 0; i < cells.length; i++){
            for(int x = 0; x < cells[0].length; x++){
                
                if(i > 0){
                    cells[i][x].addNeighbor(cells[i-1][x].getInt());

                }else{
                    cells[i][x].addNeighbor(0);
                }

                if(i < cells.length-1){
                    cells[i][x].addNeighbor(cells[i+1][x].getInt());

                }else{
                    cells[i][x].addNeighbor(0);
                }

                if( x > 0){
                    cells[i][x].addNeighbor(cells[i][x-1].getInt());

                }else{
                    cells[i][x].addNeighbor(0);
                }

                if(x < cells[0].length - 1){
                    cells[i][x].addNeighbor(cells[i][x+1].getInt());

                }else{
                    cells[i][x].addNeighbor(0);
                }

            }
            
        }
    }
    /*
     * methods
     */
    /**
     * Print each row and column of nums to the console
     */
    public void printMatrix(){
        for(int i = 0; i < cells.length; i ++){
            for(int x = 0; x < cells[0].length; x++){
                System.out.print(" "+cells[i][x].getInt());
            }
            System.out.println();   
        }
       
    }
    /**
     * Load nums with random with numbers between 1 and 10 inclusive
     */
    public void loadMatrix(){
        for(int i = 0; i < cells.length; i++){
            for(int x = 0; x < cells[0].length; x++){
                cells[i][x] = new Cell((int)((Math.random()*10)+1));
            }
        }
       
    }
    /**
     * Finds the sum of each of the neighbors and returns the greatest neighbor value
     * @return the sum of the neighbors
    */
    public int getGreatestNeighbors(){
        
        int maxVal = 0;
        int maxI = 0;
        int maxX = 0;
        for(int i = 0; i < cells.length; i++){
            for(int x = 0; x < cells[0].length; x++){
                System.out.print(cells[i][x].getNeighborsSum() + " | ");
                if(cells[i][x].getNeighborsSum() > maxVal){
                    maxI = i;
                    maxX = x;
                    maxVal = cells[i][x].getNeighborsSum();
                }
            }
            System.out.println();
            
        }
        System.out.println("FOUND @ ("+maxI+","+maxX+")");
        return maxVal;
    }
    
    
}
