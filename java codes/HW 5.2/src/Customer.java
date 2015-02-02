class Customer extends Cart {
	//Quantities of different items are stored in this array
		private int order[]=new int[5];
		private int noOfItems;

	/**
	 *
	 * @return    order    getting the order
	 */
	public int[] getOrder() {
		return order;
	}

	/**
	 *
	 * @param    order    setting the order
	 */
	public void setOrder(int[] order) {
		this.order = order;
	}
	
	/**
	 * This function adds items to the cart
	 * 
	 * @param    quantity    calculating total items
	 * @param      n         the item number selected
	 * @param      i         the quantity of particular item
	 */
	
	/**
	 *
	 * @return    noOfItems    total items in cart
	 */
	public int getNoOfItems() {
		return noOfItems;
	}
	
	public void addToCart(int quantity[],int n,int i)
	{
			noOfItems+=i;
			if(noOfItems > 100)
			{
				System.out.println("More than 100 items cannot be added..Enter a lesser quantity");
				noOfItems-=i;
			}
			else
			{
				quantity[n]+=i;
			}
	}
}


