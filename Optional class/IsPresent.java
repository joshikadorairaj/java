import java.util.Optional;

public class IsPresent {
    public static void main(String[] args) {
       // Optional<String> name = Optional.of("Joshika");
        Optional<Object> name = Optional.empty();

        if (name.isPresent()) {
            System.out.println("Value present");
        } else {
            System.out.println("Value not present");
        }
    }
}
