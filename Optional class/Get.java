import java.util.Optional;

public class Get {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Joshika");
        Optional<Object> register = Optional.empty();

        String var=name.get();
        System.out.println(var);
        System.out.println(register.get());
        
    }
}
