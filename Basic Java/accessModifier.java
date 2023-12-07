public class accessModifier {

    public int m1()
    {
        System.out.println("public is running");
        return 0;
    }
    //public can be accessed within every package, class and method.

    private int m2()
    {
        System.out.println("private is running");
        return 0;

    }
    /*private can be accessed only within the specific class, access outside 
    class using getter setter method */

    // default int m3()
    // {
    //     System.out.println("default is running");
    // }
    /*default can be accessed within and outside class and same package, used only in interfaces*/

        
    //protected can be accessed within class,outside class, same package, different package subclass.
    public static void main(String[] args) {
        accessModifier obj=new accessModifier();
        obj.m1();
        obj.m2();
        // obj.m3();
    }

}
