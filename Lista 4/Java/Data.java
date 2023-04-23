public class Data{
    private int dia;
    private int mes;
    private int ano;

    // Construtor
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Verificar data
    private boolean verificarData(int dia, int mes, int ano){
        if (mes < 1 || mes > 12)
            return false;
        
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (dia < 1 || dia > diasPorMes[mes - 1]){
            if (mes == 2 && dia == 29 && ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))
                return true;
            else
                return false;
        }
        
        return true;
    }

    // Imprime data
    public void imprimirData(){
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }
    
    // Imprime data extenso
    public void imprimirDataExtenso(){
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        System.out.printf("%02d de %s de %04d\n", dia, meses[mes], ano);
    }

    // Getters
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }

    // Setters
    public void setDia(int dia){
        if (verificarData(dia, mes, ano))
            this.dia = dia;
    }

    public void setMes(int mes){
        if (verificarData(dia, mes, ano))
            this.mes = mes;
    }
    
    public void setAno(int ano){
        if (verificarData(dia, mes, ano))
            this.ano = ano;
    }

    public static void main(String[] args){
        Data data = new Data(1, 5, 2023);
        data.imprimirData();
        data.imprimirDataExtenso();

        data.setAno(2000);
        data.setMes(2);
        data.setDia(29);

        System.out.printf("%d, %d, %d", data.getDia(), data.getMes(), data.getAno());
    }
}