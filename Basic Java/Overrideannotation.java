//override
//To inform compiler that superclass is overrided, when superclass method is removed or changed, 
//compiler will show error message
class parent{

    public void Run(){
        System.out.println("Parent class");
    }
}

class Child extends parent{
    @Override
     public void Run(){
        System.out.println("Child class");
     }
}

public class Overrideannotation{
    public static void main(String[] args) {
        Child c=new Child();
        c.Run();
    }
}



//suppress warnings
 //to instruct the compiler to suppress specific warnings that it might otherwise generate.
 // a particular warning is not necessary or when you are intentionally doing something that would trigger a warning. 

 


// public class exercise {
//     public static void main(String[] args) {
//         int x=10;
//         int y=x;
//         System.out.println(x==y);
//     }
// }


//primitive=>compare only values
//Nonprimitive=>compare address


// public class exercise{

//     String Id;
//     String Name;

//     objectcomp(String Id, String Name)
//     {
//         this.Id=Id;
//         this.Name=Name;
//     }

    
//     public static void main(String[] args) {
        
//     }
// }