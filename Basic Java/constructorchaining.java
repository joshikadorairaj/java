
//thiscall

public class constructorchaining {

    constructorchaining()
    {
        this(20);
        System.out.println("default is running..");
    }

    constructorchaining(int a)
    {
        this("");
        System.out.println("Integer is running..");
    }

    constructorchaining(int a, int b)
    {
        
        System.out.println("Two Parameter is running..");
    }

    constructorchaining(String a)
    {
        this(10,20);
        System.out.println("String is running..");
    }
    public static void main(String[] args) {
        constructorchaining a=new constructorchaining();
        
    }
}
