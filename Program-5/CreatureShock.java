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

public class CreatureShock extends Creature
{
	//----- instance variables -----
	private Line zap1, zap2, zap3, zap4, zap5, zap6, zap7, zap8, zap9;
	
	//----- constructor -----
	public CreatureShock( int x, int y )
	{
		
		super( x, y );
		
		zap1 = new Line();
		zap1.setColor( Color.blue );
		zap1.setRotation( 145 );
		zap1.setLocation( x + 87, y + 41 );
		zap1.setSize( 10, 1 );
		
		zap2 = new Line();
		zap2.setColor( Color.blue );
		zap2.setRotation( 145 );
		zap2.setLocation( x + 87, y + 44 );
		zap2.setSize( 10, 1 );
		
		zap3 = new Line();
		zap3.setColor( Color.blue );
		zap3.setRotation( 145 );
		zap3.setLocation( x + 87, y + 48 );
		zap3.setSize( 10, 1 );
		
		zap4 = new Line();
		zap4.setColor( Color.blue );
		zap4.setRotation( 145 );
		zap4.setLocation( x + 87, y + 52 );
		zap4.setSize( 10, 1 );
		
		zap5 = new Line();
		zap5.setColor( Color.blue );
		zap5.setRotation( 145 );
		zap5.setLocation( x + 87, y + 56 );
		zap5.setSize( 10, 1 );
		
		zap6 = new Line();
		zap6.setColor( Color.blue );
		zap6.setRotation( 145 );
		zap6.setLocation( x + 87, y + 60 );
		zap6.setSize( 10, 1 );
		
		zap7 = new Line();
		zap7.setColor( Color.blue );
		zap7.setRotation( 145 );
		zap7.setLocation( x + 87, y + 64 );
		zap7.setSize( 10, 1 );
		
		zap8 = new Line();
		zap8.setColor( Color.blue );
		zap8.setRotation( 145 );
		zap8.setLocation( x + 87, y + 68 );
		zap8.setSize( 10, 1 );
		
		zap9 = new Line();
		zap9.setColor( Color.blue );
		zap9.setRotation( 145 );
		zap9.setLocation( x + 87, y + 72 );
		zap9.setSize( 10, 1 );
		
		zap1.hide();
		zap2.hide();
		zap3.hide();
		zap4.hide();
		zap5.hide();
		zap6.hide();
		zap7.hide();
		zap8.hide();
		zap9.hide();
		
	}
	
	public void active()
	{
		zap1.show();
		zap2.show();
		zap3.show();
		zap4.show();
		zap5.show();
		zap6.show();
		zap7.show();
		zap8.show();
		zap9.show();
	}
	
	public void deactive()
	{
		zap1.hide();
		zap2.hide();
		zap3.hide();
		zap4.hide();
		zap5.hide();
		zap6.hide();
		zap7.hide();
		zap8.hide();
		zap9.hide();
	}
	
	public static void main( String[] args )
    {
        new Frame();
		
		CreatureShock t1 = new CreatureShock( 100, 100 );
		Utilities.sleep( 500 );
		t1.active();
		Utilities.sleep( 500 );
		t1.deactive();
    }
}