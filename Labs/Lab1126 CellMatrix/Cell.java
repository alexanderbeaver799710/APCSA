
/**
 * @author (Alex Beaver) 
 * @version (11 26 18)
 */
public class Cell
{
    // instance variables - replace the example below with your own
    private int x;
    
    private Cell[] neighbors;
    private int neighborIndex;
    private int neighborSum = 0;
    /**
     * Constructor for objects of class Cell
     */
    public Cell(int a)    {
        x = a;
        neighbors = new Cell[4];// North, East, South, and West only 
    }
    
    public void addNeighbor(int a){
        this.neighbors[neighborIndex] = new Cell(a);

        neighborIndex += 1;
    }
    
    
    /**
     * ++++++++++++++  methods
     */
    
    
    public int getNeighborsSum(){
        int z = 0;

        for(int a = 0; a < neighbors.length; a++){

            z += neighbors[a].getInt();

        }
        return z;
    }
    public int getInt(){
        return x;
    }
}
