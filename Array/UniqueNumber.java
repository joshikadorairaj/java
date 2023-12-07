import java.util.Arrays;

public class UniqueNumber {
    public static void main(String[] args) {
        int number[]={10,20,10,30};
        for(int i=0;i<number.length;i++)
        {
            for(int j=i+1;j<number.length;j++)
            {
                if(number[i]==number[j])
                {
                    number[j]=0;
                }
            }
        }
        for(int i=0;i<number.length;i++)
        {
                if(number[i]!=0)
                {
                     System.out.println(number[i]);
                }
        }
        
    }
}
