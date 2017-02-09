import greenfoot.*;

public class blue extends alien
{
  public blue(int w){
    super(w,5, 500);
  }
  public void act(){
     super.act();
  }
  public void dying(){
    int r;
    if(super.delta>0){
      r = 0;
    }
    else{
      r = 180;
    }
    getWorld().addObject(new redbull(r), this.getX(), this.getY()-10);
  }
}
