import java.util.Optional;

public class OrElse {
    public static void main(String[] args) {
        Optional<Object> name = Optional.empty();
        Optional<String> b = Optional.of("Joshika");

        // System.out.println(name.orElse("empty"));
        // System.out.println(b.orElse("empty"));

        System.out.println(name.orElseGet(() -> "Empty"));
        System.out.println(b.orElseGet(() -> "Empty"));

    }
}
