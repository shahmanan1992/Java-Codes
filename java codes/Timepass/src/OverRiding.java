public class OverRiding {

public static void main(String[] args) {
// TODO Auto-generated method stub

//Super class reference to sub class Object
  Dog dog = new Animal();
 dog.eat();
 dog.bow();

//Completely converted into pure Dog class Object
 Dog d = (Dog)dog;
 d.eat();
 d.bow();

          }

        }




 