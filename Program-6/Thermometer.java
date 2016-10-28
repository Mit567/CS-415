import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;

/** 
 *
 * This class will make a thermometer and manipulate it.
 * 
 * @author Jack Hamilton
 * Assignment number: 6P
 * 
 */
 
 public class Thermometer extends ShapeGroup implements TemperatureSensitive
 {
	 protected Ellipse _base, _mercuryBase;
	 protected Rectangle _tube, _mercury;
	 protected int x1, y1;
	 protected Point lastMousePosition;
	 
	 public Thermometer( int x, int y )
	 {
		 x1 = x;
		 y1 = y;
		 
		 _tube = new Rectangle();
		 _tube.setSize( 20, 60 );
		 _tube.setLocation( x + 10, y + 5 );
		 _tube.setFillColor( Color.white );
		 _tube.setFrameColor( Color.black );
		 add(_tube);
		 
		 _base = new Ellipse();
		 _base.setSize( 40, 40 );
		 _base.setLocation( x , y + 60 );
		 _base.setFillColor( Color.white );
		 _base.setFrameColor( Color.black );
		 add(_base);
		 
		 _mercuryBase = new Ellipse();
		 _mercuryBase.setSize( 30, 30 );
		 _mercuryBase.setLocation( x + 5, y + 65 );
		 add(_mercuryBase);
		 
		 _mercury = new Rectangle();
		 add(_mercury);
		 _mercury.hide();
	 }
	 
	 public void warm()
	 {
		 _mercury.show();
		 _mercury.setSize( 10, 60 );
		 _mercury.setLocation( x1 + 15, y1 + 10 );
		 add(_mercury);
	 }
	 
	 public void cold()
	 {
		 _mercury.show();
		 _mercury.setSize( 10, 20 );
		 _mercury.setLocation( x1 + 15, y1 + 50 );
		 add(_mercury);
	 }
	 
	 public void mousePressed ( java.awt.event.MouseEvent e )
    {
		lastMousePosition = e.getPoint();
        x1 = getXLocation();
        y1 = getYLocation();
    }
	
    public void mouseDragged( java.awt.event.MouseEvent e )
    {
        Point currentPoint = e.getPoint();
        int diffx = currentPoint.x - lastMousePosition.x;
        int diffy = currentPoint.y - lastMousePosition.y;
        setLocation( getLocation().x + diffx, getLocation().y + diffy);
        lastMousePosition = currentPoint;
    }
	
	public void mouseReleased( java.awt.event.MouseEvent e )
	{
		x1 = getXLocation();
		y1 = getYLocation();
	}
	 
	 public static void main( String[] args )
	 {
		 Frame f = new Frame();
		 Thermometer t1 = new Thermometer( 100, 100 );
		 
		 Utilities.sleep( 1000 );
		 t1.warm();
		 
		 Utilities.sleep( 1000 );
		 t1.cold();
		 
	 }
 }