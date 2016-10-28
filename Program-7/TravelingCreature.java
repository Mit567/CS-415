import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/** 
 *
 * This class will make a travelingcreature.
 * 
 * @author Jack Hamilton
 * Assignment number: 7P
 * 
 */
 
 public class TravelingCreature extends Creature
 {
	protected Crosshairs _crosshairs;
	private Point lastMousePosition, original, startFollow, center;
	private Color savedColor;
	private Color randomColor;
	private Random r;
	private Line straight;
	protected int leg, xstart, ystart, xcurrent, ycurrent;
	protected double distanceStart, legLength, xcenter, ycenter, currentLength, previousLength, legTotal, previousTotal, averageLeg;
	protected TextBox display;
	
	public TravelingCreature ( int x, int y, Color color )
	{
		super( x, y, color );
		_crosshairs = new Crosshairs( x + 50, y + 10);
		add( _crosshairs );
		straight = new Line();
		straight.setColor ( Color.black );
		add( straight );
		straight.hide();
		leg = 1;
		center = _crosshairs.getPoint();
		
		display();
	}
	
	public void mousePressed ( java.awt.event.MouseEvent e )
    {
		savedColor = getColor();
		lastMousePosition = e.getPoint();
		original = _crosshairs.getPoint();		
    }
	
    public void mouseDragged( java.awt.event.MouseEvent e)
    {
        Point currentPoint = e.getPoint();
        int diffx = currentPoint.x - lastMousePosition.x;
        int diffy = currentPoint.y - lastMousePosition.y;
        setLocation( getLocation().x + diffx, getLocation().y + diffy);
        lastMousePosition = currentPoint;
		
		straight.show();
		straight.setPoints( original, _crosshairs.getPoint() );
		
		startFollow = _crosshairs.getPoint();
		Line follow = new Line();
		follow.setColor( super.getColor() );
		follow.setPoints( startFollow , center );
		Double xld = Math.pow( ( startFollow.x - center.x ), 2 );
		Double yld = Math.pow( ( startFollow.y - center.y ), 2 );
		legLength = Math.sqrt( ( xld + yld ) );
		center = startFollow;
		
		xcurrent = _crosshairs.getXLocation();
		ycurrent = _crosshairs.getYLocation();
		Double xd = Math.pow( (xcurrent - xstart), 2 );
		Double yd = Math.pow( (ycurrent - ystart), 2 );
		distanceStart = Math.sqrt( (xd + yd ) );
		currentLength = previousLength + legLength;
		previousLength = legLength + currentLength;
		legTotal = currentLength + previousTotal;
		averageLeg = legTotal/leg;
		display.setText( "Current Leg Start: \t" + xcurrent + ", " + ycurrent + "\nCurrent Leg End: \t" + xcurrent + ", " + ycurrent +  "\nDistance to Start: \t" + distanceStart + "\nLenght of Current Leg: \t" + currentLength + "\nNumber of Legs: \t" + leg + "\nTotal Length of All Legs: \t" + legTotal + "\nAverage Leg Length: \t" + averageLeg );
    } 
	
	public void mouseReleased ( java.awt.event.MouseEvent e )
    {
		
    }
	
	public void mouseClicked( java.awt.event.MouseEvent e )
	{
		r = new Random();
		int red = r.nextInt( 255 );
		int blue = r.nextInt( 255 );
		int green = r.nextInt( 255 );
		randomColor = new Color( red, green, blue );
		setColor( randomColor);
		original = _crosshairs.getPoint();
		leg++;
		center = _crosshairs.getPoint();
		xstart = _crosshairs.getXLocation();
		ystart = _crosshairs.getYLocation();
		legTotal = currentLength + previousTotal;
		previousTotal = legTotal;
		previousLength = 0.0;
		currentLength = 0.0;
		averageLeg = legTotal/leg;
		display.setText( "Current Leg Start: \t" + xcurrent + ", " + ycurrent + "\nCurrent Leg End: \t" + xcurrent + ", " + ycurrent +  "\nDistance to Start: \t" + distanceStart + "\nLenght of Current Leg: \t" + currentLength + "\nNumber of Legs: \t" + leg + "\nTotal Length of All Legs: \t" + legTotal + "\nAverage Leg Length: \t" + averageLeg );
	}
	
	public void display()
	{
		display = new TextBox( 0, 0 );
		display.setSize( 325, 100 );
		xcurrent = _crosshairs.getXLocation();
		ycurrent = _crosshairs.getYLocation();
		xstart = _crosshairs.getXLocation();
		ystart = _crosshairs.getYLocation();
		Double xd = Math.pow( (xcurrent - xstart), 2 );
		Double yd = Math.pow( (ycurrent - ystart), 2 );
		distanceStart = Math.sqrt( (xd + yd ) );
		previousLength = 0.0;
		currentLength = 0.0;
		legTotal = 0.0;
		previousTotal = 0.0;
		averageLeg = 0.0;
		display.setText( "Current Leg Start: \t" + xcurrent + ", " + ycurrent + "\nCurrent Leg End: \t" + xcurrent + ", " + ycurrent +  "\nDistance to Start: \t" + distanceStart + "\nLenght of Current Leg: \t" + currentLength + "\nNumber of Legs: \t" + leg + "\nTotal Length of All Legs: \t" + legTotal + "\nAverage Leg Length: \t" + averageLeg );
	}

	public static void main( String[] args )
	 {
		 Frame f = new Frame();
		 TravelingCreature c1 = new TravelingCreature( 100 , 150 , Color.red );
		 
	 }
 }