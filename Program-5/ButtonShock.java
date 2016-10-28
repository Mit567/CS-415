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

public class ButtonShock extends Rectangle
{
	//----- instance variables -----
	private Rectangle _button;
	private CreatureShock sh;
	
	//----- constructor -----
	public ButtonShock( int x, int y, Color body )
	{
		super( x , y );
		setSize( 50, 30);
		setColor( body );
	}
	
	 public void mousePressed( java.awt.event.MouseEvent e )
	 {
		 sh.active();
	 }
	 
	 public void mouseReleased( java.awt.event.MouseEvent e )
	 {
		 sh.deactive();
	 }
	
	public void setPeerShock ( CreatureShock x )
	 {
		 sh = x;
	 }
	 
	 
	public static void main( String[] args )
    {
        new Frame();
		
		//Button b1 = new Button( 100, 100 );

    }
}