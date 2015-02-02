/**
 * Generic two-d class.
 * @version   $Id$
 *
 * @author    hp bischof
 *
 * Revisions:
 *	$Log$
 */

public class TwoDThings {

  private String type;		// type of the 2-d object
  public  int    nObjects;

/**
 * Default Constructor.
 *
 * @return	      TwoDThings a TwoDThings object
 */
  public TwoDThings(){
	nObjects++;
  }

/**
 * Constructor.
 * initialize the type of the object
 *
 * @param       type		the type of the object
 *
 * @return	TwoDThings  	a TwoDThings object
 */
  public TwoDThings(String _type) { 
	//this();
	type = _type;
  }

  public TwoDThings setType(String _type)	{
	type = _type;
	return this;
  }

  public String getType()	{
	return type;
  }

}
