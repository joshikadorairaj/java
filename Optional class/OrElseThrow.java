import java.util.Optional;

public class OrElseThrow {
    public static void main(String[] args) {
        {
            Optional<String> name = Optional.of("Joshika");
            Optional<Integer> rollno = Optional.ofNullable(42);
            Optional<Object> register = Optional.empty();

            System.out.println(name.orElseThrow());
            System.out.println(rollno.orElseThrow());
            System.out.println(register.orElseThrow());
        }
    }
}
