import java.lang.Math;
import java.util.Scanner;

public class Multimetro{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Amostra de dados
        //double[] volts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] volts = new double[10];

        // Quantidade de dados da amostra
        final int numElements = volts.length;

        // Entrada de dados por teclado
        for(int i=0; i<numElements; i++){
            System.out.print("Amostra " + (i+1) + ": ");
            volts[i] = scanner.nextDouble();
        }
        System.out.print("\nAmosta de Volts: ");
        for(double num : volts)
            System.out.print(num + ", ");

        // Cálculo de média
        double media = 0;
        for(double num : volts)
            media += num;
        media /= numElements;
        System.out.println("\nMedia: " + media);
        
        // Cálculo do desvio padrão
        double dp = 0;
        for(double num : volts)
            dp += (num - media) * (num - media);
        dp = Math.sqrt(dp/numElements);
        System.out.println("Desvio Padrão: " + dp);
        
        // Situação do multímetro
        System.out.println((dp > media*0.1) ? "Multímetro com problemas." : "Multímetro OK.");
    }    
}