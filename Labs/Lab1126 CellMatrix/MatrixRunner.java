
/**
 * 
 * 
 * @author (Alex Beaver) 
 * @version (11-26-18)
 */
public class MatrixRunner{
    
    public static void main(){
      CellMatrix cm = new CellMatrix(10, 10);  
      cm.loadMatrix();
      System.out.println("==============");
      cm.printMatrix();
    
      cm.loadNeighbors();
      System.out.println("");
      System.out.println("==============");
      System.out.println("Greatest " + cm.getGreatestNeighbors());
      
    }
}
