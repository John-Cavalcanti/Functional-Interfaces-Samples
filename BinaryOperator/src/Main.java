import java.util.Arrays;
import java.util.List;

public class Main {

    // O binary operator realiza operacoes em pares e retorna o valor equivalente daquela operacao
    public static void main(String[] args) throws Exception {
        // neste exemplo farei apenas das formas reduzidas
        List<Integer> numeros  = Arrays.asList(1,2,3,4,5);

        int resultado = numeros.stream().reduce(0, Integer::sum);
        // ou numeros.stream().reduce(0, (num1, num2) -> num1 + num2)

        System.out.println(resultado);
        
    }
}
