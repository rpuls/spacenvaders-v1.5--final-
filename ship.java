import greenfoot.*;

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ship extends Actor
{
  private double SpeedMove = 0;
  private double SpeedMax = 15;
  private double SpeedAcceleration = 0.4;
  private double SpeedBreak = 0.2;
  public void ControlAdvanced(){
      if(SpeedMove < 0){
      SpeedMove += SpeedBreak;
    }
  
    if(SpeedMove > 0){
      SpeedMove -= SpeedBreak;
    }

    if((SpeedMove < SpeedMax) && (SpeedMove > (-SpeedMax))){
      if(Greenfoot.isKeyDown("left")){
        SpeedMove -= SpeedAcceleration;
      }
      
      if(Greenfoot.isKeyDown("right")){
       SpeedMove += SpeedAcceleration;
      }
    } 
   move((int)SpeedMove);   
  }
  public void act(){
    ControlAdvanced();
    shoot();
    powerUpCheck();
    alienCollideCheck();
    hitByAlienCheck();
  } 
  
  private int shootTimer = 0;
  private int shootDelay = 20;
  public void shoot(){
     if( shootTimer == 0 ){
          if( Greenfoot.isKeyDown("space")){
              getWorld().addObject(new shot(), this.getX(), this.getY()-10);
              shootTimer = shootDelay;
              Greenfoot.playSound("laser.mp3");
          }
     }
     if( shootTimer > 0 ){
         shootTimer--;
     }
  }
  public void powerUpCheck(){
    if(isTouching(redbull.class)){
          Actor redbull = getOneIntersectingObject(redbull.class);
          getWorld().removeObject(redbull);
          shootDelay = shootDelay - 2;
          Greenfoot.playSound("powerup.mp3");
    }
  }
  public void alienCollideCheck(){
    if(isTouching(alien.class)){
       ((space) getWorld()).gameOver();
    }
  }
  public void hitByAlienCheck(){
    space theSpace = (space)getWorld();
    if(isTouching(alienShot.class)){
          Actor hitShot = getOneIntersectingObject(alienShot.class);
          getWorld().removeObject(hitShot);
          theSpace.gameOver();
    }
  }
}
