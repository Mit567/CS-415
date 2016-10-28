import wheelsunh.users.*;
import java.awt.Color;

public class Button extends ShapeGroup
{
	protected Rectangle button;
	protected TextBox display, rollDisplay;
	private boolean active = true;
	private Dice diceA, diceB, diceC;
	private boolean threeKind, strungFlowers, dancingDragon, aceNegative, bankerWin, betterWin, bankerTurn, betterTurn;
	private int pairPoint, bankerPoint, betterPoint, point;
	protected static int x, y, z;
	protected static boolean banker, better;
	protected boolean instanceBanker, instanceBetter;
	protected int win;
	
	/**
	*
	* The main contructor of the class the creates a button.
	* @param x int the x cordinate of the button
	* @param y int the y cordinate of the button
	* @param a Dice a peer dice
	* @param b Dice a peer dice
	* @param c Dice a peer dice
	* @param z boolean if it is a banker button or not
	*
	*/
	
	public Button( int x, int y, Dice a, Dice b, Dice c, boolean z )
	{
		makeButton( x, y, a, b, c, z );
	}
	
	/**
	*
	* Designs a button.
	* @param x int the x cordinate of the button
	* @param y int the y cordinate of the button
	* @param a Dice a peer dice
	* @param b Dice a peer dice
	* @param c Dice a peer dice
	* @param z boolean if it is a banker button or not
	*
	*/
	
	public void makeButton( int x, int y, Dice a, Dice b, Dice c, boolean z )
	{
		button = new Rectangle( x + 85 , y );
		button.setFrameColor( Color.black );
		button.setFillColor( Color.red );
		button.setSize( 80, 40 );
		add( button );
		
		display = new TextBox( x, y + 10 );
		display.setSize( 80, 30 );
		display.setFrameColor( Color.white );
		display.setText( "Better Role" );
		add( display );
		
		//rollDisplay = new TextBox();
		//rollDisplay.setSize( 200, 50 );
		
		setPeer( a, b, c, z );
		//update();
	}
	
	/**
	*
	* The mouse being pressed and rolling the dice assoiciated with the button.
	* @param e MouseEvent the mouse being pressed
	*
	*/
	
	public void mousePressed( java.awt.event.MouseEvent e )
	{
		if ( active==false )
			return;
		
		Slider.setBet();
		//setBet();
		x = diceA.rollDice();
		y = diceB.rollDice();
		z = diceC.rollDice();
		sendNumbers();		
	}
	
	/**
	*
	* To set if the button is active or not.
	* @param b boolean if the button is active or not
	*
	*/
	
	public void setActive( boolean b )
	{
		active = b;
		if ( active==true )
			button.setFillColor( Color.red );
		if ( active== false )
			button.setFillColor( Color.gray );
			
	}
	
	/**
	*
	* Sets the dice peers and if it is a banker or better button.
	* @param a Dice a peer dice
	* @param b Dice a peer dice
	* @param c Dice a peer dice
	* @param z boolean if it is a banker or better dice
	*
	*/
	
	public void setPeer( Dice a, Dice b , Dice c, boolean z )
	{
		diceA = a;
		diceB = b;
		diceC = c;
		boolean temp = z;
		System.out.println( z );
		if ( temp==true )
		{
			instanceBanker = true;
			//better = false;
			System.out.println( "banker peer" );
		}
		else if ( temp==false )
		{
			instanceBetter = true;
			//banker = false;
			System.out.println( "better peer" );
		}
	}
	
	/**
	*
	* Sends the numbers of the dice and if a banker or better roll over to ThreeDiceApp.
	*
	*/
	
	public void sendNumbers()
	{
		System.out.println( "hi" );
		if ( instanceBanker==true )
		{
			instanceBetter = false;
			ThreeDiceApp.getNumbers( x, y, z, true );
			System.out.println( "Send Num 1" );
		}
		else if ( instanceBetter==true )
		{
			instanceBanker = false;
			ThreeDiceApp.getNumbers( x, y, z, false );
			System.out.println( "Send Num 2" );
		}
	}
	
	/**
	*
	* Updates the text in the button's display box.
	* @param text java.lang.String the text being updated
	*
	*/
	
	public void update( java.lang.String text)
	{
		display.setText( text );
	}
	
	/**
	*
	* Sets the color of the dice.
	* @param c Color the new color of the dice
	*
	*/
	
	public void setDiceColor ( Color c )
	{
		diceA.setColor( c );
		diceB.setColor( c );
		diceC.setColor( c );
	}
	
	/**
	*
	* The main method of the class.
	* @param args String[]
	*
	*/
	
	public static void main( String[] args )
	{
		Frame f = new Frame();
		//Button b = new Button( 10, 10 );
		//b.update( "hello" );
	}
}