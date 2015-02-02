public class Str {

 private int convert(String s) {
 int result = 0;

 try {
 result = Integer.parseInt(s);
 } catch ( NumberFormatException e ) {
 System.out.println("Not good");
 return result;
 } finally {
 result = 75;
 System.out.println("Finally");
 }
 return result;
 }

 public static void main(String[] args) {
 System.out.println(new Str().convert("this is not a number"));
 }
 }