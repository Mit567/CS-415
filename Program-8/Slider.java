import wheelsunh.users.*;
import java.awt.Color;

public class Slider extends ShapeGroup
{
	protected Rectangle _sliderBackground;
	protected static Rectangle _sliderBar;
	protected static TextBox _display;
	private static int sliderWidth = 50;
	private static int selectedValue;
	private static int totalWidth = 100;
	private static int maxValue = 100;
	private int lastMouseX;
	protected static int bet;
	private static boolean active = true;
	
	/**
	*
	* The main constructor of the class the creates a slider.
	* @param x int the x cordinate of the slider
	* @param y int the y cordinate of the slider
	*
	*/
	
	public Slider( int x, int y )
	{
		makeSlider( x, y);
	}
	
	/**
	*
	* Creates a slider.
	* @param x int the x cordinate of the slider
	* @param y int the y cordinate of the slider
	*
	*/
	
	public void makeSlider( int x, int y )
	{
		_sliderBackground = new Rectangle( x, y );
		_sliderBackground.setFrameColor( Color.black );
		_sliderBackground.setFillColor( Color.gray.brighter() );
		_sliderBackground.setSize( 102, 20 );
		add( _sliderBackground );
		
		_sliderBar = new Rectangle( x + 1, y + 1 );
		_sliderBar.setColor( Color.green );
		_sliderBar.setSize( sliderWidth, 18 );
		add( _sliderBar );
		
		_display = new TextBox( x, y + 30 );
		_display.setFrameColor( Color.white );
		add( _display );
		
		update();
	}
	
	/**
	*
	* The mouse being pressed.
	* @param e MouseEvent the mouse being pressed
	*
	*/
	
	public void mousePressed( java.awt.event.MouseEvent e )
	{
		lastMouseX = e.getX();
	}
	
	/**
	*
	* The mouse being dragged.
	* @param e MouseEvent the mouse being dragged.
	*
	*/
	
	public void mouseDragged( java.awt.event.MouseEvent e )
	{
		if ( active==false )
			return;
		
		int dx = e.getX() - lastMouseX;
		sliderWidth = ( _sliderBar.getWidth() + dx );
		
		if ( sliderWidth<=0 )
			sliderWidth = 0;
		if ( sliderWidth>=totalWidth )
			sliderWidth = 100;
		
		update();
		lastMouseX = e.getX();
	}
	
	/**
	*
	* Updates the values of the slider.
	*
	*/
	
	public static void update()
	{
		selectedValue = (int) ((double) sliderWidth/(double) totalWidth*maxValue);
		_display.setText( selectedValue + " / " + maxValue );
		_sliderBar.setSize( sliderWidth, 18 );
	}
	
	/**
	*
	* Sets if the slider is active or not.
	*
	*/
	
	public static void setActive( boolean b )
	{
		active = b;
		if ( b==true )
			_sliderBar.setColor( Color.green );
		if ( active== false )
			_sliderBar.setColor( Color.gray );
	}
	
	/**
	*
	* Sets the bet by taking the value of the slider.
	*
	*/
	
	public static void setBet()
	{
		update();
		bet = selectedValue;
		setActive( false );
		System.out.println( "bet: " + bet);
	}
	
	/**
	*
	* Allows other classes to access the bet.
	*
	*/
	
	public static int getBet()
	{
		return bet;
	}
	
	/**
	*
	* Sets how much money the better has,
	* @param b int if the better has won, loss, or tied
	* @param x int the amount of the bet
	*
	*/
	
	public static void setMaxValue ( int b, int x )
	{
		int betterWin = b;
		if ( betterWin==1 )
		{
			maxValue = maxValue + x;
		}
		if ( betterWin==0)
		{
			maxValue = maxValue - x;
		}
		if ( betterWin==2 )
		{
			maxValue = maxValue;
		}
		update();
	}
	
	/**
	*
	* Allows other classes to acces the total money the better has,
	*
	*/
	
	public static int getMaxValue()
	{
		return maxValue;
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
		Slider s = new Slider( 50, 50);
		//s.setMaxValue( 150 );
		s.setActive( false );
	}
}