
interface Animal
{
    void run();

    void walk();

    default void jumps()
    {
        System.out.println("Animal jumps");
    }

    static void eats()
    {
        System.out.println("Animal eats");
    }
}


class Dog implements Animal
{
    public void run()
    {
        System.out.println("Dog runs...");
    }

    public void walk()
    {
        System.out.println("Dog walks...");
    }

    public void barks()
    {
        System.out.println("Dog barks...");
    }
}

class Interface1{
    public static void main(String[] args)
    {
        Dog d=new Dog();
        d.run();
        d.barks();

        Animal a=new Dog();
        a.run();
        a.walk();
        a.jumps();
        Animal.eats();
        //method created using static in interface can be accessed only with class name
        // a.barks();
    }
}