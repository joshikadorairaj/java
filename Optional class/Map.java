import java.util.Optional;

public class Map {
    public static void main(String[] args) {
        Optional<String> b = Optional.of("Joshika");

        System.out.println(b.map(String::toUpperCase));

        // Optional<Optional<String>> name = Optional.of(Optional.of("Joshika"));
        // System.out.println("Optional.flatMap: " + name.flatMap(x -> x.map(String::toUpperCase)));

    }
}
