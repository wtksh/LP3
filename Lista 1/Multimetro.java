import java.lang.Math;

public class Multimetro{
    public static void main(String[] args){
        // Amostra de dados
        double[] volts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Quantidade de dados da amostra
        final int numElements = volts.length;

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
        
        // Verificação da situação do multímetro
        System.out.println((dp > media*0.1) ? "Multimetro com problemas." : "Multimetro OK.");
    }    
}