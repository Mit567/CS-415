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

public class ButtonFlash extends Rectangle
{
	//----- instance variables -----
	private Rectangle _button;
	private CreatureFlash f;
	
	//----- constructor -----
	public ButtonFlash( int x, int y, Color body )
	{
		super( x , y );
		setSize( 50, 30);
		setColor( body );
	}
	
	 public void mousePressed( java.awt.event.MouseEvent e )
	 {
		 f.active();
	 }
	 
	 public void mouseReleased( java.awt.event.MouseEvent e )
	 {
		 f.deactive();
	 }
	
	public void setPeerFlash ( CreatureFlash x )
	 {
		 f = x;
	 }
	 
	 
	public static void main( String[] args )
    {
        new Frame();
		
		//Button b1 = new Button( 100, 100 );

    }
}