import wheelsunh.users.*;
import java.awt.Color;

/**
*
* This class will make a flash for the camera of the Creature class
*
* @author Jack Hamilton
* Assignment number: 5P
*
*/

public class CreatureFlash extends Creature
{
	//----- instance variables -----
	private Ellipse flash; 
	
	//----- constructor -----
	public CreatureFlash( int x, int y )
	{
		
		super( x, y );
		flash = new Ellipse();
		flash.setLocation( x + 47, y + 10);
		flash.setFillColor( Color.yellow );
		flash.setFrameColor( Color.black );
		flash.setSize( 20, 20 );
		flash.hide();
		
	}
	
	public void active()
	{
		flash.show();
	}
	
	public void deactive()
	{
		flash.hide();
	}
	
	public static void main( String[] args )
    {
        new Frame();
		
		CreatureFlash f1 = new CreatureFlash( 100, 100 );
		Utilities.sleep( 500 );
		f1.active();
		Utilities.sleep( 500 );
		f1.deactive();
		
    }
}