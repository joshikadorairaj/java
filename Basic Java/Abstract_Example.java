abstract class PetAnimal {
    abstract void walk();

    public void run() {
        System.out.println("Animal runs");
    }
}

class PetDog extends PetAnimal {
    void walk() {
        System.out.println("Dog walks..");
    }

    void bark() {
        System.out.println("Dog barks..");
    }
}

class Cat extends PetAnimal {
    void walk() {
        System.out.println("Cat walks..");
    }

    void meow() {
        System.out.println("cat meows");
    }
}

class Abstract_Example {
    public static void main(String[] args) {
        PetDog d = new PetDog();

        Cat c = new Cat();

        System.out.println(d);

        System.out.println(c);
    
     
    
        // System.out.println(d.equals(c));
    
     
    
        // System.out.println(d.hashCode());
    
        // System.out.println(c.hashCode());
    
     
    
        // System.out.println(d.toString());
    
        // System.out.println(c.toString());
        Animal a=new Dog();
        System.out.println(a);
        System.out.println(d.equals(c));
        System.out.println(d.equals(a));

        // d.run();
        // c.run();
        // d.walk();
        // d.bark();
        // c.walk();
        // c.meow();
    }
}