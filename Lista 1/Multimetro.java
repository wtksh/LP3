import java.lang.Math;
import java.util.Scanner;

public class Multimetro{
    // Numero de amostras
    static final int NUM_AMOSTRAS = 10;

    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            // Entrada de dados por teclado
            // double[] volts = new double[NUM_AMOSTRAS];
            // for(int i=0; i<NUM_AMOSTRAS; i++){
            //     System.out.print("Amostra " + (i+1) + ": ");
            //     volts[i] = scanner.nextDouble();
            // }
            double[] volts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            // Amostra de dados
            System.out.print("\nAmosta de Volts: ");
            for(double num : volts)
                System.out.print(num + ", ");

            // Cálculo da media
            double media = calcularMedia(volts);
            System.out.println("\nMedia: " + media);
            
            // Cálculo do desvio padrão
            double desvioPadrao = calcularDesvioPadrao(volts, media);
            System.out.println("Desvio Padrão: " + desvioPadrao);
            
            // Situação do multímetro
            System.out.println("Situação: " + ((desvioPadrao > media*0.1) ? "Multímetro com problema." : "Multímetro OK."));
        }
    }

    public static double calcularMedia(double[] amostras){
        double soma = 0;
        for(double amostra : amostras)
            soma += amostra;
        return soma/NUM_AMOSTRAS;
    }

    public static double calcularDesvioPadrao(double[] amostras, double media){
        double soma = 0;
        for(double amostra : amostras)
            soma += Math.pow(amostra - media, 2);
        return Math.sqrt(soma/NUM_AMOSTRAS);
    }
}   