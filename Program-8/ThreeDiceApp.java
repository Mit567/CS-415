import wheelsunh.users.*;
import java.awt.Color;

public class ThreeDiceApp
{
	private static Dice _banker1, _banker2, _banker3, _better1, _better2, _better3;
	private static Slider _slider;
	private static Button _bankerButton, _betterButton;
	private static TextBox _bankerDisplay, _betterDisplay;
	private static int _banker = 0;
	private static int _better = 1;
	private static int bankerPoint;
	private static int betterPoint, bet;
	private static int bankerWinNum = 3;
	private static int betterWinNum = 3;
	private static int bankerPair, betterPair, bankerA, bankerB, bankerC, betterA, betterB, betterC;
	private static boolean bankerWin, betterWin, bankerThree, bankerDragons, bankerFlowers;
	private static boolean bankerAce, betterThree, betterDragons, betterAce, betterFlowers, banker, better;
	
	/**
	*
	* The main method of the class that initialize all of the pieces.
	*
	*/
	
	public ThreeDiceApp()
	{
		_banker1 = new Dice( 50, 50 );
		_banker2 = new Dice( 150, 50 );
		_banker3 = new Dice( 250, 50 );
		
		_better1 = new Dice( 50, 150 );
		_better2 = new Dice( 150, 150 );
		_better3 = new Dice( 250, 150 );
		
		_slider = new Slider( 50, 300 );
		
		_bankerButton = new Button( 50, 350, _banker1, _banker2, _banker3, true );
		_bankerButton.update( "Banker" );
		_bankerButton.setActive( true );
		_betterButton = new Button( 50, 400, _better1, _better2, _better3, false );
		_betterButton.update( "Better" );
		_betterButton.setActive( false );
		
		_bankerDisplay = new TextBox( 350, 50 );
		_bankerDisplay.setSize( 200, 50 );
		_bankerDisplay.setText( "Banker: ");
		_betterDisplay = new TextBox( 350, 150 );
		_betterDisplay.setSize( 200, 50 );
		_betterDisplay.setText( "Better: ");
		
	}
	
	/**
	*
	* Checks to see if one of players has won.
	* 
	*/
	
