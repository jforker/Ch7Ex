import greenfoot.*;
import java.util.List;

/**
 * A block that bounces back and forth across the screen.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Block extends Actor
{
    private int delta = 2;
    
    /**
     * Move across the screen, bounce off edges. Turn leaves, if we touch any.
     */
    public void act() 
    {
        move();
        checkEdge();
        checkMouseClick();
        checkLeaf();
    }
    
    /**
     * Move sideways, either left or right.
     */
    private void move()
    {
        setLocation(getX()+delta, getY());
    }
    
    /**
     * Check whether we are at the edge of the screen. If we are, turn around.
     */
    private void checkEdge()
    {
        if (isAtEdge()) 
        {
            World world = getWorld();
            //world.addObject(new Leaf(), this.getX(), this.getY());
            delta = -delta;  // reverse direction
        }
    }
    
    /**
     * Check whether the mouse button was clicked. If it was, change all leaves.
     */
private void checkMouseClick()
    {
        if(Greenfoot.mouseClicked(null))
        {
            World world = getWorld();
            List<Leaf> leaves = world.getObjects(Leaf.class);
            for(Leaf leaf : leaves)
            {
                leaf.changeImage();
            }
        }
    }
    
    private void checkLeaf()
    {
        Leaf leaf  = (Leaf) getOneIntersectingObject(Leaf.class);
        if (leaf != null)
        {
            leaf.turn(9);
        }
        
    }
    
}
