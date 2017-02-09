import greenfoot.*;


public class redbull extends Actor{
        public redbull(int r){
        setRotation(r);
    }
    public void act(){
        moveRedbull();
    }
    private void moveRedbull(){
        int rotation = getRotation();
        if(rotation<90){
          setRotation(rotation+1);
        }
        else if(rotation>90){
          setRotation(rotation-1);
        }
        if(getY() < 549){
            move(2);
        }
        else{
            getWorld().removeObject(this);
        }
    }
}
