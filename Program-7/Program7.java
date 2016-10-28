import wheelsunh.users.*;
import java.awt.Color;

/** 
 *
 * This class will call a TravelingCreature.
 * 
 * @author Jack Hamilton
 * Assignment number: 7P
 * 
 */
 
public class Program7 extends TravelingCreature
{
	public Program7()
	{
		super( 100, 150, Color.red );
	}
	
	public static void main( String[] args )
	{
		Frame f = new Frame();
		Program7 p = new Program7();
	}
}