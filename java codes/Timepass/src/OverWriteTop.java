/**
 * This class shows how to override a method.
 * @version   $Id$
 *
 * @author    hp bischof
 *
 * Revisions:
 *	$Log$
 */

public class OverWriteTop {

  public static int var;		

  public void both(int x)	{
	var = x;
	System.out.println("	in OverWriteTop!both");
  }

  public void notBoth(int x)	{
	var = x;
	System.out.println("	in OverWriteTop!notBoth");
  }

}
