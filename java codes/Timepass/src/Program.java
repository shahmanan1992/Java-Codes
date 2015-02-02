class Program
{
    static void Main(String[] args)
    {
        Person person = new Teacher();
        person.ShowInfo();
       // Console.ReadLine();
    }
}

class Person
{
    public void ShowInfo()
    {
       System.out.println("I am Person");
    }
}
class Teacher extends Person
{
    public void ShowInfo()
    {
        System.out.println("I am Teacher");
    }
}