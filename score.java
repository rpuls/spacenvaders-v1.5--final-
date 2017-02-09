import greenfoot.*;
import java.awt.Color;



public class score extends Actor
{
  private int points;
  private int levels;
  public Color TRANS = new Color(0f,0f,0f,0f);
  public void act(){
      space theSpace = (space)getWorld();
      points = theSpace.scoreCount;
      levels = theSpace.level;
      setImage(new GreenfootImage("SCORE:" + points + "   \n" + "LEVEL:" + levels, 24, Color.YELLOW, TRANS));
  }    
}