	public static void checkWin()
	{
		System.out.println( bankerWinNum );
		System.out.println( betterWinNum );
		if ( banker==true )
		{
			bankerThree = threeKind( bankerA, bankerB, bankerC );
			bankerPair = pairPoint( bankerA, bankerB, bankerC );
			bankerFlowers = strungFlowers( bankerA, bankerB, bankerC );
			bankerDragons = dancingDragon( bankerA, bankerB, bankerC );
			bankerAce = aceNegative( bankerA, bankerB, bankerC );
			System.out.println( "banker check" );
		}
		
		if ( better==true )
		{
			betterThree = threeKind( betterA, betterB, betterC );
			betterPair = pairPoint( betterA, betterB, betterC );
			betterFlowers = strungFlowers( betterA, betterB, betterC );
			betterDragons = dancingDragon( betterA, betterB, betterC );
			betterAce = aceNegative( betterA, betterB, betterC );
			System.out.println( "better check" );
		}
		
		System.out.println( "Banker Pair: " + bankerPair );
		System.out.println( "Better Pair: " + betterPair );
		
		if ( banker==true )
		{
			_bankerButton.setDiceColor( Color.white );
			_betterButton.setDiceColor( Color.white );
			_betterDisplay.setText( "Better:" );
			
			if ( bankerThree==true || bankerPair==6 || bankerFlowers==true )
			{
				bankerWinNum = 1;
				System.out.println( bankerWinNum );
				if ( bankerThree==true )
				{
					_bankerDisplay.setText( "Banker: Banker wins on a Three in a row. Better looses " + bet );
				}
				else if ( bankerPair==6 )
				{
					_bankerDisplay.setText( "Banker: Banker wins on a Pair Point-6. Better looses " + bet );
				}
				else if ( bankerFlowers==true )
				{
					_bankerDisplay.setText( "Banker: Banker wins on Strung Flowers. Better looses " + bet );
				}
			}
			else if ( bankerAce==true || bankerDragons==true )
			{
				bankerWinNum = 0;
				System.out.println( bankerWinNum );
				if ( bankerAce==true )
				{
					_bankerDisplay.setText( "Banker: Banker looses on an Ace Negative. Better wins " + bet );
				}
				else if ( bankerDragons==true )
				{
					_bankerDisplay.setText( "Banker: Banker looses on a Dancing Dragon. Better wins " + bet );
				}
			}
			else if ( bankerPair!=6 && bankerPair!=1 && bankerPair!=0 )
			{
				bankerWinNum = 2;
				_bankerButton.setActive( false );
				_betterButton.setActive( true );
				_bankerButton.setDiceColor( Color.yellow );
				System.out.println( bankerWinNum );
				_bankerDisplay.setText( "Banker: Banker Pair Point-" + bankerPair + " .Better's turn." );
			}
			else
			{
				_bankerDisplay.setText( "Banker: Banker Reroll" );
				_bankerButton.setDiceColor( Color.white );
				_betterButton.setDiceColor( Color.white );
			}
		}
		
		if ( better==true )
		{
			if ( betterThree==true || betterPair==6 || betterFlowers==true )
			{
				betterWinNum = 0;
				System.out.println( betterWinNum );
				if ( betterThree==true )
				{
					_betterDisplay.setText( "Better: Better looses on a Three in a row. Better looses " + bet );
				}
				else if ( betterPair==6 )
				{
					_betterDisplay.setText( "Better: Better looses on a Pair Point-6. Better looses " + bet );
				}
				else if ( betterFlowers==true )
				{
					_betterDisplay.setText( "Better: Better looses on Strung Flowers. Better looses " + bet );
				}
			}
			else if ( betterAce ==true || betterDragons==true )
			{
				betterWinNum = 1;
				System.out.println( betterWinNum );
				if ( betterAce==true )
				{
					_betterDisplay.setText( "Better: Better wins on an Ace Negative. Better wins " + bet );
				}
				else if ( betterDragons==true )
				{
					_betterDisplay.setText( "Better: Better wins on a Dancing Dragon. Better wins " + bet );
				}
			}
			else if ( betterPair!=6 && betterPair!=1 && betterPair!=0 )
			{
				betterWinNum = 2;
				System.out.println( betterWinNum );
			}
			else
				_betterDisplay.setText( "Better: Better Reroll" );
		}
		
		if ( bankerWinNum==1 )
		{
			System.out.println( "Banker Wins 1 banker" );
			bankerWin = true;
			betterWin = false;
		}
		else if ( betterWinNum==1 )
		{
			System.out.println( "Better Wins 1 better" );
			bankerWin = false;
			betterWin = true;
			
		}
		else if ( bankerWinNum==0 )
		{
			System.out.println( "Better Wins 0 banker" );
			bankerWin = false;
			betterWin = true;
		}
		else if ( betterWinNum==0 )
		{
			System.out.println( "Banker Wins 0 better" );
			bankerWin = true;
			betterWin = false;
		}
		else if ( bankerWinNum==2 && betterWinNum==2 )
		{
			if ( bankerPair>betterPair )
			{
				System.out.println( "Banker Wins 2" );
				bankerWin = true;
				betterWin = false;
				_betterDisplay.setText( "Better: Better looses with Pair Point-" + betterPair + ". Better looses " + bet );
			}
			if ( betterPair>bankerPair )
			{
				System.out.println( "Better Wins 2" );
				bankerWin = false;
				betterWin = true;
				_betterDisplay.setText( "Better: Better wins with Pair Point-" + betterPair + ". Better wins " + bet );
			}
			if ( bankerPair==betterPair )
			{
				System.out.println( "Tie" );
				bankerWin = true;
				betterWin = true;
				_betterDisplay.setText( "Better: The game is a tie. Restart game." );
			}
		}
		
		setWin();
		System.out.println("/////////");
	}
	
	/**
	* 
	* Gets the numbers of the dice rolled for each button and sets if the button is a banker or better button.
	* @param x int the value of one of the dice
	* @param y int the value of one of the dice
	* @param z int the value of one of the dice
	* @param q boolean if it is a banker button or not
	* 
	*/
	
	public static void getNumbers( int x, int y, int z, boolean q )
	{
		boolean temp = q;
		if ( temp==true )
		{
			bankerA = x;
			bankerB = y;
			bankerC = z;
			banker = true;
			better = false;
			_bankerButton.setActive( true );
			_betterButton.setActive( false );
			System.out.println( "banker set" );
			bet = Slider.getBet();
		}
		else if ( temp==false )
		{
			betterA = x;
			betterB = y;
			betterC = z;
			better = true;
			banker = false;
			_bankerButton.setActive( false);
			_betterButton.setActive( true );
			System.out.println( "better set" );
		}
		
		checkWin();
	}
	
	/**
	*
	* Sets who has won and resets the conditions of each player.
	* 
	*/
	
