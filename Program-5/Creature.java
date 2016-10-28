  import wheelsunh.users.*;
  import java.awt.Color;

  /** 
   *
   * This class will make a creature and manipulate it.
   * 
   * @author Jack Hamilton
   * Assignment number: 4P
   * 
   */

public class Creature extends ShapeGroup
{
    //-----instance variables-----
    protected Ellipse _body, _eyet, _eyeb, _cameralens;
    protected Line _leg1, _leg2, _leg3, _leg4, _leg5, _leg6, _leg7;
    protected Line _leg8, _cameraarm1, _cameraarm2;
    protected Rectangle _clawt1, _clawt2, _clawb1, _clawb2, _foott;
    protected Rectangle _footb, _armt, _armb, _sensort, _sensorb, _camerabody;
    protected Rectangle _camerabase;
	protected int x1, y1;
	protected Color bodyColor, savedColor;
  
    /**
     * 
     * These are the contructors that call the makeCreature method.
     * 
     */
    
    public Creature ( int x, int y )
    {
		makeCreature( x, y );
		setColor( Color.red );
		
    }
	
	public Creature ( Color body )
	{
		makeCreature( 0 , 0 );
		setColor( body );
	}
  
  /**
   * Create the creature.
   * 
   * @param x1  int the x coordinate of the creature.
   * @param y1  int the y coordinate of the creature.
   * @param body  color the color of the creature's body.
   */
  
