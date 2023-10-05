import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    /**
     * Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado.
     * É utilizada principalmente para realizar ações, ou efeitos colaterais nos elementos do Stream sem modificar, ou
     * retornar um valor.
     */

     // tambem deixa o cdigo mais limpo do que se fosse escrito a unha a iteracao por exemplo
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<Integer>();

        for (int x = 1; x <= 10 ; x++) numeros.add(x); // adicionando 10 numeros na lista

        // implementacao de um consumer para imprimir pares mas conseguimos deixar mais exuto
        Consumer<Integer> imprimePares = numero -> imprimePar(numero);
        numeros.stream().forEach(imprimePares);

        // forma mais enxuta possivel de fazer uma iteracao sobre uma lista
        // o metodo forEach recebe um consumer que nesse caso eh um metodo lambda com n como argumento
        // n recebera cada numero da lista numeros e ira executar o metodo imprimeImpar com n como argumento
        // dessa forma pudemos reduzir uma grande quantidade de linhas
        // nao ha nem nessecidade de declarar o consumer explicitamente
        numeros.forEach(n -> imprimeImpar(n));
        
    }

    public static void imprimePar(int number)
    {
        if(number % 2 == 0) System.out.println(number);
    }

    public static void imprimeImpar(int number)
    {
        if(number % 2 != 0) System.out.println(number);
    }
}
