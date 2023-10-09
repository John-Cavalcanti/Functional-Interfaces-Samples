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

        // gerando uma nova lista de saudacoes para usar no supplier
        List<String> listaSaudacoes1 = Arrays.asList("Bom dia", "Good Morning", "Hola, como estas");
        // lambda function abaixo         vvvvvv
        Supplier<List<String>> saudacoes = () -> listaSaudacoes1;
        // atribuindo a lista de saudacoes a nova lista atraves do supplier
        List<String> listaSaudacoes2 = saudacoes.get();

        // Imprimir as saudações geradas
        listaSaudacoes.forEach(System.out::println);

        System.out.println("\n");

        // imprimindo a segunda lista de saudacoes
        listaSaudacoes2.forEach(System.out::println);
    }
}
