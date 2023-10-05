import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    /**
     *  Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.
     *  É comumente usada para criar ou fornecer novos objetos de um determinado tipo.
     */
    public static void main(String[] args) throws Exception {
        Supplier<String> saudacao = () -> "Bom dia";

        List<String> listaSaudacoes = Stream.generate(saudacao)
        .limit(5)
        .toList();


        List<String> listaSaudacoes1 = Arrays.asList("Bom dia", "Good Morning", "Hola, como estas");
        // lambda function abaixo         vvvvvv
        Supplier<List<String>> saudacoes = () -> listaSaudacoes1;
        List<String> listaSaudacoes2 = saudacoes.get();

        // Imprimir as saudações geradas
        listaSaudacoes.forEach(System.out::println);

        System.out.println("\n");

        listaSaudacoes2.forEach(System.out::println);
    }
}
