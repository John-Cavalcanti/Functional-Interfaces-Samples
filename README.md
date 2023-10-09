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
