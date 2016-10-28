import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;

/** 
 *
 * This class will make a crosshiar.
 * 
 * @author Jack Hamilton
 * Assignment number: 7P
 * 
 */
 
 public class Crosshairs extends ShapeGroup
 {
	 protected Ellipse _edges;
	 protected Line _xaxis, _yaxis;
	 protected Color myColor;
	 
	 public Crosshairs( int x, int y )
	 {
		makeCrosshairs( x, y );
	 }
	 
	 public void makeCrosshairs ( int x, int y )
	 {
		 myColor = new Color( 0, 0, 0, 0);
		 
		 _edges = new Ellipse( x, y );
		 _edges.setFillColor( myColor );
		 _edges.setFrameColor( Color.black );
		 _edges.setSize( 20, 20 );
		 add(_edges);
		 
		 _xaxis = new Line();
		 _xaxis.setLocation( x , y + 10 );
		 _xaxis.setColor( Color.black );
		 _xaxis.setSize( 20, 1 );
		 add(_xaxis);
		 
		 _yaxis = new Line();
		 _yaxis.setLocation( x + 1 , y + 10 );
		 _yaxis.setColor( Color.black );
		 _yaxis.setSize( 20, 1 );
		 _yaxis.setRotation( 90 );
		 add(_yaxis);
	 }
	 
	 public Point getPoint()
	 {
		Point center = _edges.getCenter();
		return center;
	 }
	 
	 public static void main( String[] args )
	 {
		 Frame f = new Frame();
		 Crosshairs c1 = new Crosshairs( 0, 0 );
		 System.out.println(c1.getCenter());
		 
	 }
 }