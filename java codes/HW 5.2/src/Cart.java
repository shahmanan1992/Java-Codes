abstract class Cart extends Bag
{

	private int noOfBags;

	/**
	 *
	 * @return    noOfItems    total items in cart
	 */
	abstract public int getNoOfItems();

	/**
	 * This function adds items to the cart
	 * 
	 * @param    quantity    calculating total items
	 * @param      n         the item number selected
	 * @param      i         the quantity of particular item
	 */
	abstract public void addToCart(int quantity[],int n,int i);
	
	/**
	 * Calculating the total bags used
	 * 
	 * @param    item    getting the name
	 * @param    quant   adding quantity to bag
	 */
	public void addToBag(String item,int quant,int quantity[])
	{
			noOfBags++;
		System.out.println(quantity[quant]+" "+item+" added to bag");
	}

}