	public static void setWin()
	{
		if ( bankerWin==true && betterWin==false )
		{
			_bankerButton.setDiceColor( Color.green );
			_betterButton.setDiceColor( Color.red );
			bet = Slider.getBet();
			Slider.setMaxValue( 0, bet );
			int tempMax = Slider.getMaxValue();
			if ( tempMax==0 )
			{
				_betterDisplay.setText( "Better: You are out of money. Please exit the game." );
				_betterButton.setActive( false );
			}
			else
			{
			Slider.setActive( true );
			_bankerButton.setActive( true );
			_betterButton.setActive( false );
			bankerWin = false;
			betterWin = false;
			
			bankerWinNum = 3;
			betterWinNum = 3;
			
			bankerThree = false;
			bankerPair = 0;
			bankerAce = false;
			bankerFlowers = false;
			bankerDragons = false;
			
			betterThree = false;
			betterPair = 0;
			betterAce = false;
			betterFlowers = false;
			betterDragons = false;
			System.out.println("1" + bankerWin );
			System.out.println( "1" + bankerWinNum );
			}
		}
		else if ( bankerWin==false && betterWin==true )
		{
			_bankerButton.setDiceColor( Color.red );
			_betterButton.setDiceColor( Color.green );
			bet = Slider.getBet();
			Slider.setMaxValue( 1, bet );
			Slider.setActive( true );
			_bankerButton.setActive( true );
			_betterButton.setActive( false );
			
			bankerWin = false;
			betterWin = false;
			
			bankerWinNum = 3;
			betterWinNum = 3;
			
			bankerThree = false;
			bankerPair = 0;
			bankerAce = false;
			bankerFlowers = false;
			bankerDragons = false;
			
			betterThree = false;
			betterPair = 0;
			betterAce = false;
			betterFlowers = false;
			betterDragons = false;
			
			System.out.println( "2"+bankerWin );
			System.out.println( "2" + bankerWinNum );
		}
		else if ( bankerWin==true && betterWin==true )
		{
			_bankerButton.setDiceColor( Color.yellow );
			_betterButton.setDiceColor( Color.yellow );
			bet = Slider.getBet();
			Slider.setMaxValue( 2, bet );
			Slider.setActive( true );
			_bankerButton.setActive( true );
			_betterButton.setActive( false );
			
			bankerWin = false;
			betterWin = false;
			
			bankerWinNum = 3;
			betterWinNum = 3;
			
			bankerThree = false;
			bankerPair = 0;
			bankerAce = false;
			bankerFlowers = false;
			bankerDragons = false;
			
			betterThree = false;
			betterPair = 0;
			betterAce = false;
			betterFlowers = false;
			betterDragons = false;
			System.out.println( "3"+bankerWin );
			System.out.println( "3" + bankerWinNum );
		}
	}
	
	/**
	*
	* Checks to see if the dice rooled equal three of a kind.
	* 
	*/
	
	public static boolean threeKind( int x, int y, int z )
	{
		if ( x==y && x==z && y==z )
			return true;
		else
			return false;
	}
	
	/**
	*
	* Checks to see if the dice rolled equal a pair point and sets the returns the pair point number.
	*
	*/
	
	public static int pairPoint( int x, int y, int z )
	{
		int temp = 0;
		
		
		if ( x==y && z!= x )
			temp = z;
		else if ( x==z && y!=x )
			temp = y;
		else if ( z==y && x!=y )
			temp = x;
		else
			temp = 0;
		
		return temp;
	}
	
	/**
	*
	* Checks to see if the dice rolled equal a strung flowers.
	*
	*/
	
	public static boolean strungFlowers( int x, int y, int z )
	{
		if ( x==4 && y==5 && z==6 )
			return true;
		else if ( x==4 && y==6 && z==5 )
			return true;
		else if ( x==5 && y==4 && z==6)
			return true;
		else if ( x==5 && y==6 && z==4 )
			return true;
		else if ( x==6 && y==4 && z==5 )
			return true;
		else if ( x==6 && y==5 && z==4 )
			return true;
		else
			return false;
	}
	
	/**
	*
	* Checks to see if the dice rolled equal dancing dragon.
	*
	*/
	
	public static boolean dancingDragon( int x, int y, int z )
	{
		if ( x==1 && y==2 && z==3 )
			return true;
		else if ( x==1 && y==3 && z==2 )
			return true;
		else if ( x==2 && y==1 && z==3)
			return true;
		else if ( x==2 && y==3 && z==1 )
			return true;
		else if ( x==3 && y==1 && z==2 )
			return true;
		else if ( x==3 && y==2 && z==1 )
			return true;
		else
			return false;
	}
	
	/**
	* 
	* Checks to see if the dice rolled equal an ace negative.
	*
	*/
	
	public static boolean aceNegative( int x, int y, int z )
	{
		if ( x==y && z==1 )
			return true;
		if ( x==z && y==1 )
			return true;
		if ( y==z && x==1 )
			return true;
		else
			return false;
	}
	
	/**
	*
	* The main method of the program.
	* @param args String[]
	*
	*/
	
	public static void main( String[] args )
	{
		Frame f = new Frame();
		ThreeDiceApp d = new ThreeDiceApp();
	}
}