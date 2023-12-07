import java.util.Random;
public class otp {

     public static char[] generateotp(int length)
        {
            String num="1234567890";

            Random obj=new Random();

            char [] otp=new char[length];

            for(int i=0;i<length;i++)
            {
                otp[i]=num.charAt(obj.nextInt(num.length()));
            }
            return otp;
            
        }
    
    public static void main(String[] args) {
        System.out.println(generateotp(6));
    }
}
