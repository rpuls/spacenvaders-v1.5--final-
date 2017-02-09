import greenfoot.*;


public class shot extends Actor{
    public shot(){
        setRotation(90);
    }
    public void act(){
        MoveShot();
    }
    private void MoveShot(){
        if(getY() > 0){
            move(-5);
        }
        else{
            getWorld().removeObject(this);
        }
    }
   
}
