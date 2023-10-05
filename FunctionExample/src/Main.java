import java.util.Arrays;
import java.util.List;
//import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // for mais limpa e simples de escrever um uma function
        List<Integer> numerosDobrados = numeros.stream().map(n -> n * 2).toList();
        
        // forma mais longa e explicita de escrever abaixo
        
        // Function<Integer, Integer> dobraNumeros = numero -> numero * 2;
        // List<Integer> numerosDobrados = numeros.stream().map(dobraNumeros).toList();

        numerosDobrados.forEach(System.out::println);
    }
}
