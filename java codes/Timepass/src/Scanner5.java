import java.util.Scanner;
 
/*
 * This is an example source code that prints the delimiter
 * and print the string tokens
 */
 
public class Scanner5 {
 
    public static void main(String[] args) {
 
        // Initialize Scanner object
  //  	File file = new File("E:/tmp/java/tutorial/scanner/example.txt");
        Scanner scan = new Scanner("This-a-sample-string-manan:shah");
        scan.useDelimiter("-|:");
        // Printing the delimiter used
        System.out.println("Delimiter: "+scan.delimiter());
        // Printing the tokenized Strings
        while(scan.hasNextLine()){
            System.out.println(scan.next());
        }
        // closing the scanner stream
        scan.close();
 
    }
 
}