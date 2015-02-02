import java.util.*;

public class TestTreeSet {
	public static void main(String[] args) {
		
		
		TreeSet<String> dset = new TreeSet<String>();
		dset.add("manan");
		dset.add("1");
		dset.add("7");

		Iterator<String> iterator = dset.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}