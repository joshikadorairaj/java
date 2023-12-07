import java.util.Scanner;

public class UserTest {



    public static void addUser()
    {
        users[0]=new User(01,"Joshika","abc@123","joshika01@gmail.com","Joshika","D","Athlete");
        users[1]=new User(02,"Swathi","abc@123","swathi02@gmail.com","Swathi","N","Athlete");
        users[2]=new User(03,"Rashmika","abc@123","rashmika03@gmail.com","Rashmika","D","Coach");
        users[3]=new User(04,"Indhu","abc@123","indhu04@gmail.com","Indhu","A","Coach");
        users[4]=new User(05,"Gobinath","abc@123","gobinath05@gmail.com","Gobianth","D","Administrator");
    }

    public static void display()
    {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
    }

    public static void update()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the index to be updated: ");
        int userindex=sc.nextInt();
        users[userindex]=new User(06,"Achu","abc@123","achu06@gmail.com","Achu","A","Coach");
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
    }

    public static void delete()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the index to be deleted: ");
        int deleteindex=sc.nextInt();
        users[deleteindex]=null;
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
    }

    static User users[]=new User[5];
    public static void main(String[] args) {
        addUser();
        display();
        update();
        delete();

    }

    

}
