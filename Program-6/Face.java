import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;

/** 
 *
 * This class will make a face and manipulate it.
 * 
 * @author Jack Hamilton
 * Assignment number: 6P
 * 
 */
 
public class Face extends ShapeGroup implements TemperatureSensitive
{
	protected Ellipse _face;
	protected Line _eye1, _eye2;
	protected Rectangle _mouth;
	protected Point lastMousePosition;
	protected int x1, y1;
	
	public Face ( int x, int y )
	{
		_face = new Ellipse();
		_face.setSize( 60, 60 );
		_face.setLocation( x, y );
		add(_face);
		
		_eye1 = new Line();
		_eye1.setThickness( 5 );
		_eye1.setLocation ( x + 15, y + 17 );
		_eye1.setSize( 10, 40 );
		_eye1.setRotation( 90 );
		_eye1.setColor( Color.black );
		add(_eye1);
		
		_eye2 = new Line();
		_eye2.setThickness( 5 );
		_eye2.setLocation ( x + 37, y + 17 );
		_eye2.setSize( 10, 40 );
		_eye2.setRotation( 90 );
		_eye2.setColor( Color.black );
		add(_eye2);
		
		_mouth = new Rectangle();
		_mouth.setSize( 40, 5 );
		_mouth.setLocation( x + 10, y + 40 );
		_mouth.setColor( Color.black );
		add(_mouth);
	}
	
	public void warm()
	{
		_face.setColor( Color.red );
	}
	
	public void cold()
	{
		_face.setColor( Color.blue );
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
	
	public static void main( String[] args )
	{
		Frame f1 = new Frame();
		Face s1 = new Face( 100, 100 );
		
		Utilities.sleep( 1000 );
		s1.warm();
		 
		Utilities.sleep( 1000 );
		s1.cold();
	}
} 