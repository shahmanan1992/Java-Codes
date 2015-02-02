abstract class Item
{
	private String name[]=new String[5];
	private double price[]=new double[5];
	/**
	 * default constructor
	 * @param    name,price    setting their default values
	 */
	Item()
	{
		name[0]="Apples";
		name[1]="Flour";
		name[2]="Kiwis";
		name[3]="Oranges";
		name[4]="Milk";

		price[0]=0.5;
		price[1]=0.7;
		price[2]=0.7;
		price[3]=0.7;
		price[4]=0.33;
	}

	/**
	 *
	 * @return    price    getting the price
	 */
	public double[] getPrice()
	{
		return price;
	}

	/**
	 *
	 * @return    name    getting the name
	 */
	public String[] getName()
	{
		return name;
	}

}
