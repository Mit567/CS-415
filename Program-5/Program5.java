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

public class Program5
{
	//---- instance variables -----
	private CreatureFlash _flashCreature;
	private CreatureSensorTest _testCreature;
	private CreatureShock _shockCreature;
	private Button _button1, _button2, _button3;
	
	public static void main(String[] args )
	{
		new Frame ();
		
		CreatureFlash _flashCreature = new CreatureFlash( 100, 100 );
		CreatureSensorTest _testCreature = new CreatureSensorTest( 100, 250 );
		CreatureShock _shockCreature = new CreatureShock ( 200, 100 );
		Button _button1 = new Button ( 100, 350, Color.red, _testCreature );
		Button _button2 = new Button ( 175, 350, Color.blue, _shockCreature );
		Button _button3 = new Button ( 250, 350, Color.yellow, _flashCreature );
	}
}