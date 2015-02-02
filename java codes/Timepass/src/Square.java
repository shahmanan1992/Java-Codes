/**
 * This class implements a Square class.
 *
 * @version   $Id$
 *
 * @author    hp bischof
 *
 * Revisions:
 *	$Log$
 */

public class Square extends TwoDThings {

  private int length;	

/**
 * Constructor.
 * initialize lenght and width values of a Square
 *
 * @param       _width		int _width of the square
 *
 * @return	Square 		a Square object
 */
  public Square(int _length)	{
	super("Square");
	length = _length;
  }


/**
 * Calculates the area of a square.
 *
 * @return	area 	int area of the square
 */
  public int area()	{
	return length * length;
  }

}