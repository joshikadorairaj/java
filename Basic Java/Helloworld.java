/**
 * Helloworld
 */
public class Helloworld {
    static {
        System.out.println("static block");
    }
    {
        System.out.println("non static block");
    }
    public Helloworld()
    {
        System.out.println("constructor call");

    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Helloworld obj=new Helloworld();
    }
}