    public void makeCreature ( int x, int y)
    {
        _body = new Ellipse();
        _body.setSize( 30, 30 );
		add(_body);
    
        //topside legs
        _leg1 = new Line();
        _leg1.setSize( 20, 1 );
        _leg1.setRotation( 100 );
		add(_leg1);
        _leg2 = new Line();
        _leg2.setSize( 20, 1 );
        _leg2.setRotation( 90 );
		add(_leg2);
        _leg3 = new Line();
        _leg3.setSize( 20, 1 );
        _leg3.setRotation( 80 );
		add(_leg3);
        _leg4 = new Line();
        _leg4.setSize( 15, 1 );
        _leg4.setRotation( 45 );
        _leg4.setThickness( 2 );
		add(_leg4);
        _foott = new Rectangle();
        _foott.setSize( 5, 5 );
		add(_foott);
    
        //bottomside legs
        _leg5 = new Line();
        _leg5.setSize( 20, 1 );
        _leg5.setRotation( 80 );
		add(_leg5);
        _leg6 = new Line ();
        _leg6.setSize( 20, 1 );
        _leg6.setRotation( 90 );
		add(_leg6);
        _leg7 = new Line ();
        _leg7.setSize( 20, 1 );
        _leg7.setRotation( 100 );
		add(_leg7);
        _leg8 = new Line();
        _leg8.setSize( 15, 1 );
        _leg8.setRotation( 135 );
        _leg8.setThickness( 2 );
		add(_leg8);
        _footb = new Rectangle();
        _footb.setSize( 5, 5 );
		add(_footb);
    
        //top claw
        _armt = new Rectangle();
        _armt.setSize( 25, 4 );
        _armt.setRotation( 130 );
		add(_armt);
        _clawt1 = new Rectangle();
        _clawt1.setSize( 10, 3 );
		add(_clawt1);
        _clawt2 = new Rectangle();
        _clawt2.setSize( 6, 2 );
		add(_clawt2);
        
        //bottom claw
        _armb = new Rectangle();
        _armb.setSize( 25, 4 );
        _armb.setRotation( 50 );
		add(_armb);
        _clawb1 = new Rectangle ();
        _clawb1.setSize( 10, 3 );
		add(_clawb1);
        _clawb2 = new Rectangle ();
        _clawb2.setSize( 6, 2 );
		add(_clawb2);
        
        //eyes
        _eyet = new Ellipse ();
        _eyet.setSize( 3, 5 );
		_eyet.setColor( Color.BLACK );
		add(_eyet);
        _eyeb = new Ellipse ();
        _eyeb.setColor( Color.BLACK );
        _eyeb.setSize( 3, 5 );
		add(_eyeb);
        
        //sensors
        _sensort = new Rectangle();
        _sensort.setColor( Color.BLUE );
        _sensort.setSize( 3, 3 );
        _sensort.setRotation( 130 );
		add(_sensort);
        _sensorb = new Rectangle();
        _sensorb.setColor ( Color.BLUE );
        _sensorb.setSize( 3, 3 );
        _sensorb.setRotation( 50 );
		add(_sensorb);
        
        //camera arm
        _camerabase = new Rectangle ();
        _camerabase.setColor ( Color.BLACK );
        _camerabase.setSize ( 5, 5 );
		add(_camerabase);
        _cameraarm1 = new Line();
        _cameraarm1.setColor( Color.BLACK );
        _cameraarm1.setSize( 40, 1 );
		add(_cameraarm1);
        _cameraarm2 = new Line ();
        _cameraarm2.setColor( Color.BLACK );
        _cameraarm2.setSize( 35, 1 );
        _cameraarm2.setRotation( 90 );
		add(_cameraarm2);
        _camerabody = new Rectangle ();
        _camerabody.setFillColor( Color.GREEN );
        _camerabody.setFrameColor( Color.BLACK );
        _camerabody.setSize( 10, 10 );
		add(_camerabody);
        _cameralens = new Ellipse ();
        _cameralens.setFillColor( Color.GREEN );
        _cameralens.setFrameColor( Color.BLACK );
        _cameralens.setSize( 15, 5 );
		add(_cameralens);
		
		_body.setLocation( x + 50, y + 42);
		
		_leg1.setLocation( x + 60, y + 42 );
		_leg2.setLocation( x + 55, y + 42 );
		_leg3.setLocation( x + 50, y + 42 );
		_leg4.setLocation( x + 45, y + 50 );
		_foott.setLocation( x + 42, y + 43 );
		
		_leg5.setLocation( x + 60, y + 72 );
		_leg6.setLocation( x + 55, y + 72 );
		_leg7.setLocation( x + 50, y + 72 );
		_leg8.setLocation( x + 45, y + 64 );
		_footb.setLocation( x + 42, y + 65 );
		
		_armt.setLocation( x + 65 , y + 42 );
		_clawt1.setLocation( x + 84, y + 31 );
		_clawt2.setLocation( x + 84, y + 37 );
		
		_armb.setLocation( x + 65, y + 72 );
		_clawb1.setLocation( x + 84, y + 83 );
		_clawb2.setLocation( x + 84, y + 77 );
		
		_eyet.setLocation( x + 79, y + 50 );
		_eyeb.setLocation( x + 79, y + 60 );
		
		_sensort.setLocation( x + 78, y + 35 );
		_sensorb.setLocation( x + 78, y + 79 );
		
		_camerabase.setLocation ( x + 60, y + 55 );
		_cameraarm1.setLocation( x + 20, y + 57 );
		_cameraarm2.setLocation( x + 03, y + 40 );
		_camerabody.setLocation ( x + 20, y + 15 );
		_cameralens.setLocation( x + 30, y + 18 );
		
    }
	
	public void setColor (Color body)
	{
		bodyColor = body;
		
		_body.setColor( body );
		
		_leg1.setColor( body );
		_leg2.setColor( body );
		_leg3.setColor( body );
		_leg4.setColor( body );
		_foott.setColor( body );
		
		_leg5.setColor( body );
		_leg6.setColor( body );
		_leg7.setColor( body );
		_leg8.setColor( body );
		_footb.setColor( body );
		
		_armt.setColor( body );
		_clawt1.setColor( body );
		_clawt2.setColor( body );
		
		_armb.setColor( body );
		_clawb1.setColor( body );
		_clawb2.setColor( body );
		
		
	}
	
	public Color getColor()
	{
		return bodyColor;
	}
    
	public void mousePressed ( java.awt.event.MouseEvent e )
	{
		savedColor = getColor();
		setColor( Color.pink );
	}
	
	public void mouseReleased ( java.awt.event.MouseEvent e )
	{
		setColor( savedColor );
	}
	
	public void active()
	{
		
	}
	
	public void deactive()
	{
		
	}
    /**
     * 
     * This is the main method that invokes the constructor.
     * 
     */
    
    public static void main( String[] args )
    {
        new Frame();
		
		Creature c1 = new Creature( 100, 150 );
		Creature c2 = new Creature ( Color.cyan );
		
		//c1.setLocation( 200, 300 );
		
    }
}