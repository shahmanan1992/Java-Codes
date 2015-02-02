/**
 * This class implements a Circle class.
 *
 * @version   $Id$
 *s
 * @author    hp bischof
 *
 * Revisions:
 *	$Log$
 */

public class Circle extends TwoDThings {

  private int radius;	

/**
 * Constructor.
 * initialize length and width values of a Circle
 *
 * @param       _radius		int _radius of the circle
 *
 * @return	Circle 		a Circle object
 */
  public Circle(int _radius)	{
	super("Circle");
	radius = _radius;
  }


/**
 * Calculates the area of an square.
 *
 * @return	area 	int area of the square
 */
  public int area()	{
	return (int)(Math.PI * radius * radius);
  }

}