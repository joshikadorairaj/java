import java.util.Optional;


public class Filter {
    public static void main(String[] args) {
         
        Optional<Integer> name = Optional.of(100);
        System.out.println(name.filter(s -> s > 150));

        // Optional<String> name = Optional.ofNullable("swa");
        // System.out.println(name.filter(x->x.isEmpty()));
        //System.out.println(name.filter(x -> x.equalsIgnoreCase("joshika")));

        // Optional<Object> name = Optional.empty();
        // System.out.println(name.filter(x->x.equals("")));

    }
}
