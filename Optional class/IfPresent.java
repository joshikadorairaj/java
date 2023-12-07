import java.util.Optional;

public class IfPresent {
   public static void main(String[] args) {
       // Optional<Integer> register = Optional.ofNullable(42);
        Optional<Object> register = Optional.empty();

        register.ifPresent(x->System.out.println("Value Present"));
   } 
}
