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

    /**
     * Constructor for objects of class BallRunner
     */
    public BallRunner()
    {
        // initialise instance variables

    }

    /**
     * Helper Functions
     * ===============================================================
     */
    
    /**
     * Return an open slot in the BallBot Array 
     * @param bba Ballbot array to serch through
     * @return first open ballbot slot or -32767 if no open slots
     */
    public int findFreeBallBotIndex(BallBot[] bba){
        boolean runLoop = true; //Change to false when the loop should never be run through
        int i = 0; //index of the array to search through
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
    
    /**
     * Find the distance between two tgpoitns
     * @param pA The first point
     * @param pB The second point
     * @return the distance between two points
     */
    public double distanceBetween(TGPoint pA, TGPoint pB){
        double valToReturn = Math.sqrt(Math.pow(pA.x-pB.x,2) + Math.pow(pA.y-pB.y,2));
        return valToReturn;
    }

    /**
     * Test to see if a ballbot needs to bounce
     * @param bb BallBot being controlled
     * @param bba BallBot[] to look through
     * @return the ball to bounce off or -32767 if it can not bounce
     */
    public int bbBounce(BallBot bb, BallBot[] bba, int bbi){
        int valToReturn = -32767;

        for(int i = 0; i < bba.length; i++){
            if(bba[i] != null && i != bbi){
                double ballDistance = distanceBetween(bb.forwardPoint(), bba[i].forwardPoint());
                double maxRad = 0.0;
                maxRad = bb.getRadius() + bba[i].getRadius();

                if(ballDistance <= maxRad){
                    valToReturn = i;
                }
                
                
                /*if(bb.forwardPoint() == bba[i].forwardPoint() && i != bbi){
                valToReturn = i;
                }*/
            }

        }
        return valToReturn;
    }
    
    /**
     * See if the entrance of the origin point is clear
     * 
     * @param bba The array of ballbots
     * @param entrancePoint The globla entrance point
     * @return true if the entrance is clear and false if the entrance is not clear
     */

    public boolean entranceClear(BallBot[] bba, TGPoint entrancePoint){
        BallRunner br = new BallRunner();
        boolean rv = true;

        int lastSlot = br.findFreeBallBotIndex(bba)-1; //-1 to account for the last filled slot
        if(lastSlot < 0){
            flagA = 1;
            return false;

        }else{
            for(int i = 0; i < br.findFreeBallBotIndex(bba); i++){
                /*
                 * Check against all other ballbots to prevent collisions
                 */
                TGPoint bbp = bba[i].getPoint();
                double bbd = Math.sqrt(Math.pow(bbp.xDoubleValue() - entrancePoint.xDoubleValue(),2) + Math.pow(bbp.yDoubleValue() - entrancePoint.yDoubleValue(),2));
                if(bbd < 2*bba[i].getRadius()+40){
                    rv = false;
                }
                
            }
        }
        return rv;

    }

    /**
     * The function for the first challenge
     */
    public static void activityOne(){
        BallRunner br = new BallRunner();
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
                    // To prevent from going over 360 degrees
                    bb.setHeading(0);
                }
            }

        }
    }

    /**
     * The function for the second challenge
     */
    public static void activityTwo(){
        BallWorld bw = new BallWorld(1920,1080);
        BallBot[] bba = new BallBot[10];
        BallRunner ballRunner = new BallRunner();
        boolean generateBalls = true;
        BallRunner br = new BallRunner();
        while(generateBalls){
            int bbIndex = br.findFreeBallBotIndex(bba);
            if(bbIndex >= 0){
                bba[bbIndex] = new BallBot(bw,new TGPoint(Math.random()*500, Math.random()*500),Math.random()*360,(int)(Math.random()*50)); // Creates differentiation in the balls to make it easier to debug and see many balls
            }
            else{
                generateBalls = false; //Stops generating balls once no more spaces are available to save space
            }
        }

        boolean runLoop = true; //runLoop can be set to false in certain circumstances if the program needs to finish. 
        while(runLoop == true){
            for(int i = 0; i < bba.length; i++){

                if(bba[i].canMoveForward(bw)){
                    bba[i].moveForward();
                }
                else{
                    bba[i].setHeading(Math.random()*360); //Will go between 0.0 and 359.9
                }
            }

        }

    }

    /**
     * The function for the third challenge
     */
    
    public static void activityThree(){
        BallRunner br = new BallRunner();
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

                if(br.entranceClear(bba, new TGPoint(0,0)) == true || br.findFreeBallBotIndex(bba) == 0){ //Ensures that the entrance is clear
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
        

    }
    
    /**
     * The function for the fourth challenge
     */
    
    public static void activityFour(){
        BallWorld bw = new BallWorld(1920,1080);
        BallRunner br = new BallRunner();
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
                   
                    int bbBIndex = br.bbBounce(bba[i],bba,i); //ballBotBounceIndex is the index that the ball needs to bounce with
                    if(bbBIndex >0){
                        bba[i].setHeading(Math.random()*360);
                        bba[bbBIndex].setHeading(Math.random()*360);

                    }
                    if(bba[i].canMoveForward(bw)){
                        bba[i].moveForward();
                    }
                    else{
                        bba[i].setHeading(Math.random()*360);
                    }
                }
            }

        }
        
    }
    /**
     * The function for the fifth challenge
     */
    public static void activityFive(){
        BallWorld bw = new BallWorld(1920,1080);
        BallRunner br = new BallRunner();
        BallBot[] bba = new BallBot[25];
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
                    // Runs if it is safe to create a new BallBot
                    int bbfreeindex = br.findFreeBallBotIndex(bba);
                    BallBot bbTemplate = new BallBot(bw,new TGPoint(0,0),Math.random()*360,(int)(Math.random()*50));
                    bbTemplate.setColor((int)(Math.random()*32)); //Set a color
                    bbTemplate.setPixelsPerSecond((int)(Math.random()*100)+75); //Random speed
                    bba[bbfreeindex] = bbTemplate;

                }
            }

            for(int i = 0; i <  bba.length; i++){
                if(bba[i] != null){
                    
                    int bbBIndex = br.bbBounce(bba[i],bba,i);
                    BallBot currBallBot = bba[i];
                    if(bbBIndex >0){
                      
                        currBallBot.setHeading(Math.random()*360);
                        bba[bbBIndex].setHeading(Math.random()*360);

                    }
                    if((currBallBot.forwardPoint().x >= 960) || (currBallBot.forwardPoint().x <= -960) || (currBallBot.forwardPoint().y >= 540) || (currBallBot.forwardPoint().y <= -540)){
                        currBallBot.setHeading(180-2*(currBallBot.getHeading())); //Ballistic-physics to create a ballistic physics effect
                    }
                    
                    if(currBallBot.canMoveForward(bw)){
                        currBallBot.moveForward();
                        
                    }
                    else{
                        currBallBot.setHeading(Math.random()*360);
                        
                    }
                    bba[i] = currBallBot;
                }
            }

        }
        
    }
}

