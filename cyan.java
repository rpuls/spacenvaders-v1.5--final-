import greenfoot.*;

public class cyan extends alien
{
  public cyan(int w){
        super(w, -2, 150);
        super.hitPoints = 2;
  }
      public void act(){
      super.act();
      alienShoot();
  }
  private int shootTime = 9000;
  private double timeSinceLast = System.currentTimeMillis();
  private double timeCurrent;
  protected void alienShoot(){
        timeCurrent = System.currentTimeMillis();
        if( timeCurrent > ( timeSinceLast + shootTime) ){
           timeSinceLast = timeCurrent;
           getWorld().addObject(new alienShot(), this.getX(), this.getY());
        }
  }
}
