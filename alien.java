import greenfoot.*;
public class alien extends Actor{
  private int count = 0;
  private int width;
  protected int delta;
  private int points;
    public alien(int w, int ms, int p){
    width = w;
    delta = ms;
    points = p;
  }
  public void act(){
    hitCheck();
    move(delta);
    count = count + delta;
    
    if(count==width/2){
      delta = -delta;  
    }
    else if(count == -width/2){
      delta = -delta;  
    }
  }
  public int hitPoints = 0;
  
  public void hitCheck(){
    space theSpace = (space)getWorld();
    if(isTouching(shot.class)){
          Actor hitShot = getOneIntersectingObject(shot.class);
          getWorld().removeObject(hitShot);
          if(hitPoints > 0){
              hitPoints -= 1;
          }
          else{
                dying();
                theSpace.removeObject(this);
                theSpace.scoreCount = theSpace.scoreCount + points;
          }
    }
  }
  public void dying(){
  }
}
