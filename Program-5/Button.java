import wheelsunh.users.*;
import java.awt.Color;

/**
*
* This class will create buttons to activate each creature.
*
* @author Jack Hamilton
* Assignment number: 5P
*
*/

public class Button extends Rectangle
{
	//----- instance variables -----
	private Rectangle _button;
	private Creature creatureType;
	
	//----- constructor -----
	public Button( int x, int y, Color body, Creature c )
	{
		super( x , y );
		setSize( 50, 30);
		setColor( body );
		setPeer( c );
	}
	
	 public void mousePressed( java.awt.event.MouseEvent e )
	 {
		 creatureType.active();
	 }
	 
	 public void mouseReleased( java.awt.event.MouseEvent e )
	 {
		 creatureType.deactive();
	 }
	 
	 public void setPeer ( Creature c )
	 {
		 creatureType = c;
	 }
	 
	public static void main( String[] args )
    {
        new Frame();
		
		//Button b1 = new Button( 100, 100 );

    }
}