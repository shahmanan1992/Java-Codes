class Cashier extends Receipt
{

	/**
	 * Calculating the cost of each particular item
	 * 
	 * @return    ordercost  calculating overall cost
	 * @param     price      setting the default price of items
	 */
	public double[] getTotalCost(int order[],double price[])
	{
		double ordercost[]= new double[5];
		ordercost[0]=order[0]*price[0];
		ordercost[1]=order[1]*price[1];
		ordercost[2]=order[2]*price[2];
		ordercost[3]=order[3]*price[3];
		ordercost[4]=order[4]*price[4];

		return ordercost;
	}
	
	/**
	 * Printing the receipt of shopping '
	 * @param    ordercost    total cost of each items bought
	 * @param    name         getting name of that item
	 * @param    price        getting the rice of that item
	 */
	public void printReciept(double ordercost[],String name[],double price[])
	{
		double sum=0.0;
		for(int i=0;i<ordercost.length;i++)
		{
			sum=sum+ordercost[i];
			if(ordercost[i]!=0)
			{
				System.out.println(name[i]+": "+(int)(ordercost[i]/price[i])+" ("+price[i]+")");
			}
		}
		System.out.println("--------------------");
		System.out.println(" Cost      "+ sum);

	}
	
}
