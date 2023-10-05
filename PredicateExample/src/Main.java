import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    // Predicate eh normalmente utilizada pra filtrar listas
    public static void main(String[] args) throws Exception {
        List<String> linguagens = Arrays.asList("kotlin", "Java", "javascript", "python", "ruby");

        // escrevendo da forma mais longa
        System.out.println("Forma 1");
        Predicate<String> maisDe5caracteres = palavra -> palavra.length() > 5;
        linguagens.stream().filter(maisDe5caracteres).forEach(System.out::println);

        // forma curta
        System.out.println("\nForma 2");
        linguagens.stream().filter(palavra -> palavra.length() > 5).forEach(System.out::println);

        // o metodo filter por vezes pode ser utilizar para melhorar o consumer
        // como por exemplo o codigo de exemplo deste repositorio de consumer pode ser reescrito como
        // numeros.stream().filter(numeros -> numeros % 2 == 0).forEach(System.out::println);
    }
}
