abstract class Receipt extends Item
{
	/**
	 * Printing the receipt of shopping '
	 * @param    ordercost    total cost of each items bought
	 * @param    name         getting name of that item
	 * @param    price        getting the rice of that item
	 */
	public abstract void printReciept(double ordercost[],String name[],double price[]);
}
