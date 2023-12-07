public class objcomparison
{
    public static void main(String[] args)
    {
        Book b1 = new Book(2 , "harrypotter");
        // Book b2 = new Book(2 , "harrypotter");
        Book b2=null;
        //Student s=new Student(2,"Harrypotter");

        if(b1.hashCode() == b2.hashCode())
        {
            if(b1.equals(b2))
                System.out.println("Both Objects are equal. ");
            else
                System.out.println("Both Objects are not equal. ");
        }
        else
        System.out.println("Both Objects are not equal. ");
    }
}

   

