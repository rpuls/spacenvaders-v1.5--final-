import greenfoot.*;


public class alienShot extends Actor
{
    public alienShot(){
        setRotation(90);
    }
    public void act(){
        MoveShot();
    }
    private void MoveShot(){
        if(getY() < 549){
            move(3);
        }
        else{
            getWorld().removeObject(this);
        }
    }
}
