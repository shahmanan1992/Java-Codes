public class Combination
{
	public static void main(String args []) 
	{
		char b[]={'a','b','c','d','e','f'};
	int n=b.length;
	Combi(b,n);
	}
	public static void Combi(char b[],int n)
	{

		int i,j,m;
		int output=0;
		double count=Math.pow(2,n);
		for(i=0;i<count;i++) 
		{
			m=i;
			String s="";
			int r;
			for(j=1;j<=n;j++) //calculating binary for each number
			{
				r=m%2;
				s=r+s;
				m=m/2;
		
			}
			char a[]=s.toCharArray();
			System.out.print("{");
			for(int k=0;k<a.length;k++)
			{
					if(a[k]=='1')
					{
						System.out.print(b[k]);
					}			
			}
			System.out.print("}");
		}
	
		}// end of function Combi

}// end of class


