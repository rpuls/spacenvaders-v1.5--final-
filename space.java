import greenfoot.*;
import java.lang.Runnable;


public class space extends World
{
    int width = 800;
    int height = 550;
    public int level = 1;
    public int scoreCount = 0;
    protected int shipCount = 1;
    protected int blueCount = 1;
    protected int redCount = 5;
    protected int cyanCount = 5;
    protected int pinkCount = 5;
    protected int greenCount = 5;
    protected int yellowCount = 0;
    protected int moveDownTime = 10*1000;
    private double timeSinceLast = System.currentTimeMillis();
    private double timeCurrent;
    public space(){    
      super(800, 550, 1); 

      prepare();
      
    }

    protected void prepare(){
        score score = new score();
        addObject(score, 100, 25);
        ship ship = new ship();
        if(shipCount==1){
            addObject(ship, 400, 500);
        }
        int distance = width/(blueCount+1);
        for(int i = 1; i<=blueCount; i++){
            alien alien = new blue(distance);
            addObject(alien, i*distance, 50);
        }
        distance = width/(redCount+1);
        for(int i = 1; i<=redCount; i++){
            alien alien = new red(distance);
            addObject(alien, i*distance, 100);
        }
        distance = width/(cyanCount+1);
        for(int i = 1; i<=cyanCount; i++){
            alien alien = new cyan(distance);
            addObject(alien, i*distance, 150);
        }
        distance = width/(pinkCount+1);
        for(int i = 1; i<=pinkCount; i++){
            alien alien = new pink(distance);
            addObject(alien, i*distance, 200);
        }
        distance = width/(greenCount+1);
        for(int i = 1; i<=greenCount; i++){
            alien alien = new green(distance);
            addObject(alien, i*distance, 250);
        }
        distance = width/(yellowCount+1);
        for(int i = 1; i<=yellowCount; i++){
            alien alien = new yellow(distance);
            addObject(alien, i*distance, 300);
        }        

    }
    
    private void downMove(){
        downMoveList(getObjects(blue.class));
        downMoveList(getObjects(red.class));
        downMoveList(getObjects(cyan.class));
        downMoveList(getObjects(pink.class));
        downMoveList(getObjects(green.class));
        downMoveList(getObjects(yellow.class));        
    }
    
    private void downMoveList(java.util.List<alien> actors){
        for(java.util.Iterator<alien> i = actors.iterator(); i.hasNext(); ){
              alien a = i.next();
              int y = a.getY()+25;
              a.setLocation(a.getX(), y);
              if(y>=height){
                  gameOver();
                  return;
              }
        }
    }
    
    protected void moveDown(){
        timeCurrent = System.currentTimeMillis();
        if( timeCurrent > ( timeSinceLast + moveDownTime ) ){
           timeSinceLast = timeCurrent;
           downMove();
        }
    }
    
    public void act(){
        showText("Created by: Rasmus Puls", 122, 530);
        moveDown();
       if (getObjects(alien.class).isEmpty() && level==1){
            level=2;
            levelTwo();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==2){
            level=3;
            levelThree();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==3){
            level=4;
            levelFour();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==4){
            level=5;
            levelFive();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==5){
            level=6;
            levelSix();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==6){
            level=7;
            levelSeven();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==7){
            level=8;
            levelEight();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==8){
            level=9;
            levelNine();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
       if (getObjects(alien.class).isEmpty() && level==9){
            level=10;
            levelTen();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
       }
            if (getObjects(alien.class).isEmpty() && level>=10){
            level = level+1;
            levelTen();
            Greenfoot.playSound("nextlevel.mp3");
            prepare();
            if(moveDownTime>1){
                moveDownTime = moveDownTime -500;
            }
       }
    }        
    
    public void gameOver(){
      removeObjects(getObjects(null));
      gameOver gameOver = new gameOver();
      addObject(gameOver, width/2, height/2);
      Greenfoot.playSound("gameover.mp3");
    }
    
    //LEVELS
    public void levelTwo(){
    shipCount = 0;
    blueCount = 1;
    redCount = 7;
    cyanCount = 5;
    pinkCount = 7;
    greenCount = 5;
    yellowCount = 10;
    moveDownTime = 9*1000;
    }
    
    public void levelThree(){
    shipCount = 0;
    blueCount = 1;
    redCount = 10;
    cyanCount = 5;
    pinkCount = 10;
    greenCount = 5;
    yellowCount = 10;
    moveDownTime = 8*1000;
    }
    
    public void levelFour(){
    shipCount = 0;
    blueCount = 1;
    redCount = 10;
    cyanCount = 7;
    pinkCount = 10;
    greenCount = 7;
    yellowCount = 10;
    moveDownTime = 8*1000;
    }
    
    public void levelFive(){
    shipCount = 0;
    blueCount = 1;
    redCount = 13;
    cyanCount = 7;
    pinkCount = 13;
    greenCount = 7;
    yellowCount = 10;
    moveDownTime = 7*1000;
    }
    
    public void levelSix(){
    shipCount = 0;
    blueCount = 1;
    redCount = 15;
    cyanCount = 7;
    pinkCount = 15;
    greenCount = 7;
    yellowCount = 10;
    moveDownTime = 7*1000;
    }
    
    public void levelSeven(){
    shipCount = 0;
    blueCount = 0;
    redCount = 15;
    cyanCount = 7;
    pinkCount = 15;
    greenCount = 7;
    yellowCount = 10;
    moveDownTime = 6*1000;
    }
    
    public void levelEight(){
    shipCount = 0;
    blueCount = 0;
    redCount = 15;
    cyanCount = 9;
    pinkCount = 15;
    greenCount = 7;
    yellowCount = 10;
    moveDownTime = 6*1000;
    }
    
    public void levelNine(){
    shipCount = 0;
    blueCount = 0;
    redCount = 15;
    cyanCount = 13;
    pinkCount = 15;
    greenCount = 9;
    yellowCount = 10;
    moveDownTime = 6*1000;
    }
    
    public void levelTen(){
    shipCount = 0;
    blueCount = 0;
    redCount = 15;
    cyanCount = 13;
    pinkCount = 15;
    greenCount = 13;
    yellowCount = 10;
    moveDownTime = 5*1000;
    }
}

