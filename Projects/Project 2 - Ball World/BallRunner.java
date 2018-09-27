import java.*;
/**
 * Write a description of class BallRunner here.
 *
 * @author (Alex)
 * @version (Proj 2)
 */
public class BallRunner
{
    // instance variables - replace the example below with your own
    /**
     * Flag to show that the task is ended
     */
    public static int flagA = 0;
    BallRunner br = new BallRunner();
    /**
     * Constructor for objects of class BallRunner
     */
    public BallRunner()
    {
        // initialise instance variables

    }

    /**
     * Helper Functions
     */
    public int findFreeBallBotIndex(BallBot[] bba){
        boolean runLoop = true;
        int i = 0;
        int valToReturn = -32767;
        while(runLoop){
            if(bba[i] == null){
                runLoop = false;
                valToReturn = i;
            }
            if(i == bba.length-1){
                runLoop = false;

            }
            i++;
        }
        return valToReturn;
    }

    public double distanceBetween(TGPoint pA, TGPoint pB){
        double valToReturn = Math.sqrt(Math.pow(pA.x-pB.x,2) + Math.pow(pA.y-pB.y,2));
        return valToReturn;
    }
    /**
     * @param bb BallBot being controlled
     * @param bba BallBot[] to look through
     */
    public int bbBounce(BallBot bb, BallBot[] bba, int bbi){
        int valToReturn = -32767;
        for(int i = 0; i < bba.length; i++){
            if(bba[i] != null){
                if(bb.forwardPoint() == bba[i].forwardPoint() && i != bbi){
                valToReturn = i;
            }
            }
            
        }
    }
    
    public boolean entranceClear(BallBot[] bba, TGPoint entrancePoint){
        boolean rv = false;

        int lastSlot = br.findFreeBallBotIndex(bba)-1; //-1 to account for the last filled slot
        if(lastSlot < 0){
            flagA = 1;
            return false;

        }
        TGPoint bbp = bba[lastSlot].getPoint();
        double bbd = Math.sqrt(Math.pow(bbp.xDoubleValue() - entrancePoint.xDoubleValue(),2) + Math.pow(bbp.yDoubleValue() - entrancePoint.yDoubleValue(),2));
        if(bbd > 75){
            return true;
        }
        else{
            return false;
        }

    }
    
    

    public static void activityOne(){
        BallWorld bw = new BallWorld(1920,1080);
        BallBot bb = new BallBot(bw,new TGPoint(300,300),0,25);
        int heading = 0;
        boolean runLoop = true;
        while(runLoop == true){
            if(bb.canMoveForward(bw)){
                bb.moveForward();
            }
            else{
                if( bb.getHeading() < 270){
                    bb.setHeading(bb.getHeading() + 90);
                }
                else{
                    bb.setHeading(0);
                }
            }

        }
    }

    public static void activityTwo(){
        BallWorld bw = new BallWorld(1920,1080);
        BallBot[] bba = new BallBot[10];
        BallRunner ballRunner = new BallRunner();
        boolean generateBalls = true;
        while(generateBalls){
            int bbIndex = br.findFreeBallBotIndex(bba);
            if(bbIndex >= 0){
                bba[bbIndex] = new BallBot(bw,new TGPoint(Math.random()*500, Math.random()*500),Math.random()*360,(int)(Math.random()*50));
            }
            else{
                generateBalls = false;
            }
        }

        boolean runLoop = true;
        while(runLoop == true){
            for(int i = 0; i < bba.length; i++){

                if(bba[i].canMoveForward(bw)){
                    bba[i].moveForward();
                }
                else{
                    bba[i].setHeading(Math.random()*360);
                }
            }

        }

    }

    public static void activityThree(){
        BallWorld bw = new BallWorld(1920,1080);
        BallBot[] bba = new BallBot[15];
        BallRunner ballRunner = new BallRunner();
        boolean generateBalls = true;

        int numOfBalls = 0;
        boolean runLoop = true;
        while(runLoop == true){
            /**
             * Ball Generation
             */
            
           if(br.findFreeBallBotIndex(bba)>=0){

               if(br.entranceClear(bba, new TGPoint(0,0)) == true || br.findFreeBallBotIndex(bba) == 0){
                   bba[br.findFreeBallBotIndex(bba)] = new BallBot(bw,new TGPoint(0,0),Math.random()*360,(int)(Math.random()*50));
                }
            }
            
            for(int i = 0; i <  bba.length; i++){
                if(bba[i] != null){
                    if(bba[i].canMoveForward(bw)){
                        bba[i].moveForward();
                    }
                    else{
                        bba[i].setHeading(Math.random()*360);
                    }
                }
            }
            

        }
        // update to GH
        

    }
    public static void activityFour(){
        BallWorld bw = new BallWorld(1920,1080);
        BallBot[] bba = new BallBot[15];
        BallRunner ballRunner = new BallRunner();
        boolean generateBalls = true;

        int numOfBalls = 0;
        boolean runLoop = true;
        while(runLoop == true){
            /**
             * Ball Generation
             */
            
           if(br.findFreeBallBotIndex(bba)>=0){

               if(br.entranceClear(bba, new TGPoint(0,0)) == true || br.findFreeBallBotIndex(bba) == 0){
                   bba[br.findFreeBallBotIndex(bba)] = new BallBot(bw,new TGPoint(0,0),Math.random()*360,(int)(Math.random()*50));
                }
            }
            
            for(int i = 0; i <  bba.length; i++){
                if(bba[i] != null){
                    
                    if(bba[i].canMoveForward(bw)){
                        bba[i].moveForward();
                    }
                    else{
                        bba[i].setHeading(Math.random()*360);
                    }
                }
            }
            

        }
        // update to GH
        

    }
}

