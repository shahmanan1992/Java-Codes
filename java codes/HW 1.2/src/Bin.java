
public class Bin {
public static void main(String args[])
{
	int r;
	String s="";
	int i,j;
	char b[]={'a','b','c'};
	int n=b.length;
	double count=Math.pow(2,n);
	for(i=1;i<=3;i++)
	{
		r=n%2;
		s=r+s;
		n=n/2;
	}
	
	System.out.println(s);
	
}
}
/*sb=new StringBuilder("{}");
String output = "{}";
double count=Math.pow(2,n);	

for(int i=0;i<n;i++)
{
	output+="{"+s[i]+"}";
	
	for(int j=i+1;j<n;j++)
	{
		if(s[i]==s[j])
			continue;
		else
		output+="{"+s[i]+s[j]+"}";
		
		for(int k=j+1;k<n;k++)
		{
			output+="{"+s[i]+s[j]+s[k]+"}";
		}
	}
}
System.out.println(output);
*/
