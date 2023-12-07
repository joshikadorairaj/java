public class Book {
    int id;

    String name ;

 

    Book(int id ,String name)

    {

     this.name = name;

     this.id = id;

    }

   
//we are passing object as a parameter, but exactly we have to pass class name for comparison it will take a parent object 
    public boolean equals(Object b2)

   {

      if(this == b2)

            return true;

        if(b2 == null || b2.getClass()!= this.getClass())

            return false;

         

        Book book = (Book) b2; //typecasting(downcasting from object to class)

         

        return (book.name == this.name && book.id == this.id);

   }

   public int hashCode()

   {

    return this.id;

   }
}
