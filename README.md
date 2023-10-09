# Functional-Interfaces-Samples
Aplicação de Stream APIs e Functional Interfaces em Java. Apenas alguns exercícios de fixação simples.

# Resumos Geral e especificos

## Geral

Basicamente Functional interfaces funcionam como métodos Lambda, tal tipo de implementação de método serve para todas as functional interfaces.

### Consumer

A functional interface consumer funciona como um metodo void, onde pode receber argumentos mas não retorna nada.
Apenas excuta suas linhas de código <br>
Exemplo :

```Java
List<Integer> numeros = new ArrayList<Integer>();

for (int x = 1; x <= 10 ; x++) numeros.add(x); // adicionando 10 numeros na lista

// implementacao de um consumer para imprimir pares mas conseguimos deixar mais exuto
Consumer<Integer> imprimePares = numero -> imprimePar(numero);
numeros.stream().forEach(imprimePares);
```

Entretanto as duas últimas linhas de código acima podem ser resumidas em apenas uma que faz todo o trabalho de declarar
o consumer e executar o método imprimePares com o forEach:

```Java
numeros.forEach(n -> imprimeImpar(n));
```

### Supplier 

A Supplier não recebe nenhum argumento e normalmente retorna algum valor esperado, fornecendo alguma informação ou informações para algum atributo na class, daí que vem seu nome supplier que do inglês traduzido é fornecedor

Exemplo : 

```Java
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
```

### Function

Uma Function recebe um argumento e retorna um argumento de um tipo especificado, ela é utilizada para executar algum tipo de alteração no código ou funcionalidade específica.

Exemplo abaixo mostra uma function dobrando os números de dentro de uma List :

```Java
List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

// for mais limpa e simples de escrever um uma function
List<Integer> numerosDobrados = numeros.stream().map(n -> n * 2).toList();
        
// forma mais longa e explicita de escrever abaixo
        
// Function<Integer, Integer> dobraNumeros = numero -> numero * 2;
// List<Integer> numerosDobrados = numeros.stream().map(dobraNumeros).toList();

numerosDobrados.forEach(System.out::println);
```

### Predicate

Predicate normalmente é utilizada para tratar listas de dados, como no exemplo abaixo temos duas formar de filtrar uma listas e alterá-la para imprimir apenas palavras com mais de 5 caracteres :

```Java
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
```

### Binary Operator

E por último mas não menos importante temos o operador binário que sempre recebe dois valores para realizar uma operação entre os mesmos e normalmente os valores são do mesmo tipo, no exemplo abaixo mostra como somar dois valores.

``` Java
// neste exemplo farei apenas das formas reduzidas
        List<Integer> numeros  = Arrays.asList(1,2,3,4,5);

        int resultado = numeros.stream().reduce(0, Integer::sum);
        // ou numeros.stream().reduce(0, (num1, num2) -> num1 + num2)

        System.out.println(resultado);
```
