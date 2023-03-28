public class Operadores {
    public static void main(String[] args){

        /* PRECEDÊNCIA
         * Os operadores possuem regras que são aplicadas nas expressões aritméticas do Java, que são as mesmas seguidas em álgebra.
         * Quando dizemos que os operadores são aplicados da esquerda para a direita, estamos nos referindo à sua associatividade.
         * Por exemplo, quando aparecer uma expressão com várias dessas operações, elas serão aplicadas da esquerda para a direita.
         * Operadores de multiplicação, divisão e módulo são aplicadas primeiro.
         * As operações de adição e subtração são aplicadas em seguida.
         */
         int soma, x = 3, y = 4, z = 5;
         soma = x + y * z;
         System.out.println(soma); // soma = 23
        /*
         * Essa ordem pode ser alterada com o uso de parênteses.
         * Caso uma operação esteja sendo realizada entre parênteses, esta será aplicada primeiro.
         */
        soma = (x + y) * z;
        System.out.println(soma); // soma = 35


        /* OPERADOR TERNARIO
         * O operador ternário é um recurso para tomada de decisões com objetivo similar ao do if/else, mas que é codificado em apenas uma linha.
         * Sintaxe do operador ternário:
         * (expressão booleana) ? código 1 : código 2;
         * Ao avaliar a expressão booleana, caso ela seja verdadeira, o código 1, declarado após o ponto de interrogação (?) será executado;
         * do contrário, o programa irá executar o código 2, declarado após os dois pontos (:).
         */
        int media = 8;
        System.out.println("Aluno " + ((media >= 7) ? "Aprovado!" : "Reprovado!"));
        media = 5;
        System.out.println("Aluno " + ((media >= 7) ? "Aprovado!" : "Reprovado!"));
    }
}
