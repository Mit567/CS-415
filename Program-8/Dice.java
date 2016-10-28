import wheelsunh.users.*;
import java.awt.Color;
import java.util.Random;

public class Dice extends ShapeGroup
{
	protected Ellipse _one, _two, _three, _four, _five, _six;
	protected Rectangle _dice;
	private int x1, y1, value;
	private int random;
	private Random r = new Random();
	
	/**
	*
	* The main constructor of the class that creates a dice.
	* @param x int the x cordinate of the dice
	* @param y int the y cordinate of the dice
	*
	*/
	
	public Dice ( int x, int y )
	{
		makeDice( x, y );
		
	}
	
	/**
	*
	* A method that creates a dice
	* @param x int the x cordinate of the dice
	* @param y int the y cordinate of the dice
	*
	*/
	
	public void makeDice( int x, int y )
	{
		_dice = new Rectangle();
		_dice.setFrameColor( Color.black );
		_dice.setFillColor( Color.white );
		_dice.setLocation( x, y );
		_dice.setSize( 50, 50 );
		add(_dice);
		
		_one = new Ellipse();
		_one.setSize( 10, 10 );
		_one.setLocation( x + 5, y + 5 );
		_one.setColor( Color.black );
		add( _one );
		
		_two = new Ellipse();
		_two.setSize( 10, 10 );
		_two.setLocation( x + 5, y + 20 );
		_two.setColor( Color.black );
		add( _two );
		
		_three = new Ellipse();
		_three.setSize( 10, 10 );
		_three.setLocation( x + 5, y +  35 );
		_three.setColor( Color.black );
		add( _three );
		
		_four = new Ellipse();
		_four.setSize( 10, 10 );
		_four.setLocation( x + 35, y + 5 );
		_four.setColor( Color.black );
		add( _four );
		
		_five = new Ellipse();
		_five.setSize( 10, 10 );
		_five.setLocation( x + 35, y + 20 );
		_five.setColor( Color.black );
		add( _five );
		
		_six = new Ellipse();
		_six.setSize( 10, 10 );
		_six.setLocation( x + 35, y +  35 );
		_six.setColor( Color.black );
		add( _six );
		
		hideAllDots();
		x1 = x;
		y1 = y;
	}
	
	/**
	*
	* Sets the color of the dice.
	* @param c Color the new color of the dice
	*
	*/
	
	public void setColor( Color c )
	{
		_dice.setFillColor( c );
	}
	
	/**
	*
	* Hides all of the dice.
	*
	*/
	
	public void hideAllDots()
	{
		_one.hide();
		_two.hide();
		_three.hide();
		_four.hide();
		_five.hide();
		_six.hide();
	}
	
	/**
	*
	* Sets wich dots show on the dice to represent the number rolled.
	* @param x int the number rolled for the dice
	*
	*/
	
	public void setNumber( int x )
	{
		if ( x==1 )
		{
			_one.setLocation( x1 + 20, y1 + 20 );
			_one.show();
			_two.hide();
			_three.hide();
			_four.hide();
			_five.hide();
			_six.hide();
		}
		else if ( x==2 )
		{
			_one.setLocation( x1 + 5, y1 + 5 );
			_two.setLocation( x1 + 35, y1 + 35 );
			_two.show();
			_one.show();
			_three.hide();
			_four.hide();
			_five.hide();
			_six.hide();
		}
		else if ( x==3 )
		{
			_one.setLocation( x1 + 5, y1 + 5 );
			_two.setLocation( x1 + 35, y1 + 35 );
			_three.setLocation( x1 + 20, y1 + 20 );
			_two.show();
			_one.show();
			_three.show();
			_four.hide();
			_five.hide();
			_six.hide();
		}
		else if ( x==4 )
		{
			_one.setLocation( x1 + 5, y1 + 5 );
			_two.setLocation( x1 + 5, y1 + 35 );
			_three.setLocation( x1 + 35, y1 + 5 );
			_four.setLocation( x1 + 35, y1 + 35 );
			_two.show();
			_one.show();
			_three.show();
			_four.show();
			_five.hide();
			_six.hide();
		}
		else if ( x==5 )
		{
			_one.setLocation( x1 + 5, y1 + 5 );
			_two.setLocation( x1 + 5, y1 + 35 );
			_three.setLocation( x1 + 35, y1 + 5 );
			_four.setLocation( x1 + 35, y1 + 35 );
			_five.setLocation( x1 + 20, y1 + 20 );
			_two.show();
			_one.show();
			_three.show();
			_four.show();
			_five.show();
			_six.hide();
		}
		else if ( x==6 )
		{
			_one.setLocation( x1 + 5, y1 + 5 );
			_two.setLocation( x1 + 5, y1 + 35 );
			_three.setLocation( x1 + 35, y1 + 5 );
			_four.setLocation( x1 + 35, y1 + 35 );
			_five.setLocation( x1 + 5, y1 + 20 );
			_six.setLocation( x1 + 35, y1 + 20 );
			_two.show();
			_one.show();
			_three.show();
			_four.show();
			_five.show();
			_six.show();
		}
	}
	
	/**
	*
	* Rolls the dice by setting it to a random number between 1 & 6
	*
	*/
	
	public int rollDice()
	{
		random = r.nextInt( 6 ) + 1;
		setNumber( random );
		return random;
	}
	
	/**
	*
	* Allows other classes to acces the value of the dice.
	*
	*/
	
	public int getValue()
	{
		return value;
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
		Dice d1 = new Dice( 50, 50 );
		Dice d2 = new Dice( 50, 150 );
		d2.setColor( Color.yellow );
		d2.setNumber( 1 );
		Utilities.sleep( 1000 );
		d2.setNumber( 2 );
		Utilities.sleep( 1000 );
		d2.setNumber( 3 );
		Utilities.sleep( 1000 );
		d2.setNumber( 4 );
		Utilities.sleep( 1000 );
		d2.setNumber( 5 );
		Utilities.sleep( 1000 );
		d2.setNumber( 6 );
		Utilities.sleep( 1000 );
		d2.rollDice();
    }
}