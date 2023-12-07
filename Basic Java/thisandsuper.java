public class thisandsuper {

    static int a=10;
    int b=20;

    void t1()
    {
        int var=this.a;
        System.out.println(var);
        System.out.println(this.b);
    }
    public static void main(String[] args) {
        thisandsuper d=new thisandsuper();
        superkey s=new superkey();
        s.t1();

    }
}
// //this keyword can be used only inside nonstatic method
class superkey extends thisandsuper
{
    void t1()
    {
        super.b=150;
        System.out.println(super.b);
        System.out.println(super.a);
        super.t1();
    }
}


// public class thisandsuper 
// {
//      thisandsuper()
//     {
//        System.out.println("parent is running......");
//     }
//     public static void main(String[] args) 
//     {
//         child c = new child();
//     }
// }

// class child extends thisandsuper
// {
//     child ()
//     {
//         super();
//         System.out.println("child is running.....");
//     }
// }
//when we are creating object for child, child constructor is called defaulty.