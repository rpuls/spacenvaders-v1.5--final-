import greenfoot.*;

public class yellow extends alien
{
  public yellow(int w){
        super(w, 1, 125);
        super.hitPoints = 1;
  }
      public void act(){
      super.act();

  } 
   /* public void dying(){
    int r;
    if(super.delta>0){
      r = 0;
    }
    else{
      r = 180;
    }
    getWorld().addObject(new redbull(r), this.getX(), this.getY()-10);
  }*/
}
