import wheelsunh.users.*;
import java.awt.Color;

/**
*
* This class will test the sensors of the Creature class.
*
* @author Jack Hamilton
* Assignment number: 5P
*
*/

public class CreatureSensorTest extends Creature
{
	//----- instance variables -----
	private Rectangle test1, test2; 
	
	//----- constructor -----
	public CreatureSensorTest( int x, int y )
	{
		
		super( x, y );
		
		test1 = new Rectangle();
		test1.setSize( 3, 3 );
		test1.setRotation( 130 );
		test1.setLocation( x + 75, y + 33 );
		test1.hide();
		
		test2 = new Rectangle();
		test2.setSize( 3, 3 );
		test2.setRotation( 50 );
		test2.setLocation( x + 75, y + 81 );
		test2.hide();
		
	}
	
	 public void active()
	{
		test1.show();
		test2.show();
	}
	
	public void deactive()
	{
		test1.hide();
		test2.hide();
	}
	
	public static void main( String[] args )
    {
        new Frame();
		
		CreatureSensorTest t1 = new CreatureSensorTest( 100, 100 );
		Utilities.sleep( 500 );
		t1.active();
		Utilities.sleep( 500 );
		t1.deactive();
    }
}